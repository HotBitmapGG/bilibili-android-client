package com.hotbitmapgg.ohmybilibili.module.video;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.Toolbar;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.base.RxAppCompatBaseActivity;
import com.hotbitmapgg.ohmybilibili.module.user.UserInfoActivity;
import com.hotbitmapgg.ohmybilibili.utils.LogUtil;
import com.hotbitmapgg.ohmybilibili.widget.CircleImageView;
import com.squareup.picasso.Picasso;

import java.io.IOException;

import butterknife.Bind;
import butterknife.OnClick;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/**
 * 直播播放界面
 *
 * @HotBitmapGG
 */
public class BiliBiliLivePlayerActivity extends RxAppCompatBaseActivity
{

    @Bind(R.id.video_view)
    SurfaceView videoView;

    @Bind(R.id.bili_anim)
    ImageView mAnimView;

    @Bind(R.id.right_play)
    ImageView mRightPlayBtn;

    @Bind(R.id.bottom_layout)
    RelativeLayout mBottomLayout;

    @Bind(R.id.bottom_play)
    ImageView mBottomPlayBtn;

    @Bind(R.id.bottom_fullscreen)
    ImageView mBottomFullscreen;

    @Bind(R.id.video_start_info)
    TextView mLoadTv;

    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    @Bind(R.id.user_pic)
    CircleImageView mUserPic;

    @Bind(R.id.user_name)
    TextView mUserName;

    @Bind(R.id.live_num)
    TextView mLiveNum;


    private IjkMediaPlayer ijkMediaPlayer;

    private SurfaceHolder holder;

    private OkHttpClient client;

    private int flag = 0;

    private boolean isPlay = false;

    private AnimationDrawable mAnimViewBackground;

    private int cid;

    private String title;

    private int online;

    private String face;

    private String name;

    private int mid;

    private Handler mHandler = new Handler()
    {

        @Override
        public void handleMessage(Message msg)
        {

            if (msg.what == 0)
            {

                stopAnim();
                isPlay = true;
                videoView.setVisibility(View.VISIBLE);
                mRightPlayBtn.setImageResource(R.drawable.ic_tv_stop);
                mBottomPlayBtn.setImageResource(R.drawable.ic_portrait_stop);
            }
            super.handleMessage(msg);
        }
    };


    @Override
    public int getLayoutId()
    {

        return R.layout.activity_live_detail;
    }

    @Override
    public void initViews(Bundle savedInstanceState)
    {

        Intent intent = getIntent();
        if (intent != null)
        {
            cid = intent.getIntExtra("cid", 0);
            title = intent.getStringExtra("title");
            online = intent.getIntExtra("online", 0);
            face = intent.getStringExtra("face");
            name = intent.getStringExtra("name");
            mid = intent.getIntExtra("mid", 0);
        }


        initVideo();
        initUserInfo();
        startAnim();
    }

    private void initUserInfo()
    {

        Picasso.with(this).load(face).placeholder(R.drawable.ico_user_default).into(mUserPic);
        mUserName.setText(name);
        mLiveNum.setText(online + "");
    }

    private void startAnim()
    {

        mAnimViewBackground = (AnimationDrawable) mAnimView.getBackground();
        mAnimViewBackground.start();
    }

    private void stopAnim()
    {

        mAnimViewBackground.stop();
        mAnimView.setVisibility(View.GONE);
        mLoadTv.setVisibility(View.GONE);
    }

    @Override
    public void initToolBar()
    {

        mToolbar.setTitle(title);
        mToolbar.setNavigationIcon(R.drawable.action_button_back_pressed_light);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {

                finish();
            }
        });
    }


    private void initVideo()
    {

        client = new OkHttpClient();
        holder = videoView.getHolder();
        ijkMediaPlayer = new IjkMediaPlayer();

        new Thread(new Runnable()
        {

            @Override
            public void run()
            {

                try
                {
                    execute();
                } catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void execute() throws Exception
    {

        ijkMediaPlayer.stop();

        String url = "http://live.bilibili.com/api/playurl?player=1&quality=0&cid=" + cid;
        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute();

        if (response.isSuccessful())
        {
            String str = response.body().string();
            LogUtil.lsw(str);
            String result = str.substring(str.lastIndexOf("[") + 1, str.lastIndexOf("]") - 1);
            playVideo(result);

            mHandler.sendEmptyMessageDelayed(0, 2000);
        }
    }


    private void playVideo(String uri)
    {

        try
        {
            ijkMediaPlayer.setDataSource(this, Uri.parse(uri));
            ijkMediaPlayer.setDisplay(holder);
            holder.addCallback(new SurfaceHolder.Callback()
            {

                @Override
                public void surfaceCreated(SurfaceHolder holder)
                {

                }

                @Override
                public void surfaceChanged(SurfaceHolder holder, int format, int width, int height)
                {

                    ijkMediaPlayer.setDisplay(holder);
                }

                @Override
                public void surfaceDestroyed(SurfaceHolder holder)
                {

                }
            });
            ijkMediaPlayer.prepareAsync();
            ijkMediaPlayer.start();
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        ijkMediaPlayer.setKeepInBackground(false);
    }

    private void startBottomShowAnim()
    {

        mBottomLayout.setVisibility(View.VISIBLE);
        mRightPlayBtn.setVisibility(View.VISIBLE);
    }

    private void startBottomHideAnim()
    {

        mBottomLayout.setVisibility(View.GONE);
        mRightPlayBtn.setVisibility(View.GONE);
    }


    @OnClick(R.id.right_play)
    void rightPlay()
    {

        ControlVideo();
    }

    @OnClick(R.id.bottom_play)
    void bottomPlay()
    {

        ControlVideo();
    }

    @OnClick(R.id.bottom_fullscreen)
    void fullScreen()
    {

    }


    @OnClick(R.id.video_view)
    void showBottomLayout()
    {

        if (flag == 0)
        {
            startBottomShowAnim();
            flag = 1;
        } else
        {
            startBottomHideAnim();
            flag = 0;
        }
    }

    @OnClick(R.id.user_pic)
    void startUserInfo()
    {

        UserInfoActivity.launch(BiliBiliLivePlayerActivity.this, name, mid, face);
        ControlVideo();
        mRightPlayBtn.setVisibility(View.VISIBLE);
    }

    private void ControlVideo()
    {

        if (isPlay)
        {
            ijkMediaPlayer.pause();
            isPlay = false;
            mRightPlayBtn.setImageResource(R.drawable.ic_tv_play);
            mBottomPlayBtn.setImageResource(R.drawable.ic_portrait_play);
        } else
        {
            ijkMediaPlayer.start();
            isPlay = true;
            mRightPlayBtn.setImageResource(R.drawable.ic_tv_stop);
            mBottomPlayBtn.setImageResource(R.drawable.ic_portrait_stop);
        }
    }

    @Override
    protected void onDestroy()
    {

        super.onDestroy();
        ijkMediaPlayer.release();
    }
}
