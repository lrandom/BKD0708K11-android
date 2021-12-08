package com.example.bkd0708k11.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.bkd0708k11.R;
import com.example.bkd0708k11.domains.Person;

import java.util.ArrayList;

public class PersonAdapter extends ArrayAdapter<Person> {
    private ArrayList<Person> persons;
    public PersonAdapter(@NonNull Context context, ArrayList<Person> inputPersons) {
        super(context, 0);
        this.persons = inputPersons;
    }


    //set giao diện cho phần tử đang hiển thị (đã được chọn)
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return getItemView(position, convertView, parent);
    }

    @NonNull
    private View getItemView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View cView = convertView;
        if (cView == null) {
            cView = LayoutInflater.from(getContext()).inflate(R.layout.person_item_layout, parent,false);
        }
        TextView tvName = cView.findViewById(R.id.tvName);
        TextView tvAge = cView.findViewById(R.id.tvAge);
        tvName.setText(persons.get(position).getName());
        tvAge.setText(persons.get(position).getAge());
        return cView;
    }

    //set giao diện cho từng phần tử trong danh sách chọn
    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return getItemView(position, convertView, parent);
    }

    @Override
    public int getCount() {
        return this.persons.size();
    }
}
