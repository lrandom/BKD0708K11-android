package com.example.bkd0708k11.activities.noteapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bkd0708k11.R;
import com.example.bkd0708k11.activities.noteapp.helpers.Helpers;
import com.example.bkd0708k11.activities.noteapp.models.Note;
import com.example.bkd0708k11.activities.noteapp.models.StatementItem;

import java.util.ArrayList;

public class StatementItemAdapter extends RecyclerView.Adapter<StatementItemAdapter.StatementItemViewHolder> {
    LayoutInflater layoutInflater;
    Context context;
    ArrayList<StatementItem> statementItems;

    public StatementItemAdapter(Context context, ArrayList<StatementItem> statementItems) {
        this.context = context;
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.statementItems = statementItems;
    }


    @NonNull
    @Override
    public StatementItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = layoutInflater.inflate(R.layout.note_item, parent, false);
        StatementItemAdapter.StatementItemViewHolder myViewHolder = new StatementItemViewHolder(v);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull StatementItemViewHolder holder, int position) {
        StatementItem statementItem = statementItems.get(position);
        holder.tvPurpose.setText(statementItem.getPurpose());
        holder.tvAmount.setText(Helpers.formatCurrency(statementItem.getAmount()));
        holder.tvDate.setText(statementItem.getDate());
    }

    @Override
    public int getItemCount() {
        return this.statementItems.size();
    }

    public class StatementItemViewHolder extends RecyclerView.ViewHolder {
        public TextView tvAmount, tvDate, tvPurpose;

        public StatementItemViewHolder(@NonNull View itemView) {
            super(itemView);
            tvAmount = itemView.findViewById(R.id.tvAmount);
            tvDate = itemView.findViewById(R.id.tvDate);
            tvPurpose = itemView.findViewById(R.id.tvPurpose);
        }
    }

}
