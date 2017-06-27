package com.hotbitmapgg.bilibili.utils;

import android.content.Context;
import android.content.Intent;

/**
 * Created by hcc on 16/6/25 18:05
 * 100332338@qq.com
 * <p>
 * 分享工具类
 */
public class ShareUtil {

    /**
     * 分享链接
     */
    public static void shareLink(String url, String title, Context context) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, "分享");
        intent.putExtra(Intent.EXTRA_TEXT, "非官方开源哔哩哔哩动画安卓客户端,GitHub地址:" + url);
        context.startActivity(Intent.createChooser(intent, title));
    }
}
