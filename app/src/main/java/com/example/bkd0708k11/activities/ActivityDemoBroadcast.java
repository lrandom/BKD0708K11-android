package com.example.bkd0708k11.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.bkd0708k11.R;

public class ActivityDemoBroadcast extends AppCompatActivity {
    public static final String ACTION_SEND_FULL_NAME = "com.example.bkd0708k11.ACTION_SEND_FULL_NAME";
    MyReceiver myReceiver = null;
    Button btnSendBroadcast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_broadcast);
        myReceiver = new MyReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_BATTERY_LOW);
        intentFilter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        intentFilter.addAction(Intent.ACTION_BATTERY_CHANGED);
        intentFilter.addAction(ACTION_SEND_FULL_NAME);

        registerReceiver(myReceiver, intentFilter);

        LocalBroadcastManager.getInstance(ActivityDemoBroadcast.this)
                .registerReceiver(myReceiver, intentFilter);

        btnSendBroadcast = findViewById(R.id.btnSendBroadcast);
        btnSendBroadcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ACTION_SEND_FULL_NAME);
                intent.putExtra("FULL_NAME", "Nguyen Thanh Luan");
                LocalBroadcastManager.getInstance(ActivityDemoBroadcast.this).sendBroadcast(intent);
                sendBroadcast(intent, Manifest.permission.BROADCAST_SMS);

            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(myReceiver);
        LocalBroadcastManager.getInstance(ActivityDemoBroadcast.this).unregisterReceiver(myReceiver);
    }

    public class MyReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            //được gọi khi nhận được tín hiệu
            String action = intent.getAction();
            switch (action) {
                case Intent.ACTION_BATTERY_LOW:
                    //pin yếu
                    Toast.makeText(ActivityDemoBroadcast.this,
                            "Pin yếu rồi bro ơi, cứu em, pls help",
                            Toast.LENGTH_SHORT).show();
                    break;


                case Intent.ACTION_AIRPLANE_MODE_CHANGED:
                    Toast.makeText(ActivityDemoBroadcast.this,
                            "Người dùng đã chuyển chế độ sóng",
                            Toast.LENGTH_SHORT).show();
                    break;


                case ACTION_SEND_FULL_NAME:
                    String fullName = intent.getStringExtra("FULL_NAME");
                    Toast.makeText(ActivityDemoBroadcast.this, fullName,
                            Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }
}
