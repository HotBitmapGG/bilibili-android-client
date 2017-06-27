package com.hotbitmapgg.bilibili.entity.user;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hcc on 2016/10/13 15:39
 * 100332338@qq.com
 * <p>
 * 用户收藏夹模型类
 */

public class UserFavoritesInfo implements Parcelable {
    private int code;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }


    public static class DataBean implements Parcelable {
        private int fid;
        private int mid;
        private String name;
        private int max_count;
        private int cur_count;
        private int atten_count;
        private int state;
        private int ctime;
        private List<VideosBean> videos;

        public int getFid() {
            return fid;
        }

        public void setFid(int fid) {
            this.fid = fid;
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

        public int getMax_count() {
            return max_count;
        }

        public void setMax_count(int max_count) {
            this.max_count = max_count;
        }

        public int getCur_count() {
            return cur_count;
        }

        public void setCur_count(int cur_count) {
            this.cur_count = cur_count;
        }

        public int getAtten_count() {
            return atten_count;
        }

        public void setAtten_count(int atten_count) {
            this.atten_count = atten_count;
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

        public List<VideosBean> getVideos() {
            return videos;
        }

        public void setVideos(List<VideosBean> videos) {
            this.videos = videos;
        }

        public static class VideosBean implements Parcelable {
            private int aid;
            private String pic;

            public int getAid() {
                return aid;
            }

            public void setAid(int aid) {
                this.aid = aid;
            }

            public String getPic() {
                return pic;
            }

            public void setPic(String pic) {
                this.pic = pic;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeInt(this.aid);
                dest.writeString(this.pic);
            }

            public VideosBean() {
            }


            protected VideosBean(Parcel in) {
                this.aid = in.readInt();
                this.pic = in.readString();
            }

            public static final Creator<VideosBean> CREATOR = new Creator<VideosBean>() {
                @Override
                public VideosBean createFromParcel(Parcel source) {
                    return new VideosBean(source);
                }

                @Override
                public VideosBean[] newArray(int size) {
                    return new VideosBean[size];
                }
            };
        }


        @Override
        public int describeContents() {
            return 0;
        }


        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.fid);
            dest.writeInt(this.mid);
            dest.writeString(this.name);
            dest.writeInt(this.max_count);
            dest.writeInt(this.cur_count);
            dest.writeInt(this.atten_count);
            dest.writeInt(this.state);
            dest.writeInt(this.ctime);
            dest.writeList(this.videos);
        }


        public DataBean() {
        }


        protected DataBean(Parcel in) {
            this.fid = in.readInt();
            this.mid = in.readInt();
            this.name = in.readString();
            this.max_count = in.readInt();
            this.cur_count = in.readInt();
            this.atten_count = in.readInt();
            this.state = in.readInt();
            this.ctime = in.readInt();
            this.videos = new ArrayList<VideosBean>();
            in.readList(this.videos, VideosBean.class.getClassLoader());
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
        dest.writeInt(this.code);
        dest.writeList(this.data);
    }

    public UserFavoritesInfo() {
    }


    protected UserFavoritesInfo(Parcel in) {
        this.code = in.readInt();
        this.data = new ArrayList<DataBean>();
        in.readList(this.data, DataBean.class.getClassLoader());
    }


    public static final Parcelable.Creator<UserFavoritesInfo> CREATOR
            = new Parcelable.Creator<UserFavoritesInfo>() {

        @Override
        public UserFavoritesInfo createFromParcel(Parcel source) {
            return new UserFavoritesInfo(source);
        }


        @Override
        public UserFavoritesInfo[] newArray(int size) {
            return new UserFavoritesInfo[size];
        }
    };
}
