package com.example.exotica;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;
import com.google.android.youtube.player.YouTubePlayerView;

public class About extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    public static final String DEV_KEY = "AIzaSyATkf15Tw5XmFKjWlpCwG6fxzBc8oP0_4Y";
    private static final String VID_ID= "3TeC6Oiyt54";
    private static final int REC_DIA_REQ = 1;

    YouTubePlayerFragment youTubePlayerFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        YouTubePlayerView youTubePlayerView = findViewById(R.id.websiteyoutube);
        youTubePlayerView.initialize(DEV_KEY,this);


    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {

        if (!b){
            youTubePlayer.cueVideo(VID_ID);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REC_DIA_REQ){
            getYouTubePlayerProvider().initialize(DEV_KEY,this);
        }
    }

    protected YouTubePlayer.Provider getYouTubePlayerProvider(){
        return (YouTubePlayerView)findViewById(R.id.websiteyoutube);
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

        String errorMessage = String.format("There was an error on initializing the youtube player (%1$s)",youTubeInitializationResult.toString());
        Toast.makeText(this,errorMessage,Toast.LENGTH_LONG).show();
    }

}
