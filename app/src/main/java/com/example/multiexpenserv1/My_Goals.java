package com.example.multiexpenserv1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

public class My_Goals extends AppCompatActivity {

    RecyclerView recyclerView;
    DataBaseHelper db = new DataBaseHelper(My_Goals.this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_goals);
        recyclerView = findViewById(R.id.My_Goals_Recycler_View);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<goal> goalsList=db.getAllGoals();
        MyGoals_Adapter adapter=new MyGoals_Adapter(goalsList,this);
        recyclerView.setAdapter(adapter);
    }
}