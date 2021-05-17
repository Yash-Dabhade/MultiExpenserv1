package com.example.multiexpenserv1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

public class show_transactions extends AppCompatActivity {
    private RecyclerView recyclerView;
    DataBaseHelper db = new DataBaseHelper(show_transactions.this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_transactions);
        recyclerView = findViewById(R.id.show_transactions_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<balance> balanceList=db.getAllBalance();
        Show_Transactions_Adapter adapter=new Show_Transactions_Adapter(balanceList,this);
        recyclerView.setAdapter(adapter);
    }
}