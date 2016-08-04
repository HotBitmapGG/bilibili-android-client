package com.hotbitmapgg.ohmybilibili.model.recommended;

import org.json.*;

import java.util.ArrayList;

public class Result
{

    private String type;

    private Head head;

    private ArrayList<Body> body;


    public Result()
    {

    }

    public Result(JSONObject json)
    {

        this.type = json.optString("type");
        this.head = new Head(json.optJSONObject("head"));

        this.body = new ArrayList<Body>();
        JSONArray arrayBody = json.optJSONArray("body");
        if (null != arrayBody)
        {
            int bodyLength = arrayBody.length();
            for (int i = 0; i < bodyLength; i++)
            {
                JSONObject item = arrayBody.optJSONObject(i);
                if (null != item)
                {
                    this.body.add(new Body(item));
                }
            }
        } else
        {
            JSONObject item = json.optJSONObject("body");
            if (null != item)
            {
                this.body.add(new Body(item));
            }
        }
    }

    public String getType()
    {

        return this.type;
    }

    public void setType(String type)
    {

        this.type = type;
    }

    public Head getHead()
    {

        return this.head;
    }

    public void setHead(Head head)
    {

        this.head = head;
    }

    public ArrayList<Body> getBody()
    {

        return this.body;
    }

    public void setBody(ArrayList<Body> body)
    {

        this.body = body;
    }
}
