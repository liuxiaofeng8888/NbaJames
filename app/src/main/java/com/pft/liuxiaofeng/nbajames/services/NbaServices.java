package com.pft.liuxiaofeng.nbajames.services;

import com.pft.liuxiaofeng.nbajames.bean.AllTeamInfo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by LittlePudding on 17-6-12.
 */

public interface NbaServices {
    @GET("/nba/all_team_info.php?key=bff90bfa2891ccb24c021931ea874b80")
    Call<String> getAllTeamInfo();
}
