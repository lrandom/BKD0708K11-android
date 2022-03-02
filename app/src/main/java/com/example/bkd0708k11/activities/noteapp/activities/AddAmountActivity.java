package com.example.bkd0708k11.activities.noteapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.example.bkd0708k11.R;

import java.util.Calendar;

public class AddAmountActivity extends AppCompatActivity {
    Button btnSubmit;
    EditText edtPurpose, edtAmount, edtInputDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_amount);
        btnSubmit = findViewById(R.id.btnSubmit);
        edtPurpose = findViewById(R.id.edtPurpose);
        edtAmount = findViewById(R.id.edtAmount);
        edtInputDate = findViewById(R.id.edtInputDate);


        Calendar calendar = Calendar.getInstance();

        edtInputDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("HIHI", "onClick: TEST");
                new DatePickerDialog(AddAmountActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                            }
                        },
                        calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)
                ).show();
            }
        });
    }
}