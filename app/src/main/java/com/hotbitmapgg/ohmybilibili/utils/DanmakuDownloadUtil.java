package com.hotbitmapgg.ohmybilibili.utils;

import org.jsoup.Jsoup;
import org.jsoup.helper.HttpConnection;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.DataFormatException;

import master.flame.danmaku.danmaku.loader.ILoader;
import master.flame.danmaku.danmaku.loader.IllegalDataException;
import master.flame.danmaku.danmaku.loader.android.DanmakuLoaderFactory;
import master.flame.danmaku.danmaku.model.IDanmakus;
import master.flame.danmaku.danmaku.model.android.Danmakus;
import master.flame.danmaku.danmaku.parser.BaseDanmakuParser;
import master.flame.danmaku.danmaku.parser.IDataSource;
import master.flame.danmaku.danmaku.parser.android.BiliDanmukuParser;
import rx.Observable;
import rx.Subscriber;
import rx.schedulers.Schedulers;

/**
 * Created by hcc on 16/8/31 19:50
 * 100332338@qq.com
 * <p/>
 * 视频弹幕下载工具类
 */
public class DanmakuDownloadUtil
{

    public Observable<BaseDanmakuParser> downloadXML(final String uri)
    {

        return Observable.create(new Observable.OnSubscribe<BaseDanmakuParser>()
        {

            @Override
            public void call(final Subscriber<? super BaseDanmakuParser> subscriber)
            {

                InputStream stream = null;
                if (uri == null)
                {
                    subscriber.onNext(new BaseDanmakuParser()
                    {

                        @Override
                        protected IDanmakus parse()
                        {

                            return new Danmakus();
                        }
                    });
                }
                try
                {
                    HttpConnection.Response rsp = (HttpConnection.Response)
                            Jsoup.connect(uri).timeout(20000).execute();
                    stream = new ByteArrayInputStream(CompressionTools.
                            decompressXML(rsp.bodyAsBytes()));
                } catch (IOException | DataFormatException e1)
                {
                    e1.printStackTrace();
                }

                ILoader loader = DanmakuLoaderFactory.
                        create(DanmakuLoaderFactory.TAG_BILI);

                try
                {
                    loader.load(stream);
                } catch (IllegalDataException e)
                {
                    e.printStackTrace();
                }
                BaseDanmakuParser parser = new BiliDanmukuParser();
                IDataSource<?> dataSource = loader.getDataSource();
                parser.load(dataSource);
                subscriber.onNext(parser);

            }
        }).subscribeOn(Schedulers.io());
    }
}
