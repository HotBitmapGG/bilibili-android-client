package com.hotbitmapgg.bilibili.module.user;

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
import com.hotbitmapgg.bilibili.base.RxBaseActivity;
import com.hotbitmapgg.bilibili.entity.user.UserCoinsInfo;
import com.hotbitmapgg.bilibili.entity.user.UserContributeInfo;
import com.hotbitmapgg.bilibili.entity.user.UserDetailsInfo;
import com.hotbitmapgg.bilibili.entity.user.UserInterestQuanInfo;
import com.hotbitmapgg.bilibili.entity.user.UserLiveRoomStatusInfo;
import com.hotbitmapgg.bilibili.entity.user.UserPlayGameInfo;
import com.hotbitmapgg.bilibili.event.AppBarStateChangeEvent;
import com.hotbitmapgg.bilibili.network.RetrofitHelper;
import com.hotbitmapgg.bilibili.utils.LogUtil;
import com.hotbitmapgg.bilibili.utils.NumberUtil;
import com.hotbitmapgg.bilibili.utils.SystemBarHelper;
import com.hotbitmapgg.bilibili.utils.ToastUtil;
import com.hotbitmapgg.bilibili.widget.CircleImageView;
import com.hotbitmapgg.bilibili.widget.CircleProgressView;
import com.hotbitmapgg.bilibili.widget.NoScrollViewPager;
import com.hotbitmapgg.ohmybilibili.R;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by hcc on 16/8/4 21:18
 * 100332338@qq.com
 * <p/>
 * 用户个人中心界面
 */
public class UserInfoDetailsActivity extends RxBaseActivity {
    @BindView(R.id.user_avatar_view)
    CircleImageView mAvatarImage;
    @BindView(R.id.user_name)
    TextView mUserNameText;
    @BindView(R.id.user_desc)
    TextView mDescriptionText;
    @BindView(R.id.tv_follow_users)
    TextView mFollowNumText;
    @BindView(R.id.tv_fans)
    TextView mFansNumText;
    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout mCollapsingToolbarLayout;
    @BindView(R.id.user_lv)
    ImageView mUserLv;
    @BindView(R.id.user_sex)
    ImageView mUserSex;
    @BindView(R.id.author_verified_layout)
    LinearLayout mAuthorVerifiedLayout;
    @BindView(R.id.author_verified_text)
    TextView mAuthorVerifiedText;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.sliding_tabs)
    SlidingTabLayout mSlidingTabLayout;
    @BindView(R.id.view_pager)
    NoScrollViewPager mViewPager;
    @BindView(R.id.app_bar_layout)
    AppBarLayout mAppBarLayout;
    @BindView(R.id.line)
    View mLineView;
    @BindView(R.id.circle_progress)
    CircleProgressView mCircleProgressView;

    private int mid;
    private String name = "";
    private String avatar_url;
    private int userContributeCount;
    private int userInterestQuanCount;
    private int userCoinsCount;
    private int userPlayGameCount;
    private UserDetailsInfo mUserDetailsInfo;
    private UserCoinsInfo mUserCoinsInfo;
    private UserPlayGameInfo mUserPlayGameInfo;
    private UserContributeInfo mUserContributeInfo;
    private UserInterestQuanInfo mUserInterestQuanInfo;
    private UserLiveRoomStatusInfo mUserLiveRoomStatusInfo;
    private List<String> titles = new ArrayList<>();
    private List<Fragment> fragments = new ArrayList<>();
    private List<UserCoinsInfo.DataBean.ListBean> userCoins = new ArrayList<>();
    private List<UserPlayGameInfo.DataBean.GamesBean> userPlayGames = new ArrayList<>();
    private List<UserContributeInfo.DataBean.VlistBean> userContributes = new ArrayList<>();
    private List<UserInterestQuanInfo.DataBean.ResultBean> userInterestQuans = new ArrayList<>();
    private static final String EXTRA_USER_NAME = "extra_user_name", EXTRA_MID = "extra_mid", EXTRA_AVATAR_URL = "extra_avatar_url";


    @Override
    public int getLayoutId() {
        return R.layout.activity_user_info;
    }


    @Override
    public void initViews(Bundle savedInstanceState) {
        Intent intent = getIntent();
        if (intent != null) {
            name = intent.getStringExtra(EXTRA_USER_NAME);
            mid = intent.getIntExtra(EXTRA_MID, -1);
            avatar_url = intent.getStringExtra(EXTRA_AVATAR_URL);
        }
        if (name != null) {
            mUserNameText.setText(name);
        }
        if (avatar_url != null) {
            Glide.with(UserInfoDetailsActivity.this)
                    .load(avatar_url)
                    .centerCrop()
                    .dontAnimate()
                    .placeholder(R.drawable.ico_user_default)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(mAvatarImage);
        }
        //获取用户详情
        getUserInfo();
        //隐藏ViewPager
        mViewPager.setVisibility(View.INVISIBLE);
    }

    @Override
    public void initToolBar() {
        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
        //设置StatusBar透明
        SystemBarHelper.immersiveStatusBar(this);
        SystemBarHelper.setHeightAndPadding(this, mToolbar);
        //设置AppBar展开折叠状态监听
        mAppBarLayout.addOnOffsetChangedListener(new AppBarStateChangeEvent() {
            @Override
            public void onStateChanged(AppBarLayout appBarLayout, State state, int verticalOffset) {
                if (state == State.EXPANDED) {
                    //展开状态
                    mCollapsingToolbarLayout.setTitle("");
                    mLineView.setVisibility(View.VISIBLE);
                } else if (state == State.COLLAPSED) {
                    //折叠状态
                    mCollapsingToolbarLayout.setTitle(name);
                    mLineView.setVisibility(View.GONE);
                } else {
                    mCollapsingToolbarLayout.setTitle("");
                    mLineView.setVisibility(View.VISIBLE);
                }
            }
        });
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }


    public void getUserInfo() {
        RetrofitHelper.getAccountAPI()
                .getUserInfoById(mid)
                .compose(this.bindToLifecycle())
                .doOnSubscribe(this::showProgressBar)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(userInfo -> {
                    mUserDetailsInfo = userInfo;
                    finishTask();
                }, throwable -> hideProgressBar());
    }


    public void finishTask() {
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
        switch (mUserDetailsInfo.getCard().getSex()) {
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
        //设置用户签名信息
        if (!TextUtils.isEmpty(mUserDetailsInfo.getCard().getSign())) {
            mDescriptionText.setText(mUserDetailsInfo.getCard().getSign());
        } else {
            mDescriptionText.setText("这个人懒死了,什么都没有写(・－・。)");
        }
        //设置认证用户信息
        if (mUserDetailsInfo.getCard().isApprove()) {
            //认证用户 显示认证资料
            mAuthorVerifiedLayout.setVisibility(View.VISIBLE);
            if (!TextUtils.isEmpty(mUserDetailsInfo.getCard().getDescription())) {
                mAuthorVerifiedText.setText(mUserDetailsInfo.getCard().getDescription());
            } else {
                mAuthorVerifiedText.setText("这个人懒死了,什么都没有写(・－・。)");
            }
        } else {
            //普通用户
            mAuthorVerifiedLayout.setVisibility(View.GONE);
        }
        //获取用户详情全部数据
        getUserAllData();
    }


    private void getUserAllData() {
        RetrofitHelper.getUserAPI()
                .getUserContributeVideos(mid, 1, 10)
                .compose(this.bindToLifecycle())
                .flatMap(new Func1<UserContributeInfo, Observable<UserInterestQuanInfo>>() {
                    @Override
                    public Observable<UserInterestQuanInfo> call(UserContributeInfo userContributeInfo) {
                        mUserContributeInfo = userContributeInfo;
                        userContributeCount = userContributeInfo.getData().getCount();
                        userContributes.addAll(userContributeInfo.getData().getVlist());
                        return RetrofitHelper.getIm9API().getUserInterestQuanData(mid, 1, 10);
                    }
                })
                .compose(bindToLifecycle())
                .flatMap(new Func1<UserInterestQuanInfo, Observable<UserCoinsInfo>>() {
                    @Override
                    public Observable<UserCoinsInfo> call(UserInterestQuanInfo userInterestQuanInfo) {
                        mUserInterestQuanInfo = userInterestQuanInfo;
                        userInterestQuanCount = userInterestQuanInfo.getData().getTotal_count();
                        userInterestQuans.addAll(userInterestQuanInfo.getData().getResult());
                        return RetrofitHelper.getUserAPI().getUserCoinVideos(mid);
                    }
                })
                .compose(bindToLifecycle())
                .flatMap(new Func1<UserCoinsInfo, Observable<UserPlayGameInfo>>() {
                    @Override
                    public Observable<UserPlayGameInfo> call(UserCoinsInfo userCoinsInfo) {
                        mUserCoinsInfo = userCoinsInfo;
                        userCoinsCount = userCoinsInfo.getData().getCount();
                        userCoins.addAll(userCoinsInfo.getData().getList());
                        return RetrofitHelper.getUserAPI().getUserPlayGames(mid);
                    }
                })
                .compose(bindToLifecycle())
                .flatMap(new Func1<UserPlayGameInfo, Observable<UserLiveRoomStatusInfo>>() {
                    @Override
                    public Observable<UserLiveRoomStatusInfo> call(UserPlayGameInfo userPlayGameInfo) {
                        mUserPlayGameInfo = userPlayGameInfo;
                        userPlayGameCount = userPlayGameInfo.getData().getCount();
                        userPlayGames.addAll(userPlayGameInfo.getData().getGames());
                        return RetrofitHelper.getLiveAPI().getUserLiveRoomStatus(mid);
                    }
                })
                .compose(bindToLifecycle())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(userLiveRoomStatusInfo -> {
                    mUserLiveRoomStatusInfo = userLiveRoomStatusInfo;
                    initViewPager();
                }, throwable -> {
                    ToastUtil.ShortToast("用户隐私未公开");
                    hideProgressBar();
                });
    }


    private void initViewPager() {
        fragments.add(UserHomePageFragment.newInstance(mUserContributeInfo,
                mUserInterestQuanInfo, mUserCoinsInfo, mUserPlayGameInfo, mUserLiveRoomStatusInfo));
        fragments.add(UserContributeFragment.newInstance(mid, mUserContributeInfo));
        fragments.add(UserInterestQuanFragment.newInstance(mid, mUserInterestQuanInfo));
        fragments.add(UserCoinsVideoFragment.newInstance(mUserCoinsInfo));
        fragments.add(UserPlayGameFragment.newInstance(mUserPlayGameInfo));
        UserInfoDetailsPagerAdapter mAdapter = new UserInfoDetailsPagerAdapter(getSupportFragmentManager(), fragments);
        mViewPager.setOffscreenPageLimit(fragments.size());
        mViewPager.setAdapter(mAdapter);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                measureTabLayoutTextWidth(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        Observable.timer(2000, TimeUnit.MILLISECONDS)
                .compose(bindToLifecycle())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(aLong -> setPagerTitles(), throwable -> LogUtil.all(throwable.getMessage()));
    }


    private void setPagerTitles() {
        titles.add("主页");
        titles.add("投稿 " + userContributeCount);
        titles.add("兴趣圈 " + userInterestQuanCount);
        titles.add("投币 " + userCoinsCount);
        titles.add("游戏 " + userPlayGameCount);
        mSlidingTabLayout.setViewPager(mViewPager, titles.toArray(new String[titles.size()]));
        measureTabLayoutTextWidth(1);
        mViewPager.setCurrentItem(1);
        hideProgressBar();
        mViewPager.setVisibility(View.VISIBLE);
    }


    private void measureTabLayoutTextWidth(int position) {
        String title = titles.get(position);
        TextView titleView = mSlidingTabLayout.getTitleView(position);
        TextPaint paint = titleView.getPaint();
        float textWidth = paint.measureText(title);
        mSlidingTabLayout.setIndicatorWidth(textWidth / 3);
    }


    private void setUserLevel(int rank) {
        if (rank == 0) {
            mUserLv.setImageResource(R.drawable.ic_lv0);
        } else if (rank == 1) {
            mUserLv.setImageResource(R.drawable.ic_lv1);
        } else if (rank == 200) {
            mUserLv.setImageResource(R.drawable.ic_lv2);
        } else if (rank == 1500) {
            mUserLv.setImageResource(R.drawable.ic_lv3);
        } else if (rank == 3000) {
            mUserLv.setImageResource(R.drawable.ic_lv4);
        } else if (rank == 7000) {
            mUserLv.setImageResource(R.drawable.ic_lv5);
        } else if (rank == 10000) {
            mUserLv.setImageResource(R.drawable.ic_lv6);
        }
    }


    @Override
    public void showProgressBar() {
        mCircleProgressView.setVisibility(View.VISIBLE);
        mCircleProgressView.spin();
    }


    @Override
    public void hideProgressBar() {
        mCircleProgressView.setVisibility(View.GONE);
        mCircleProgressView.stopSpinning();
    }


    public static void launch(Activity activity, String name, int mid, String avatar_url) {
        Intent intent = new Intent(activity, UserInfoDetailsActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra(EXTRA_USER_NAME, name);
        intent.putExtra(EXTRA_MID, mid);
        intent.putExtra(EXTRA_AVATAR_URL, avatar_url);
        activity.startActivity(intent);
    }


    /**
     * 根据下标切换页面
     */
    public void switchPager(int index) {
        switch (index) {
            case 1:
                mViewPager.setCurrentItem(1);
                break;
            case 2:
                mViewPager.setCurrentItem(2);
                break;
            case 3:
                mViewPager.setCurrentItem(3);
                break;
            case 4:
                mViewPager.setCurrentItem(4);
                break;
        }
    }


    private static class UserInfoDetailsPagerAdapter extends FragmentStatePagerAdapter {
        private List<Fragment> fragments;

        UserInfoDetailsPagerAdapter(FragmentManager fm, List<Fragment> fragments) {
            super(fm);
            this.fragments = fragments;
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
    }
}
