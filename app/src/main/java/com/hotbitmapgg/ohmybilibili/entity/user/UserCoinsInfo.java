package com.hotbitmapgg.ohmybilibili.entity.user;

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

public class UserCoinsInfo implements Parcelable
{

    /**
     * status : true
     * data : {"list":[{"aid":6303824,"tid":28,"tname":"原创音乐","copyright":1,"pic":"http://i0.hdslb.com/bfs/archive/0be59f2ad8ebfeff9ffc02b6c958a1a106f2b51c.jpg","title":"【凹凸君说】夏家三千菜 【给夏一可夏姬八唱首歌】","pubdate":1474014991,"ctime":1474014991,"desc":"早早答应@夏一可  女王大人要写歌给她～然而一直拖到现在。。。不过昨晚正好看到有人说手艺人拖延不叫拖延！叫艺术沉淀需要时间的洗礼！于是就洗礼出了这首歌！有没有摇起来滚起来的感觉？感谢女王大人的耐心等待和种子提供~\n微博：@凹凸君说 weibo.com/aotujunshuo\n编曲：土司、STML\n填词：土司\nPV：aoto\n再次感谢@夏一可 ~\n","state":0,"attribute":540672,"duration":244,"tags":["夏一可","国人男声","原创编曲","守望先锋","凹凸君说","午时已到","夏家三千菜","厉害了我的歌","夏姬八唱"],"rights":{"bp":0,"elec":0,"download":0,"movie":0,"pay":0,"hd5":0},"owner":{"mid":20484551,"name":"凹凸君说","face":"http://i2.hdslb.com/bfs/face/d82be1e7132697946d3d6b6cd4cc07e2ff687215.jpg"},"stat":{"view":400444,"danmaku":2679,"reply":1361,"favorite":19754,"coin":22663,"share":3773,"now_rank":0,"his_rank":78},"ip":"27.217.132.88","time":1474205206,"coins":2},{"aid":6262080,"tid":31,"tname":"翻唱","copyright":1,"pic":"http://i1.hdslb.com/bfs/archive/33ee966a9a144f464072bae2ed4bf45d9b123e4f.jpg","title":"【33是抠脚kami【翻唱】岁月神偷","pubdate":1473750990,"ctime":1473750990,"desc":"米纳桑好啊我是33\n这是我第一次投稿翻唱作品\n非专业录制\n喜欢的小伙伴投个硬币吧~\n么么哒\u2044(\u2044 \u2044\u2022\u2044ω\u2044\u2022\u2044 \u2044)\u2044","state":0,"attribute":540672,"duration":247,"tags":["岁月神偷","翻唱","金玟岐"],"rights":{"bp":0,"elec":0,"download":0,"movie":0,"pay":0,"hd5":0},"owner":{"mid":8919801,"name":"听说33是个很咸的词","face":"http://i1.hdslb.com/bfs/face/f74048bf554a3b27cf618ed9fca83841e5a33d69.gif"},"stat":{"view":296,"danmaku":22,"reply":26,"favorite":6,"coin":71,"share":2,"now_rank":0,"his_rank":0},"ip":"27.217.132.88","time":1473758355,"coins":2},{"aid":6254109,"tid":83,"tname":"其他国家","copyright":2,"pic":"http://i2.hdslb.com/bfs/archive/9c8efd5179ab9994751649476775d39ddbbbb3bb.jpg","title":"【惊悚/灾难】釜山行 2016 中文字幕 1080P 孔侑 郑有美 【TSKS】","pubdate":1473680355,"ctime":1473680355,"desc":"直传 首尔站：釜山行前传 av6484311  链接：http://pan.baidu.com/s/1o8jfNAU 密码：v7q2  抓紧存咯~叫你们不听话~","state":0,"access":10000,"attribute":540672,"duration":7080,"tags":["泪腺崩坏","孔侑","釜山行","会员的世界","我敬你是条汉子","丧尸","全员奔跑啊","人性","夏威夷吉他"],"rights":{"bp":0,"elec":0,"download":0,"movie":0,"pay":0,"hd5":0},"owner":{"mid":2028824,"name":"mpor2","face":"http://i2.hdslb.com/bfs/face/7df214e54e255c862e0b0c9980ec2dc4bf228895.jpg"},"stat":{"view":0,"danmaku":561730,"reply":21785,"favorite":190097,"coin":45355,"share":43614,"now_rank":0,"his_rank":0},"ip":"27.217.132.88","time":1473748211,"coins":1}],"pages":1,"count":3}
     */

    private boolean status;

    /**
     * list : [{"aid":6303824,"tid":28,"tname":"原创音乐","copyright":1,"pic":"http://i0.hdslb.com/bfs/archive/0be59f2ad8ebfeff9ffc02b6c958a1a106f2b51c.jpg","title":"【凹凸君说】夏家三千菜 【给夏一可夏姬八唱首歌】","pubdate":1474014991,"ctime":1474014991,"desc":"早早答应@夏一可  女王大人要写歌给她～然而一直拖到现在。。。不过昨晚正好看到有人说手艺人拖延不叫拖延！叫艺术沉淀需要时间的洗礼！于是就洗礼出了这首歌！有没有摇起来滚起来的感觉？感谢女王大人的耐心等待和种子提供~\n微博：@凹凸君说 weibo.com/aotujunshuo\n编曲：土司、STML\n填词：土司\nPV：aoto\n再次感谢@夏一可 ~\n","state":0,"attribute":540672,"duration":244,"tags":["夏一可","国人男声","原创编曲","守望先锋","凹凸君说","午时已到","夏家三千菜","厉害了我的歌","夏姬八唱"],"rights":{"bp":0,"elec":0,"download":0,"movie":0,"pay":0,"hd5":0},"owner":{"mid":20484551,"name":"凹凸君说","face":"http://i2.hdslb.com/bfs/face/d82be1e7132697946d3d6b6cd4cc07e2ff687215.jpg"},"stat":{"view":400444,"danmaku":2679,"reply":1361,"favorite":19754,"coin":22663,"share":3773,"now_rank":0,"his_rank":78},"ip":"27.217.132.88","time":1474205206,"coins":2},{"aid":6262080,"tid":31,"tname":"翻唱","copyright":1,"pic":"http://i1.hdslb.com/bfs/archive/33ee966a9a144f464072bae2ed4bf45d9b123e4f.jpg","title":"【33是抠脚kami【翻唱】岁月神偷","pubdate":1473750990,"ctime":1473750990,"desc":"米纳桑好啊我是33\n这是我第一次投稿翻唱作品\n非专业录制\n喜欢的小伙伴投个硬币吧~\n么么哒\u2044(\u2044 \u2044\u2022\u2044ω\u2044\u2022\u2044 \u2044)\u2044","state":0,"attribute":540672,"duration":247,"tags":["岁月神偷","翻唱","金玟岐"],"rights":{"bp":0,"elec":0,"download":0,"movie":0,"pay":0,"hd5":0},"owner":{"mid":8919801,"name":"听说33是个很咸的词","face":"http://i1.hdslb.com/bfs/face/f74048bf554a3b27cf618ed9fca83841e5a33d69.gif"},"stat":{"view":296,"danmaku":22,"reply":26,"favorite":6,"coin":71,"share":2,"now_rank":0,"his_rank":0},"ip":"27.217.132.88","time":1473758355,"coins":2},{"aid":6254109,"tid":83,"tname":"其他国家","copyright":2,"pic":"http://i2.hdslb.com/bfs/archive/9c8efd5179ab9994751649476775d39ddbbbb3bb.jpg","title":"【惊悚/灾难】釜山行 2016 中文字幕 1080P 孔侑 郑有美 【TSKS】","pubdate":1473680355,"ctime":1473680355,"desc":"直传 首尔站：釜山行前传 av6484311  链接：http://pan.baidu.com/s/1o8jfNAU 密码：v7q2  抓紧存咯~叫你们不听话~","state":0,"access":10000,"attribute":540672,"duration":7080,"tags":["泪腺崩坏","孔侑","釜山行","会员的世界","我敬你是条汉子","丧尸","全员奔跑啊","人性","夏威夷吉他"],"rights":{"bp":0,"elec":0,"download":0,"movie":0,"pay":0,"hd5":0},"owner":{"mid":2028824,"name":"mpor2","face":"http://i2.hdslb.com/bfs/face/7df214e54e255c862e0b0c9980ec2dc4bf228895.jpg"},"stat":{"view":0,"danmaku":561730,"reply":21785,"favorite":190097,"coin":45355,"share":43614,"now_rank":0,"his_rank":0},"ip":"27.217.132.88","time":1473748211,"coins":1}]
     * pages : 1
     * count : 3
     */

    private DataBean data;

    public boolean isStatus()
    {

        return status;
    }

    public void setStatus(boolean status)
    {

        this.status = status;
    }

    public DataBean getData()
    {

        return data;
    }

    public void setData(DataBean data)
    {

        this.data = data;
    }

    public static class DataBean implements Parcelable
    {

        private int pages;

        private int count;

        /**
         * aid : 6303824
         * tid : 28
         * tname : 原创音乐
         * copyright : 1
         * pic : http://i0.hdslb.com/bfs/archive/0be59f2ad8ebfeff9ffc02b6c958a1a106f2b51c.jpg
         * title : 【凹凸君说】夏家三千菜 【给夏一可夏姬八唱首歌】
         * pubdate : 1474014991
         * ctime : 1474014991
         * desc : 早早答应@夏一可  女王大人要写歌给她～然而一直拖到现在。。。不过昨晚正好看到有人说手艺人拖延不叫拖延！叫艺术沉淀需要时间的洗礼！于是就洗礼出了这首歌！有没有摇起来滚起来的感觉？感谢女王大人的耐心等待和种子提供~
         * 微博：@凹凸君说 weibo.com/aotujunshuo
         * 编曲：土司、STML
         * 填词：土司
         * PV：aoto
         * 再次感谢@夏一可 ~
         * <p>
         * state : 0
         * attribute : 540672
         * duration : 244
         * tags : ["夏一可","国人男声","原创编曲","守望先锋","凹凸君说","午时已到","夏家三千菜","厉害了我的歌","夏姬八唱"]
         * rights : {"bp":0,"elec":0,"download":0,"movie":0,"pay":0,"hd5":0}
         * owner : {"mid":20484551,"name":"凹凸君说","face":"http://i2.hdslb.com/bfs/face/d82be1e7132697946d3d6b6cd4cc07e2ff687215.jpg"}
         * stat : {"view":400444,"danmaku":2679,"reply":1361,"favorite":19754,"coin":22663,"share":3773,"now_rank":0,"his_rank":78}
         * ip : 27.217.132.88
         * time : 1474205206
         * coins : 2
         */

        private List<ListBean> list;

        public int getPages()
        {

            return pages;
        }

        public void setPages(int pages)
        {

            this.pages = pages;
        }

        public int getCount()
        {

            return count;
        }

        public void setCount(int count)
        {

            this.count = count;
        }

        public List<ListBean> getList()
        {

            return list;
        }

        public void setList(List<ListBean> list)
        {

            this.list = list;
        }

        public static class ListBean implements Parcelable
        {

            private int aid;

            private int tid;

            private String tname;

            private int copyright;

            private String pic;

            private String title;

            private int pubdate;

            private int ctime;

            private String desc;

            private int state;

            private int attribute;

            private int duration;

            /**
             * bp : 0
             * elec : 0
             * download : 0
             * movie : 0
             * pay : 0
             * hd5 : 0
             */

            private RightsBean rights;

            /**
             * mid : 20484551
             * name : 凹凸君说
             * face : http://i2.hdslb.com/bfs/face/d82be1e7132697946d3d6b6cd4cc07e2ff687215.jpg
             */

            private OwnerBean owner;

            /**
             * view : 400444
             * danmaku : 2679
             * reply : 1361
             * favorite : 19754
             * coin : 22663
             * share : 3773
             * now_rank : 0
             * his_rank : 78
             */

            private StatBean stat;

            private String ip;

            private int time;

            private int coins;

            private List<String> tags;

            public int getAid()
            {

                return aid;
            }

            public void setAid(int aid)
            {

                this.aid = aid;
            }

            public int getTid()
            {

                return tid;
            }

            public void setTid(int tid)
            {

                this.tid = tid;
            }

            public String getTname()
            {

                return tname;
            }

            public void setTname(String tname)
            {

                this.tname = tname;
            }

            public int getCopyright()
            {

                return copyright;
            }

            public void setCopyright(int copyright)
            {

                this.copyright = copyright;
            }

            public String getPic()
            {

                return pic;
            }

            public void setPic(String pic)
            {

                this.pic = pic;
            }

            public String getTitle()
            {

                return title;
            }

            public void setTitle(String title)
            {

                this.title = title;
            }

            public int getPubdate()
            {

                return pubdate;
            }

            public void setPubdate(int pubdate)
            {

                this.pubdate = pubdate;
            }

            public int getCtime()
            {

                return ctime;
            }

            public void setCtime(int ctime)
            {

                this.ctime = ctime;
            }

            public String getDesc()
            {

                return desc;
            }

            public void setDesc(String desc)
            {

                this.desc = desc;
            }

            public int getState()
            {

                return state;
            }

            public void setState(int state)
            {

                this.state = state;
            }

            public int getAttribute()
            {

                return attribute;
            }

            public void setAttribute(int attribute)
            {

                this.attribute = attribute;
            }

            public int getDuration()
            {

                return duration;
            }

            public void setDuration(int duration)
            {

                this.duration = duration;
            }

            public RightsBean getRights()
            {

                return rights;
            }

            public void setRights(RightsBean rights)
            {

                this.rights = rights;
            }

            public OwnerBean getOwner()
            {

                return owner;
            }

            public void setOwner(OwnerBean owner)
            {

                this.owner = owner;
            }

            public StatBean getStat()
            {

                return stat;
            }

            public void setStat(StatBean stat)
            {

                this.stat = stat;
            }

            public String getIp()
            {

                return ip;
            }

            public void setIp(String ip)
            {

                this.ip = ip;
            }

            public int getTime()
            {

                return time;
            }

            public void setTime(int time)
            {

                this.time = time;
            }

            public int getCoins()
            {

                return coins;
            }

            public void setCoins(int coins)
            {

                this.coins = coins;
            }

            public List<String> getTags()
            {

                return tags;
            }

            public void setTags(List<String> tags)
            {

                this.tags = tags;
            }

            public static class RightsBean implements Parcelable
            {

                private int bp;

                private int elec;

                private int download;

                private int movie;

                private int pay;

                private int hd5;

                public int getBp()
                {

                    return bp;
                }

                public void setBp(int bp)
                {

                    this.bp = bp;
                }

                public int getElec()
                {

                    return elec;
                }

                public void setElec(int elec)
                {

                    this.elec = elec;
                }

                public int getDownload()
                {

                    return download;
                }

                public void setDownload(int download)
                {

                    this.download = download;
                }

                public int getMovie()
                {

                    return movie;
                }

                public void setMovie(int movie)
                {

                    this.movie = movie;
                }

                public int getPay()
                {

                    return pay;
                }

                public void setPay(int pay)
                {

                    this.pay = pay;
                }

                public int getHd5()
                {

                    return hd5;
                }

                public void setHd5(int hd5)
                {

                    this.hd5 = hd5;
                }

                @Override
                public int describeContents()
                {

                    return 0;
                }

                @Override
                public void writeToParcel(Parcel dest, int flags)
                {

                    dest.writeInt(this.bp);
                    dest.writeInt(this.elec);
                    dest.writeInt(this.download);
                    dest.writeInt(this.movie);
                    dest.writeInt(this.pay);
                    dest.writeInt(this.hd5);
                }

                public RightsBean()
                {

                }

                protected RightsBean(Parcel in)
                {

                    this.bp = in.readInt();
                    this.elec = in.readInt();
                    this.download = in.readInt();
                    this.movie = in.readInt();
                    this.pay = in.readInt();
                    this.hd5 = in.readInt();
                }

                public static final Creator<RightsBean> CREATOR = new Creator<RightsBean>()
                {

                    @Override
                    public RightsBean createFromParcel(Parcel source)
                    {

                        return new RightsBean(source);
                    }

                    @Override
                    public RightsBean[] newArray(int size)
                    {

                        return new RightsBean[size];
                    }
                };
            }

            public static class OwnerBean implements Parcelable
            {

                private int mid;

                private String name;

                private String face;

                public int getMid()
                {

                    return mid;
                }

                public void setMid(int mid)
                {

                    this.mid = mid;
                }

                public String getName()
                {

                    return name;
                }

                public void setName(String name)
                {

                    this.name = name;
                }

                public String getFace()
                {

                    return face;
                }

                public void setFace(String face)
                {

                    this.face = face;
                }

                @Override
                public int describeContents()
                {

                    return 0;
                }

                @Override
                public void writeToParcel(Parcel dest, int flags)
                {

                    dest.writeInt(this.mid);
                    dest.writeString(this.name);
                    dest.writeString(this.face);
                }

                public OwnerBean()
                {

                }

                protected OwnerBean(Parcel in)
                {

                    this.mid = in.readInt();
                    this.name = in.readString();
                    this.face = in.readString();
                }

                public static final Creator<OwnerBean> CREATOR = new Creator<OwnerBean>()
                {

                    @Override
                    public OwnerBean createFromParcel(Parcel source)
                    {

                        return new OwnerBean(source);
                    }

                    @Override
                    public OwnerBean[] newArray(int size)
                    {

                        return new OwnerBean[size];
                    }
                };
            }

            public static class StatBean implements Parcelable
            {

                private int view;

                private int danmaku;

                private int reply;

                private int favorite;

                private int coin;

                private int share;

                private int now_rank;

                private int his_rank;

                public int getView()
                {

                    return view;
                }

                public void setView(int view)
                {

                    this.view = view;
                }

                public int getDanmaku()
                {

                    return danmaku;
                }

                public void setDanmaku(int danmaku)
                {

                    this.danmaku = danmaku;
                }

                public int getReply()
                {

                    return reply;
                }

                public void setReply(int reply)
                {

                    this.reply = reply;
                }

                public int getFavorite()
                {

                    return favorite;
                }

                public void setFavorite(int favorite)
                {

                    this.favorite = favorite;
                }

                public int getCoin()
                {

                    return coin;
                }

                public void setCoin(int coin)
                {

                    this.coin = coin;
                }

                public int getShare()
                {

                    return share;
                }

                public void setShare(int share)
                {

                    this.share = share;
                }

                public int getNow_rank()
                {

                    return now_rank;
                }

                public void setNow_rank(int now_rank)
                {

                    this.now_rank = now_rank;
                }

                public int getHis_rank()
                {

                    return his_rank;
                }

                public void setHis_rank(int his_rank)
                {

                    this.his_rank = his_rank;
                }

                @Override
                public int describeContents()
                {

                    return 0;
                }

                @Override
                public void writeToParcel(Parcel dest, int flags)
                {

                    dest.writeInt(this.view);
                    dest.writeInt(this.danmaku);
                    dest.writeInt(this.reply);
                    dest.writeInt(this.favorite);
                    dest.writeInt(this.coin);
                    dest.writeInt(this.share);
                    dest.writeInt(this.now_rank);
                    dest.writeInt(this.his_rank);
                }

                public StatBean()
                {

                }

                protected StatBean(Parcel in)
                {

                    this.view = in.readInt();
                    this.danmaku = in.readInt();
                    this.reply = in.readInt();
                    this.favorite = in.readInt();
                    this.coin = in.readInt();
                    this.share = in.readInt();
                    this.now_rank = in.readInt();
                    this.his_rank = in.readInt();
                }

                public static final Creator<StatBean> CREATOR = new Creator<StatBean>()
                {

                    @Override
                    public StatBean createFromParcel(Parcel source)
                    {

                        return new StatBean(source);
                    }

                    @Override
                    public StatBean[] newArray(int size)
                    {

                        return new StatBean[size];
                    }
                };
            }

            @Override
            public int describeContents()
            {

                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags)
            {

                dest.writeInt(this.aid);
                dest.writeInt(this.tid);
                dest.writeString(this.tname);
                dest.writeInt(this.copyright);
                dest.writeString(this.pic);
                dest.writeString(this.title);
                dest.writeInt(this.pubdate);
                dest.writeInt(this.ctime);
                dest.writeString(this.desc);
                dest.writeInt(this.state);
                dest.writeInt(this.attribute);
                dest.writeInt(this.duration);
                dest.writeParcelable(this.rights, flags);
                dest.writeParcelable(this.owner, flags);
                dest.writeParcelable(this.stat, flags);
                dest.writeString(this.ip);
                dest.writeInt(this.time);
                dest.writeInt(this.coins);
                dest.writeStringList(this.tags);
            }

            public ListBean()
            {

            }

            protected ListBean(Parcel in)
            {

                this.aid = in.readInt();
                this.tid = in.readInt();
                this.tname = in.readString();
                this.copyright = in.readInt();
                this.pic = in.readString();
                this.title = in.readString();
                this.pubdate = in.readInt();
                this.ctime = in.readInt();
                this.desc = in.readString();
                this.state = in.readInt();
                this.attribute = in.readInt();
                this.duration = in.readInt();
                this.rights = in.readParcelable(RightsBean.class.getClassLoader());
                this.owner = in.readParcelable(OwnerBean.class.getClassLoader());
                this.stat = in.readParcelable(StatBean.class.getClassLoader());
                this.ip = in.readString();
                this.time = in.readInt();
                this.coins = in.readInt();
                this.tags = in.createStringArrayList();
            }

            public static final Creator<ListBean> CREATOR = new Creator<ListBean>()
            {

                @Override
                public ListBean createFromParcel(Parcel source)
                {

                    return new ListBean(source);
                }

                @Override
                public ListBean[] newArray(int size)
                {

                    return new ListBean[size];
                }
            };
        }

        @Override
        public int describeContents()
        {

            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags)
        {

            dest.writeInt(this.pages);
            dest.writeInt(this.count);
            dest.writeList(this.list);
        }

        public DataBean()
        {

        }

        protected DataBean(Parcel in)
        {

            this.pages = in.readInt();
            this.count = in.readInt();
            this.list = new ArrayList<ListBean>();
            in.readList(this.list, ListBean.class.getClassLoader());
        }

        public static final Creator<DataBean> CREATOR = new Creator<DataBean>()
        {

            @Override
            public DataBean createFromParcel(Parcel source)
            {

                return new DataBean(source);
            }

            @Override
            public DataBean[] newArray(int size)
            {

                return new DataBean[size];
            }
        };
    }

    @Override
    public int describeContents()
    {

        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags)
    {

        dest.writeByte(this.status ? (byte) 1 : (byte) 0);
        dest.writeParcelable(this.data, flags);
    }

    public UserCoinsInfo()
    {

    }

    protected UserCoinsInfo(Parcel in)
    {

        this.status = in.readByte() != 0;
        this.data = in.readParcelable(DataBean.class.getClassLoader());
    }

    public static final Parcelable.Creator<UserCoinsInfo> CREATOR = new Parcelable.Creator<UserCoinsInfo>()
    {

        @Override
        public UserCoinsInfo createFromParcel(Parcel source)
        {

            return new UserCoinsInfo(source);
        }

        @Override
        public UserCoinsInfo[] newArray(int size)
        {

            return new UserCoinsInfo[size];
        }
    };
}
