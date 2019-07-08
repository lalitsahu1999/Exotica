package com.example.exotica;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridLayout;
import android.widget.GridView;

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
