package com.pft.liuxiaofeng.nbajames.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.pft.liuxiaofeng.nbajames.R;

/**
 * created by liuxiaofeng
 * date:2017-10-23
 * nfc功能实现
 */
public class NfcActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nfc);
        handleIntent(getIntent());
    }


    @Override
    protected void initView() {

    }

    @Override
    protected void initToolbar(TextView tvToolbar) {

    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        handleIntent(intent);
    }

    private void handleIntent(Intent intent){
        Log.d(TAG, "handleIntent: " + intent.getAction());
    }
}
