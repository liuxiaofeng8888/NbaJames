package com.pft.liuxiaofeng.nbajames.cache;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;
import java.nio.charset.Charset;

import hui.hik.com.commonsdk.CommonUtils;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okio.Buffer;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @author :Little Pidding
 * @since 17-11-13.
 */

public class EnhancedCall<T> {
    private Context context;
    private Call<T> mcall;
    private Class dataClassName;
    //是否使用缓存 默认开启
    private boolean mUseCache = true;

    public EnhancedCall(Context context, Call<T> call) {
        this.context = context;
        mcall = call;
    }

    /**
     * Gson反序列化缓存时 需要获取到泛型的class类型
     *
     * @param className
     * @return
     */
    public EnhancedCall<T> dataClassName(Class className) {
        dataClassName = className;
        return this;
    }

    /**
     * 是否使用缓存 默认使用
     *
     * @param useCache
     * @return
     */
    public EnhancedCall<T> useCache(boolean useCache) {
        mUseCache = useCache;
        return this;
    }

    public void enqueue(final EnhancedCallback<T> enhancedCallback) {
        mcall.enqueue(new Callback<T>() {
            @Override
            public void onResponse(Call<T> call, Response<T> response) {
                enhancedCallback.onResponse(call, response);

            }

            @Override
            public void onFailure(Call<T> call, Throwable t) {
                if (!mUseCache || CommonUtils.isNetworkConnected(context)) {
                    //不用缓存 或者网络可用的情况下直接返回onFailure
                    enhancedCallback.onFailure(call, t);
                    return;
                }

                Request request = call.request();
                String url = request.url().toString();
                RequestBody requestBody = request.body();
                Charset charset = Charset.forName("UTF-8");
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(url);
                if (request.method().equals("POST")) {
                    MediaType contentType = requestBody.contentType();
                    if (contentType != null) {
                        charset = contentType.charset(Charset.forName("UTF-8"));
                    }
                    Buffer buffer = new Buffer();
                    try {
                        requestBody.writeTo(buffer);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    stringBuilder.append(buffer.readString(charset));
                    buffer.close();
                }

                String cache = CacheManager.getInstance(context).getCache(stringBuilder.toString());
                Log.d(CacheManager.TAG, "get cache->" + cache);

                if (!TextUtils.isEmpty(cache) && dataClassName != null) {
                    Object obj = new Gson().fromJson(cache,dataClassName);
                    if (obj!=null){
                        enhancedCallback.onGetCache((T) obj);
                        return;
                    }
                }

                enhancedCallback.onFailure(call,t);
                Log.d(CacheManager.TAG, "onFailure->" + t.getMessage());
            }
        });
    }
}
