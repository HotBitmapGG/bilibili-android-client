package com.hotbitmapgg.bilibili.entity.discover;

import java.util.List;

/**
 * Created by hcc on 2016/9/22 18:44
 * 100332338@qq.com
 * <p>
 * 原创排行榜模型类
 */

public class OriginalRankInfo {
    private RankBean rank;

    public RankBean getRank() {
        return rank;
    }

    public void setRank(RankBean rank) {
        this.rank = rank;
    }

    public static class RankBean {
        private String note;
        private int code;
        private int pages;
        private int num;
        private List<ListBean> list;

        public String getNote() {
            return note;
        }

        public void setNote(String note) {
            this.note = note;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public int getPages() {
            return pages;
        }

        public void setPages(int pages) {
            this.pages = pages;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            private int aid;
            private String typename;
            private String title;
            private String subtitle;
            private String play;
            private int review;
            private int video_review;
            private int favorites;
            private int mid;
            private String author;
            private String description;
            private String create;
            private String pic;
            private int coins;
            private String duration;
            private boolean badgepay;
            private int pts;

            public int getAid() {
                return aid;
            }

            public void setAid(int aid) {
                this.aid = aid;
            }

            public String getTypename() {
                return typename;
            }

            public void setTypename(String typename) {
                this.typename = typename;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getSubtitle() {
                return subtitle;
            }

            public void setSubtitle(String subtitle) {
                this.subtitle = subtitle;
            }

            public String getPlay() {
                return play;
            }

            public void setPlay(String play) {
                this.play = play;
            }

            public int getReview() {
                return review;
            }

            public void setReview(int review) {
                this.review = review;
            }

            public int getVideo_review() {
                return video_review;
            }

            public void setVideo_review(int video_review) {
                this.video_review = video_review;
            }

            public int getFavorites() {
                return favorites;
            }

            public void setFavorites(int favorites) {
                this.favorites = favorites;
            }

            public int getMid() {
                return mid;
            }

            public void setMid(int mid) {
                this.mid = mid;
            }

            public String getAuthor() {
                return author;
            }

            public void setAuthor(String author) {
                this.author = author;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getCreate() {
                return create;
            }

            public void setCreate(String create) {
                this.create = create;
            }

            public String getPic() {
                return pic;
            }

            public void setPic(String pic) {
                this.pic = pic;
            }

            public int getCoins() {
                return coins;
            }

            public void setCoins(int coins) {
                this.coins = coins;
            }

            public String getDuration() {
                return duration;
            }

            public void setDuration(String duration) {
                this.duration = duration;
            }

            public boolean isBadgepay() {
                return badgepay;
            }

            public void setBadgepay(boolean badgepay) {
                this.badgepay = badgepay;
            }

            public int getPts() {
                return pts;
            }

            public void setPts(int pts) {
                this.pts = pts;
            }
        }
    }
}
