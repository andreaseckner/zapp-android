package com.example.othregensburg.zapp.music.controller;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.othregensburg.zapp.R;
import com.example.othregensburg.zapp.music.model.DsAlbum;

import java.util.ArrayList;

public class AlbumAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int VIEW_TYPE_HEADER = 0;
    private static final int VIEW_TYPE_ALBUM = 1;

    private LayoutInflater mInflater;
    private Context mCtx;
    private ArrayList<Object> mItems;

    public AlbumAdapter(Context context, ArrayList<Object> items) {
        mInflater = LayoutInflater.from(context);
        this.mCtx = context;
        this.mItems = items;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case VIEW_TYPE_HEADER:
                return new ViewHolderHeader(mInflater.inflate(R.layout.row_music_header, parent, false));
            case VIEW_TYPE_ALBUM:
                return new ViewHolder(mInflater.inflate(R.layout.row_music, parent, false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolder) {
            ViewHolder mHolder = (ViewHolder) holder;
            DsAlbum album = (DsAlbum) mItems.get(position);
            mHolder.mTextViewTitle.setText(album.getTitle());
            mHolder.mTextViewPerformer.setText(album.getPerformer());
            mHolder.mImageViewCover.setImageResource(album.getResIdImage());
            mHolder.mCardView.setCardBackgroundColor(album.getBackgroundColor());
        }
    }

    @Override
    public int getItemViewType(int position) {
        if(mItems.get(position) instanceof DsAlbum)
            return VIEW_TYPE_ALBUM;
        else
            return VIEW_TYPE_HEADER;
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    class ViewHolderHeader extends RecyclerView.ViewHolder {

        public ViewHolderHeader(View view) {
            super(view);
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private CardView mCardView;
        private TextView mTextViewTitle;
        private TextView mTextViewPerformer;
        private ImageView mImageViewCover;

        public ViewHolder(View view) {
            super(view);
            mCardView = (CardView) view.findViewById(R.id.row_music_card_view);
            mTextViewTitle = (TextView) view.findViewById(R.id.row_music_title);
            mTextViewPerformer = (TextView) view.findViewById(R.id.row_music_performer);
            mImageViewCover = (ImageView) view.findViewById(R.id.row_music_image);
        }
    }
}
