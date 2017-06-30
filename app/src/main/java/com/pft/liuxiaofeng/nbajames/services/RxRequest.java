package com.pft.liuxiaofeng.nbajames.services;

import android.support.annotation.Nullable;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author :Little Pidding
 * @since 17-6-26.
 */

public class RxRequest {

    public static final String baseUrl="http://v.juhe.cn/";//后台访问的地址

    /**
     *封装retrofit
     * @return retrofit的调用方法的接口
     */
    public static NbaServices createRequest(){
        OkHttpClient client = new OkHttpClient.Builder()
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
}
