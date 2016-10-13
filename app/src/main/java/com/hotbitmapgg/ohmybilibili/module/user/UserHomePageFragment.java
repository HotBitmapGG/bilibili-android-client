package com.hotbitmapgg.ohmybilibili.module.user;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.adapter.UserHomePagerChaseBangumiAdapter;
import com.hotbitmapgg.ohmybilibili.adapter.UserHomePagerCoinsAdapter;
import com.hotbitmapgg.ohmybilibili.adapter.UserHomePagerContributeAdapter;
import com.hotbitmapgg.ohmybilibili.adapter.UserHomePagerInterestQuanAdapter;
import com.hotbitmapgg.ohmybilibili.adapter.UserHomePagerPlayGameAdapter;
import com.hotbitmapgg.ohmybilibili.base.RxLazyFragment;
import com.hotbitmapgg.ohmybilibili.entity.user.UserChaseBangumiInfo;
import com.hotbitmapgg.ohmybilibili.entity.user.UserCoinsInfo;
import com.hotbitmapgg.ohmybilibili.entity.user.UserContributeInfo;
import com.hotbitmapgg.ohmybilibili.entity.user.UserFavoritesInfo;
import com.hotbitmapgg.ohmybilibili.entity.user.UserInterestQuanInfo;
import com.hotbitmapgg.ohmybilibili.entity.user.UserPlayGameInfo;
import com.hotbitmapgg.ohmybilibili.utils.ConstantUtils;
import com.hotbitmapgg.ohmybilibili.widget.FavoritesItemLayout;

import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by hcc on 2016/10/12 13:29
 * 100332338@qq.com
 * <p>
 * 用户详情界面的主页
 */

public class UserHomePageFragment extends RxLazyFragment
{

    @Bind(R.id.contribute_count)
    TextView mContributeCount;

    @Bind(R.id.contribute_recycler)
    RecyclerView mContributeRecycler;

    @Bind(R.id.coins_count)
    TextView mCoinsCount;

    @Bind(R.id.coins_recycler)
    RecyclerView mCoinsRecycler;

    @Bind(R.id.favorites_count)
    TextView mFavoritesCount;

    @Bind(R.id.favorites_layout)
    FavoritesItemLayout mFavoritesLayout;

    @Bind(R.id.chase_bangumi_count)
    TextView mChaseBangumiCount;

    @Bind(R.id.chase_bangumi_recycler)
    RecyclerView mChaseBangumiRecycler;

    @Bind(R.id.quanzi_count)
    TextView mQuanziCount;

    @Bind(R.id.quanzi_recycler)
    RecyclerView mQuanziRecycler;

    @Bind(R.id.play_game_count)
    TextView mPlayGameCount;

    @Bind(R.id.player_game_recycler)
    RecyclerView mPlayerGameRecycler;

    @Bind(R.id.contribute_layout)
    RelativeLayout contributeLayout;

    @Bind(R.id.coins_layout)
    RelativeLayout coinsLayout;

    @Bind(R.id.favorites_head_layout)
    RelativeLayout favoritesHeadLayout;

    @Bind(R.id.chase_bangumi_layout)
    RelativeLayout chaseBangumiLayout;

    @Bind(R.id.quanzi_layout)
    RelativeLayout quanziLayout;

    @Bind(R.id.play_game_layout)
    RelativeLayout playGameLayout;

    private UserContributeInfo mUserContributeInfo;

    private UserFavoritesInfo mUserFavoritesInfo;

    private UserChaseBangumiInfo mUserChaseBangumiInfo;

    private UserInterestQuanInfo mUserInterestQuanInfo;

    private UserCoinsInfo mUserCoinsInfo;

    private UserPlayGameInfo mUserPlayGameInfo;

    public static UserHomePageFragment newInstance(UserContributeInfo userContributeInfo, UserFavoritesInfo userFavoritesInfo,
                                                   UserChaseBangumiInfo userChaseBangumiInfo, UserInterestQuanInfo userInterestQuanInfo,
                                                   UserCoinsInfo userCoinsInfo, UserPlayGameInfo userPlayGameInfo)
    {

        UserHomePageFragment mFragment = new UserHomePageFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(ConstantUtils.USER_CONTRIBUTE, userContributeInfo);
        bundle.putParcelable(ConstantUtils.USER_FAVORITES, userFavoritesInfo);
        bundle.putParcelable(ConstantUtils.USER_CHASE_BANGUMI, userChaseBangumiInfo);
        bundle.putParcelable(ConstantUtils.USER_INTEREST_QUAN, userInterestQuanInfo);
        bundle.putParcelable(ConstantUtils.USER_COINS, userCoinsInfo);
        bundle.putParcelable(ConstantUtils.USER_PLAY_GAME, userPlayGameInfo);
        mFragment.setArguments(bundle);
        return mFragment;
    }

    @Override
    public int getLayoutResId()
    {

        return R.layout.fragment_user_home_page;
    }

    @Override
    public void finishCreateView(Bundle state)
    {

        mUserContributeInfo = getArguments().getParcelable(ConstantUtils.USER_CONTRIBUTE);
        mUserFavoritesInfo = getArguments().getParcelable(ConstantUtils.USER_FAVORITES);
        mUserChaseBangumiInfo = getArguments().getParcelable(ConstantUtils.USER_CHASE_BANGUMI);
        mUserInterestQuanInfo = getArguments().getParcelable(ConstantUtils.USER_INTEREST_QUAN);
        mUserCoinsInfo = getArguments().getParcelable(ConstantUtils.USER_COINS);
        mUserPlayGameInfo = getArguments().getParcelable(ConstantUtils.USER_PLAY_GAME);

        setContribute();
        setCoins();
        setFavorites();
        setChaseBangumi();
        setQuanzi();
        setPlayGame();
    }

    private void setPlayGame()
    {

        int count = mUserPlayGameInfo.getData().getCount();
        if (count == 0)
            playGameLayout.setVisibility(View.GONE);

        List<UserPlayGameInfo.DataBean.GamesBean> games = mUserPlayGameInfo.getData().getGames();
        mPlayerGameRecycler.setHasFixedSize(false);
        mPlayerGameRecycler.setNestedScrollingEnabled(false);
        mPlayerGameRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        mPlayerGameRecycler.setAdapter(new UserHomePagerPlayGameAdapter(mPlayerGameRecycler, games));
        mPlayGameCount.setText(String.valueOf(count));
    }

    private void setQuanzi()
    {

        int total_count = mUserInterestQuanInfo.getData().getTotal_count();
        if (total_count == 0)
            quanziLayout.setVisibility(View.GONE);

        List<UserInterestQuanInfo.DataBean.ResultBean> result = mUserInterestQuanInfo.getData().getResult();
        mQuanziRecycler.setHasFixedSize(false);
        mQuanziRecycler.setNestedScrollingEnabled(false);
        mQuanziRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        mQuanziRecycler.setAdapter(new UserHomePagerInterestQuanAdapter(mQuanziRecycler, result));
        mQuanziCount.setText(String.valueOf(total_count));
    }

    private void setChaseBangumi()
    {

        int count = mUserChaseBangumiInfo.getData().getCount();
        if (count == 0)
            chaseBangumiLayout.setVisibility(View.GONE);

        List<UserChaseBangumiInfo.DataBean.ResultBean> result = mUserChaseBangumiInfo.getData().getResult();
        mChaseBangumiRecycler.setHasFixedSize(false);
        mChaseBangumiRecycler.setNestedScrollingEnabled(false);
        mChaseBangumiRecycler.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        mChaseBangumiRecycler.setAdapter(new UserHomePagerChaseBangumiAdapter(mChaseBangumiRecycler, result));
        mChaseBangumiCount.setText(String.valueOf(count));
    }

    private void setFavorites()
    {

        int size = mUserFavoritesInfo.getData().size();
        if (size == 0)
            favoritesHeadLayout.setVisibility(View.GONE);

        List<UserFavoritesInfo.DataBean> data = mUserFavoritesInfo.getData();
        List<UserFavoritesInfo.DataBean.VideosBean> videos = data.get(0).getVideos();
        mFavoritesLayout.setImages(videos);
        mFavoritesCount.setText(String.valueOf(size));
    }

    private void setCoins()
    {

        int count = mUserCoinsInfo.getData().getCount();
        if (count == 0)
            coinsLayout.setVisibility(View.GONE);

        List<UserCoinsInfo.DataBean.ListBean> list = mUserCoinsInfo.getData().getList();
        mCoinsRecycler.setHasFixedSize(false);
        mCoinsRecycler.setNestedScrollingEnabled(false);
        mCoinsRecycler.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        mCoinsRecycler.setAdapter(new UserHomePagerCoinsAdapter(mCoinsRecycler, list));
        mCoinsCount.setText(String.valueOf(count));
    }

    private void setContribute()
    {

        int count = mUserContributeInfo.getData().getCount();
        if (count == 0)
            contributeLayout.setVisibility(View.GONE);

        List<UserContributeInfo.DataBean.VlistBean> vlist = mUserContributeInfo.getData().getVlist();
        mContributeRecycler.setHasFixedSize(false);
        mContributeRecycler.setNestedScrollingEnabled(false);
        mContributeRecycler.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        mContributeRecycler.setAdapter(new UserHomePagerContributeAdapter(mContributeRecycler, vlist));
        mContributeCount.setText(String.valueOf(count));
    }


    @OnClick(R.id.contribute_more)
    void gotoContributePager()
    {

        ((UserInfoDetailsActivity) getActivity()).switchPager(1);
    }

    @OnClick(R.id.coins_more)
    void gotoCoinsPager()
    {

        ((UserInfoDetailsActivity) getActivity()).switchPager(5);
    }

    @OnClick(R.id.favorites_more)
    void gotoFavoritesPager()
    {

        ((UserInfoDetailsActivity) getActivity()).switchPager(2);
    }

    @OnClick(R.id.chase_bangumi_more)
    void gotoChaseBangumiPager()
    {

        ((UserInfoDetailsActivity) getActivity()).switchPager(3);
    }

    @OnClick(R.id.quanzi_more)
    void gotoQuanziPager()
    {

        ((UserInfoDetailsActivity) getActivity()).switchPager(4);
    }

    @OnClick(R.id.play_game_more)
    void gotoPlayGamePager()
    {

        ((UserInfoDetailsActivity) getActivity()).switchPager(6);
    }
}
