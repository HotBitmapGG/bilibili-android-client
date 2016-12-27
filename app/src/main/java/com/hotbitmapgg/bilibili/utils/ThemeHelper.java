package com.hotbitmapgg.bilibili.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by hcc on 16/9/16 13:14
 * 100332338@qq.com
 * <p/>
 * 主题切换帮助类
 */
public class ThemeHelper {

  private static final String CURRENT_THEME = "theme_current";

  public static final int CRAD_SAKURA = 0x1;

  public static final int CARD_HOPE = 0x2;

  public static final int CARD_STORM = 0x3;

  public static final int CARD_WOOD = 0x4;

  public static final int CARD_LIGHT = 0x5;

  public static final int CARD_THUNDER = 0x6;

  public static final int CARD_SAND = 0x7;

  public static final int CARD_FIREY = 0x8;


  public static SharedPreferences getSharePreference(Context context) {

    return context.getSharedPreferences("multiple_theme", Context.MODE_PRIVATE);
  }


  public static void setTheme(Context context, int themeId) {

    getSharePreference(context).edit()
        .putInt(CURRENT_THEME, themeId)
        .apply();
  }


  public static int getTheme(Context context) {

    return getSharePreference(context).getInt(CURRENT_THEME, CRAD_SAKURA);
  }


  public static boolean isDefaultTheme(Context context) {

    return getTheme(context) == CRAD_SAKURA;
  }


  public static String getName(int currentTheme) {

    switch (currentTheme) {
      case CRAD_SAKURA:
        return "THE SAKURA";
      case CARD_STORM:
        return "THE STORM";
      case CARD_WOOD:
        return "THE WOOD";
      case CARD_LIGHT:
        return "THE LIGHT";
      case CARD_HOPE:
        return "THE HOPE";
      case CARD_THUNDER:
        return "THE THUNDER";
      case CARD_SAND:
        return "THE SAND";
      case CARD_FIREY:
        return "THE FIREY";
    }
    return "THE RETURN";
  }
}
