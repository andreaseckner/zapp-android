package com.example.othregensburg.zapp.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

// TODO (6) Let StaffDatabase extend from RoomDatabase instead of SQLiteOpenHelper
// TODO (7) Add proper annotations

// TODO (8) Use the Singleton pattern to make sure that there is only one Database object at runtime

/* HINT

// For Singleton instantiation
private static final Object LOCK = new Object();
private static volatile EmployeeDatabase sInstance;

public static EmployeeDatabase getInstance(Context context) {
    if (sInstance == null) {
        synchronized (LOCK) {
            if (sInstance == null) {
                // TODO (9) Create database and allow Main Thread Queries
                sInstance = [...]
            }
        }
    }
    return sInstance;
}
*/


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
