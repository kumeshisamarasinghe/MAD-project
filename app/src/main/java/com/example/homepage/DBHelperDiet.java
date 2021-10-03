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
        //create the table
        DB.execSQL("create Table Dietdetails(category TEXT primary key, weight TEXT, height TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        //check the created table already exist
        DB.execSQL("drop Table if exists Dietdetails");
    }

    public Boolean insertdietdata(String category, String weight, String height)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        //get values
        contentValues.put("category", category);
        contentValues.put("weight", weight);
        contentValues.put("height", height);
        long result=DB.insert("Dietdetails", null, contentValues);
        if(result==-1){
            return false;
        }else{
            return true;
        }
    }


    public Boolean updatedietdata(String category, String weight, String height) {
        SQLiteDatabase DB = this.getWritableDatabase();
        //get values
        ContentValues contentValues = new ContentValues();
        contentValues.put("weight", weight);
        contentValues.put("height", height);
        //do update according to the category
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
        //delete details according to the category
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
        //select all in the table
        Cursor cursor = DB.rawQuery("Select * from Dietdetails", null);
        return cursor;

    }
}
