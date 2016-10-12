package com.hotbitmapgg.ohmybilibili.module.user;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.flyco.tablayout.SlidingTabLayout;
import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.base.RxAppCompatBaseActivity;
import com.hotbitmapgg.ohmybilibili.entity.user.UserDetailsInfo;
import com.hotbitmapgg.ohmybilibili.event.AppBarStateChangeEvent;
import com.hotbitmapgg.ohmybilibili.network.RetrofitHelper;
import com.hotbitmapgg.ohmybilibili.utils.NumberUtil;
import com.hotbitmapgg.ohmybilibili.utils.SystemBarHelper;
import com.hotbitmapgg.ohmybilibili.utils.ToastUtil;
import com.hotbitmapgg.ohmybilibili.widget.CircleImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by hcc on 16/8/4 21:18
 * 100332338@qq.com
 * <p/>
 * 用户个人中心界面
 */
public class UserInfoDetailsActivity extends RxAppCompatBaseActivity
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

    @Bind(R.id.collapsing_toolbar)
    CollapsingToolbarLayout mCollapsingToolbarLayout;

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

    @Bind(R.id.sliding_tabs)
    SlidingTabLayout mSlidingTabLayout;

    @Bind(R.id.view_pager)
    ViewPager mViewPager;

    @Bind(R.id.app_bar_layout)
    AppBarLayout mAppBarLayout;

    @Bind(R.id.line)
    View mLineView;

    private String name = "";

    private int mid;

    private String avatar_url;

    private UserDetailsInfo mUserDetailsInfo;

    private List<String> titles = new ArrayList<>();

    private List<Fragment> fragments = new ArrayList<>();

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
            mUserNameText.setText(name);

        if (avatar_url != null)
            Glide.with(UserInfoDetailsActivity.this)
                    .load(avatar_url)
                    .centerCrop()
                    .dontAnimate()
                    .placeholder(R.drawable.ico_user_default)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(mAvatarImage);

        //获取用户详情
        getUserInfo();
    }


    @Override
    public void initToolBar()
    {

        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null)
            supportActionBar.setDisplayHomeAsUpEnabled(true);


        //设置StatusBar透明
        SystemBarHelper.immersiveStatusBar(this);
        SystemBarHelper.setHeightAndPadding(this, mToolbar);

        //设置AppBar展开折叠状态监听
        mAppBarLayout.addOnOffsetChangedListener(new AppBarStateChangeEvent()
        {


            @Override
            public void onStateChanged(AppBarLayout appBarLayout, State state, int verticalOffset)
            {

                if (state == State.EXPANDED)
                {
                    //展开状态
                    mCollapsingToolbarLayout.setTitle("");
                    mLineView.setVisibility(View.VISIBLE);
                } else if (state == State.COLLAPSED)
                {
                    //折叠状态
                    mCollapsingToolbarLayout.setTitle(name);
                    mLineView.setVisibility(View.GONE);
                } else
                {
                    mCollapsingToolbarLayout.setTitle("");
                    mLineView.setVisibility(View.VISIBLE);
                }
            }
        });
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {

        if (item.getItemId() == android.R.id.home)
            onBackPressed();
        return super.onOptionsItemSelected(item);
    }

    public void getUserInfo()
    {

        RetrofitHelper.getUserInfoDetailsApi()
                .getUserInfoById(mid)
                .compose(this.bindToLifecycle())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(userInfo -> {

                    mUserDetailsInfo = userInfo;
                    finishTask();
                }, throwable -> {
                    ToastUtil.ShortToast("用户详情加载失败啦~");
                });
    }


    public void finishTask()
    {
        //设置用户头像
        Glide.with(UserInfoDetailsActivity.this)
                .load(mUserDetailsInfo.getCard().getFace())
                .centerCrop()
                .dontAnimate()
                .placeholder(R.drawable.ico_user_default)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(mAvatarImage);

        //设置粉丝和关注
        mUserNameText.setText(mUserDetailsInfo.getCard().getName());
        mFollowNumText.setText(String.valueOf(mUserDetailsInfo.getCard().getAttention()));
        mFansNumText.setText(NumberUtil.converString(mUserDetailsInfo.getCard().getFans()));

        //设置用户等级
        setUserLevel(Integer.valueOf(mUserDetailsInfo.getCard().getRank()));

        //设置用户性别
        switch (mUserDetailsInfo.getCard().getSex())
        {
            case "男":
                mUserSex.setImageResource(R.drawable.ic_user_male);
                break;
            case "女":
                mUserSex.setImageResource(R.drawable.ic_user_female);
                break;
            default:
                mUserSex.setImageResource(R.drawable.ic_user_gay_border);
                break;
        }

        //设置认证用户信息
        if (mUserDetailsInfo.getCard().isApprove())
        {
            //认证用户 显示认证资料
            mAuthorVerifiedLayout.setVisibility(View.VISIBLE);
            mDescriptionText.setVisibility(View.GONE);
            if (!TextUtils.isEmpty(mUserDetailsInfo.getCard().getDescription()))
            {
                mAuthorVerifiedText.setText(mUserDetailsInfo.getCard().getDescription());
            } else
            {
                mAuthorVerifiedText.setText("这个人懒死了,什么都没有写(・－・。)");
            }
        } else
        {
            //普通用户
            mAuthorVerifiedLayout.setVisibility(View.GONE);
            mDescriptionText.setVisibility(View.VISIBLE);
            if (!TextUtils.isEmpty(mUserDetailsInfo.getCard().getSign()))
            {
                mDescriptionText.setText(mUserDetailsInfo.getCard().getSign());
            } else
            {
                mDescriptionText.setText("这个人懒死了,什么都没有写(・－・。)");
            }
        }

        //初始化Viewpager
        initViewPager();
    }

    private void initViewPager()
    {

        titles.add("主页");
        titles.add("投稿");
        titles.add("收藏");
        titles.add("追番");
        titles.add("兴趣圈");
        titles.add("投币");
        titles.add("游戏");

        UserHomePageFragment userHomePageFragment = UserHomePageFragment.newInstance(mid);
        UserContributeFragment userContributeFragment = UserContributeFragment.newInstance(mid);
        UserFavoritesFragment userFavoritesFragment = UserFavoritesFragment.newInstance(mid);
        UserChaseBangumiFragment userChaseBangumiFragment = UserChaseBangumiFragment.newInstance(mid);
        UserInterestQuanFragment userInterestQuanFragment = UserInterestQuanFragment.newInstance(mid);
        UserCoinsVideoFragment userCoinsVideoFragment = UserCoinsVideoFragment.newInstance(mid);
        UserPlayGameFragment userPlayGameFragment = UserPlayGameFragment.newInstance(mid);
        fragments.add(userHomePageFragment);
        fragments.add(userContributeFragment);
        fragments.add(userFavoritesFragment);
        fragments.add(userChaseBangumiFragment);
        fragments.add(userInterestQuanFragment);
        fragments.add(userCoinsVideoFragment);
        fragments.add(userPlayGameFragment);

        UserInfoDetailsPagerAdapter mAdapter = new UserInfoDetailsPagerAdapter(getSupportFragmentManager(), titles, fragments);
        mViewPager.setOffscreenPageLimit(fragments.size());
        mViewPager.setAdapter(mAdapter);
        mSlidingTabLayout.setViewPager(mViewPager);
        measureTabLayoutTextWidth(1);
        mViewPager.setCurrentItem(1);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener()
        {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels)
            {

            }

            @Override
            public void onPageSelected(int position)
            {

                measureTabLayoutTextWidth(position);
            }

            @Override
            public void onPageScrollStateChanged(int state)
            {

            }
        });
    }

    private void measureTabLayoutTextWidth(int position)
    {

        String title = titles.get(position);
        TextView titleView = mSlidingTabLayout.getTitleView(position);
        TextPaint paint = titleView.getPaint();
        float textWidth = paint.measureText(title);
        mSlidingTabLayout.setIndicatorWidth(textWidth / 3);
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

    public static void launch(Activity activity, String name, int mid, String avatar_url)
    {

        Intent intent = new Intent(activity, UserInfoDetailsActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra(EXTRA_USER_NAME, name);
        intent.putExtra(EXTRA_MID, mid);
        intent.putExtra(EXTRA_AVATAR_URL, avatar_url);
        activity.startActivity(intent);
    }


    private static class UserInfoDetailsPagerAdapter extends FragmentStatePagerAdapter
    {

        private List<String> titles;

        private List<Fragment> fragments;


        UserInfoDetailsPagerAdapter(
                FragmentManager fm,
                List<String> titles,
                List<Fragment> fragments)
        {

            super(fm);
            this.titles = titles;
            this.fragments = fragments;
        }

        @Override
        public Fragment getItem(int position)
        {

            return fragments.get(position);
        }

        @Override
        public int getCount()
        {

            return titles.size();
        }

        @Override
        public CharSequence getPageTitle(int position)
        {

            return titles.get(position);
        }
    }
}
