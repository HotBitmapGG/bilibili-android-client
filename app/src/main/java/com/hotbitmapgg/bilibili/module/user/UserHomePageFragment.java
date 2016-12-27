package com.hotbitmapgg.bilibili.module.user;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hotbitmapgg.bilibili.adapter.UserHomePagerChaseBangumiAdapter;
import com.hotbitmapgg.bilibili.adapter.UserHomePagerCoinsAdapter;
import com.hotbitmapgg.bilibili.adapter.UserHomePagerContributeAdapter;
import com.hotbitmapgg.bilibili.adapter.UserHomePagerInterestQuanAdapter;
import com.hotbitmapgg.bilibili.adapter.UserHomePagerPlayGameAdapter;
import com.hotbitmapgg.bilibili.base.RxLazyFragment;
import com.hotbitmapgg.bilibili.entity.user.UserChaseBangumiInfo;
import com.hotbitmapgg.bilibili.entity.user.UserCoinsInfo;
import com.hotbitmapgg.bilibili.entity.user.UserInterestQuanInfo;
import com.hotbitmapgg.bilibili.entity.user.UserPlayGameInfo;
import com.hotbitmapgg.bilibili.utils.ConstantUtil;
import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.bilibili.entity.user.UserContributeInfo;
import com.hotbitmapgg.bilibili.entity.user.UserFavoritesInfo;
import com.hotbitmapgg.bilibili.entity.user.UserLiveRoomStatusInfo;
import com.hotbitmapgg.bilibili.widget.FavoritesItemLayout;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by hcc on 2016/10/12 13:29
 * 100332338@qq.com
 * <p>
 * 用户详情界面的主页
 */

public class UserHomePageFragment extends RxLazyFragment {

  @BindView(R.id.contribute_count)
  TextView mContributeCount;

  @BindView(R.id.contribute_recycler)
  RecyclerView mContributeRecycler;

  @BindView(R.id.coins_count)
  TextView mCoinsCount;

  @BindView(R.id.coins_recycler)
  RecyclerView mCoinsRecycler;

  @BindView(R.id.favorites_count)
  TextView mFavoritesCount;

  @BindView(R.id.favorites_layout)
  FavoritesItemLayout mFavoritesLayout;

  @BindView(R.id.chase_bangumi_count)
  TextView mChaseBangumiCount;

  @BindView(R.id.chase_bangumi_recycler)
  RecyclerView mChaseBangumiRecycler;

  @BindView(R.id.quanzi_count)
  TextView mQuanziCount;

  @BindView(R.id.quanzi_recycler)
  RecyclerView mQuanziRecycler;

  @BindView(R.id.play_game_count)
  TextView mPlayGameCount;

  @BindView(R.id.player_game_recycler)
  RecyclerView mPlayerGameRecycler;

  @BindView(R.id.contribute_layout)
  RelativeLayout contributeLayout;

  @BindView(R.id.coins_layout)
  RelativeLayout coinsLayout;

  @BindView(R.id.favorites_head_layout)
  RelativeLayout favoritesHeadLayout;

  @BindView(R.id.chase_bangumi_layout)
  RelativeLayout chaseBangumiLayout;

  @BindView(R.id.quanzi_layout)
  RelativeLayout quanziLayout;

  @BindView(R.id.play_game_layout)
  RelativeLayout playGameLayout;

  @BindView(R.id.live_image)
  ImageView liveImage;

  @BindView(R.id.live_status_tv)
  TextView liveStatusTv;

  @BindView(R.id.card_view)
  CardView cardView;

  private UserContributeInfo mUserContributeInfo;

  private UserFavoritesInfo mUserFavoritesInfo;

  private UserChaseBangumiInfo mUserChaseBangumiInfo;

  private UserInterestQuanInfo mUserInterestQuanInfo;

  private UserCoinsInfo mUserCoinsInfo;

  private UserPlayGameInfo mUserPlayGameInfo;

  private UserLiveRoomStatusInfo mUserLiveRoomStatusInfo;


  public static UserHomePageFragment newInstance(
      UserContributeInfo userContributeInfo, UserFavoritesInfo userFavoritesInfo,
      UserChaseBangumiInfo userChaseBangumiInfo, UserInterestQuanInfo userInterestQuanInfo,
      UserCoinsInfo userCoinsInfo, UserPlayGameInfo userPlayGameInfo,
      UserLiveRoomStatusInfo userLiveRoomStatusInfo) {

    UserHomePageFragment mFragment = new UserHomePageFragment();
    Bundle bundle = new Bundle();
    bundle.putParcelable(ConstantUtil.USER_CONTRIBUTE, userContributeInfo);
    bundle.putParcelable(ConstantUtil.USER_FAVORITES, userFavoritesInfo);
    bundle.putParcelable(ConstantUtil.USER_CHASE_BANGUMI, userChaseBangumiInfo);
    bundle.putParcelable(ConstantUtil.USER_INTEREST_QUAN, userInterestQuanInfo);
    bundle.putParcelable(ConstantUtil.USER_COINS, userCoinsInfo);
    bundle.putParcelable(ConstantUtil.USER_PLAY_GAME, userPlayGameInfo);
    bundle.putParcelable(ConstantUtil.USER_LIVE_STATUS, userLiveRoomStatusInfo);
    mFragment.setArguments(bundle);
    return mFragment;
  }


  @Override
  public int getLayoutResId() {

    return R.layout.fragment_user_home_page;
  }


  @Override
  public void finishCreateView(Bundle state) {

    mUserContributeInfo = getArguments().getParcelable(ConstantUtil.USER_CONTRIBUTE);
    mUserFavoritesInfo = getArguments().getParcelable(ConstantUtil.USER_FAVORITES);
    mUserChaseBangumiInfo = getArguments().getParcelable(ConstantUtil.USER_CHASE_BANGUMI);
    mUserInterestQuanInfo = getArguments().getParcelable(ConstantUtil.USER_INTEREST_QUAN);
    mUserCoinsInfo = getArguments().getParcelable(ConstantUtil.USER_COINS);
    mUserPlayGameInfo = getArguments().getParcelable(ConstantUtil.USER_PLAY_GAME);
    mUserLiveRoomStatusInfo = getArguments().getParcelable(ConstantUtil.USER_LIVE_STATUS);

    setLive();
    setContribute();
    setCoins();
    setFavorites();
    setChaseBangumi();
    setQuanzi();
    setPlayGame();
  }


  @SuppressLint("SetTextI18n")
  private void setLive() {

    int roomStatus = mUserLiveRoomStatusInfo.getData().getRoomStatus();
    if (roomStatus == 0) {
      //用户没有直播
      liveImage.setImageResource(R.drawable.ic_live_line);
      liveImage.setImageTintList(
          ColorStateList.valueOf(getActivity().getResources().getColor(R.color.font_normal)));
      liveStatusTv.setText(R.string.live_message);
      liveStatusTv.setTextColor(getActivity().getResources().getColor(R.color.font_normal));
    } else {
      //用户正在直播
      liveImage.setImageResource(R.drawable.ic_live_fill);
      liveImage.setImageTintList(
          ColorStateList.valueOf(getActivity().getResources().getColor(R.color.colorPrimary)));
      liveStatusTv.setText("正在直播 :" + mUserLiveRoomStatusInfo.getData().getTitle());
      liveStatusTv.setTextColor(getActivity().getResources().getColor(R.color.colorPrimary));
    }
  }


  private void setPlayGame() {

    int count = mUserPlayGameInfo.getData().getCount();
    if (count == 0) {
      playGameLayout.setVisibility(View.GONE);
    }

    List<UserPlayGameInfo.DataBean.GamesBean> games = mUserPlayGameInfo.getData().getGames();
    mPlayerGameRecycler.setHasFixedSize(false);
    mPlayerGameRecycler.setNestedScrollingEnabled(false);
    mPlayerGameRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
    mPlayerGameRecycler.setAdapter(new UserHomePagerPlayGameAdapter(mPlayerGameRecycler, games));
    mPlayGameCount.setText(String.valueOf(count));
  }


  private void setQuanzi() {

    int total_count = mUserInterestQuanInfo.getData().getTotal_count();
    if (total_count == 0) {
      quanziLayout.setVisibility(View.GONE);
    }

    List<UserInterestQuanInfo.DataBean.ResultBean> result = mUserInterestQuanInfo.getData()
        .getResult();
    mQuanziRecycler.setHasFixedSize(false);
    mQuanziRecycler.setNestedScrollingEnabled(false);
    mQuanziRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
    mQuanziRecycler.setAdapter(new UserHomePagerInterestQuanAdapter(mQuanziRecycler, result));
    mQuanziCount.setText(String.valueOf(total_count));
  }


  private void setChaseBangumi() {

    int count = mUserChaseBangumiInfo.getData().getCount();
    if (count == 0) {
      chaseBangumiLayout.setVisibility(View.GONE);
    }

    List<UserChaseBangumiInfo.DataBean.ResultBean> result = mUserChaseBangumiInfo.getData()
        .getResult();
    mChaseBangumiRecycler.setHasFixedSize(false);
    mChaseBangumiRecycler.setNestedScrollingEnabled(false);
    mChaseBangumiRecycler.setLayoutManager(new GridLayoutManager(getActivity(), 3));
    mChaseBangumiRecycler.setAdapter(
        new UserHomePagerChaseBangumiAdapter(mChaseBangumiRecycler, result));
    mChaseBangumiCount.setText(String.valueOf(count));
  }


  private void setFavorites() {

    int size = mUserFavoritesInfo.getData().size();
    if (size == 0) {
      favoritesHeadLayout.setVisibility(View.GONE);
    }

    List<UserFavoritesInfo.DataBean> data = mUserFavoritesInfo.getData();
    List<UserFavoritesInfo.DataBean.VideosBean> videos = data.get(0).getVideos();
    mFavoritesLayout.setImages(videos);
    mFavoritesCount.setText(String.valueOf(size));
  }


  private void setCoins() {

    int count = mUserCoinsInfo.getData().getCount();
    if (count == 0) {
      coinsLayout.setVisibility(View.GONE);
    }

    List<UserCoinsInfo.DataBean.ListBean> list = mUserCoinsInfo.getData().getList();
    mCoinsRecycler.setHasFixedSize(false);
    mCoinsRecycler.setNestedScrollingEnabled(false);
    mCoinsRecycler.setLayoutManager(new GridLayoutManager(getActivity(), 2));
    mCoinsRecycler.setAdapter(new UserHomePagerCoinsAdapter(mCoinsRecycler, list));
    mCoinsCount.setText(String.valueOf(count));
  }


  private void setContribute() {

    int count = mUserContributeInfo.getData().getCount();
    if (count == 0) {
      contributeLayout.setVisibility(View.GONE);
    }

    List<UserContributeInfo.DataBean.VlistBean> vlist = mUserContributeInfo.getData().getVlist();
    mContributeRecycler.setHasFixedSize(false);
    mContributeRecycler.setNestedScrollingEnabled(false);
    mContributeRecycler.setLayoutManager(new GridLayoutManager(getActivity(), 2));
    mContributeRecycler.setAdapter(new UserHomePagerContributeAdapter(mContributeRecycler, vlist));
    mContributeCount.setText(String.valueOf(count));
  }


  @OnClick(R.id.contribute_more)
  void gotoContributePager() {

    ((UserInfoDetailsActivity) getActivity()).switchPager(1);
  }


  @OnClick(R.id.favorites_more)
  void gotoFavoritesPager() {

    ((UserInfoDetailsActivity) getActivity()).switchPager(2);
  }


  @OnClick(R.id.chase_bangumi_more)
  void gotoChaseBangumiPager() {

    ((UserInfoDetailsActivity) getActivity()).switchPager(3);
  }


  @OnClick(R.id.quanzi_more)
  void gotoQuanziPager() {

    ((UserInfoDetailsActivity) getActivity()).switchPager(4);
  }


  @OnClick(R.id.coins_more)
  void gotoCoinsPager() {

    ((UserInfoDetailsActivity) getActivity()).switchPager(5);
  }


  @OnClick(R.id.play_game_more)
  void gotoPlayGamePager() {

    ((UserInfoDetailsActivity) getActivity()).switchPager(6);
  }
}
