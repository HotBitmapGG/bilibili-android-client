package com.hotbitmapgg.bilibili.entity.user;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hcc on 2016/10/12 17:11
 * 100332338@qq.com
 * <p>
 * 用户投稿视频模型类
 */

public class UserContributeInfo implements Parcelable {
    private boolean status;
    private DataBean data;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean implements Parcelable {
        private int count;
        private int pages;
        private List<VlistBean> vlist;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public int getPages() {
            return pages;
        }

        public void setPages(int pages) {
            this.pages = pages;
        }

        public List<VlistBean> getVlist() {
            return vlist;
        }

        public void setVlist(List<VlistBean> vlist) {
            this.vlist = vlist;
        }

        public static class VlistBean implements Parcelable {
            private int aid;
            private String copyright;
            private int typeid;
            private String title;
            private String subtitle;
            private int play;
            private int review;
            private int video_review;
            private int favorites;
            private int mid;
            private String author;
            private String description;
            private String created;
            private String pic;
            private int comment;
            private String length;

            public int getAid() {
                return aid;
            }

            public void setAid(int aid) {
                this.aid = aid;
            }

            public String getCopyright() {
                return copyright;
            }

            public void setCopyright(String copyright) {
                this.copyright = copyright;
            }

            public int getTypeid() {
                return typeid;
            }

            public void setTypeid(int typeid) {
                this.typeid = typeid;
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

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getCreated() {
                return created;
            }

            public void setCreated(String created) {
                this.created = created;
            }

            public String getPic() {
                return pic;
            }

            public void setPic(String pic) {
                this.pic = pic;
            }

            public int getComment() {
                return comment;
            }

            public void setComment(int comment) {
                this.comment = comment;
            }

            public String getLength() {
                return length;
            }

            public void setLength(String length) {
                this.length = length;
            }


            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeInt(this.aid);
                dest.writeString(this.copyright);
                dest.writeInt(this.typeid);
                dest.writeString(this.title);
                dest.writeString(this.subtitle);
                dest.writeInt(this.play);
                dest.writeInt(this.review);
                dest.writeInt(this.video_review);
                dest.writeInt(this.favorites);
                dest.writeInt(this.mid);
                dest.writeString(this.author);
                dest.writeString(this.description);
                dest.writeString(this.created);
                dest.writeString(this.pic);
                dest.writeInt(this.comment);
                dest.writeString(this.length);
            }

            public VlistBean() {
            }


            protected VlistBean(Parcel in) {
                this.aid = in.readInt();
                this.copyright = in.readString();
                this.typeid = in.readInt();
                this.title = in.readString();
                this.subtitle = in.readString();
                this.play = in.readInt();
                this.review = in.readInt();
                this.video_review = in.readInt();
                this.favorites = in.readInt();
                this.mid = in.readInt();
                this.author = in.readString();
                this.description = in.readString();
                this.created = in.readString();
                this.pic = in.readString();
                this.comment = in.readInt();
                this.length = in.readString();
            }


            public static final Creator<VlistBean> CREATOR = new Creator<VlistBean>() {
                @Override
                public VlistBean createFromParcel(Parcel source) {
                    return new VlistBean(source);
                }


                @Override
                public VlistBean[] newArray(int size) {
                    return new VlistBean[size];
                }
            };
        }


        @Override
        public int describeContents() {
            return 0;
        }


        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.count);
            dest.writeInt(this.pages);
            dest.writeList(this.vlist);
        }


        public DataBean() {
        }


        protected DataBean(Parcel in) {
            this.count = in.readInt();
            this.pages = in.readInt();
            this.vlist = new ArrayList<VlistBean>();
            in.readList(this.vlist, VlistBean.class.getClassLoader());
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
        dest.writeByte(this.status ? (byte) 1 : (byte) 0);
        dest.writeParcelable(this.data, flags);
    }


    public UserContributeInfo() {
    }


    protected UserContributeInfo(Parcel in) {
        this.status = in.readByte() != 0;
        this.data = in.readParcelable(DataBean.class.getClassLoader());
    }


    public static final Parcelable.Creator<UserContributeInfo> CREATOR
            = new Parcelable.Creator<UserContributeInfo>() {

        @Override
        public UserContributeInfo createFromParcel(Parcel source) {
            return new UserContributeInfo(source);
        }

        @Override
        public UserContributeInfo[] newArray(int size) {
            return new UserContributeInfo[size];
        }
    };
}
