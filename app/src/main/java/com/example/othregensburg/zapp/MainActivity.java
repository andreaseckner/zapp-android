package com.example.othregensburg.zapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button mBtnNewStaffMember;
    private Button mBtnStaffList;

    // TODO (1) Create a new interface "StaffColumns" which describes the staff table name and columns
    // TODO (2) Create a new class "StaffTable" providing SQL statements for creating and dropping the table
    // TODO (3) Add another static method to describe all columns to the "StaffTable" class
    // TODO (4) Add a new class "StaffDatabase" extending SQLiteOpenHelper and implement all necessary methods


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init(){
        setupUiComponents();
        setListeners();
    }

    private void setListeners(){
        mBtnNewStaffMember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NewStaffMemberActivty.class);
                startActivity(intent);
            }
        });

        mBtnStaffList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, StaffListActivity.class);
                startActivity(intent);
            }
        });
    }

    private void setupUiComponents(){
        mBtnNewStaffMember = findViewById(R.id.btn_new_staff_member);
        mBtnStaffList = findViewById(R.id.btn_staff_list);
    }



}
