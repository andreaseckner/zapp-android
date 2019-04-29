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
        // TODO (5) Get a reference of the toolbar
    }

    private void setupToolbar() {
        // TODO (6) Set toolbar as ActionBar (setSupportActionBar)
    }
}
