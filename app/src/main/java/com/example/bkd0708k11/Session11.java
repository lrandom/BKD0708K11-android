package com.example.bkd0708k11;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.bkd0708k11.adapters.AdapterCountry;
import com.example.bkd0708k11.domains.Country;

import java.util.ArrayList;

public class Session11 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_session11);
        RecyclerView rcCountry = findViewById(R.id.rcCountry);
        ArrayList<Country> countries = new ArrayList<>();
        countries.add(new Country("VietNam", "336000", "100000000"));
        countries.add(new Country("Indonesia", "336000", "300000000"));
        countries.add(new Country("USA", "336000", "300000000"));
        countries.add(new Country("China", "336000", "14000000000"));
        countries.add(new Country("India", "336000", "13000000000"));
        countries.add(new Country("Russia", "336000", "100000000"));
        countries.add(new Country("Japan", "336000", "100000000"));
        countries.add(new Country("Korea", "336000", "50000000"));
        countries.add(new Country("North Korea", "336000", "80000000"));
        countries.add(new Country("Lao", "336000", "4000000"));
        countries.add(new Country("Cambodia", "336000", "15000000"));
        countries.add(new Country("Philipin", "336000", "80000000"));

        AdapterCountry adapterCountry = new AdapterCountry(Session11.this, countries);
        LinearLayoutManager lln = new LinearLayoutManager(Session11.this, LinearLayoutManager.VERTICAL, true);
        //GridLayoutManager gln = new GridLayoutManager(Session11.this,3,RecyclerView.VERTICAL,true);
        rcCountry.setLayoutManager(lln);
        rcCountry.setAdapter(adapterCountry);
    }
}