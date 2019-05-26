package com.example.othregensburg.zapp.utils;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.othregensburg.zapp.R;

public class DividerItemDecoration extends RecyclerView.ItemDecoration {
    private Drawable mDivider;
    private int mPadding;

    public DividerItemDecoration(Context context) {
        this(context, 0);
    }

    public DividerItemDecoration(Context context, int padding) {
        mDivider = ContextCompat.getDrawable(context, R.drawable.divider_default_horizontal);
        this.mPadding = padding;
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        int left = mPadding;
        int right = parent.getWidth() - mPadding;
        int childCount = parent.getChildCount();
        boolean lastIteration = false;
        for (int i = 0; i < childCount; i++) {
            if (i == childCount - 1)
                lastIteration = true;
            View child = parent.getChildAt(i);

            if(!lastIteration) {
                RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();

                int top = child.getBottom() + params.bottomMargin;
                int bottom = top + mDivider.getIntrinsicHeight();

                mDivider.setBounds(left, top, right, bottom);
                mDivider.draw(c);
            }
        }
    }
}
