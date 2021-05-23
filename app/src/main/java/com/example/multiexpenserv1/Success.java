package com.example.multiexpenserv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

public class Success extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);
        MediaPlayer mediaPlayer=MediaPlayer.create(this,R.raw.success);
        mediaPlayer.start();
        new java. util. Timer(). schedule(
                new java. util. TimerTask() {
                    @Override
                    public void run() {
                        startActivity(new Intent(Success.this,Home.class));
                        finish();
                    }
                },
                3000);
    }
}