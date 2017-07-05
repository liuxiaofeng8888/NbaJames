package com.pft.liuxiaofeng.nbajames.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pft.liuxiaofeng.nbajames.R;
import com.pft.liuxiaofeng.nbajames.bean.AllTeamInfo;
import com.pft.liuxiaofeng.nbajames.utils.CommonUtils;

import java.util.ArrayList;

/**
 * @author :Little Pidding
 * @since 17-6-30.
 */

public class NbaInfoAdapter extends RecyclerView.Adapter<NbaInfoAdapter.ViewHolder> {

    private ArrayList<AllTeamInfo.ResultBean.TeamInfoBean> data;
    private Activity activity;

    public NbaInfoAdapter(ArrayList<AllTeamInfo.ResultBean.TeamInfoBean> data, Activity activity) {
        this.data = data;
        this.activity = activity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(activity,R.layout.item_info,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Log.e("name",data.get(position).getIntro()+".");
        holder.tvName.setText(data.get(position).getName());
        holder.tvIntro.setText(data.get(position).getIntro());

        holder.llItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CommonUtils.showToast(activity,data.get(position).getName()+"is click!");
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvName; //球队名字
        TextView tvIntro;//球队简介
        LinearLayout llItem;
        public ViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
            llItem = (LinearLayout) itemView.findViewById(R.id.ll_item);
            tvIntro = (TextView) itemView.findViewById(R.id.tv_intro);
        }
    }
}
