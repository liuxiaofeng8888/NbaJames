package com.pft.liuxiaofeng.nbajames.databindingvm;

import android.app.Activity;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.graphics.Color;
import android.view.View;

import com.pft.liuxiaofeng.nbajames.bean.DataBindingModule;

import hui.hik.com.commonsdk.CommonUtils;

/**
 * Created by liuxiaofeng on 17-12-15.
 */

public class DatabindingDemoVm {
    private Activity activity;
//    public final ObservableField<String> buttonText = new ObservableField<>();
    public ObservableArrayList<String> dataList = new ObservableArrayList<>();
//    public ObservableInt buttonColor = new ObservableInt();
//    public ObservableField<Integer> textSize = new ObservableField<>();

    public DatabindingDemoVm(Activity activity) {
        this.activity = activity;
        DataBindingModule module = new DataBindingModule();
//        module.setButtonText("我是一个button");
//        module.setButtonColor(Color.BLUE);
//        module.setTextSize(20);
//        textSize.set(module.getTextSize());
//        buttonColor.set(module.getButtonColor());
//        buttonText.set(module.getButtonText());
        for (int i = 0; i < 20; i++) {
            dataList.add("data"+i);
        }
    }

    public void toast(View view){
        CommonUtils.showLongToast(activity,"button点击了");
    }
}
