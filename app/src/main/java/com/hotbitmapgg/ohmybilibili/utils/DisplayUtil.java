package com.hotbitmapgg.ohmybilibili.utils;

import android.content.Context;
import android.util.DisplayMetrics;

/**
 * 屏幕相关工具类
 *
 * @HotBitmapGG
 */
public class DisplayUtil
{

    public static int px2dip(Context context, float pxValue)
    {

        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    public static int dip2px(Context context, float dipValue)
    {

        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }

    public static int px2sp(Context context, float pxValue)
    {

        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale + 0.5f);
    }

    public static int sp2px(Context context, float spValue)
    {

        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

    public static int getScreenWidth(Context context)
    {

        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        return dm.widthPixels;
    }

    public static int getScreenHeight(Context context)
    {

        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        return dm.heightPixels;
    }

    public static float getDisplayDensity(Context context)
    {

        if (context == null)
        {
            return -1;
        }
        return context.getResources().getDisplayMetrics().density;
    }
}
