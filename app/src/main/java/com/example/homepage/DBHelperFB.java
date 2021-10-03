package com.example.homepage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelperFB extends SQLiteOpenHelper {
    public DBHelperFB(Context context) {
        super(context, "Feeddata.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table Feeddetails(name TEXT primary key, date TEXT, feedback TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop Table if exists Feeddetails");
    }

    public Boolean insertfeeddata(String name, String date, String feedback)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Name", name);
        contentValues.put("Date", date);
        contentValues.put("Feedback", feedback);
        long result=DB.insert("Feeddetails", null, contentValues);
        if(result==-1){
            return false;
        }else{
            return true;
        }
    }

    public Boolean updatefeeddata(String name, String date, String feedback) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Date", date);
        contentValues.put("Feedback", feedback);
        Cursor cursor = DB.rawQuery("Select * from Feeddetails where name = ?", new String[]{name});
        if (cursor.getCount() > 0) {
            long result = DB.update("Feeddetails", contentValues, "name=?", new String[]{name});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }}

    public Boolean deletedata (String name)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Feeddetails where name = ?", new String[]{name});
        if (cursor.getCount() > 0) {
            long result = DB.delete("Feeddetails", "name=?", new String[]{name});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }

    }

    public Cursor getdata ()
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Feeddetails", null);
        return cursor;

    }

}
