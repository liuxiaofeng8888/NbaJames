package com.pft.liuxiaofeng.nbajames.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.android.debug.hv.ViewServer;

import java.util.ArrayList;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by LittlePudding on 17-6-12.
 */

 public abstract class BaseActivity extends AppCompatActivity{
    protected String TAG;
    protected String key = "bff90bfa2891ccb24c021931ea874b80";
    protected String baseUrl = "http://v.juhe.cn/";
    protected ArrayList<Activity> activityList = new ArrayList<>();
    protected Activity activity;
    protected CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewServer.get(this).addWindow(this);
        TAG = getClass().getSimpleName();
        activity = this;
        Log.d(TAG,"onCreat！");
//        intView();
//        setListener();
        activityList.add(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ViewServer.get(this).setFocusedWindow(this);
    }

    protected abstract void initView();

    protected void setListener(){

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ViewServer.get(this).removeWindow(this);
    }
}
