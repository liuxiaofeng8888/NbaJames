package com.pft.liuxiaofeng.nbajames.view;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * @author :Little Pidding
 * date 17-11-21.
 */

public class SpaceItemDecoration extends RecyclerView.ItemDecoration {
    int space;

    public SpaceItemDecoration(int space) {
        this.space = space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
//        outRect.left = space;
//        outRect.right = space;
        outRect.bottom = space;

        // Add top margin only for the first item to avoid double space between items
        if (parent.getChildAdapterPosition(view) == 0){
//                        outRect.top = space;
        }
    }
}
