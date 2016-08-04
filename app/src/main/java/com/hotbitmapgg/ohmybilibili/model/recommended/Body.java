package com.hotbitmapgg.ohmybilibili.model.recommended;

import org.json.*;


public class Body
{

    private String style;

    private String up;

    private String param;

    private String desc1;

    private int width;

    private String gotoProperty;

    private String title;

    private String upFace;

    private String danmaku;

    private String cover;

    private int height;

    private int online;

    private String play;


    public Body()
    {

    }

    public Body(JSONObject json)
    {

        this.style = json.optString("style");
        this.up = json.optString("up");
        this.param = json.optString("param");
        this.desc1 = json.optString("desc1");
        this.width = json.optInt("width");
        this.gotoProperty = json.optString("goto");
        this.title = json.optString("title");
        this.upFace = json.optString("up_face");
        this.danmaku = json.optString("danmaku");
        this.cover = json.optString("cover");
        this.height = json.optInt("height");
        this.online = json.optInt("online");
        this.play = json.optString("play");
    }

    public String getStyle()
    {

        return this.style;
    }

    public void setStyle(String style)
    {

        this.style = style;
    }

    public String getUp()
    {

        return this.up;
    }

    public void setUp(String up)
    {

        this.up = up;
    }

    public String getParam()
    {

        return this.param;
    }

    public void setParam(String param)
    {

        this.param = param;
    }

    public String getDesc1()
    {

        return this.desc1;
    }

    public void setDesc1(String desc1)
    {

        this.desc1 = desc1;
    }

    public int getWidth()
    {

        return this.width;
    }

    public void setWidth(int width)
    {

        this.width = width;
    }

    public String getGotoProperty()
    {

        return this.gotoProperty;
    }

    public void setGotoProperty(String gotoProperty)
    {

        this.gotoProperty = gotoProperty;
    }

    public String getTitle()
    {

        return this.title;
    }

    public void setTitle(String title)
    {

        this.title = title;
    }

    public String getUpFace()
    {

        return this.upFace;
    }

    public void setUpFace(String upFace)
    {

        this.upFace = upFace;
    }

    public String getDanmaku()
    {

        return this.danmaku;
    }

    public void setDanmaku(String danmaku)
    {

        this.danmaku = danmaku;
    }

    public String getCover()
    {

        return this.cover;
    }

    public void setCover(String cover)
    {

        this.cover = cover;
    }

    public int getHeight()
    {

        return this.height;
    }

    public void setHeight(int height)
    {

        this.height = height;
    }

    public int getOnline()
    {

        return this.online;
    }

    public void setOnline(int online)
    {

        this.online = online;
    }

    public String getPlay()
    {

        return this.play;
    }

    public void setPlay(String play)
    {

        this.play = play;
    }
}
