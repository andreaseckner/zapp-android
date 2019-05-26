package com.example.othregensburg.zapp.db;

public class StaffTable implements StaffColumns {

    public static final String SQL_CREATE =
            "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" +
                    ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    FIRST_NAME + " TEXT NOT NULL," +
                    LAST_NAME + " TEXT NOT NULL," +
                    ROLE + " TEXT NOT NULL);";

    public static final String SQL_DROP =
            "DROP TABLE IF EXISTS " + TABLE_NAME + ";";

    public static final String[] ALL_COLUMNS = new String[]{
            ID,
            FIRST_NAME,
            LAST_NAME,
            ROLE
    };
}
