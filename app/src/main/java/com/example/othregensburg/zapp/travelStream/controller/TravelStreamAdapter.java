package com.example.othregensburg.zapp.travelStream.controller;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.othregensburg.zapp.R;
import com.example.othregensburg.zapp.travelStream.model.DsTravelStream;

import java.util.List;

public class TravelStreamAdapter extends RecyclerView.Adapter<TravelStreamAdapter.ViewHolder> {

    private LayoutInflater mInflater;
    private Context mCtx;
    private List<DsTravelStream> mItems;

    public TravelStreamAdapter(Context context, List<DsTravelStream> items) {
        mInflater = LayoutInflater.from(context);
        this.mCtx = context;
        this.mItems = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(mInflater.inflate(R.layout.row_travel_stream, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        DsTravelStream travelStream = mItems.get(position);
        holder.mImageView.setImageResource(travelStream.getResId());
        holder.mTextViewTitle.setText(travelStream.getTitle());
        holder.mTextViewSubtitle.setText(travelStream.getSubtitle());
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView mImageView;
        private TextView mTextViewTitle;
        private TextView mTextViewSubtitle;

        public ViewHolder(View view) {
            super(view);
            mImageView = (ImageView) view.findViewById(R.id.row_travel_stream_image);
            mTextViewTitle = (TextView) view.findViewById(R.id.row_travel_stream_title);
            mTextViewSubtitle = (TextView) view.findViewById(R.id.row_travel_stream_subtitle);
        }
    }
}
