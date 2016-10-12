package com.hotbitmapgg.ohmybilibili.module.user;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.adapter.UserCoinsVideoAdapter;
import com.hotbitmapgg.ohmybilibili.base.RxLazyFragment;
import com.hotbitmapgg.ohmybilibili.entity.user.UserCoinsInfo;
import com.hotbitmapgg.ohmybilibili.network.RetrofitHelper;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by hcc on 2016/10/12 18:18
 * 100332338@qq.com
 * <p>
 * 用户详情界面的投币
 */

public class UserCoinsVideoFragment extends RxLazyFragment
{

    @Bind(R.id.recycle)
    RecyclerView mRecyclerView;

    private int mid;

    private static final String EXTRA_MID = "extra_mid";

    private List<UserCoinsInfo.DataBean.ListBean> userCoins = new ArrayList<>();

    private UserCoinsVideoAdapter mAdapter;

    public static UserCoinsVideoFragment newInstance(int mid)
    {

        UserCoinsVideoFragment mFragment = new UserCoinsVideoFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(EXTRA_MID, mid);
        mFragment.setArguments(bundle);
        return mFragment;
    }

    @Override
    public int getLayoutResId()
    {

        return R.layout.fragment_user_coins;
    }

    @Override
    public void finishCreateView(Bundle state)
    {

        mid = getArguments().getInt(EXTRA_MID);

        initRecyclerView();
        getUserCoins();
    }

    private void initRecyclerView()
    {

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter = new UserCoinsVideoAdapter(mRecyclerView, userCoins);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void getUserCoins()
    {

        RetrofitHelper.getUserCoinsVideoApi()
                .getUserCoinVideos(mid)
                .compose(bindToLifecycle())
                .map(userCoinsInfo -> userCoinsInfo.getData().getList())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(listBeans -> {
                    userCoins.addAll(listBeans);
                    finishTask();
                }, throwable -> {

                });
    }

    private void finishTask()
    {

        mAdapter.notifyDataSetChanged();
    }
}
