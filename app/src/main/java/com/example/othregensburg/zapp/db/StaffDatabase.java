package com.example.othregensburg.zapp.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class StaffDatabase extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Staff.db";
    private static final int DATABASE_VERSION = 1;

    public StaffDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(StaffTable.SQL_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(StaffTable.SQL_DROP);
        onCreate(sqLiteDatabase);
    }
}
