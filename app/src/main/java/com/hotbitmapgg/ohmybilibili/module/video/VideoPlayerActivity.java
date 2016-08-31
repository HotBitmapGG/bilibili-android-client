package com.hotbitmapgg.ohmybilibili.module.video;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.view.WindowManager;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.base.RxAppCompatBaseActivity;
import com.hotbitmapgg.ohmybilibili.entity.video.HDVideoInfo;
import com.hotbitmapgg.ohmybilibili.entity.video.VideoSrc;
import com.hotbitmapgg.ohmybilibili.network.RetrofitHelper;
import com.hotbitmapgg.ohmybilibili.utils.DanMuDownloadUtil;
import com.hotbitmapgg.ohmybilibili.service.MediaController;
import com.hotbitmapgg.ohmybilibili.widget.VideoView;

import butterknife.Bind;
import master.flame.danmaku.controller.DrawHandler;
import master.flame.danmaku.controller.IDanmakuView;
import master.flame.danmaku.danmaku.model.BaseDanmaku;
import master.flame.danmaku.danmaku.model.DanmakuTimer;
import master.flame.danmaku.danmaku.model.android.DanmakuContext;
import master.flame.danmaku.danmaku.parser.BaseDanmakuParser;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import tv.danmaku.ijk.media.player.IMediaPlayer;

public class VideoPlayerActivity extends RxAppCompatBaseActivity
{


    @Bind(R.id.sv_danmaku)
    IDanmakuView mDanmakuView;

    @Bind(R.id.playerView)
    VideoView mPlayerView;

    @Bind(R.id.buffering_indicator)
    View mBufferingIndicator;

    private MediaController mMediaController;

    //页面切换时，播放到的位置
    private int LastPosition = 0;

    //VideoView OnInfo 当正在缓冲时等事件会被调用

    // todo 显示缓冲提示
    private IMediaPlayer.OnInfoListener onInfoListener = new IMediaPlayer.OnInfoListener()
    {

        @Override
        public boolean onInfo(IMediaPlayer mp, int what, int extra)
        {

            if (what == IMediaPlayer.MEDIA_INFO_BUFFERING_START)
            {
                if (mDanmakuView != null && mDanmakuView.isPrepared())
                {
                    mDanmakuView.pause();
                    if (mBufferingIndicator != null)
                        mBufferingIndicator.setVisibility(View.VISIBLE);
                }
            } else if (what == IMediaPlayer.MEDIA_INFO_BUFFERING_END)
            {
                if (mDanmakuView != null && mDanmakuView.isPaused())
                {
                    mDanmakuView.resume();
                }
                if (mBufferingIndicator != null)
                    mBufferingIndicator.setVisibility(View.GONE);
            }
            return true;
        }
    };

    //跳转
    private IMediaPlayer.OnSeekCompleteListener onSeekCompleteListener = new IMediaPlayer.OnSeekCompleteListener()
    {

        @Override
        public void onSeekComplete(IMediaPlayer mp)
        {

            if (mDanmakuView != null && mDanmakuView.isPrepared())
            {
                mDanmakuView.seekTo(mp.getCurrentPosition());
            }
        }
    };

    //播放完成
    private IMediaPlayer.OnCompletionListener onCompletionListener = new IMediaPlayer.OnCompletionListener()
    {

        @Override
        public void onCompletion(IMediaPlayer mp)
        {

            if (mDanmakuView != null && mDanmakuView.isPrepared())
            {
                mDanmakuView.seekTo((long) 0);
                mDanmakuView.pause();
            }
            mPlayerView.pause();
        }
    };

    //被控制条控制状态
    private VideoView.OnControllerEventsListener onControllerEventsListener = new VideoView.OnControllerEventsListener()
    {

        @Override
        public void onVideoPause()
        {

            if (mDanmakuView != null && mDanmakuView.isPrepared())
            {
                mDanmakuView.pause();
            }
        }

        @Override
        public void OnVideoResume()
        {

            if (mDanmakuView != null && mDanmakuView.isPaused())
            {
                mDanmakuView.resume();
            }
        }
    };

    private int aid;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().setBackgroundDrawable(null);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

    }

    protected void initData()
    {

        mMediaController = new MediaController(this);
        mDanmakuView.enableDanmakuDrawingCache(true);
        mPlayerView.setMediaController(mMediaController);
        mPlayerView.setMediaBufferingIndicator(mBufferingIndicator);
        mPlayerView.requestFocus();

        if (mBufferingIndicator != null)
            mBufferingIndicator.setVisibility(View.VISIBLE);

        mPlayerView.setOnInfoListener(onInfoListener);
        mPlayerView.setOnSeekCompleteListener(onSeekCompleteListener);
        mPlayerView.setOnCompletionListener(onCompletionListener);
        mPlayerView.setOnControllerEventsListener(onControllerEventsListener);


        Observable<VideoSrc> observable = RetrofitHelper
                .getHtml5VideoPlayerUrlApi()
                .getHtml5VideoPlayerUrl(aid, 1)
                .subscribeOn(Schedulers.io());

        //danmaku
        Observable<Object> danmakuObservable =
                observable
                        .map(new Func1<VideoSrc,String>()
                        {

                            @Override
                            public String call(VideoSrc videoSrc)
                            {

                                if (videoSrc.getCid() == null || videoSrc.getCid().contentEquals("undefined"))
                                {
                                    return "error";
                                }
                                return videoSrc.getCid();
                            }
                        })
                        .flatMap(new Func1<String,Observable<BaseDanmakuParser>>()
                        {

                            @Override
                            public Observable<BaseDanmakuParser> call(String string)
                            {

                                if (string.equals("error"))
                                {
                                    return Observable.error(new Exception("视频不存在或不能播放"));
                                }
                                return new DanMuDownloadUtil().downloadXML(string);
                            }
                        })
                        .observeOn(AndroidSchedulers.mainThread())
                        .flatMap(new Func1<BaseDanmakuParser,Observable<?>>()
                        {

                            @Override
                            public Observable<?> call(BaseDanmakuParser parser)
                            {

                                return preparDanmaku(parser);
                            }
                        });

        //video
        Observable<Object> videoObservable =
                observable
                        .map(new Func1<VideoSrc,String>()
                        {

                            @Override
                            public String call(VideoSrc videoSrc)
                            {

                                return videoSrc.getCid();
                            }
                        })
                        .map(new Func1<String,String>()
                        {

                            @Override
                            public String call(String s)
                            {

                                if (s == null || s.contentEquals("undefined"))
                                {
                                    return "error";
                                }
                                return s.substring(s.lastIndexOf('/') + 1, s.lastIndexOf("."));
                            }
                        })
                        .flatMap(new Func1<String,Observable<HDVideoInfo>>()
                        {

                            @Override
                            public Observable<HDVideoInfo> call(String cid)
                            {

                                if (cid.equals("error"))
                                {
                                    return Observable.error(new Exception("视频不存在或不能播放"));
                                }

                                return RetrofitHelper.getHDVideoApi()
                                        .getHDVideoUrl(cid, 4, "mp4");
                            }
                        })
                        .map(new Func1<HDVideoInfo,Uri>()
                        {

                            @Override
                            public Uri call(HDVideoInfo videoInfo)
                            {

                                return Uri.parse(videoInfo.getDurl().get(0).getUrl());
                            }
                        })
                        .observeOn(AndroidSchedulers.mainThread())
                        .flatMap(new Func1<Uri,Observable<?>>()
                        {

                            @Override
                            public Observable<?> call(Uri uri)
                            {

                                return preparVideo(uri);
                            }
                        });

        Observable
                .merge(videoObservable, danmakuObservable)
                //.last()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Object>()
                {

                    @Override
                    public void onCompleted()
                    {

                        mPlayerView.start();
                        mDanmakuView.start();
                    }

                    @Override
                    public void onError(Throwable e)
                    {

                        Snackbar.make(mPlayerView, e.getMessage(), Snackbar.LENGTH_LONG).show();
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(Object o)
                    {

                    }
                });
    }


    @Override
    protected void onResume()
    {

        super.onResume();
        if (mDanmakuView != null && mDanmakuView.isPrepared() && mDanmakuView.isPaused())
        {
            mDanmakuView.seekTo((long) LastPosition);
        }
        //todo 看看能不能保留缓冲的视频
        if (mPlayerView != null && !mPlayerView.isPlaying())
        {
            mPlayerView.seekTo(LastPosition);
        }
    }

    @Override
    protected void onPause()
    {

        super.onPause();
        if (mPlayerView != null)
        {
            LastPosition = mPlayerView.getCurrentPosition();
            mPlayerView.pause();
        }

        if (mDanmakuView != null && mDanmakuView.isPrepared())
        {
            mDanmakuView.pause();
        }
    }

    @Override
    public void onBackPressed()
    {

        super.onBackPressed();
        if (mDanmakuView != null)
        {
            // dont forget release!
            mDanmakuView.release();
            mDanmakuView = null;
        }
    }

    @Override
    protected void onDestroy()
    {

        super.onDestroy();
        if (mPlayerView != null && mPlayerView.isDrawingCacheEnabled())
        {
            mPlayerView.destroyDrawingCache();
        }
        if (mDanmakuView != null && mDanmakuView.isPaused())
        {
            mDanmakuView.release();
            mDanmakuView = null;
        }
    }

    @Override
    public int getLayoutId()
    {

        return R.layout.activity_player;
    }

    @Override
    public void initViews(Bundle savedInstanceState)
    {
        Intent intent = getIntent();
        if (intent != null)
            aid = intent.getIntExtra("AID", 0);

        initData();
    }

    @Override
    public void initToolBar()
    {

    }


    //视频加载
    public Observable preparVideo(final Uri src)
    {

        return Observable.create(new Observable.OnSubscribe<Object>()
        {

            @Override
            public void call(final Subscriber<? super Object> subscriber)
            {

                mPlayerView.setVideoURI(src);
                mPlayerView.setOnPreparedListener(new IMediaPlayer.OnPreparedListener()
                {

                    @Override
                    public void onPrepared(IMediaPlayer mp)
                    {

                        subscriber.onCompleted();
                        if (mBufferingIndicator != null)
                            mBufferingIndicator.setVisibility(View.GONE);
                    }
                });
            }
        });
    }

    //danmaku加载
    public Observable preparDanmaku(final BaseDanmakuParser parser)
    {

        return Observable.create(new Observable.OnSubscribe<Object>()
        {

            @Override
            public void call(final Subscriber<? super Object> subscriber)
            {

                mDanmakuView.prepare(parser, DanmakuContext.create());
                mDanmakuView.showFPS(false);
                mDanmakuView.enableDanmakuDrawingCache(false);
                mDanmakuView.setCallback(new DrawHandler.Callback()
                {

                    @Override
                    public void prepared()
                    {

                        subscriber.onCompleted();
                    }

                    @Override
                    public void updateTimer(DanmakuTimer danmakuTimer)
                    {

                    }

                    @Override
                    public void danmakuShown(BaseDanmaku danmaku)
                    {

                    }

                    @Override
                    public void drawingFinished()
                    {

                    }
                });
            }
        });
    }

//    private String mBatteryLevel;
//
//    private void setBatteryLevel()
//    {
//
//        if (mMediaController != null)
//            mMediaController.setBatteryLevel(mBatteryLevel);
//    }
//
//    private class BatteryReceiver extends BroadcastReceiver
//    {
//
//        @Override
//        public void onReceive(Context context, Intent intent)
//        {
//
//            int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
//            int scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, 100);
//            int percent = scale > 0 ? level * 100 / scale : 0;
//            if (percent > 100)
//                percent = 100;
//            mBatteryLevel = String.valueOf(percent) + "%";
//            setBatteryLevel();
//        }
//    }
}
