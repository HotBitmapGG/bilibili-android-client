package com.hotbitmapgg.ohmybilibili.module.user;

import android.os.Bundle;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.base.RxLazyFragment;

/**
 * Created by hcc on 2016/10/12 18:13
 * 100332338@qq.com
 * <p>
 * 用户详情界面的收藏夹
 */

public class UserFavoritesFragment extends RxLazyFragment
{

    private int mid;

    private static final String EXTRA_MID = "extra_mid";

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
    }
}
