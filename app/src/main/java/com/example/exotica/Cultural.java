package com.example.exotica;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class Cultural extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        ListView lst;

        String[] eventname={"Antakshari","Dance-A-Thon","Dueto-Voco","Dumb-Charades","NITs Got Talent","Rangoli","Roadies","Step-Up","Voca-idolo"};
        Integer[] imgid={R.drawable.antakshari,R.drawable.dance,R.drawable.dueto,R.drawable.dumb,R.drawable.got,R.drawable.rangoli,R.drawable.roadies,R.drawable.step,R.drawable.vocoid};
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cultural);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        lst= (ListView) findViewById(R.id.listview);


        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent intent = new Intent(Cultural.this, antakshari.class);
                    startActivity(intent);
                }
                if (position == 1) {
                    Intent intent = new Intent(Cultural.this, dance.class);
                    startActivity(intent);
                }
                if (position == 2) {
                    Intent intent = new Intent(Cultural.this, dueto.class);
                    startActivity(intent);
                }
                if (position == 3) {
                    Intent intent = new Intent(Cultural.this,dumb.class);
                    startActivity(intent);
                }
                if (position == 4) {
                    Intent intent = new Intent(Cultural.this, got.class);
                    startActivity(intent);
                }
                if (position == 5) {
                    Intent intent = new Intent(Cultural.this, rangoli.class);
                    startActivity(intent);
                }
                if (position == 6) {
                    Intent intent = new Intent(Cultural.this, roadies.class);
                    startActivity(intent);
                }
                if (position == 7) {
                    Intent intent = new Intent(Cultural.this, step.class);
                    startActivity(intent);
                }
                if (position == 8) {
                    Intent intent = new Intent(Cultural.this, vocoid.class);
                    startActivity(intent);
                }
              }
            });
            customListView customListView=new customListView(this,eventname,imgid);
            lst.setAdapter(customListView);


            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
