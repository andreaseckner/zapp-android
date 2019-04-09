package com.example.othregensburg.zapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private final static String TAG = MainActivity.class.getSimpleName();
    public final static String PUT_EXTRA_STRING = "text";

    EditText mEditText;
    Button mHelloWorldButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditText = findViewById(R.id.activity_main_edit_text);
        mHelloWorldButton = findViewById(R.id.hello_world_button);

        mHelloWorldButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "Hello World!");
            }
        });
    }

    public void goToSecondActivity(View button) {
        String text = mEditText.getText().toString();

        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        intent.putExtra(PUT_EXTRA_STRING, text);
        startActivity(intent);
    }
}
