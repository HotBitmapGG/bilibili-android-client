package com.hotbitmapgg.bilibili.entity.bangumi;

import java.util.List;

/**
 * Created by hcc on 2016/11/1 10:41
 * 100332338@qq.com
 * <p>
 * 首页番剧内容模型类
 */

public class BangumiAppIndexInfo {
    private int code;
    private String message;
    private ResultBean result;

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

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        private AdBean ad;
        private PreviousBean previous;
        private List<SerializingBean> serializing;

        public AdBean getAd() {
            return ad;
        }

        public void setAd(AdBean ad) {
            this.ad = ad;
        }

        public PreviousBean getPrevious() {
            return previous;
        }


        public void setPrevious(PreviousBean previous) {
            this.previous = previous;
        }


        public List<SerializingBean> getSerializing() {
            return serializing;
        }


        public void setSerializing(List<SerializingBean> serializing) {
            this.serializing = serializing;
        }


        public static class AdBean {
            private List<BodyBean> body;
            private List<HeadBean> head;

            public List<BodyBean> getBody() {
                return body;
            }


            public void setBody(List<BodyBean> body) {
                this.body = body;
            }

            public List<HeadBean> getHead() {
                return head;
            }

            public void setHead(List<HeadBean> head) {
                this.head = head;
            }

            public static class BodyBean {
                private String img;
                private int index;
                private String link;
                private String title;

                public String getImg() {
                    return img;
                }

                public void setImg(String img) {
                    this.img = img;
                }

                public int getIndex() {
                    return index;
                }

                public void setIndex(int index) {
                    this.index = index;
                }

                public String getLink() {
                    return link;
                }

                public void setLink(String link) {
                    this.link = link;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }
            }

            public static class HeadBean {
                private int id;
                private String img;
                private int is_ad;
                private String link;
                private String pub_time;
                private String title;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getImg() {
                    return img;
                }

                public void setImg(String img) {
                    this.img = img;
                }

                public int getIs_ad() {
                    return is_ad;
                }

                public void setIs_ad(int is_ad) {
                    this.is_ad = is_ad;
                }

                public String getLink() {
                    return link;
                }

                public void setLink(String link) {
                    this.link = link;
                }

                public String getPub_time() {
                    return pub_time;
                }

                public void setPub_time(String pub_time) {
                    this.pub_time = pub_time;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }
            }
        }

        public static class PreviousBean {
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

                public int getWatching_count() {
                    return watching_count;
                }

                public void setWatching_count(int watching_count) {
                    this.watching_count = watching_count;
                }
            }
        }

        public static class SerializingBean {
            private String cover;
            private String favourites;
            private int is_finish;
            private int is_started;
            private int last_time;
            private String newest_ep_index;
            private int pub_time;
            private int season_id;
            private int season_status;
            private String title;
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

            public int getIs_started() {
                return is_started;
            }

            public void setIs_started(int is_started) {
                this.is_started = is_started;
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

            public int getWatching_count() {
                return watching_count;
            }

            public void setWatching_count(int watching_count) {
                this.watching_count = watching_count;
            }
        }
    }
}
