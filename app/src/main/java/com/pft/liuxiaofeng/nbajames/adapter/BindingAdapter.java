package com.pft.liuxiaofeng.nbajames.adapter;

import android.databinding.ObservableArrayList;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

import java.util.List;

/**
 * Created by liuxiaofeng on 17-12-19.
 */

public class BindingAdapter {

    /**
     * 设置TextView的颜色
     *
     * @param button
     * @param color
     */
    @android.databinding.BindingAdapter({"textColor"})
    public static void setTextColor(Button button, int color) {
        button.setTextColor(color);
    }

    @android.databinding.BindingAdapter({"textSize"})
    public static void setTextSize(Button button, int size) {
        button.setTextSize(size);
    }

    @android.databinding.BindingAdapter("data")
    public static void setData(RecyclerView recyclerView, ObservableArrayList<String> data) {
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(new RecyclerViewAdapter(recyclerView.getContext(), data));
    }
}
