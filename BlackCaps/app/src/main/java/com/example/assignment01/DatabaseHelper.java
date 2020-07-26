package com.example.assignment01;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.math.BigInteger;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(Context context) {
        super(context, "carwash.db", null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table user (number integer primary key,name text,password text,address text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists user");
        onCreate(db);

    }

    public boolean insert(BigInteger number, String name, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("number", String.valueOf(number));
        contentValues.put("name", name);
        contentValues.put("password", password);

        long ins = db.insert("user", null, contentValues);
        if (ins == -1) return false;
        else return true;
    }

    //checking if email exists
    public Boolean chkemail(BigInteger num) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select  * from user where number='" + num + "'", null);
        if (cursor.getCount() > 0) return false;
        else return true;
    }

    //for login
    public Boolean login(BigInteger n, String p) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from user where number = '" + n + "' and password = '" + p + "'", null);
        if (cursor.getCount() > 0) return true;
        else return false;

    }

    public String ProfileName(BigInteger n,int col) {
        String p = "";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from user where number = '" + n + "'", null);
        if (cursor.getCount() > 0) {
            while(cursor.moveToNext()) {

                    p = cursor.getString(col);

            }

        }
        return p;
    }
}
