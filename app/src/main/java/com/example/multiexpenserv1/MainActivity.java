package com.example.multiexpenserv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Cheking for Onbard process
        SharedPreferences sharedPreferences=getSharedPreferences("PREFERENCE",MODE_PRIVATE);
        String FirstTime=sharedPreferences.getString("FirstTimeInstalled","");

        if(FirstTime.equals("Yes")) {
            startActivity(new Intent(MainActivity.this,Home.class));
        }
        else{
            SharedPreferences.Editor editor=sharedPreferences.edit();
            editor.putString("FirstTimeInstalled","Yes");
            editor.apply();
        }
    }
}