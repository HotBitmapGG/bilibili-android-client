package com.hotbitmapgg.bilibili.entity.user;

import java.util.List;

/**
 * Created by hcc on 16/8/22 20:48
 * 100332338@qq.com
 * <p/>
 * 用户详情模型类
 */
public class UserDetailsInfo {
    private int code;
    private CardBean card;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public CardBean getCard() {
        return card;
    }

    public void setCard(CardBean card) {
        this.card = card;
    }


    public static class CardBean {
        private String mid;
        private String name;
        private boolean approve;
        private String sex;
        private String rank;
        private String face;
        private int coins;
        private String DisplayRank;
        private int regtime;
        private int spacesta;
        private String birthday;
        private String place;
        private String description;
        private int article;
        private int fans;
        private int friend;
        private int attention;
        private String sign;
        private LevelInfoBean level_info;
        private PendantBean pendant;
        private NameplateBean nameplate;
        private OfficialVerifyBean official_verify;
        private List<Integer> attentions;

        public String getMid() {
            return mid;
        }

        public void setMid(String mid) {
            this.mid = mid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public boolean isApprove() {
            return approve;
        }

        public void setApprove(boolean approve) {
            this.approve = approve;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getRank() {
            return rank;
        }

        public void setRank(String rank) {
            this.rank = rank;
        }

        public String getFace() {
            return face;
        }

        public void setFace(String face) {
            this.face = face;
        }

        public int getCoins() {
            return coins;
        }

        public void setCoins(int coins) {
            this.coins = coins;
        }

        public String getDisplayRank() {
            return DisplayRank;
        }

        public void setDisplayRank(String DisplayRank) {
            this.DisplayRank = DisplayRank;
        }

        public int getRegtime() {
            return regtime;
        }

        public void setRegtime(int regtime) {
            this.regtime = regtime;
        }

        public int getSpacesta() {
            return spacesta;
        }

        public void setSpacesta(int spacesta) {
            this.spacesta = spacesta;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public String getPlace() {
            return place;
        }

        public void setPlace(String place) {
            this.place = place;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getArticle() {
            return article;
        }

        public void setArticle(int article) {
            this.article = article;
        }

        public int getFans() {
            return fans;
        }

        public void setFans(int fans) {
            this.fans = fans;
        }

        public int getFriend() {
            return friend;
        }

        public void setFriend(int friend) {
            this.friend = friend;
        }

        public int getAttention() {
            return attention;
        }

        public void setAttention(int attention) {
            this.attention = attention;
        }

        public String getSign() {
            return sign;
        }

        public void setSign(String sign) {
            this.sign = sign;
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

        public List<Integer> getAttentions() {
            return attentions;
        }

        public void setAttentions(List<Integer> attentions) {
            this.attentions = attentions;
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
            private int expire;

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

            public int getExpire() {
                return expire;
            }

            public void setExpire(int expire) {
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
}
