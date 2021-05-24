package com.example.multiexpenserv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class Gifts_in extends AppCompatActivity {

    private TextView Coins_collected;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gifts_in);
        SharedPreferences sharedPreferences=getSharedPreferences("PREFERENCE",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        String Current_coins=sharedPreferences.getString("Coins","100");
        Coins_collected=findViewById(R.id.Coins_Collected_Gifts_in);
        //Setting Coins
        Coins_collected.setText(Current_coins);
        //Function to increase the coins every 24 hours
        Timer timer = new Timer ();
        TimerTask t = new TimerTask () {
            @Override
            public void run () {
                int coins= Integer.parseInt(Current_coins);
                coins+=100;
                editor.putString("Coins",String.valueOf(coins));
                editor.apply();
            }
        };timer.schedule (t, 0L, 1000*60*60*24);
    }
}