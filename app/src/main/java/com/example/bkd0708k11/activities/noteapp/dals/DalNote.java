package com.example.bkd0708k11.activities.noteapp.dals;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.bkd0708k11.activities.noteapp.db.DBHelper;
import com.example.bkd0708k11.activities.noteapp.models.Note;

import java.util.ArrayList;

public class DalNote {
    private SQLiteDatabase db;

    public DalNote(Context context) {
        DBHelper dbHelper = new DBHelper(context);
        this.db = dbHelper.getWritableDatabase();
    }

    public void addNote(String title, String content) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", title);
        contentValues.put("content", content);
        this.db.insert("notes", null, contentValues);
    }

    public void updateNote(Long id, String title, String content) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", title);
        contentValues.put("content", content);
        this.db.update("notes", contentValues, "id =" + id, null);
    }

    public void deleteNote(Long id) {
        this.db.delete("notes", "id =" + id, null);
    }

    public ArrayList<Note> getNotes() {
        ArrayList<Note> notes = new ArrayList<>();
        Cursor cursor = this.db.rawQuery("SELECT * FROM notes", null);
        if (cursor.moveToFirst()) {
            do {
                //lấy dữ liệu ra
                @SuppressLint("Range") Long id = cursor.getLong(cursor.getColumnIndex("id"));
                @SuppressLint("Range") String title = cursor.getString(cursor.getColumnIndex("title"));
                @SuppressLint("Range") String content = cursor.getString(cursor.getColumnIndex("content"));
                Note note = new Note();
                note.setId(id);
                note.setTitle(title);
                note.setContent(content);
                notes.add(note);
            } while (cursor.moveToNext());
        }
        return notes;
    }

    public Note getNoteById(Long id) {
        ArrayList<Note> notes = new ArrayList<>();
        Note note = new Note();
        Cursor cursor = this.db.rawQuery("SELECT * FROM notes WHERE id=" + id, null);
        if (cursor.moveToFirst()) {
            @SuppressLint("Range") String title = cursor.getString(cursor.getColumnIndex("title"));
            @SuppressLint("Range") String content = cursor.getString(cursor.getColumnIndex("content"));
            note.setId(id);
            note.setTitle(title);
            note.setContent(content);
        }
        return note;
    }

}
