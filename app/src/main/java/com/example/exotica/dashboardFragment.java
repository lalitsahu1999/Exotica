package com.example.exotica;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.cardview.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;

public class dashboardFragment extends Fragment{

    GridLayout mainGrid;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_dashboard, container, false);

        mainGrid = (GridLayout) rootView.findViewById(R.id.mainGrid);
        setSingleEvent(mainGrid);
        return rootView;

    }

    private void setSingleEvent(GridLayout mainGrid){

        for (int i=0;i<mainGrid.getChildCount();i++){
            CardView cardView = (CardView)mainGrid.getChildAt(i);
            final int finali=i;
            cardView.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    if (finali==0){

                        Intent intent = new Intent(v.getContext(),Robotics.class);
                        dashboardFragment.this.startActivity(intent);
                    }
                    else if (finali==1){

                        Intent intent = new Intent(v.getContext(),Education.class);
                        dashboardFragment.this.startActivity(intent);
                    }
                    else if (finali==2){

                        Intent intent = new Intent(v.getContext(),Cultural.class);
                        dashboardFragment.this.startActivity(intent);
                    }
                    else if (finali==3){

                        Intent intent = new Intent(v.getContext(),Sports.class);
                        dashboardFragment.this.startActivity(intent);
                    }
                }
            });
        }

    }
}
