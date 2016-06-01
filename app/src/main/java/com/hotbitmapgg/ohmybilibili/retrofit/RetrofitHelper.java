package com.hotbitmapgg.ohmybilibili.retrofit;

import android.util.Log;

import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;

import java.io.IOException;

import okhttp3.logging.HttpLoggingInterceptor;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

/**
 * Retrofit管理类
 * <p/>
 * retrofit是项目后来才使用的，之前一直使用okHttp和Rxjava来进行网络请求
 * 目前使用retrofit完成了直播界面的网络需求和番剧索引
 * 因为对之前改起来比较麻烦 所以就没有全部换掉
 *
 * @HotBitmapGG
 */

public class RetrofitHelper
{

    private volatile static Retrofit liveBilibiliRetrofit;

    private volatile static Retrofit bilibiliRetrofit;

    private static HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();

    private RetrofitHelper()
    {

        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
    }


    public static Retrofit getLiveBilibiliRetrofit()
    {

        if (liveBilibiliRetrofit == null)
        {
            synchronized (Retrofit.class)
            {
                if (liveBilibiliRetrofit == null)
                {
                    liveBilibiliRetrofit = new Retrofit.Builder()
                            .baseUrl("http://live.bilibili.com/")
                            .addConverterFactory(GsonConverterFactory.create())
                            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                            .build();
                }
            }
        }

        liveBilibiliRetrofit.client()
                .interceptors()
                .add(new LoggingInterceptor());

        return liveBilibiliRetrofit;
    }


    public static Retrofit getBiliBili()
    {

        if (bilibiliRetrofit == null)
        {
            synchronized (Retrofit.class)
            {
                if (bilibiliRetrofit == null)
                {
                    bilibiliRetrofit = new Retrofit.Builder()
                            .baseUrl("http://www.bilibili.com")
                            .addConverterFactory(GsonConverterFactory.create())
                            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                            .build();
                }
            }
        }

        bilibiliRetrofit.client()
                .interceptors()
                .add(new LoggingInterceptor());

        return bilibiliRetrofit;
    }


    static class LoggingInterceptor implements Interceptor
    {

        @Override
        public Response intercept(Interceptor.Chain chain) throws IOException
        {

            Request request = chain.request();

            long t1 = System.nanoTime();

            //可以添加公共参数 增加校验签名等
            request.uri().getQuery();
            Log.d("retrofit request", request.url().toString());

            Response response = chain.proceed(request);

            long t2 = System.nanoTime();
            String bodyString = response.body().string();
            Log.d("retrofit response",
                    "request time " + (t2 - t1) / 1e6d + "ms\n" +
                            "request url " + response.request().url().toString() + "\n"
                            + "response body " + bodyString
            );

            return response.newBuilder()
                    .body(ResponseBody.create(response.body().contentType(), bodyString))
                    .build();
        }
    }
}
