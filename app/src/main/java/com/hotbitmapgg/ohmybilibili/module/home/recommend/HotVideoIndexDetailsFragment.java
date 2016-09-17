package com.hotbitmapgg.ohmybilibili.module.home.recommend;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.adapter.HotVideoIndexRecyclerAdapter;
import com.hotbitmapgg.ohmybilibili.adapter.base.AbsRecyclerViewAdapter;
import com.hotbitmapgg.ohmybilibili.base.RxLazyFragment;
import com.hotbitmapgg.ohmybilibili.entity.index.Index;
import com.hotbitmapgg.ohmybilibili.entity.video.VideoItemInfo;
import com.hotbitmapgg.ohmybilibili.module.video.VideoDetailsActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.Bind;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

/**
 * Created by hcc on 16/8/11 20:23
 * 100332338@qq.com
 * <p/>
 * 9个热门视频详情界面
 */
public class HotVideoIndexDetailsFragment extends RxLazyFragment
{

    @Bind(R.id.recycle)
    RecyclerView mRecyclerView;

    @Bind(R.id.swipe_refresh_layout)
    SwipeRefreshLayout mSwipeRefreshLayout;

    private static final String EXTRA_KEY = "extra_index_list";

    private Index.FuckList mFuckList;

    private List<VideoItemInfo> videoItemInfos = new ArrayList<>();


    public static HotVideoIndexDetailsFragment newInstance(Index.FuckList fuckList)
    {

        HotVideoIndexDetailsFragment mFragment = new HotVideoIndexDetailsFragment();
        Bundle mBundle = new Bundle();
        mBundle.putSerializable(EXTRA_KEY, fuckList);
        mFragment.setArguments(mBundle);
        return mFragment;
    }

    @Override
    public int getLayoutResId()
    {

        return R.layout.fragment_hot_video_index;
    }

    @Override
    public void finishCreateView(Bundle state)
    {

        mFuckList = (Index.FuckList) getArguments()
                .getSerializable(EXTRA_KEY);
        initRefreshLayout();
    }

    @Override
    protected void lazyLoad()
    {

    }

    private void initRefreshLayout()
    {

        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        mSwipeRefreshLayout.postDelayed(new Runnable()
        {

            @Override
            public void run()
            {

                mSwipeRefreshLayout.setRefreshing(true);
                initData();
            }
        }, 500);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener()
        {

            @Override
            public void onRefresh()
            {

                mSwipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    private void initData()
    {

        videoItemInfos.add(mFuckList.item0);
        videoItemInfos.add(mFuckList.item1);
        videoItemInfos.add(mFuckList.item2);
        videoItemInfos.add(mFuckList.item3);
        videoItemInfos.add(mFuckList.item4);
        videoItemInfos.add(mFuckList.item5);
        videoItemInfos.add(mFuckList.item6);
        videoItemInfos.add(mFuckList.item7);
        videoItemInfos.add(mFuckList.item8);


        Observable.timer(1000, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Long>()
                {

                    @Override
                    public void call(Long aLong)
                    {

                        initRecyclerView();
                    }
                });
    }

    private void initRecyclerView()
    {

        mSwipeRefreshLayout.setRefreshing(false);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setNestedScrollingEnabled(true);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        HotVideoIndexRecyclerAdapter mAdapter = new HotVideoIndexRecyclerAdapter(mRecyclerView, videoItemInfos);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new AbsRecyclerViewAdapter.OnItemClickListener()
        {

            @Override
            public void onItemClick(int position, AbsRecyclerViewAdapter.ClickableViewHolder holder)
            {

                VideoDetailsActivity.launch(getActivity(),
                        videoItemInfos.get(position).aid,
                        videoItemInfos.get(position).pic);
            }
        });
    }
}
