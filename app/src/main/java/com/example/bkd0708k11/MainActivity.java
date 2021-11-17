package com.example.bkd0708k11;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "debug"); //debug
        Log.e(TAG, "error"); //error
        Log.i(TAG, "info"); //info
        Log.w(TAG, "warning"); //warning
        Log.v(TAG, "verbose"); ///verbose
    }
}