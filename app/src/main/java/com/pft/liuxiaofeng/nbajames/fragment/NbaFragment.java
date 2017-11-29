package com.pft.liuxiaofeng.nbajames.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.pft.liuxiaofeng.nbajames.R;
import com.pft.liuxiaofeng.nbajames.adapter.NbaInfoAdapter;
import com.pft.liuxiaofeng.nbajames.bean.AllTeamInfo;
import com.pft.liuxiaofeng.nbajames.services.RxRequest;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
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
    private ArrayList<AllTeamInfo.ResultBean.TeamInfoBean> data = new ArrayList<>();
    private List<Integer> images = new ArrayList<>();//图片集合  ;
    private List<String> imagesTitle = new ArrayList<>();//图片标题集合  ;
    private NbaInfoAdapter nbaInfoAdapter;
//    private int[] images = {R.drawable.bg_home};//图片集合  ;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_nba, container, false);
        initView();
        activity = getActivity();
//        images.add("http://www.zbjuran.com/uploads/allimg/170725/1506053064-0.jpg");
        images.add(R.drawable.snap);
        images.add(R.drawable.mainlogo);
        imagesTitle.add("标无管理");
        imagesTitle.add("手机抄表");
//        images.add("http://www.zbjuran.com/uploads/allimg/170826/14-1FR6135245.jpg");
//        images.add("http://www.zbjuran.com/uploads/allimg/171030/2-1G030114644.jpg");
//        images.add("http://www.zbjuran.com/uploads/allimg/170717/15293T939-0.jpg");
        rv.setLayoutManager(new LinearLayoutManager(activity));
        getData();
        //横向布局
//        GridLayoutManager gridLayoutManager = new GridLayoutManager(activity,4);
//        rv.setLayoutManager(gridLayoutManager);
//        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
//            @Override
//            public int getSpanSize(int position) {
//                return nbaInfoAdapter.isTittle(position) ? 4 : 1; //如果是headerview  一个item显示4列
//            }
//        });
        rv.addItemDecoration(new DividerItemDecoration(activity, DividerItemDecoration.VERTICAL));
        AllTeamInfo.ResultBean.TeamInfoBean teamInfoBean = new AllTeamInfo.ResultBean.TeamInfoBean();
        teamInfoBean.setCity("this is title:1");
        data.add(0, teamInfoBean);
        Log.e(TAG,"oncreateview");
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

                            nbaInfoAdapter = new NbaInfoAdapter(data, images,imagesTitle, activity);
                            rv.setAdapter(nbaInfoAdapter);
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
    }


    @Override
    void initView() {
        rv = (RecyclerView) rootView.findViewById(R.id.rv_nba_info);
        tvToolbar = (TextView) rootView.findViewById(R.id.tv_toolbar);
        initToolbar(tvToolbar);
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
}
