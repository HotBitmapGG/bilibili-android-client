package com.hotbitmapgg.bilibili.entity.bangumi;

import java.util.List;

/**
 * Created by hcc on 16/8/22 21:03
 * 100332338@qq.com
 * <p/>
 * 番剧详情模型类
 */
public class BangumiDetailsInfo {
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
        private String alias;
        private String allow_bp;
        private String allow_download;
        private String area;
        private int arealimit;
        private String bangumi_id;
        private String bangumi_title;
        private String brief;
        private String coins;
        private String copyright;
        private String cover;
        private String danmaku_count;
        private String evaluate;
        private String favorites;
        private String is_finish;
        private String jp_title;
        private LimitInfoBean limit_info;
        private String newest_ep_id;
        private String newest_ep_index;
        private String play_count;
        private String pub_time;
        private String season_id;
        private int season_status;
        private String season_title;
        private String share_url;
        private String squareCover;
        private String staff;
        private String title;
        private String total_count;
        private UserSeasonBean user_season;
        private int viewRank;
        private int vip_quality;
        private String watchingCount;
        private String weekday;
        private List<ActorBean> actor;
        private List<EpisodesBean> episodes;
        private List<?> related_seasons;
        private List<SeasonsBean> seasons;
        private List<?> tag2s;
        private List<TagsBean> tags;

        public String getAlias() {
            return alias;
        }

        public void setAlias(String alias) {
            this.alias = alias;
        }

        public String getAllow_bp() {
            return allow_bp;
        }

        public void setAllow_bp(String allow_bp) {
            this.allow_bp = allow_bp;
        }

        public String getAllow_download() {
            return allow_download;
        }

        public void setAllow_download(String allow_download) {
            this.allow_download = allow_download;
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

        public String getBangumi_id() {
            return bangumi_id;
        }

        public void setBangumi_id(String bangumi_id) {
            this.bangumi_id = bangumi_id;
        }

        public String getBangumi_title() {
            return bangumi_title;
        }

        public void setBangumi_title(String bangumi_title) {
            this.bangumi_title = bangumi_title;
        }

        public String getBrief() {
            return brief;
        }

        public void setBrief(String brief) {
            this.brief = brief;
        }

        public String getCoins() {
            return coins;
        }

        public void setCoins(String coins) {
            this.coins = coins;
        }

        public String getCopyright() {
            return copyright;
        }

        public void setCopyright(String copyright) {
            this.copyright = copyright;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getDanmaku_count() {
            return danmaku_count;
        }

        public void setDanmaku_count(String danmaku_count) {
            this.danmaku_count = danmaku_count;
        }

        public String getEvaluate() {
            return evaluate;
        }

        public void setEvaluate(String evaluate) {
            this.evaluate = evaluate;
        }

        public String getFavorites() {
            return favorites;
        }

        public void setFavorites(String favorites) {
            this.favorites = favorites;
        }

        public String getIs_finish() {
            return is_finish;
        }

        public void setIs_finish(String is_finish) {
            this.is_finish = is_finish;
        }

        public String getJp_title() {
            return jp_title;
        }

        public void setJp_title(String jp_title) {
            this.jp_title = jp_title;
        }

        public LimitInfoBean getLimit_info() {
            return limit_info;
        }

        public void setLimit_info(LimitInfoBean limit_info) {
            this.limit_info = limit_info;
        }

        public String getNewest_ep_id() {
            return newest_ep_id;
        }

        public void setNewest_ep_id(String newest_ep_id) {
            this.newest_ep_id = newest_ep_id;
        }

        public String getNewest_ep_index() {
            return newest_ep_index;
        }

        public void setNewest_ep_index(String newest_ep_index) {
            this.newest_ep_index = newest_ep_index;
        }

        public String getPlay_count() {
            return play_count;
        }

        public void setPlay_count(String play_count) {
            this.play_count = play_count;
        }

        public String getPub_time() {
            return pub_time;
        }

        public void setPub_time(String pub_time) {
            this.pub_time = pub_time;
        }

        public String getSeason_id() {
            return season_id;
        }

        public void setSeason_id(String season_id) {
            this.season_id = season_id;
        }

        public int getSeason_status() {
            return season_status;
        }

        public void setSeason_status(int season_status) {
            this.season_status = season_status;
        }

        public String getSeason_title() {
            return season_title;
        }

        public void setSeason_title(String season_title) {
            this.season_title = season_title;
        }

        public String getShare_url() {
            return share_url;
        }

        public void setShare_url(String share_url) {
            this.share_url = share_url;
        }

        public String getSquareCover() {
            return squareCover;
        }

        public void setSquareCover(String squareCover) {
            this.squareCover = squareCover;
        }

        public String getStaff() {
            return staff;
        }

        public void setStaff(String staff) {
            this.staff = staff;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTotal_count() {
            return total_count;
        }

        public void setTotal_count(String total_count) {
            this.total_count = total_count;
        }

        public UserSeasonBean getUser_season() {
            return user_season;
        }

        public void setUser_season(UserSeasonBean user_season) {
            this.user_season = user_season;
        }

        public int getViewRank() {
            return viewRank;
        }

        public void setViewRank(int viewRank) {
            this.viewRank = viewRank;
        }

        public int getVip_quality() {
            return vip_quality;
        }

        public void setVip_quality(int vip_quality) {
            this.vip_quality = vip_quality;
        }

        public String getWatchingCount() {
            return watchingCount;
        }

        public void setWatchingCount(String watchingCount) {
            this.watchingCount = watchingCount;
        }

        public String getWeekday() {
            return weekday;
        }

        public void setWeekday(String weekday) {
            this.weekday = weekday;
        }

        public List<ActorBean> getActor() {
            return actor;
        }

        public void setActor(List<ActorBean> actor) {
            this.actor = actor;
        }

        public List<EpisodesBean> getEpisodes() {
            return episodes;
        }

        public void setEpisodes(List<EpisodesBean> episodes) {
            this.episodes = episodes;
        }

        public List<?> getRelated_seasons() {
            return related_seasons;
        }

        public void setRelated_seasons(List<?> related_seasons) {
            this.related_seasons = related_seasons;
        }

        public List<SeasonsBean> getSeasons() {
            return seasons;
        }

        public void setSeasons(List<SeasonsBean> seasons) {
            this.seasons = seasons;
        }

        public List<?> getTag2s() {
            return tag2s;
        }

        public void setTag2s(List<?> tag2s) {
            this.tag2s = tag2s;
        }

        public List<TagsBean> getTags() {
            return tags;
        }

        public void setTags(List<TagsBean> tags) {
            this.tags = tags;
        }

        public static class LimitInfoBean {
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
                private int down;
                private int play;

                public int getDown() {
                    return down;
                }

                public void setDown(int down) {
                    this.down = down;
                }

                public int getPlay() {
                    return play;
                }

                public void setPlay(int play) {
                    this.play = play;
                }
            }
        }

        public static class UserSeasonBean {
            private String attention;
            private int bp;
            private String last_ep_id;
            private String last_ep_index;
            private String last_time;

            public String getAttention() {
                return attention;
            }

            public void setAttention(String attention) {
                this.attention = attention;
            }

            public int getBp() {
                return bp;
            }

            public void setBp(int bp) {
                this.bp = bp;
            }

            public String getLast_ep_id() {
                return last_ep_id;
            }

            public void setLast_ep_id(String last_ep_id) {
                this.last_ep_id = last_ep_id;
            }

            public String getLast_ep_index() {
                return last_ep_index;
            }

            public void setLast_ep_index(String last_ep_index) {
                this.last_ep_index = last_ep_index;
            }

            public String getLast_time() {
                return last_time;
            }

            public void setLast_time(String last_time) {
                this.last_time = last_time;
            }
        }

        public static class ActorBean {
            private String actor;
            private int actor_id;
            private String role;

            public String getActor() {
                return actor;
            }

            public void setActor(String actor) {
                this.actor = actor;
            }

            public int getActor_id() {
                return actor_id;
            }

            public void setActor_id(int actor_id) {
                this.actor_id = actor_id;
            }

            public String getRole() {
                return role;
            }

            public void setRole(String role) {
                this.role = role;
            }
        }

        public static class EpisodesBean {
            private String av_id;
            private String coins;
            private String cover;
            private String danmaku;
            private String episode_id;
            private int episode_status;
            private String index;
            private String index_title;
            private String is_new;
            private String is_webplay;
            private String mid;
            private String page;
            private UpBean up;
            private String update_time;

            public String getAv_id() {
                return av_id;
            }

            public void setAv_id(String av_id) {
                this.av_id = av_id;
            }

            public String getCoins() {
                return coins;
            }

            public void setCoins(String coins) {
                this.coins = coins;
            }

            public String getCover() {
                return cover;
            }

            public void setCover(String cover) {
                this.cover = cover;
            }

            public String getDanmaku() {
                return danmaku;
            }

            public void setDanmaku(String danmaku) {
                this.danmaku = danmaku;
            }

            public String getEpisode_id() {
                return episode_id;
            }

            public void setEpisode_id(String episode_id) {
                this.episode_id = episode_id;
            }

            public int getEpisode_status() {
                return episode_status;
            }

            public void setEpisode_status(int episode_status) {
                this.episode_status = episode_status;
            }

            public String getIndex() {
                return index;
            }

            public void setIndex(String index) {
                this.index = index;
            }

            public String getIndex_title() {
                return index_title;
            }

            public void setIndex_title(String index_title) {
                this.index_title = index_title;
            }

            public String getIs_new() {
                return is_new;
            }

            public void setIs_new(String is_new) {
                this.is_new = is_new;
            }

            public String getIs_webplay() {
                return is_webplay;
            }

            public void setIs_webplay(String is_webplay) {
                this.is_webplay = is_webplay;
            }

            public String getMid() {
                return mid;
            }

            public void setMid(String mid) {
                this.mid = mid;
            }

            public String getPage() {
                return page;
            }

            public void setPage(String page) {
                this.page = page;
            }

            public UpBean getUp() {
                return up;
            }

            public void setUp(UpBean up) {
                this.up = up;
            }

            public String getUpdate_time() {
                return update_time;
            }

            public void setUpdate_time(String update_time) {
                this.update_time = update_time;
            }

            public static class UpBean {
            }
        }

        public static class SeasonsBean {
            private String bangumi_id;
            private String cover;
            private String is_finish;
            private String is_new;
            private String newest_ep_id;
            private String newest_ep_index;
            private String season_id;
            private int season_status;
            private String title;
            private String total_count;

            public String getBangumi_id() {
                return bangumi_id;
            }

            public void setBangumi_id(String bangumi_id) {
                this.bangumi_id = bangumi_id;
            }

            public String getCover() {
                return cover;
            }

            public void setCover(String cover) {
                this.cover = cover;
            }

            public String getIs_finish() {
                return is_finish;
            }

            public void setIs_finish(String is_finish) {
                this.is_finish = is_finish;
            }

            public String getIs_new() {
                return is_new;
            }

            public void setIs_new(String is_new) {
                this.is_new = is_new;
            }

            public String getNewest_ep_id() {
                return newest_ep_id;
            }

            public void setNewest_ep_id(String newest_ep_id) {
                this.newest_ep_id = newest_ep_id;
            }

            public String getNewest_ep_index() {
                return newest_ep_index;
            }

            public void setNewest_ep_index(String newest_ep_index) {
                this.newest_ep_index = newest_ep_index;
            }

            public String getSeason_id() {
                return season_id;
            }

            public void setSeason_id(String season_id) {
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

            public String getTotal_count() {
                return total_count;
            }

            public void setTotal_count(String total_count) {
                this.total_count = total_count;
            }
        }

        public static class TagsBean {
            private String cover;
            private String tag_id;
            private String tag_name;

            public String getCover() {
                return cover;
            }

            public void setCover(String cover) {
                this.cover = cover;
            }

            public String getTag_id() {
                return tag_id;
            }

            public void setTag_id(String tag_id) {
                this.tag_id = tag_id;
            }

            public String getTag_name() {
                return tag_name;
            }

            public void setTag_name(String tag_name) {
                this.tag_name = tag_name;
            }
        }
    }
}
