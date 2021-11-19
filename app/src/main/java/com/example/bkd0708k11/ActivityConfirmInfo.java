package com.example.bkd0708k11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ActivityConfirmInfo extends AppCompatActivity {
    TextView tvUserName, tvFullName, tvPhone;
    String userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_info);
        tvUserName = findViewById(R.id.tvUserName);
        tvFullName = findViewById(R.id.tvFullName);
        tvPhone = findViewById(R.id.tvPhone);

        this.userName = getIntent().getStringExtra("userName");
        tvUserName.setText(this.userName);
        tvFullName.setText(getIntent().getStringExtra("fullName"));
        tvPhone.setText(getIntent().getStringExtra("phone"));

    }

    public void next(View view) {
        Intent intent = new Intent(this, ActivitySuccess.class);
        intent.putExtra("userName", this.userName);
        startActivity(intent);
    }
}