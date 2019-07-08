package com.example.exotica;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class GalleryViewholder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public  TextView t1;
    public ImageView i1;



    public GalleryViewholder(@NonNull View itemView) {
        super(itemView);

        t1 = itemView.findViewById(R.id.gDescription);
        i1 = itemView.findViewById(R.id.gImageView);
        itemView.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {



    }
}
