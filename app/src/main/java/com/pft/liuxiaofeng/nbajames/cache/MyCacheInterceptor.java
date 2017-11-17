package com.pft.liuxiaofeng.nbajames.cache;

import android.app.Application;
import android.content.Context;

import com.pft.liuxiaofeng.nbajames.utils.CommonUtils;

import java.io.IOException;

import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author :Little Pidding
 * @since 17-11-10.
 */

public class MyCacheInterceptor implements Interceptor {
    private Context context;

    public MyCacheInterceptor(Context context) {
        this.context = context;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        //判断有没有网络
        boolean netAvaliable = CommonUtils.isNetworkConnected(context);
        if (netAvaliable){
            request = request.newBuilder()
                    //网络可用的话  强制从网络获取数据
                    .cacheControl(CacheControl.FORCE_NETWORK)
                    .build();
        }else {
            request = request.newBuilder()
                    //网络不可用 从缓存中获取数据
                    .cacheControl(CacheControl.FORCE_CACHE)
                    .build();
        }

        Response response = chain.proceed(request);

        if (netAvaliable){
            response = response.newBuilder()
                    .removeHeader("Pragma")
                    //有网络时  设置缓存超过1小时
                    .header("Cache-Control", "public, max-age=" + 60 * 60)
                    .build();
        }else {
            response = response.newBuilder()
                    .removeHeader("Pragma")
                    //无网络时 设置缓存一周
                    .header("Cache-Control", "public, only-if-cached, max-stale=" + 7 * 24 * 60 * 60)
                    .build();
        }
        return response;
    }
}
