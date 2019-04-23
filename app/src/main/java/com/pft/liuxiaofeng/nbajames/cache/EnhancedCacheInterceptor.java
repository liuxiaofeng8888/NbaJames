package com.pft.liuxiaofeng.nbajames.cache;

import android.content.Context;
import android.util.Log;


import java.io.IOException;
import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;

import hui.hik.com.commonsdk.CommonUtils;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;

/**
 * @author :Little Pidding
 * @since 17-11-13.
 */

public class EnhancedCacheInterceptor implements Interceptor {
    private Context context;

    public EnhancedCacheInterceptor(Context context) {
        this.context = context;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();

        //判断有没有网络
        boolean netAvaliable = CommonUtils.isNetworkConnected(context);
        StringBuilder stringBuilder = new StringBuilder();
        Log.d(CacheManager.TAG, "netAvaliable" + netAvaliable);
        if (netAvaliable) {
            Response response = chain.proceed(request);
            String uri = request.url().toString();
            RequestBody requestBody = request.body();
            Charset charset = Charset.forName("UTF-8");

            stringBuilder.append(uri);

            if (request.method().equals("POST")) {
                MediaType contentType = requestBody.contentType();
                if (contentType != null) {
                    charset = contentType.charset(Charset.forName("UTF-8"));
                }
                Buffer buffer = new Buffer();
                requestBody.writeTo(buffer);
                stringBuilder.append(buffer.readString(charset));
                buffer.close();
                Log.d(CacheManager.TAG, "EnhancedCacheInterceptor -> key:" + stringBuilder.toString());
            }


            ResponseBody responseBody = response.body();
            MediaType contentType = responseBody.contentType();

            BufferedSource source = responseBody.source();
            source.request(Long.MAX_VALUE);
            Buffer buffer = source.buffer();
            if (contentType != null) {
                charset = contentType.charset(Charset.forName("UTF-8"));
            }
            String key = stringBuilder.toString();
            //服务器返回的json原始数据
            String json = buffer.clone().readString(charset);
            CacheManager.getInstance(context).putCache(key, json);
            Log.d(CacheManager.TAG, "put cache-> key:" + key + "-> json:" + json);
            return response
                    .newBuilder()
                    .removeHeader("Pragma")
                    //有网络时  设置缓存超过30秒
                    .header("Cache-Control", "public, max-age=" + 30)
                    .build();

        } else {
            //没有网络读取缓存
            String uri = request.url().toString();
            RequestBody requestBody = request.body();
//            Response response = chain.proceed(request);
            Charset charset = Charset.forName("UTF-8");
            stringBuilder.append(uri);
            MediaType contentType = null;
            if (request.method().equals("POST")) {
                contentType = requestBody.contentType();
                if (contentType != null) {
                    charset = contentType.charset(Charset.forName("UTF-8"));
                }
                Buffer buffer = new Buffer();
                requestBody.writeTo(buffer);
                stringBuilder.append(buffer.readString(charset));
                buffer.close();
                Log.d(CacheManager.TAG, "get cache -> key:" + stringBuilder.toString());
            }
            Log.d(CacheManager.TAG, "get cache->start");
            String cache = CacheManager.getInstance(context).getCache(stringBuilder.toString());
            Log.d(CacheManager.TAG, "get cache->" + cache);

            if (cache != null) {

                CacheControl cacheControl = new CacheControl.Builder()
                        .maxAge(30, TimeUnit.DAYS)
                        .build();

                Response response = new Response.Builder()
                        .message("OK")
                        .code(200)
                        .request(request)
                        .header("Cache-Control", cacheControl.toString())
                        .protocol(Protocol.HTTP_1_1)
                        .body(ResponseBody.create(contentType, cache))
                        .build();
                Log.d(CacheManager.TAG, "response:缓存" + response);
                return response;
            }
            return null;
            //                return chain.proceed(request);
        }
    }
}
