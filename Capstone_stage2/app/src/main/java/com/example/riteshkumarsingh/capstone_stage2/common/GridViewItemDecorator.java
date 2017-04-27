package com.example.riteshkumarsingh.capstone_stage2.common;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by riteshkumarsingh on 27/04/17.
 */

public class GridViewItemDecorator extends RecyclerView.ItemDecoration {

    public int mOffset;

    public GridViewItemDecorator(){
        mOffset = 20;
    }

    public GridViewItemDecorator(int offset){
        this.mOffset = offset;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.left = mOffset;
        outRect.right = mOffset;
        outRect.top = mOffset;
        outRect.bottom = mOffset;
    }
}
