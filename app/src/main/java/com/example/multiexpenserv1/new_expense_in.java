package com.example.multiexpenserv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class new_expense_in extends AppCompatActivity {

    private EditText Title,Amount,Day,Month,Year,Description;
    private ImageView save,back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_expense_in);

        //Getting elements by ID
        Title=findViewById(R.id.Title);
        Amount=findViewById(R.id.Amount);
        Day=findViewById(R.id.Day);
        Month=findViewById(R.id.Month);
        Year=findViewById(R.id.Year);
        Description=findViewById(R.id.Description);
        save=findViewById(R.id.save_btn);
        back=findViewById(R.id.back_btn);

        // On click listner for back button
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(new_expense_in.this,Home.class));
                Toast.makeText(new_expense_in.this, "Data Not Saved", Toast.LENGTH_SHORT).show();
            }
        });

        // On click listner for the save button
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title,amount,day,month,year,description;

                //Storing data from the edit text into the strings
                title= Title.getText().toString();
                amount=Amount.getText().toString();
                day=Day.getText().toString();
                month=Month.getText().toString();
                year=Year.getText().toString();
                description=Description.getText().toString();

                //Checking whether the data fields are filled
                if(!(title.isEmpty()||amount.isEmpty()||day.isEmpty()||month.isEmpty()||year.isEmpty()||description.isEmpty())) {
                    //Creating object of expense and saving the data into it
                    expense obj = new expense(title, amount, day, month, year, description);
                    //Creating database object
                    DataBaseHelper db = new DataBaseHelper(new_expense_in.this);
                    boolean isSaved=false;
                        // Calling funtion to add the expense data
                        isSaved = db.addExpenseToDB(obj);
                        db.close();
                    if (isSaved) {
                        Toast.makeText(new_expense_in.this, "Data Saved successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(new_expense_in.this,Success.class));
                        finish();
                    }
                    else {
                        Snackbar snackbar=Snackbar.make(v,"Title already saved, choose different title !",Snackbar.LENGTH_LONG);
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
    }
}