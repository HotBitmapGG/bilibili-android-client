package com.hotbitmapgg.bilibili.network.auxiliary;

import com.hotbitmapgg.bilibili.entity.user.UserDetailsInfo;

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
