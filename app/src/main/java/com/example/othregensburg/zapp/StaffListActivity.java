package com.example.othregensburg.zapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.example.othregensburg.zapp.db.StaffDatabase;
import com.example.othregensburg.zapp.db.StaffMember;

import java.util.ArrayList;

public class StaffListActivity extends AppCompatActivity {

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

        init();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private ArrayList<StaffMember> getStaffMember() {

        ArrayList<StaffMember> members =
                new ArrayList<>(StaffDatabase.getInstance(this).staffDao().getAll());

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
