package com.example.exotica;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.felipecsl.gifimageview.library.GifImageView;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;

public class SplashScreen extends AppCompatActivity {

    GifImageView gifImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        gifImageView = findViewById(R.id.gifImageView);

                try{
                    InputStream inputStream = getAssets().open("exotica.gif");
                    byte[] bytes = IOUtils.toByteArray(inputStream);
                    gifImageView.setBytes(bytes);
                    gifImageView.startAnimation();

                } catch (IOException e) {

                }

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        SplashScreen.this.startActivity(new Intent(SplashScreen.this,MainActivity.class));
                        SplashScreen.this.finish();
                    }
                },4000);
    }
}



