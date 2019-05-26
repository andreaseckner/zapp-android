package com.example.othregensburg.zapp;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.othregensburg.zapp.db.StaffDatabase;
import com.example.othregensburg.zapp.db.StaffTable;

public class NewStaffMemberActivty extends AppCompatActivity {

    private Button mButtonSave;
    private StaffDatabase mStaffDatabase;
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

        mStaffDatabase = new StaffDatabase(this);
        init();
    }

    @Override
    protected void onDestroy() {
        mStaffDatabase.close();
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

        SQLiteDatabase db = mStaffDatabase.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(StaffTable.FIRST_NAME, mEditTextFirstName.getText().toString());
        contentValues.put(StaffTable.LAST_NAME, mEditTextLastName.getText().toString());
        contentValues.put(StaffTable.ROLE, mEditTextRole.getText().toString());

        db.insert(StaffTable.TABLE_NAME, null, contentValues);

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
