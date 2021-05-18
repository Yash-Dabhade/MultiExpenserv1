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

public class New_Goal extends AppCompatActivity {

    private ImageView save,back,myGoals;
    private EditText Title,Amount,Type,Day,Month,Year;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_goal);
        //Getting all the ui elements
        Title=findViewById(R.id.New_Goal_Title);
        Amount=findViewById(R.id.New_Goal_Amount);
        Type=findViewById(R.id.New_Goal_Type);
        Day=findViewById(R.id.New_Goal_Day);
        Month=findViewById(R.id.New_Goal_Month);
        Year=findViewById(R.id.New_Goal_Year);
        save=findViewById(R.id.Save_Btn_New_Goal);
        back=findViewById(R.id.Back_Btn_New_Goal);
        myGoals=findViewById(R.id.New_Goal_My_Goals_Bg);

        // On click listner for back button
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(New_Goal.this,Home.class));
                Toast.makeText(New_Goal.this, "Data Not Saved", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        //Save OnCLickListener
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title,amount,day,month,year,type;
                boolean isBalanceConsistent=true;
                //Storing data from the edit text into the strings
                title= Title.getText().toString();
                amount=Amount.getText().toString();
                type=Type.getText().toString();
                day=Day.getText().toString();
                month=Month.getText().toString();
                year=Year.getText().toString();

                //Checking whether the data fields are filled
                if(!(title.isEmpty()||amount.isEmpty()||day.isEmpty()||month.isEmpty()||year.isEmpty()||type.isEmpty())) {
                    //Creating object of expense and saving the data into it
                    goal obj = new goal(title, amount,type, day, month, year);
                    //Creating database object
                    DataBaseHelper db = new DataBaseHelper(New_Goal.this);
                    boolean isSaved=false;
                    // Calling funtion to add the expense data
                    isSaved = db.AddGoalToDB(obj);
                    db.close();
                    if (isSaved) {
                        startActivity(new Intent(New_Goal.this,Success.class));
                        finish();
                    }
                    else {
                        Snackbar snackbar=Snackbar.make(v,"Please Fill The Detaills Properly !",Snackbar.LENGTH_LONG);
                        snackbar.show();
                    }
                }
                else {
                    //Giving warning to the user to fill all the details
                    Snackbar snackbar=Snackbar.make(v,"Please fill all the details !",Snackbar.LENGTH_LONG);
                    snackbar.show();
                }
            }
        });

        //Setting oncllick listner for my goals
        myGoals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(New_Goal.this,My_Goals.class));
            }
        });
    }
}