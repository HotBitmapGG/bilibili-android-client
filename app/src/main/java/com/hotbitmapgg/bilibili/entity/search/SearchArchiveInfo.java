package com.hotbitmapgg.bilibili.entity.search;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by hcc on 2016/10/24 20:11
 * 100332338@qq.com
 * <p>
 * 综合搜索模型类
 */

public class SearchArchiveInfo {
    private int code;
    private DataBean data;
    private String message;

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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class DataBean {
        private int page;
        private ItemsBean items;
        private List<NavBean> nav;

        public int getPage() {
            return page;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public ItemsBean getItems() {
            return items;
        }

        public void setItems(ItemsBean items) {
            this.items = items;
        }

        public List<NavBean> getNav() {
            return nav;
        }

        public void setNav(List<NavBean> nav) {
            this.nav = nav;
        }

        public static class ItemsBean {
            private List<SeasonBean> season;
            private List<ArchiveBean> archive;

            public List<SeasonBean> getSeason() {
                return season;
            }

            public void setSeason(List<SeasonBean> season) {
                this.season = season;
            }

            public List<ArchiveBean> getArchive() {
                return archive;
            }

            public void setArchive(List<ArchiveBean> archive) {
                this.archive = archive;
            }

            public static class SeasonBean {
                private String title;
                private String cover;
                private String uri;
                private String param;
                @SerializedName("goto")
                private String gotoX;
                private String index;
                private String newest_cat;
                private String newest_season;
                private String cat_desc;
                private int total_count;
                private int finish;
                private OfficialVerifyBean official_verify;
                private int status;

                public int getFinish() {
                    return finish;
                }

                public void setFinish(int finish) {
                    this.finish = finish;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getCover() {
                    return cover;
                }

                public void setCover(String cover) {
                    this.cover = cover;
                }

                public String getUri() {
                    return uri;
                }

                public void setUri(String uri) {
                    this.uri = uri;
                }

                public String getParam() {
                    return param;
                }

                public void setParam(String param) {
                    this.param = param;
                }

                public String getGotoX() {
                    return gotoX;
                }

                public void setGotoX(String gotoX) {
                    this.gotoX = gotoX;
                }

                public String getIndex() {
                    return index;
                }

                public void setIndex(String index) {
                    this.index = index;
                }

                public String getNewest_cat() {
                    return newest_cat;
                }

                public void setNewest_cat(String newest_cat) {
                    this.newest_cat = newest_cat;
                }

                public String getNewest_season() {
                    return newest_season;
                }

                public void setNewest_season(String newest_season) {
                    this.newest_season = newest_season;
                }

                public String getCat_desc() {
                    return cat_desc;
                }

                public void setCat_desc(String cat_desc) {
                    this.cat_desc = cat_desc;
                }

                public int getTotal_count() {
                    return total_count;
                }

                public void setTotal_count(int total_count) {
                    this.total_count = total_count;
                }

                public OfficialVerifyBean getOfficial_verify() {
                    return official_verify;
                }

                public void setOfficial_verify(OfficialVerifyBean official_verify) {
                    this.official_verify = official_verify;
                }

                public int getStatus() {
                    return status;
                }

                public void setStatus(int status) {
                    this.status = status;
                }

                public static class OfficialVerifyBean {
                    private int type;
                    private String desc;

                    public int getType() {
                        return type;
                    }

                    public void setType(int type) {
                        this.type = type;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }
            }

            public static class ArchiveBean {
                private String title;
                private String cover;
                private String uri;
                private String param;
                @SerializedName("goto")
                private String gotoX;
                private int play;
                private int danmaku;
                private String author;
                private int total_count;
                private String desc;
                private OfficialVerifyBean official_verify;
                private String duration;
                private int status;

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getCover() {
                    return cover;
                }

                public void setCover(String cover) {
                    this.cover = cover;
                }

                public String getUri() {
                    return uri;
                }

                public void setUri(String uri) {
                    this.uri = uri;
                }

                public String getParam() {
                    return param;
                }

                public void setParam(String param) {
                    this.param = param;
                }

                public String getGotoX() {
                    return gotoX;
                }

                public void setGotoX(String gotoX) {
                    this.gotoX = gotoX;
                }

                public int getPlay() {
                    return play;
                }

                public void setPlay(int play) {
                    this.play = play;
                }

                public int getDanmaku() {
                    return danmaku;
                }

                public void setDanmaku(int danmaku) {
                    this.danmaku = danmaku;
                }

                public String getAuthor() {
                    return author;
                }

                public void setAuthor(String author) {
                    this.author = author;
                }

                public int getTotal_count() {
                    return total_count;
                }

                public void setTotal_count(int total_count) {
                    this.total_count = total_count;
                }

                public String getDesc() {
                    return desc;
                }

                public void setDesc(String desc) {
                    this.desc = desc;
                }

                public OfficialVerifyBean getOfficial_verify() {
                    return official_verify;
                }

                public void setOfficial_verify(OfficialVerifyBean official_verify) {
                    this.official_verify = official_verify;
                }

                public String getDuration() {
                    return duration;
                }

                public void setDuration(String duration) {
                    this.duration = duration;
                }

                public int getStatus() {
                    return status;
                }

                public void setStatus(int status) {
                    this.status = status;
                }

                public static class OfficialVerifyBean {
                    private int type;
                    private String desc;

                    public int getType() {
                        return type;
                    }

                    public void setType(int type) {
                        this.type = type;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }
            }
        }

        public static class NavBean {
            private String name;
            private int total;
            private int pages;
            private int type;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getTotal() {
                return total;
            }

            public void setTotal(int total) {
                this.total = total;
            }

            public int getPages() {
                return pages;
            }

            public void setPages(int pages) {
                this.pages = pages;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }
        }
    }
}
