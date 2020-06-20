package com.example.gridlayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import java.util.ArrayList;

public class ActivityYoutube extends YouTubeBaseActivity {

    private static final String TAG = "ActivityYoutube";



    YouTubePlayerView mYoutubePlayerView;
    Button playbtn;
    YouTubePlayer.OnInitializedListener mOnInitializedListener;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube);
        Log.d(TAG, "onCreate: Starting.");

        playbtn = (Button) findViewById(R.id.playbtn);
        mYoutubePlayerView = (YouTubePlayerView) findViewById(R.id.youtube);

        mOnInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                Log.d(TAG, "onClick: Done Initializing");
                youTubePlayer.loadVideo("1APwq1df6Mw");

            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Log.d(TAG, "onClick: Failed to iniitializa");

            }
        };
        playbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Initializing Youtube Player");
                mYoutubePlayerView.initialize(youtubeConfig.getApiKey(),mOnInitializedListener);


            }
        });



    }
}
