package com.hotbitmapgg.ohmybilibili;

import android.app.Application;
import android.os.Environment;

import com.facebook.stetho.Stetho;
import com.hotbitmapgg.ohmybilibili.utils.FileUtils;

/**
 * Created by hcc on 16/8/7 21:18
 * 100332338@qq.com
 * <p/>
 * 高仿哔哩哔哩动画App
 */
public class OhMyBiliBiliApp extends Application
{


    //全局应用上下文对象
    public static OhMyBiliBiliApp mInstance;

    //OPlayer SD卡缓存路径
    public static final String OPLAYER_CACHE_BASE = Environment.getExternalStorageDirectory() + "/oplayer";

    //视频截图缓冲路径
    public static final String OPLAYER_VIDEO_THUMB = OPLAYER_CACHE_BASE + "/thumb/";

    //首次扫描
    public static final String PREF_KEY_FIRST = "application_first";


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


        //创建缓存目录
        FileUtils.createIfNoExists(OPLAYER_CACHE_BASE);
        FileUtils.createIfNoExists(OPLAYER_VIDEO_THUMB);

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
