package com.hotbitmapgg.ohmybilibili.module.user;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.adapter.UserPlayGameAdapter;
import com.hotbitmapgg.ohmybilibili.base.RxLazyFragment;
import com.hotbitmapgg.ohmybilibili.entity.user.UserPlayGameInfo;
import com.hotbitmapgg.ohmybilibili.network.RetrofitHelper;
import com.hotbitmapgg.ohmybilibili.widget.CustomEmptyView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by hcc on 2016/10/12 18:19
 * 100332338@qq.com
 * <p>
 * 用户详情界面的游戏
 */

public class UserPlayGameFragment extends RxLazyFragment
{

    @Bind(R.id.recycle)
    RecyclerView mRecyclerView;

    @Bind(R.id.empty_view)
    CustomEmptyView mCustomEmptyView;

    private int mid;

    private static final String EXTRA_MID = "extra_mid";

    private List<UserPlayGameInfo.DataBean.GamesBean> games = new ArrayList<>();

    private UserPlayGameAdapter mAdapter;

    public static UserPlayGameFragment newInstance(int mid)
    {

        UserPlayGameFragment mFragment = new UserPlayGameFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(EXTRA_MID, mid);
        mFragment.setArguments(bundle);
        return mFragment;
    }


    @Override
    public int getLayoutResId()
    {

        return R.layout.fragment_user_play_game;
    }

    @Override
    public void finishCreateView(Bundle state)
    {

        mid = getArguments().getInt(EXTRA_MID);

        initRecyclerView();
        getUserPlayGames();
    }

    private void initRecyclerView()
    {

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter = new UserPlayGameAdapter(mRecyclerView, games);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void getUserPlayGames()
    {

        RetrofitHelper.getUserPlayGameApi()
                .getUserPlayGames(mid)
                .compose(bindToLifecycle())
                .map(userPlayGameInfo -> userPlayGameInfo.getData().getGames())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(gameBeans -> {

                    games.addAll(gameBeans);
                    finishTask();
                }, throwable -> {
                    initEmptyLayout();
                });
    }

    private void finishTask()
    {

        mAdapter.notifyDataSetChanged();
        if (games.isEmpty())
            initEmptyLayout();
    }

    private void initEmptyLayout()
    {

        mCustomEmptyView.setEmptyImage(R.drawable.img_tips_error_space_no_data);
        mCustomEmptyView.setEmptyText("ㄟ( ▔, ▔ )ㄏ 再怎么找也没有啦");
        mCustomEmptyView.hideReloadButton();
    }
}
