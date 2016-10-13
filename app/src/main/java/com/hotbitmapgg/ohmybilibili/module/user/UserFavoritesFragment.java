package com.hotbitmapgg.ohmybilibili.module.user;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.adapter.UserFavoritesAdapter;
import com.hotbitmapgg.ohmybilibili.base.RxLazyFragment;
import com.hotbitmapgg.ohmybilibili.entity.user.UserFavoritesInfo;
import com.hotbitmapgg.ohmybilibili.network.RetrofitHelper;
import com.hotbitmapgg.ohmybilibili.rx.RxBus;
import com.hotbitmapgg.ohmybilibili.utils.ConstantUtils;
import com.hotbitmapgg.ohmybilibili.widget.CustomEmptyView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by hcc on 2016/10/12 18:13
 * 100332338@qq.com
 * <p>
 * 用户详情界面的收藏夹
 */

public class UserFavoritesFragment extends RxLazyFragment
{

    @Bind(R.id.recycle)
    RecyclerView mRecyclerView;

    @Bind(R.id.empty_view)
    CustomEmptyView mCustomEmptyView;

    private int mid;

    private int count;

    private static final String EXTRA_MID = "extra_mid";

    private List<UserFavoritesInfo.DataBean> userFavorites = new ArrayList<>();

    private UserFavoritesAdapter mAdapter;

    public static UserFavoritesFragment newInstance(int mid)
    {

        UserFavoritesFragment mFragment = new UserFavoritesFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(EXTRA_MID, mid);
        mFragment.setArguments(bundle);
        return mFragment;
    }

    @Override
    public int getLayoutResId()
    {

        return R.layout.fragment_user_favorites;
    }

    @Override
    public void finishCreateView(Bundle state)
    {

        mid = getArguments().getInt(EXTRA_MID);

        initRecyclerView();
        getUserFavorites();
    }

    private void initRecyclerView()
    {

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        mAdapter = new UserFavoritesAdapter(mRecyclerView, userFavorites);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void getUserFavorites()
    {

        RetrofitHelper.getUserFavoritesApi()
                .getUserFavorites(mid)
                .compose(bindToLifecycle())
                .map(UserFavoritesInfo::getData)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(dataBeans -> {
                    count = dataBeans.size();
                    userFavorites.addAll(dataBeans);
                    finishTask();
                }, throwable -> {
                    initEmptyLayout();
                });
    }

    private void finishTask()
    {

        postCount();
        mAdapter.notifyDataSetChanged();
        if (userFavorites.isEmpty())
            initEmptyLayout();
    }

    private void postCount()
    {

        Bundle bundle = new Bundle();
        bundle.putString(ConstantUtils.EXTRA_TYPE, ConstantUtils.USER_FAVORITES);
        bundle.putInt(ConstantUtils.EXTRA_COUNT, count);
        RxBus.getInstance().post(bundle);
    }

    private void initEmptyLayout()
    {

        mCustomEmptyView.setEmptyImage(R.drawable.img_tips_error_space_no_data);
        mCustomEmptyView.setEmptyText("ㄟ( ▔, ▔ )ㄏ 再怎么找也没有啦");
        mCustomEmptyView.hideReloadButton();
    }
}
