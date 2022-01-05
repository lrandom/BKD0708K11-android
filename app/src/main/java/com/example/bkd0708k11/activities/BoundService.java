package com.example.bkd0708k11.activities;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;

import androidx.annotation.Nullable;

import com.example.bkd0708k11.R;

public class BoundService extends Service {
    MediaPlayer mediaPlayer;

    @Override
    public void onCreate() {
        super.onCreate();
        System.out.println("create service");
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.rap_dsk);
    }

    public void playMusic() {
        if (mediaPlayer != null) {
            mediaPlayer.start();
        }
    }

    public void pauseMusic() {
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
        }
    }

    public void resumeMusic() {
        if (mediaPlayer != null && !mediaPlayer.isPlaying()) {
            mediaPlayer.start();
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new MyBinder();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("destroy service");
    }

    public class MyBinder extends Binder {
        public Service getService() {
            return BoundService.this;
        }
    }

}
