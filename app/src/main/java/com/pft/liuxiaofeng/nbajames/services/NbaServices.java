package com.pft.liuxiaofeng.nbajames.services;

import com.pft.liuxiaofeng.nbajames.bean.AllTeamInfo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by LittlePudding on 17-6-12.
 */

public interface NbaServices {
    @GET("nba/all_team_info.php")
    Call<AllTeamInfo> getAllTeamInfo(@Query("key") String key);
}
