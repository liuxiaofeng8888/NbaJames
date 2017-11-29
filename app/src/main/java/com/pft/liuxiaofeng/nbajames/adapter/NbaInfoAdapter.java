package com.pft.liuxiaofeng.nbajames.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pft.liuxiaofeng.nbajames.R;
import com.pft.liuxiaofeng.nbajames.activity.TeamInfoDetailActivity;
import com.pft.liuxiaofeng.nbajames.bean.AllTeamInfo;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :Little Pidding
 * @since 17-6-30.
 */

public class NbaInfoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_IMAGE = 0;
    private static final int TYPE_GROUP = 1;
    private List<Integer> images ;
    private List<String> imagesTitle ;
    private ArrayList<AllTeamInfo.ResultBean.TeamInfoBean> data;
    private Activity activity;

    public boolean isTittle(int position) {
        Log.e("data",data.get(position).getCity()+"");
        if (data.get(position).getCity()!=null) {
            if (data.get(position).getCity().startsWith("this is title:")) {
                return true;
            }
        }
        return false;
    }

    public NbaInfoAdapter(ArrayList<AllTeamInfo.ResultBean.TeamInfoBean> data, List<Integer> images,List<String> imagesTitle, Activity activity) {
        this.data = data;
        this.activity = activity;
        this.images = images;
        this.imagesTitle = imagesTitle;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case TYPE_IMAGE:
                ViewGroup vImage = (ViewGroup) View.inflate(activity, R.layout.item_info, null);
                ViewHolder vhImage = new ViewHolder(vImage);
                return vhImage;
            case TYPE_GROUP:
                ViewGroup view = (ViewGroup) View.inflate(activity, R.layout.you, null);
                return new GroupViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        switch (holder.getItemViewType()) {
            case TYPE_IMAGE:
                ViewHolder imageViewHolder = (ViewHolder) holder;
//                imageViewHolder.mImage.setImageResource ( );
                imageViewHolder.tvName.setText(data.get(position).getName());
                imageViewHolder.tvIntro.setText(data.get(position).getIntro());
                imageViewHolder.llItem.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent();
                        intent.setClass(activity, TeamInfoDetailActivity.class);
                        intent.putExtra("id", data.get(position).getId());
                        activity.startActivity(intent);
                    }
                });
                break;
            case TYPE_GROUP:
                GroupViewHolder groupViewHolder = (GroupViewHolder) holder;
                groupViewHolder.banner.setBannerStyle(BannerConfig.NUM_INDICATOR_TITLE);
                //设置图片加载器
                groupViewHolder.banner.setImageLoader(new GlideImageLoader());
                //设置图片集合
                groupViewHolder.banner.setImages(images);
                //设置动画效果
                groupViewHolder.banner.setBannerAnimation(Transformer.DepthPage);
                //设置轮播时间
                groupViewHolder.banner.setDelayTime(3000);
                //设置自动轮播，默认为true
                groupViewHolder.banner.isAutoPlay(true);
                //设置指示器位置（当banner模式中有指示器时）
                groupViewHolder.banner.setIndicatorGravity(BannerConfig.CENTER);
                //设置标题集合（当banner样式有显示title时）
                groupViewHolder.banner.setBannerTitles(imagesTitle);

                //banner设置方法全部调用完毕时最后调用
                groupViewHolder.banner.start();
                break;
        }
//        Log.e("name", data.get(position).getIntro() + ".");
//        holder.tvName.setText(data.get(position).getName());
//        holder.tvIntro.setText(data.get(position).getIntro());
//
//        holder.llItem.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent();
//                intent.setClass(activity, TeamInfoDetailActivity.class);
//                intent.putExtra("id", data.get(position).getId());
//                activity.startActivity(intent);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public int getItemViewType(int position) {
        int viewType;
        Log.e("view", isTittle(position) + "");
        if (!isTittle(position)) {
            viewType = TYPE_IMAGE;
        } else {
            viewType = TYPE_GROUP;
        }
        return viewType;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
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

    public class GroupViewHolder extends RecyclerView.ViewHolder {
        Banner banner;

        public GroupViewHolder(View itemView) {
            super(itemView);
            banner = (Banner) itemView.findViewById(R.id.banner);
        }

    }

}
