package com.example.bkd0708k11;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ActivitySignup extends AppCompatActivity {
    Button button;
    public static final String TAG = "Activity Signup";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

/*        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);


        TextView tv1 = new TextView(this);
        tv1.setText(R.string.app_name);

        linearLayout.addView(tv1);

        setContentView(linearLayout);*/
        button =findViewById(R.id.btnSubmit); //inflating
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: ");
            }
        });
    }

    public void submit(View v) {
        Log.d(TAG, "submit:");
    }
}