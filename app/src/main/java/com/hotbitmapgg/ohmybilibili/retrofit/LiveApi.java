package com.hotbitmapgg.ohmybilibili.retrofit;

import android.util.Log;

import com.hotbitmapgg.ohmybilibili.model.live.LiveIndex;
import com.hotbitmapgg.ohmybilibili.model.base.Result;

import rx.Observable;
import rx.functions.Func1;


/**
 * 直播数据Api
 *
 * @HotBitmapGG
 */
public class LiveApi
{

    public static Observable<LiveIndex> getLiveIndex(LiveService bilibiliService)
    {

        return bilibiliService.getIndexRx()
                .flatMap(new Func1<Result<LiveIndex>,Observable<LiveIndex>>()
                {

                    @Override
                    public Observable<LiveIndex> call(Result<LiveIndex> liveIndexResult)
                    {

                        if (liveIndexResult.code != 0)
                        {
                            Log.e("retrofit error", liveIndexResult.message);
                            throw new RuntimeException();
                        }
                        return Observable.just(liveIndexResult.data);
                    }
                });
    }
}


