package com.hotbitmapgg.bilibili.entity.bangumi;

import java.util.List;

/**
 * Created by hcc on 2016/9/25 14:32
 * 100332338@qq.com
 * <p>
 * 分季新番模型类
 */

public class SeasonNewBangumiInfo {
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
        private int season;
        private int year;
        private List<ListBean> list;

        public int getSeason() {
            return season;
        }

        public void setSeason(int season) {
            this.season = season;
        }

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            private String cover;
            private String favourites;
            private int is_finish;
            private int last_time;
            private String newest_ep_index;
            private int pub_time;
            private int season_id;
            private int season_status;
            private String title;
            private String version;
            private int watching_count;

            public String getCover() {
                return cover;
            }

            public void setCover(String cover) {
                this.cover = cover;
            }

            public String getFavourites() {
                return favourites;
            }

            public void setFavourites(String favourites) {
                this.favourites = favourites;
            }

            public int getIs_finish() {
                return is_finish;
            }

            public void setIs_finish(int is_finish) {
                this.is_finish = is_finish;
            }

            public int getLast_time() {
                return last_time;
            }

            public void setLast_time(int last_time) {
                this.last_time = last_time;
            }

            public String getNewest_ep_index() {
                return newest_ep_index;
            }

            public void setNewest_ep_index(String newest_ep_index) {
                this.newest_ep_index = newest_ep_index;
            }

            public int getPub_time() {
                return pub_time;
            }

            public void setPub_time(int pub_time) {
                this.pub_time = pub_time;
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

            public String getVersion() {
                return version;
            }

            public void setVersion(String version) {
                this.version = version;
            }

            public int getWatching_count() {
                return watching_count;
            }

            public void setWatching_count(int watching_count) {
                this.watching_count = watching_count;
            }
        }
    }
}
