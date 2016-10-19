package com.hotbitmapgg.ohmybilibili.module.home.focus;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.adapter.FocusOnBangumiAdapter;
import com.hotbitmapgg.ohmybilibili.adapter.FocusOnDynamicAdapter;
import com.hotbitmapgg.ohmybilibili.adapter.helper.HeaderViewRecyclerAdapter;
import com.hotbitmapgg.ohmybilibili.base.RxLazyFragment;
import com.hotbitmapgg.ohmybilibili.entity.focus.FocusOnBangumi;
import com.hotbitmapgg.ohmybilibili.entity.focus.FocusOnContents;
import com.hotbitmapgg.ohmybilibili.entity.focus.FocusOnDynamic;

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
public class HomeFocusFragment extends RxLazyFragment
{

    @BindView(R.id.recycle)
    RecyclerView mRecyclerView;

    private List<FocusOnBangumi> focusOnBangumis;

    private List<FocusOnDynamic> focusOnDynamics;

    private HeaderViewRecyclerAdapter mHeaderViewRecyclerAdapter;

    public static HomeFocusFragment newIntance()
    {

        return new HomeFocusFragment();
    }

    @Override
    public int getLayoutResId()
    {

        return R.layout.fragment_focus;
    }

    @Override
    public void finishCreateView(Bundle state)
    {

        loadData();
    }

    @Override
    protected void loadData()
    {

        FocusOnContents mFocusOnContents = new FocusOnContents();
        focusOnBangumis = mFocusOnContents.fillBangumiData();
        focusOnDynamics = mFocusOnContents.fillDynamicData();
        initRecyclerView();
    }

    @Override
    protected void initRecyclerView()
    {

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        FocusOnDynamicAdapter mAdapter = new FocusOnDynamicAdapter(mRecyclerView, focusOnDynamics);
        mHeaderViewRecyclerAdapter = new HeaderViewRecyclerAdapter(mAdapter);
        createHeadView();
        mRecyclerView.setAdapter(mHeaderViewRecyclerAdapter);
    }

    private void createHeadView()
    {

        View headView = LayoutInflater.from(getActivity()).inflate(R.layout.layout_focus_head_view, mRecyclerView, false);
        RecyclerView mBangumiRecycler = (RecyclerView) headView.findViewById(R.id.focus_head_recycler);
        mBangumiRecycler.setHasFixedSize(false);
        mBangumiRecycler.setNestedScrollingEnabled(false);
        mBangumiRecycler.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        mBangumiRecycler.setAdapter(new FocusOnBangumiAdapter(mBangumiRecycler, focusOnBangumis));
        mHeaderViewRecyclerAdapter.addHeaderView(headView);
    }
}
