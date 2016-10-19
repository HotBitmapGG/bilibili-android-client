package com.hotbitmapgg.ohmybilibili.module.search;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.adapter.ComprehensiveResultsAdapter;
import com.hotbitmapgg.ohmybilibili.base.RxLazyFragment;
import com.hotbitmapgg.ohmybilibili.entity.search.SearchResult;
import com.hotbitmapgg.ohmybilibili.module.video.VideoDetailsActivity;
import com.hotbitmapgg.ohmybilibili.utils.ConstantUtils;

import java.util.List;

import butterknife.BindView;

/**
 * Created by hcc on 16/9/4 12:10
 * 100332338@qq.com
 * <p/>
 * 综合搜索结果界面
 */
public class ComprehensiveResultsFragment extends RxLazyFragment
{

    @BindView(R.id.recycle)
    RecyclerView mRecyclerView;

    @BindView(R.id.empty_view)
    ImageView mEmptyView;

    private SearchResult.ResultBean resultBean;

    private List<SearchResult.ResultBean.VideoBean> videos;

    public static ComprehensiveResultsFragment newInstance(SearchResult.ResultBean result)
    {

        ComprehensiveResultsFragment fragment = new ComprehensiveResultsFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(ConstantUtils.EXTRA_DATA, result);
        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public int getLayoutResId()
    {

        return R.layout.fragment_search_result;
    }

    @Override
    public void finishCreateView(Bundle state)
    {

        resultBean = getArguments().getParcelable(ConstantUtils.EXTRA_DATA);
        initData();
    }

    private void initData()
    {

        videos = resultBean.getVideo();
        if (videos != null)
            if (videos.size() == 0)
                showEmptyView();
            else
                hideEmptyView();


        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        ComprehensiveResultsAdapter mAdapter = new ComprehensiveResultsAdapter(mRecyclerView, videos);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener((position, holder) -> {

            SearchResult.ResultBean.VideoBean videoBean = videos.get(position);
            VideoDetailsActivity.launch(getActivity(), Integer.valueOf(videoBean.getAid()),videoBean.getPic());
        });
    }

    public void showEmptyView()
    {

        mEmptyView.setVisibility(View.VISIBLE);
    }

    public void hideEmptyView()
    {

        mEmptyView.setVisibility(View.GONE);
    }
}
