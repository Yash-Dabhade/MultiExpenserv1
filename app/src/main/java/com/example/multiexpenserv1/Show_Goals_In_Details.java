package com.example.multiexpenserv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Show_Goals_In_Details extends AppCompatActivity {

    private TextView title,date,amount,category,status;
    private ImageView ChangeStatus,Back,ChangeStatusText;
    DataBaseHelper db = new DataBaseHelper(Show_Goals_In_Details.this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_goals_in_details);
        Intent intent=getIntent();
        //Getting elements from frontend
        title=findViewById(R.id.Title_Show_Goals_In_Details);
        date=findViewById(R.id.Date_Show_Goals_In_Details);
        amount=findViewById(R.id.Amount_Show_Goals_In_Details);
        category=findViewById(R.id.Category_Show_Goals_In_Details);
        status=findViewById(R.id.Status_Show_Goals_In_Details);
        ChangeStatus=findViewById(R.id.Change_Status_Show_Goals_In_Details);
        Back=findViewById(R.id.Back_Show_Goals_In_Details);
        ChangeStatusText=findViewById(R.id.Change_Status_Text_Show_Goals_In_Details);

        //CHECKING WHETHER THE STATUS IS ACHIEVED
        if(intent.getStringExtra(MyGoals_Adapter.Show_Goals_Status).equals("ACHIEVED")){
            ChangeStatus.setVisibility(View.INVISIBLE);
            ChangeStatusText.setVisibility(View.INVISIBLE);
        }

        //Setting data
        title.setText(intent.getStringExtra(MyGoals_Adapter.Show_Goals_Title));
        date.setText(intent.getStringExtra(MyGoals_Adapter.Show_Goals_Date));
        amount.setText(intent.getStringExtra(MyGoals_Adapter.Show_Goals_Amount));
        category.setText(intent.getStringExtra(MyGoals_Adapter.Show_Goals_Category));
        status.setText(intent.getStringExtra(MyGoals_Adapter.Show_Goals_Status));

        //Setting On click listner for back button
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //Setting On Click listner for the Change Status Button
        ChangeStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.ChangeGoalStatus(intent.getIntExtra(MyGoals_Adapter.Show_Goals_ID,-1));
                startActivity(new Intent(Show_Goals_In_Details.this,Congratulations.class));
                finish();
            }
        });
    }
}