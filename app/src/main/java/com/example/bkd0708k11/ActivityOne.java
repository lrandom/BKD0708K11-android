package com.example.bkd0708k11;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class ActivityOne extends AppCompatActivity {
    String name = "";
    public static final String TAG = "ActivityOne";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);
        Log.i(TAG, "onCreate");
        if (savedInstanceState != null) {
            if (savedInstanceState.getString("name") != null) {
                this.name = savedInstanceState.getString("name");
            }
        }
    }

/*
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null) {
            if (savedInstanceState.getString("name") != null) {
                this.name = savedInstanceState.getString("name");
            }
        }
    }*/

    public void next(View view) {
        //chuyen sang màn hình 2
        Intent intent = new Intent(this, ActivityTwo.class);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy");
    }

    public void getData(View v) {
        EditText edtName = findViewById(R.id.edtName);
        this.name = edtName.getText().toString();
    }

    public void printData(View v) {
        System.out.println("Name Value " + this.name);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        //backup
        outState.putString("name", this.name);
    }
}