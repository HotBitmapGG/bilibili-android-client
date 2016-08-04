package com.hotbitmapgg.ohmybilibili.network;

import android.util.Log;

import com.google.gson.Gson;
import com.hotbitmapgg.ohmybilibili.config.Secret;
import com.hotbitmapgg.ohmybilibili.model.base.BasicMessage;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * B站api请求网络管理类
 *
 * @HotBitmapGG
 */
public class ApiHelper
{

    private static Gson gson = new Gson();

    private static OkHttpClient client = new OkHttpClient();

    public static final String API_HOST = "http://api.bilibili.cn";

    public static final String BILIBILI_SITE = "http://www.bilibili.com";

    public static final String HDSLB_HOST = "http://i2.hdslb.com";

    //通过HTML5API抓包获取到的视频源地址 因为安卓5.0以上无法使用flash播放器来播放视频
    public static final String API_HTML5_VIDEO_HOST = "http://www.bilibili.tv";

    public static final String COMMON_UA_STR = "OhMyBiliBili Android Client/0.1 (100332338@qq.com)";

    public static final String COMPUTER_UA = "Mozilla/5.0 (Windows NT 6.1)" + " AppleWebKit/537.36 (KHTML, like Gecko) Chrome/44.0.2403.89 Safari/537.36";

    public static final String TAG = ApiHelper.class.getSimpleName();

    public static String getHTML5Url(String aid)
    {

        return new UrlBuilder(API_HTML5_VIDEO_HOST + "/" + ApiUrl.HTML5).addParams("aid", aid).toString();
    }

    /**
     * 获取推荐区视频
     *
     * @param tid
     * @param pagenum
     * @param pagesize
     * @param order
     * @return
     */
    public static String getRecommendUrl(String tid, String pagenum, String pagesize, String order)
    {

        UrlBuilder builder = new UrlBuilder(API_HOST + "/" + ApiUrl.RECOMMEND);

        if (tid != null)
            builder.addParams("tid", tid);
        if (pagenum != null)
            builder.addParams("page", pagenum);
        if (pagesize != null)
            builder.addParams("pagesize", pagesize);
        if (order != null)
            builder.addParams("order", order);

        return builder.toString();
    }

    /**
     * 获取视频详情
     *
     * @param av
     * @param page
     * @param needFav
     * @return
     */
    public static String getVideoInfoUrl(int av, int page, boolean needFav)
    {

        UrlBuilder builder = new UrlBuilder(API_HOST + "/" + ApiUrl.VIEW);

        builder.addParams("id", av);
        builder.addParams("page", page);
        builder.addParams("fav", needFav ? "1" : "0");
        addAPIParmasAndComplete(builder);

        return builder.toString();
    }

    /**
     * 根据userName获取用户信息
     *
     * @param user
     * @return
     */
    public static String getUserInfoUrl(String user)
    {

        UrlBuilder builder = new UrlBuilder(API_HOST + "/" + ApiUrl.USERINFO);
        return builder.addParams("user", user).toString();
    }

    /**
     * 根据userId获取用户信息
     *
     * @param uid
     * @return
     */
    public static String getUserInfoUrl(int uid)
    {

        UrlBuilder builder = new UrlBuilder(API_HOST + "/" + ApiUrl.USERINFO);
        return builder.addParams("uid", uid).toString();
    }

    /**
     * 获取该用户上传的所有视频
     *
     * @param mid
     * @param page
     * @return
     */
    public static String getUserVideoListUrl(int mid, int page, int pagesize)
    {

        UrlBuilder builder = new UrlBuilder(API_HOST + "/" + ApiUrl.LIST);

        builder.addParams("mid", mid);
        builder.addParams("page", page);
        builder.addParams("pagesize", pagesize);
        addAPIParmasAndComplete(builder);

        return builder.toString();
    }

    /**
     * 获取分区类型推荐视频
     *
     * @return
     */
    public static String getIndexUrl()
    {

        UrlBuilder builder = new UrlBuilder(API_HOST + "/" + ApiUrl.INDEX);

        builder.addParams("platform", "android");

        return builder.toString();
    }

    public static String getSlideshowUrl()
    {

        return BILIBILI_SITE + "/" + ApiUrl.SLIDESHOW;
    }

    /**
     * 获取每日更新专题
     *
     * @param btype
     * @param weekday
     * @return
     */
    public static String getBangumiUrl(int btype, int weekday)
    {

        UrlBuilder builder = new UrlBuilder(API_HOST + "/" + ApiUrl.BANGUMI);

        if (btype != -1)
            builder.addParams("btype", btype);
        if (weekday != -1)
            builder.addParams("weekday", weekday);
        addAPIParmasAndComplete(builder);

        return builder.toString();
    }

    /**
     * 获取专题详情
     *
     * @param spid
     * @param name
     * @return
     */
    public static String getSpUrl(int spid, String name)
    {

        UrlBuilder builder = new UrlBuilder(API_HOST + "/" + ApiUrl.SP);

        if (spid != -1)
            builder.addParams("spid", spid);
        if (name != null)
            builder.addParams("title", name);

        return builder.toString();
    }

    /**
     * 获取专题对应的视频列表
     *
     * @param spid
     * @param season_id
     * @param bangumi
     * @return
     */
    public static String getSpItemUrl(int spid, int season_id, int bangumi)
    {

        UrlBuilder builder = new UrlBuilder(API_HOST + "/" + ApiUrl.SP_VIEW);

        if (spid != -1)
            builder.addParams("spid", spid);
        if (season_id != -1)
            builder.addParams("season_id", season_id);
        if (bangumi != -1)
            builder.addParams("bangumi", bangumi);

        return builder.toString();
    }

    /**
     * 根据类型查询对应分区下的视频
     *
     * @param tid
     * @param pagenum
     * @param pagesize
     * @param order
     * @return
     */
    public static String getTypeListUrl(String tid, String pagenum, String pagesize, String order)
    {

        UrlBuilder builder = new UrlBuilder(API_HOST + "/" + ApiUrl.LIST);

        if (tid != null)
            builder.addParams("tid", tid);
        if (pagenum != null)
            builder.addParams("page", pagenum);
        if (pagesize != null)
            builder.addParams("pagesize", pagesize);
        if (order != null)
            builder.addParams("order", order);

        addAPIParmasAndComplete(builder);

        return builder.toString();
    }

    /**
     * 根据类型id查询相关的视频列表
     *
     * @param tid
     * @param pagenum
     * @param pagesize
     * @param order
     * @return
     */
    public static String getVideoListPartsByTid(String tid, String pagenum, String pagesize, String order)
    {

        UrlBuilder builder = new UrlBuilder(API_HOST + "/" + ApiUrl.LIST);

        if (tid != null)
            builder.addParams("tid", tid);
        if (pagenum != null)
            builder.addParams("page", pagenum);
        if (pagesize != null)
            builder.addParams("pagesize", pagesize);
        if (order != null)
            builder.addParams("order", order);

        addAPIParmasAndComplete(builder);
        return builder.toString();
    }

    /**
     * 获取用户推荐视频列表
     *
     * @param aid
     * @return
     */
    public static String getAuthorRecommendVideo(String aid)
    {

        UrlBuilder builder = new UrlBuilder(API_HOST + "/" + ApiUrl.AUTHOR_RECOMMEND);
        if (aid != null)
            builder.addParams("aid", aid);
        return builder.toString();
    }

    /**
     * 获取用户粉丝列表
     *
     * @param mid
     * @param page
     * @param pagesize
     * @return
     */
    public static String getUserFansList(String mid, int page, int pagesize)
    {

        UrlBuilder builder = new UrlBuilder(API_HOST + "/" + ApiUrl.FANS);
        if (mid != null)
            builder.addParams("mid", mid);
        builder.addParams("page", page);
        builder.addParams("pagesize", pagesize);
        return builder.toString();
    }

    /**
     * 获取视频评论列表
     *
     * @param aid
     * @param page
     * @param pagesize
     * @param ver
     * @return
     */
    public static String getVideoComment(int aid, int page, int pagesize, int ver)
    {

        UrlBuilder builder = new UrlBuilder(API_HOST + "/" + ApiUrl.VIDEO_COMMENT);
        builder.addParams("aid", aid);
        builder.addParams("page", page);
        builder.addParams("pagesize", pagesize);
        builder.addParams("ver", ver);

        return builder.toString();
    }


    private static void addAPIParmasAndComplete(UrlBuilder builder)
    {

        builder.addParams("appkey", Secret.APP_KEY);
        builder.addParams("ts", Long.toString(System.currentTimeMillis() / 1000));
        //对API请求签名去除 B站签名算法已修改 导致无法正常请求
        //String produceMD5 = SecretHelper.produceMD5(builder, Secret.APP_SECRET);
        //builder.addParams("sign", produceMD5);
    }

    private static class ApiUrl
    {

        static final String HTML5 = "m/html5";

        static final String RECOMMEND = "recommend";

        static final String VIEW = "view";

        static final String USERINFO = "userinfo";

        static final String LIST = "list";

        static final String INDEX = "index";

        static final String BANGUMI = "bangumi";

        static final String SP = "sp";

        static final String SP_VIEW = "spview";

        static final String SLIDESHOW = "index/slideshow.json";

        static final String AUTHOR_RECOMMEND = "author_recommend";

        static final String FANS = "friend/fans";

        static final String VIDEO_COMMENT = "feedback";
    }

    public static class RecommendOrder
    {

        public static final String DEFAULT = "default", NEW = "new", REVIEW = "review", HOT = "hot", DAMKU = "damku", COMMENT = "comment", PROMOTE = "promote";
    }

    public static <OBJ> BasicMessage<OBJ> getSimpleUrlResult(String url, Class<OBJ> obj)
    {

        Log.i(TAG, url);

        Request request = new Request.Builder().url(url).header("User-Agent", COMMON_UA_STR).build();
        Log.i(TAG, "Set up the request" + request.toString());

        BasicMessage<OBJ> msg = new BasicMessage<>();
        try
        {
            Response response = client.newCall(request).execute();
            Log.i(TAG, "Get response:" + response.code());
            String result = response.body().string();
            Log.i(TAG, result);
            msg.setObject(gson.fromJson(result, obj));
            msg.setCode(BasicMessage.CODE_SUCCEED);
        } catch (IOException e)
        {
            e.printStackTrace();
            msg.setCode(BasicMessage.CODE_ERROR);
        }

        return msg;
    }
}
