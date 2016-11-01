package com.hotbitmapgg.ohmybilibili.rx.cache;

import com.hotbitmapgg.ohmybilibili.entity.bangumi.BangumiAppIndexInfo;
import com.hotbitmapgg.ohmybilibili.entity.bangumi.BangumiRecommend;
import com.hotbitmapgg.ohmybilibili.entity.discover.HotSearchTag;
import com.hotbitmapgg.ohmybilibili.entity.live.LiveAppIndexInfo;
import com.hotbitmapgg.ohmybilibili.entity.recommend.RecommendBannerInfo;
import com.hotbitmapgg.ohmybilibili.entity.recommend.RecommendInfo;
import com.hotbitmapgg.ohmybilibili.entity.region.RegionTypesInfo;

import java.util.concurrent.TimeUnit;

import io.rx_cache.DynamicKey;
import io.rx_cache.EvictProvider;
import io.rx_cache.LifeCache;
import io.rx_cache.Reply;
import rx.Observable;

/**
 * Created by hcc on 2016/10/19 15:11
 * 100332338@qq.com
 * <p>
 * Rxcache缓存接口
 * <p>
 * LifeCache 设置缓存过期时间. 如果没有设置@LifeCache ,
 * 数据将被永久缓存理除非你使用了 EvictProvider, EvictDynamicKey or EvictDynamicKeyGroup.
 * EvictProvider 可以明确地清理清理所有缓存数据.
 * EvictDynamicKey 可以明确地清理指定的数据 DynamicKey.
 * EvictDynamicKeyGroup 允许明确地清理一组特定的数据. DynamicKeyGroup.
 * DynamicKey 驱逐与一个特定的键使用 EvictDynamicKey 相关的数据。比如分页，排序或筛选要求
 * DynamicKeyGroup。驱逐一组与 key 关联的数据，使用 EvictDynamicKeyGroup。比如分页，排序或筛选要求
 */

interface CacheProviders
{

    /**
     * 首页推荐数据缓存接口
     *
     * @param recommendInfo
     * @param dynamicKey
     * @param evictProvider
     * @return
     */
    @LifeCache(duration = 1, timeUnit = TimeUnit.DAYS)
    Observable<Reply<RecommendInfo>> getRecommendedInfo(Observable<RecommendInfo> recommendInfo, DynamicKey dynamicKey, EvictProvider evictProvider);

    /**
     * 首页推荐Banner数据缓存接口
     *
     * @param recommendBannerInfo
     * @param dynamicKey
     * @param evictProvider
     * @return
     */
    @LifeCache(duration = 1, timeUnit = TimeUnit.DAYS)
    Observable<Reply<RecommendBannerInfo>> getRecommendedBannerInfo(Observable<RecommendBannerInfo> recommendBannerInfo, DynamicKey dynamicKey, EvictProvider evictProvider);


    /**
     * 首页直播数据缓存接口
     *
     * @param liveInfo
     * @param dynamicKey
     * @param evictProvider
     * @return
     */
    @LifeCache(duration = 1, timeUnit = TimeUnit.DAYS)
    Observable<Reply<LiveAppIndexInfo>> getLiveAppIndex(Observable<LiveAppIndexInfo> liveInfo, DynamicKey dynamicKey, EvictProvider evictProvider);


    /**
     * 首页番剧内容缓存接口
     *
     * @param bangumiAppIndexInfo
     * @param dynamicKey
     * @param evictProvider
     * @return
     */
    @LifeCache(duration = 1, timeUnit = TimeUnit.DAYS)
    Observable<Reply<BangumiAppIndexInfo>> getBangumiAppIndex(Observable<BangumiAppIndexInfo> bangumiAppIndexInfo, DynamicKey dynamicKey, EvictProvider evictProvider);


    /**
     * 首页番剧推荐缓存接口
     *
     * @param bangumiRecommend
     * @param dynamicKey
     * @param evictProvider
     * @return
     */
    @LifeCache(duration = 1, timeUnit = TimeUnit.DAYS)
    Observable<Reply<BangumiRecommend>> getBangumiRecommended(Observable<BangumiRecommend> bangumiRecommend, DynamicKey dynamicKey, EvictProvider evictProvider);


    /**
     * 分区数据缓存接口
     *
     * @param partitionInfo
     * @return
     */
    @LifeCache(duration = 7, timeUnit = TimeUnit.DAYS)
    Observable<Reply<RegionTypesInfo>> getPartitionTypes(Observable<RegionTypesInfo> partitionInfo, DynamicKey dynamicKey, EvictProvider evictProvider);


    /**
     * 发现页面热搜词缓存接口
     *
     * @param hotSearchTag
     * @param dynamicKey
     * @param evictProvider
     * @return
     */
    @LifeCache(duration = 1, timeUnit = TimeUnit.DAYS)
    Observable<Reply<HotSearchTag>> getHotSearchTags(Observable<HotSearchTag> hotSearchTag, DynamicKey dynamicKey, EvictProvider evictProvider);
}
