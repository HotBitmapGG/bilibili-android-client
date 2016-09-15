package com.hotbitmapgg.ohmybilibili.module.video;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.base.RxAppCompatBaseActivity;
import com.hotbitmapgg.ohmybilibili.entity.video.HDVideoInfo;
import com.hotbitmapgg.ohmybilibili.entity.video.VideoSrc;
import com.hotbitmapgg.ohmybilibili.media.callback.DanmakuSwitchEvent;
import com.hotbitmapgg.ohmybilibili.media.MediaController;
import com.hotbitmapgg.ohmybilibili.media.callback.VideoBackEvent;
import com.hotbitmapgg.ohmybilibili.network.RetrofitHelper;
import com.hotbitmapgg.ohmybilibili.utils.DanmakuDownloadUtil;
import com.hotbitmapgg.ohmybilibili.widget.VideoPlayerView;

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

/**
 * Created by hcc on 16/8/30 19:50
 * 100332338@qq.com
 * <p/>
 * 视频播放界面
 */
public class VideoPlayerActivity extends RxAppCompatBaseActivity implements DanmakuSwitchEvent, VideoBackEvent
{


    @Bind(R.id.sv_danmaku)
    IDanmakuView mDanmakuView;

    @Bind(R.id.playerView)
    VideoPlayerView mPlayerView;

    @Bind(R.id.buffering_indicator)
    View mBufferingIndicator;

    @Bind(R.id.video_start)
    RelativeLayout mVideoPrepareLayout;

    @Bind(R.id.bili_anim)
    ImageView mAnimImageView;

    @Bind(R.id.video_start_info)
    TextView mPrepareText;

    private String startText = "初始化播放器...";

    private static final String ERROR_MESSAGE = "error";

    private static final String UNFIND_MESSAGE = "undefined";

    private static final String VIDEO_TYPE_MP4 = "mp4";

    private static final String EXTRA_AID = "extra_aid";

    private int LastPosition = 0;

    private int aid;

    private AnimationDrawable mLoadingAnim;

    private Observable<VideoSrc> observable;

    private MediaController mMediaController;


    @Override
    public void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().setBackgroundDrawable(null);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        // 初始化加载动画
        mVideoPrepareLayout.setVisibility(View.VISIBLE);
        startText = startText + "【完成】\n解析视频地址...【完成】\n全舰弹幕填装...";
        mPrepareText.setText(startText);
        mLoadingAnim = (AnimationDrawable) mAnimImageView.getBackground();
        mLoadingAnim.start();
    }


    @Override
    public int getLayoutId()
    {

        return R.layout.activity_video_player;
    }

    @Override
    public void initViews(Bundle savedInstanceState)
    {

        Intent intent = getIntent();
        if (intent != null)
            aid = intent.getIntExtra(EXTRA_AID, 0);

        initData();
    }

    @Override
    public void initToolBar()
    {

    }

    private void initData()
    {
        //配置播放器
        mMediaController = new MediaController(this);
        mDanmakuView.enableDanmakuDrawingCache(true);
        mPlayerView.setMediaController(mMediaController);
        mPlayerView.setMediaBufferingIndicator(mBufferingIndicator);
        mPlayerView.requestFocus();

        mPlayerView.setOnInfoListener(onInfoListener);
        mPlayerView.setOnSeekCompleteListener(onSeekCompleteListener);
        mPlayerView.setOnCompletionListener(onCompletionListener);
        mPlayerView.setOnControllerEventsListener(onControllerEventsListener);

        // 设置弹幕开关监听
        mMediaController.setDanmakuSwitchListener(this);
        //设置返回键监听
        mMediaController.setVideoBackEvent(this);

        // 获取Html5的视频数据
        observable = RetrofitHelper.getHtml5VideoPlayerUrlApi()
                .getHtml5VideoPlayerUrl(aid, 1)
                .compose(this.<VideoSrc> bindToLifecycle())
                .subscribeOn(Schedulers.io());

        //合并视频和弹幕数据
        Observable.merge(loadVideo(), loadDanmaku())
                .last()
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

                        startText = startText + "【失败】\n视频缓冲中...";
                        mPrepareText.setText(startText);
                        startText = startText + "【失败】\n" + e.getMessage();
                        mPrepareText.setText(startText);
                    }

                    @Override
                    public void onNext(Object o)
                    {

                    }
                });
    }


    public Observable<Object> loadDanmaku()
    {

        return observable
                .compose(this.<VideoSrc> bindToLifecycle())
                .map(new Func1<VideoSrc,String>()
                {

                    @Override
                    public String call(VideoSrc videoSrc)
                    {

                        if (videoSrc.getCid() == null || videoSrc.getCid()
                                .contentEquals(UNFIND_MESSAGE))
                        {
                            return ERROR_MESSAGE;
                        }
                        return videoSrc.getCid();
                    }
                })
                .flatMap(new Func1<String,Observable<BaseDanmakuParser>>()
                {

                    @Override
                    public Observable<BaseDanmakuParser> call(String string)
                    {

                        if (string.equals(ERROR_MESSAGE))
                        {
                            return Observable.error(new Exception("视频不存在或不能播放"));
                        }
                        return new DanmakuDownloadUtil().downloadXML(string);
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap(new Func1<BaseDanmakuParser,Observable<?>>()
                {

                    @Override
                    public Observable<?> call(BaseDanmakuParser parser)
                    {

                        return prepareDanmaku(parser);
                    }
                });
    }


    public Observable<Object> loadVideo()
    {

        return observable
                .compose(this.<VideoSrc> bindToLifecycle())
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

                        if (s == null || s.contentEquals(UNFIND_MESSAGE))
                        {
                            return ERROR_MESSAGE;
                        }
                        return s.substring(s.lastIndexOf('/') + 1, s.lastIndexOf("."));
                    }
                })
                .flatMap(new Func1<String,Observable<HDVideoInfo>>()
                {

                    @Override
                    public Observable<HDVideoInfo> call(String cid)
                    {

                        if (cid.equals(ERROR_MESSAGE))
                        {
                            return Observable.error(new Exception("视频不存在或不能播放"));
                        }

                        return RetrofitHelper.getHDVideoApi()
                                .getHDVideoUrl(cid, 4, VIDEO_TYPE_MP4);
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

                        return prepareVideo(uri);
                    }
                });
    }


    public Observable prepareVideo(final Uri src)
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
                        mLoadingAnim.stop();
                        startText = startText + "【完成】\n视频缓冲中...";
                        mPrepareText.setText(startText);
                        mVideoPrepareLayout.setVisibility(View.GONE);
                    }
                });
            }
        });
    }

    public Observable prepareDanmaku(final BaseDanmakuParser parser)
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


    @Override
    protected void onResume()
    {

        super.onResume();
        if (mDanmakuView != null && mDanmakuView.isPrepared() && mDanmakuView.isPaused())
        {
            mDanmakuView.seekTo((long) LastPosition);
        }
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
            mDanmakuView.release();
            mDanmakuView = null;
        }
        if (mLoadingAnim != null)
        {
            mLoadingAnim.stop();
            mLoadingAnim = null;
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
        if (mLoadingAnim != null)
        {
            mLoadingAnim.stop();
            mLoadingAnim = null;
        }
    }


    /**
     * 视频缓冲事件回调
     */
    private IMediaPlayer.OnInfoListener onInfoListener =
            new IMediaPlayer.OnInfoListener()
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

    /**
     * 视频跳转事件回调
     */
    private IMediaPlayer.OnSeekCompleteListener onSeekCompleteListener =
            new IMediaPlayer.OnSeekCompleteListener()
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

    /**
     * 视频播放完成事件回调
     */
    private IMediaPlayer.OnCompletionListener onCompletionListener =
            new IMediaPlayer.OnCompletionListener()
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

    /**
     * 控制条控制状态事件回调
     */
    private VideoPlayerView.OnControllerEventsListener onControllerEventsListener =
            new VideoPlayerView.OnControllerEventsListener()
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


    public static void launch(Activity activity, int aid)
    {

        Intent mIntent = new Intent(activity, VideoPlayerActivity.class);
        mIntent.putExtra(EXTRA_AID, aid);
        activity.startActivity(mIntent);
    }

    @Override
    public void setDanmakushow(boolean isShow)
    {

        if (mDanmakuView != null)
        {
            if (isShow)
            {
                mDanmakuView.show();
            } else
            {
                mDanmakuView.hide();
            }
        }
    }

    @Override
    public void back()
    {

        onBackPressed();
    }
}
