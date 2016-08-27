package com.hotbitmapgg.ohmybilibili.module.home.live;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.adapter.BiliBiliLiveRecyclerAdapter;
import com.hotbitmapgg.ohmybilibili.base.RxLazyFragment;
import com.hotbitmapgg.ohmybilibili.entity.live.Result;
import com.hotbitmapgg.ohmybilibili.entity.live.LiveIndex;
import com.hotbitmapgg.ohmybilibili.network.RetrofitHelper;
import com.hotbitmapgg.ohmybilibili.utils.SnackbarUtil;
import com.hotbitmapgg.ohmybilibili.widget.CustomEmptyView;

import butterknife.Bind;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by hcc on 16/8/4 21:18
 * 100332338@qq.com
 * <p/>
 * 首页直播界面
 */
public class HomeLiveFragment extends RxLazyFragment
{

    @Bind(R.id.recycle)
    RecyclerView mRecyclerView;

    @Bind(R.id.swipe_refresh_layout)
    SwipeRefreshLayout mSwipeRefreshLayout;

    @Bind(R.id.empty_layout)
    CustomEmptyView mCustomEmptyView;

    private BiliBiliLiveRecyclerAdapter mBiliBiliLiveRecyclerAdapter;


    public static HomeLiveFragment newIntance()
    {

        return new HomeLiveFragment();
    }


    @Override
    public int getLayoutResId()
    {

        return R.layout.fragment_live;
    }


    @Override
    public void finishCreateView(Bundle state)
    {

        isPrepared = true;
        lazyLoad();
    }

    @Override
    protected void lazyLoad()
    {

        if (!isPrepared || !isVisible)
            return;

        showProgressBar();
        isPrepared = false;
    }

    private void showProgressBar()
    {

        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        mBiliBiliLiveRecyclerAdapter = new BiliBiliLiveRecyclerAdapter(getActivity());
        mRecyclerView.setAdapter(mBiliBiliLiveRecyclerAdapter);
        GridLayoutManager layout = new GridLayoutManager(getActivity(), 12);
        layout.setOrientation(LinearLayoutManager.VERTICAL);
        layout.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup()
        {

            @Override
            public int getSpanSize(int position)
            {

                return mBiliBiliLiveRecyclerAdapter.getSpanSize(position);
            }
        });

        mRecyclerView.setLayoutManager(layout);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener()
        {

            @Override
            public void onRefresh()
            {

                getBiliBiliLive();
            }
        });

        mSwipeRefreshLayout.post(new Runnable()
        {

            @Override
            public void run()
            {

                mSwipeRefreshLayout.setRefreshing(true);
                getBiliBiliLive();
            }
        });
    }


    public void getBiliBiliLive()
    {

        RetrofitHelper.getBiliBiliLiveApi()
                .getLiveIndex()
                .compose(this.<Result<LiveIndex>> bindToLifecycle())
                .flatMap(new Func1<Result<LiveIndex>,Observable<LiveIndex>>()
                {

                    @Override
                    public Observable<LiveIndex> call(Result<LiveIndex> liveIndexResult)
                    {

                        if (liveIndexResult.code != 0)
                        {
                            throw new RuntimeException();
                        }
                        return Observable.just(liveIndexResult.data);
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<LiveIndex>()
                {

                    @Override
                    public void call(LiveIndex liveIndex)
                    {

                        finishTask(liveIndex);
                    }
                }, new Action1<Throwable>()
                {

                    @Override
                    public void call(Throwable throwable)
                    {

                        initEmptyView();
                    }
                });
    }

    private void initEmptyView()
    {

        mSwipeRefreshLayout.setRefreshing(false);
        mCustomEmptyView.setVisibility(View.VISIBLE);
        mCustomEmptyView.setEmptyImage(R.drawable.img_tips_error_load_error);
        mCustomEmptyView.setEmptyText("加载失败~(≧▽≦)~啦啦啦.");
        SnackbarUtil.showMessage(mRecyclerView, "数据加载失败,请重新加载或者检查网络是否链接");
        mCustomEmptyView.reload(new CustomEmptyView.ReloadOnClickListener()
        {

            @Override
            public void reloadClick()
            {
                showProgressBar();
            }
        });
    }

    public void hideEmptyView()
    {

        mCustomEmptyView.setVisibility(View.GONE);
    }


    private void finishTask(LiveIndex liveIndex)
    {

        hideEmptyView();
        mSwipeRefreshLayout.setRefreshing(false);
        mBiliBiliLiveRecyclerAdapter.setLiveIndex(liveIndex);
        mBiliBiliLiveRecyclerAdapter.notifyDataSetChanged();
        mRecyclerView.scrollToPosition(0);
    }
}
