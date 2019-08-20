//package com.pft.liuxiaofeng.nbajames.activity.customview
//
//import android.os.Bundle
//import android.support.v7.widget.Toolbar
//import android.widget.TextView
//
//import com.pft.liuxiaofeng.nbajames.R
//import hui.hik.com.commonsdk.BaseActivity
//
//import hui.hik.com.commonsdk.CommonUtils
//
///**
// * created by LittlePudding
// * 2017-11-10
// * 这是一个自定义的View,实现类似探探的水波紋效果
// */
//class WaterWaveViewDisplay : BaseActivity() {
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_water_wave_view_display)
//        CommonUtils.showToast(activity, "请点击或者滑动屏幕")
//        initView()
//    }
//
//    override fun initView() {
//        toolbar = findViewById(R.id.toolbar)
//        tvToolbar = findViewById(R.id.tv_toolbar)
//        initToolbar(toolbar, tvToolbar)
//    }
//
//    override fun initToolbar(toolbar: Toolbar, tvToolbar: TextView) {
//        toolbar.title = "水波紋效果展示" //toolbar的tittle系统默认居左显示
//        super.initToolbar(toolbar, tvToolbar)
//    }
//}
