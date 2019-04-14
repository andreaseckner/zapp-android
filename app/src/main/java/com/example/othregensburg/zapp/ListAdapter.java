package com.example.othregensburg.zapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import java.util.LinkedList;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private final LinkedList<String> mList;

    private LayoutInflater mInflater;


    ListAdapter(Context context, LinkedList<String> list) {
        mInflater = LayoutInflater.from(context);
        this.mList = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, final int viewType) {
        View mItemView = mInflater.inflate(R.layout.listitem, parent, false);
        return new ViewHolder(mItemView);

    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int position) {
        String mCurrent = mList.get(position);
        viewHolder.mCheckBox.setText(mCurrent);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    // TODO (1) Let the ViewHolder implement a View.OnClickListener

    class ViewHolder extends RecyclerView.ViewHolder {

        final CheckBox mCheckBox;

        ViewHolder(@NonNull final View itemView) {
            super(itemView);

            mCheckBox = itemView.findViewById(R.id.checkbox);
            // TODO (2) Set the OnCLickListener to the checkboxes
        }

        // TODO (3) Show a Toast with position and state of the clicked checkbox

        // TODO (4) Fix the issue with checkbox state of the recycled views which occurs after scrolling up and down
            // Hint: Make use of a SpareBooleanArray
    }
}
