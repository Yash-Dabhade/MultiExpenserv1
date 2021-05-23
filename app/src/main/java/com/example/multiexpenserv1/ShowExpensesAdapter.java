package com.example.multiexpenserv1;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.multiexpenserv1.expense;

import java.util.List;

public class ShowExpensesAdapter extends RecyclerView.Adapter<ShowExpensesAdapter.ViewHolder>{
    //Initialization
    List<expense>expenseList;
    //Declaring keys for sharing in intent
    public  static  String ShowExpenseTitleKey=" com.example.multiexpenserv1.ShowExpensesAdapter.Title";
    public  static  String ShowExpenseAmountKey=" com.example.multiexpenserv1.ShowExpensesAdapter.Amount";
    public  static  String ShowExpenseDateKey=" com.example.multiexpenserv1.ShowExpensesAdapter.Date";
    public  static  String ShowExpenseDescriptionKey=" com.example.multiexpenserv1.ShowExpensesAdapter.Description";
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

    public class ViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener{
        final private  TextView Title,Amount,Date;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //Setting On click listener for the items
            itemView.setOnClickListener(this);
            Title=itemView.findViewById(R.id.Title_Show_Expenses);
            Amount=itemView.findViewById(R.id.Amount_Show_Expenses);
            Date=itemView.findViewById(R.id.Date_Show_Expenses);

        }
        @Override
        public void onClick(View v) {
            //Getting click position
            int position=this.getAdapterPosition();

            //Getting object at the clicked position
            expense e=expenseList.get(position);

            //Declaring intent
            Intent intent=new Intent(context,Show_Expenses_In_Details.class);
            //Initializing values from object
            String Title,Amount,Date,Description;
            Title=e.getTitle();
            Amount=e.getAmountWithRS();
            Date=e.getDate();
            Description=e.getDescription();
            //Putting extra values in to the intent
            intent.putExtra(ShowExpenseTitleKey,Title);
            intent.putExtra(ShowExpenseAmountKey,Amount);
            intent.putExtra(ShowExpenseDateKey,Date);
            intent.putExtra(ShowExpenseDescriptionKey,Description);
            //Starting activity
            context.startActivity(intent);

        }
    }
}