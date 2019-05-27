package com.example.othregensburg.zapp.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface StaffDao {

    @Query("SELECT * FROM staff")
    List<StaffMember> getAll();

    @Insert
    void insert(StaffMember staff);

    @Delete
    void delete(StaffMember staff);
}
