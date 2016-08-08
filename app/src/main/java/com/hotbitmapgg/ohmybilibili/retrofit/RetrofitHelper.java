package com.hotbitmapgg.ohmybilibili.retrofit;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.hotbitmapgg.ohmybilibili.OhMyBiliBiliApp;
import com.hotbitmapgg.ohmybilibili.retrofit.api.AuthorRecommendedService;
import com.hotbitmapgg.ohmybilibili.retrofit.api.BangumiIndexService;
import com.hotbitmapgg.ohmybilibili.retrofit.api.BangumiRecommendService;
import com.hotbitmapgg.ohmybilibili.retrofit.api.BiliBiliLiveService;
import com.hotbitmapgg.ohmybilibili.retrofit.api.FansService;
import com.hotbitmapgg.ohmybilibili.retrofit.api.Html5VideoUrlService;
import com.hotbitmapgg.ohmybilibili.retrofit.api.LiveUrlService;
import com.hotbitmapgg.ohmybilibili.retrofit.api.PartitionMoreService;
import com.hotbitmapgg.ohmybilibili.retrofit.api.RecommendedIndexService;
import com.hotbitmapgg.ohmybilibili.retrofit.api.RecommendedService;
import com.hotbitmapgg.ohmybilibili.retrofit.api.TwoDimensionalService;
import com.hotbitmapgg.ohmybilibili.retrofit.api.UserInfoService;
import com.hotbitmapgg.ohmybilibili.retrofit.api.UserUpVideoService;
import com.hotbitmapgg.ohmybilibili.retrofit.api.VideoDetailsService;
import com.hotbitmapgg.ohmybilibili.retrofit.api.WeekDayBangumiService;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
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
                .baseUrl(HOST_API_BASE_URL)
                .client(mOkHttpClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
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
    public static RecommendedIndexService getIndexApi()
    {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(HOST_API_BASE_URL)
                .client(mOkHttpClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(RecommendedIndexService.class);
    }


    /**
     * 初始化OKHttpClient
     * 设置缓存
     * 设置超时时间
     * 设置打印日志
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
                            .build();
                }
            }
        }
    }
}
