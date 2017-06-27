package com.hotbitmapgg.bilibili.entity.user;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by hcc on 2016/10/14 11:46
 * 100332338@qq.com
 * <p>
 * 用户详情界面的直播状态模型类
 */

public class UserLiveRoomStatusInfo implements Parcelable {
    private int code;
    private String message;
    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }


    public static class DataBean implements Parcelable {
        private int roomStatus;
        private int liveStatus;
        private String url;
        private String title;
        private String cover;
        private int online;
        private int roomid;

        public int getRoomStatus() {
            return roomStatus;
        }

        public void setRoomStatus(int roomStatus) {
            this.roomStatus = roomStatus;
        }

        public int getLiveStatus() {
            return liveStatus;
        }

        public void setLiveStatus(int liveStatus) {
            this.liveStatus = liveStatus;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
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

        public int getOnline() {
            return online;
        }

        public void setOnline(int online) {
            this.online = online;
        }

        public int getRoomid() {
            return roomid;
        }

        public void setRoomid(int roomid) {
            this.roomid = roomid;
        }

        @Override
        public int describeContents() {
            return 0;
        }


        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.roomStatus);
            dest.writeInt(this.liveStatus);
            dest.writeString(this.url);
            dest.writeString(this.title);
            dest.writeString(this.cover);
            dest.writeInt(this.online);
            dest.writeInt(this.roomid);
        }

        public DataBean() {
        }


        protected DataBean(Parcel in) {
            this.roomStatus = in.readInt();
            this.liveStatus = in.readInt();
            this.url = in.readString();
            this.title = in.readString();
            this.cover = in.readString();
            this.online = in.readInt();
            this.roomid = in.readInt();
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
        dest.writeString(this.message);
        dest.writeParcelable(this.data, flags);
    }


    public UserLiveRoomStatusInfo() {
    }


    protected UserLiveRoomStatusInfo(Parcel in) {
        this.code = in.readInt();
        this.message = in.readString();
        this.data = in.readParcelable(DataBean.class.getClassLoader());
    }


    public static final Parcelable.Creator<UserLiveRoomStatusInfo> CREATOR
            = new Parcelable.Creator<UserLiveRoomStatusInfo>() {

        @Override
        public UserLiveRoomStatusInfo createFromParcel(Parcel source) {
            return new UserLiveRoomStatusInfo(source);
        }


        @Override
        public UserLiveRoomStatusInfo[] newArray(int size) {
            return new UserLiveRoomStatusInfo[size];
        }
    };
}
