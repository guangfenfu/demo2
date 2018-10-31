package com.example.playvideo;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;
import android.media.MediaPlayer;

public class MainActivity extends AppCompatActivity {
VideoView videoView;
Button btn_start,btn_end;
MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        videoView = findViewById(R.id.videoView);
        initView();
    }
    private void initView(){
        videoView=(VideoView)findViewById(R.id.videoView);
        btn_start=(Button)findViewById(R.id.btn_start);
        btn_end=(Button)findViewById(R.id.btn_end);

        // button Start click
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                init();
            }
        });

        // button End click
        btn_end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                videoView.stopPlayback();
            }
        });
    }

    // Play Video
    private void init(){
        videoView=(VideoView) findViewById(R.id.videoView);
        // add MediaController function
        mediaController=new MediaController(this);
        String uri="android.resource://"+getPackageName()+"/"+R.raw.sailing;
        videoView.setVideoURI(Uri.parse(uri));
        videoView.setMediaController(mediaController);
        mediaController.setMediaPlayer(videoView);
        videoView.requestFocus();
        videoView.start();
    }
}
