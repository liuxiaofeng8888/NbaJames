package com.pft.liuxiaofeng.nbajames.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @author :Little Pidding
 * @since 17-7-12.
 */

public class TeamInfoDetail implements Serializable{

    /**
     * reason : success
     * result : {"id":1,"tagid":3020,"name":"凯尔特人","eng_name":"Celtics","full_name":"波士顿凯尔特人","eng_full_name":"Boston Celtics","city":"Boston","bbr":"BOS","logo":"e59350a5bc97aa5c.png","home":"TD 花园","homepage_link":"http://www.nba.com/celtics/","intro":"波士顿凯尔特人队是NBA现有30支球队之一，NBA的前身、BAA创始球队之一，1947年进入NBA，凯尔特人和尼克斯是仅有的两支参加了1946年首届BAA联赛且至今没有迁移过城市的NBA球队。","conference":"E","eng_division":"Atlantic","cn_division":"大西洋赛区","stoped":0,"chief_coach":"布拉德-史蒂文斯","found_year":1946,"players":"3450,3467,3613,3654,3658,3671,4779,4925,4926,150005,150006,150007,1137,3360,1032","stadiums":null,"team_link":"http://g.hupu.com/nba/teams/celtics","logo_link":"http://c2.hoopchina.com.cn/images/gamespace/team/e59350a5bc97aa5c.png","playersInfo":[{"id":1032,"hupuid":1032,"team_id":1,"name":"大卫-李","alias":"大卫-李","eng_name":"David Lee","first_name":"David","last_name":"Lee","number":"42","position":"F/C","age":33,"birth_date":"420393600","first_year":2005,"height":81,"weight":245,"wage":"6年7954万美元，2010年夏天签，2016年夏天到期","salary":1549,"country":"美国","draft_year":2005,"draft_round":1,"draft_pick":30,"high_school":"Chaminade College Prep School","college_school":"佛罗里达大学","wingspan":213.36,"standing_reach":270.51,"contract_details":"2010-11赛季 1080万美元#2011-12赛季 934万美元#2012-13赛季 1274万美元#2013-14赛季 1388万美元#2014-15赛季 1501万美元#2015-16赛季 1549万美元","player_link":"http://g.hupu.com/nba/players/davidlee-1032.html","photo_link":"http://c2.hoopchina.com.cn/uploads/gamespace/players/7fcb9c5c085467fc63d68724db66f766.png","big_photo_link":"http://c2.hoopchina.com.cn/uploads/gamespace/players/bc2b0e790bfcfa9c967d1d876a88c441.png","positionZhName":"前锋/中锋","playerId":"1032"},{"id":150007,"hupuid":150007,"team_id":1,"name":"乔丹-米基","alias":"乔丹-米基","eng_name":"Jordan Mickey","first_name":"Jordan","last_name":"Mickey","number":"55","position":"PF","age":22,"birth_date":"773683200","first_year":2015,"height":80,"weight":235,"wage":"3年367万美元，2015年夏天签，2018年夏天到期，2017-18赛季无保障","salary":117,"country":"美国","draft_year":2015,"draft_round":2,"draft_pick":3,"high_school":"Prime Prep Academy","college_school":"路易斯安那州立大学","wingspan":221.87,"standing_reach":269.24,"contract_details":"2015-16赛季 117万美元#2016-17赛季 122万美元#2017-18赛季 128万美元","player_link":"http://g.hupu.com/nba/players/jordanmickey-150007.html","photo_link":"http://c2.hoopchina.com.cn/uploads/gamespace/players/298e4332241d5c1063194318e461ffec.png","big_photo_link":"http://c2.hoopchina.com.cn/uploads/gamespace/players/5361b8882013d46bf944c966e9143096.png","positionZhName":"大前锋","playerId":"150007"}],"stadiumsInfo":[{"id":15,"name":"TD花园","eng_name":"TD Garden","city":"Boston","state":"MA","capacity":18624}]}
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
         * playersInfo : [{"id":1032,"hupuid":1032,"team_id":1,"name":"大卫-李","alias":"大卫-李","eng_name":"David Lee","first_name":"David","last_name":"Lee","number":"42","position":"F/C","age":33,"birth_date":"420393600","first_year":2005,"height":81,"weight":245,"wage":"6年7954万美元，2010年夏天签，2016年夏天到期","salary":1549,"country":"美国","draft_year":2005,"draft_round":1,"draft_pick":30,"high_school":"Chaminade College Prep School","college_school":"佛罗里达大学","wingspan":213.36,"standing_reach":270.51,"contract_details":"2010-11赛季 1080万美元#2011-12赛季 934万美元#2012-13赛季 1274万美元#2013-14赛季 1388万美元#2014-15赛季 1501万美元#2015-16赛季 1549万美元","player_link":"http://g.hupu.com/nba/players/davidlee-1032.html","photo_link":"http://c2.hoopchina.com.cn/uploads/gamespace/players/7fcb9c5c085467fc63d68724db66f766.png","big_photo_link":"http://c2.hoopchina.com.cn/uploads/gamespace/players/bc2b0e790bfcfa9c967d1d876a88c441.png","positionZhName":"前锋/中锋","playerId":"1032"},{"id":150007,"hupuid":150007,"team_id":1,"name":"乔丹-米基","alias":"乔丹-米基","eng_name":"Jordan Mickey","first_name":"Jordan","last_name":"Mickey","number":"55","position":"PF","age":22,"birth_date":"773683200","first_year":2015,"height":80,"weight":235,"wage":"3年367万美元，2015年夏天签，2018年夏天到期，2017-18赛季无保障","salary":117,"country":"美国","draft_year":2015,"draft_round":2,"draft_pick":3,"high_school":"Prime Prep Academy","college_school":"路易斯安那州立大学","wingspan":221.87,"standing_reach":269.24,"contract_details":"2015-16赛季 117万美元#2016-17赛季 122万美元#2017-18赛季 128万美元","player_link":"http://g.hupu.com/nba/players/jordanmickey-150007.html","photo_link":"http://c2.hoopchina.com.cn/uploads/gamespace/players/298e4332241d5c1063194318e461ffec.png","big_photo_link":"http://c2.hoopchina.com.cn/uploads/gamespace/players/5361b8882013d46bf944c966e9143096.png","positionZhName":"大前锋","playerId":"150007"}]
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
        private String found_year;
        private String players;
        private Object stadiums;
        private String team_link;
        private String logo_link;
        private List<PlayersInfoBean> playersInfo;
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
            return intro;
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

        public String getFound_year() {
            return found_year;
        }

        public void setFound_year(String found_year) {
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

        public List<PlayersInfoBean> getPlayersInfo() {
            return playersInfo;
        }

        public void setPlayersInfo(List<PlayersInfoBean> playersInfo) {
            this.playersInfo = playersInfo;
        }

        public List<StadiumsInfoBean> getStadiumsInfo() {
            return stadiumsInfo;
        }

        public void setStadiumsInfo(List<StadiumsInfoBean> stadiumsInfo) {
            this.stadiumsInfo = stadiumsInfo;
        }

        public static class PlayersInfoBean {
            /**
             * id : 1032
             * hupuid : 1032
             * team_id : 1
             * name : 大卫-李
             * alias : 大卫-李
             * eng_name : David Lee
             * first_name : David
             * last_name : Lee
             * number : 42
             * position : F/C
             * age : 33
             * birth_date : 420393600
             * first_year : 2005
             * height : 81
             * weight : 245
             * wage : 6年7954万美元，2010年夏天签，2016年夏天到期
             * salary : 1549
             * country : 美国
             * draft_year : 2005
             * draft_round : 1
             * draft_pick : 30
             * high_school : Chaminade College Prep School
             * college_school : 佛罗里达大学
             * wingspan : 213.36
             * standing_reach : 270.51
             * contract_details : 2010-11赛季 1080万美元#2011-12赛季 934万美元#2012-13赛季 1274万美元#2013-14赛季 1388万美元#2014-15赛季 1501万美元#2015-16赛季 1549万美元
             * player_link : http://g.hupu.com/nba/players/davidlee-1032.html
             * photo_link : http://c2.hoopchina.com.cn/uploads/gamespace/players/7fcb9c5c085467fc63d68724db66f766.png
             * big_photo_link : http://c2.hoopchina.com.cn/uploads/gamespace/players/bc2b0e790bfcfa9c967d1d876a88c441.png
             * positionZhName : 前锋/中锋
             * playerId : 1032
             */

            private int id;
            private int hupuid;
            private int team_id;
            private String name;
            private String alias;
            private String eng_name;
            private String first_name;
            private String last_name;
            private String number;
            private String position;
            private int age;
            private String birth_date;
            private int first_year;
            private int height;
            private int weight;
            private String wage;
            private int salary;
            private String country;
            private int draft_year;
            private int draft_round;
            private int draft_pick;
            private String high_school;
            private String college_school;
            private double wingspan;
            private double standing_reach;
            private String contract_details;
            private String player_link;
            private String photo_link;
            private String big_photo_link;
            private String positionZhName;
            private String playerId;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getHupuid() {
                return hupuid;
            }

            public void setHupuid(int hupuid) {
                this.hupuid = hupuid;
            }

            public int getTeam_id() {
                return team_id;
            }

            public void setTeam_id(int team_id) {
                this.team_id = team_id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getAlias() {
                return alias;
            }

            public void setAlias(String alias) {
                this.alias = alias;
            }

            public String getEng_name() {
                return eng_name;
            }

            public void setEng_name(String eng_name) {
                this.eng_name = eng_name;
            }

            public String getFirst_name() {
                return first_name;
            }

            public void setFirst_name(String first_name) {
                this.first_name = first_name;
            }

            public String getLast_name() {
                return last_name;
            }

            public void setLast_name(String last_name) {
                this.last_name = last_name;
            }

            public String getNumber() {
                return number;
            }

            public void setNumber(String number) {
                this.number = number;
            }

            public String getPosition() {
                return position;
            }

            public void setPosition(String position) {
                this.position = position;
            }

            public int getAge() {
                return age;
            }

            public void setAge(int age) {
                this.age = age;
            }

            public String getBirth_date() {
                return birth_date;
            }

            public void setBirth_date(String birth_date) {
                this.birth_date = birth_date;
            }

            public int getFirst_year() {
                return first_year;
            }

            public void setFirst_year(int first_year) {
                this.first_year = first_year;
            }

            public int getHeight() {
                return height;
            }

            public void setHeight(int height) {
                this.height = height;
            }

            public int getWeight() {
                return weight;
            }

            public void setWeight(int weight) {
                this.weight = weight;
            }

            public String getWage() {
                return wage;
            }

            public void setWage(String wage) {
                this.wage = wage;
            }

            public int getSalary() {
                return salary;
            }

            public void setSalary(int salary) {
                this.salary = salary;
            }

            public String getCountry() {
                return country;
            }

            public void setCountry(String country) {
                this.country = country;
            }

            public int getDraft_year() {
                return draft_year;
            }

            public void setDraft_year(int draft_year) {
                this.draft_year = draft_year;
            }

            public int getDraft_round() {
                return draft_round;
            }

            public void setDraft_round(int draft_round) {
                this.draft_round = draft_round;
            }

            public int getDraft_pick() {
                return draft_pick;
            }

            public void setDraft_pick(int draft_pick) {
                this.draft_pick = draft_pick;
            }

            public String getHigh_school() {
                return high_school;
            }

            public void setHigh_school(String high_school) {
                this.high_school = high_school;
            }

            public String getCollege_school() {
                return college_school;
            }

            public void setCollege_school(String college_school) {
                this.college_school = college_school;
            }

            public double getWingspan() {
                return wingspan;
            }

            public void setWingspan(double wingspan) {
                this.wingspan = wingspan;
            }

            public double getStanding_reach() {
                return standing_reach;
            }

            public void setStanding_reach(double standing_reach) {
                this.standing_reach = standing_reach;
            }

            public String getContract_details() {
                return contract_details;
            }

            public void setContract_details(String contract_details) {
                this.contract_details = contract_details;
            }

            public String getPlayer_link() {
                return player_link;
            }

            public void setPlayer_link(String player_link) {
                this.player_link = player_link;
            }

            public String getPhoto_link() {
                return photo_link;
            }

            public void setPhoto_link(String photo_link) {
                this.photo_link = photo_link;
            }

            public String getBig_photo_link() {
                return big_photo_link;
            }

            public void setBig_photo_link(String big_photo_link) {
                this.big_photo_link = big_photo_link;
            }

            public String getPositionZhName() {
                return positionZhName;
            }

            public void setPositionZhName(String positionZhName) {
                this.positionZhName = positionZhName;
            }

            public String getPlayerId() {
                return playerId;
            }

            public void setPlayerId(String playerId) {
                this.playerId = playerId;
            }
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
