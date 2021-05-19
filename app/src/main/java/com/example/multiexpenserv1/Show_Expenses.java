package com.example.multiexpenserv1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

public class Show_Expenses extends AppCompatActivity {

    private RecyclerView recyclerView;
    DataBaseHelper db = new DataBaseHelper(Show_Expenses.this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_expenses);

        recyclerView = findViewById(R.id.Show_Expenses_Recycler_View);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<expense> expenseList=db.getAllExpenses();
        ShowExpensesAdapter adapter=new ShowExpensesAdapter(expenseList,this);
        recyclerView.setAdapter(adapter);

    }
}