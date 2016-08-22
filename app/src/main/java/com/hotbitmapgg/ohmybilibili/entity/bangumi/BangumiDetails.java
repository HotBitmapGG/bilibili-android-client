package com.hotbitmapgg.ohmybilibili.entity.bangumi;

/**
 * Created by hcc on 16/8/22 21:03
 * 100332338@qq.com
 * <p/>
 * 番剧详情数据
 */
public class BangumiDetails
{

    /**
     * spid : 56749
     * title : 终结的炽天使 第二季
     * create_at : 2014-12-12 21:19
     * lastupdate_at : 2015-12-17 22:53
     * alias : 终わりのセラフ
     * cover : http://i0.hdslb.com/sp/1e/1e21c6a6e17f5419eb1e10fadc53e6eb.jpg
     * isbangumi : 1
     * isbangumi_end : 1
     * bangumi_date : 2015-10-01
     * description : 电视动画《终结的炽天使》改编自日本轻小说家镜贵也原作、漫画家山本大和作画的同名漫画。
     * 2014年8月28日，发表了《终结的炽天使》电视动画化的决定。
     * 2014年12月20日，在日本千叶县幕张展览馆开幕的“Jump Festa 2015”会场上，宣布电视动画《终结的炽天使》会被分割成两个季度播出。
     * 第1期的播送时间为2015年4月4日－6月20日。
     * 第2期则是同年的10月至12月。
     * view : 1359646
     * video_view : 28723627
     * favourite : 172048
     * attention : 342432
     */

    private int spid;

    private String title;

    private String create_at;

    private String lastupdate_at;

    private String alias;

    private String cover;

    private int isbangumi;

    private int isbangumi_end;

    private String bangumi_date;

    private String description;

    private int view;

    private int video_view;

    private int favourite;

    private int attention;

    public int getSpid()
    {

        return spid;
    }

    public void setSpid(int spid)
    {

        this.spid = spid;
    }

    public String getTitle()
    {

        return title;
    }

    public void setTitle(String title)
    {

        this.title = title;
    }

    public String getCreate_at()
    {

        return create_at;
    }

    public void setCreate_at(String create_at)
    {

        this.create_at = create_at;
    }

    public String getLastupdate_at()
    {

        return lastupdate_at;
    }

    public void setLastupdate_at(String lastupdate_at)
    {

        this.lastupdate_at = lastupdate_at;
    }

    public String getAlias()
    {

        return alias;
    }

    public void setAlias(String alias)
    {

        this.alias = alias;
    }

    public String getCover()
    {

        return cover;
    }

    public void setCover(String cover)
    {

        this.cover = cover;
    }

    public int getIsbangumi()
    {

        return isbangumi;
    }

    public void setIsbangumi(int isbangumi)
    {

        this.isbangumi = isbangumi;
    }

    public int getIsbangumi_end()
    {

        return isbangumi_end;
    }

    public void setIsbangumi_end(int isbangumi_end)
    {

        this.isbangumi_end = isbangumi_end;
    }

    public String getBangumi_date()
    {

        return bangumi_date;
    }

    public void setBangumi_date(String bangumi_date)
    {

        this.bangumi_date = bangumi_date;
    }

    public String getDescription()
    {

        return description;
    }

    public void setDescription(String description)
    {

        this.description = description;
    }

    public int getView()
    {

        return view;
    }

    public void setView(int view)
    {

        this.view = view;
    }

    public int getVideo_view()
    {

        return video_view;
    }

    public void setVideo_view(int video_view)
    {

        this.video_view = video_view;
    }

    public int getFavourite()
    {

        return favourite;
    }

    public void setFavourite(int favourite)
    {

        this.favourite = favourite;
    }

    public int getAttention()
    {

        return attention;
    }

    public void setAttention(int attention)
    {

        this.attention = attention;
    }
}
