package com.example.multiexpenserv1;

import androidx.appcompat.app.AppCompatActivity;

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
                    editor.apply();
                    //Getting intent
                    Intent intent=getIntent();
                    // Creating A user object
                    user u=new user();
                    //Setting Data
                    u.setFirst_name(intent.getStringExtra("MULTIEXPENSER_FIRST_NAME"));
                    u.setLast_name(intent.getStringExtra("MULTIEXPENSER_LAST_NAME"));
                    u.setEmail(intent.getStringExtra("MULTIEXPENSER_EMAIL"));
                    u.setMonthly_income(Long.parseLong(mincome));
                    u.setCurrent_balance(Long.parseLong(cbalance));
                    u.setExtra_income(Long.parseLong(eincome));
                    //Starting home activity
                    startActivity(new Intent(GettingStarted_two.this, Home.class));
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