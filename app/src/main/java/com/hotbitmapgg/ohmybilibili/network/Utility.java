package com.hotbitmapgg.ohmybilibili.network;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

import java.lang.reflect.Method;

/**
 * 通用工具类
 *
 * @HotBitmapGG
 */
public class Utility
{

    public static boolean isChrome()
    {

        return Build.BRAND.equals("chromium") || Build.BRAND.equals("chrome");
    }

    public static int getStatusBarHeight(Context context)
    {

        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0)
        {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    public static String getFirstCharacter(String sentence)
    {

        for (int i = 0; i < sentence.length(); i++)
        {
            String s = sentence.substring(i, i + 1);
            if (s.equals("[") || s.equals("]"))
                continue;
            if (s.equals("{") || s.equals("}"))
                continue;
            if (s.equals("(") || s.equals(")"))
                continue;
            if (s.equals(",") || s.equals("."))
                continue;
            if (s.equals("<") || s.equals(">"))
                continue;
            if (s.equals("《") || s.equals("》"))
                continue;
            if (s.equals("【") || s.equals("】"))
                continue;
            if (s.equals("｛") || s.equals("｝"))
                continue;
            return s;
        }
        return null;
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public static String getSystemProperties(String key)
    {

        try
        {
            Class c = Class.forName("android.os.SystemProperties");
            Method m = c.getDeclaredMethod("get", String.class);
            m.setAccessible(true);
            return (String) m.invoke(null, key);
        } catch (Throwable e)
        {
            return "";
        }
    }

    public static int getScreenHeight(Context context)
    {

        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        return dm.heightPixels;
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @SuppressLint("NewApi")
    public static int getTrueScreenHeight(Context context)
    {

        int dpi = 0;
        Display display = ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        DisplayMetrics dm = new DisplayMetrics();
        if (Build.VERSION.SDK_INT >= 17)
        {
            display.getRealMetrics(dm);
            dpi = dm.heightPixels;
        } else
        {
            try
            {
                Class c = Class.forName("android.view.Display");
                Method method = c.getMethod("getRealMetrics", DisplayMetrics.class);
                method.invoke(display, dm);
                dpi = dm.heightPixels;
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }

        return dpi;
    }

    public static int getNavigationBarHeight(Context context)
    {

        return getTrueScreenHeight(context) - getScreenHeight(context);
    }
}
