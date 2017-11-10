package com.pft.liuxiaofeng.nbajames.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import io.reactivex.disposables.CompositeDisposable;

/**
 * @author :Little Pidding
 * @since 17-6-30.
 */

abstract class BaseFragment extends Fragment implements View.OnClickListener{
    protected String TAG;
    protected String key = "bff90bfa2891ccb24c021931ea874b80";
    protected String baseUrl = "http://v.juhe.cn/";
    protected CompositeDisposable compositeDisposable = new CompositeDisposable();
    protected TextView tvToolbar;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TAG = getClass().getSimpleName();
        Log.d(TAG,"oncreate!");
    }

    abstract void initView();

    abstract void initToolbar(TextView tvToolbar);

    protected void setListener(){}
}
