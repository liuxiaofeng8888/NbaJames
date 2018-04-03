package com.pft.liuxiaofeng.nbajames.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.pft.liuxiaofeng.nbajames.R;
import com.pft.liuxiaofeng.nbajames.databinding.ItemDatabindingDemoBinding;

import java.util.List;

/**
 * Created by liuxiaofeng on 17-12-22.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.BindingViewHolder> {
    private ObservableArrayList<String> data;
    private Context context;
    private String TAG ="RecyclerViewAdapter";

    public RecyclerViewAdapter(Context context, ObservableArrayList<String> data) {
        this.data = data;
        this.context = context;
    }

    @Override
    public BindingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemDatabindingDemoBinding binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.item_databinding_demo, parent, false);
        return new BindingViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(BindingViewHolder holder, int position) {
        Log.e(TAG, "onBindViewHolder: "+position );
        holder.getBinding().setListName(data.get(position));
        //立即刷新界面
        holder.getBinding().executePendingBindings();
    }

    @Override
    public int getItemCount() {
        Log.e(TAG, "getItemCount: "+data.size());
        return data == null ? 0 : data.size();
    }

    static class BindingViewHolder extends RecyclerView.ViewHolder {
        private ItemDatabindingDemoBinding binding;

        public BindingViewHolder(ItemDatabindingDemoBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public ItemDatabindingDemoBinding getBinding() {
            return binding;
        }

        public void setBinding(ItemDatabindingDemoBinding binding) {
            this.binding = binding;
        }
    }
}