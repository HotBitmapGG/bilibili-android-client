package com.hotbitmapgg.bilibili.media.danmuku;

import android.text.TextUtils;

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
import rx.Observable;
import rx.schedulers.Schedulers;

/**
 * Created by hcc on 16/8/31 19:50
 * 100332338@qq.com
 * <p/>
 * 视频弹幕下载工具类
 */
public class BiliDanmukuDownloadUtil {
    public static Observable<BaseDanmakuParser> downloadXML(final String uri) {
        return Observable.create((Observable.OnSubscribe<BaseDanmakuParser>) subscriber -> {
            if (TextUtils.isEmpty(uri)) {
                subscriber.onNext(new BaseDanmakuParser() {
                    @Override
                    protected IDanmakus parse() {
                        return new Danmakus();
                    }
                });
            }
            ILoader loader = null;
            try {
                HttpConnection.Response rsp = (HttpConnection.Response)
                        Jsoup.connect(uri).timeout(20000).execute();
                InputStream stream = new ByteArrayInputStream(BiliDanmukuCompressionTools.
                        decompressXML(rsp.bodyAsBytes()));
                loader = DanmakuLoaderFactory.
                        create(DanmakuLoaderFactory.TAG_BILI);
                loader.load(stream);
            } catch (IOException | DataFormatException | IllegalDataException e) {
                e.printStackTrace();
            }
            BaseDanmakuParser parser = new BiliDanmukuParser();
            assert loader != null;
            IDataSource<?> dataSource = loader.getDataSource();
            parser.load(dataSource);
            subscriber.onNext(parser);
        }).subscribeOn(Schedulers.io());
    }
}
