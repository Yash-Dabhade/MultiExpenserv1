package com.example.multiexpenserv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class SplashScreenv1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screenv1);
        new java. util. Timer(). schedule(
                new java. util. TimerTask() {
                    @Override
                    public void run() {
                    startActivity(new Intent(SplashScreenv1.this,MainActivity.class));
                    finish();
                    }
                },
                1500);
    }
}