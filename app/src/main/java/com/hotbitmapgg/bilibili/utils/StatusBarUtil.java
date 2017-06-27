package com.hotbitmapgg.bilibili.utils;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by hcc on 16/9/18 13:41
 * 100332338@qq.com
 * <p>
 * 沉浸式状态栏工具类
 */
public class StatusBarUtil {
    private final boolean lightStatusBar;
    private final boolean transparentStatusBar;
    private final boolean transparentNavigationbar;
    private final Window window;
    private final View actionBarView;
    private final int current = Build.VERSION.SDK_INT;

    private StatusBarUtil(Window window, boolean lightStatusBar, boolean transparentStatusBar, boolean transparentNavigationbar, View actionBarView) {
        this.lightStatusBar = lightStatusBar;
        this.transparentStatusBar = transparentStatusBar;
        this.window = window;
        this.transparentNavigationbar = transparentNavigationbar;
        this.actionBarView = actionBarView;
    }

    public static boolean isLessKitkat() {
        return Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT;
    }

    public static Builder from(Activity activity) {
        return new Builder().setWindow(activity);
    }

    public static Builder from(Dialog dialog) {
        return new Builder().setWindow(dialog);
    }

    public static Builder from(Window window) {
        return new Builder().setWindow(window);
    }

    /**
     * Default status dp = 24 or 25
     * mhdpi = dp * 1
     * hdpi = dp * 1.5
     * xhdpi = dp * 2
     * xxhdpi = dp * 3
     * eg : 1920x1080, xxhdpi, => status/all = 25/640(dp) = 75/1080(px)
     * <p/>
     * don't forget toolbar's dp = 48
     *
     * @return px
     */
    @IntRange(from = 0, to = 75)
    public static int getStatusBarOffsetPx(Context context) {
        if (isLessKitkat()) {
            return 0;
        }
        Context appContext = context.getApplicationContext();
        int result = 0;
        int resourceId =
                appContext.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = appContext.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }


    @IntRange(from = 0, to = 75)
    public static int getNavigationBarOffsetPx(Context context) {
        if (isLessKitkat()) {
            return 0;
        }
        Context appContext = context.getApplicationContext();
        int result = 0;
        int resourceId =
                appContext.getResources().getIdentifier("navigation_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = appContext.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    private void processActionBar(final View v) {
        if (v == null || !transparentStatusBar || isLessKitkat()) {
            return;
        }
        v.post(() -> {
            v.setPadding(v.getPaddingLeft(), v.getPaddingTop() + getStatusBarOffsetPx(v.getContext()),
                    v.getPaddingRight(), v.getPaddingBottom());
            v.getLayoutParams().height += getStatusBarOffsetPx(v.getContext());
        });
    }


    /**
     * 调用私有API处理颜色
     */
    private void processPrivateAPI() {
        try {
            processFlyMe(lightStatusBar);
        } catch (Exception e) {
            try {
                processMIUI(lightStatusBar);
            } catch (Exception e2) {
            }
        }
    }


    private void process() {
        //调用私有API处理颜色
        processPrivateAPI();
        processActionBar(actionBarView);
        //处理4.4~5.0沉浸
        if (current >= Build.VERSION_CODES.KITKAT && current < Build.VERSION_CODES.M) {
            processKitkat();
        } else if (current >= Build.VERSION_CODES.M) {
            processM();
        }
    }


    /**
     * 处理4.4沉浸
     */
    @TargetApi(Build.VERSION_CODES.KITKAT)
    private void processKitkat() {
        WindowManager.LayoutParams winParams = window.getAttributes();
        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if (transparentStatusBar) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        window.setAttributes(winParams);
    }


    /**
     * 改变小米的状态栏字体颜色为黑色, 要求MIUI6以上
     * Tested on: MIUIV7 5.0 Redmi-Note3
     */
    private void processMIUI(boolean lightStatusBar) throws Exception {
        Class<? extends Window> clazz = window.getClass();
        int darkModeFlag;
        Class<?> layoutParams = Class.forName("android.view.MiuiWindowManager$LayoutParams");
        Field field = layoutParams.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE");
        darkModeFlag = field.getInt(layoutParams);
        Method extraFlagField = clazz.getMethod("setExtraFlags", int.class, int.class);
        extraFlagField.invoke(window, lightStatusBar ? darkModeFlag : 0, darkModeFlag);
    }


    /**
     * 改变魅族的状态栏字体为黑色，要求FlyMe4以上
     */
    private void processFlyMe(boolean isLightStatusBar) throws Exception {
        WindowManager.LayoutParams lp = window.getAttributes();
        Class<?> instance = Class.forName("android.view.WindowManager$LayoutParams");
        int value = instance.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON").getInt(lp);
        Field field = instance.getDeclaredField("meizuFlags");
        field.setAccessible(true);
        int origin = field.getInt(lp);
        if (isLightStatusBar) {
            field.set(lp, origin | value);
        } else {
            field.set(lp, (~value) & origin);
        }
    }


    @TargetApi(Build.VERSION_CODES.M)
    private void processM() {
        if (current < Build.VERSION_CODES.M) {
            return;
        }
        int flag = window.getDecorView().getSystemUiVisibility();
        if (lightStatusBar) {
            /**
             * 改变字体颜色
             * see {@link <a href="https://developer.android.com/reference/android/R.attr.html#windowLightStatusBar"></a>}
             */
            flag |= (WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
        if (transparentStatusBar) {
            flag |= View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            window.setStatusBarColor(Color.TRANSPARENT);
        }
        if (transparentNavigationbar) {
            flag |= (View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
            window.setNavigationBarColor(Color.TRANSPARENT);
        }
        window.getDecorView().setSystemUiVisibility(flag);
    }


    public final static class Builder {
        private Window window;
        private boolean lightStatusBar = false;
        private boolean transparentStatusbar = false;
        private boolean transparentNavigationbar = false;
        private View actionBarView;

        public Builder setActionbarView(@NonNull View actionbarView) {
            this.actionBarView = actionbarView;
            return this;
        }

        private Builder setWindow(@NonNull Window Window) {
            this.window = Window;
            return this;
        }

        private Builder setWindow(@NonNull Activity activity) {
            this.window = activity.getWindow();
            return this;
        }

        private Builder setWindow(@NonNull Dialog dialog) {
            this.window = dialog.getWindow();
            return this;
        }

        public Builder setLightStatusBar(boolean lightStatusBar) {
            this.lightStatusBar = lightStatusBar;
            return this;
        }

        public Builder setTransparentStatusbar(boolean transparentStatusbar) {
            this.transparentStatusbar = transparentStatusbar;
            return this;
        }

        public Builder setTransparentNavigationbar(boolean transparentNavigationbar) {
            this.transparentNavigationbar = transparentNavigationbar;
            return this;
        }

        public void process() {
            new StatusBarUtil(window, lightStatusBar, transparentStatusbar, transparentNavigationbar, actionBarView).process();
        }
    }
}
