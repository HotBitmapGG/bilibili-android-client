package com.hotbitmapgg.ohmybilibili.network;

import android.util.Log;

import com.hotbitmapgg.ohmybilibili.model.UserInfo;

public class UrlHelper
{

    public static boolean isVideoUrl(String url)
    {

        return url.contains("bilibili.com/video/av");
    }

    public static int getAVfromVideoUrl(String url)
    {

        if (!isVideoUrl(url))
        {
            return -1;
        }

        String av = url;
        av = av.substring(av.indexOf("bilibili.com/video/av") + "bilibili.com/video/av".length());
        Log.i("test", av);
        av = av.substring(0, av.indexOf("/"));
        Log.i("test", av);

        return Integer.parseInt(av);
    }

    public static String getFaceUrl(UserInfo info)
    {

        if (info.face.contains(".hdslb.com"))
        {
            return info.face;
        }
        String face = ApiHelper.HDSLB_HOST + info.face;
        if (face.contains("{SIZE}"))
        {
            face = face.replace("{SIZE}", "");
        }
        return face;
    }

    public static String getFaceUrlByUrl(String url)
    {

        if (url.contains("/52_52"))
        {
            String mURL = url.replace("/52_52", "");

            return mURL;
        }
        return url;
    }

    public static String getClearVideoPreviewUrl(String url)
    {

        if (!url.contains("/320_180"))
        {
            return url;
        }

        url = url.replace("/320_180", "");
        return url;
    }
}
