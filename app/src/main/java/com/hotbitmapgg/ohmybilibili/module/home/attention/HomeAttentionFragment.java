package com.hotbitmapgg.ohmybilibili.module.home.attention;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.adapter.AttentionBangumiAdapter;
import com.hotbitmapgg.ohmybilibili.adapter.AttentionDynamicAdapter;
import com.hotbitmapgg.ohmybilibili.adapter.helper.HeaderViewRecyclerAdapter;
import com.hotbitmapgg.ohmybilibili.base.RxLazyFragment;
import com.hotbitmapgg.ohmybilibili.entity.attention.AttentionBangumi;
import com.hotbitmapgg.ohmybilibili.entity.attention.AttentionContents;
import com.hotbitmapgg.ohmybilibili.entity.attention.AttentionDynamic;

import java.util.List;

import butterknife.BindView;

/**
 * Created by hcc on 16/8/22 21:40
 * 100332338@qq.com
 * <p/>
 * 主界面关注界面
 * 该界面由于需要请求登录用户的关注数据
 * 所以这里只能用假数据让界面好看点
 */
public class HomeAttentionFragment extends RxLazyFragment
{

    @BindView(R.id.recycle)
    RecyclerView mRecyclerView;

    private List<AttentionBangumi> attentionBangumis;

    private List<AttentionDynamic> attentionDynamics;

    private HeaderViewRecyclerAdapter mHeaderViewRecyclerAdapter;

    public static HomeAttentionFragment newIntance()
    {

        return new HomeAttentionFragment();
    }

    @Override
    public int getLayoutResId()
    {

        return R.layout.fragment_attention;
    }

    @Override
    public void finishCreateView(Bundle state)
    {

        loadData();
    }

    @Override
    protected void loadData()
    {

        AttentionContents mAttentionContents = new AttentionContents();
        attentionBangumis = mAttentionContents.fillBangumiData();
        attentionDynamics = mAttentionContents.fillDynamicData();
        initRecyclerView();
    }

    @Override
    protected void initRecyclerView()
    {

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        AttentionDynamicAdapter mAdapter = new AttentionDynamicAdapter(mRecyclerView, attentionDynamics);
        mHeaderViewRecyclerAdapter = new HeaderViewRecyclerAdapter(mAdapter);
        createHeadView();
        mRecyclerView.setAdapter(mHeaderViewRecyclerAdapter);
    }

    private void createHeadView()
    {

        View headView = LayoutInflater.from(getActivity()).inflate(R.layout.layout_attention_head_view, mRecyclerView, false);
        RecyclerView mBangumiRecycler = (RecyclerView) headView.findViewById(R.id.focus_head_recycler);
        mBangumiRecycler.setHasFixedSize(false);
        mBangumiRecycler.setNestedScrollingEnabled(false);
        mBangumiRecycler.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        mBangumiRecycler.setAdapter(new AttentionBangumiAdapter(mBangumiRecycler, attentionBangumis));
        mHeaderViewRecyclerAdapter.addHeaderView(headView);
    }
}
