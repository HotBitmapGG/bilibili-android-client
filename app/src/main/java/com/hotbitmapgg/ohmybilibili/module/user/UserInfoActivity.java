package com.hotbitmapgg.ohmybilibili.module.user;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.adapter.UserUpVideoAdapter;
import com.hotbitmapgg.ohmybilibili.adapter.helper.AbsRecyclerViewAdapter;
import com.hotbitmapgg.ohmybilibili.base.RxAppCompatBaseActivity;
import com.hotbitmapgg.ohmybilibili.entity.user.UserInfo;
import com.hotbitmapgg.ohmybilibili.entity.user.UserUpVideoInfo;
import com.hotbitmapgg.ohmybilibili.module.video.VideoDetailsActivity;
import com.hotbitmapgg.ohmybilibili.network.RetrofitHelper;
import com.hotbitmapgg.ohmybilibili.network.auxiliary.UrlHelper;
import com.hotbitmapgg.ohmybilibili.widget.CircleImageView;
import com.hotbitmapgg.ohmybilibili.widget.CircleProgressView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by hcc on 16/8/4 21:18
 * 100332338@qq.com
 * <p/>
 * 用户个人中心界面
 */
public class UserInfoActivity extends RxAppCompatBaseActivity
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

    @Bind(R.id.recycle)
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

    private UserInfo mUserInfo;

    private List<UserUpVideoInfo.VlistBean> userVideoList = new ArrayList<>();

    private static final String EXTRA_USER_NAME = "extra_user_name",
            EXTRA_MID = "extra_mid", EXTRA_AVATAR_URL = "extra_avatar_url";


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
            Glide.with(UserInfoActivity.this)
                    .load(avatar_url)
                    .centerCrop()
                    .dontAnimate()
                    .placeholder(R.drawable.ico_user_default)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(mAvatarImage);
        }

        startGetUserInfoTask();
    }


    @Override
    public void initToolBar()
    {

        mCollapsingToolbarLayout.setTitle(name);
        setSupportActionBar(mToolbar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null)
            supportActionBar.setDisplayHomeAsUpEnabled(true);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {

        if (item.getItemId() == android.R.id.home)
            onBackPressed();
        return super.onOptionsItemSelected(item);
    }

    private void startGetUserInfoTask()
    {


        showProgressBar();
        getUserInfo();
    }


    public void getUserInfo()
    {

        RetrofitHelper.getUserInfoApi()
                .getUserInfoByName(name)
                .compose(this.<UserInfo> bindToLifecycle())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<UserInfo>()
                {

                    @Override
                    public void call(UserInfo userInfo)
                    {

                        mUserInfo = userInfo;
                        finishUserInfoTask();
                    }
                }, new Action1<Throwable>()
                {

                    @Override
                    public void call(Throwable throwable)
                    {

                        hideProgressBar();
                    }
                });
    }


    public void finishUserInfoTask()
    {

        mNumberBar.setVisibility(View.VISIBLE);
        mUserNameText.setText(mUserInfo.name);
        mFollowNumText.setText(String.format(getString(R.string.info_following_format), mUserInfo.attention));
        mFansNumText.setText(String.format(getString(R.string.info_fans_format), mUserInfo.fans));
        mToolbar.setTitle("");

        Glide.with(UserInfoActivity.this)
                .load(UrlHelper.getFaceUrl(mUserInfo))
                .centerCrop()
                .dontAnimate()
                .placeholder(R.drawable.ico_user_default)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(mAvatarImage);


        setUserLevel(mUserInfo.rank);
        if (mUserInfo.sex.equals("男"))
        {
            mUserSex.setImageResource(R.drawable.ic_user_male_border);
        } else
        {
            mUserSex.setImageResource(R.drawable.ic_user_female_border);
        }
        if (mUserInfo.approve)
        {
            //认证用户 显示认证资料
            mAuthorVerifiedLayout.setVisibility(View.VISIBLE);
            mDescriptionText.setVisibility(View.GONE);
            if (!TextUtils.isEmpty(mUserInfo.description))
            {
                mAuthorVerifiedText.setText(mUserInfo.description);
            } else
            {
                mAuthorVerifiedText.setText("这个家伙太懒,什么都没有填写");
            }
        } else
        {
            //普通用户
            mAuthorVerifiedLayout.setVisibility(View.GONE);
            mDescriptionText.setVisibility(View.VISIBLE);
            if (!TextUtils.isEmpty(mUserInfo.sign))
            {
                mDescriptionText.setText(mUserInfo.sign);
            } else
            {
                mDescriptionText.setText("这个家伙太懒,什么都没有填写");
            }
        }

        getUserVideoList();
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


    private void getUserVideoList()
    {


        RetrofitHelper.getUserUpVideoListApi()
                .getUserUpVideos(mid, 1, 10)
                .compose(this.<UserUpVideoInfo> bindToLifecycle())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<UserUpVideoInfo>()
                {

                    @Override
                    public void call(UserUpVideoInfo userUpVideoInfo)
                    {

                        List<UserUpVideoInfo.VlistBean> vlist = userUpVideoInfo.getVlist();
                        userVideoList.addAll(vlist);
                        finishTask();
                    }
                }, new Action1<Throwable>()
                {

                    @Override
                    public void call(Throwable throwable)
                    {

                        hideProgressBar();
                    }
                });
    }


    private void finishTask()
    {

        mRecyclerView.setHasFixedSize(false);
        mRecyclerView.setNestedScrollingEnabled(false);
        mRecyclerView.setLayoutManager(new GridLayoutManager(UserInfoActivity.this, 2));
        UserUpVideoAdapter mAdapter = new UserUpVideoAdapter(mRecyclerView, userVideoList);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new AbsRecyclerViewAdapter.OnItemClickListener()
        {

            @Override
            public void onItemClick(int position, AbsRecyclerViewAdapter.ClickableViewHolder holder)
            {

                VideoDetailsActivity.launch(UserInfoActivity.this,
                        userVideoList.get(position).getAid(),
                        userVideoList.get(position).getPic());
            }
        });

        mUpTip.setVisibility(View.VISIBLE);
        String str = "Up主的投稿" + "(" +
                String.valueOf(mUserInfo.article) + ")";
        mUpTip.setText(str);
        mRecyclerView.setVisibility(View.VISIBLE);
        mMoreTextView.setVisibility(View.VISIBLE);
        hideProgressBar();
    }


    @OnClick(R.id.btn_go_more)
    void startUpAllVideos()
    {
        //查看Up主所有视频
        UserUpMoreCoverActivity.launch(UserInfoActivity.this, mUserInfo.name, mUserInfo.mid);
    }

    @OnClick(R.id.tv_fans)
    void startUpFans()
    {
        //查看Up主的粉丝
        UserFansActivity.launch(UserInfoActivity.this, String.valueOf(mid), name);
    }


    public void showProgressBar()
    {

        mCircleProgressView.setVisibility(View.VISIBLE);
        mCircleProgressView.spin();
    }

    public void hideProgressBar()
    {

        mCircleProgressView.setVisibility(View.GONE);
        mCircleProgressView.stopSpinning();
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
}
