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

public class ShowExpensesAdapter extends RecyclerView.Adapter<ShowExpensesAdapter.ViewHolder> {
    List<expense>expenseList;
    Context context;

    //constructor for context
    public ShowExpensesAdapter(List<expense> expenseList, Context context) {
        this.expenseList = expenseList;
        this.context = context;
    }

    @NonNull
    @Override
    public ShowExpensesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.activity_show_expenses_layout,parent,false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ShowExpensesAdapter.ViewHolder holder, int position) {
        holder.Title.setText(expenseList.get(position).getTitle());
        holder.Amount.setText(expenseList.get(position).getAmountWithRS());
        holder.Date.setText(expenseList.get(position).getDate());
    }
    //to get count
    @Override
    public int getItemCount() {
        return  expenseList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        final private  TextView Title,Amount,Date;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Title=itemView.findViewById(R.id.Title_Show_Expenses);
            Amount=itemView.findViewById(R.id.Amount_Show_Expenses);
            Date=itemView.findViewById(R.id.Date_Show_Expenses);

        }
    }
}