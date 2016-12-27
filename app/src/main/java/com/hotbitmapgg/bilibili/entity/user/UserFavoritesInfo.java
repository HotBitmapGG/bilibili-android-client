package com.hotbitmapgg.bilibili.entity.user;

import java.util.ArrayList;
import java.util.List;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by hcc on 2016/10/13 15:39
 * 100332338@qq.com
 * <p>
 * 用户收藏夹模型类
 */

public class UserFavoritesInfo implements Parcelable {

  /**
   * code : 0
   * data : [{"fid":1361235,"mid":159122,"name":"默认收藏夹","max_count":200,"cur_count":161,"atten_count":0,"state":0,"ctime":1438922096,"videos":[{"aid":6479279,"pic":"http://i2.hdslb.com/bfs/archive/64905249599c1f3bcde0789693302020ca755be5.jpg"},{"aid":6594604,"pic":"http://i2.hdslb.com/bfs/archive/d6e914a0a7b31bc4f8c510e5fed22e0af2e2c472.jpg"},{"aid":6625642,"pic":"http://i1.hdslb.com/bfs/archive/bf89b962bfd200d2c54ff5be41b7036250140364.jpg"}]},{"fid":24411892,"mid":159122,"name":"童年","max_count":150,"cur_count":65,"atten_count":0,"state":2,"ctime":1456309984,"videos":[{"aid":2836581,"pic":"http://i1.hdslb.com/video/63/633da1fd395a82c0edf76c39e61b8786.jpg"},{"aid":6049123,"pic":"http://i0.hdslb.com/bfs/archive/756459bd7d815014c78949ac95c27c7f77606098.jpg"},{"aid":5804090,"pic":"http://i0.hdslb.com/bfs/archive/659b42b0975b290e7b4219b1ec47b97287244fda.jpg"}]}]
   */

  private int code;

  /**
   * fid : 1361235
   * mid : 159122
   * name : 默认收藏夹
   * max_count : 200
   * cur_count : 161
   * atten_count : 0
   * state : 0
   * ctime : 1438922096
   * videos : [{"aid":6479279,"pic":"http://i2.hdslb.com/bfs/archive/64905249599c1f3bcde0789693302020ca755be5.jpg"},{"aid":6594604,"pic":"http://i2.hdslb.com/bfs/archive/d6e914a0a7b31bc4f8c510e5fed22e0af2e2c472.jpg"},{"aid":6625642,"pic":"http://i1.hdslb.com/bfs/archive/bf89b962bfd200d2c54ff5be41b7036250140364.jpg"}]
   */

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

    /**
     * aid : 6479279
     * pic : http://i2.hdslb.com/bfs/archive/64905249599c1f3bcde0789693302020ca755be5.jpg
     */

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
