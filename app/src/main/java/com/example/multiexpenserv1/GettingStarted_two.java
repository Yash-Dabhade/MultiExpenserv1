package com.example.multiexpenserv1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class GettingStarted_two extends AppCompatActivity {

    private EditText Montly_Income,Current_Balance,Extra_Income;
    private ImageView Finish_Button;

    //Declaring database
    DbHandler db;
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

                //Checking whether data is not null
                if(!(mincome.isEmpty()||cbalance.isEmpty()||eincome.isEmpty())) {
                    editor.putString("FirstTimeInstalled", "Yes");
                    editor.putString("Monthly_Income",mincome);
                    editor.putString("Current_Balance",cbalance);
                    editor.putString("Extra_Income",eincome);
                    editor.apply();
                    //Getting intent
                    Intent intent=getIntent();

                    //Starting home activity
                    startActivity(new Intent(GettingStarted_two.this, Home.class));
                    overridePendingTransition(R.anim.slide_out_left,R.anim.slide_in_right);
                    finish();
                }
                else {
                    //Giving warning to the user to fill all the details
                    Snackbar snackbar=Snackbar.make(v,"Please fill all the details !",Snackbar.LENGTH_LONG);
                    snackbar.show();
                }
            }
        });

    }
}