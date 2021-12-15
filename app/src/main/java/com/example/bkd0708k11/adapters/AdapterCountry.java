package com.example.bkd0708k11.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bkd0708k11.R;
import com.example.bkd0708k11.domains.Country;

import java.util.ArrayList;
import java.util.List;

public class AdapterCountry extends RecyclerView.Adapter<AdapterCountry.MyViewHolder> {
    LayoutInflater layoutInflater;
    Context context;
    ArrayList<Country> countries = new ArrayList<>();
    MyItemClickListener myItemClickListener;

    public AdapterCountry(Context context, ArrayList<Country> countries) {
        this.context = context;
        this.countries = countries;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = this.layoutInflater.inflate(R.layout.country_item, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Country country = countries.get(position);
        holder.tvName.setText(country.getName());
        holder.tvArea.setText(country.getArea());
        holder.tvPoplulation.setText(country.getPopulation());
    }

    @Override
    public int getItemCount() {
        return this.countries.size();
    }

    public interface MyItemClickListener{
        public void itemClick(View v, int position);
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvArea, tvPoplulation;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvArea = itemView.findViewById(R.id.tvArea);
            tvPoplulation = itemView.findViewById(R.id.tvPopulation);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Viết code xử lý khi người dùng click vào một item
                    myItemClickListener.itemClick(v,getAdapterPosition());
                }
            });
        }
    }

    public void setOnItemClickListener(MyItemClickListener myItemClickListener) {
        this.myItemClickListener = myItemClickListener;
    }
}

