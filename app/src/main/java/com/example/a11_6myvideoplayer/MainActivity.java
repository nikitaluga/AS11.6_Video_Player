package com.example.a11_6myvideoplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    VideoView videoView;
    int intPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        videoView = findViewById(R.id.videoView);
        String pathToVideoFile = "android.resource://com.example.a11_6myvideoplayer/" + R.raw.video;
        videoView.setVideoPath(pathToVideoFile);

        if (savedInstanceState != null){
            intPosition = savedInstanceState.getInt("intPosition");
            videoView.seekTo(intPosition);
            videoView.start();
        } else {
            videoView.start();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        intPosition = videoView.getCurrentPosition();
        outState.putInt("intPosition",intPosition);
    }
}
