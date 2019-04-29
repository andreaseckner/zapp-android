package com.example.othregensburg.zapp;

import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.othregensburg.zapp.music.view.MyMusicFragment;
import com.example.othregensburg.zapp.travelStream.view.TravelStreamFragment;

public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;

    private ActionBarDrawerToggle mDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    private void init() {
        setupUiComponents();
        setupToolbar();
        setupDrawerToggle();
        setupNavigationDrawer();
        switchFragment(R.id.menu_nav_item_travel_stream);
    }

    private void setupUiComponents() {
        mToolbar = findViewById(R.id.main_toolbar);
        mDrawerLayout = findViewById(R.id.main_drawer_layout);
        mNavigationView = findViewById(R.id.main_navigation_view);

    }

    private void setupToolbar() {
        setSupportActionBar(mToolbar);
    }

    private void setupDrawerToggle() {
        mDrawerToggle = new ActionBarDrawerToggle(this,
                mDrawerLayout, mToolbar, R.string.open_drawer_accessibility_desc,
                R.string.close_drawer_accessibility_desc);
        mDrawerLayout.addDrawerListener(mDrawerToggle);
    }

    private void setupNavigationDrawer() {
        // Check the first item in the NavigationView
        mNavigationView.getMenu().getItem(0).setChecked(true);

        // Once a menu item is selected replace fragment
        mNavigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        menuItem.setChecked(true);
                        switchFragment(menuItem.getItemId());
                        mDrawerLayout.closeDrawers();
                        return true;
                    }
                });
    }

    private void switchFragment(int menuItemId) {

        // Get FragmentManager
        FragmentManager fragmentManager = getSupportFragmentManager();
        // Start transaction
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        // Set custom animation
        fragmentTransaction.setCustomAnimations(R.anim.alpha_transition_in, R.anim.alpha_transition_out);
        // Get the current fragment which is in the container
        Fragment containerFragment = fragmentManager.findFragmentById(R.id.main_container);
        // Init the new fragment
        Fragment newFragment = getFragmentById(containerFragment, menuItemId);
        // If returned fragment != null -> replace it
        if (newFragment != null) {
            fragmentTransaction.replace(R.id.main_container, newFragment);
            fragmentTransaction.commit();
        }
    }

    private Fragment getFragmentById(Fragment containerFragment, int menuItemId) {
        switch (menuItemId) {
            case R.id.menu_nav_item_travel_stream:
                // Check if fragment is already there - prevent unnecessary replacement
                if (!(containerFragment instanceof TravelStreamFragment))
                    return TravelStreamFragment.newInstance(getString(R.string.nav_item_title_travel_stream));
                break;
            case R.id.menu_nav_items_music:
                if (!(containerFragment instanceof MyMusicFragment))
                    return MyMusicFragment.newInstance(getString(R.string.nav_item_title_my_music));
                break;
            default:
                return null;
        }
        // Return null if no change should occur
        return null;
    }
}
