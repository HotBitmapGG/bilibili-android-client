package com.hotbitmapgg.bilibili.entity.video;

import java.util.List;

/**
 * Created by hcc on 16/8/8 10:09
 * 100332338@qq.com
 * <p/>
 * 视频详情模型类
 */
public class VideoDetailsInfo {
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
        private int aid;
        private int attribute;
        private int copyright;
        private int ctime;
        private String desc;
        private int duration;
        private ElecBean elec;
        private OwnerBean owner;
        private OwnerExtBean owner_ext;
        private String pic;
        private int pubdate;
        private ReqUserBean req_user;
        private RightsBean rights;
        private StatBean stat;
        private int state;
        private int tid;
        private String title;
        private String tname;
        private List<PagesBean> pages;
        private List<RelatesBean> relates;
        private List<TagBean> tag;
        private List<String> tags;

        public int getAid() {
            return aid;
        }

        public void setAid(int aid) {
            this.aid = aid;
        }

        public int getAttribute() {
            return attribute;
        }

        public void setAttribute(int attribute) {
            this.attribute = attribute;
        }

        public int getCopyright() {
            return copyright;
        }

        public void setCopyright(int copyright) {
            this.copyright = copyright;
        }

        public int getCtime() {
            return ctime;
        }

        public void setCtime(int ctime) {
            this.ctime = ctime;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public int getDuration() {
            return duration;
        }

        public void setDuration(int duration) {
            this.duration = duration;
        }

        public ElecBean getElec() {
            return elec;
        }

        public void setElec(ElecBean elec) {
            this.elec = elec;
        }

        public OwnerBean getOwner() {
            return owner;
        }

        public void setOwner(OwnerBean owner) {
            this.owner = owner;
        }

        public OwnerExtBean getOwner_ext() {
            return owner_ext;
        }

        public void setOwner_ext(OwnerExtBean owner_ext) {
            this.owner_ext = owner_ext;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public int getPubdate() {
            return pubdate;
        }

        public void setPubdate(int pubdate) {
            this.pubdate = pubdate;
        }

        public ReqUserBean getReq_user() {
            return req_user;
        }

        public void setReq_user(ReqUserBean req_user) {
            this.req_user = req_user;
        }

        public RightsBean getRights() {
            return rights;
        }

        public void setRights(RightsBean rights) {
            this.rights = rights;
        }

        public StatBean getStat() {
            return stat;
        }

        public void setStat(StatBean stat) {
            this.stat = stat;
        }

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
        }

        public int getTid() {
            return tid;
        }

        public void setTid(int tid) {
            this.tid = tid;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTname() {
            return tname;
        }

        public void setTname(String tname) {
            this.tname = tname;
        }

        public List<PagesBean> getPages() {
            return pages;
        }

        public void setPages(List<PagesBean> pages) {
            this.pages = pages;
        }

        public List<RelatesBean> getRelates() {
            return relates;
        }

        public void setRelates(List<RelatesBean> relates) {
            this.relates = relates;
        }

        public List<TagBean> getTag() {
            return tag;
        }

        public void setTag(List<TagBean> tag) {
            this.tag = tag;
        }

        public List<String> getTags() {
            return tags;
        }

        public void setTags(List<String> tags) {
            this.tags = tags;
        }

        public static class ElecBean {
            private int count;
            private boolean show;
            private int total;
            private List<ListBean> list;

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }

            public boolean isShow() {
                return show;
            }

            public void setShow(boolean show) {
                this.show = show;
            }

            public int getTotal() {
                return total;
            }

            public void setTotal(int total) {
                this.total = total;
            }

            public List<ListBean> getList() {
                return list;
            }

            public void setList(List<ListBean> list) {
                this.list = list;
            }

            public static class ListBean {
                private String avatar;
                private String message;
                private int mid;
                private int msg_deleted;
                private int pay_mid;
                private int rank;
                private int trend_type;
                private String uname;
                private VipInfoBean vip_info;

                public String getAvatar() {
                    return avatar;
                }

                public void setAvatar(String avatar) {
                    this.avatar = avatar;
                }

                public String getMessage() {
                    return message;
                }

                public void setMessage(String message) {
                    this.message = message;
                }

                public int getMid() {
                    return mid;
                }

                public void setMid(int mid) {
                    this.mid = mid;
                }

                public int getMsg_deleted() {
                    return msg_deleted;
                }

                public void setMsg_deleted(int msg_deleted) {
                    this.msg_deleted = msg_deleted;
                }

                public int getPay_mid() {
                    return pay_mid;
                }

                public void setPay_mid(int pay_mid) {
                    this.pay_mid = pay_mid;
                }

                public int getRank() {
                    return rank;
                }

                public void setRank(int rank) {
                    this.rank = rank;
                }

                public int getTrend_type() {
                    return trend_type;
                }

                public void setTrend_type(int trend_type) {
                    this.trend_type = trend_type;
                }

                public String getUname() {
                    return uname;
                }

                public void setUname(String uname) {
                    this.uname = uname;
                }

                public VipInfoBean getVip_info() {
                    return vip_info;
                }

                public void setVip_info(VipInfoBean vip_info) {
                    this.vip_info = vip_info;
                }

                public static class VipInfoBean {
                    private int vipStatus;
                    private int vipType;

                    public int getVipStatus() {
                        return vipStatus;
                    }

                    public void setVipStatus(int vipStatus) {
                        this.vipStatus = vipStatus;
                    }

                    public int getVipType() {
                        return vipType;
                    }

                    public void setVipType(int vipType) {
                        this.vipType = vipType;
                    }
                }
            }
        }

        public static class OwnerBean {
            private String face;
            private int mid;
            private String name;

            public String getFace() {
                return face;
            }

            public void setFace(String face) {
                this.face = face;
            }

            public int getMid() {
                return mid;
            }

            public void setMid(int mid) {
                this.mid = mid;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }

        public static class OwnerExtBean {
            private VipBean vip;

            public VipBean getVip() {
                return vip;
            }

            public void setVip(VipBean vip) {
                this.vip = vip;
            }

            public static class VipBean {
                private int accessStatus;
                private String dueRemark;
                private long vipDueDate;
                private int vipStatus;
                private String vipStatusWarn;
                private int vipType;

                public int getAccessStatus() {
                    return accessStatus;
                }

                public void setAccessStatus(int accessStatus) {
                    this.accessStatus = accessStatus;
                }

                public String getDueRemark() {
                    return dueRemark;
                }

                public void setDueRemark(String dueRemark) {
                    this.dueRemark = dueRemark;
                }

                public long getVipDueDate() {
                    return vipDueDate;
                }

                public void setVipDueDate(long vipDueDate) {
                    this.vipDueDate = vipDueDate;
                }

                public int getVipStatus() {
                    return vipStatus;
                }

                public void setVipStatus(int vipStatus) {
                    this.vipStatus = vipStatus;
                }

                public String getVipStatusWarn() {
                    return vipStatusWarn;
                }

                public void setVipStatusWarn(String vipStatusWarn) {
                    this.vipStatusWarn = vipStatusWarn;
                }

                public int getVipType() {
                    return vipType;
                }

                public void setVipType(int vipType) {
                    this.vipType = vipType;
                }
            }
        }

        public static class ReqUserBean {
            private int attention;
            private int favorite;

            public int getAttention() {
                return attention;
            }

            public void setAttention(int attention) {
                this.attention = attention;
            }

            public int getFavorite() {
                return favorite;
            }

            public void setFavorite(int favorite) {
                this.favorite = favorite;
            }
        }

        public static class RightsBean {
            private int bp;
            private int download;
            private int elec;
            private int hd5;
            private int movie;
            private int pay;

            public int getBp() {
                return bp;
            }

            public void setBp(int bp) {
                this.bp = bp;
            }

            public int getDownload() {
                return download;
            }

            public void setDownload(int download) {
                this.download = download;
            }

            public int getElec() {
                return elec;
            }

            public void setElec(int elec) {
                this.elec = elec;
            }

            public int getHd5() {
                return hd5;
            }

            public void setHd5(int hd5) {
                this.hd5 = hd5;
            }

            public int getMovie() {
                return movie;
            }

            public void setMovie(int movie) {
                this.movie = movie;
            }

            public int getPay() {
                return pay;
            }

            public void setPay(int pay) {
                this.pay = pay;
            }
        }

        public static class StatBean {
            private int coin;
            private int danmaku;
            private int favorite;
            private int his_rank;
            private int now_rank;
            private int reply;
            private int share;
            private int view;

            public int getCoin() {
                return coin;
            }

            public void setCoin(int coin) {
                this.coin = coin;
            }

            public int getDanmaku() {
                return danmaku;
            }

            public void setDanmaku(int danmaku) {
                this.danmaku = danmaku;
            }

            public int getFavorite() {
                return favorite;
            }

            public void setFavorite(int favorite) {
                this.favorite = favorite;
            }

            public int getHis_rank() {
                return his_rank;
            }

            public void setHis_rank(int his_rank) {
                this.his_rank = his_rank;
            }

            public int getNow_rank() {
                return now_rank;
            }

            public void setNow_rank(int now_rank) {
                this.now_rank = now_rank;
            }

            public int getReply() {
                return reply;
            }

            public void setReply(int reply) {
                this.reply = reply;
            }

            public int getShare() {
                return share;
            }

            public void setShare(int share) {
                this.share = share;
            }

            public int getView() {
                return view;
            }

            public void setView(int view) {
                this.view = view;
            }
        }

        public static class PagesBean {
            private int cid;
            private String from;
            private int has_alias;
            private String link;
            private int page;
            private String part;
            private String rich_vid;
            private String vid;
            private String weblink;

            public int getCid() {
                return cid;
            }

            public void setCid(int cid) {
                this.cid = cid;
            }

            public String getFrom() {
                return from;
            }

            public void setFrom(String from) {
                this.from = from;
            }

            public int getHas_alias() {
                return has_alias;
            }

            public void setHas_alias(int has_alias) {
                this.has_alias = has_alias;
            }

            public String getLink() {
                return link;
            }

            public void setLink(String link) {
                this.link = link;
            }

            public int getPage() {
                return page;
            }

            public void setPage(int page) {
                this.page = page;
            }

            public String getPart() {
                return part;
            }

            public void setPart(String part) {
                this.part = part;
            }

            public String getRich_vid() {
                return rich_vid;
            }

            public void setRich_vid(String rich_vid) {
                this.rich_vid = rich_vid;
            }

            public String getVid() {
                return vid;
            }

            public void setVid(String vid) {
                this.vid = vid;
            }

            public String getWeblink() {
                return weblink;
            }

            public void setWeblink(String weblink) {
                this.weblink = weblink;
            }
        }

        public static class RelatesBean {
            private int aid;
            private OwnerBean owner;
            private String pic;
            private StatBean stat;
            private String title;

            public int getAid() {
                return aid;
            }

            public void setAid(int aid) {
                this.aid = aid;
            }

            public OwnerBean getOwner() {
                return owner;
            }

            public void setOwner(OwnerBean owner) {
                this.owner = owner;
            }

            public String getPic() {
                return pic;
            }

            public void setPic(String pic) {
                this.pic = pic;
            }

            public StatBean getStat() {
                return stat;
            }

            public void setStat(StatBean stat) {
                this.stat = stat;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public static class OwnerBean {
                private String face;
                private int mid;
                private String name;

                public String getFace() {
                    return face;
                }

                public void setFace(String face) {
                    this.face = face;
                }

                public int getMid() {
                    return mid;
                }

                public void setMid(int mid) {
                    this.mid = mid;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }
            }

            public static class StatBean {
                private int coin;
                private int danmaku;
                private int favorite;
                private int his_rank;
                private int now_rank;
                private int reply;
                private int share;
                private int view;

                public int getCoin() {
                    return coin;
                }

                public void setCoin(int coin) {
                    this.coin = coin;
                }

                public int getDanmaku() {
                    return danmaku;
                }

                public void setDanmaku(int danmaku) {
                    this.danmaku = danmaku;
                }

                public int getFavorite() {
                    return favorite;
                }

                public void setFavorite(int favorite) {
                    this.favorite = favorite;
                }

                public int getHis_rank() {
                    return his_rank;
                }

                public void setHis_rank(int his_rank) {
                    this.his_rank = his_rank;
                }

                public int getNow_rank() {
                    return now_rank;
                }

                public void setNow_rank(int now_rank) {
                    this.now_rank = now_rank;
                }

                public int getReply() {
                    return reply;
                }

                public void setReply(int reply) {
                    this.reply = reply;
                }

                public int getShare() {
                    return share;
                }

                public void setShare(int share) {
                    this.share = share;
                }

                public int getView() {
                    return view;
                }

                public void setView(int view) {
                    this.view = view;
                }
            }
        }

        public static class TagBean {
            private String cover;
            private int hates;
            private int likes;
            private int tag_id;
            private String tag_name;

            public String getCover() {
                return cover;
            }

            public void setCover(String cover) {
                this.cover = cover;
            }

            public int getHates() {
                return hates;
            }

            public void setHates(int hates) {
                this.hates = hates;
            }

            public int getLikes() {
                return likes;
            }

            public void setLikes(int likes) {
                this.likes = likes;
            }

            public int getTag_id() {
                return tag_id;
            }

            public void setTag_id(int tag_id) {
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
