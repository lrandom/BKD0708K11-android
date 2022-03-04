package com.example.bkd0708k11.activities.noteapp.dals;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.bkd0708k11.activities.noteapp.db.DBHelper;
import com.example.bkd0708k11.activities.noteapp.models.Note;
import com.example.bkd0708k11.activities.noteapp.models.StatementItem;

import java.util.ArrayList;

public class DalStatementItem {
    private SQLiteDatabase db;

    public DalStatementItem(Context context) {
        DBHelper dbHelper = new DBHelper(context);
        this.db = dbHelper.getWritableDatabase();
    }

    public void addStatement(String purpose, double amount, String inputDate, int isSpend) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("purpose", purpose);
        contentValues.put("amount", amount);
        contentValues.put("dt", inputDate);
        contentValues.put("isSpend", isSpend);
        this.db.insert("tb_statements", null, contentValues);
    }


    public ArrayList<StatementItem> getStatementItems(String fromDate, String toDate) {
        String query = "SELECT * FROM tb_statements";
        if (fromDate != null && toDate != null) {
            query += " WHERE dt BETWEEN " + fromDate + " AND " + toDate;
        }
        if (fromDate != null && toDate == null) {
            query += " WHERE dt >= " + fromDate;
        }
        if (fromDate == null && toDate != null) {
            query += " WHERE dt <=" + toDate;
        }


        ArrayList<StatementItem> statementItems = new ArrayList<>();

        Cursor cursor = this.db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                //lấy dữ liệu ra
                @SuppressLint("Range") Long id = cursor.getLong(cursor.getColumnIndex("id"));
                @SuppressLint("Range") Double amount = cursor.getDouble(cursor.getColumnIndex("amount"));
                @SuppressLint("Range") String purpose = cursor.getString(cursor.getColumnIndex("purpose"));
                @SuppressLint("Range") String inputDate = cursor.getString(cursor.getColumnIndex("dt"));
                @SuppressLint("Range") Integer isSpend = cursor.getInt(cursor.getColumnIndex("isSpend"));
                StatementItem statement = new StatementItem();
                statement.setId(id);
                statement.setDate(inputDate);
                statement.setIsSpend(isSpend);
                statement.setPurpose(purpose);
                statement.setAmount(amount);
                statementItems.add(statement);
            } while (cursor.moveToNext());
        }
        return statementItems;
    }

    //SUM = TÍNH TỔNG
    //lấy tổng thu
    @SuppressLint("Range")
    public Double getCollectAmount(String fromDate, String toDate) {
        Double totalCollect = 0.0;
        String query = "SELECT SUM(amount) AS total_collect FROM tb_statements WHERE isSpend=0 ";
        if (fromDate != null && toDate != null) {
            query += "AND dt BETWEEN " + fromDate + " AND " + toDate;
        }
        if (fromDate != null && toDate == null) {
            query += "AND dt >= " + fromDate;
        }
        if (fromDate == null && toDate != null) {
            query += "AND dt <=" + toDate;
        }
        Cursor cursor = this.db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            totalCollect = cursor.getDouble(cursor.getColumnIndex("total_collect"));
        }
        return totalCollect;
    }

    @SuppressLint("Range")
    public Double getSpentAmount(String fromDate, String toDate) {
        Double totalSpent = 0.0;
        String query = "SELECT SUM(amount) AS total_collect FROM tb_statements WHERE isSpend=1 ";
        if (fromDate != null && toDate != null) {
            query += "AND dt BETWEEN " + fromDate + " AND " + toDate;
        }
        if (fromDate != null && toDate == null) {
            query += "AND dt >= " + fromDate;
        }
        if (fromDate == null && toDate != null) {
            query += "AND dt <=" + toDate;
        }
        Cursor cursor = this.db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            totalSpent = cursor.getDouble(cursor.getColumnIndex("total_collect"));
        }
        return totalSpent;
    }
}

