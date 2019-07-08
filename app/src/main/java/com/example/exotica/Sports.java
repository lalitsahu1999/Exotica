package com.example.exotica;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Sports extends AppCompatActivity {

    ListView lst;
    String[] eventname={"Carrom","Chess","Cricket","Kabaddi","Counter-Strike","PUBG","NFS-Most Wanted","Kho-Kho","Table-Tennis","Tug-of-War","Volleyball","Musical-Chair"};
    Integer[] imgid={R.drawable.carrom,R.drawable.chess,R.drawable.cricket,R.drawable.kabaddi,R.drawable.counterstrike,R.drawable.pubg,R.drawable.nfs,R.drawable.khokho,R.drawable.tabletennis,R.drawable.tugofwar,R.drawable.volleyball,R.drawable.musical};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sports);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        lst= (ListView) findViewById(R.id.listview);
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,eventname);
        lst.setAdapter(adapter);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    Intent intent= new Intent(Sports.this,carrom.class);
                    startActivity(intent);
                }
                if(position==1){
                    Intent intent= new Intent(Sports.this,chess.class);
                    startActivity(intent);
                }
                if(position==2){
                    Intent intent= new Intent(Sports.this,cricket.class);
                    startActivity(intent);
                }
                if(position==3){
                    Intent intent= new Intent(Sports.this,kabaddi.class);
                    startActivity(intent);
                }
                if(position==4){
                    Intent intent= new Intent(Sports.this,counterStrike.class);
                    startActivity(intent);
                }
                if(position==5){
                    Intent intent= new Intent(Sports.this,pubg.class);
                    startActivity(intent);
                }
                if(position==6){
                    Intent intent= new Intent(Sports.this,nfs.class);
                    startActivity(intent);
                }
                if(position==7){
                    Intent intent= new Intent(Sports.this,khokho.class);
                    startActivity(intent);
                }
                if(position==8){
                    Intent intent= new Intent(Sports.this,tabletennis.class);
                    startActivity(intent);
                }
                if(position==9){
                    Intent intent= new Intent(Sports.this,tugofwar.class);
                    startActivity(intent);
                }
                if(position==10){
                    Intent intent= new Intent(Sports.this,volleyball.class);
                    startActivity(intent);
                }
                if(position==11){
                    Intent intent= new Intent(Sports.this,musical.class);
                    startActivity(intent);
                }

            }
        });
        customListView customListView=new customListView(this,eventname,imgid);
        lst.setAdapter(customListView);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
