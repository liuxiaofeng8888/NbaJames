package com.pft.liuxiaofeng.nbajames.activity.customview;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.pft.liuxiaofeng.nbajames.R;
import com.pft.liuxiaofeng.nbajames.activity.BaseActivity;
import com.pft.liuxiaofeng.nbajames.utils.CommonUtils;

/**
 * created by LittlePudding
 * 2017-11-10
 * 这是一个自定义的View,实现类似探探的水波紋效果
 */
public class WaterWaveViewDisplay extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_wave_view_display);
        CommonUtils.showToast(activity,"请点击或者滑动屏幕");
        initView();
    }

    @Override
    protected void initView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tvToolbar = (TextView) findViewById(R.id.tv_toolbar);
        initToolbar(toolbar,tvToolbar);
    }

    @Override
    protected void initToolbar(Toolbar toolbar, TextView tvToolbar) {
        toolbar.setTitle("水波紋效果展示"); //toolbar的tittle系统默认居左显示
        super.initToolbar(toolbar, tvToolbar);
    }
}
