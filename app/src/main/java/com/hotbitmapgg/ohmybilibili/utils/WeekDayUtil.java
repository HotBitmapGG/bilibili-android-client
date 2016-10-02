package com.hotbitmapgg.ohmybilibili.utils;

/**
 * Created by hcc on 2016/10/2 16:40
 * 100332338@qq.com
 * <p>
 * 星期日期转换工具类
 */

public class WeekDayUtil
{

    public static String converWeekDay(int day)
    {

        String weekDay = "";

        switch (day)
        {
            case 0:
                weekDay = "日";
                break;

            case 1:
                weekDay = "一";
                break;

            case 2:
                weekDay = "二";
                break;

            case 3:
                weekDay = "三";
                break;

            case 4:
                weekDay = "四";
                break;

            case 5:
                weekDay = "五";
                break;

            case 6:
                weekDay = "六";
                break;
        }

        return weekDay;
    }
}
