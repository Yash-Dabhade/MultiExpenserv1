package com.example.multiexpenserv1;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.multiexpenserv1.expense;

import java.util.List;

public class MyGoals_Adapter extends RecyclerView.Adapter<MyGoals_Adapter.ViewHolder> {
    List<goal>goalsList;
    Context context;
    //Defining some keys
    public static String Show_Goals_Title=" com.example.multiexpenserv1.Show_Goals_In_Details.Title";
    public static String Show_Goals_Amount=" com.example.multiexpenserv1.Show_Goals_In_Details.Amount";
    public static String Show_Goals_Category=" com.example.multiexpenserv1.Show_Goals_In_Details.Category";
    public static String Show_Goals_Date=" com.example.multiexpenserv1.Show_Goals_In_Details.Date";
    public static String Show_Goals_Status=" com.example.multiexpenserv1.Show_Goals_In_Details.Status";
    public static String Show_Goals_ID=" com.example.multiexpenserv1.Show_Goals_In_Details.ID";

    //constructor for context
    public MyGoals_Adapter(List<goal> goalsList, Context context) {
        this.goalsList = goalsList;
        this.context = context;
    }


    @NonNull
    @Override
    public MyGoals_Adapter.ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.activity_show_goals_layout,parent,false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull MyGoals_Adapter.ViewHolder holder, int position) {

        holder.Title.setText(goalsList.get(position).getTitle());
        holder.Amount.setText(goalsList.get(position).getAmountWithRS());
        holder.Date.setText(goalsList.get(position).getDate());
    }

    //to get count
    @Override
    public int getItemCount() {
        return  goalsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener{
        final private  TextView Title,Amount,Date;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //Setting on click listner for each item
            itemView.setOnClickListener(this);
            Title=itemView.findViewById(R.id.Title_My_Goals);
            Amount=itemView.findViewById(R.id.Amount_My_Goals);
            Date=itemView.findViewById(R.id.Date_My_Goals);


        }

        @Override
        public void onClick(View v) {
            //Getting click position
            int position=this.getAdapterPosition();

            //Getting object at the clicked position
            goal obj=goalsList.get(position);

            //Declaring intent
            Intent intent=new Intent(context,Show_Goals_In_Details.class);

            //Initializing values from object
            String Title,Amount,Date,Status,Category;
            int ID;
            ID=obj.getID();
            Title=obj.getTitle();
            Amount=obj.getAmountWithRS();
            Date=obj.getDate();
            Status=obj.getStatus();
            Category=obj.getType();
            //Putting it in extras in intent
            intent.putExtra(Show_Goals_ID,ID);
            intent.putExtra(Show_Goals_Title,Title);
            intent.putExtra(Show_Goals_Amount,Amount);
            intent.putExtra(Show_Goals_Date,Date);
            intent.putExtra(Show_Goals_Status,Status);
            intent.putExtra(Show_Goals_Category,Category);

            //Starting Activity
            context.startActivity(intent);

        }
    }
}