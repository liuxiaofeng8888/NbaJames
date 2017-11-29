package com.pft.liuxiaofeng.nbajames.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.pft.liuxiaofeng.nbajames.R;
import com.pft.liuxiaofeng.nbajames.activity.CustomVIew;
import com.pft.liuxiaofeng.nbajames.activity.customview.PipChartVIewDIsplay;
import com.pft.liuxiaofeng.nbajames.activity.customview.WaterWaveViewDisplay;
import com.pft.liuxiaofeng.nbajames.utils.CommonUtils;
import com.pft.liuxiaofeng.nbajames.view.MyViewDemo;

/**
 * @author :Little Pidding
 * @since 17-7-11.
 */

public class MyVIewFragment extends BaseFragment {
    private View view;
    private Button btnWaterWave; //水波紋按钮
    private Button btnPipChart; //饼状图按钮
    private Button btnMyView; //我的自定义view
    private Intent intent;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_my_view, container, false);
        initView();
        setListener();
        return view;
    }

    @Override
    public void initView() {
        tvToolbar = (TextView) view.findViewById(R.id.tv_toolbar);
        btnWaterWave = (Button) view.findViewById(R.id.btn_water_wave);
        btnPipChart = (Button) view.findViewById(R.id.btn_pipchart);
        btnMyView = (Button) view.findViewById(R.id.btn_my_view);
        initToolbar(tvToolbar);
    }

    @Override
    void initToolbar(TextView tvToolbar) {
        tvToolbar.setText("控件");
    }

    @Override
    protected void setListener() {
        super.setListener();
        btnWaterWave.setOnClickListener(this);
        btnPipChart.setOnClickListener(this);
        btnMyView.setOnClickListener(this);
    }

    /**
     * 监听fragment的隐藏显示切换
     * @param hidden
     */
    @Override
    public void onHiddenChanged(boolean hidden) {

    }

    @Override
    public void onClick(View v) {
        intent = new Intent();
        switch (v.getId()) {
            case R.id.btn_water_wave:
                intent.setClass(getActivity(),WaterWaveViewDisplay.class);
                startActivity(intent);
                break;
            case R.id.btn_pipchart:
                intent.setClass(getActivity(),PipChartVIewDIsplay.class);
                startActivity(intent);
                break;
            case R.id.btn_my_view:
                intent.setClass(getActivity(),CustomVIew.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
