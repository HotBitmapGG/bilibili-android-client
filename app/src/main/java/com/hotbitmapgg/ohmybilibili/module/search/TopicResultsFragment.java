package com.hotbitmapgg.ohmybilibili.module.search;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.adapter.TopicResultsAdapter;
import com.hotbitmapgg.ohmybilibili.adapter.base.AbsRecyclerViewAdapter;
import com.hotbitmapgg.ohmybilibili.base.RxLazyFragment;
import com.hotbitmapgg.ohmybilibili.entity.search.SearchResult;
import com.hotbitmapgg.ohmybilibili.module.common.WebActivity;

import java.util.List;

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

    @Bind(R.id.empty_view)
    ImageView mEmptyView;

    private static final String EXTRA_DATA = "extra_data";

    private SearchResult.ResultBean resultBean;

    private List<SearchResult.ResultBean.TopicBean> topics;

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

        topics = resultBean.getTopic();
        if (topics != null)
            if (topics.size() == 0)
                showEmptyView();
            else
                hideEmptyView();


        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        TopicResultsAdapter mAdapter = new TopicResultsAdapter(mRecyclerView, topics);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new AbsRecyclerViewAdapter.OnItemClickListener()
        {

            @Override
            public void onItemClick(int position, AbsRecyclerViewAdapter.ClickableViewHolder holder)
            {

                SearchResult.ResultBean.TopicBean topicBean = topics.get(position);
                WebActivity.launch(getActivity(), topicBean.getArcurl(), topicBean.getTitle());
            }
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

    @Override
    protected void lazyLoad()
    {

    }
}
