package com.pft.liuxiaofeng.nbajames;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.pft.liuxiaofeng.nbajames.activity.BaseActivity;
import com.pft.liuxiaofeng.nbajames.bean.AllTeamInfo;
import com.pft.liuxiaofeng.nbajames.fragment.NbaFragment;
import com.pft.liuxiaofeng.nbajames.services.RxRequest;
import com.pft.liuxiaofeng.nbajames.utils.CommonUtils;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends BaseActivity implements View.OnClickListener{
    private Button btnNbaInfo;
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("jni",stringFromJNI()+"jni");
        CommonUtils.showToast(this,stringFromJNI());
        initFragment();
    }

    @Override
    protected void intView() {
        btnNbaInfo = (Button) findViewById(R.id.btn_nba_info);
    }

    @Override
    protected void setListener() {
        btnNbaInfo.setOnClickListener(this);
    }

    private void initFragment(){
        FragmentManager fragmentManager =getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        NbaFragment nbaFragment = new NbaFragment();
//        transaction.add(R.id.rl_container,nbaFragment);
        transaction.commit();
    }

    /**
     * A native method that is implemented by the 'native-lib.cpp' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_nba_info:

                break;
            default:
                break;
        }
    }
}
