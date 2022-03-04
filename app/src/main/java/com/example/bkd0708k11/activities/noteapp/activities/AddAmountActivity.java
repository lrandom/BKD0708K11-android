package com.example.bkd0708k11.activities.noteapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;

import com.example.bkd0708k11.R;
import com.example.bkd0708k11.activities.noteapp.dals.DalStatementItem;

import java.util.Calendar;

public class AddAmountActivity extends AppCompatActivity {
    Button btnSubmit;
    EditText edtPurpose, edtAmount, edtInputDate;
    String gSelectedDate = null;
    Integer isSpend = 1;

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
                new DatePickerDialog(AddAmountActivity.this,
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
                                edtInputDate.setText(selectedDate);
                                gSelectedDate = year + "-" + sMonth + "-" + sDate;

                            }
                        },
                        calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)
                ).show();
            }
        });
    }

    public void selectRadioType(View view) {
        Boolean isChecked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.rdoCollect:
                if (isChecked) {
                    isSpend = 0;
                }
                break;

            case R.id.rdoSpend:
                if (isChecked) {
                    isSpend = 1;
                }
                break;
        }
    }

    public void addAmount(View view) {
        DalStatementItem dalStatementItem = new DalStatementItem(AddAmountActivity.this);
        String purpose = edtPurpose.getText().toString();
        String amount = edtAmount.getText().toString();
        System.out.println(isSpend);
        dalStatementItem.addStatement(purpose, new Double(amount), gSelectedDate, isSpend);
        edtPurpose.setText("");
        edtAmount.setText("");
        edtInputDate.setText("");

    }
}