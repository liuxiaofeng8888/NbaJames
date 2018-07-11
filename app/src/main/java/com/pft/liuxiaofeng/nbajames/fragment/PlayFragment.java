package com.pft.liuxiaofeng.nbajames.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.didi.virtualapk.PluginManager;
import com.github.mikephil.charting.charts.LineChart;
import com.pft.liuxiaofeng.nbajames.R;
import com.pft.liuxiaofeng.nbajames.activity.BluetoothActivity;
import com.pft.liuxiaofeng.nbajames.activity.NfcActivity;

import java.io.File;

/**
 * @author :Little Pudding
 * @since 17-9-7.
 */

public class PlayFragment extends BaseFragment {
    private Activity activity;
    private View view;
    private Button button;
    private LineChart lineChart;
    private Button btnPligin;
    private Button btnNfc;
    private Button btnBluetooth;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
       view = inflater.inflate(R.layout.fragment_play,container,false);
        initView();
        return view;
    }

    @Override
    void initView() {
        button = (Button) view.findViewById(R.id.btn_auto_link);
//        lineChart = (LineChart) view.findViewById(R.id.line_chart);
        btnPligin = view.findViewById(R.id.btn_plugin);
        btnNfc = view.findViewById(R.id.btn_nfc);
        btnBluetooth = view.findViewById(R.id.btn_bluetooth);
        tvToolbar = view.findViewById(R.id.tv_toolbar);

        initToolbar(tvToolbar);
        btnBluetooth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(activity, BluetoothActivity.class));
            }
        });
        btnNfc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(activity, NfcActivity.class));
                activity.overridePendingTransition(0,0);
            }
        });
        btnPligin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pluginPath = Environment.getExternalStorageDirectory().getAbsolutePath().concat("/Test.apk");
                File plugin = new File(pluginPath);
                try {
                    PluginManager.getInstance(activity).loadPlugin(plugin);
                } catch (Exception e) {
                    e.printStackTrace();
                }

// Given "com.didi.virtualapk.demo" is the package name of plugin APK,
// and there is an activity called `MainActivity`.
                Intent intent = new Intent();
                intent.setClassName("com.didi.virtualapk.demo", "com.didi.virtualapk.demo.MainActivity");
                startActivity(intent);
            }
        });
    }

    @Override
    void initToolbar(TextView tvToolbar) {
        tvToolbar.setText("play");
    }

    @Override
    public void onClick(View v) {

    }
}
