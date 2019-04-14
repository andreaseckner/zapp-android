package com.example.othregensburg.zapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private final LinkedList<String> mList = new LinkedList<>();

    private RecyclerView mRecyclerView;
    private ListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Random rnd = new Random();
        for (int i = 0; i < 50; i++)
            mList.add(((char) ('A' + rnd.nextInt('Z' - 'A'))) + " " + Integer.toString(i));
        Collections.sort(mList);

        mRecyclerView = findViewById(R.id.recyclerview);
        mAdapter = new ListAdapter(this, mList);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
