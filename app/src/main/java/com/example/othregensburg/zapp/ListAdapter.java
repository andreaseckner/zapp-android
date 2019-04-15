package com.example.othregensburg.zapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.Locale;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private final LinkedList<String> mList;
    private SparseBooleanArray mItemStateArray = new SparseBooleanArray();

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

        if (!mItemStateArray.get(position, false)) {
            viewHolder.mCheckBox.setChecked(false);
        } else {
            viewHolder.mCheckBox.setChecked(true);
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        final CheckBox mCheckBox;

        ViewHolder(@NonNull final View itemView) {
            super(itemView);

            mCheckBox = itemView.findViewById(R.id.checkbox);
            mCheckBox.setOnClickListener(this);
        }

        @Override
        public void onClick(final View v) {

            final Boolean mCheckboxState = mCheckBox.isChecked();

            int adapterPosition = getAdapterPosition();
            mItemStateArray.put(adapterPosition, mCheckboxState);

            Toast.makeText(v.getContext(),
                    String.format(Locale.GERMAN, "Position: %d is checked: %s",
                            getLayoutPosition(), mCheckboxState),
                    Toast.LENGTH_SHORT)
                    .show();
        }
    }
}
