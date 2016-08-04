package com.hotbitmapgg.ohmybilibili.model.recommended;

import org.json.*;


public class Head
{

    private String param;

    private String style;

    private String title;

    private int count;

    private String gotoProperty;


    public Head()
    {

    }

    public Head(JSONObject json)
    {

        this.param = json.optString("param");
        this.style = json.optString("style");
        this.title = json.optString("title");
        this.count = json.optInt("count");
        this.gotoProperty = json.optString("goto");
    }

    public String getParam()
    {

        return this.param;
    }

    public void setParam(String param)
    {

        this.param = param;
    }

    public String getStyle()
    {

        return this.style;
    }

    public void setStyle(String style)
    {

        this.style = style;
    }

    public String getTitle()
    {

        return this.title;
    }

    public void setTitle(String title)
    {

        this.title = title;
    }

    public int getCount()
    {

        return this.count;
    }

    public void setCount(int count)
    {

        this.count = count;
    }

    public String getGotoProperty()
    {

        return this.gotoProperty;
    }

    public void setGotoProperty(String gotoProperty)
    {

        this.gotoProperty = gotoProperty;
    }
}
