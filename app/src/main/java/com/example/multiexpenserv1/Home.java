package com.example.multiexpenserv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class Home extends AppCompatActivity {

    private TextView name,balance;
    private  String fname;
    private String cbalance;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        SharedPreferences sharedPreferences=getSharedPreferences("PREFERENCE",MODE_PRIVATE);

        //Accessing the text view by id from backend
        name=findViewById(R.id.Welcome);
        balance=findViewById(R.id.Home_Balance);

        //Getting the user data from the sharedPreferences
        fname=sharedPreferences.getString("First_Name","");
        cbalance=sharedPreferences.getString("Current_Balance","");

        // Setting textview on the home screen
        name.setText("Welcome "+fname);
        balance.setText("RS "+cbalance);
    }
}