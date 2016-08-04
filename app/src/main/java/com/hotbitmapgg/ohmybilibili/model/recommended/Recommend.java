package com.hotbitmapgg.ohmybilibili.model.recommended;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by hcc on 16/8/4 11:47
 * 100332338@qq.com
 * <p/>
 * 首页 推荐内容
 */
public class Recommend
{

    private ArrayList<Result> result;

    private int code;


    public Recommend()

    {

    }

    public Recommend(JSONObject json)
    {


        this.result = new ArrayList<Result>();
        JSONArray arrayResult = json.optJSONArray("result");
        if (null != arrayResult)
        {
            int resultLength = arrayResult.length();
            for (int i = 0; i < resultLength; i++)
            {
                JSONObject item = arrayResult.optJSONObject(i);
                if (null != item)
                {
                    this.result.add(new Result(item));
                }
            }
        } else
        {
            JSONObject item = json.optJSONObject("result");
            if (null != item)
            {
                this.result.add(new Result(item));
            }
        }

        this.code = json.optInt("code");
    }

    public ArrayList<Result> getResult()
    {

        return this.result;
    }

    public void setResult(ArrayList<Result> result)
    {

        this.result = result;
    }

    public int getCode()
    {

        return this.code;
    }

    public void setCode(int code)
    {

        this.code = code;
    }
}
