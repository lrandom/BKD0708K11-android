package com.example.bkd0708k11.activities;

import android.app.IntentService;
import android.content.Intent;
import androidx.annotation.Nullable;

public class MyIntentService extends IntentService {
    public MyIntentService() {
        super("intent service");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        for (int i = 0; i < 1000; i++) {
            System.out.println(i);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("Tự huỷ");
    }
}
