package com.pft.liuxiaofeng.nbajames.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.pft.liuxiaofeng.nbajames.R;
import com.pft.liuxiaofeng.nbajames.bean.TeamInfoDetail;
import com.pft.liuxiaofeng.nbajames.services.RxRequest;
import com.pft.liuxiaofeng.nbajames.utils.Constant;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class TeamInfoDetailActivity extends BaseActivity {
    private Intent intent;
    private int teamId; //球队的id号
    private TextView teamFullName;//球队全称
    private TextView teamIntro;//球队介绍
    private TextView teamFoundYear;//建队时间
    private TextView teamLink;//球队网站链接
    private TextView teamPlayers;//球队成员
    private TextView teamStadiumsInfo;//体育馆信息

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_info_detail);
        intent = getIntent();
        teamId = intent.getIntExtra("id", -999);
        getData();
    }

    @Override
    protected void intView() {

    }

    /**
     * 从网络获取球队信息数据
     */
    private void getData() {
        Observable<TeamInfoDetail> observable = RxRequest.createGsonRequest().getTeamInfoDetail(key, teamId);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<TeamInfoDetail>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }
                    @Override
                    public void onNext(TeamInfoDetail value) {
                        if (Constant.SUCCESS.equals(value.getReason())){

                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("error", e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
