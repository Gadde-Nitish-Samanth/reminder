package com.example.reminder;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String db_name = "task.db";
    public static final String table_name = "tabl_task";
    public static final String col_1 = "ID";
    public static final String col_2 = "note_name";
    public static final String col_3 = "note";
    public static final String col_4 = "date";
    public static final String col_5 = "time";
    public DatabaseHelper(@Nullable Context context) {
        super(context, db_name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table  "+ table_name+ " (ID INTEGER PRIMARY KEY AUTOINCREMENT, note_name TEXT , note TEXT , date TEXT , time TEXT )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+ table_name );
        onCreate(db);
    }

    public boolean insertData (String note_name , String task , String date , String time){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col_2,note_name);
        contentValues.put(col_3,task);
        contentValues.put(col_4,date);
        contentValues.put(col_5,time);
        long result = db.insert(table_name , null,contentValues);
        if(result == -1 ){
            return false;
        }
        else {
            return true;
        }
    }
}
