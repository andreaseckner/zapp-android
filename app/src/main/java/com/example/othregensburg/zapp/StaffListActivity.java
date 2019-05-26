package com.example.othregensburg.zapp;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.example.othregensburg.zapp.db.StaffDatabase;
import com.example.othregensburg.zapp.db.StaffTable;

import java.util.ArrayList;

public class StaffListActivity extends AppCompatActivity {

    StaffDatabase mStaffDatabase;
    private RecyclerView mRecyclerView;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_members);
        mStaffDatabase = new StaffDatabase(this);

        init();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mStaffDatabase.close();
    }

    private ArrayList<StaffMember> getStaffMember() {

        SQLiteDatabase db = mStaffDatabase.getReadableDatabase();

        String[] projection = StaffTable.ALL_COLUMNS;

        Cursor cursor = db.query(
                StaffTable.TABLE_NAME,  // The table to query
                projection,             // The array of columns to return (pass null to get all)
                null,                   // The columns for the WHERE clause
                null,                   // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                null                    // The sort order
        );

        ArrayList<StaffMember> members = new ArrayList<>();

        while(cursor.moveToNext()) {
            StaffMember member = new StaffMember(
                    cursor.getString(cursor.getColumnIndex(StaffTable.FIRST_NAME)),
                    cursor.getString(cursor.getColumnIndex(StaffTable.LAST_NAME)),
                    cursor.getString(cursor.getColumnIndex(StaffTable.ROLE)));
            members.add(member);
        }
        cursor.close();

        return members;
    }

    private void init() {
        setupToolbar();
        setupUiComponents();
        setupRecyclerView();
    }

    private void setupRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        StaffAdapter staffAdapter = new StaffAdapter(this, getStaffMember());
        mRecyclerView.setAdapter(staffAdapter);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, layoutManager.getOrientation()));
    }

    private void setupToolbar() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.title_staff_members);
    }

    private void setupUiComponents() {
        mRecyclerView = findViewById(R.id.activity_staff_members_rv);
    }
}
