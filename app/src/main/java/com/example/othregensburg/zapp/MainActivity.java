package com.example.othregensburg.zapp;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

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

        // TODO (2) Add a OnNavigationItemSelectedListener via NavigationView#setNavigationItemSelectedListener

        // TODO (3a) Within the callback a) set the menu item as active (setChecked(...))

        // TODO (3b) Within the callback b) switch to the selected fragment
        // HINT: make use of the switchFragment() method

        // TODO (3c) Within the callback c) call DrawerLayout#closeDrawers() to close the Drawer
    }

    private void switchFragment(int menuItemId) {

        // TODO (4) Get an instance of a FragmentManager

        // TODO (5) Get an instance of a FragmentTransaction

        // TODO (6) Set a custom animation for the transaction
        // HINT: Make use of R.anim.alpha_transition_in and R.anim.alpha.transition_out and FragmentTransaction#setCustomAnimations

        // TODO (7) Get the corresponding fragment for the menuItemId
        // HINT: Make use of the getFragmentById method which takes the current fragment and the menuItemId as arguments

        // TODO (8) Replace the Fragment and commit the transaction
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
