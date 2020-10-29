package com.example.motocoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class info_act extends AppCompatActivity {

    private VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_act);

        videoView = (VideoView)findViewById(R.id.vidView);


        String ruta = "android.resource://" + getPackageName() + "/" + R.raw.promo;

        Uri uri = Uri.parse(ruta);

        videoView.setVideoURI(uri);

        MediaController media = new MediaController(this);
        videoView.setMediaController(media);
    }
}