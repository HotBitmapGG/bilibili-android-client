package com.hotbitmapgg.bilibili.entity.attention;

import java.util.List;

/**
 * Created by hcc on 2016/9/28 19:49
 * 100332338@qq.com
 * <p>
 * 关注动态模型类
 */

public class AttentionDynamicInfo {
    private int code;
    private DataBean data;

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


    public static class DataBean {
        private PageBean page;
        private List<FeedsBean> feeds;

        public PageBean getPage() {
            return page;
        }

        public void setPage(PageBean page) {
            this.page = page;
        }

        public List<FeedsBean> getFeeds() {
            return feeds;
        }

        public void setFeeds(List<FeedsBean> feeds) {
            this.feeds = feeds;
        }

        public static class PageBean {
            private int count;
            private int num;
            private int size;

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }

            public int getNum() {
                return num;
            }

            public void setNum(int num) {
                this.num = num;
            }

            public int getSize() {
                return size;
            }

            public void setSize(int size) {
                this.size = size;
            }
        }

        public static class FeedsBean {
            private int id;
            private int src_id;
            private int add_id;
            private int type;
            private int mcid;
            private int ctime;
            private SourceBean source;
            private AdditionBean addition;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getSrc_id() {
                return src_id;
            }

            public void setSrc_id(int src_id) {
                this.src_id = src_id;
            }

            public int getAdd_id() {
                return add_id;
            }

            public void setAdd_id(int add_id) {
                this.add_id = add_id;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public int getMcid() {
                return mcid;
            }

            public void setMcid(int mcid) {
                this.mcid = mcid;
            }

            public int getCtime() {
                return ctime;
            }

            public void setCtime(int ctime) {
                this.ctime = ctime;
            }

            public SourceBean getSource() {
                return source;
            }

            public void setSource(SourceBean source) {
                this.source = source;
            }

            public AdditionBean getAddition() {
                return addition;
            }

            public void setAddition(AdditionBean addition) {
                this.addition = addition;
            }

            public static class SourceBean {
                private String mid;
                private String uname;
                private String sex;
                private String sign;
                private String avatar;
                private String rank;
                private String DisplayRank;
                private LevelInfoBean level_info;
                private PendantBean pendant;
                private NameplateBean nameplate;
                private OfficialVerifyBean official_verify;

                public String getMid() {
                    return mid;
                }

                public void setMid(String mid) {
                    this.mid = mid;
                }

                public String getUname() {
                    return uname;
                }

                public void setUname(String uname) {
                    this.uname = uname;
                }

                public String getSex() {
                    return sex;
                }

                public void setSex(String sex) {
                    this.sex = sex;
                }

                public String getSign() {
                    return sign;
                }

                public void setSign(String sign) {
                    this.sign = sign;
                }

                public String getAvatar() {
                    return avatar;
                }

                public void setAvatar(String avatar) {
                    this.avatar = avatar;
                }

                public String getRank() {
                    return rank;
                }

                public void setRank(String rank) {
                    this.rank = rank;
                }

                public String getDisplayRank() {
                    return DisplayRank;
                }

                public void setDisplayRank(String DisplayRank) {
                    this.DisplayRank = DisplayRank;
                }

                public LevelInfoBean getLevel_info() {
                    return level_info;
                }

                public void setLevel_info(LevelInfoBean level_info) {
                    this.level_info = level_info;
                }

                public PendantBean getPendant() {
                    return pendant;
                }

                public void setPendant(PendantBean pendant) {
                    this.pendant = pendant;
                }

                public NameplateBean getNameplate() {
                    return nameplate;
                }

                public void setNameplate(NameplateBean nameplate) {
                    this.nameplate = nameplate;
                }

                public OfficialVerifyBean getOfficial_verify() {
                    return official_verify;
                }

                public void setOfficial_verify(OfficialVerifyBean official_verify) {
                    this.official_verify = official_verify;
                }

                public static class LevelInfoBean {
                    private int current_level;
                    private int current_min;
                    private int current_exp;
                    private String next_exp;

                    public int getCurrent_level() {
                        return current_level;
                    }

                    public void setCurrent_level(int current_level) {
                        this.current_level = current_level;
                    }

                    public int getCurrent_min() {
                        return current_min;
                    }

                    public void setCurrent_min(int current_min) {
                        this.current_min = current_min;
                    }

                    public int getCurrent_exp() {
                        return current_exp;
                    }

                    public void setCurrent_exp(int current_exp) {
                        this.current_exp = current_exp;
                    }

                    public String getNext_exp() {
                        return next_exp;
                    }

                    public void setNext_exp(String next_exp) {
                        this.next_exp = next_exp;
                    }
                }

                public static class PendantBean {
                    private int pid;
                    private String name;
                    private String image;
                    private long expire;

                    public int getPid() {
                        return pid;
                    }


                    public void setPid(int pid) {
                        this.pid = pid;
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public String getImage() {
                        return image;
                    }

                    public void setImage(String image) {
                        this.image = image;
                    }

                    public long getExpire() {
                        return expire;
                    }

                    public void setExpire(long expire) {
                        this.expire = expire;
                    }
                }

                public static class NameplateBean {
                    private int nid;
                    private String name;
                    private String image;
                    private String image_small;
                    private String level;
                    private String condition;

                    public int getNid() {
                        return nid;
                    }

                    public void setNid(int nid) {
                        this.nid = nid;
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public String getImage() {
                        return image;
                    }

                    public void setImage(String image) {
                        this.image = image;
                    }

                    public String getImage_small() {
                        return image_small;
                    }

                    public void setImage_small(String image_small) {
                        this.image_small = image_small;
                    }

                    public String getLevel() {
                        return level;
                    }

                    public void setLevel(String level) {
                        this.level = level;
                    }

                    public String getCondition() {
                        return condition;
                    }

                    public void setCondition(String condition) {
                        this.condition = condition;
                    }
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

            public static class AdditionBean {
                private int aid;
                private int typeid;
                private String typename;
                private String title;
                private String subtitle;
                private int play;
                private int review;
                private int video_review;
                private int favorites;
                private int mid;
                private String author;
                private String link;
                private String keywords;
                private String description;
                private String create;
                private String pic;
                private int credit;
                private int coins;
                private int money;
                private String duration;
                private int status;
                private int view;
                private String view_at;
                private int fav_create;
                private String fav_create_at;
                private String flag;

                public int getAid() {
                    return aid;
                }

                public void setAid(int aid) {
                    this.aid = aid;
                }

                public int getTypeid() {
                    return typeid;
                }

                public void setTypeid(int typeid) {
                    this.typeid = typeid;
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

                public int getPlay() {
                    return play;
                }

                public void setPlay(int play) {
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

                public String getLink() {
                    return link;
                }

                public void setLink(String link) {
                    this.link = link;
                }

                public String getKeywords() {
                    return keywords;
                }

                public void setKeywords(String keywords) {
                    this.keywords = keywords;
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

                public int getCredit() {
                    return credit;
                }

                public void setCredit(int credit) {
                    this.credit = credit;
                }

                public int getCoins() {
                    return coins;
                }

                public void setCoins(int coins) {
                    this.coins = coins;
                }

                public int getMoney() {
                    return money;
                }

                public void setMoney(int money) {
                    this.money = money;
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

                public int getView() {
                    return view;
                }

                public void setView(int view) {
                    this.view = view;
                }

                public String getView_at() {
                    return view_at;
                }

                public void setView_at(String view_at) {
                    this.view_at = view_at;
                }

                public int getFav_create() {
                    return fav_create;
                }

                public void setFav_create(int fav_create) {
                    this.fav_create = fav_create;
                }

                public String getFav_create_at() {
                    return fav_create_at;
                }

                public void setFav_create_at(String fav_create_at) {
                    this.fav_create_at = fav_create_at;
                }

                public String getFlag() {
                    return flag;
                }

                public void setFlag(String flag) {
                    this.flag = flag;
                }
            }
        }
    }
}
