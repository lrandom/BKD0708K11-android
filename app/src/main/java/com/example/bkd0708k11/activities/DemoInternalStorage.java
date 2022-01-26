package com.example.bkd0708k11.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class DemoInternalStorage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // writeFile();
        readFile();
    }

    public void writeFile() {
        try {
            FileOutputStream fileOutputStream = openFileOutput("data.txt", MODE_PRIVATE);
            fileOutputStream.write("Hello".getBytes());
            fileOutputStream.close();
        } catch (Exception e) {

        }
    }

    public void readFile() {
        try {
            FileInputStream fileInputStream = openFileInput("data.txt");
            Reader reader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            bufferedReader.close();
            reader.close();
            fileInputStream.close();
        } catch (Exception e) {

        }
    }
}