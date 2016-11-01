package com.hotbitmapgg.ohmybilibili.network;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.hotbitmapgg.ohmybilibili.BilibiliApp;
import com.hotbitmapgg.ohmybilibili.network.api.ActivityCenterService;
import com.hotbitmapgg.ohmybilibili.network.api.AllareasRankService;
import com.hotbitmapgg.ohmybilibili.network.api.AuthorRecommendedService;
import com.hotbitmapgg.ohmybilibili.network.api.BangumiAppIndexService;
import com.hotbitmapgg.ohmybilibili.network.api.BangumiDetailsRecommendService;
import com.hotbitmapgg.ohmybilibili.network.api.BangumiDetailsService;
import com.hotbitmapgg.ohmybilibili.network.api.BangumiIndexService;
import com.hotbitmapgg.ohmybilibili.network.api.BangumiRecommendService;
import com.hotbitmapgg.ohmybilibili.network.api.BangumiScheduleService;
import com.hotbitmapgg.ohmybilibili.network.api.HDVideoService;
import com.hotbitmapgg.ohmybilibili.network.api.HotSearchTagService;
import com.hotbitmapgg.ohmybilibili.network.api.LiveAppIndexService;
import com.hotbitmapgg.ohmybilibili.network.api.LiveUrlService;
import com.hotbitmapgg.ohmybilibili.network.api.NewBangumiSerialService;
import com.hotbitmapgg.ohmybilibili.network.api.OriginalRankService;
import com.hotbitmapgg.ohmybilibili.network.api.RecommendedService;
import com.hotbitmapgg.ohmybilibili.network.api.RegionDetailsService;
import com.hotbitmapgg.ohmybilibili.network.api.RegionRecommendService;
import com.hotbitmapgg.ohmybilibili.network.api.RegionTypeService;
import com.hotbitmapgg.ohmybilibili.network.api.SeasonNewBangumiService;
import com.hotbitmapgg.ohmybilibili.network.api.SpecialTopicInfoService;
import com.hotbitmapgg.ohmybilibili.network.api.SpecialTopicItemService;
import com.hotbitmapgg.ohmybilibili.network.api.SplashService;
import com.hotbitmapgg.ohmybilibili.network.api.TopicCenterService;
import com.hotbitmapgg.ohmybilibili.network.api.TotalStationSearchService;
import com.hotbitmapgg.ohmybilibili.network.api.UserChaseBangumiService;
import com.hotbitmapgg.ohmybilibili.network.api.UserCoinsVideoService;
import com.hotbitmapgg.ohmybilibili.network.api.UserContributeVideoService;
import com.hotbitmapgg.ohmybilibili.network.api.UserFavoritesService;
import com.hotbitmapgg.ohmybilibili.network.api.UserInfoDetailsService;
import com.hotbitmapgg.ohmybilibili.network.api.UserInterestQuanService;
import com.hotbitmapgg.ohmybilibili.network.api.UserLiveRoomStatusService;
import com.hotbitmapgg.ohmybilibili.network.api.UserPlayGameService;
import com.hotbitmapgg.ohmybilibili.network.api.VideoCommentService;
import com.hotbitmapgg.ohmybilibili.network.api.VideoDetailsService;
import com.hotbitmapgg.ohmybilibili.network.api.VipGameService;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by hcc on 16/8/4 21:18
 * 100332338@qq.com
 * <p/>
 * Retrofit帮助类
 */
public class RetrofitHelper
{

    private static OkHttpClient mOkHttpClient;

    private static final String API_BASE_URL = "http://bilibili-service.daoapp.io/";

    private static final String MAIN_BASE_URL = "http://www.bilibili.com/";

    private static final String APP_BASE_URL = "http://app.bilibili.com/";

    private static final String LIVE_BASE_URL = "http://live.bilibili.com/";

    private static final String HOST_API_BASE_URL = "http://api.bilibili.cn/";

    private static final String BANGUMI_BASE_URL = "http://bangumi.bilibili.com/";

    private static final String SEARCH_BASE_URL = "http://s.search.bilibili.com/";

    private static final String ACCOUNT_BASE_URL = "https://account.bilibili.com/";

    private static final String USER_DETAILS_BASE_URL = "http://space.bilibili.com/";

    private static final String VIP_BASE_URL = "http://vip.bilibili.com/";

    private static final String IM9_BASE_URL = "http://www.im9.com/";

    public static final String HDSLB_HOST = "http://i2.hdslb.com";

    private static final String COMMON_UA_STR = "OhMyBiliBili Android Client/2.1 (100332338@qq.com)";

    static
    {
        initOkHttpClient();
    }

    /**
     * 获取哔哩哔哩直播Api
     *
     * @return
     */

    public static LiveAppIndexService getLiveAppIndexApi()
    {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(LIVE_BASE_URL)
                .client(mOkHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        return retrofit.create(LiveAppIndexService.class);
    }


    /**
     * 获取番剧索引Api
     *
     * @return
     */

    public static BangumiIndexService getBangumiIndexApi()
    {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BANGUMI_BASE_URL)
                .client(mOkHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        return retrofit.create(BangumiIndexService.class);
    }

    /**
     * 获取主页推荐Api
     *
     * @return
     */

    public static RecommendedService getHomeRecommendedApi()
    {


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APP_BASE_URL)
                .client(mOkHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        return retrofit.create(RecommendedService.class);
    }

    /**
     * 获取新番连载
     *
     * @return
     */
    public static NewBangumiSerialService getNewBangumiSerial()
    {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .client(mOkHttpClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(NewBangumiSerialService.class);
    }


    /**
     * 获取视频详情
     *
     * @return
     */
    public static VideoDetailsService getVideoDetailsApi()
    {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .client(mOkHttpClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(VideoDetailsService.class);
    }


    /**
     * 获取直播数据Url
     *
     * @return
     */
    public static LiveUrlService getLiveUrlApi()
    {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(LIVE_BASE_URL)
                .client(mOkHttpClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        return retrofit.create(LiveUrlService.class);
    }


    /**
     * 获取Up主推荐的更多视频
     *
     * @return
     */
    public static AuthorRecommendedService getAuthorRecommendedApi()
    {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(HOST_API_BASE_URL)
                .client(mOkHttpClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(AuthorRecommendedService.class);
    }


    /**
     * 获取番剧时间表数据
     *
     * @return
     */
    public static BangumiScheduleService getBangumiScheduleApi()
    {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BANGUMI_BASE_URL)
                .client(mOkHttpClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(BangumiScheduleService.class);
    }


    /**
     * 获取用户详情数据
     *
     * @return
     */
    public static UserInfoDetailsService getUserInfoDetailsApi()
    {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ACCOUNT_BASE_URL)
                .client(mOkHttpClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(UserInfoDetailsService.class);
    }


    /**
     * 获取视频评论
     *
     * @return
     */
    public static VideoCommentService getVideoCommentApi()
    {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(HOST_API_BASE_URL)
                .client(mOkHttpClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(VideoCommentService.class);
    }

    /**
     * 获取专题详情数据
     *
     * @return
     */
    public static SpecialTopicInfoService getSpInfoApi()
    {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(HOST_API_BASE_URL)
                .client(mOkHttpClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(SpecialTopicInfoService.class);
    }


    /**
     * 获取专题下的视频列表数据
     *
     * @return
     */
    public static SpecialTopicItemService getSpItemApi()
    {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(HOST_API_BASE_URL)
                .client(mOkHttpClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(SpecialTopicItemService.class);
    }

    /**
     * 获取全站搜索结果
     *
     * @return
     */
    public static TotalStationSearchService getSearchApi()
    {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APP_BASE_URL)
                .client(mOkHttpClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(TotalStationSearchService.class);
    }


    /**
     * 获取B站高清视频地址数据
     *
     * @return
     */
    public static HDVideoService getHDVideoApi()
    {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .client(mOkHttpClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(HDVideoService.class);
    }


    /**
     * 获取原创排行榜数据
     *
     * @return
     */
    public static OriginalRankService getOriginalRankApi()
    {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MAIN_BASE_URL)
                .client(mOkHttpClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(OriginalRankService.class);
    }

    /**
     * 获取全区排行榜数据
     *
     * @return
     */
    public static AllareasRankService getAllareasRankApi()
    {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MAIN_BASE_URL)
                .client(mOkHttpClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(AllareasRankService.class);
    }


    /**
     * 获取分季新番数据
     *
     * @return
     */
    public static SeasonNewBangumiService getSeasonNewBangumiApi()
    {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BANGUMI_BASE_URL)
                .client(mOkHttpClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(SeasonNewBangumiService.class);
    }

    /**
     * 获取番剧推荐
     *
     * @return
     */
    public static BangumiRecommendService getBangumiRecommendedApi()
    {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BANGUMI_BASE_URL)
                .client(mOkHttpClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(BangumiRecommendService.class);
    }


    /**
     * 获取发现页面热搜词标签数据
     *
     * @return
     */
    public static HotSearchTagService getHotSearchTagsApi()
    {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(SEARCH_BASE_URL)
                .client(mOkHttpClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(HotSearchTagService.class);
    }

    /**
     * 获取话题中心数据
     *
     * @return
     */
    public static TopicCenterService getTopicCenterApi()
    {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(HOST_API_BASE_URL)
                .client(mOkHttpClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(TopicCenterService.class);
    }

    /**
     * 获取活动中心数据
     *
     * @return
     */
    public static ActivityCenterService getActivityCenterApi()
    {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(HOST_API_BASE_URL)
                .client(mOkHttpClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(ActivityCenterService.class);
    }

    /**
     * 获取全部分区数据类型
     *
     * @return
     */
    public static RegionTypeService getPartitionTypesApi()
    {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APP_BASE_URL)
                .client(mOkHttpClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(RegionTypeService.class);
    }

    /**
     * 获取用户投稿视频数据
     *
     * @return
     */
    public static UserContributeVideoService getUserContributeVideoApi()
    {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(USER_DETAILS_BASE_URL)
                .client(mOkHttpClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(UserContributeVideoService.class);
    }


    /**
     * 获取用户追番数据
     *
     * @return
     */
    public static UserChaseBangumiService getUserChaseBangumiApi()
    {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(USER_DETAILS_BASE_URL)
                .client(mOkHttpClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(UserChaseBangumiService.class);
    }

    /**
     * 获取用户兴趣圈数据
     *
     * @return
     */
    public static UserInterestQuanService getUserInterestQuanApi()
    {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(IM9_BASE_URL)
                .client(mOkHttpClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(UserInterestQuanService.class);
    }

    /**
     * 获取用户投币视频数据
     *
     * @return
     */
    public static UserCoinsVideoService getUserCoinsVideoApi()
    {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(USER_DETAILS_BASE_URL)
                .client(mOkHttpClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(UserCoinsVideoService.class);
    }

    /**
     * 获取用户所玩游戏数据
     *
     * @return
     */
    public static UserPlayGameService getUserPlayGameApi()
    {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(USER_DETAILS_BASE_URL)
                .client(mOkHttpClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(UserPlayGameService.class);
    }

    /**
     * 获取用户收藏夹
     *
     * @return
     */
    public static UserFavoritesService getUserFavoritesApi()
    {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(HOST_API_BASE_URL)
                .client(mOkHttpClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(UserFavoritesService.class);
    }

    /**
     * 获取用户直播状态
     *
     * @return
     */
    public static UserLiveRoomStatusService getUserLiveRoomStatusApi()
    {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(LIVE_BASE_URL)
                .client(mOkHttpClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(UserLiveRoomStatusService.class);
    }


    /**
     * 获取分区推荐页数据
     *
     * @return
     */
    public static RegionRecommendService getRegionRecommendApi()
    {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APP_BASE_URL)
                .client(mOkHttpClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(RegionRecommendService.class);
    }

    /**
     * 获取分区详情数据
     *
     * @return
     */
    public static RegionDetailsService getRegionDetailsApi()
    {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APP_BASE_URL)
                .client(mOkHttpClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(RegionDetailsService.class);
    }


    /**
     * 获取启动页图片
     *
     * @return
     */
    public static SplashService getSplashApi()
    {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APP_BASE_URL)
                .client(mOkHttpClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(SplashService.class);
    }


    /**
     * 获取番剧详情数据
     *
     * @return
     */
    public static BangumiDetailsService getBangumiDetailsApi()
    {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BANGUMI_BASE_URL)
                .client(mOkHttpClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(BangumiDetailsService.class);
    }

    /**
     * 获取番剧详情番剧推荐
     *
     * @return
     */
    public static BangumiDetailsRecommendService getBangumiDetailsRecommendApi()
    {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BANGUMI_BASE_URL)
                .client(mOkHttpClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(BangumiDetailsRecommendService.class);
    }


    /**
     * 游戏中心大会员礼包专区
     *
     * @return
     */
    public static VipGameService getVipGameApi()
    {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(VIP_BASE_URL)
                .client(mOkHttpClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(VipGameService.class);
    }


    /**
     * 获取首页番剧内容
     *
     * @return
     */
    public static BangumiAppIndexService getBangumiAppIndexApi()
    {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BANGUMI_BASE_URL)
                .client(mOkHttpClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(BangumiAppIndexService.class);
    }


    /**
     * 初始化OKHttpClient
     * 设置缓存
     * 设置超时时间
     * 设置打印日志
     * 设置UA拦截器
     */
    private static void initOkHttpClient()
    {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        if (mOkHttpClient == null)
        {
            synchronized (RetrofitHelper.class)
            {
                if (mOkHttpClient == null)
                {
                    //设置Http缓存
                    Cache cache = new Cache(new File(BilibiliApp.getInstance()
                            .getCacheDir(), "HttpCache"), 1024 * 1024 * 100);

                    mOkHttpClient = new OkHttpClient.Builder()
                            .cache(cache)
                            .addInterceptor(interceptor)
                            .addNetworkInterceptor(new CacheInterceptor())
                            .addNetworkInterceptor(new StethoInterceptor())
                            .retryOnConnectionFailure(true)
                            .connectTimeout(30, TimeUnit.SECONDS)
                            .writeTimeout(20, TimeUnit.SECONDS)
                            .readTimeout(20, TimeUnit.SECONDS)
                            .addInterceptor(new UserAgentInterceptor())
                            .build();
                }
            }
        }
    }


    /**
     * 添加UA拦截器，B站请求API需要加上UA才能正常使用
     */
    private static class UserAgentInterceptor implements Interceptor
    {

        @Override
        public Response intercept(Chain chain) throws IOException
        {

            Request originalRequest = chain.request();
            Request requestWithUserAgent = originalRequest.newBuilder()
                    .removeHeader("User-Agent")
                    .addHeader("User-Agent", COMMON_UA_STR)
                    .build();
            return chain.proceed(requestWithUserAgent);
        }
    }


    /**
     * 为okhttp添加缓存，缓存时间为1小时，
     * 这里是考虑到服务器不支持缓存时，从而让okhttp支持缓存
     */
    private static class CacheInterceptor implements Interceptor
    {

        @Override
        public Response intercept(Chain chain) throws IOException
        {

            Request request = chain.request();
            return chain.proceed(request).newBuilder()
                    .removeHeader("Pragma")
                    .removeHeader("Cache-Control")
                    .header("Cache-Control", "max-age=" + 3600)
                    .build();
        }
    }
}
