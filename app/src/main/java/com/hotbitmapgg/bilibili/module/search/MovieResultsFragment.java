package com.hotbitmapgg.bilibili.module.search;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.hotbitmapgg.bilibili.adapter.MovieResultsAdapter;
import com.hotbitmapgg.bilibili.adapter.helper.EndlessRecyclerOnScrollListener;
import com.hotbitmapgg.bilibili.adapter.helper.HeaderViewRecyclerAdapter;
import com.hotbitmapgg.bilibili.base.RxLazyFragment;
import com.hotbitmapgg.bilibili.entity.search.SearchMovieInfo;
import com.hotbitmapgg.bilibili.module.home.bangumi.SpecialDetailsActivity;
import com.hotbitmapgg.bilibili.network.RetrofitHelper;
import com.hotbitmapgg.bilibili.utils.ConstantUtil;
import com.hotbitmapgg.ohmybilibili.R;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by hcc on 16/9/4 12:26
 * 100332338@qq.com
 * <p/>
 * 影视搜索界面
 */
public class MovieResultsFragment extends RxLazyFragment {
    @BindView(R.id.recycle)
    RecyclerView mRecyclerView;
    @BindView(R.id.empty_view)
    ImageView mEmptyView;
    @BindView(R.id.iv_search_loading)
    ImageView mLoadingView;

    private String content;
    private int pageNum = 1;
    private int pageSize = 10;
    private View loadMoreView;
    private AnimationDrawable mAnimationDrawable;
    private HeaderViewRecyclerAdapter mHeaderViewRecyclerAdapter;
    private List<SearchMovieInfo.DataBean.ItemsBean> movies = new ArrayList<>();

    public static MovieResultsFragment newInstance(String content) {
        MovieResultsFragment fragment = new MovieResultsFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ConstantUtil.EXTRA_CONTENT, content);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_search_result;
    }

    @Override
    public void finishCreateView(Bundle state) {
        content = getArguments().getString(ConstantUtil.EXTRA_CONTENT);
        mLoadingView.setImageResource(R.drawable.anim_search_loading);
        mAnimationDrawable = (AnimationDrawable) mLoadingView.getDrawable();
        showSearchAnim();
        isPrepared = true;
        lazyLoad();
    }

    @Override
    protected void lazyLoad() {
        if (!isPrepared || !isVisible) {
            return;
        }
        initRecyclerView();
        loadData();
        isPrepared = false;
    }

    @Override
    protected void initRecyclerView() {
        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        MovieResultsAdapter mAdapter = new MovieResultsAdapter(mRecyclerView, movies);
        mHeaderViewRecyclerAdapter = new HeaderViewRecyclerAdapter(mAdapter);
        mRecyclerView.setAdapter(mHeaderViewRecyclerAdapter);
        createLoadMoreView();
        mRecyclerView.addOnScrollListener(new EndlessRecyclerOnScrollListener(mLinearLayoutManager) {
            @Override
            public void onLoadMore(int i) {
                pageNum++;
                loadData();
                loadMoreView.setVisibility(View.VISIBLE);
            }
        });
        mAdapter.setOnItemClickListener((position, holder) -> SpecialDetailsActivity.launch(getActivity(),
                movies.get(position).getParam(),
                movies.get(position).getTitle(),
                Integer.valueOf(movies.get(position).getParam())));
    }

    @Override
    protected void loadData() {
        RetrofitHelper.getBiliAppAPI()
                .searchMovie(content, pageNum, pageSize)
                .compose(bindToLifecycle())
                .map(SearchMovieInfo::getData)
                .delay(1000, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(dataBean -> {
                    if (dataBean.getItems().size() < pageSize) {
                        loadMoreView.setVisibility(View.GONE);
                        mHeaderViewRecyclerAdapter.removeFootView();
                    }
                })
                .subscribe(dataBean -> {
                    movies.addAll(dataBean.getItems());
                    finishTask();
                }, throwable -> {
                    hideSearchAnim();
                    showEmptyView();
                    loadMoreView.setVisibility(View.GONE);
                });
    }


    @Override
    protected void finishTask() {
        if (movies != null) {
            if (movies.size() == 0) {
                showEmptyView();
            } else {
                hideEmptyView();
            }
        }
        hideSearchAnim();
        loadMoreView.setVisibility(View.GONE);
        if (pageNum * pageSize - pageSize - 1 > 0) {
            mHeaderViewRecyclerAdapter.notifyItemRangeChanged(pageNum * pageSize - pageSize - 1,
                    pageSize);
        } else {
            mHeaderViewRecyclerAdapter.notifyDataSetChanged();
        }
    }

    private void createLoadMoreView() {
        loadMoreView = LayoutInflater.from(getActivity()).inflate(R.layout.layout_load_more, mRecyclerView, false);
        mHeaderViewRecyclerAdapter.addFooterView(loadMoreView);
        loadMoreView.setVisibility(View.GONE);
    }

    private void showSearchAnim() {
        mLoadingView.setVisibility(View.VISIBLE);
        mAnimationDrawable.start();
    }

    private void hideSearchAnim() {
        mLoadingView.setVisibility(View.GONE);
        mAnimationDrawable.stop();
    }

    public void showEmptyView() {
        mEmptyView.setVisibility(View.VISIBLE);
    }

    public void hideEmptyView() {
        mEmptyView.setVisibility(View.GONE);
    }
}
