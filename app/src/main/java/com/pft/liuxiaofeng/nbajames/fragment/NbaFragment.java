package com.pft.liuxiaofeng.nbajames.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bartoszlipinski.recyclerviewheader2.RecyclerViewHeader;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.pft.liuxiaofeng.nbajames.R;
import com.pft.liuxiaofeng.nbajames.adapter.NbaInfoAdapter;
import com.pft.liuxiaofeng.nbajames.bean.AllTeamInfo;
import com.pft.liuxiaofeng.nbajames.services.RxRequest;
import com.pft.liuxiaofeng.nbajames.utils.Constant;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;

import cn.trinea.android.view.autoscrollviewpager.AutoScrollViewPager;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @author :Little Pidding
 * @since 17-6-30.
 */

public class NbaFragment extends BaseFragment {
    private RecyclerView rv;
    private View rootView;
    private Activity activity;
    private RecyclerViewHeader recyclerViewHeader;
    private AutoScrollViewPager autoScrollViewPager;
    private ArrayList<AllTeamInfo.ResultBean.TeamInfoBean> data = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        activity = getActivity();
        rootView = inflater.inflate(R.layout.fragment_nba, container, false);
        initView();
        getData();
        recyclerViewHeader.attachTo(rv);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }


    @Override
    public void onResume() {
        super.onResume();


    }

    /**
     * 发出网络请求获取nba数据
     */
    private void getData() {
        Observable<String> observable = RxRequest.createStringRequest(activity.getApplicationContext()).getAllTeamInfo(key);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String value) {
                        Gson gson = new Gson();
                        JsonObject json = gson.fromJson(value, JsonObject.class);
                        Object result = json.get("result");
                        String str = gson.toJson(result);
                        Type type = new TypeToken<HashMap<String, AllTeamInfo.ResultBean.TeamInfoBean>>() {
                        }.getType();
                        HashMap<String, AllTeamInfo.ResultBean.TeamInfoBean> info =
                                gson.fromJson(str, type);
//                        Log.e("data",info.get("1").getName());
                        for (int i = 1; i <= 30; i++) {
                            if (i == 3) continue;
                            AllTeamInfo.ResultBean.TeamInfoBean teamInfoBean =
                                    new AllTeamInfo.ResultBean.TeamInfoBean();
                            // TODO: 17-7-5 将服务器获取到的数据解析并封装进对象中
                            teamInfoBean.setName(info.get(i + "").getName());
                            teamInfoBean.setIntro(info.get(i + "").getIntro());
                            teamInfoBean.setId(info.get(i + "").getId());
                            data.add(teamInfoBean);
                            rv.setAdapter(new NbaInfoAdapter(data, activity));
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("error", e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void onPause() {
        super.onPause();
        autoScrollViewPager.stopAutoScroll();
    }


    @Override
    void initView() {
        rv = (RecyclerView) rootView.findViewById(R.id.rv_nba_info);
        rv.setLayoutManager(new LinearLayoutManager(activity));
        rv.addItemDecoration(new DividerItemDecoration(activity, DividerItemDecoration.VERTICAL));
        rv.setAdapter(new NbaInfoAdapter(data, activity));
        tvToolbar = (TextView) rootView.findViewById(R.id.tv_toolbar);
        initToolbar(tvToolbar);
        recyclerViewHeader = (RecyclerViewHeader) rootView.findViewById(R.id.recyclerView_header);
        autoScrollViewPager = (AutoScrollViewPager) rootView.findViewById(R.id.autoScrollViewPager);

        autoScrollViewPager.setAdapter(new myPagerAdapter());
        autoScrollViewPager.startAutoScroll(3000);
        autoScrollViewPager.setInterval(3000);
        autoScrollViewPager.setDirection(AutoScrollViewPager.RIGHT);
        autoScrollViewPager.setCycle(true);
        autoScrollViewPager.setScrollDurationFactor(20);
        autoScrollViewPager.setStopScrollWhenTouch(true);
        autoScrollViewPager.setSlideBorderMode(AutoScrollViewPager.SLIDE_BORDER_MODE_CYCLE);
        autoScrollViewPager.setBorderAnimation(false);

        autoScrollViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
//                UIUtils.showToast("" + position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    void initToolbar(TextView tvToolbar) {
        tvToolbar.setText("NBA");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("onDestroy", "invoke");
    }

    @Override
    public void onClick(View v) {

    }


    private class myPagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return 5;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = View.inflate(activity, R.layout.image_view, null);
            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
    }
}
