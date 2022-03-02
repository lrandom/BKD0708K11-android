package com.example.bkd0708k11.activities.noteapp.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(@Nullable Context context) {
        super(context, "my_app_db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
   /*     db.execSQL("CREATE TABLE notes(\n" +
                "     id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "\t title TEXT(200),\n" +
                "\t content TEXT(1000)\n" +
                ")\n");*/

        db.execSQL("CREATE TABLE tb_statements(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "amount FLOAT,purpose TAEXT(200)," +
                " isSpend INTEGER DEFAULT 1," +
                " dt datetime default current_timestamp)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS notes");
    }
}
