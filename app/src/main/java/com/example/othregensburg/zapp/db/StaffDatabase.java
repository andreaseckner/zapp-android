package com.example.othregensburg.zapp.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {StaffMember.class}, version = 1)
public abstract class StaffDatabase extends RoomDatabase {

    private static final String DATABASE_NAME = "staff";

    // For Singleton instantiation
    private static final Object LOCK = new Object();
    private static volatile StaffDatabase sInstance;

    public static StaffDatabase getInstance(Context context) {
        if (sInstance == null) {
            synchronized (LOCK) {
                if (sInstance == null) {
                    sInstance = Room.databaseBuilder(context.getApplicationContext(),
                            StaffDatabase.class, StaffDatabase.DATABASE_NAME).
                            allowMainThreadQueries().build();
                }
            }
        }
        return sInstance;
    }

    public abstract StaffDao staffDao();
}
