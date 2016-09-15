package com.hotbitmapgg.ohmybilibili.media;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.media.AudioManager;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.media.callback.DanmakuSwitchEvent;
import com.hotbitmapgg.ohmybilibili.media.callback.MediaPlayerControl;
import com.hotbitmapgg.ohmybilibili.media.callback.VideoBackEvent;
import com.hotbitmapgg.ohmybilibili.widget.OutlineTextView;

import java.util.Locale;

import tv.danmaku.ijk.media.player.pragma.DebugLog;

/**
 * Created by hcc on 16/8/31 19:50
 * 100332338@qq.com
 * <p/>
 * 播放器控制器
 */
public class MediaController extends FrameLayout
{

    private static final String TAG = MediaController.class.getSimpleName();

    private static final int sDefaultTimeout = 3000;

    private static final int FADE_OUT = 1;

    private static final int SHOW_PROGRESS = 2;

    private MediaPlayerControl mPlayer;

    private Context mContext;

    private PopupWindow mWindow;

    private int mAnimStyle;

    private View mAnchor;

    private View mRoot;

    private ProgressBar mProgress;

    private TextView mEndTime, mCurrentTime;

    private TextView mFileName;

    private OutlineTextView mInfoView;

    private String mTitle;

    private long mDuration;

    private boolean mShowing;

    private boolean mDragging;

    private boolean mInstantSeeking = true;

    private boolean mFromXml = false;

    private ImageButton mPauseButton;

    private AudioManager mAM;

    private OnShownListener mShownListener;

    private OnHiddenListener mHiddenListener;

    private boolean mDanmakuShow = true;

    private DanmakuSwitchEvent mDanmakuSwitchEvent;

    private ImageView mBack;

    private VideoBackEvent mVideoBackEvent;

    public void setDanmakuSwitchListener(DanmakuSwitchEvent danmakuSwitchEvent)
    {

        this.mDanmakuSwitchEvent = danmakuSwitchEvent;
    }

    public void setVideoBackEvent(VideoBackEvent videoBackEvent)
    {

        this.mVideoBackEvent = videoBackEvent;
    }

    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler()
    {

        @Override
        public void handleMessage(Message msg)
        {

            long pos;
            switch (msg.what)
            {
                case FADE_OUT:
                    hide();
                    break;
                case SHOW_PROGRESS:
                    pos = setProgress();
                    if (!mDragging && mShowing)
                    {
                        msg = obtainMessage(SHOW_PROGRESS);
                        sendMessageDelayed(msg, 1000 - (pos % 1000));
                        updatePausePlay();
                    }
                    break;
            }
        }
    };

    private OnClickListener mPauseListener = new OnClickListener()
    {

        public void onClick(View v)
        {

            doPauseResume();
            show(sDefaultTimeout);
        }
    };

    private Runnable lastRunnable;

    private OnSeekBarChangeListener mSeekListener = new OnSeekBarChangeListener()
    {

        public void onStartTrackingTouch(SeekBar bar)
        {

            mDragging = true;
            show(3600000);
            mHandler.removeMessages(SHOW_PROGRESS);
            if (mInstantSeeking)
                mAM.setStreamMute(AudioManager.STREAM_MUSIC, true);
            if (mInfoView != null)
            {
                mInfoView.setText("");
                mInfoView.setVisibility(View.VISIBLE);
            }
        }

        public void onProgressChanged(SeekBar bar, int progress,
                                      boolean fromuser)
        {

            if (!fromuser)
                return;

            final long newposition = (mDuration * progress) / 1000;
            String time = generateTime(newposition);
            if (mInstantSeeking)
            {
                mHandler.removeCallbacks(lastRunnable);
                lastRunnable = new Runnable()
                {

                    @Override
                    public void run()
                    {

                        mPlayer.seekTo(newposition);
                    }
                };
                mHandler.postDelayed(lastRunnable, 200);
            }
            if (mInfoView != null)
                mInfoView.setText(time);
            if (mCurrentTime != null)
                mCurrentTime.setText(time);
        }

        public void onStopTrackingTouch(SeekBar bar)
        {

            if (!mInstantSeeking)
                mPlayer.seekTo((mDuration * bar.getProgress()) / 1000);
            if (mInfoView != null)
            {
                mInfoView.setText("");
                mInfoView.setVisibility(View.GONE);
            }
            show(sDefaultTimeout);
            mHandler.removeMessages(SHOW_PROGRESS);
            mAM.setStreamMute(AudioManager.STREAM_MUSIC, false);
            mDragging = false;
            mHandler.sendEmptyMessageDelayed(SHOW_PROGRESS, 1000);
        }
    };

    private ImageButton mDanmakuSwitch;

    public MediaController(Context context, AttributeSet attrs)
    {

        super(context, attrs);
        mRoot = this;
        mFromXml = true;
        initController(context);
    }

    public MediaController(Context context)
    {

        super(context);
        if (!mFromXml && initController(context))
            initFloatingWindow();
    }

    private static String generateTime(long position)
    {

        int totalSeconds = (int) ((position / 1000.0) + 0.5);

        int seconds = totalSeconds % 60;
        int minutes = (totalSeconds / 60) % 60;
        int hours = totalSeconds / 3600;

        if (hours > 0)
        {
            return String.format(Locale.US, "%02d:%02d:%02d", hours, minutes,
                    seconds);
        } else
        {
            return String.format(Locale.US, "%02d:%02d", minutes, seconds);
        }
    }

    private boolean initController(Context context)
    {

        mContext = context;
        mAM = (AudioManager) mContext.getSystemService(Context.AUDIO_SERVICE);
        return true;
    }

    @Override
    public void onFinishInflate()
    {

        super.onFinishInflate();
        if (mRoot != null)
            initControllerView(mRoot);
    }


    private void initFloatingWindow()
    {

        mWindow = new PopupWindow(mContext);
        mWindow.setFocusable(false);
        mWindow.setBackgroundDrawable(null);
        mWindow.setOutsideTouchable(true);
        mAnimStyle = android.R.style.Animation;
    }

    /**
     * 设置VideoView
     *
     * @param view
     */
    public void setAnchorView(View view)
    {

        mAnchor = view;
        if (!mFromXml)
        {
            removeAllViews();
            mRoot = makeControllerView();
            mWindow.setContentView(mRoot);
            mWindow.setWidth(LayoutParams.MATCH_PARENT);
            mWindow.setHeight(LayoutParams.WRAP_CONTENT);
        }
        initControllerView(mRoot);
    }

    /**
     * 创建视图包含小部件,控制回放
     *
     * @return
     */
    protected View makeControllerView()
    {

        return ((LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(
                R.layout.layout_media_controller, this);
    }

    private void initControllerView(View v)
    {

        mPauseButton = (ImageButton) v
                .findViewById(R.id.media_controller_play_pause);
        if (mPauseButton != null)
        {
            mPauseButton.requestFocus();
            mPauseButton.setOnClickListener(mPauseListener);
        }

        mProgress = (SeekBar) v.findViewById(R.id.media_controller_seekbar);
        if (mProgress != null)
        {
            if (mProgress instanceof SeekBar)
            {
                SeekBar seeker = (SeekBar) mProgress;
                seeker.setOnSeekBarChangeListener(mSeekListener);
                seeker.setThumbOffset(1);
            }
            mProgress.setMax(1000);
        }

        mEndTime = (TextView) v.findViewById(R.id.media_controller_time_total);
        mCurrentTime = (TextView) v
                .findViewById(R.id.media_controller_time_current);
        mFileName = (TextView) v.findViewById(R.id.media_controller_file_name);
        if (mFileName != null)
            mFileName.setText(mTitle);

        mDanmakuSwitch = (ImageButton) v.
                findViewById(R.id.media_controller_danmaku_switch);
        mDanmakuSwitch.setOnClickListener(new OnClickListener()
        {

            @Override
            public void onClick(View v)
            {

                if (mDanmakuShow)
                {
                    mDanmakuSwitch.setImageResource(R.drawable.bili_player_danmaku_is_closed);
                    mDanmakuSwitchEvent.setDanmakushow(false);
                    mDanmakuShow = false;
                } else
                {
                    mDanmakuSwitch.setImageResource(R.drawable.bili_player_danmaku_is_open);
                    mDanmakuSwitchEvent.setDanmakushow(true);
                    mDanmakuShow = true;
                }
            }
        });

        mBack = (ImageView) v.findViewById(R.id.media_controller_back);
        mBack.setOnClickListener(new OnClickListener()
        {

            @Override
            public void onClick(View v)
            {

                mVideoBackEvent.back();
            }
        });
    }

    public void setMediaPlayer(MediaPlayerControl player)
    {

        mPlayer = player;
        updatePausePlay();
    }

    /**
     * 拖动seekBar时回调
     *
     * @param seekWhenDragging
     */
    public void setInstantSeeking(boolean seekWhenDragging)
    {

        mInstantSeeking = seekWhenDragging;
    }

    public void show()
    {

        show(sDefaultTimeout);
    }

    /**
     * 设置播放的文件名称
     *
     * @param name
     */
    public void setFileName(String name)
    {

        mTitle = name;
        if (mFileName != null)
            mFileName.setText(mTitle);
    }

    /**
     * 设置MediaController持有的View
     *
     * @param v
     */
    public void setInfoView(OutlineTextView v)
    {

        mInfoView = v;
    }

    private void disableUnsupportedButtons()
    {

        try
        {
            if (mPauseButton != null && !mPlayer.canPause())
                mPauseButton.setEnabled(false);
        } catch (IncompatibleClassChangeError ex)
        {
        }
    }

    /**
     * 改变控制器的动画风格的资源
     */
    public void setAnimationStyle(int animationStyle)
    {

        mAnimStyle = animationStyle;
    }

    /**
     * 在屏幕上显示控制器
     *
     * @param timeout
     */
    @SuppressLint("InlinedApi")
    public void show(int timeout)
    {

        if (!mShowing && mAnchor != null && mAnchor.getWindowToken() != null)
        {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH)
            {
                mAnchor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);
            }
            if (mPauseButton != null)
                mPauseButton.requestFocus();
            disableUnsupportedButtons();

            if (mFromXml)
            {
                setVisibility(View.VISIBLE);
            } else
            {
                int[] location = new int[2];

                mAnchor.getLocationOnScreen(location);
                Rect anchorRect = new Rect(location[0], location[1],
                        location[0] + mAnchor.getWidth(), location[1]
                        + mAnchor.getHeight());

                mWindow.setAnimationStyle(mAnimStyle);
                mWindow.showAtLocation(mAnchor, Gravity.BOTTOM,
                        anchorRect.left, 0);
            }
            mShowing = true;
            if (mShownListener != null)
                mShownListener.onShown();
        }
        updatePausePlay();
        mHandler.sendEmptyMessage(SHOW_PROGRESS);

        if (timeout != 0)
        {
            mHandler.removeMessages(FADE_OUT);
            mHandler.sendMessageDelayed(mHandler.obtainMessage(FADE_OUT),
                    timeout);
        }
    }

    public boolean isShowing()
    {

        return mShowing;
    }

    @SuppressLint("InlinedApi")
    public void hide()
    {

        if (mAnchor == null)
            return;

        if (mShowing)
        {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH)
            {
                mAnchor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
            }
            try
            {
                mHandler.removeMessages(SHOW_PROGRESS);
                if (mFromXml)
                    setVisibility(View.GONE);
                else
                    mWindow.dismiss();
            } catch (IllegalArgumentException ex)
            {
                DebugLog.d(TAG, "MediaController already removed");
            }
            mShowing = false;
            if (mHiddenListener != null)
                mHiddenListener.onHidden();
        }
    }

    public void setOnShownListener(OnShownListener l)
    {

        mShownListener = l;
    }

    public void setOnHiddenListener(OnHiddenListener l)
    {

        mHiddenListener = l;
    }

    private long setProgress()
    {

        if (mPlayer == null || mDragging)
            return 0;

        int position = mPlayer.getCurrentPosition();
        int duration = mPlayer.getDuration();
        if (mProgress != null)
        {
            if (duration > 0)
            {
                long pos = 1000L * position / duration;
                mProgress.setProgress((int) pos);
            }
            int percent = mPlayer.getBufferPercentage();
            mProgress.setSecondaryProgress(percent * 10);
        }

        mDuration = duration;

        if (mEndTime != null)
            mEndTime.setText(generateTime(mDuration));
        if (mCurrentTime != null)
            mCurrentTime.setText(generateTime(position));

        return position;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {

        show(sDefaultTimeout);
        return true;
    }

    @Override
    public boolean onTrackballEvent(MotionEvent ev)
    {

        show(sDefaultTimeout);
        return false;
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event)
    {

        int keyCode = event.getKeyCode();
        if (event.getRepeatCount() == 0
                && (keyCode == KeyEvent.KEYCODE_HEADSETHOOK
                || keyCode == KeyEvent.KEYCODE_MEDIA_PLAY_PAUSE || keyCode == KeyEvent.KEYCODE_SPACE))
        {
            doPauseResume();
            show(sDefaultTimeout);
            if (mPauseButton != null)
                mPauseButton.requestFocus();
            return true;
        } else if (keyCode == KeyEvent.KEYCODE_MEDIA_STOP)
        {
            if (mPlayer.isPlaying())
            {
                mPlayer.pause();
                updatePausePlay();
            }
            return true;
        } else if (keyCode == KeyEvent.KEYCODE_BACK
                || keyCode == KeyEvent.KEYCODE_MENU)
        {
            hide();
            return true;
        } else
        {
            show(sDefaultTimeout);
        }
        return super.dispatchKeyEvent(event);
    }

    private void updatePausePlay()
    {

        if (mRoot == null || mPauseButton == null)
            return;

        if (mPlayer.isPlaying())
            mPauseButton
                    .setImageResource(R.drawable.mediacontroller_pause);
        else
            mPauseButton
                    .setImageResource(R.drawable.mediacontroller_play);
    }

    private void doPauseResume()
    {

        if (mPlayer.isPlaying())
            mPlayer.pause();
        else
            mPlayer.start();
        updatePausePlay();
    }

    @Override
    public void setEnabled(boolean enabled)
    {

        if (mPauseButton != null)
            mPauseButton.setEnabled(enabled);
        if (mProgress != null)
            mProgress.setEnabled(enabled);
        disableUnsupportedButtons();
        super.setEnabled(enabled);
    }

    public interface OnShownListener
    {

        public void onShown();
    }

    public interface OnHiddenListener
    {

        public void onHidden();
    }
}
