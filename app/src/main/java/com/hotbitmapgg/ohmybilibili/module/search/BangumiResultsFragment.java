package com.hotbitmapgg.ohmybilibili.module.search;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.adapter.BangumiResultsAdapter;
import com.hotbitmapgg.ohmybilibili.base.RxLazyFragment;
import com.hotbitmapgg.ohmybilibili.entity.search.SearchResult;
import com.hotbitmapgg.ohmybilibili.utils.ConstantUtils;

import java.util.ArrayList;

import butterknife.Bind;

/**
 * Created by hcc on 16/8/29 21:08
 * 100332338@qq.com
 * <p/>
 * 番剧搜索内容列表界面
 */
public class BangumiResultsFragment extends RxLazyFragment
{

    @Bind(R.id.recycle)
    RecyclerView mRecyclerView;

    @Bind(R.id.empty_view)
    ImageView mEmptyView;

    private SearchResult.ResultBean resultBean;

    private ArrayList<SearchResult.ResultBean.BangumiBean> bangumis;

    public static BangumiResultsFragment newInstance(SearchResult.ResultBean result)
    {

        BangumiResultsFragment fragment = new BangumiResultsFragment();
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

        bangumis = resultBean.getBangumi();
        if (bangumis != null)
            if (bangumis.size() == 0)
                showEmptyView();
            else
                hideEmptyView();

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        BangumiResultsAdapter mAdapter = new BangumiResultsAdapter(mRecyclerView, bangumis);
        mRecyclerView.setAdapter(mAdapter);
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
