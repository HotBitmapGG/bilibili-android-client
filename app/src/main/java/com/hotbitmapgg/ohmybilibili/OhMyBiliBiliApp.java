package com.hotbitmapgg.ohmybilibili;

import android.app.Application;
import android.os.Environment;

import com.hotbitmapgg.ohmybilibili.utils.FileUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/**
 * OhMyBiliBiliApp
 * 高仿哔哩哔哩动画
 *
 * @HotBitmapGG
 */
public class OhMyBiliBiliApp extends Application
{


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
    }


    public static OhMyBiliBiliApp getInstance()
    {

        return mInstance;
    }


    /**
     * 读取对象
     *
     * @param file
     * @return
     * @throws IOException
     */
    public Serializable readObject(String file, long... time)
    {

        if (!isExistDataCache(file, time))
            return null;

        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try
        {
            fis = openFileInput(file);
            ois = new ObjectInputStream(fis);
            return (Serializable) ois.readObject();
        } catch (FileNotFoundException e)
        {
        } catch (Exception e)
        {
            e.printStackTrace();
            // 反序列化失败 - 删除缓存文件
            if (e instanceof InvalidClassException)
            {
                File data = getFileStreamPath(file);
                data.delete();
            }
        } finally
        {
            try
            {
                ois.close();
            } catch (Exception e)
            {
            }
            try
            {
                fis.close();
            } catch (Exception e)
            {
            }
        }
        return null;
    }

    /**
     * 判断缓存是否存在
     *
     * @param cachefile
     * @return
     */
    public boolean isExistDataCache(String cachefile, long... time)
    {

        boolean exist = false;
        File data = getFileStreamPath(cachefile);
        if (data.exists())
            exist = true;

        boolean persistent = time == null || time.length == 0;
        return exist && (persistent || isEffictiveData(data.lastModified(), time[0]));
    }

    /**
     * 删除本地缓存数据
     *
     * @param cachefile
     * @return
     */
    public synchronized boolean delCache(String cachefile)
    {

        boolean isDel = false;
        File data = getFileStreamPath(cachefile);
        if (data.exists())
        {
            isDel = data.delete();
        }

        return isDel;
    }

    /**
     * @param modifyTime 文件创建时间
     * @param effictTime 文件有效期
     * @return
     */
    private boolean isEffictiveData(long modifyTime, long effictTime)
    {

        long diff = System.currentTimeMillis() - modifyTime;
        return diff > effictTime ? false : true;
    }
}
