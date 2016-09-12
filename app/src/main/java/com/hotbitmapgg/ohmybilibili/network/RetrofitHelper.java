package com.hotbitmapgg.ohmybilibili.network;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.hotbitmapgg.ohmybilibili.OhMyBiliBiliApp;
import com.hotbitmapgg.ohmybilibili.network.api.AllRankService;
import com.hotbitmapgg.ohmybilibili.network.api.AuthorRecommendedService;
import com.hotbitmapgg.ohmybilibili.network.api.BangumiIndexService;
import com.hotbitmapgg.ohmybilibili.network.api.BangumiRecommendService;
import com.hotbitmapgg.ohmybilibili.network.api.BiliBiliLiveService;
import com.hotbitmapgg.ohmybilibili.network.api.FansService;
import com.hotbitmapgg.ohmybilibili.network.api.HDVideoService;
import com.hotbitmapgg.ohmybilibili.network.api.Html5VideoUrlService;
import com.hotbitmapgg.ohmybilibili.network.api.IndexService;
import com.hotbitmapgg.ohmybilibili.network.api.LiveUrlService;
import com.hotbitmapgg.ohmybilibili.network.api.PartitionMoreService;
import com.hotbitmapgg.ohmybilibili.network.api.RecommendedService;
import com.hotbitmapgg.ohmybilibili.network.api.SpecialTopicInfoService;
import com.hotbitmapgg.ohmybilibili.network.api.SpecialTopicItemService;
import com.hotbitmapgg.ohmybilibili.network.api.TotalStationSearchService;
import com.hotbitmapgg.ohmybilibili.network.api.TwoDimensionalService;
import com.hotbitmapgg.ohmybilibili.network.api.UserInfoService;
import com.hotbitmapgg.ohmybilibili.network.api.UserUpVideoService;
import com.hotbitmapgg.ohmybilibili.network.api.VideoCommentService;
import com.hotbitmapgg.ohmybilibili.network.api.VideoDetailsService;
import com.hotbitmapgg.ohmybilibili.network.api.WeekDayBangumiService;

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

    public static final String HDSLB_HOST = "http://i2.hdslb.com";

    public static final String COMMON_UA_STR = "OhMyBiliBili Android Client/2.1 (100332338@qq.com)";

    static
    {
        initOkHttpClient();
    }

    /**
     * 获取哔哩哔哩直播Api
     *
     * @return
     */

    public static BiliBiliLiveService getBiliBiliLiveApi()
    {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(LIVE_BASE_URL)
                .client(mOkHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        return retrofit.create(BiliBiliLiveService.class);
    }


    /**
     * 获取番剧索引Api
     *
     * @return
     */

    public static BangumiIndexService getBangumiIndexApi()
    {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MAIN_BASE_URL)
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
     * 获取首页番剧推荐列表
     *
     * @return
     */

    public static BangumiRecommendService getBnagumiRecommendApi()
    {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .client(mOkHttpClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(BangumiRecommendService.class);
    }

    /**
     * 获取二次元新番
     *
     * @return
     */
    public static TwoDimensionalService getTwoDimensionalApi()
    {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .client(mOkHttpClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(TwoDimensionalService.class);
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
     * 获取分区数据列表详情
     *
     * @return
     */
    public static PartitionMoreService getPartitionMoreApi()
    {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(HOST_API_BASE_URL)
                .client(mOkHttpClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        return retrofit.create(PartitionMoreService.class);
    }

    /**
     * 获取用户上传的视频
     *
     * @return
     */
    public static UserUpVideoService getUserUpVideoListApi()
    {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .client(mOkHttpClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(UserUpVideoService.class);
    }


    /**
     * 获取HTML5视频播放地址
     *
     * @return
     */
    public static Html5VideoUrlService getHtml5VideoPlayerUrlApi()
    {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MAIN_BASE_URL)
                .client(mOkHttpClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(Html5VideoUrlService.class);
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
     * 获取番剧放送表数据
     *
     * @return
     */
    public static WeekDayBangumiService getWeekDayBangumiApi()
    {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(HOST_API_BASE_URL)
                .client(mOkHttpClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(WeekDayBangumiService.class);
    }


    /**
     * 获取用户粉丝列表
     *
     * @return
     */
    public static FansService getUserFansApi()
    {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(HOST_API_BASE_URL)
                .client(mOkHttpClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(FansService.class);
    }

    /**
     * 获取用户详情数据
     *
     * @return
     */
    public static UserInfoService getUserInfoApi()
    {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(HOST_API_BASE_URL)
                .client(mOkHttpClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(UserInfoService.class);
    }


    /**
     * 获取9个热门视频排行
     *
     * @return
     */
    public static IndexService getIndexApi()
    {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(HOST_API_BASE_URL)
                .client(mOkHttpClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(IndexService.class);
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
                .baseUrl(API_BASE_URL)
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
     * 获取全区排行榜视频
     *
     * @return
     */
    public static AllRankService getAllRankApi()
    {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .client(mOkHttpClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        return retrofit.create(AllRankService.class);
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
                    Cache cache = new Cache(new File(OhMyBiliBiliApp.getInstance()
                            .getCacheDir(), "HttpCache"), 1024 * 1024 * 100);

                    mOkHttpClient = new OkHttpClient.Builder()
                            .cache(cache)
                            .addInterceptor(interceptor)
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
     * 添加UA拦截器
     * B站请求API文档需要加上UA
     */
    static class UserAgentInterceptor implements Interceptor
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
}
