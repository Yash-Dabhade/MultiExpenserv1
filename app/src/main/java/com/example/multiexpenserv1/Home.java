package com.example.multiexpenserv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class Home extends AppCompatActivity {

    private TextView name,balance;
    private  String fname;
    private String cbalance;
    private ImageView share,newexpense;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        SharedPreferences sharedPreferences=getSharedPreferences("PREFERENCE",MODE_PRIVATE);

        //Accessing the text view by id from backend
        name=findViewById(R.id.Welcome);
        balance=findViewById(R.id.Home_Balance);
        share=findViewById(R.id.share);
        newexpense=findViewById(R.id.newexpense_button);
        //Getting the user data from the sharedPreferences
        fname=sharedPreferences.getString("First_Name","");
        cbalance=sharedPreferences.getString("Current_Balance","");

        // Setting textview on the home screen
        name.setText("Welcome "+fname);
        balance.setText("RS "+cbalance);

        //Share activity
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_SUBJECT, "Download MultiExpenser ");
                intent.putExtra(Intent.EXTRA_TEXT, "Regars of the day , try this amazing app to save your money named as MultiExpenser. Download it from the playStore");
                startActivity(Intent.createChooser(intent, "choose one"));
            }
        });

        //New expense activity
        newexpense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this,new_expense_in.class));
            }
        });

    }
}