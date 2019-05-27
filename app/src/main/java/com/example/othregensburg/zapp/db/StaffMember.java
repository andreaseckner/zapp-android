package com.example.othregensburg.zapp.db;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "staff")
public class StaffMember {

    @PrimaryKey(autoGenerate = true)
    public int id;
    public String firstName;
    public String lastName;
    public String role;

    public StaffMember(String firstName, String lastName, String role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
    }
}
