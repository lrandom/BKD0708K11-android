package com.example.bkd0708k11.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;

public class DemoExternalStorage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //checkPermission();
        //readExternalStorage();
        //writePref();
        readPref();
    }


    void checkPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                //đã cấp quyền
                //ghi file
                writeExternalStorage();
            } else {
                //chưa cấp quyền
                //yêu cầu cấp quyền
                requestPermissions(new String[]{
                        Manifest.permission.WRITE_EXTERNAL_STORAGE
                }, 10);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 10) {
            //hồi đáp của yêu cầu cấp quyền ghi
            if (grantResults.length != 0) {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //đã cấp quyền
                    writeExternalStorage();
                }
            }
        }
    }

    public void writeExternalStorage() {
        try {
            if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
                File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "data.txt");
                FileOutputStream fos = new FileOutputStream(file.getAbsolutePath());
                fos.write("Hello".getBytes());
                fos.close();
            } else {
                //alo alo
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void readExternalStorage() {
        try {
            File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "data.txt");
            FileReader fileReader = new FileReader(file.getAbsolutePath());
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            bufferedReader.close();
            fileReader.close();
        } catch (Exception e) {

        }
    }

    public void writePref() {
        SharedPreferences prefs = getSharedPreferences("data_pref", Context.MODE_PRIVATE);
        prefs.edit().putString("name", "Luan").commit();
        prefs.edit().putString("address", "QN").commit();
    }

    public void readPref() {
        SharedPreferences prefs = getSharedPreferences("data_pref", Context.MODE_PRIVATE);
        String name = prefs.getString("name", "");
        String address = prefs.getString("address", "");
        System.out.println(name);
        System.out.println(address);
    }
}