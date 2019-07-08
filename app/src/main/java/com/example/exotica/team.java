package com.example.exotica;

import android.os.Bundle;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.widget.ProgressBar;

public class team extends AppCompatActivity {

    private ProgressBar progressBar;
    private int progressStatus = 0;

    private String[] imageUrls = new String[]{
            "https://firebasestorage.googleapis.com/v0/b/exotica-f82fd.appspot.com/o/IMG-20190206-WA0016.jpg?alt=media&token=4062880f-6a3d-43b1-a093-b7dbde8e0881",
            "https://firebasestorage.googleapis.com/v0/b/exotica-f82fd.appspot.com/o/IMG-20190206-WA0010.jpg?alt=media&token=35d39aac-0475-4671-8b53-1bd2928f3e2e",
            "https://firebasestorage.googleapis.com/v0/b/exotica-f82fd.appspot.com/o/IMG-20190206-WA0006.jpg?alt=media&token=6a62055e-bd36-4c54-ab4f-58c1ca6962b3"

    };




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ViewPager viewPager = findViewById(R.id.view_pager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(this,imageUrls);
        viewPager.setAdapter(adapter);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
