package com.pft.liuxiaofeng.nbajames;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;

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

public class MainActivity extends BaseActivity {
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("jni",stringFromJNI()+"jni");
        CommonUtils.showToast(this,stringFromJNI());
//        initFragment();

//        Observable<AllTeamInfo> observable =RxRequest.createRequest().getAllTeamInfo(key);
//        observable.subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<AllTeamInfo>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(AllTeamInfo value) {
//                        Log.e("data",value.getResult().toString());
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.e("error",e.toString()+"");
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });
    }

    private void initFragment(){
//        FragmentManager fragmentManager =getFragmentManager();
//        FragmentTransaction transaction = fragmentManager.beginTransaction();
//        NbaFragment nbaFragment = new NbaFragment();
//        transaction.add(R.id.rl_container,nbaFragment);
//        transaction.commit();
    }

    /**
     * A native method that is implemented by the 'native-lib.cpp' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}
