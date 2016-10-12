package com.hotbitmapgg.ohmybilibili.module.user;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.adapter.UserChaseBangumiAdapter;
import com.hotbitmapgg.ohmybilibili.base.RxLazyFragment;
import com.hotbitmapgg.ohmybilibili.entity.user.UserChaseBangumiInfo;
import com.hotbitmapgg.ohmybilibili.network.RetrofitHelper;
import com.hotbitmapgg.ohmybilibili.widget.CustomEmptyView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by hcc on 2016/10/12 18:16
 * 100332338@qq.com
 * <p>
 * 用户详情界面的追番
 */

public class UserChaseBangumiFragment extends RxLazyFragment
{

    @Bind(R.id.recycle)
    RecyclerView mRecyclerView;

    @Bind(R.id.empty_view)
    CustomEmptyView mCustomEmptyView;

    private int mid;

    private static final String EXTRA_MID = "extra_mid";

    private List<UserChaseBangumiInfo.DataBean.ResultBean> userChaseBangumis = new ArrayList<>();

    private UserChaseBangumiAdapter mAdapter;

    public static UserChaseBangumiFragment newInstance(int mid)
    {

        UserChaseBangumiFragment mFragment = new UserChaseBangumiFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(EXTRA_MID, mid);
        mFragment.setArguments(bundle);
        return mFragment;
    }

    @Override
    public int getLayoutResId()
    {

        return R.layout.fragment_user_chase_bangumi;
    }

    @Override
    public void finishCreateView(Bundle state)
    {

        mid = getArguments().getInt(EXTRA_MID);

        initRecyclerView();
        getUserChaseBangumis();
    }

    private void initRecyclerView()
    {

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        mAdapter = new UserChaseBangumiAdapter(mRecyclerView, userChaseBangumis);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void getUserChaseBangumis()
    {

        RetrofitHelper.getUserChaseBangumiApi()
                .getUserChaseBangumis(mid)
                .compose(bindToLifecycle())
                .map(userChaseBangumiInfo -> userChaseBangumiInfo.getData().getResult())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(resultBeans -> {

                    userChaseBangumis.addAll(resultBeans);
                    finishTask();
                }, throwable -> {
                    initEmptyLayout();
                });
    }

    private void finishTask()
    {

        mAdapter.notifyDataSetChanged();
        if (userChaseBangumis.isEmpty())
            initEmptyLayout();
    }

    private void initEmptyLayout()
    {

        mCustomEmptyView.setEmptyImage(R.drawable.img_tips_error_space_no_data);
        mCustomEmptyView.setEmptyText("ㄟ( ▔, ▔ )ㄏ 再怎么找也没有啦");
        mCustomEmptyView.hideReloadButton();
    }
}
