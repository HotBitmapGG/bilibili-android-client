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
import com.hotbitmapgg.ohmybilibili.entity.attention.AttentionDynamicInfo;
import com.hotbitmapgg.ohmybilibili.entity.user.UserChaseBangumiInfo;
import com.hotbitmapgg.ohmybilibili.network.RetrofitHelper;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by hcc on 16/8/22 21:40
 * 100332338@qq.com
 * <p/>
 * 主界面关注界面
 */
public class HomeAttentionFragment extends RxLazyFragment
{

    @BindView(R.id.recycle)
    RecyclerView mRecyclerView;

    private static final int MID = 9467159;

    private HeaderViewRecyclerAdapter mHeaderViewRecyclerAdapter;

    private List<UserChaseBangumiInfo.DataBean.ResultBean> chaseBangumis = new ArrayList<>();

    private List<AttentionDynamicInfo.DataBean.FeedsBean> dynamics = new ArrayList<>();

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

        RetrofitHelper.getUserChaseBangumiApi()
                .getUserChaseBangumis(MID)
                .compose(bindToLifecycle())
                .map(userChaseBangumiInfo -> userChaseBangumiInfo.getData().getResult())
                .flatMap(new Func1<List<UserChaseBangumiInfo.DataBean.ResultBean>,Observable<AttentionDynamicInfo>>()
                {

                    @Override
                    public Observable<AttentionDynamicInfo> call(List<UserChaseBangumiInfo.DataBean.ResultBean> resultBeans)
                    {

                        chaseBangumis.addAll(resultBeans);
                        return RetrofitHelper.getAttentionDynamicApi().getAttentionDynamic();
                    }
                })
                .map(attentionDynamicInfo -> attentionDynamicInfo.getData().getFeeds())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(feedsBeans -> {

                    dynamics.addAll(feedsBeans);
                    finishTask();
                }, throwable -> {

                });
    }

    @Override
    protected void finishTask()
    {

        initRecyclerView();
    }

    @Override
    protected void initRecyclerView()
    {

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        AttentionDynamicAdapter mAdapter = new AttentionDynamicAdapter(mRecyclerView, dynamics);
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
        mBangumiRecycler.setAdapter(new AttentionBangumiAdapter(mBangumiRecycler, chaseBangumis));
        mHeaderViewRecyclerAdapter.addHeaderView(headView);
    }
}
