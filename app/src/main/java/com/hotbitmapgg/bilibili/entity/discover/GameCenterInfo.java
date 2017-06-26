package com.hotbitmapgg.bilibili.entity.discover;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by hcc on 2016/10/31 22:01
 * 100332338@qq.com
 * <p>
 * 游戏中心模型类
 */

public class GameCenterInfo {
    private long timestamp;
    private int code;
    private List<ItemsBean> items;

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<ItemsBean> getItems() {
        return items;
    }

    public void setItems(List<ItemsBean> items) {
        this.items = items;
    }

    public static class ItemsBean {
        private int id;
        private String title;
        private String summary;
        private int iOS_game_status;
        private String download_link;
        private String cover;
        private int hot;
        @SerializedName("new")
        private int newX;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public int getIOS_game_status() {
            return iOS_game_status;
        }

        public void setIOS_game_status(int iOS_game_status) {
            this.iOS_game_status = iOS_game_status;
        }

        public String getDownload_link() {
            return download_link;
        }

        public void setDownload_link(String download_link) {
            this.download_link = download_link;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public int getHot() {
            return hot;
        }

        public void setHot(int hot) {
            this.hot = hot;
        }

        public int getNewX() {
            return newX;
        }

        public void setNewX(int newX) {
            this.newX = newX;
        }
    }
}
