package com.hotbitmapgg.bilibili.entity.discover;

/**
 * Created by hcc on 2016/10/31 23:26
 * 100332338@qq.com
 * <p>
 * 大会员游戏礼包模型类
 */

public class VipGameInfo {
    private int code;
    private DataBean data;
    private String msg;
    private long ts;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public long getTs() {
        return ts;
    }

    public void setTs(long ts) {
        this.ts = ts;
    }

    public static class DataBean {
        private String link;
        private String imgPath;

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public String getImgPath() {
            return imgPath;
        }

        public void setImgPath(String imgPath) {
            this.imgPath = imgPath;
        }
    }
}
