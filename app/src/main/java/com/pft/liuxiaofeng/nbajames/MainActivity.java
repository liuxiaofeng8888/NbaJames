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

import com.pft.liuxiaofeng.nbajames.activity.BaseActivity;
import com.pft.liuxiaofeng.nbajames.fragment.MyVIewFragment;
import com.pft.liuxiaofeng.nbajames.fragment.NbaFragment;
import com.pft.liuxiaofeng.nbajames.fragment.PlayFragment;
import com.pft.liuxiaofeng.nbajames.services.AidlService;

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
//            iMyAidlInterface = null;
        }
    };


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
        Intent intent = new Intent(activity,AidlService.class);
        bindService(intent,serviceConnection,BIND_AUTO_CREATE);
//        try {
//            iMyAidlInterface.getCount();
//        } catch (RemoteException e) {
//            e.printStackTrace();
//        }
//        Log.e("jni",stringFromJNI()+"jni");
//        CommonUtils.showToast(this,stringFromJNI());
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

    private void initFragment() {
        nbaFragment = new NbaFragment();
        myVIewFragment = new MyVIewFragment();
        playFragment = new PlayFragment();
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

                if (playFragment.isAdded()) {
                    fragmentTransaction.hide(playFragment); //隐藏play的Fragment
                }
                break;

            case R.id.btn_service:
                try {
                    iMyAidlInterface.getCount();
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.btn_home_play:
                if (!playFragment.isAdded()){
                    fragmentTransaction.add(R.id.fragment,playFragment);
                }else {
                    fragmentTransaction.show(playFragment);
                }
                if (nbaFragment.isAdded()) {
                    fragmentTransaction.hide(nbaFragment); //隐藏nba的Fragment
                }

                if (myVIewFragment.isAdded()) {
                    fragmentTransaction.hide(myVIewFragment); //隐藏n自定义view的Fragment
                }
                break;
            default:
                break;
        }
        fragmentTransaction.commit();
    }
}
