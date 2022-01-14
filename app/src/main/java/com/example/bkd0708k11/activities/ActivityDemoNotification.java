package com.example.bkd0708k11.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.bkd0708k11.R;

public class ActivityDemoNotification extends AppCompatActivity {
    Button btnShowNotification, btnHideNotification;
    NotificationChannel notificationChannel;
    NotificationCompat.Builder notificationBuilder;
    NotificationManager notificationManager;
    Notification notification;

    public static final String CHANNEL_ID = "com.example.bkd0708k11.CHANNEL_ME";
    public static final int NOTIFICATION_ID = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_notification);
        btnShowNotification = findViewById(R.id.btnShowNotification);
        btnHideNotification = findViewById(R.id.btnHideNotification);
        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        btnShowNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNotification();
            }
        });
    }

    public void showNotification() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            //nếu là android 8
            notificationChannel = new NotificationChannel(CHANNEL_ID, "channel me", NotificationManager.IMPORTANCE_HIGH);
            notificationChannel.setSound(null, null);
            notificationChannel.enableVibration(true);
            notificationManager.createNotificationChannel(notificationChannel);

            notificationBuilder = new NotificationCompat.Builder(ActivityDemoNotification.this, CHANNEL_ID);
            notificationBuilder.setSmallIcon(R.drawable.ic_android_black_24dp)
                    .setContentTitle("Thong bao")
                    .setContentText("Ban tin nhan moi");
            notification = notificationBuilder.build();
            notificationManager.notify(NOTIFICATION_ID, notification);
        } else {
            //theo một cách rất khác
            notificationBuilder = new NotificationCompat.Builder(ActivityDemoNotification.this, CHANNEL_ID);
            notificationBuilder.setSmallIcon(R.drawable.ic_android_black_24dp)
                    .setContentTitle("Thong bao")
                    .setContentText("Ban tin nhan moi");
            notification = notificationBuilder.build();
            notificationManager.notify(NOTIFICATION_ID, notification);
        }
    }
}