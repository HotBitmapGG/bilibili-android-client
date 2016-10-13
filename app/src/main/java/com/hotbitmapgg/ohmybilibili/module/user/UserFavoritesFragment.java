package com.hotbitmapgg.ohmybilibili.module.user;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.adapter.UserFavoritesAdapter;
import com.hotbitmapgg.ohmybilibili.base.RxLazyFragment;
import com.hotbitmapgg.ohmybilibili.entity.user.UserFavoritesInfo;
import com.hotbitmapgg.ohmybilibili.utils.ConstantUtils;
import com.hotbitmapgg.ohmybilibili.widget.CustomEmptyView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

import static com.hotbitmapgg.ohmybilibili.utils.ConstantUtils.EXTRA_DATA;

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

    private List<UserFavoritesInfo.DataBean> userFavorites = new ArrayList<>();

    private UserFavoritesInfo userFavoritesInfo;

    public static UserFavoritesFragment newInstance(UserFavoritesInfo userFavoritesInfo)
    {

        UserFavoritesFragment mFragment = new UserFavoritesFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(ConstantUtils.EXTRA_DATA, userFavoritesInfo);
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

        userFavoritesInfo = getArguments().getParcelable(EXTRA_DATA);
        initRecyclerView();
    }

    private void initRecyclerView()
    {

        userFavorites.addAll(userFavoritesInfo.getData());
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        UserFavoritesAdapter mAdapter = new UserFavoritesAdapter(mRecyclerView, userFavorites);
        mRecyclerView.setAdapter(mAdapter);
        if (userFavorites.isEmpty())
            initEmptyLayout();
    }


    private void initEmptyLayout()
    {

        mCustomEmptyView.setEmptyImage(R.drawable.img_tips_error_space_no_data);
        mCustomEmptyView.setEmptyText("ㄟ( ▔, ▔ )ㄏ 再怎么找也没有啦");
        mCustomEmptyView.hideReloadButton();
    }
}
