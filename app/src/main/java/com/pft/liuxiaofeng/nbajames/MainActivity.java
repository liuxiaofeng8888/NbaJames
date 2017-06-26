package com.pft.liuxiaofeng.nbajames;

import android.os.Bundle;
import android.util.Log;

import com.pft.liuxiaofeng.nbajames.activity.BaseActivity;
import com.pft.liuxiaofeng.nbajames.bean.AllTeamInfo;
import com.pft.liuxiaofeng.nbajames.services.RxRequest;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Observable<AllTeamInfo> observable =RxRequest.createRequest().getAllTeamInfo(key);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<AllTeamInfo>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(AllTeamInfo value) {
                        Log.e("data",value.getResult().get_$1().getName());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("error",e.toString()+"");
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
