package com.pft.liuxiaofeng.nbajames;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.debug.hv.ViewServer;
import hui.hik.com.commonsdk.BaseActivity;
import com.pft.liuxiaofeng.nbajames.fragment.MyVIewFragment;
import com.pft.liuxiaofeng.nbajames.fragment.NbaFragment;
import com.pft.liuxiaofeng.nbajames.fragment.PlayFragment;
import com.pft.liuxiaofeng.nbajames.services.AidlService;

/**
 * @author littlepudding
 * @date fix 2019-3-6
 * @description 主界面
 */
public class MainActivity extends BaseActivity implements View.OnClickListener {
    private Button btnNbaInfo; //NBA页面
    private Button btnMyView; //我的自定义view
    private Button btnService; //服务功能开启
    private Button btnHomePlay; //实验模块 官网实践部分
    private NbaFragment nbaFragment;
    private MyVIewFragment myVIewFragment;
    private PlayFragment playFragment;
    private IMyAidlInterface iMyAidlInterface;
    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            iMyAidlInterface = IMyAidlInterface.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setListener();
        initFragment();
        Intent intent = new Intent(activity,AidlService.class);
        bindService(intent,serviceConnection,BIND_AUTO_CREATE);
    }


    @Override
    protected void initView() {
        btnNbaInfo = (Button) findViewById(R.id.btn_nba_info);
        btnMyView = (Button) findViewById(R.id.btn_my_view);
        btnService = (Button) findViewById(R.id.btn_service);
        btnHomePlay = (Button) findViewById(R.id.btn_home_play);
    }

    @Override
    protected void setListener() {
        btnNbaInfo.setOnClickListener(this);
        btnMyView.setOnClickListener(this);
        btnService.setOnClickListener(this);
        btnHomePlay.setOnClickListener(this);
    }

    @Override
    protected void initToolbar(TextView tvToolbar) {

    }

    private void initFragment() {
        nbaFragment = new NbaFragment();
        myVIewFragment = new MyVIewFragment();
        playFragment = new PlayFragment();

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if (!myVIewFragment.isAdded()) {
            fragmentTransaction.add(R.id.fragment, myVIewFragment);
        } else {
            fragmentTransaction.show(myVIewFragment);
        }

        fragmentTransaction.commit();
        setColor(btnMyView);

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
                nbaModule(fragmentTransaction);
                break;

            case R.id.btn_my_view: //点击我的控件
                myModule(fragmentTransaction);
                break;

            case R.id.btn_service:
                try {
                    iMyAidlInterface.getCount();
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                setColor(btnService);
                break;

            case R.id.btn_home_play: //点击play进入playfragment
                palyModule(fragmentTransaction);
                break;

            default:
                break;
        }
        fragmentTransaction.commit();
    }


    /**
     * NBA模块
     * @param fragmentTransaction
     */
    private void nbaModule(FragmentTransaction fragmentTransaction) {
        if (!nbaFragment.isAdded()) {
            fragmentTransaction.add(R.id.fragment, nbaFragment);
        } else {
            fragmentTransaction.show(nbaFragment);
        }
        if (myVIewFragment.isAdded()) {
            fragmentTransaction.hide(myVIewFragment); //隐藏自定义view的Fragemnt
        }

        if (playFragment.isAdded()) {
            fragmentTransaction.hide(playFragment); //隐藏play的Fragment
        }

        setColor(btnNbaInfo);
    }

    /**
     * play模块
     * @param fragmentTransaction
     */
    private void palyModule(FragmentTransaction fragmentTransaction) {
        if (!playFragment.isAdded()){
            fragmentTransaction.add(R.id.fragment,playFragment);
        }else {
            fragmentTransaction.show(playFragment);
        }
        if (nbaFragment.isAdded()) {
            fragmentTransaction.hide(nbaFragment); //隐藏nba的Fragment
        }

        if (myVIewFragment.isAdded()) {
            fragmentTransaction.hide(myVIewFragment); //隐藏自定义view的Fragment
        }
        setColor(btnHomePlay);
    }

    /**
     * 我的模块
     * @param fragmentTransaction
     */
    private void myModule(FragmentTransaction fragmentTransaction) {
        if (!myVIewFragment.isAdded()) {
            fragmentTransaction.add(R.id.fragment, myVIewFragment);
        } else {
            fragmentTransaction.show(myVIewFragment);
        }

        if (nbaFragment.isAdded()) {
            fragmentTransaction.hide(nbaFragment); //隐藏nba的Fragment
        }

        if (playFragment.isAdded()) {
            fragmentTransaction.hide(playFragment); //隐藏play的Fragment
        }
        setColor(btnMyView);
    }

    /**
     * 设置选中按钮的字体颜色
     * @param button 选中的按钮
     */
    private void setColor(Button button){
        resetColor();
        button.setTextColor(getResources().getColor(R.color.colorAccent));
    }

    /**
     * 重设默认颜色
     */
    private void resetColor(){
        btnNbaInfo.setTextColor(getResources().getColor(R.color.colorPrimary));
        btnHomePlay.setTextColor(getResources().getColor(R.color.colorPrimary));
        btnMyView.setTextColor(getResources().getColor(R.color.colorPrimary));
        btnService.setTextColor(getResources().getColor(R.color.colorPrimary));
    }

}
