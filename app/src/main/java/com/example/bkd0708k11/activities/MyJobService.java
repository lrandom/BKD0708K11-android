package com.example.bkd0708k11.activities;

import android.app.job.JobParameters;
import android.app.job.JobService;

public class MyJobService extends JobService {
    @Override
    public boolean onStartJob(JobParameters params) {
        //nghiệp vụ
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
        }
        return false;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        return false;
    }
}
