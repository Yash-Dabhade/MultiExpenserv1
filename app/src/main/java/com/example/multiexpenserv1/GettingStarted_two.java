package com.example.multiexpenserv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.android.material.snackbar.Snackbar;

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
                String mincome,cbalance,eincome;
                mincome=Montly_Income.getText().toString();
                cbalance=Current_Balance.getText().toString();
                eincome=Extra_Income.getText().toString();
                if(!(mincome.isEmpty()||cbalance.isEmpty()||eincome.isEmpty())) {
                    editor.putInt("Monthly_Income",Integer.parseInt(mincome));
                    editor.putInt("Current_Balance",Integer.parseInt(cbalance));
                    editor.putInt("Extra_Income", Integer.parseInt(eincome));
                    editor.putString("FirstTimeInstalled", "Yes");
                    editor.apply();
                    startActivity(new Intent(GettingStarted_two.this, Home.class));
                    finish();
                }
                else {
                    Snackbar snackbar=Snackbar.make(v,"Please fill all the details !",Snackbar.LENGTH_LONG);
                    snackbar.show();
                }
            }
        });

    }
}