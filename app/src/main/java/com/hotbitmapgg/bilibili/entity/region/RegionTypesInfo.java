package com.hotbitmapgg.bilibili.entity.region;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hcc on 2016/10/11 18:20
 * 100332338@qq.com
 * <p>
 * 分区数据模型类
 */

public class RegionTypesInfo implements Parcelable {
    private int code;
    private String message;
    private String ver;
    private List<DataBean> data;

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

    public String getVer() {
        return ver;
    }

    public void setVer(String ver) {
        this.ver = ver;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean implements Parcelable {
        private int tid;
        private int reid;
        private String name;
        private String logo;
        @SerializedName("goto")
        private String gotoX;
        private String param;
        private List<ChildrenBean> children;

        public int getTid() {
            return tid;
        }

        public void setTid(int tid) {
            this.tid = tid;
        }

        public int getReid() {
            return reid;
        }

        public void setReid(int reid) {
            this.reid = reid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLogo() {
            return logo;
        }

        public void setLogo(String logo) {
            this.logo = logo;
        }

        public String getGotoX() {
            return gotoX;
        }

        public void setGotoX(String gotoX) {
            this.gotoX = gotoX;
        }

        public String getParam() {
            return param;
        }

        public void setParam(String param) {
            this.param = param;
        }

        public List<ChildrenBean> getChildren() {
            return children;
        }

        public void setChildren(List<ChildrenBean> children) {
            this.children = children;
        }

        public static class ChildrenBean implements Parcelable {
            private int tid;
            private int reid;
            private String name;
            private String logo;
            @SerializedName("goto")
            private String gotoX;
            private String param;

            public int getTid() {
                return tid;
            }

            public void setTid(int tid) {
                this.tid = tid;
            }

            public int getReid() {
                return reid;
            }

            public void setReid(int reid) {
                this.reid = reid;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getLogo() {
                return logo;
            }

            public void setLogo(String logo) {
                this.logo = logo;
            }

            public String getGotoX() {
                return gotoX;
            }

            public void setGotoX(String gotoX) {
                this.gotoX = gotoX;
            }

            public String getParam() {
                return param;
            }

            public void setParam(String param) {
                this.param = param;
            }

            @Override
            public int describeContents() {
                return 0;
            }


            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeInt(this.tid);
                dest.writeInt(this.reid);
                dest.writeString(this.name);
                dest.writeString(this.logo);
                dest.writeString(this.gotoX);
                dest.writeString(this.param);
            }


            public ChildrenBean() {
            }


            protected ChildrenBean(Parcel in) {
                this.tid = in.readInt();
                this.reid = in.readInt();
                this.name = in.readString();
                this.logo = in.readString();
                this.gotoX = in.readString();
                this.param = in.readString();
            }

            public static final Creator<ChildrenBean> CREATOR = new Creator<ChildrenBean>() {

                @Override
                public ChildrenBean createFromParcel(Parcel source) {
                    return new ChildrenBean(source);
                }


                @Override
                public ChildrenBean[] newArray(int size) {
                    return new ChildrenBean[size];
                }
            };
        }


        @Override
        public int describeContents() {
            return 0;
        }


        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.tid);
            dest.writeInt(this.reid);
            dest.writeString(this.name);
            dest.writeString(this.logo);
            dest.writeString(this.gotoX);
            dest.writeString(this.param);
            dest.writeList(this.children);
        }


        public DataBean() {
        }


        protected DataBean(Parcel in) {
            this.tid = in.readInt();
            this.reid = in.readInt();
            this.name = in.readString();
            this.logo = in.readString();
            this.gotoX = in.readString();
            this.param = in.readString();
            this.children = new ArrayList<ChildrenBean>();
            in.readList(this.children, ChildrenBean.class.getClassLoader());
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
        dest.writeString(this.ver);
        dest.writeList(this.data);
    }


    public RegionTypesInfo() {
    }


    protected RegionTypesInfo(Parcel in) {
        this.code = in.readInt();
        this.message = in.readString();
        this.ver = in.readString();
        this.data = new ArrayList<DataBean>();
        in.readList(this.data, DataBean.class.getClassLoader());
    }

    public static final Creator<RegionTypesInfo> CREATOR = new Creator<RegionTypesInfo>() {
        @Override
        public RegionTypesInfo createFromParcel(Parcel source) {
            return new RegionTypesInfo(source);
        }

        @Override
        public RegionTypesInfo[] newArray(int size) {
            return new RegionTypesInfo[size];
        }
    };
}
