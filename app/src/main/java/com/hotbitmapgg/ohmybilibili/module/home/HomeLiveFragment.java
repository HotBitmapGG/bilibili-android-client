package com.hotbitmapgg.ohmybilibili.module.home;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.adapter.LiveFragmentAdapter;
import com.hotbitmapgg.ohmybilibili.base.BaseHomeFragment;
import com.hotbitmapgg.ohmybilibili.model.base.Result;
import com.hotbitmapgg.ohmybilibili.model.live.LiveIndex;
import com.hotbitmapgg.ohmybilibili.retrofit.RetrofitHelper;

import butterknife.Bind;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * 首页-直播
 *
 * @HotBitmapGG
 */
public class HomeLiveFragment extends BaseHomeFragment
{

    @Bind(R.id.frag_live_recycler)
    RecyclerView liveRecyclerView;

    @Bind(R.id.frag_live_refresh)
    SwipeRefreshLayout liveRefresh;

    private LiveFragmentAdapter liveFragmentAdapter;


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

        liveRefresh.setColorSchemeResources(R.color.primary);
        liveFragmentAdapter = new LiveFragmentAdapter(getActivity());
        liveRecyclerView.setAdapter(liveFragmentAdapter);

        GridLayoutManager layout = new GridLayoutManager(getActivity(), 12);
        layout.setOrientation(LinearLayoutManager.VERTICAL);
        layout.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup()
        {

            @Override
            public int getSpanSize(int position)
            {

                return liveFragmentAdapter.getSpanSize(position);
            }
        });

        liveRecyclerView.setLayoutManager(layout);
        liveRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener()
        {

            @Override
            public void onRefresh()
            {
                //开始请求
                liveRequest();
            }
        });
        //开始请求
        liveRequest();
    }


    public void liveRequest()
    {

        RetrofitHelper.getBiliBiliLiveApi()
                .getIndexRx()
                .compose(this.<Result<LiveIndex>>bindToLifecycle())
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
                .subscribe(new Subscriber<LiveIndex>()
                {

                    @Override
                    public void onCompleted()
                    {

                        liveRefresh.setRefreshing(false);
                    }

                    @Override
                    public void onError(Throwable e)
                    {

                        liveRefresh.setRefreshing(false);
                    }

                    @Override
                    public void onNext(LiveIndex liveIndex)
                    {

                        liveFragmentAdapter.setLiveIndex(liveIndex);
                        liveFragmentAdapter.notifyDataSetChanged();
                        liveRecyclerView.scrollToPosition(0);
                    }
                });
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
}
