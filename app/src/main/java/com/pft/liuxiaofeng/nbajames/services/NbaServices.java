package com.pft.liuxiaofeng.nbajames.services;

import com.pft.liuxiaofeng.nbajames.bean.AllTeamInfo;
import com.pft.liuxiaofeng.nbajames.bean.TeamInfoDetail;


import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by LittlePudding on 17-6-12.
 */

public interface NbaServices {
    //获取NBA所有球队的信息
    @GET("nba/all_team_info.php")
    Observable<String> getAllTeamInfo(@Query("key") String key);

    //获取球队的详细信息
    @GET("nba/team_info_byId.php")
    Observable<TeamInfoDetail> getTeamInfoDetail(@Query("key") String key,@Query("team_id") int id);
}
