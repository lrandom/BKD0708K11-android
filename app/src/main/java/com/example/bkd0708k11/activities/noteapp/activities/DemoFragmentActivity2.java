package com.example.bkd0708k11.activities.noteapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.bkd0708k11.R;
import com.example.bkd0708k11.activities.noteapp.fragments.Fragment1;
import com.example.bkd0708k11.activities.noteapp.fragments.Fragment2;

public class DemoFragmentActivity2 extends AppCompatActivity {
    Button btnLoadFragment1, btnLoadFragment2;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_fragment2);
        btnLoadFragment1 = findViewById(R.id.btnLoadFragment1);
        btnLoadFragment2 = findViewById(R.id.btnLoadFragment2);
        btnLoadFragment1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.content, Fragment1.newInstance());
                fragmentTransaction.commit();
            }
        });

        btnLoadFragment2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.content, Fragment2.newInstance());
                fragmentTransaction.commit();
            }
        });

    }

    public void callFromFragment1(String params) {
        System.out.println(params);
    }
}