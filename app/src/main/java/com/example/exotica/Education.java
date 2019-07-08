package com.example.exotica;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class Education extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        ListView lst;

        final String[] eventname={"Essay-Writing","Group-Debate","JAM","Spell-Bee","Turn-Coat","Mind-Portal"};
        final Integer[] imgid={R.drawable.writting,R.drawable.group,R.drawable.just,R.drawable.spell,R.drawable.turn,R.drawable.mind};






        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        lst= (ListView) findViewById(R.id.listview);


        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    Intent intent= new Intent(Education.this,writting.class);
                    startActivity(intent);
                }
                if(position==1){
                    Intent intent= new Intent(Education.this,group.class);
                    startActivity(intent);
                }
                if(position==2){
                    Intent intent= new Intent(Education.this,just.class);
                    startActivity(intent);
                }
                if(position==3){
                    Intent intent= new Intent(Education.this,spell.class);
                    startActivity(intent);
                }
                if(position==4){
                    Intent intent= new Intent(Education.this,turn.class);
                    startActivity(intent);
                }
                if(position==5){
                    Intent intent= new Intent(Education.this,mind.class);
                    startActivity(intent);
                }
            }
        });


        customListView customListView=new customListView(this,eventname,imgid);
        lst.setAdapter(customListView);




        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}