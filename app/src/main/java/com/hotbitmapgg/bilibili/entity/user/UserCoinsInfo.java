package com.hotbitmapgg.bilibili.entity.user;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hcc on 2016/10/12 22:10
 * 100332338@qq.com
 * <p>
 * 用户详情投币模型类
 */

public class UserCoinsInfo implements Parcelable {

  /**
   * status : true
   * data : {"list":[{"aid":7157356,"pic":"http://i1.hdslb.com/bfs/archive/4b4f985f505a5423e63dc49a723c29dd808862c4.jpg","title":"【MMD配布预告】哪个是你老婆呢？随心所欲Mercy
   * [崩坏3模型5人组×K3ls渲]","stat":{"view":610,"danmaku":14,"reply":31,"favorite":70,"coin":36,"share":1,"now_rank":0,"his_rank":0}},{"aid":7076004,"pic":"http://i1.hdslb.com/bfs/archive/d8df0f38c25b6c5775f2c0ddc020fc5929acb4d5.jpg","title":"【MMD】drop
   * pop candy 【简易PV】","stat":{"view":446,"danmaku":7,"reply":21,"favorite":62,"coin":45,"share":2,"now_rank":0,"his_rank":0}}],"pages":1,"count":2}
   */

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

    /**
     * list : [{"aid":7157356,"pic":"http://i1.hdslb.com/bfs/archive/4b4f985f505a5423e63dc49a723c29dd808862c4.jpg","title":"【MMD配布预告】哪个是你老婆呢？随心所欲Mercy
     * [崩坏3模型5人组×K3ls渲]","stat":{"view":610,"danmaku":14,"reply":31,"favorite":70,"coin":36,"share":1,"now_rank":0,"his_rank":0}},{"aid":7076004,"pic":"http://i1.hdslb.com/bfs/archive/d8df0f38c25b6c5775f2c0ddc020fc5929acb4d5.jpg","title":"【MMD】drop
     * pop candy 【简易PV】","stat":{"view":446,"danmaku":7,"reply":21,"favorite":62,"coin":45,"share":2,"now_rank":0,"his_rank":0}}]
     * pages : 1
     * count : 2
     */

    private int pages;

    private int count;

    private List<ListBean> list;


    public int getPages() {

      return pages;
    }


    public void setPages(int pages) {

      this.pages = pages;
    }


    public int getCount() {

      return count;
    }


    public void setCount(int count) {

      this.count = count;
    }


    public List<ListBean> getList() {

      return list;
    }


    public void setList(List<ListBean> list) {

      this.list = list;
    }


    public static class ListBean implements Parcelable {

      /**
       * aid : 7157356
       * pic : http://i1.hdslb.com/bfs/archive/4b4f985f505a5423e63dc49a723c29dd808862c4.jpg
       * title : 【MMD配布预告】哪个是你老婆呢？随心所欲Mercy [崩坏3模型5人组×K3ls渲]
       * stat : {"view":610,"danmaku":14,"reply":31,"favorite":70,"coin":36,"share":1,"now_rank":0,"his_rank":0}
       */

      private int aid;

      private String pic;

      private String title;

      private StatBean stat;


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


      public String getTitle() {

        return title;
      }


      public void setTitle(String title) {

        this.title = title;
      }


      public StatBean getStat() {

        return stat;
      }


      public void setStat(StatBean stat) {

        this.stat = stat;
      }


      public static class StatBean implements Parcelable {

        /**
         * view : 610
         * danmaku : 14
         * reply : 31
         * favorite : 70
         * coin : 36
         * share : 1
         * now_rank : 0
         * his_rank : 0
         */

        private int view;

        private int danmaku;

        private int reply;

        private int favorite;

        private int coin;

        private int share;

        private int now_rank;

        private int his_rank;


        public int getView() {

          return view;
        }


        public void setView(int view) {

          this.view = view;
        }


        public int getDanmaku() {

          return danmaku;
        }


        public void setDanmaku(int danmaku) {

          this.danmaku = danmaku;
        }


        public int getReply() {

          return reply;
        }


        public void setReply(int reply) {

          this.reply = reply;
        }


        public int getFavorite() {

          return favorite;
        }


        public void setFavorite(int favorite) {

          this.favorite = favorite;
        }


        public int getCoin() {

          return coin;
        }


        public void setCoin(int coin) {

          this.coin = coin;
        }


        public int getShare() {

          return share;
        }


        public void setShare(int share) {

          this.share = share;
        }


        public int getNow_rank() {

          return now_rank;
        }


        public void setNow_rank(int now_rank) {

          this.now_rank = now_rank;
        }


        public int getHis_rank() {

          return his_rank;
        }


        public void setHis_rank(int his_rank) {

          this.his_rank = his_rank;
        }


        @Override
        public int describeContents() {

          return 0;
        }


        @Override
        public void writeToParcel(Parcel dest, int flags) {

          dest.writeInt(this.view);
          dest.writeInt(this.danmaku);
          dest.writeInt(this.reply);
          dest.writeInt(this.favorite);
          dest.writeInt(this.coin);
          dest.writeInt(this.share);
          dest.writeInt(this.now_rank);
          dest.writeInt(this.his_rank);
        }


        public StatBean() {

        }


        protected StatBean(Parcel in) {

          this.view = in.readInt();
          this.danmaku = in.readInt();
          this.reply = in.readInt();
          this.favorite = in.readInt();
          this.coin = in.readInt();
          this.share = in.readInt();
          this.now_rank = in.readInt();
          this.his_rank = in.readInt();
        }


        public static final Creator<StatBean> CREATOR = new Creator<StatBean>() {

          @Override
          public StatBean createFromParcel(Parcel source) {

            return new StatBean(source);
          }


          @Override
          public StatBean[] newArray(int size) {

            return new StatBean[size];
          }
        };
      }


      @Override
      public int describeContents() {

        return 0;
      }


      @Override
      public void writeToParcel(Parcel dest, int flags) {

        dest.writeInt(this.aid);
        dest.writeString(this.pic);
        dest.writeString(this.title);
        dest.writeParcelable(this.stat, flags);
      }


      public ListBean() {

      }


      protected ListBean(Parcel in) {

        this.aid = in.readInt();
        this.pic = in.readString();
        this.title = in.readString();
        this.stat = in.readParcelable(StatBean.class.getClassLoader());
      }


      public static final Creator<ListBean> CREATOR = new Creator<ListBean>() {

        @Override
        public ListBean createFromParcel(Parcel source) {

          return new ListBean(source);
        }


        @Override
        public ListBean[] newArray(int size) {

          return new ListBean[size];
        }
      };
    }


    @Override
    public int describeContents() {

      return 0;
    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {

      dest.writeInt(this.pages);
      dest.writeInt(this.count);
      dest.writeList(this.list);
    }


    public DataBean() {

    }


    protected DataBean(Parcel in) {

      this.pages = in.readInt();
      this.count = in.readInt();
      this.list = new ArrayList<ListBean>();
      in.readList(this.list, ListBean.class.getClassLoader());
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


  public UserCoinsInfo() {

  }


  protected UserCoinsInfo(Parcel in) {

    this.status = in.readByte() != 0;
    this.data = in.readParcelable(DataBean.class.getClassLoader());
  }


  public static final Parcelable.Creator<UserCoinsInfo> CREATOR
      = new Parcelable.Creator<UserCoinsInfo>() {

    @Override
    public UserCoinsInfo createFromParcel(Parcel source) {

      return new UserCoinsInfo(source);
    }


    @Override
    public UserCoinsInfo[] newArray(int size) {

      return new UserCoinsInfo[size];
    }
  };
}
