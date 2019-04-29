package hui.hik.com.commonsdk;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;


import java.util.ArrayList;

import io.reactivex.disposables.CompositeDisposable;


/**
 * Created by LittlePudding on 17-6-12.
 */

public abstract class BaseActivity extends AppCompatActivity {
    protected String TAG;
    protected String key = "bff90bfa2891ccb24c021931ea874b80";
    protected String baseUrl = "http://v.juhe.cn/";
    protected ArrayList<Activity> activityList = new ArrayList<>();
    protected Activity activity;
    protected CompositeDisposable compositeDisposable = new CompositeDisposable();
    protected TextView tvToolbar;
    protected Toolbar toolbar;
    private FrameLayout container;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        ViewServer.get(this).addWindow(this);
        View view = View.inflate(this,R.layout.base_layout_activity,null);
        container = findViewById(R.id.container);
        setContentView(view);
        TAG = getClass().getSimpleName();
        activity = this;
        Log.d(TAG, "onCreat！");
        activityList.add(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
//        ViewServer.get(this).setFocusedWindow(this);
    }

    protected abstract void initView();

    protected void setListener() {

    }

    //一般用于没有返回的Fragment
    protected  void initToolbar(TextView tvToolbar){

    };

    //有返回按钮 需要设置toolbar的点击事件,或者设置toolbar的title
    protected void initToolbar(Toolbar toolbar,TextView tvToolbar){
        setSupportActionBar(toolbar); //用toolbar替换之前的ActionBar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //必须先调用方法setSupportActionBar(toolbar)
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        tvToolbar.setText(""); //toolbar的tittle居中显示
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        ViewServer.get(this).removeWindow(this);
    }
}
