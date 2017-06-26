package com.hotbitmapgg.bilibili.entity.bangumi;

import java.util.List;

/**
 * Created by hcc on 2016/10/11 10:48
 * 100332338@qq.com
 * <p>
 * 番剧放送表模型类
 */

public class BangumiScheduleInfo {
    private int code;
    private String message;
    private List<ResultBean> result;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        private int area_id;
        private String cover;
        private int date;
        private int delay;
        private int ep_id;
        private String ep_index;
        private int follow;
        private int is_published;
        private String ontime;
        private String pub_date;
        private int season_id;
        private int season_status;
        private String title;

        public int getArea_id() {
            return area_id;
        }

        public void setArea_id(int area_id) {
            this.area_id = area_id;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public int getDate() {
            return date;
        }

        public void setDate(int date) {
            this.date = date;
        }

        public int getDelay() {
            return delay;
        }

        public void setDelay(int delay) {
            this.delay = delay;
        }

        public int getEp_id() {
            return ep_id;
        }

        public void setEp_id(int ep_id) {
            this.ep_id = ep_id;
        }

        public String getEp_index() {
            return ep_index;
        }

        public void setEp_index(String ep_index) {
            this.ep_index = ep_index;
        }

        public int getFollow() {
            return follow;
        }

        public void setFollow(int follow) {
            this.follow = follow;
        }

        public int getIs_published() {
            return is_published;
        }

        public void setIs_published(int is_published) {
            this.is_published = is_published;
        }

        public String getOntime() {
            return ontime;
        }

        public void setOntime(String ontime) {
            this.ontime = ontime;
        }

        public String getPub_date() {
            return pub_date;
        }

        public void setPub_date(String pub_date) {
            this.pub_date = pub_date;
        }

        public int getSeason_id() {
            return season_id;
        }

        public void setSeason_id(int season_id) {
            this.season_id = season_id;
        }

        public int getSeason_status() {
            return season_status;
        }

        public void setSeason_status(int season_status) {
            this.season_status = season_status;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
