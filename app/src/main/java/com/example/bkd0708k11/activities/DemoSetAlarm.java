package com.example.bkd0708k11.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.bkd0708k11.R;

public class DemoSetAlarm extends AppCompatActivity {
    Button btnSetAlarm;
    AlarmManager alarmManager;
    public static final String ACTION_WAKEUP = "WAKEUP";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        setContentView(R.layout.activity_demo_set_alarm);
        btnSetAlarm = findViewById(R.id.btnSetAlarm);
        btnSetAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                long currentTime = System.currentTimeMillis();//thời gian tại thời điểm gọi hàm
                //hiệu của thời điểm hiện tại trừ đi 1-1-1970 0:00:00 (unix time)
                Intent intent = new Intent(ACTION_WAKEUP);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(DemoSetAlarm.this, 1,
                        intent, PendingIntent.FLAG_UPDATE_CURRENT);//gửi đi một tín hiệu
              /*  alarmManager.setExact(AlarmManager.RTC_WAKEUP,
                        currentTime + 2000, pendingIntent);*/

                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
                        currentTime + 2000, 60000, pendingIntent);

                //API 23 (Android 6 trở lên)
                //alarmManager.setExactAndAllowWhileIdle();
            }
        });

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ACTION_WAKEUP);
        registerReceiver(new MyReceiver(), intentFilter);
    }

    class MyReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            switch (intent.getAction()) {
                case ACTION_WAKEUP:
                    System.out.println("Báo thức đã được kích hoạt");
                    break;
            }
        }
    }
}