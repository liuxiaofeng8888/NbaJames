package com.pft.liuxiaofeng.nbajames.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pft.liuxiaofeng.nbajames.R;
import com.pft.liuxiaofeng.nbajames.utils.CommonUtils;

/**
 * @author :Little Pidding
 * @since 17-7-11.
 */

public class MyVIewFragment extends BaseFragment {
    private View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_my_view,container,false);
        initView();
        return view;
    }

    @Override
    public void initView() {
        CommonUtils.showToast(getActivity(),"请点击或者滑动屏幕");
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
//            CommonUtils.showToast(getActivity(),"请点击或者滑动屏幕");
    }
}