package com.hotbitmapgg.ohmybilibili.rx.cache;

import com.hotbitmapgg.ohmybilibili.entity.bangumi.BangumiRecommend;
import com.hotbitmapgg.ohmybilibili.entity.bangumi.HomeBangumiRecommend;
import com.hotbitmapgg.ohmybilibili.entity.bangumi.NewBangumiSerial;
import com.hotbitmapgg.ohmybilibili.entity.bangumi.SeasonNewBangumi;
import com.hotbitmapgg.ohmybilibili.entity.discover.HotSearchTag;
import com.hotbitmapgg.ohmybilibili.entity.live.LiveInfo;
import com.hotbitmapgg.ohmybilibili.entity.partition.PartitionInfo;
import com.hotbitmapgg.ohmybilibili.entity.recommended.RecommendBannerInfo;
import com.hotbitmapgg.ohmybilibili.entity.recommended.RecommendInfo;
import com.hotbitmapgg.ohmybilibili.network.RetrofitHelper;

import java.io.File;

import io.rx_cache.DynamicKey;
import io.rx_cache.EvictDynamicKey;
import io.rx_cache.Reply;
import io.rx_cache.internal.RxCache;
import io.victoralbertos.jolyglot.GsonSpeaker;
import rx.Observable;

/**
 * Created by hcc on 2016/10/19 15:21
 * 100332338@qq.com
 * <p>
 * RxCahce缓存实现
 * new EvictDynamicKey(false) false 使用缓存  true 加载数据不使用缓存
 */

public class Repository
{

    private final CacheProviders providers;

    public static Repository init(File cacheDir)
    {

        return new Repository(cacheDir);
    }

    private Repository(File cacheDir)
    {

        providers = new RxCache.Builder()
                .persistence(cacheDir, new GsonSpeaker())
                .using(CacheProviders.class);
    }


    public Observable<Reply<RecommendInfo>> getRecommendedInfo(final boolean update)
    {

        return providers.getRecommendedInfo(RetrofitHelper.getHomeRecommendedApi()
                .getRecommendedInfo(), new DynamicKey("首页推荐"), new EvictDynamicKey(update));
    }

    public Observable<Reply<RecommendBannerInfo>> getRecommendedBannerInfo(final boolean update)
    {

        return providers.getRecommendedBannerInfo(RetrofitHelper.getHomeRecommendedApi()
                .getRecommendedBannerInfo(), new DynamicKey("首页推荐Banner"), new EvictDynamicKey(update));
    }

    public Observable<Reply<LiveInfo>> getLiveInfo(final boolean update)
    {

        return providers.getLiveInfo(RetrofitHelper.getLiveApi()
                .getLiveInfo(), new DynamicKey("首页直播"), new EvictDynamicKey(update));
    }


    public Observable<Reply<HomeBangumiRecommend>> getHomeBangumiRecommended(final boolean update)
    {

        return providers.getHomeBangumiRecommended(RetrofitHelper.getHomeBnagumiRecommendApi()
                .getHomeBangumiRecommended(), new DynamicKey("首页番剧Banner"), new EvictDynamicKey(update));
    }

    public Observable<Reply<SeasonNewBangumi>> getSeasonNewBangumiList(final boolean update)
    {

        return providers.getSeasonNewBangumiList(RetrofitHelper.getSeasonNewBangumiApi()
                .getSeasonNewBangumiList(), new DynamicKey("首页番剧分季新番"), new EvictDynamicKey(update));
    }

    public Observable<Reply<NewBangumiSerial>> getNewBangumiSerialList(final boolean update)
    {

        return providers.getNewBangumiSerialList(RetrofitHelper.getNewBangumiSerial()
                .getNewBangumiSerialList(), new DynamicKey("首页番剧新番推荐"), new EvictDynamicKey(update));
    }

    public Observable<Reply<BangumiRecommend>> getBangumiRecommended(final boolean update)
    {

        return providers.getBangumiRecommended(RetrofitHelper.getBangumiRecommendedApi()
                .getBangumiRecommended(), new DynamicKey("首页番剧推荐"), new EvictDynamicKey(update));
    }

    public Observable<Reply<PartitionInfo>> getPartitionTypes(final boolean update)
    {

        return providers.getPartitionTypes(RetrofitHelper.getPartitionTypesApi()
                .getPartitionTypes(), new DynamicKey("分区数据"), new EvictDynamicKey(update));
    }

    public Observable<Reply<HotSearchTag>> getHotSearchTags(final boolean update)
    {

        return providers.getHotSearchTags(RetrofitHelper.getHotSearchTagsApi()
                .getHotSearchTags(), new DynamicKey("发现热搜词"), new EvictDynamicKey(update));
    }
}
