package com.hotbitmapgg.bilibili.entity.bangumi;

import java.util.List;

/**
 * Created by hcc on 2016/11/1 21:20
 * 100332338@qq.com
 * <p>
 * 番剧详情番剧评论模型类
 */

public class BangumiDetailsCommentInfo {
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
        private PageBean page;
        private List<HotsBean> hots;
        private List<RepliesBean> replies;

        public PageBean getPage() {
            return page;
        }

        public void setPage(PageBean page) {
            this.page = page;
        }

        public List<HotsBean> getHots() {
            return hots;
        }

        public void setHots(List<HotsBean> hots) {
            this.hots = hots;
        }

        public List<RepliesBean> getReplies() {
            return replies;
        }

        public void setReplies(List<RepliesBean> replies) {
            this.replies = replies;
        }

        public static class PageBean {
            private int acount;
            private int count;
            private int num;
            private int size;

            public int getAcount() {
                return acount;
            }

            public void setAcount(int acount) {
                this.acount = acount;
            }

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

        public static class HotsBean {
            private int rpid;
            private int oid;
            private int type;
            private int mid;
            private int root;
            private int parent;
            private int count;
            private int rcount;
            private int floor;
            private int state;
            private int ctime;
            private String rpid_str;
            private String root_str;
            private String parent_str;
            private int like;
            private int action;
            private MemberBean member;
            private ContentBean content;
            private List<?> replies;

            public int getRpid() {
                return rpid;
            }

            public void setRpid(int rpid) {
                this.rpid = rpid;
            }

            public int getOid() {
                return oid;
            }

            public void setOid(int oid) {
                this.oid = oid;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public int getMid() {
                return mid;
            }

            public void setMid(int mid) {
                this.mid = mid;
            }

            public int getRoot() {
                return root;
            }

            public void setRoot(int root) {
                this.root = root;
            }

            public int getParent() {
                return parent;
            }

            public void setParent(int parent) {
                this.parent = parent;
            }

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }

            public int getRcount() {
                return rcount;
            }

            public void setRcount(int rcount) {
                this.rcount = rcount;
            }

            public int getFloor() {
                return floor;
            }

            public void setFloor(int floor) {
                this.floor = floor;
            }

            public int getState() {
                return state;
            }

            public void setState(int state) {
                this.state = state;
            }

            public int getCtime() {
                return ctime;
            }

            public void setCtime(int ctime) {
                this.ctime = ctime;
            }

            public String getRpid_str() {
                return rpid_str;
            }

            public void setRpid_str(String rpid_str) {
                this.rpid_str = rpid_str;
            }

            public String getRoot_str() {
                return root_str;
            }

            public void setRoot_str(String root_str) {
                this.root_str = root_str;
            }

            public String getParent_str() {
                return parent_str;
            }

            public void setParent_str(String parent_str) {
                this.parent_str = parent_str;
            }

            public int getLike() {
                return like;
            }

            public void setLike(int like) {
                this.like = like;
            }

            public int getAction() {
                return action;
            }

            public void setAction(int action) {
                this.action = action;
            }

            public MemberBean getMember() {
                return member;
            }

            public void setMember(MemberBean member) {
                this.member = member;
            }

            public ContentBean getContent() {
                return content;
            }

            public void setContent(ContentBean content) {
                this.content = content;
            }

            public List<?> getReplies() {
                return replies;
            }

            public void setReplies(List<?> replies) {
                this.replies = replies;
            }

            public static class MemberBean {
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
                private VipBean vip;

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

                public VipBean getVip() {
                    return vip;
                }

                public void setVip(VipBean vip) {
                    this.vip = vip;
                }

                public static class LevelInfoBean {
                    private int current_level;
                    private int current_min;
                    private int current_exp;
                    private int next_exp;

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

                    public int getNext_exp() {
                        return next_exp;
                    }

                    public void setNext_exp(int next_exp) {
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

                public static class VipBean {
                    private int vipType;
                    private long vipDueDate;
                    private String dueRemark;
                    private int accessStatus;
                    private int vipStatus;
                    private String vipStatusWarn;

                    public int getVipType() {
                        return vipType;
                    }

                    public void setVipType(int vipType) {
                        this.vipType = vipType;
                    }

                    public long getVipDueDate() {
                        return vipDueDate;
                    }

                    public void setVipDueDate(long vipDueDate) {
                        this.vipDueDate = vipDueDate;
                    }

                    public String getDueRemark() {
                        return dueRemark;
                    }

                    public void setDueRemark(String dueRemark) {
                        this.dueRemark = dueRemark;
                    }

                    public int getAccessStatus() {
                        return accessStatus;
                    }

                    public void setAccessStatus(int accessStatus) {
                        this.accessStatus = accessStatus;
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
                }
            }

            public static class ContentBean {
                private String message;
                private int plat;
                private String device;
                private List<?> members;

                public String getMessage() {
                    return message;
                }

                public void setMessage(String message) {
                    this.message = message;
                }

                public int getPlat() {
                    return plat;
                }

                public void setPlat(int plat) {
                    this.plat = plat;
                }

                public String getDevice() {
                    return device;
                }

                public void setDevice(String device) {
                    this.device = device;
                }

                public List<?> getMembers() {
                    return members;
                }

                public void setMembers(List<?> members) {
                    this.members = members;
                }
            }
        }

        public static class RepliesBean {
            private int rpid;
            private int oid;
            private int type;
            private int mid;
            private int root;
            private int parent;
            private int count;
            private int rcount;
            private int floor;
            private int state;
            private int ctime;
            private String rpid_str;
            private String root_str;
            private String parent_str;
            private int like;
            private int action;
            private MemberBean member;
            private ContentBean content;
            private List<?> replies;

            public int getRpid() {
                return rpid;
            }

            public void setRpid(int rpid) {
                this.rpid = rpid;
            }

            public int getOid() {
                return oid;
            }

            public void setOid(int oid) {
                this.oid = oid;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public int getMid() {
                return mid;
            }

            public void setMid(int mid) {
                this.mid = mid;
            }

            public int getRoot() {
                return root;
            }

            public void setRoot(int root) {
                this.root = root;
            }

            public int getParent() {
                return parent;
            }

            public void setParent(int parent) {
                this.parent = parent;
            }

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }

            public int getRcount() {
                return rcount;
            }

            public void setRcount(int rcount) {
                this.rcount = rcount;
            }

            public int getFloor() {
                return floor;
            }

            public void setFloor(int floor) {
                this.floor = floor;
            }

            public int getState() {
                return state;
            }

            public void setState(int state) {
                this.state = state;
            }

            public int getCtime() {
                return ctime;
            }

            public void setCtime(int ctime) {
                this.ctime = ctime;
            }

            public String getRpid_str() {
                return rpid_str;
            }

            public void setRpid_str(String rpid_str) {
                this.rpid_str = rpid_str;
            }

            public String getRoot_str() {
                return root_str;
            }

            public void setRoot_str(String root_str) {
                this.root_str = root_str;
            }

            public String getParent_str() {
                return parent_str;
            }

            public void setParent_str(String parent_str) {
                this.parent_str = parent_str;
            }

            public int getLike() {
                return like;
            }

            public void setLike(int like) {
                this.like = like;
            }

            public int getAction() {
                return action;
            }

            public void setAction(int action) {
                this.action = action;
            }

            public MemberBean getMember() {
                return member;
            }

            public void setMember(MemberBean member) {
                this.member = member;
            }

            public ContentBean getContent() {
                return content;
            }

            public void setContent(ContentBean content) {
                this.content = content;
            }

            public List<?> getReplies() {
                return replies;
            }

            public void setReplies(List<?> replies) {
                this.replies = replies;
            }

            public static class MemberBean {
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
                private VipBean vip;

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

                public VipBean getVip() {
                    return vip;
                }

                public void setVip(VipBean vip) {
                    this.vip = vip;
                }

                public static class LevelInfoBean {
                    private int current_level;
                    private int current_min;
                    private int current_exp;
                    private int next_exp;

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

                    public int getNext_exp() {
                        return next_exp;
                    }

                    public void setNext_exp(int next_exp) {
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

                public static class VipBean {
                    private int vipType;
                    private long vipDueDate;
                    private String dueRemark;
                    private int accessStatus;
                    private int vipStatus;
                    private String vipStatusWarn;

                    public int getVipType() {
                        return vipType;
                    }

                    public void setVipType(int vipType) {
                        this.vipType = vipType;
                    }

                    public long getVipDueDate() {
                        return vipDueDate;
                    }

                    public void setVipDueDate(long vipDueDate) {
                        this.vipDueDate = vipDueDate;
                    }

                    public String getDueRemark() {
                        return dueRemark;
                    }

                    public void setDueRemark(String dueRemark) {
                        this.dueRemark = dueRemark;
                    }

                    public int getAccessStatus() {
                        return accessStatus;
                    }

                    public void setAccessStatus(int accessStatus) {
                        this.accessStatus = accessStatus;
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
                }
            }

            public static class ContentBean {
                private String message;
                private int plat;
                private String device;
                private List<?> members;

                public String getMessage() {
                    return message;
                }

                public void setMessage(String message) {
                    this.message = message;
                }

                public int getPlat() {
                    return plat;
                }

                public void setPlat(int plat) {
                    this.plat = plat;
                }

                public String getDevice() {
                    return device;
                }

                public void setDevice(String device) {
                    this.device = device;
                }

                public List<?> getMembers() {
                    return members;
                }

                public void setMembers(List<?> members) {
                    this.members = members;
                }
            }
        }
    }
}
