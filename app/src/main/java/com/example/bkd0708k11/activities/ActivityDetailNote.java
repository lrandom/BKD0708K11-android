package com.example.bkd0708k11.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.bkd0708k11.R;

import org.w3c.dom.Text;

public class ActivityDetailNote extends AppCompatActivity {
    TextView tvTitle, tvContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_note);
        tvTitle = findViewById(R.id.tvTitle);
        tvContent = findViewById(R.id.tvContent);
        tvTitle.setText(getIntent().getStringExtra("TITLE"));
        tvContent.setText(getIntent().getStringExtra("CONTENT"));
    }
}