package com.pft.liuxiaofeng.nbajames.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

/**
 * @author :Little Pidding
 * @since 17-6-12.
 */

public class BaseActivity extends AppCompatActivity {
    protected ArrayList<Activity> activityList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityList.add(this);
    }

    protected void destroyActivitys(){

    }
}
