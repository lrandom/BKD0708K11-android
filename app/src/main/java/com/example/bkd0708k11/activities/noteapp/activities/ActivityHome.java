package com.example.bkd0708k11.activities.noteapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.example.bkd0708k11.R;
import com.example.bkd0708k11.activities.noteapp.adapter.StatementItemAdapter;
import com.example.bkd0708k11.activities.noteapp.dals.DalStatementItem;
import com.example.bkd0708k11.activities.noteapp.helpers.Helpers;
import com.example.bkd0708k11.activities.noteapp.models.StatementItem;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Currency;

public class ActivityHome extends AppCompatActivity {
    TextView tvTotalSpent, tvTotalCollect;
    DalStatementItem dalStatementItem;
    RecyclerView rcListStm;
    ArrayList<StatementItem> statementItems = new ArrayList<>();
    StatementItemAdapter statementItemAdapter;
    EditText edtFrom, edtTo;
    String fromDate, toDate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        tvTotalSpent = findViewById(R.id.tvTotalSpend);
        tvTotalCollect = findViewById(R.id.tvTotalCollectAmount);
        dalStatementItem = new DalStatementItem(ActivityHome.this);
        statementItemAdapter = new StatementItemAdapter(ActivityHome.this, statementItems);
        rcListStm = findViewById(R.id.rcListAmount);
        rcListStm.setAdapter(statementItemAdapter);
        rcListStm.setLayoutManager(new LinearLayoutManager(ActivityHome.this,
                LinearLayoutManager.VERTICAL, false));
        edtFrom = findViewById(R.id.edtFrom);
        edtTo = findViewById(R.id.edtTo);

        Calendar calendar = Calendar.getInstance();
        edtFrom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(ActivityHome.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                int myMonth = month + 1;
                                String sMonth = myMonth + "";
                                if (myMonth < 10) {
                                    sMonth = "0" + sMonth;
                                }
                                int myDate = dayOfMonth;
                                String sDate = myDate + "";
                                if (myDate < 10) {
                                    sDate = "0" + sDate;
                                }

                                String selectedDate = sDate + "-" + sMonth + "-" + year;
                                edtFrom.setText(selectedDate);
                                fromDate = year + "-" + sMonth + "-" + sDate;
                                _updateUI();
                            }
                        },
                        calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)
                ).show();
            }
        });

        edtTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(ActivityHome.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                int myMonth = month + 1;
                                String sMonth = myMonth + "";
                                if (myMonth < 10) {
                                    sMonth = "0" + sMonth;
                                }
                                int myDate = dayOfMonth;
                                String sDate = myDate + "";
                                if (myDate < 10) {
                                    sDate = "0" + sDate;
                                }

                                String selectedDate = sDate + "-" + sMonth + "-" + year;
                                edtTo.setText(selectedDate);
                                toDate = year + "-" + sMonth + "-" + sDate;
                                _updateUI();
                            }
                        },
                        calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)
                ).show();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        _updateUI();
    }

    private void _updateUI() {
        double totalCollectAmount = dalStatementItem.getCollectAmount(fromDate, toDate);
        double totalSpentAmount = dalStatementItem.getSpentAmount(fromDate, toDate);
        tvTotalSpent.setText(Helpers.formatCurrency(totalSpentAmount));
        tvTotalCollect.setText(Helpers.formatCurrency(totalCollectAmount));
        statementItems.clear();
        ArrayList<StatementItem> tmpStatements = dalStatementItem.getStatementItems(fromDate, toDate);
        for (StatementItem statementItem : tmpStatements
        ) {
            statementItems.add(statementItem);
        }
        statementItemAdapter.notifyDataSetChanged();
    }

    public void goToAddAmountActivity(View view) {
        Intent intent = new Intent(ActivityHome.this, AddAmountActivity.class);
        startActivity(intent);
    }
}