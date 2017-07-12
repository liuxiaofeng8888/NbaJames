package com.pft.liuxiaofeng.nbajames.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by LittlePudding on 17-6-12.
 */

 public abstract class BaseActivity extends AppCompatActivity{
    protected String TAG;
    protected String key = "bff90bfa2891ccb24c021931ea874b80";
    protected String baseUrl = "http://v.juhe.cn/";
    protected ArrayList<Activity> activityList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TAG = getClass().getSimpleName();
        Log.d(TAG,"onCreat！");
//        intView();
//        setListener();
        activityList.add(this);
    }

    protected abstract void intView();

    protected void setListener(){

    }
}
