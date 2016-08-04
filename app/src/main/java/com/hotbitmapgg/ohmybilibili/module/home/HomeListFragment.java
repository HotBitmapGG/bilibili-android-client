package com.hotbitmapgg.ohmybilibili.module.home;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.adapter.MainListRecycleAdapter;
import com.hotbitmapgg.ohmybilibili.api.IndexApi;
import com.hotbitmapgg.ohmybilibili.base.BaseHomeFragment;
import com.hotbitmapgg.ohmybilibili.model.base.BasicMessage;
import com.hotbitmapgg.ohmybilibili.model.index.Index;
import com.hotbitmapgg.ohmybilibili.utils.LogUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import butterknife.Bind;
import rx.Single;
import rx.SingleSubscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * 首页-推荐
 *
 * @HotBitmapGG
 */
public class HomeListFragment extends BaseHomeFragment
{

    @Bind(R.id.main_list)
    RecyclerView mRecyclerView;

    @Bind(R.id.swipe_refresh_layout)
    SwipeRefreshLayout mSwipeRefreshLayout;

    List<Index.FuckList> indexs = new ArrayList<>();

    private Index mTypeIndex;

    public static final int TYPE_CARTOON = 1, TYPE_MUSIC = 3,
            TYPE_GAME = 4, TYPE_ENTERTAINMENT = 5,
            TYPE_TV_SERIES = 11, TYPE_ANIME = 13,
            TYPE_MOVIE = 23, TYPE_TECHNOLOGY = 36,
            TYPE_DANCE = 129, TYPE_FUNNY = 119;


    public static HomeListFragment newInstance()
    {

        HomeListFragment homeListFragment = new HomeListFragment();
        return homeListFragment;
    }

    @Override
    public int getLayoutResId()
    {

        return R.layout.fragment_main_list;
    }

    @Override
    public void finishCreateView(Bundle state)
    {

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mSwipeRefreshLayout.setColorSchemeResources(R.color.primary);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener()
        {

            @Override
            public void onRefresh()
            {

                getIndex();
            }
        });

        getIndex();
    }

    @Override
    public void scrollToTop()
    {

    }

    @Override
    public boolean canScrollVertically(int direction)
    {

        return false;
    }

    public void getIndex()
    {

        Single<BasicMessage<Index>> single = Single.fromCallable(new Callable<BasicMessage<Index>>()
        {

            @Override
            public BasicMessage<Index> call() throws Exception
            {

                return IndexApi.getIndex();
            }
        });

        Subscription subscribe = single.map(new Func1<BasicMessage<Index>,Index>()
        {

            @Override
            public Index call(BasicMessage<Index> indexBasicMessage)
            {

                return indexBasicMessage.getObject();
            }
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleSubscriber<Index>()
                {

                    @Override
                    public void onSuccess(Index value)
                    {

                        mTypeIndex = value;
                        finishGetTask();
                    }

                    @Override
                    public void onError(Throwable error)
                    {

                        LogUtil.lsw("加载index数据失败");
                    }
                });

        compositeSubscription.add(subscribe);
    }


    private void finishGetTask()
    {

        indexs.clear();
        mSwipeRefreshLayout.setRefreshing(false);

        if (mTypeIndex != null)
        {
            Index.FuckList typeAnime = mTypeIndex.typeAnime;
            Index.FuckList typeCartoon = mTypeIndex.typeCartoon;
            Index.FuckList typeMusic = mTypeIndex.typeMusic;
            Index.FuckList typeDance = mTypeIndex.typeDance;
            Index.FuckList typeEntertainment = mTypeIndex.typeEntertainment;
            Index.FuckList typeFunny = mTypeIndex.typeFunny;
            Index.FuckList typeGame = mTypeIndex.typeGame;
            Index.FuckList typeMovie = mTypeIndex.typeMovie;
            Index.FuckList typeTechnology = mTypeIndex.typeTechnology;
            Index.FuckList typeTvSeries = mTypeIndex.typeTvSeries;


            indexs.add(typeAnime);
            indexs.add(typeCartoon);
            indexs.add(typeMusic);
            indexs.add(typeDance);
            indexs.add(typeEntertainment);
            indexs.add(typeFunny);
            indexs.add(typeGame);
            indexs.add(typeMovie);
            indexs.add(typeTechnology);
            indexs.add(typeTvSeries);


            MainListRecycleAdapter mainListRecycleAdapter = new MainListRecycleAdapter(mRecyclerView, indexs, getActivity());
            mRecyclerView.setAdapter(mainListRecycleAdapter);
        }
    }
}
