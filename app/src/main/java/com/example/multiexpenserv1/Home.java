package com.example.multiexpenserv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class Home extends AppCompatActivity {

    private TextView name,balance;
    private  String fname;
    private int cbalance;
    SharedPreferences sharedPreferences=getSharedPreferences("PREFERENCE",MODE_PRIVATE);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
         fname=sharedPreferences.getString("First_Name","");
         cbalance=sharedPreferences.getInt("Current_Balance",0);
        name=findViewById(R.id.Welcome);
        balance=findViewById(R.id.Home_Balance);
        name.setText(fname);
        balance.setText(cbalance);
        System.out.println(fname);
        System.out.println(cbalance);
    }
}