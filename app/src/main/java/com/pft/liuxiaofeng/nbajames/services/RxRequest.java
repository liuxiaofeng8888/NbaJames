package com.pft.liuxiaofeng.nbajames.services;

import android.content.Context;
import android.support.annotation.Nullable;

import com.pft.liuxiaofeng.nbajames.cache.MyCacheInterceptor;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author :Little Pudding
 * @since 17-6-26.
 *
 * <p>addNetworkInterceptor添加的是网络拦截器，他会在在request和resposne是分别被调用一次，
 * 能够操作中间过程的响应,如重定向和重试；
 * 而addinterceptor添加的是aplication拦截器，他只会在response被调用一次，
 * 且总是只调用一次，不需要担心中间过程的响应。</p>
 */

public class RxRequest {

    public static final String baseUrl = "http://v.juhe.cn/";//后台访问的地址
    private static Context context;

    /**
     * 封装retrofit
     *
     * @return retrofit的调用方法的接口
     */
    public static NbaServices createStringRequest(Context context) {
        OkHttpClient client = new OkHttpClient.Builder()
                .cache(new Cache(new File(context.getCacheDir(), "nbaJames_cache"), 10 * 1024 * 1024))
                .addInterceptor(new MyCacheInterceptor(context))
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(new Converter.Factory() {
                    @Nullable
                    @Override
                    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
                        return new Converter<ResponseBody, Object>() {
                            @Override
                            public Object convert(ResponseBody value) throws IOException {
                                return value.string();
                            }
                        };
                    }
                })
                .addConverterFactory(GsonConverterFactory.create())  //必须放在stringConverter的后面
                .build();                                       //否则会抛出 json的IllegalState异常
        return retrofit.create(NbaServices.class);
    }

    /**
     * 封装retrofit
     *
     * @return retrofit的调用方法的接口
     */
    public static NbaServices createGsonRequest(Context context) {
        OkHttpClient client = new OkHttpClient.Builder()
                .cache(new Cache(new File(context.getCacheDir(), "nbaJames_cache2"), 10 * 1024 * 1024))
                .addInterceptor(new MyCacheInterceptor(context))
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())  //必须放在stringConverter的后面
                .build();                                       //否则会抛出 json的IllegalState异常
        return retrofit.create(NbaServices.class);
    }
}
