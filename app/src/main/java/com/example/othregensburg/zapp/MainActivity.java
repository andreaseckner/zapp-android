package com.example.othregensburg.zapp;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private static final String COUNTER = "counter";

    private TextView mTextView;
    private Integer mCounter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = findViewById(R.id.counterTextView);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

        mCounter = prefs.getInt(COUNTER, 1);
        mTextView.setText(String.format(Locale.GERMAN, "%d", mCounter));

        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(COUNTER, ++mCounter);
        editor.apply();

    }
}
