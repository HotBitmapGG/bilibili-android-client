package com.hotbitmapgg.ohmybilibili.module.search;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.adapter.TopicResultsAdapter;
import com.hotbitmapgg.ohmybilibili.base.RxLazyFragment;
import com.hotbitmapgg.ohmybilibili.entity.search.SearchResult;

import butterknife.Bind;

/**
 * Created by hcc on 16/9/4 12:26
 * 100332338@qq.com
 * <p/>
 * 话题搜索结果返回界面
 */
public class TopicResultsFragment extends RxLazyFragment
{

    @Bind(R.id.recycle)
    RecyclerView mRecyclerView;

    private static final String EXTRA_DATA = "extra_data";

    private SearchResult.ResultBean resultBean;

    public static TopicResultsFragment newInstance(SearchResult.ResultBean result)
    {

        TopicResultsFragment fragment = new TopicResultsFragment();
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
        mRecyclerView.setAdapter(new TopicResultsAdapter(mRecyclerView, resultBean.getTopic()));
    }

    @Override
    protected void lazyLoad()
    {

    }
}
