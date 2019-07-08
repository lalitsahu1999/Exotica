package com.example.exotica;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class resultsFragment extends Fragment {

    RecyclerView mRecyclerView;
    FirebaseDatabase mFirebaseDatabase;
    DatabaseReference mRef;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_results, container, false);
        mRecyclerView = rootView.findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        mFirebaseDatabase= FirebaseDatabase.getInstance();
        mRef = mFirebaseDatabase.getReference("Result");
        return rootView;
    }
    @Override
    public void onStart() {
        super.onStart();

        FirebaseRecyclerOptions<Model> options = new FirebaseRecyclerOptions.Builder<Model>().setQuery(mRef ,Model.class).build();

        final FirebaseRecyclerAdapter<Model, ViewHolder> firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<Model , ViewHolder>(options){

                    @NonNull
                    @Override
                    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
                        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.results,viewGroup,false);
                        ViewHolder viewHolder = new ViewHolder(view);
                        return viewHolder;
                    }

                    @Override
                    protected void onBindViewHolder(@NonNull final ViewHolder holder, int position, @NonNull Model model) {

                        String id = getRef(position).getKey();
                        mRef.child(id).addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                if(dataSnapshot.hasChild("image")){
                                    String resImg = dataSnapshot.child("image").getValue().toString();
                                    String resTitle = dataSnapshot.child("title").getValue().toString();
                                    String resDesc = dataSnapshot.child("description").getValue().toString();

                                    holder.mTitleView.setText(resTitle);
                                    holder.mDetail.setText(resDesc);
                                    Picasso.get().load(resImg).into(holder.mImage);
                                }
                                else {
                                    String resTitle = dataSnapshot.child("title").getValue().toString();
                                    String resDesc = dataSnapshot.child("description").getValue().toString();

                                    holder.mTitleView.setText(resTitle);
                                    holder.mDetail.setText(resDesc);
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {

                            }
                        });




                    }
                };

        mRecyclerView.setAdapter(firebaseRecyclerAdapter);
        firebaseRecyclerAdapter.startListening();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView mTitleView,mDetail;
        ImageView mImage;

        View mView;

        public ViewHolder(View itemView){
            super(itemView);
            mView = itemView;
            mTitleView = mView.findViewById(R.id.rTitle);
            mDetail = mView.findViewById(R.id.rDescription);
            mImage = mView.findViewById(R.id.rImageView);


        }


    }

}
