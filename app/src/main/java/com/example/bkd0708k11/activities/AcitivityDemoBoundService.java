package com.example.bkd0708k11.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;

import com.example.bkd0708k11.R;

public class AcitivityDemoBoundService extends AppCompatActivity {
    Button btnBindServiceToActivity, btnPlayMusic, btnPauseMusic, btnResumeMusic;
    BoundService boundService = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acitivity_demo_bound_service);
        btnBindServiceToActivity = findViewById(R.id.btnBindServiceToActivity);
        btnPlayMusic = findViewById(R.id.btnPlayMusic);
        btnPauseMusic = findViewById(R.id.btnPauseMusic);
        btnResumeMusic = findViewById(R.id.btnResumeMusic);

        btnBindServiceToActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(AcitivityDemoBoundService.this, BoundService.class);
                //bindService(intent, serviceConnection, BIND_AUTO_CREATE);
                Intent intent = new Intent(AcitivityDemoBoundService.this, MyIntentService.class);
                startService(intent);
            }
        });

        btnPlayMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (boundService != null) {
                    boundService.playMusic();
                }
            }
        });

        btnPauseMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (boundService != null) {
                    boundService.pauseMusic();
                }
            }
        });

        btnResumeMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (boundService != null) {
                    boundService.resumeMusic();
                }
            }
        });
    }

    ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder binder) {
            BoundService.MyBinder myBinder = (BoundService.MyBinder) binder;
            boundService = (BoundService) myBinder.getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };
}