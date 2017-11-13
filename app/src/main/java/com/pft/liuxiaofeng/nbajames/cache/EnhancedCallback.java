package com.pft.liuxiaofeng.nbajames.cache;


import retrofit2.Call;
import retrofit2.Response;

/**
 * @author :Little Pidding
 * @since 17-11-13.
 */

public interface EnhancedCallback<T> {

    void onResponse(Call<T> call, Response response);

    void onFailure(Call<T> call,Throwable t);

    void onGetCache(T t);
}
