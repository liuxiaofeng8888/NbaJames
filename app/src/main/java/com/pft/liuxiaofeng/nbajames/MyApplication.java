package com.pft.liuxiaofeng.nbajames;

import android.app.Application;
import android.content.Context;

import com.didi.virtualapk.PluginManager;

/**
 * @author :Little Pidding
 * @since 17-9-14.
 */

public class MyApplication extends Application {
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        PluginManager.getInstance(base).init();
    }
}
