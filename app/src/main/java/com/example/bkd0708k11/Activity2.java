package com.example.bkd0708k11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Activity2 extends AppCompatActivity {
    public static final String TAG = "Activity2";
    Button btnReturnDataToActivity1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
       /* String name = getIntent().getStringExtra("NAME");
        String address = getIntent().getStringExtra("ADDRESS");
        Log.i(TAG, name);
        Log.i(TAG, address);*/
/*        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("NAME");
        String address = bundle.getString("ADDRESS");
        Log.i(TAG, name);
        Log.i(TAG, address);*/

        btnReturnDataToActivity1 = findViewById(R.id.btnReturnData);
        btnReturnDataToActivity1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("SUBJECT", "Information Technology");
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}