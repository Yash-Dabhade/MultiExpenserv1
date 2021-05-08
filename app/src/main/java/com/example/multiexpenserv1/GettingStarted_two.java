package com.example.multiexpenserv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class GettingStarted_two extends AppCompatActivity {

    private EditText Montly_Income,Current_Balance,Extra_Income;
    private ImageView Finish_Button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getting_started_two);
        Montly_Income=findViewById(R.id.Monthly_Income);
        Current_Balance=findViewById(R.id.Current_Balance);
        Extra_Income=findViewById(R.id.Extra_Income);
        Finish_Button=findViewById(R.id.Finish_Button);
        SharedPreferences sharedPreferences=getSharedPreferences("PREFERENCE",MODE_PRIVATE);
        Finish_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString("Monthly_Income",Montly_Income.toString());
                editor.putString("Current_Balance",Current_Balance.toString());
                editor.putString("Extra_Income",Extra_Income.toString());
                editor.putString("FirstTimeInstalled","Yes");
                editor.apply();
                startActivity(new Intent(GettingStarted_two.this,Home.class));
                finish();
            }
        });

    }
}