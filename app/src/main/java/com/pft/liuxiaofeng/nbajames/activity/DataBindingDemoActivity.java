package com.pft.liuxiaofeng.nbajames.activity;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.pft.liuxiaofeng.nbajames.R;
import com.pft.liuxiaofeng.nbajames.databinding.ActivityDataBindingDemoBinding;
import com.pft.liuxiaofeng.nbajames.databindingvm.DatabindingDemoVm;

public class DataBindingDemoActivity extends BaseActivity {
    private Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    @Override
    protected void initView() {
        activity = this;
        DatabindingDemoVm demoVm = new DatabindingDemoVm(activity);
        ActivityDataBindingDemoBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_data_binding_demo);
        binding.setData(demoVm);
    }
}
