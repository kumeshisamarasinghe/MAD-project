package com.example.homepage;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class waterDBHelper extends SQLiteOpenHelper {

    public waterDBHelper(Context context) {
        super(context, "Userdata.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create Table waterplan(time TEXT primary key, litres INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop Table if exists waterplan");
    }

    public Boolean insertdrinkedwater(String time, Integer litres){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("time",time);
        contentValues.put("litres",litres);
        long result = db.insert("waterplan", null,contentValues);
        if (result==-1){
            return false;
        }else{
            return true;
        }
    }

    public Boolean updatedrinkedwater(String time, Integer litres){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("litres",litres);
        Cursor cursor = db.rawQuery("Select * from waterplan where time=?",new String[] {time});
        if (cursor.getCount()>0){
          long result = db.update("waterplan",contentValues,"time=?", new String[]{time});
          if (result==-1){
              return false;
          }else {
              return true;
          }

        }else{
            return false;
        }
    }

    public Boolean deletedrinkedwater(String time){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from waterplan where time=?",new String[] {time});
        if (cursor.getCount()>0){
            long result = db.delete("waterplan","time=?", new String[]{time});
            if (result == -1){
                return false;
            }else{
                return true;
            }
        }else{
            return false;
        }
    }

    public Cursor getdata(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from waterplan",null);
        return cursor;
    }

    public Cursor sumofdata() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT SUM(litres) as totallitres FROM waterplan", null);

        if (cursor.moveToFirst()) {

            @SuppressLint("Range")
            int totallitres = cursor.getInt(cursor.getColumnIndex("litres"));// get final total

        }
        return cursor;
    }
}
