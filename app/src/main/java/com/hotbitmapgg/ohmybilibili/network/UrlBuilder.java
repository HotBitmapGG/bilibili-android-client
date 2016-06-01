package com.hotbitmapgg.ohmybilibili.network;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Url拼接辅助类
 *
 * @HotBitmapGG
 */
public class UrlBuilder
{

    String urlRoot;

    ArrayList<HashMap<String,String>> params;

    public UrlBuilder(String urlRoot)
    {

        this.urlRoot = urlRoot;
        this.params = new ArrayList<>();
    }

    public UrlBuilder addParams(String key, String value)
    {

        HashMap<String,String> map = new HashMap<>();
        map.put("key", key);
        map.put("value", value);
        this.params.add(map);
        return this;
    }

    public UrlBuilder addParams(String key, int value)
    {

        HashMap<String,String> map = new HashMap<>();
        map.put("key", key);
        map.put("value", Integer.toString(value));
        this.params.add(map);
        return this;
    }

    public UrlBuilder removeParams(String key)
    {

        for (HashMap<String,String> map : params)
        {
            if (map.get("key").equals(key))
            {
                params.remove(map);
                return this;
            }
        }
        return this;
    }

    public int paramsSize()
    {

        return params.size();
    }

    public HashMap<String,String> getParmas(int index)
    {

        return params.get(index);
    }

    public String toString()
    {

        StringBuffer sb = new StringBuffer(urlRoot);
        for (int i = 0; i < params.size(); i++)
        {
            try
            {
                sb.append(i == 0 ? "?" : "&").append(params.get(i).get("key")).append("=").append(URLEncoder.encode(params.get(i).get("value"), "UTF-8"));
            } catch (UnsupportedEncodingException e)
            {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

    public String toStringWithoutUrlRoot()
    {

        StringBuffer sb = new StringBuffer("");
        sortParams();
        for (int i = 0; i < params.size(); i++)
        {
            try
            {
                sb.append(i == 0 ? "" : "&").append(params.get(i).get("key")).append("=").append(URLEncoder.encode(params.get(i).get("value"), "UTF-8"));
            } catch (UnsupportedEncodingException e)
            {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

    private void sortParams()
    {

        for (int i = 0; i < paramsSize() - 1; i++)
        {
            for (int j = i + 1; j < paramsSize(); j++)
            {
                if (params.get(i).get("key").compareTo(params.get(j).get("key")) > 0)
                {
                    HashMap<String,String> tempMap = params.get(i);
                    params.set(i, params.get(j));
                    params.set(j, tempMap);
                }
            }
        }
    }
}