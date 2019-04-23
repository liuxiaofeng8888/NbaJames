package com.pft.liuxiaofeng.nbajames.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import hui.hik.com.commonsdk.CommonUtils;

/**
 * Created by LittlePudding on 17-6-12.
 */

public class AllTeamInfo implements Serializable {

    /**
     * reason : success
     * result : {"1":{"id":1,"tagid":3020,"name":"凯尔特人","eng_name":"Celtics","full_name":"波士顿凯尔特人","eng_full_name":"Boston Celtics","city":"Boston","bbr":"BOS","logo":"e59350a5bc97aa5c.png","home":"TD 花园","homepage_link":"http://www.nba.com/celtics/","intro":"波士顿凯尔特人队是NBA现有30支球队之一，NBA的前身、BAA创始球队之一，1947年进入NBA，凯尔特人和尼克斯是仅有的两支参加了1946年首届BAA联赛且至今没有迁移过城市的NBA球队。","conference":"E","eng_division":"Atlantic","cn_division":"大西洋赛区","stoped":0,"chief_coach":"布拉德-史蒂文斯","found_year":1946,"players":"3450,3467,3613,3654,3658,3671,4779,4925,4926,150005,150006,150007,1137,3360,1032","stadiums":null,"team_link":"http://g.hupu.com/nba/teams/celtics","logo_link":"http://c2.hoopchina.com.cn/images/gamespace/team/e59350a5bc97aa5c.png","stadiumsInfo":[{"id":15,"name":"TD花园","eng_name":"TD Garden","city":"Boston","state":"MA","capacity":18624}]}}
     * error_code : 0
     */

    private String reason;
    private ResultBean result;
    private int error_code;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public static class ResultBean {

        /**
         * 1 : {"id":1,"tagid":3020,"name":"凯尔特人","eng_name":"Celtics","full_name":"波士顿凯尔特人","eng_full_name":"Boston Celtics","city":"Boston","bbr":"BOS","logo":"e59350a5bc97aa5c.png","home":"TD 花园","homepage_link":"http://www.nba.com/celtics/","intro":"波士顿凯尔特人队是NBA现有30支球队之一，NBA的前身、BAA创始球队之一，1947年进入NBA，凯尔特人和尼克斯是仅有的两支参加了1946年首届BAA联赛且至今没有迁移过城市的NBA球队。","conference":"E","eng_division":"Atlantic","cn_division":"大西洋赛区","stoped":0,"chief_coach":"布拉德-史蒂文斯","found_year":1946,"players":"3450,3467,3613,3654,3658,3671,4779,4925,4926,150005,150006,150007,1137,3360,1032","stadiums":null,"team_link":"http://g.hupu.com/nba/teams/celtics","logo_link":"http://c2.hoopchina.com.cn/images/gamespace/team/e59350a5bc97aa5c.png","stadiumsInfo":[{"id":15,"name":"TD花园","eng_name":"TD Garden","city":"Boston","state":"MA","capacity":18624}]}
         */

//        @SerializedName("1")
        private TeamInfoBean teamInfoBean;

        public TeamInfoBean getTeamInfoBean() {
            return teamInfoBean;
        }

        public void setTeamInfoBean(TeamInfoBean teamInfoBean) {
            this.teamInfoBean = teamInfoBean;
        }

        public static class TeamInfoBean {
            /**
             * id : 1
             * tagid : 3020
             * name : 凯尔特人
             * eng_name : Celtics
             * full_name : 波士顿凯尔特人
             * eng_full_name : Boston Celtics
             * city : Boston
             * bbr : BOS
             * logo : e59350a5bc97aa5c.png
             * home : TD 花园
             * homepage_link : http://www.nba.com/celtics/
             * intro : 波士顿凯尔特人队是NBA现有30支球队之一，NBA的前身、BAA创始球队之一，1947年进入NBA，凯尔特人和尼克斯是仅有的两支参加了1946年首届BAA联赛且至今没有迁移过城市的NBA球队。
             * conference : E
             * eng_division : Atlantic
             * cn_division : 大西洋赛区
             * stoped : 0
             * chief_coach : 布拉德-史蒂文斯
             * found_year : 1946
             * players : 3450,3467,3613,3654,3658,3671,4779,4925,4926,150005,150006,150007,1137,3360,1032
             * stadiums : null
             * team_link : http://g.hupu.com/nba/teams/celtics
             * logo_link : http://c2.hoopchina.com.cn/images/gamespace/team/e59350a5bc97aa5c.png
             * stadiumsInfo : [{"id":15,"name":"TD花园","eng_name":"TD Garden","city":"Boston","state":"MA","capacity":18624}]
             */

            private int id;
            private int tagid;
            private String name;
            private String eng_name;
            private String full_name;
            private String eng_full_name;
            private String city;
            private String bbr;
            private String logo;
            private String home;
            private String homepage_link;
            private String intro;
            private String conference;
            private String eng_division;
            private String cn_division;
            private int stoped;
            private String chief_coach;
            private int found_year;
            private String players;
            private Object stadiums;
            private String team_link;
            private String logo_link;
            private List<StadiumsInfoBean> stadiumsInfo;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getTagid() {
                return tagid;
            }

            public void setTagid(int tagid) {
                this.tagid = tagid;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getEng_name() {
                return eng_name;
            }

            public void setEng_name(String eng_name) {
                this.eng_name = eng_name;
            }

            public String getFull_name() {
                return full_name;
            }

            public void setFull_name(String full_name) {
                this.full_name = full_name;
            }

            public String getEng_full_name() {
                return eng_full_name;
            }

            public void setEng_full_name(String eng_full_name) {
                this.eng_full_name = eng_full_name;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getBbr() {
                return bbr;
            }

            public void setBbr(String bbr) {
                this.bbr = bbr;
            }

            public String getLogo() {
                return logo;
            }

            public void setLogo(String logo) {
                this.logo = logo;
            }

            public String getHome() {
                return home;
            }

            public void setHome(String home) {
                this.home = home;
            }

            public String getHomepage_link() {
                return homepage_link;
            }

            public void setHomepage_link(String homepage_link) {
                this.homepage_link = homepage_link;
            }

            public String getIntro() {
                return CommonUtils.isEmpty(intro)?"":intro;
            }

            public void setIntro(String intro) {
                this.intro = intro;
            }

            public String getConference() {
                return conference;
            }

            public void setConference(String conference) {
                this.conference = conference;
            }

            public String getEng_division() {
                return eng_division;
            }

            public void setEng_division(String eng_division) {
                this.eng_division = eng_division;
            }

            public String getCn_division() {
                return cn_division;
            }

            public void setCn_division(String cn_division) {
                this.cn_division = cn_division;
            }

            public int getStoped() {
                return stoped;
            }

            public void setStoped(int stoped) {
                this.stoped = stoped;
            }

            public String getChief_coach() {
                return chief_coach;
            }

            public void setChief_coach(String chief_coach) {
                this.chief_coach = chief_coach;
            }

            public int getFound_year() {
                return found_year;
            }

            public void setFound_year(int found_year) {
                this.found_year = found_year;
            }

            public String getPlayers() {
                return players;
            }

            public void setPlayers(String players) {
                this.players = players;
            }

            public Object getStadiums() {
                return stadiums;
            }

            public void setStadiums(Object stadiums) {
                this.stadiums = stadiums;
            }

            public String getTeam_link() {
                return team_link;
            }

            public void setTeam_link(String team_link) {
                this.team_link = team_link;
            }

            public String getLogo_link() {
                return logo_link;
            }

            public void setLogo_link(String logo_link) {
                this.logo_link = logo_link;
            }

            public List<StadiumsInfoBean> getStadiumsInfo() {
                return stadiumsInfo;
            }

            public void setStadiumsInfo(List<StadiumsInfoBean> stadiumsInfo) {
                this.stadiumsInfo = stadiumsInfo;


            }

            public static class StadiumsInfoBean {
                /**
                 * id : 15
                 * name : TD花园
                 * eng_name : TD Garden
                 * city : Boston
                 * state : MA
                 * capacity : 18624
                 */

                private int id;
                private String name;
                private String eng_name;
                private String city;
                private String state;
                private int capacity;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getEng_name() {
                    return eng_name;
                }

                public void setEng_name(String eng_name) {
                    this.eng_name = eng_name;
                }

                public String getCity() {
                    return city;
                }

                public void setCity(String city) {
                    this.city = city;
                }

                public String getState() {
                    return state;
                }

                public void setState(String state) {
                    this.state = state;
                }

                public int getCapacity() {
                    return capacity;
                }

                public void setCapacity(int capacity) {
                    this.capacity = capacity;
                }

            }
        }
    }
}
