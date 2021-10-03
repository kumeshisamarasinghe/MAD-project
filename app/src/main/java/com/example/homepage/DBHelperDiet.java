package com.example.homepage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelperDiet extends SQLiteOpenHelper {
    public DBHelperDiet(Context context) {
        super(context, "Userdata.db", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table Dietdetails(category TEXT primary key, breakfast TEXT, lunch TEXT, dinner TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop Table if exists Dietdetails");
    }

    public Boolean insertdietdata(String category, String weight, String height, String state)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("category", category);
        contentValues.put("breakfast", weight);
        contentValues.put("lunch", height);
        contentValues.put("dinner", state);
        long result=DB.insert("Dietdetails", null, contentValues);
        if(result==-1){
            return false;
        }else{
            return true;
        }
    }


    public Boolean updatedietdata(String category, String weight, String height, String state) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("breakfast", weight);
        contentValues.put("lunch", height);
        contentValues.put("dinner", state);
        Cursor cursor = DB.rawQuery("Select * from Dietdetails where category = ?", new String[]{category});
        if (cursor.getCount() > 0) {
            long result = DB.update("Dietdetails", contentValues, "category=?", new String[]{category});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }}


    public Boolean deletediet (String category)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Dietdetails where category = ?", new String[]{category});
        if (cursor.getCount() > 0) {
            long result = DB.delete("Dietdetails", "category=?", new String[]{category});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }

    }

    public Cursor getdiet ()
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Dietdetails", null);
        return cursor;

    }
}
