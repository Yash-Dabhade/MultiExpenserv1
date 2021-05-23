package com.example.multiexpenserv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

public class Congratulations extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_congratulations);
        MediaPlayer mediaPlayer=MediaPlayer.create(this,R.raw.goalachieved);
        mediaPlayer.start();
        new java. util. Timer(). schedule(
                new java. util. TimerTask() {
                    @Override
                    public void run() {
                        startActivity(new Intent(Congratulations.this,My_Goals.class));
                        finish();
                    }
                },
                3000);
    }
}