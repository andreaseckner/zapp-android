package com.example.othregensburg.zapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NewStaffMemberActivty extends AppCompatActivity {

    private Button mButtonSave;
    // TODO (5) Create a member field for the StaffDatabase
    private EditText mEditTextFirstName;
    private EditText mEditTextLastName;
    private EditText mEditTextRole;

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
        setContentView(R.layout.activity_new_staff_member);

        // TODO (6) Instantiate the StaffDatabase
        init();
    }

    @Override
    protected void onDestroy() {
        // TODO (9) Make sure to close the database before leaving the Activity
        super.onDestroy();
    }

    private void init() {
        setupUiComponents();
        setupToolbar();
        setListeners();
    }

    private boolean isInputValid(){
        return mEditTextFirstName.getText().length() > 0
                && mEditTextLastName.getText().length() > 0
                && mEditTextRole.getText().length() > 0;
    }

    private void save(){
        if(isInputValid()){
            saveInDatabase();
            onBackPressed();
        } else {
            showInfoToast();
        }
    }

    private void saveInDatabase() {

        // TODO (7) Get a writable SQLiteDatabase

        // TODO (8) Insert the values from the textfields into the database
        // HINT: Make use of the ContentValues class
        // HINT: Column names are declared in the StaffTable class
    }

    private void setListeners(){
        mButtonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                save();
            }
        });
    }

    private void setupToolbar() {
        getSupportActionBar().setTitle(R.string.title_new_staff_member);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setupUiComponents(){
        mEditTextFirstName = findViewById(R.id.edt_first_name);
        mEditTextLastName = findViewById(R.id.edt_last_name);
        mEditTextRole = findViewById(R.id.edt_role);
        mButtonSave = findViewById(R.id.btn_save_member);
    }

    private void showInfoToast(){
        Toast.makeText(this, R.string.toast_error_empty_fields, Toast.LENGTH_SHORT).show();
    }
}
