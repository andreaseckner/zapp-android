package com.example.othregensburg.zapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import java.util.ArrayList;

public class StaffListActivity extends AppCompatActivity {

    // TODO (10) Create a member field for the StaffDatabase
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
        // TODO (11) Instantiate the StaffDatabase

        init();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // TODO (17) Make sure to close the database before leaving the Activity
    }

    private ArrayList<StaffMember> getStaffMember() {

        // TODO (12) Get a writable SQLiteDatabase

        // TODO (13) Prepare the projection for the SQLite query
        // HINT: Make use of the static ALL_COLUMNS method from the StaffTable class

        // TODO (14) Make a query against the database to read all entries

        ArrayList<StaffMember> members = new ArrayList<>();

        // TODO (15) Fill the ArrayList using the cursor to retreive all necessary data
        // TODO (16) Do not forget to close the cursor appropriately!


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
