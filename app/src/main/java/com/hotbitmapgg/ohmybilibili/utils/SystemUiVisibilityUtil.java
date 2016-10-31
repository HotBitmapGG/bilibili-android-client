package com.hotbitmapgg.ohmybilibili.utils;

import android.view.View;

/**
 * Created by hcc on 2016/10/31 12:33
 * 100332338@qq.com
 * <p>
 * StatusBar隐藏显示工具类
 */
public class SystemUiVisibilityUtil
{

    public static void addFlags(View view, int flags)
    {

        view.setSystemUiVisibility(view.getSystemUiVisibility() | flags);
    }

    public static void clearFlags(View view, int flags)
    {

        view.setSystemUiVisibility(view.getSystemUiVisibility() & ~flags);
    }

    public static boolean hasFlags(View view, int flags)
    {

        return (view.getSystemUiVisibility() & flags) == flags;
    }
}
