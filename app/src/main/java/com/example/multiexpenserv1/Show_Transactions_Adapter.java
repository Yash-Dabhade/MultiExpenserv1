package com.example.multiexpenserv1;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Show_Transactions_Adapter extends RecyclerView.Adapter< Show_Transactions_Adapter.ViewHolder> {
    List<balance>balanceList;
    Context context;

    //constructor for context
    public Show_Transactions_Adapter (List<balance> balanceList, Context context) {
        this.balanceList =balanceList;
        this.context = context;
    }

    @NonNull
    @Override
    public Show_Transactions_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.activity_show_transactions_layout,parent,false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull Show_Transactions_Adapter.ViewHolder holder, int position) {
        holder.Title.setText(balanceList.get(position).getTitle());
        holder.Date.setText(balanceList.get(position).getDate());
        if(balanceList.get(position).getStatus().equals("Deposit")){
            holder.StatusD.setText(balanceList.get(position).getAmountWithRS());
        }
        else if(balanceList.get(position).getStatus().equals("Withdraw")){
            holder.StatusW.setText(balanceList.get(position).getAmountWithRS());
        }
    }
    //to get count
    @Override
    public int getItemCount() {
        return  balanceList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        final private  TextView Title,Date,StatusW,StatusD;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Title=itemView.findViewById(R.id.show_transactions_title);
            Date=itemView.findViewById(R.id.show_transactions_date);
            StatusD=itemView.findViewById(R.id.show_transactions_status_deposit);
            StatusW=itemView.findViewById(R.id.show_transactions_status_withdraw);

        }
    }
}