package com.example.othregensburg.zapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private final LinkedList<String> mList = new LinkedList<>();

    // TODO (4) Create a new class for the adapter which extends from RecyclerView.Adapter<CustomAdapter.ViewHolder>


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Random rnd = new Random();
        for (int i = 0; i < 50; i++)
            mList.add(((char) ('A' + rnd.nextInt('Z' - 'A'))) + " " + Integer.toString(i));
        Collections.sort(mList);

        // TODO (5) Create member variables and instantiate the Recycler View and the Adapter

        // TODO (6) Set the new Adapter to the Recycler View

        // TODO (7) Set a LayoutManager to the Recycler View
    }
}
