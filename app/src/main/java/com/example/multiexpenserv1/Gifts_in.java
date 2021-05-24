package com.example.multiexpenserv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;

public class Gifts_in extends AppCompatActivity {

    private TextView Coins_collected;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gifts_in);
        //Getting current Day
        Calendar calendar=Calendar.getInstance(TimeZone.getDefault());
        Date date=calendar.getTime();
        SharedPreferences sharedPreferences=getSharedPreferences("PREFERENCE",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        int Previous_Day=sharedPreferences.getInt("Day",0);
        int Current_Day=calendar.get(Calendar.DATE);
        String Current_coins=sharedPreferences.getString("Coins","100");
        //Function to increase the coins every 24 hours
        if(Current_Day!=Previous_Day) {
            int coins = Integer.parseInt(Current_coins);
            coins += 100;
            editor.putString("Coins", String.valueOf(coins));
            editor.putInt("Day",Current_Day);
            editor.apply();
        }
        Current_coins=sharedPreferences.getString("Coins","100");
        Coins_collected=findViewById(R.id.Coins_Collected_Gifts_in);
        //Setting Coins
        Coins_collected.setText(Current_coins);
    }
}