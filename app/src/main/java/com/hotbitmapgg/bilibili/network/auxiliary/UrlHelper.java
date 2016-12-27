package com.hotbitmapgg.bilibili.network.auxiliary;

import com.hotbitmapgg.bilibili.entity.user.UserDetailsInfo;

import android.util.Log;

/**
 * Created by hcc on 16/8/4 21:18
 * 100332338@qq.com
 * <p/>
 * 根据B站返回的数据 个人参数由于返回限制
 * 需要进行特殊处理，如视频封面
 * 用户头像等url 进行url改装
 * 才能进行展示.
 */
public class UrlHelper {

  private static final String HDSLB_HOST = "http://i2.hdslb.com";


  private static boolean isVideoUrl(String url) {

    return url.contains("bilibili.com/video/av");
  }


  public static int getAVfromVideoUrl(String url) {

    if (!isVideoUrl(url)) {
      return -1;
    }

    String av = url;
    av = av.substring(av.indexOf("bilibili.com/video/av") + "bilibili.com/video/av".length());
    Log.i("test", av);
    av = av.substring(0, av.indexOf("/"));
    Log.i("test", av);

    return Integer.parseInt(av);
  }


  public static String getFaceUrl(UserDetailsInfo info) {

    if (info.getCard().getFace().contains(".hdslb.com")) {
      return info.getCard().getFace();
    }
    String face = HDSLB_HOST + info.getCard().getFace();
    if (face.contains("{SIZE}")) {
      face = face.replace("{SIZE}", "");
    }
    return face;
  }


  public static String getFaceUrlByUrl(String url) {

    if (url.contains("/52_52")) {

      return url.replace("/52_52", "");
    }
    return url;
  }


  public static String getClearVideoPreviewUrl(String url) {

    if (!url.contains("/320_180")) {
      return url;
    }

    url = url.replace("/320_180", "");
    return url;
  }
}
