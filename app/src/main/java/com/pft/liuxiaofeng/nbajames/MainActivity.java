package com.pft.liuxiaofeng.nbajames;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.pft.liuxiaofeng.nbajames.activity.BaseActivity;
import com.pft.liuxiaofeng.nbajames.fragment.MyVIewFragment;
import com.pft.liuxiaofeng.nbajames.fragment.NbaFragment;
import com.pft.liuxiaofeng.nbajames.services.AidlService;

public class MainActivity extends BaseActivity implements View.OnClickListener {
    private Button btnNbaInfo; //NBA页面
    private Button btnMyView; //我的自定义view
    private NbaFragment nbaFragment;
    private MyVIewFragment myVIewFragment;


    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setListener();
        initFragment();
//        Log.e("jni",stringFromJNI()+"jni");
//        CommonUtils.showToast(this,stringFromJNI());
    }

    @Override
    protected void initView() {
        btnNbaInfo = (Button) findViewById(R.id.btn_nba_info);
        btnMyView = (Button) findViewById(R.id.btn_my_view);
    }

    @Override
    protected void setListener() {
        btnNbaInfo.setOnClickListener(this);
        btnMyView.setOnClickListener(this);
    }

    private void initFragment() {
        nbaFragment = new NbaFragment();
        myVIewFragment = new MyVIewFragment();
    }


    /**
     * A native method that is implemented by the 'native-lib.cpp' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();

    @Override
    public void onClick(View v) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        switch (v.getId()) {
            case R.id.btn_nba_info:
                if (!nbaFragment.isAdded()) {
                    fragmentTransaction.add(R.id.fragment, nbaFragment);
                } else {
                    fragmentTransaction.show(nbaFragment);
                }
                if (myVIewFragment.isAdded()) {
                    fragmentTransaction.hide(myVIewFragment); //隐藏自定义view的Fragemnt
                }
                break;

            case R.id.btn_my_view:
                if (!myVIewFragment.isAdded()) {
                    fragmentTransaction.add(R.id.fragment, myVIewFragment);
                } else {
                    fragmentTransaction.show(myVIewFragment);
                }

                if (nbaFragment.isAdded()) {
                    fragmentTransaction.hide(nbaFragment); //隐藏nba的Fragment
                }
                break;
            default:
                break;
        }
        fragmentTransaction.commit();
    }
}
