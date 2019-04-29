package com.example.othregensburg.zapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        setupUiComponents();
        setupToolbar();
    }

    private void setupUiComponents() {
        mToolbar = findViewById(R.id.main_toolbar);
    }

    private void setupToolbar() {
        setSupportActionBar(mToolbar);
    }
}
