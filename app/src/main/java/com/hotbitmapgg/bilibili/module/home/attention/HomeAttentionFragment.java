package com.hotbitmapgg.bilibili.module.home.attention;

import butterknife.BindView;
import com.hotbitmapgg.bilibili.adapter.AttentionBangumiAdapter;
import com.hotbitmapgg.bilibili.adapter.AttentionDynamicAdapter;
import com.hotbitmapgg.bilibili.adapter.helper.HeaderViewRecyclerAdapter;
import com.hotbitmapgg.bilibili.base.RxLazyFragment;
import com.hotbitmapgg.bilibili.entity.attention.AttentionDynamicInfo;
import com.hotbitmapgg.bilibili.entity.user.UserChaseBangumiInfo;
import com.hotbitmapgg.bilibili.network.RetrofitHelper;
import com.hotbitmapgg.bilibili.utils.SnackbarUtil;
import com.hotbitmapgg.bilibili.widget.CustomEmptyView;
import com.hotbitmapgg.ohmybilibili.R;
import java.util.ArrayList;
import java.util.List;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

/**
 * Created by hcc on 16/8/22 21:40
 * 100332338@qq.com
 * <p/>
 * 主界面关注界面
 */
public class HomeAttentionFragment extends RxLazyFragment {

  @BindView(R.id.swipe_refresh_layout)
  SwipeRefreshLayout mSwipeRefreshLayout;

  @BindView(R.id.recycle)
  RecyclerView mRecyclerView;

  @BindView(R.id.empty_layout)
  CustomEmptyView mCustomEmptyView;

  private static final int MID = 9467159;

  private boolean mIsRefreshing = false;

  private HeaderViewRecyclerAdapter mHeaderViewRecyclerAdapter;

  private List<UserChaseBangumiInfo.DataBean.ResultBean> chaseBangumis = new ArrayList<>();

  private List<AttentionDynamicInfo.DataBean.FeedsBean> dynamics = new ArrayList<>();


  public static HomeAttentionFragment newIntance() {

    return new HomeAttentionFragment();
  }


  @Override
  public int getLayoutResId() {

    return R.layout.fragment_attention;
  }


  @Override
  public void finishCreateView(Bundle state) {

    isPrepared = true;
    lazyLoad();
  }


  @Override
  protected void lazyLoad() {

    if (!isPrepared || !isVisible) {
      return;
    }

    initRefreshLayout();
    isPrepared = false;
  }


  @Override
  protected void initRefreshLayout() {

    mSwipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
    mSwipeRefreshLayout.post(() -> {

      mSwipeRefreshLayout.setRefreshing(true);
      mIsRefreshing = true;
      loadData();
    });

    mSwipeRefreshLayout.setOnRefreshListener(() -> {

      clearData();
      loadData();
    });
  }


  @Override
  protected void loadData() {

    RetrofitHelper.getUserAPI()
        .getUserChaseBangumis(MID)
        .compose(bindToLifecycle())
        .map(userChaseBangumiInfo -> userChaseBangumiInfo.getData().getResult())
        .flatMap(
            new Func1<List<UserChaseBangumiInfo.DataBean.ResultBean>, Observable<AttentionDynamicInfo>>() {

              @Override
              public Observable<AttentionDynamicInfo> call(List<UserChaseBangumiInfo.DataBean.ResultBean> resultBeans) {

                chaseBangumis.addAll(resultBeans);
                return RetrofitHelper.getBiliAPI().getAttentionDynamic();
              }
            })
        .map(attentionDynamicInfo -> attentionDynamicInfo.getData().getFeeds())
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(feedsBeans -> {

          dynamics.addAll(feedsBeans);
          finishTask();
        }, throwable -> {
          initEmptyView();
        });
  }


  @Override
  protected void finishTask() {

    mSwipeRefreshLayout.setRefreshing(false);
    mIsRefreshing = false;
    hideEmptyView();
    initRecyclerView();
  }


  @Override
  protected void initRecyclerView() {

    mRecyclerView.setHasFixedSize(true);
    mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    AttentionDynamicAdapter mAdapter = new AttentionDynamicAdapter(mRecyclerView, dynamics);
    mHeaderViewRecyclerAdapter = new HeaderViewRecyclerAdapter(mAdapter);
    createHeadView();
    mRecyclerView.setAdapter(mHeaderViewRecyclerAdapter);
    setRecycleNoScroll();
  }


  public void initEmptyView() {

    mSwipeRefreshLayout.setRefreshing(false);
    mCustomEmptyView.setVisibility(View.VISIBLE);
    mRecyclerView.setVisibility(View.GONE);
    mCustomEmptyView.setEmptyImage(R.drawable.img_tips_error_load_error);
    mCustomEmptyView.setEmptyText("加载失败~(≧▽≦)~啦啦啦.");
    SnackbarUtil.showMessage(mRecyclerView, "数据加载失败,请重新加载或者检查网络是否链接");
  }


  public void hideEmptyView() {

    mCustomEmptyView.setVisibility(View.GONE);
    mRecyclerView.setVisibility(View.VISIBLE);
  }


  private void clearData() {

    mIsRefreshing = true;
    chaseBangumis.clear();
    dynamics.clear();
  }


  private void createHeadView() {

    View headView = LayoutInflater.from(getActivity())
        .inflate(R.layout.layout_attention_head_view, mRecyclerView, false);
    RecyclerView mBangumiRecycler = (RecyclerView) headView.findViewById(R.id.focus_head_recycler);
    mBangumiRecycler.setHasFixedSize(false);
    mBangumiRecycler.setNestedScrollingEnabled(false);
    mBangumiRecycler.setLayoutManager(new GridLayoutManager(getActivity(), 3));
    mBangumiRecycler.setAdapter(new AttentionBangumiAdapter(mBangumiRecycler, chaseBangumis));
    mHeaderViewRecyclerAdapter.addHeaderView(headView);
  }


  private void setRecycleNoScroll() {

    mRecyclerView.setOnTouchListener((v, event) -> mIsRefreshing);
  }
}
