package com.example.othregensburg.zapp;

import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;

    private ActionBarDrawerToggle mDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    // TODO(2) Add onPostCreate method to sync the drawer toggle state

    private void init() {
        setupUiComponents();
        setupToolbar();
        setupDrawerToggle();
    }

    private void setupUiComponents() {
        mToolbar = findViewById(R.id.main_toolbar);
        mDrawerLayout = findViewById(R.id.main_drawer_layout);
    }

    private void setupToolbar() {
        setSupportActionBar(mToolbar);
    }

    private void setupDrawerToggle() {
        // TODO (1) Add ActionBarDrawerToggle and assign it to the drawer layout listener
    }
}
