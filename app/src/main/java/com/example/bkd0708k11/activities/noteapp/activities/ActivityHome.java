package com.example.bkd0708k11.activities.noteapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.bkd0708k11.R;
import com.example.bkd0708k11.activities.noteapp.dals.DalStatementItem;
import com.example.bkd0708k11.activities.noteapp.helpers.Helpers;

import java.text.NumberFormat;
import java.util.Currency;

public class ActivityHome extends AppCompatActivity {
    TextView tvTotalSpent, tvTotalCollect;
    DalStatementItem dalStatementItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        tvTotalSpent = findViewById(R.id.tvTotalSpend);
        tvTotalCollect = findViewById(R.id.tvTotalCollectAmount);
        dalStatementItem = new DalStatementItem(ActivityHome.this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        double totalCollectAmount = dalStatementItem.getCollectAmount();
        double totalSpentAmount = dalStatementItem.getSpentAmount();
        tvTotalSpent.setText(Helpers.formatCurrency(totalSpentAmount));
        tvTotalCollect.setText(Helpers.formatCurrency(totalCollectAmount));

    }

    public void goToAddAmountActivity(View view) {
        Intent intent = new Intent(ActivityHome.this, AddAmountActivity.class);
        startActivity(intent);
    }
}