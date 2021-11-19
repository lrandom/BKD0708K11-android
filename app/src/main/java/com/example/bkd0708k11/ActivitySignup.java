package com.example.bkd0708k11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ActivitySignup extends AppCompatActivity {
    EditText edtUserName, edtFullName, edtPhone, edtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        edtUserName = findViewById(R.id.edtUserName);
        edtPassword = findViewById(R.id.edtPassword);
        edtPhone = findViewById(R.id.edtPhone);
        edtFullName = findViewById(R.id.edtFullName);
    }

    public void next(View view) {
        Intent intent = new Intent(this, ActivityConfirmInfo.class);
        intent.putExtra("fullName", edtFullName.getText().toString());
        intent.putExtra("userName", edtUserName.getText().toString());
        intent.putExtra("phone", edtPhone.getText().toString());
        startActivity(intent);
    }
}