package com.pft.liuxiaofeng.nbajames.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

import com.pft.liuxiaofeng.nbajames.IMyAidlInterface;

/**
 * @author :Little Pudding
 * @since 17-8-31.
 */

public class AidlService extends Service {

    private final IMyAidlInterface.Stub myAidlInterface = new IMyAidlInterface.Stub() {
        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }

        @Override
        public void getCount() throws RemoteException {
            Log.e("service","调用了");
//            CommonUtils.showToast(getApplicationContext(),"AIDL功能调用!");
        }

    };


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return myAidlInterface;
    }
}
