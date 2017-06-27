package com.hotbitmapgg.bilibili.entity.user;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hcc on 2016/10/12 19:33
 * 100332338@qq.com
 * <p>
 * 用户详情兴趣圈模型类
 */

public class UserInterestQuanInfo implements Parcelable {
    private String ts;
    private int code;
    private int type;
    private DataBean data;

    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean implements Parcelable {
        private int total_count;
        private int total_page;
        private List<ResultBean> result;

        public int getTotal_count() {
            return total_count;
        }

        public void setTotal_count(int total_count) {
            this.total_count = total_count;
        }

        public int getTotal_page() {
            return total_page;
        }

        public void setTotal_page(int total_page) {
            this.total_page = total_page;
        }

        public List<ResultBean> getResult() {
            return result;
        }

        public void setResult(List<ResultBean> result) {
            this.result = result;
        }

        public static class ResultBean implements Parcelable {
            private int id;
            private String name;
            private String desc;
            private String thumb;
            private int post_count;
            private int post_count_today;
            private int is_join_community;
            private int member_count;
            private int certification;
            private int role_id;
            private String post_nickname;
            private String member_nickname;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getThumb() {
                return thumb;
            }

            public void setThumb(String thumb) {
                this.thumb = thumb;
            }

            public int getPost_count() {
                return post_count;
            }

            public void setPost_count(int post_count) {
                this.post_count = post_count;
            }

            public int getPost_count_today() {
                return post_count_today;
            }

            public void setPost_count_today(int post_count_today) {
                this.post_count_today = post_count_today;
            }

            public int getIs_join_community() {
                return is_join_community;
            }

            public void setIs_join_community(int is_join_community) {
                this.is_join_community = is_join_community;
            }

            public int getMember_count() {
                return member_count;
            }

            public void setMember_count(int member_count) {
                this.member_count = member_count;
            }

            public int getCertification() {
                return certification;
            }

            public void setCertification(int certification) {
                this.certification = certification;
            }

            public int getRole_id() {
                return role_id;
            }

            public void setRole_id(int role_id) {
                this.role_id = role_id;
            }

            public String getPost_nickname() {
                return post_nickname;
            }

            public void setPost_nickname(String post_nickname) {
                this.post_nickname = post_nickname;
            }

            public String getMember_nickname() {
                return member_nickname;
            }

            public void setMember_nickname(String member_nickname) {
                this.member_nickname = member_nickname;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeInt(this.id);
                dest.writeString(this.name);
                dest.writeString(this.desc);
                dest.writeString(this.thumb);
                dest.writeInt(this.post_count);
                dest.writeInt(this.post_count_today);
                dest.writeInt(this.is_join_community);
                dest.writeInt(this.member_count);
                dest.writeInt(this.certification);
                dest.writeInt(this.role_id);
                dest.writeString(this.post_nickname);
                dest.writeString(this.member_nickname);
            }


            public ResultBean() {
            }


            protected ResultBean(Parcel in) {
                this.id = in.readInt();
                this.name = in.readString();
                this.desc = in.readString();
                this.thumb = in.readString();
                this.post_count = in.readInt();
                this.post_count_today = in.readInt();
                this.is_join_community = in.readInt();
                this.member_count = in.readInt();
                this.certification = in.readInt();
                this.role_id = in.readInt();
                this.post_nickname = in.readString();
                this.member_nickname = in.readString();
            }


            public static final Creator<ResultBean> CREATOR = new Creator<ResultBean>() {
                @Override
                public ResultBean createFromParcel(Parcel source) {
                    return new ResultBean(source);
                }

                @Override
                public ResultBean[] newArray(int size) {
                    return new ResultBean[size];
                }
            };
        }


        @Override
        public int describeContents() {
            return 0;
        }


        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.total_count);
            dest.writeInt(this.total_page);
            dest.writeList(this.result);
        }


        public DataBean() {
        }


        protected DataBean(Parcel in) {
            this.total_count = in.readInt();
            this.total_page = in.readInt();
            this.result = new ArrayList<ResultBean>();
            in.readList(this.result, ResultBean.class.getClassLoader());
        }


        public static final Creator<DataBean> CREATOR = new Creator<DataBean>() {
            @Override
            public DataBean createFromParcel(Parcel source) {
                return new DataBean(source);
            }

            @Override
            public DataBean[] newArray(int size) {
                return new DataBean[size];
            }
        };
    }


    @Override
    public int describeContents() {
        return 0;
    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.ts);
        dest.writeInt(this.code);
        dest.writeInt(this.type);
        dest.writeParcelable(this.data, flags);
    }


    public UserInterestQuanInfo() {
    }


    protected UserInterestQuanInfo(Parcel in) {
        this.ts = in.readString();
        this.code = in.readInt();
        this.type = in.readInt();
        this.data = in.readParcelable(DataBean.class.getClassLoader());
    }


    public static final Parcelable.Creator<UserInterestQuanInfo> CREATOR
            = new Parcelable.Creator<UserInterestQuanInfo>() {

        @Override
        public UserInterestQuanInfo createFromParcel(Parcel source) {
            return new UserInterestQuanInfo(source);
        }


        @Override
        public UserInterestQuanInfo[] newArray(int size) {
            return new UserInterestQuanInfo[size];
        }
    };
}
