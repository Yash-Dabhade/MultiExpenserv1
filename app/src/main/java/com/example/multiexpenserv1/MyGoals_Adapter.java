package com.example.multiexpenserv1;


import android.content.Context;
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
        holder.Type.setText(goalsList.get(position).getType());
        holder.Date.setText(goalsList.get(position).getDate());
        holder.Status.setText("Pending");
    }

    //to get count
    @Override
    public int getItemCount() {
        return  goalsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        final private  TextView Title,Amount,Date,Type,Status;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Title=itemView.findViewById(R.id.Title_My_Goals);
            Amount=itemView.findViewById(R.id.Amount_My_Goals);
            Date=itemView.findViewById(R.id.Date_My_Goals);
            Type=itemView.findViewById(R.id.My_Goals_Type);
            Status=itemView.findViewById(R.id.Status_My_Goals);


        }
    }
}