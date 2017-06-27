package com.hotbitmapgg.bilibili.utils;

import android.annotation.SuppressLint;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by hcc on 2016/11/1 15:34
 * 100332338@qq.com
 * <p>
 * 日期时间转星期工具类
 */
public class WeekDayUtil {
    public static String getWeek(String date) {
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8, 10));
        //获得一个日历
        Calendar calendar = Calendar.getInstance();
        //设置当前时间,月份是从0月开始计算
        calendar.set(year, month - 1, day);
        //星期表示1-7，是从星期日开始
        int number = calendar.get(Calendar.DAY_OF_WEEK);
        return getWeekDay(number);
    }

    private static String getWeekDay(int dayForWeek) {
        if (dayForWeek == 1) {
            return "周日";
        } else if (dayForWeek == 2) {
            return "周一";
        } else if (dayForWeek == 3) {
            return "周二";
        } else if (dayForWeek == 4) {
            return "周三";
        } else if (dayForWeek == 5) {
            return "周四";
        } else if (dayForWeek == 6) {
            return "周五";
        } else if (dayForWeek == 7) {
            return "周六";
        } else {
            return "";
        }
    }


    public static String formatDate(String date) {
        String dateFormat = null;
        try {
            dateFormat = date.substring(5, 7) + "月" + date.substring(8, 10) + "日";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dateFormat;
    }


    @SuppressLint("SimpleDateFormat")
    public static String getTime(long date) {
        SimpleDateFormat format = new SimpleDateFormat("MM-dd HH:mm:ss");
        return format.format(date);
    }
}
