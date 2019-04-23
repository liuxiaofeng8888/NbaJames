package com.pft.liuxiaofeng.nbajames.activity;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.os.Bundle;

import com.pft.liuxiaofeng.nbajames.R;
import com.pft.liuxiaofeng.nbajames.databinding.ActivityDataBindingDemoBinding;

import hui.hik.com.commonsdk.BaseActivity;

public class DataBindingDemoActivity extends BaseActivity {
    private Activity activity;
    public ObservableArrayList<String> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    @Override
    protected void initView() {
        activity = this;
            ActivityDataBindingDemoBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding_demo);
//            DatabindingDemoVm demoVm = new DatabindingDemoVm(activity);
        dataList = new ObservableArrayList<>();
        for (int i = 0; i < 20; i++) {
            dataList.add("数据"+i);
        }
            binding.setData(this);
    }
}
