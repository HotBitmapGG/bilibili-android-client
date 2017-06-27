package com.hotbitmapgg.bilibili.utils;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Build;

/**
 * Created by hcc on 2016/10/3 19:01
 * 100332338@qq.com
 * <p>
 * 复制剪贴工具类
 */
public class ClipboardUtil {
    private static ClipboardManager mClipboardManager;
    private static ClipboardManager mNewCliboardManager;

    private static boolean isNew() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB;
    }

    private static void instance(Context context) {
        if (isNew()) {
            if (mNewCliboardManager == null) {
                mNewCliboardManager = (ClipboardManager) context.getSystemService(
                        Context.CLIPBOARD_SERVICE);
            }
        } else {
            if (mClipboardManager == null) {
                mClipboardManager = (ClipboardManager) context.getSystemService(
                        Context.CLIPBOARD_SERVICE);
            }
        }
    }

    /**
     * 为剪切板设置内容
     */
    public static void setText(Context context, CharSequence text) {
        if (isNew()) {
            instance(context);
            ClipData clip = ClipData.newPlainText("simple text", text);
            mNewCliboardManager.setPrimaryClip(clip);
        } else {
            instance(context);
            mClipboardManager.setText(text);
        }
    }


    /**
     * 获取剪切板的内容
     */
    public static CharSequence getText(Context context) {
        StringBuilder sb = new StringBuilder();
        if (isNew()) {
            instance(context);
            if (!mNewCliboardManager.hasPrimaryClip()) {
                return sb.toString();
            } else {
                ClipData clipData = (mNewCliboardManager).getPrimaryClip();
                int count = clipData.getItemCount();
                for (int i = 0; i < count; ++i) {
                    ClipData.Item item = clipData.getItemAt(i);
                    CharSequence str = item.coerceToText(context);
                    sb.append(str);
                }
            }
        } else {
            instance(context);
            sb.append(mClipboardManager.getText());
        }
        return sb.toString();
    }
}
