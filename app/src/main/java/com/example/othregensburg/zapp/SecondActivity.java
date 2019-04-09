package com.example.othregensburg.zapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mTextView = findViewById(R.id.tv_second_activity);

        String text = getIntent()
                .getExtras().getCharSequence(MainActivity.PUT_EXTRA_STRING, "").toString();
        mTextView.setText(text);

    }
}
