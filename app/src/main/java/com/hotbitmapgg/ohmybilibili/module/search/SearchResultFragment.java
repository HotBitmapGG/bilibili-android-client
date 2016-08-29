package com.hotbitmapgg.ohmybilibili.module.search;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.adapter.SearchResultRecyclerAdapter;
import com.hotbitmapgg.ohmybilibili.base.RxLazyFragment;
import com.hotbitmapgg.ohmybilibili.entity.search.SearchResult;
import com.hotbitmapgg.ohmybilibili.utils.LogUtil;

import butterknife.Bind;

/**
 * Created by hcc on 16/8/29 21:08
 * 100332338@qq.com
 * <p/>
 * 全站搜索内容列表界面
 */
public class SearchResultFragment extends RxLazyFragment
{

    @Bind(R.id.recycle)
    RecyclerView mRecyclerView;

    private static final String EXTRA_DATA = "extra_data";

    private SearchResult.ResultBean resultBean;

    public static SearchResultFragment newInstance(SearchResult.ResultBean result)
    {

        SearchResultFragment fragment = new SearchResultFragment();
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
        LogUtil.all(resultBean.getBangumi().size() + "^^^^");
        initData();
    }

    private void initData()
    {

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(new SearchResultRecyclerAdapter(mRecyclerView, resultBean.getBangumi()));
    }

    @Override
    protected void lazyLoad()
    {

    }
}
