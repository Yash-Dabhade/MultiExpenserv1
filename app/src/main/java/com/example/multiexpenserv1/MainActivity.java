package com.example.multiexpenserv1;
// Getting Started  First Activity
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private EditText FirstName,LastName,Email;
    ImageView next_button;
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
        else {
            FirstName = findViewById(R.id.First_Name);
            LastName = findViewById(R.id.Last_Name);
            Email = findViewById(R.id.Email_Address);
            next_button = findViewById(R.id.Next_Button_GS1);
            next_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("FirstName", FirstName.toString());
                    editor.putString("LastName", LastName.toString());
                    editor.putString("Email", Email.toString());
                    editor.apply();
                    startActivity(new Intent(MainActivity.this, GettingStarted_two.class));
                }
            });


        }
    }
}