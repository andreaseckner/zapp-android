package com.example.othregensburg.zapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class StaffAdapter extends RecyclerView.Adapter<StaffAdapter.ViewHolder> {
    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mTextViewFirstName;
        private TextView mTextViewLastName;
        private TextView mTextViewRole;

        public ViewHolder(View view) {
            super(view);
            mTextViewFirstName = (TextView) view.findViewById(R.id.row_staff_first_name);
            mTextViewLastName = (TextView) view.findViewById(R.id.row_staff_last_name);
            mTextViewRole = (TextView) view.findViewById(R.id.row_staff_role);
        }
    }
    private Context mCtx;
    private LayoutInflater mInflater;
    private ArrayList<StaffMember> mItems;

    public StaffAdapter(Context context, ArrayList<StaffMember> items) {
        mInflater = LayoutInflater.from(context);
        this.mCtx = context;
        this.mItems = items;
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    @Override
    public void onBindViewHolder(StaffAdapter.ViewHolder holder, int position) {
        StaffMember member = mItems.get(position);
        holder.mTextViewFirstName.setText(member.getFirstName());
        holder.mTextViewLastName.setText(member.getLastName());
        holder.mTextViewRole.setText(member.getRole());
    }

    @Override
    public StaffAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(mInflater.inflate(R.layout.row_staff, parent, false));
    }
}
