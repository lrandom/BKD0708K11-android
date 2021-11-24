package com.example.bkd0708k11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void openWebsite(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://google.com.vn"));
        intent.putExtra("extra_data", "search engine");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void callPhone(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:0868232837"));
        startActivity(intent);
    }

    public void sendSMS(View v) {
        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:0856758675"));
        if (intent.resolveActivity(getPackageManager()) != null) {
            intent.putExtra("sms_body", "hello");
            startActivity(intent);
        }
    }

    public void openMap(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:21.027268766769954, 105.8094713498643"));
        startActivity(intent);
    }
}