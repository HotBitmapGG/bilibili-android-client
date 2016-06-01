package com.hotbitmapgg.ohmybilibili.model;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class UserVideoList
{

    public int pages;

    public int code;

    public int results;

    public List<UserVideoItem> lists;

    private JsonObject list;

    public static UserVideoList createFromJson(String json)
    {

        UserVideoList result = new Gson().fromJson(json, UserVideoList.class);
        Iterator<Map.Entry<String,JsonElement>> iterator = result.list.entrySet().iterator();
        if (result.lists == null)
        {
            result.lists = new ArrayList<>();
        }
        while (iterator.hasNext())
        {
            Map.Entry<String,JsonElement> element = iterator.next();
            try
            {
                result.lists.add(new Gson().fromJson(element.getValue(), UserVideoItem.class));
            } catch (Exception e)
            {

            }
        }

        result.list = null;

        return result;
    }
}
