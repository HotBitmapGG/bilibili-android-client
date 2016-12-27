package com.hotbitmapgg.bilibili.entity.user;

import java.util.ArrayList;
import java.util.List;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by hcc on 2016/10/12 22:39
 * 100332338@qq.com
 * <p>
 * 用户详情所玩游戏模型类
 */

public class UserPlayGameInfo implements Parcelable {

  /**
   * status : true
   * data : {"games":[{"website":"http://yys.biligame.com/","image":"http://i0.hdslb.com/bfs/game/3b205675d44bbd90e6ea46d4baec9674bda6e642.png","name":"阴阳师"},{"website":"http://djsy.biligame.com/","image":"http://i0.hdslb.com/bfs/game/80008bbf4cb9b0343fd6e4325127645b2323c1a3.png","name":"刀剑神域黑衣剑士"},{"website":"http://acg.tv/u1g3","image":"http://i0.hdslb.com/u_user/7baceb341073fe823faad36d2e1c805e.png","name":"ICHU偶像进行曲"},{"website":"http://100p.biligame.com/","image":"http://i0.hdslb.com/bfs/game/3e8f079c18c2f81627703c0914e3c285f6d1a7b2.png","name":"梦100"},{"website":"http://xsqst.biligame.com/","image":"http://i2.hdslb.com/u_user/b3c01eb5b7d9925e4488f581baef8006.jpg","name":"像素骑士团"}],"count":5}
   */

  private boolean status;

  /**
   * games : [{"website":"http://yys.biligame.com/","image":"http://i0.hdslb.com/bfs/game/3b205675d44bbd90e6ea46d4baec9674bda6e642.png","name":"阴阳师"},{"website":"http://djsy.biligame.com/","image":"http://i0.hdslb.com/bfs/game/80008bbf4cb9b0343fd6e4325127645b2323c1a3.png","name":"刀剑神域黑衣剑士"},{"website":"http://acg.tv/u1g3","image":"http://i0.hdslb.com/u_user/7baceb341073fe823faad36d2e1c805e.png","name":"ICHU偶像进行曲"},{"website":"http://100p.biligame.com/","image":"http://i0.hdslb.com/bfs/game/3e8f079c18c2f81627703c0914e3c285f6d1a7b2.png","name":"梦100"},{"website":"http://xsqst.biligame.com/","image":"http://i2.hdslb.com/u_user/b3c01eb5b7d9925e4488f581baef8006.jpg","name":"像素骑士团"}]
   * count : 5
   */

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

    /**
     * website : http://yys.biligame.com/
     * image : http://i0.hdslb.com/bfs/game/3b205675d44bbd90e6ea46d4baec9674bda6e642.png
     * name : 阴阳师
     */

    private List<GamesBean> games;


    public int getCount() {

      return count;
    }


    public void setCount(int count) {

      this.count = count;
    }


    public List<GamesBean> getGames() {

      return games;
    }


    public void setGames(List<GamesBean> games) {

      this.games = games;
    }


    public static class GamesBean implements Parcelable {

      private String website;

      private String image;

      private String name;


      public String getWebsite() {

        return website;
      }


      public void setWebsite(String website) {

        this.website = website;
      }


      public String getImage() {

        return image;
      }


      public void setImage(String image) {

        this.image = image;
      }


      public String getName() {

        return name;
      }


      public void setName(String name) {

        this.name = name;
      }


      @Override
      public int describeContents() {

        return 0;
      }


      @Override
      public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(this.website);
        dest.writeString(this.image);
        dest.writeString(this.name);
      }


      public GamesBean() {

      }


      protected GamesBean(Parcel in) {

        this.website = in.readString();
        this.image = in.readString();
        this.name = in.readString();
      }


      public static final Creator<GamesBean> CREATOR = new Creator<GamesBean>() {

        @Override
        public GamesBean createFromParcel(Parcel source) {

          return new GamesBean(source);
        }


        @Override
        public GamesBean[] newArray(int size) {

          return new GamesBean[size];
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
      dest.writeList(this.games);
    }


    public DataBean() {

    }


    protected DataBean(Parcel in) {

      this.count = in.readInt();
      this.games = new ArrayList<GamesBean>();
      in.readList(this.games, GamesBean.class.getClassLoader());
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


  public UserPlayGameInfo() {

  }


  protected UserPlayGameInfo(Parcel in) {

    this.status = in.readByte() != 0;
    this.data = in.readParcelable(DataBean.class.getClassLoader());
  }


  public static final Parcelable.Creator<UserPlayGameInfo> CREATOR
      = new Parcelable.Creator<UserPlayGameInfo>() {

    @Override
    public UserPlayGameInfo createFromParcel(Parcel source) {

      return new UserPlayGameInfo(source);
    }


    @Override
    public UserPlayGameInfo[] newArray(int size) {

      return new UserPlayGameInfo[size];
    }
  };
}
