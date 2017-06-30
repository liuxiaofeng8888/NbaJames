package com.pft.liuxiaofeng.nbajames.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pft.liuxiaofeng.nbajames.R;
import com.pft.liuxiaofeng.nbajames.bean.AllTeamInfo;

import java.util.ArrayList;

/**
 * @author :Little Pidding
 * @since 17-6-30.
 */

public class NbaInfoAdapter extends RecyclerView.Adapter<NbaInfoAdapter.ViewHolder> {

    private ArrayList<AllTeamInfo> data;
    private Activity activity;

    public NbaInfoAdapter(ArrayList<AllTeamInfo> data, Activity activity) {
        this.data = data;
        this.activity = activity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(activity,R.layout.item_info,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tvName.setText("");
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvName;
        public ViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
        }
    }
}
