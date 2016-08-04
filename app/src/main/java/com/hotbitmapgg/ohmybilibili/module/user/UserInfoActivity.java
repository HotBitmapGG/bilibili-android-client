package com.hotbitmapgg.ohmybilibili.module.user;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.adapter.UserUpVideoAdapter;
import com.hotbitmapgg.ohmybilibili.adapter.base.AbsRecyclerViewAdapter;
import com.hotbitmapgg.ohmybilibili.module.video.VideoDetailsActivity;
import com.hotbitmapgg.ohmybilibili.api.UserInfoApi;
import com.hotbitmapgg.ohmybilibili.base.RxAppCompatBaseActivity;
import com.hotbitmapgg.ohmybilibili.model.base.BasicMessage;
import com.hotbitmapgg.ohmybilibili.model.user.UserInfo;
import com.hotbitmapgg.ohmybilibili.model.user.UserVideoItem;
import com.hotbitmapgg.ohmybilibili.model.user.UserVideoList;
import com.hotbitmapgg.ohmybilibili.network.ApiHelper;
import com.hotbitmapgg.ohmybilibili.network.UrlHelper;
import com.hotbitmapgg.ohmybilibili.utils.LogUtil;
import com.hotbitmapgg.ohmybilibili.widget.CircleImageView;
import com.hotbitmapgg.ohmybilibili.widget.CircleProgressView;
import com.squareup.picasso.Picasso;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import butterknife.Bind;
import okhttp3.Call;
import rx.Single;
import rx.SingleSubscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * 用户个人中心界面
 *
 * @HotBitmapGG
 */
public class UserInfoActivity extends RxAppCompatBaseActivity implements View.OnClickListener
{

    @Bind(R.id.user_avatar_view)
    CircleImageView mAvatarImage;

    @Bind(R.id.user_name)
    TextView mUserNameText;

    @Bind(R.id.user_desc)
    TextView mDescriptionText;

    @Bind(R.id.tv_follow_users)
    TextView mFollowNumText;

    @Bind(R.id.tv_fans)
    TextView mFansNumText;

    @Bind(R.id.user_video_list)
    RecyclerView mRecyclerView;

    @Bind(R.id.collapsing_toolbar)
    CollapsingToolbarLayout mCollapsingToolbarLayout;

    @Bind(R.id.circle_progress)
    CircleProgressView mCircleProgressView;

    @Bind(R.id.tv_up_contributor)
    TextView mUpTip;

    @Bind(R.id.user_lv)
    ImageView mUserLv;

    @Bind(R.id.user_sex)
    ImageView mUserSex;

    @Bind(R.id.author_verified_layout)
    LinearLayout mAuthorVerifiedLayout;

    @Bind(R.id.author_verified_text)
    TextView mAuthorVerifiedText;

    @Bind(R.id.toolbar)
    Toolbar mToolbar;


    @Bind(R.id.btn_go_more)
    TextView mMoreTextView;

    @Bind(R.id.number_bar)
    LinearLayout mNumberBar;

    private String name = "";

    private int mid;

    private String avatar_url;

    private UserInfo userInfo;

    private ArrayList<Integer> uids = new ArrayList<Integer>();

    private List<UserVideoItem> userVideoList = new ArrayList<>();

    private UserUpVideoAdapter mPartListAdapter;

    private static final String EXTRA_USER_NAME = "extra_user_name", EXTRA_MID = "extra_mid", EXTRA_AVATAR_URL = "extra_avatar_url";


    @Override
    public int getLayoutId()
    {

        return R.layout.activity_user_info;
    }

    @Override
    public void initViews(Bundle savedInstanceState)
    {

        Intent intent = getIntent();
        if (intent != null)
        {
            name = intent.getStringExtra(EXTRA_USER_NAME);
            mid = intent.getIntExtra(EXTRA_MID, -1);
            avatar_url = intent.getStringExtra(EXTRA_AVATAR_URL);
        }

        if (name != null)
        {
            mUserNameText.setText(name);
        }
        if (avatar_url != null)
        {
            Picasso.with(this).load(avatar_url).placeholder(R.drawable.ico_user_default).into(mAvatarImage);
        }


        mMoreTextView.setOnClickListener(this);
        mFollowNumText.setOnClickListener(this);
        mFansNumText.setOnClickListener(this);

        startGetUserBasicInfo();
    }

    @Override
    public void initToolBar()
    {

        mCollapsingToolbarLayout.setTitle(name);
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

    private void startGetUserBasicInfo()
    {

        mCircleProgressView.setVisibility(View.VISIBLE);
        mCircleProgressView.spin();

        getUserInfo();
    }


    public void finishBasicInfoGetTask()
    {

        mNumberBar.setVisibility(View.VISIBLE);

        mUserNameText.setText(userInfo.name);
        mFollowNumText.setText(String.format(getString(R.string.info_following_format), userInfo.attention));
        mFansNumText.setText(String.format(getString(R.string.info_fans_format), userInfo.fans));

        mToolbar.setTitle("");

        Picasso.with(this).load(UrlHelper.getFaceUrl(userInfo)).placeholder(R.drawable.ico_user_default).into(mAvatarImage);
        setUserLevel(userInfo.rank);
        if (userInfo.sex.equals("男"))
        {
            mUserSex.setImageResource(R.drawable.ic_user_male_border);
        } else
        {
            mUserSex.setImageResource(R.drawable.ic_user_female_border);
        }
        if (userInfo.approve)
        {
            //认证用户 显示认证资料
            mAuthorVerifiedLayout.setVisibility(View.VISIBLE);
            mDescriptionText.setVisibility(View.GONE);
            if (!TextUtils.isEmpty(userInfo.description))
            {
                mAuthorVerifiedText.setText(userInfo.description);
            } else
            {
                mAuthorVerifiedText.setText("这个家伙太懒,什么都没有填写");
            }
        } else
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

        if (rank == 0)
        {
            mUserLv.setImageResource(R.drawable.ic_lv0);
        } else if (rank == 1)
        {
            mUserLv.setImageResource(R.drawable.ic_lv1);
        } else if (rank == 200)
        {
            mUserLv.setImageResource(R.drawable.ic_lv2);
        } else if (rank == 1500)
        {
            mUserLv.setImageResource(R.drawable.ic_lv3);
        } else if (rank == 3000)
        {
            mUserLv.setImageResource(R.drawable.ic_lv4);
        } else if (rank == 7000)
        {
            mUserLv.setImageResource(R.drawable.ic_lv5);
        } else if (rank == 10000)
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
        OkHttpUtils.get().url(url).build().execute(new StringCallback()
        {

            @Override
            public void onError(Call call, Exception e)
            {

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
        });
    }


    private void finishUserVideoListGetTask(int results)
    {

        mRecyclerView.setHasFixedSize(false);
        mRecyclerView.setNestedScrollingEnabled(false);
        mRecyclerView.setLayoutManager(new GridLayoutManager(UserInfoActivity.this, 2));
        mPartListAdapter = new UserUpVideoAdapter(mRecyclerView, userVideoList);
        mRecyclerView.setAdapter(mPartListAdapter);
        mPartListAdapter.setOnItemClickListener(new AbsRecyclerViewAdapter.OnItemClickListener()
        {

            @Override
            public void onItemClick(int position, AbsRecyclerViewAdapter.ClickableViewHolder holder)
            {

                UserVideoItem videoItem = userVideoList.get(position);
                int aid = videoItem.aid;
                VideoDetailsActivity.launch(UserInfoActivity.this, aid);
            }
        });

        mUpTip.setVisibility(View.VISIBLE);
        mUpTip.setText("Up主的投稿" + " " + "(" + results + ")");
        mRecyclerView.setVisibility(View.VISIBLE);
        mCircleProgressView.setVisibility(View.GONE);
        mCircleProgressView.stopSpinning();
        mMoreTextView.setVisibility(View.VISIBLE);
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

    @Override
    public void onClick(View v)
    {

        switch (v.getId())
        {
            case R.id.btn_go_more:
                //查看Up主所有视频
                UpMoreCoverActivity.launch(UserInfoActivity.this, userInfo.name, userInfo.mid);
                break;

            case R.id.tv_follow_users:
                //关注的人
                UserAttentionActivity.launch(UserInfoActivity.this, new ArrayList<>(userInfo.attentions), name);
                break;

            case R.id.tv_fans:
                //查看粉丝
                UserFansActivity.launch(UserInfoActivity.this, mid + "", name);
                break;
        }
    }

    public void getUserInfo()
    {

        Single<BasicMessage<UserInfo>> single = Single.fromCallable(new Callable<BasicMessage<UserInfo>>()
        {

            @Override
            public BasicMessage<UserInfo> call() throws Exception
            {

                return UserInfoApi.getUserInfoByName(name);
            }
        });

        Subscription subscribe = single.map(new Func1<BasicMessage<UserInfo>,UserInfo>()
        {

            @Override
            public UserInfo call(BasicMessage<UserInfo> userInfoBasicMessage)
            {

                return userInfoBasicMessage.getObject();
            }
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleSubscriber<UserInfo>()
                {

                    @Override
                    public void onSuccess(UserInfo value)
                    {

                        userInfo = value;
                        finishBasicInfoGetTask();
                    }

                    @Override
                    public void onError(Throwable error)
                    {

                        LogUtil.lsw("用户数据加载失败");
                    }
                });

        compositeSubscription.add(subscribe);
    }
}
