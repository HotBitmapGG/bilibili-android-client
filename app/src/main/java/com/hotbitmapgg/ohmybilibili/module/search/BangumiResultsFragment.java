package com.hotbitmapgg.ohmybilibili.module.search;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.adapter.BangumiResultsAdapter;
import com.hotbitmapgg.ohmybilibili.base.RxLazyFragment;
import com.hotbitmapgg.ohmybilibili.entity.search.SearchResult;

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

    private static final String EXTRA_DATA = "extra_data";

    private SearchResult.ResultBean resultBean;

    public static BangumiResultsFragment newInstance(SearchResult.ResultBean result)
    {

        BangumiResultsFragment fragment = new BangumiResultsFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(EXTRA_DATA, result);
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

        resultBean = getArguments().getParcelable(EXTRA_DATA);
        initData();
    }

    private void initData()
    {

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(new BangumiResultsAdapter(mRecyclerView, resultBean.getBangumi()));
    }

    @Override
    protected void lazyLoad()
    {

    }
}
