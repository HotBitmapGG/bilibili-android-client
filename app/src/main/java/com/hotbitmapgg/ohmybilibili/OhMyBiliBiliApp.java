package com.hotbitmapgg.ohmybilibili;

import android.app.Application;

import com.facebook.stetho.Stetho;

/**
 * Created by hcc on 16/8/7 21:18
 * 100332338@qq.com
 * <p/>
 * 高仿哔哩哔哩动画App
 */
public class OhMyBiliBiliApp extends Application
{

    public static OhMyBiliBiliApp mInstance;


    @Override
    public void onCreate()
    {
        // TODO Auto-generated method stub
        super.onCreate();

        mInstance = this;
        init();
    }

    private void init()
    {
        //初始化Stetho调试工具
        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                        .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
                        .build());
    }


    public static OhMyBiliBiliApp getInstance()
    {

        return mInstance;
    }
}
