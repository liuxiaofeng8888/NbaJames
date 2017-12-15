package com.pft.liuxiaofeng.nbajames.databindingvm;

import android.app.Activity;
import android.databinding.ObservableField;
import android.view.View;

import com.pft.liuxiaofeng.nbajames.bean.DataBindingModule;
import com.pft.liuxiaofeng.nbajames.utils.CommonUtils;

/**
 * Created by liuxiaofeng on 17-12-15.
 */

public class DatabindingDemoVm {
    private Activity activity;
    public final ObservableField<String> buttonText = new ObservableField<>();


    public DatabindingDemoVm(Activity activity) {
        this.activity = activity;
        DataBindingModule module = new DataBindingModule();
        module.setButtonText("我是一个button");
        buttonText.set(module.getButtonText());
    }

    public void toast(View view){
        CommonUtils.showLongToast(activity,"button点击了");
    }
}
