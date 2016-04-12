package com.hotbitmapgg.ohmybilibili.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.adapter.UserUpVideoAdapter;
import com.hotbitmapgg.ohmybilibili.api.UserInfoApi;
import com.hotbitmapgg.ohmybilibili.model.BasicMessage;
import com.hotbitmapgg.ohmybilibili.model.UserInfo;
import com.hotbitmapgg.ohmybilibili.model.UserVideoItem;
import com.hotbitmapgg.ohmybilibili.model.UserVideoList;
import com.hotbitmapgg.ohmybilibili.network.ApiHelper;
import com.hotbitmapgg.ohmybilibili.network.AbsAsyncTask;
import com.hotbitmapgg.ohmybilibili.network.UrlHelper;
import com.hotbitmapgg.ohmybilibili.network.Utility;
import com.hotbitmapgg.ohmybilibili.okhttp.OkHttpClientManager;
import com.hotbitmapgg.ohmybilibili.utils.LogUtil;
import com.hotbitmapgg.ohmybilibili.widget.AppBarLayout;
import com.hotbitmapgg.ohmybilibili.widget.CircleImageView;
import com.hotbitmapgg.ohmybilibili.widget.CircleProgressView;
import com.hotbitmapgg.ohmybilibili.widget.ExpandableHeightGridView;
import com.hotbitmapgg.ohmybilibili.widget.ObservableScrollView;
import com.squareup.okhttp.Request;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class UserInfoActivity extends AppCompatActivity implements ObservableScrollView.OnScrollChangeListener
{

    private CircleImageView mAvatarImage;

    private TextView mUserNameText, mDescriptionText, mFollowNumText, mFansNumText;

    private ExpandableHeightGridView mUserVideoList;

    private String name = "";

    private int mid;

    private String avatar_url;

    private UserInfo userInfo;

    private ArrayList<Integer> uids = new ArrayList<Integer>();

    private ArrayList<UserInfo> users;

    private List<UserVideoItem> userVideoList = new ArrayList<>();

    private UserUpVideoAdapter mPartListAdapter;

    private static final String EXTRA_USER_NAME = "extra_user_name", EXTRA_MID = "extra_mid", EXTRA_AVATAR_URL = "extra_avatar_url";

    private ObservableScrollView mScrollView;

    private AppBarLayout mAppBarLayout;

    private FrameLayout mAppBarBackground;

    private int APP_BAR_HEIGHT, TOOLBAR_HEIGHT, STATUS_BAR_HEIGHT = 0, minHeight = 0;

    private ImageView mPreviewView;

    private CircleProgressView mCircleProgressView;

    private TextView mUpTip;

    private Toolbar mToolbar;

    private TextView mMoreTextView;

    private ImageView mUserLv;

    private ImageView mUserSex;

    private LinearLayout mAuthorVerifiedLayout;

    private TextView mAuthorVerifiedText;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);


        APP_BAR_HEIGHT = getResources().getDimensionPixelSize(R.dimen.appbar_parallax_max_height);
        TOOLBAR_HEIGHT = getResources().getDimensionPixelSize(R.dimen.abc_action_bar_default_height_material);
        if (Build.VERSION.SDK_INT >= 19)
        {
            STATUS_BAR_HEIGHT = Utility.getStatusBarHeight(getApplicationContext());
        }
        minHeight = APP_BAR_HEIGHT - TOOLBAR_HEIGHT - STATUS_BAR_HEIGHT;

        Intent intent = getIntent();
        name = intent.getStringExtra(EXTRA_USER_NAME);
        mid = intent.getIntExtra(EXTRA_MID, -1);
        avatar_url = intent.getStringExtra(EXTRA_AVATAR_URL);

        setContentView(R.layout.activity_user_info);
        initView();

        startGetUserBasicInfo();
    }

    private void startGetUserBasicInfo()
    {

        mCircleProgressView.setVisibility(View.VISIBLE);
        mCircleProgressView.spin();

        new UserBasicInfoTaskAbs().execute();
    }

    protected void initView()
    {

        mAvatarImage = (CircleImageView) findViewById(R.id.user_avatar_view);
        mUserNameText = (TextView) findViewById(R.id.user_name);
        mDescriptionText = (TextView) findViewById(R.id.user_desc);
        mFollowNumText = (TextView) findViewById(R.id.tv_follow_users);
        mFansNumText = (TextView) findViewById(R.id.tv_fans);
        mUserVideoList = (ExpandableHeightGridView) findViewById(R.id.user_video_list);

        mScrollView = (ObservableScrollView) findViewById(R.id.user_scroll_view);
        mAppBarLayout = (AppBarLayout) findViewById(R.id.user_appbar_layout);
        mAppBarBackground = (FrameLayout) findViewById(R.id.user_appbar_container);
        mPreviewView = (ImageView) findViewById(R.id.user_pic);

        mCircleProgressView = (CircleProgressView) findViewById(R.id.circle_progress);
        mUpTip = (TextView) findViewById(R.id.tv_up_contributor);
        mUserLv = (ImageView) findViewById(R.id.user_lv);
        mUserSex = (ImageView) findViewById(R.id.user_sex);
        mAuthorVerifiedLayout = (LinearLayout) findViewById(R.id.author_verified_layout);
        mAuthorVerifiedText = (TextView) findViewById(R.id.author_verified_text);

        mMoreTextView = (TextView) findViewById(R.id.btn_go_more);
        mMoreTextView.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                //查看Up主所有视频
                UpMoreCoverActivity.launch(UserInfoActivity.this, userInfo.name, userInfo.mid);
            }
        });

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setNavigationIcon(R.drawable.action_button_back_pressed_light);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {

                finish();
            }
        });

        mScrollView.addOnScrollChangeListener(this);

        mFollowNumText.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {

                UserAttentionActivity.launch(UserInfoActivity.this, new ArrayList<>(userInfo.attentions), name);
            }
        });
        mFansNumText.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {

                UserFansActivity.launch(UserInfoActivity.this, mid + "", name);
            }
        });

        if (name != null)
        {
            mUserNameText.setText(name);
        }
        if (avatar_url != null)
        {
            Picasso.with(this).load(avatar_url).placeholder(R.drawable.ico_user_default).into(mAvatarImage);
        }
    }

    public void finishBasicInfoGetTask()
    {

        findViewById(R.id.number_bar).setVisibility(View.VISIBLE);

        mUserNameText.setText(userInfo.name);
        mFollowNumText.setText(String.format(getString(R.string.info_following_format), userInfo.attention));
        mFansNumText.setText(String.format(getString(R.string.info_fans_format), userInfo.fans));

        mToolbar.setTitle("");

        Picasso.with(this).load(UrlHelper.getFaceUrl(userInfo)).placeholder(R.drawable.ico_user_default).into(mAvatarImage);
        setUserLevel(userInfo.rank);
        if(userInfo.sex.equals("男"))
        {
            mUserSex.setImageResource(R.drawable.ic_user_male_border);
        }
        else
        {
            mUserSex.setImageResource(R.drawable.ic_user_female_border);
        }
        if(userInfo.approve)
        {
            //认证用户 显示认证资料
            mAuthorVerifiedLayout.setVisibility(View.VISIBLE);
            mDescriptionText.setVisibility(View.GONE);
            if(!TextUtils.isEmpty(userInfo.description))
            {
                mAuthorVerifiedText.setText(userInfo.description);
            }
            else
            {
                mAuthorVerifiedText.setText("这个家伙太懒,什么都没有填写");
            }

        }
        else
        {
            //普通用户
            mAuthorVerifiedLayout.setVisibility(View.GONE);
            mDescriptionText.setVisibility(View.VISIBLE);
            if (!TextUtils.isEmpty(userInfo.sign))
            {
                mDescriptionText.setText(userInfo.sign);
            } else
            {
                mDescriptionText.setText("这个家伙太懒,什么都没有填写");
            }

        }

        List<Integer> attentions = userInfo.attentions;
        LogUtil.lsw(attentions.size() + "");
        uids.addAll(attentions);

        startGetListTask();
    }

    private void setUserLevel(int rank)
    {
      if(rank == 0)
      {
         mUserLv.setImageResource(R.drawable.ic_lv0);
      }
        else if(rank == 1)
      {
          mUserLv.setImageResource(R.drawable.ic_lv1);
      }
        else if(rank == 200)
      {
          mUserLv.setImageResource(R.drawable.ic_lv2);
      }
        else if(rank == 1500)
      {
          mUserLv.setImageResource(R.drawable.ic_lv3);
      }
        else if(rank == 3000)
      {
          mUserLv.setImageResource(R.drawable.ic_lv4);
      }
        else if(rank == 7000)
      {
          mUserLv.setImageResource(R.drawable.ic_lv5);
      }
        else if(rank == 10000)
      {
          mUserLv.setImageResource(R.drawable.ic_lv6);
      }
    }

    private void startGetListTask()
    {
        getUserVideoList();
    }

    private void getUserVideoList()
    {

        String url = ApiHelper.getUserVideoListUrl(userInfo.mid, 1, 10);
        OkHttpClientManager.getAsyn(url, new OkHttpClientManager.ResultCallback<String>()

                {

                    @Override
                    public void onError(Request request, Exception e)
                    {
                        // TODO Auto-generated method stub

                    }

                    @Override
                    public void onResponse(String response)
                    {

                        UserVideoList videoList = UserVideoList.createFromJson(response);
                        if (videoList != null)
                        {
                            List<UserVideoItem> datas = videoList.lists;
                            userVideoList.addAll(datas);
                            int results = videoList.results;

                            finishUserVideoListGetTask(results);
                        }
                    }
                }
        );
    }


    private void finishUserVideoListGetTask(int results)
    {

        mPartListAdapter = new UserUpVideoAdapter(UserInfoActivity.this, userVideoList);
        mUserVideoList.setAdapter(mPartListAdapter);
        mUserVideoList.setOnItemClickListener(new OnItemClickListener()
        {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {

                UserVideoItem videoItem = mPartListAdapter.getItem(position);
                int aid = videoItem.aid;
                VideoViewActivity.launch(UserInfoActivity.this, aid);
            }
        });

        mUpTip.setVisibility(View.VISIBLE);
        mUpTip.setText("Up主的投稿" + " " + "(" + results + ")");
        mUserVideoList.setVisibility(View.VISIBLE);
        mCircleProgressView.setVisibility(View.GONE);
        mCircleProgressView.stopSpinning();
        mMoreTextView.setVisibility(View.VISIBLE);
        mUserVideoList.setExpanded(true);
    }


    public static void launch(Activity activity, String name, int mid, String avatar_url)
    {

        Intent intent = new Intent(activity, UserInfoActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra(EXTRA_USER_NAME, name);
        intent.putExtra(EXTRA_MID, mid);
        intent.putExtra(EXTRA_AVATAR_URL, avatar_url);
        activity.startActivity(intent);
    }

    public class UserBasicInfoTaskAbs extends AbsAsyncTask<Void,Void,BasicMessage<UserInfo>>
    {

        @Override
        protected BasicMessage<UserInfo> doInBackground(Void... params)
        {

            return UserInfoApi.getUserInfoByName(name);
        }

        @Override
        protected void onPostExecute(BasicMessage<UserInfo> msg)
        {

            if (msg != null)
            {
                if (msg.getCode() == BasicMessage.CODE_SUCCEED)
                {
                    userInfo = msg.getObject();
                    finishBasicInfoGetTask();
                } else if (msg.getCode() == UserInfo.CODE_NOT_EXIST)
                {

                }
            }
        }
    }


    @Override
    public void onScrollChanged(ObservableScrollView view, int x, int y, int oldx, int oldy)
    {
        // TODO Auto-generated method stub
        setViewsTranslation(Math.min(minHeight, y));
    }


    private void setViewsTranslation(int target)
    {

        mAppBarBackground.setTranslationY(-target);
        mAppBarLayout.setTranslationY(target);
        float alpha = Math.min(1, -mAppBarBackground.getTranslationY() / (float) minHeight);
        mAppBarLayout.setAlpha(alpha);


        if (alpha > 0.8f)
        {
            mToolbar.setTitle(userInfo.name);
        } else if (alpha < 0.65f)
        {
            mToolbar.setTitle("");
        }


        mPreviewView.setTranslationY(target * 0.7f);
    }
}
