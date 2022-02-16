package com.example.bkd0708k11.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.example.bkd0708k11.R;
import com.example.bkd0708k11.activities.db.DBHelper;

public class DemoSqlite extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_sqlite);
        DBHelper dbHelper = new DBHelper(DemoSqlite.this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();//check chưa có db thì tạo db và tạo bảng và trả về đối tượng SqliteDatabase
        db.execSQL("INSERT INTO users(\n" +
                "   name,\n" +
                "   address\n" +
                ") VALUES (\n" +
                "   \"Nguyen Duc Toan\",\n" +
                "   \"Quang Ninh\"\n" +
                ")\n");

        db.execSQL("INSERT INTO users(\n" +
                "   name,\n" +
                "   address\n" +
                ") VALUES (\n" +
                "   \"Nguyen Duc Toan\",\n" +
                "   \"Quang Ninh\"\n" +
                ")\n");

        db.execSQL("INSERT INTO users(\n" +
                "   name,\n" +
                "   address\n" +
                ") VALUES (\n" +
                "   \"Nguyen Duc Toan\",\n" +
                "   \"Quang Ninh\"\n" +
                ")\n");

    }
}