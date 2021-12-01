package com.example.bkd0708k11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText edtShowResult;
    String numberOne = "";
    String numberTwo = "";
    String operationName = null;
    Float result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtShowResult = findViewById(R.id.edtShowResult);
    }

    public void getButtonNumberValue(View view) {
        Button btn = (Button) view;
        String number = btn.getText().toString();

        if (this.operationName == null) {
            this.numberOne = this.numberOne + number;
        } else {
            this.numberTwo = this.numberTwo + number;
        }
    }

    public void getOperationName(View view) {
        Button btn = (Button) view;
        this.operationName = btn.getText().toString();
    }


    public void clear(View view) {
        this.numberOne = "";
        this.numberTwo = "";
        this.result = null;
        edtShowResult.setText("");
        this.operationName = null;
    }

    public void calc(View view) {
        switch (this.operationName) {
            case "+":
                this.result = Float.parseFloat(this.numberOne) + Float.parseFloat(this.numberTwo);
                break;

            case "-":
                this.result = Float.parseFloat(this.numberOne) - Float.parseFloat(this.numberTwo);
                break;

            case "*":
                this.result = Float.parseFloat(this.numberOne) * Float.parseFloat(this.numberTwo);
                break;

            case "/":
                this.result = Float.parseFloat(this.numberOne) / Float.parseFloat(this.numberTwo);
                break;
        }

        edtShowResult.setText(String.format(this.result + ""));
    }
}