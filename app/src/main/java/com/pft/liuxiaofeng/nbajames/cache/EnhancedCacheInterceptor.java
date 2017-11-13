package com.pft.liuxiaofeng.nbajames.cache;

import android.util.Log;

import java.io.IOException;
import java.nio.charset.Charset;

import okhttp3.Interceptor;
import okhttp3.MediaType;
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
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Response response = chain.proceed(request);

        String uri = request.url().toString();
        RequestBody requestBody = request.body();
        Charset charset = Charset.forName("UTF-8");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(uri);

        if (request.method().equals("POST")){
            MediaType contentType = requestBody.contentType();
            if (contentType !=null){
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
        if (contentType !=null){
            charset = contentType.charset(Charset.forName("UTF-8"));
        }
        String key = stringBuilder.toString();
        //服务器返回的json原始数据
        String json = buffer.clone().readString(charset);
        Log.d(CacheManager.TAG, "put cache-> key:" + key + "-> json:" + json);
        return chain.proceed(request);
    }
}
