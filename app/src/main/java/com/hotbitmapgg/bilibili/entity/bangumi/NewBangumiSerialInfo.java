package com.hotbitmapgg.bilibili.entity.bangumi;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by hcc on 16/8/6 14:05
 * 100332338@qq.com
 * <p/>
 * 新番连载
 */
public class NewBangumiSerialInfo {
    private String count;
    private List<ListBean> list;

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        private String title;
        private String area;
        private int arealimit;
        private int attention;
        private int bangumi_id;
        private String bgmcount;
        private String cover;
        private String square_cover;
        private int danmaku_count;
        private int favorites;
        private int is_finish;
        private String lastupdate_at;
        @SerializedName("new")
        private boolean newX;
        private int play_count;
        private int season_id;
        private int spid;
        private String url;
        private int viewRank;
        private int weekday;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public int getArealimit() {
            return arealimit;
        }

        public void setArealimit(int arealimit) {
            this.arealimit = arealimit;
        }

        public int getAttention() {
            return attention;
        }

        public void setAttention(int attention) {
            this.attention = attention;
        }

        public int getBangumi_id() {
            return bangumi_id;
        }

        public void setBangumi_id(int bangumi_id) {
            this.bangumi_id = bangumi_id;
        }

        public String getBgmcount() {
            return bgmcount;
        }

        public void setBgmcount(String bgmcount) {
            this.bgmcount = bgmcount;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getSquare_cover() {
            return square_cover;
        }

        public void setSquare_cover(String square_cover) {
            this.square_cover = square_cover;
        }

        public int getDanmaku_count() {
            return danmaku_count;
        }

        public void setDanmaku_count(int danmaku_count) {
            this.danmaku_count = danmaku_count;
        }

        public int getFavorites() {
            return favorites;
        }

        public void setFavorites(int favorites) {
            this.favorites = favorites;
        }

        public int getIs_finish() {
            return is_finish;
        }

        public void setIs_finish(int is_finish) {
            this.is_finish = is_finish;
        }

        public String getLastupdate_at() {
            return lastupdate_at;
        }

        public void setLastupdate_at(String lastupdate_at) {
            this.lastupdate_at = lastupdate_at;
        }

        public boolean isNewX() {
            return newX;
        }

        public void setNewX(boolean newX) {
            this.newX = newX;
        }

        public int getPlay_count() {
            return play_count;
        }

        public void setPlay_count(int play_count) {
            this.play_count = play_count;
        }

        public int getSeason_id() {
            return season_id;
        }

        public void setSeason_id(int season_id) {
            this.season_id = season_id;
        }

        public int getSpid() {
            return spid;
        }

        public void setSpid(int spid) {
            this.spid = spid;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getViewRank() {
            return viewRank;
        }

        public void setViewRank(int viewRank) {
            this.viewRank = viewRank;
        }

        public int getWeekday() {
            return weekday;
        }

        public void setWeekday(int weekday) {
            this.weekday = weekday;
        }
    }
}
