package com.hotbitmapgg.bilibili.module.search;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.hotbitmapgg.bilibili.adapter.ArchiveHeadBangumiAdapter;
import com.hotbitmapgg.bilibili.adapter.ArchiveResultsAdapter;
import com.hotbitmapgg.bilibili.adapter.helper.EndlessRecyclerOnScrollListener;
import com.hotbitmapgg.bilibili.adapter.helper.HeaderViewRecyclerAdapter;
import com.hotbitmapgg.bilibili.base.RxLazyFragment;
import com.hotbitmapgg.bilibili.entity.search.SearchArchiveInfo;
import com.hotbitmapgg.bilibili.module.video.VideoDetailsActivity;
import com.hotbitmapgg.bilibili.network.RetrofitHelper;
import com.hotbitmapgg.bilibili.utils.ConstantUtil;
import com.hotbitmapgg.ohmybilibili.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by hcc on 16/9/4 12:10
 * 100332338@qq.com
 * <p/>
 * 综合搜索结果界面
 */
public class ArchiveResultsFragment extends RxLazyFragment {
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
    private HeaderViewRecyclerAdapter mHeaderViewRecyclerAdapter;
    private List<SearchArchiveInfo.DataBean.ItemsBean.ArchiveBean> archives = new ArrayList<>();
    private List<SearchArchiveInfo.DataBean.ItemsBean.SeasonBean> seasons = new ArrayList<>();
    private ArchiveHeadBangumiAdapter archiveHeadBangumiAdapter;

    public static ArchiveResultsFragment newInstance(String content) {
        ArchiveResultsFragment fragment = new ArchiveResultsFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ConstantUtil.EXTRA_CONTENT, content);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_archive_results;
    }

    @Override
    public void finishCreateView(Bundle state) {
        content = getArguments().getString(ConstantUtil.EXTRA_CONTENT);
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
        ArchiveResultsAdapter mAdapter = new ArchiveResultsAdapter(mRecyclerView, archives);
        mHeaderViewRecyclerAdapter = new HeaderViewRecyclerAdapter(mAdapter);
        mRecyclerView.setAdapter(mHeaderViewRecyclerAdapter);
        createHeadView();
        createLoadMoreView();
        mRecyclerView.addOnScrollListener(new EndlessRecyclerOnScrollListener(mLinearLayoutManager) {
            @Override
            public void onLoadMore(int i) {
                pageNum++;
                loadData();
                loadMoreView.setVisibility(View.VISIBLE);
            }
        });
        mAdapter.setOnItemClickListener((position, holder) -> {
            SearchArchiveInfo.DataBean.ItemsBean.ArchiveBean archiveBean = archives.get(position);
            VideoDetailsActivity.launch(getActivity(), Integer.valueOf(archiveBean.getParam()),
                    archiveBean.getCover());
        });
    }


    @Override
    protected void loadData() {
        RetrofitHelper.getBiliAppAPI()
                .searchArchive(content, pageNum, pageSize)
                .compose(this.bindToLifecycle())
                .map(SearchArchiveInfo::getData)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(dataBean -> {
                    if (dataBean.getItems().getArchive().size() < pageSize) {
                        loadMoreView.setVisibility(View.GONE);
                        mHeaderViewRecyclerAdapter.removeFootView();
                    }
                })
                .subscribe(dataBean -> {
                    archives.addAll(dataBean.getItems().getArchive());
                    seasons.addAll(dataBean.getItems().getSeason());
                    finishTask();
                }, throwable -> {
                    showEmptyView();
                    loadMoreView.setVisibility(View.GONE);
                });
    }


    @Override
    protected void finishTask() {
        if (archives != null) {
            if (archives.size() == 0) {
                showEmptyView();
            } else {
                hideEmptyView();
            }
        }
        loadMoreView.setVisibility(View.GONE);
        archiveHeadBangumiAdapter.notifyDataSetChanged();
        if (pageNum * pageSize - pageSize - 1 > 0) {
            mHeaderViewRecyclerAdapter.notifyItemRangeChanged(pageNum * pageSize - pageSize - 1, pageSize);
        } else {
            mHeaderViewRecyclerAdapter.notifyDataSetChanged();
        }
    }


    private void createHeadView() {
        View headView = LayoutInflater.from(getActivity()).inflate(R.layout.layout_search_archive_head_view, mRecyclerView, false);
        RecyclerView mHeadBangumiRecycler = (RecyclerView) headView.findViewById(R.id.search_archive_bangumi_head_recycler);
        mHeadBangumiRecycler.setHasFixedSize(false);
        mHeadBangumiRecycler.setNestedScrollingEnabled(false);
        mHeadBangumiRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        archiveHeadBangumiAdapter = new ArchiveHeadBangumiAdapter(mHeadBangumiRecycler, seasons);
        mHeadBangumiRecycler.setAdapter(archiveHeadBangumiAdapter);
        mHeaderViewRecyclerAdapter.addHeaderView(headView);
    }


    private void createLoadMoreView() {
        loadMoreView = LayoutInflater.from(getActivity()).inflate(R.layout.layout_load_more, mRecyclerView, false);
        mHeaderViewRecyclerAdapter.addFooterView(loadMoreView);
        loadMoreView.setVisibility(View.GONE);
    }

    public void showEmptyView() {
        mEmptyView.setVisibility(View.VISIBLE);
    }

    public void hideEmptyView() {
        mEmptyView.setVisibility(View.GONE);
    }
}
