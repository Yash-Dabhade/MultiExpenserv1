package com.example.multiexpenserv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class new_expense_in extends AppCompatActivity {

    private EditText Title,Amount,Day,Month,Year,Description;
    private ImageView save,back,show_expenses;
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
        show_expenses=findViewById(R.id.show_expenses_btn);
        save=findViewById(R.id.save_btn);
        back=findViewById(R.id.back_btn);

        //Show Expenses on click listnere
        show_expenses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(new_expense_in.this,Show_Expenses.class));
            }
        });

        // On click listner for back button
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(new_expense_in.this,Home.class));
                finish();
            }
        });

        // On click listner for the save button
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title,amount,day,month,year,description;
                boolean isBalanceConsistent=true;
                //Storing data from the edit text into the strings
                title= Title.getText().toString();
                amount=Amount.getText().toString();
                day=Day.getText().toString();
                month=Month.getText().toString();
                year=Year.getText().toString();
                description=Description.getText().toString();

                //Checking whether the data fields are filled
                if(!(title.isEmpty()||amount.isEmpty()||day.isEmpty()||month.isEmpty()||year.isEmpty()||description.isEmpty())) {

                    //Declaring varibales
                    expense obj;
                    DataBaseHelper db;
                    boolean isSaved=false;

                    // Adding Shared Preferences
                    SharedPreferences sharedPreferences=getSharedPreferences("PREFERENCE",MODE_PRIVATE);
                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    String Orignal_Balance=sharedPreferences.getString("Current_Balance","");

                    //Subtracting Balance
                    int Balance_Integer = Integer.parseInt(Orignal_Balance);
                    String Amount_String = Amount.getText().toString();
                    if (Amount_String.isEmpty()) {
                        Snackbar snackbar = Snackbar.make(v, "Please Fill the amount details !!!", Snackbar.LENGTH_LONG);
                        snackbar.show();
                    }
                    else {
                        int amount_t = Integer.parseInt(Amount_String);
                        if(Balance_Integer>=amount_t) {
                            Balance_Integer -= amount_t;
                            editor.putString("Current_Balance", Integer.toString(Balance_Integer));
                            //Creating object of expense and saving the data into it
                             obj = new expense(title, amount, day, month, year, description);
                            //Creating database object
                             db = new DataBaseHelper(new_expense_in.this);
                            isSaved = db.addExpenseToDB(obj);
                            db.close();

                        }
                        else{
                            Toast.makeText(new_expense_in.this, "Insuffient Balance !", Toast.LENGTH_LONG).show();
                            isBalanceConsistent=false;
                        }
                    }
                        // Calling funtion to add the expense data

                    if (isSaved && isBalanceConsistent) {
                        editor.apply();
                        startActivity(new Intent(new_expense_in.this,Success.class));
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
    }
}