package com.hotbitmapgg.ohmybilibili.module.entry;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.base.RxLazyFragment;
import com.hotbitmapgg.ohmybilibili.module.common.MainActivity;
import com.hotbitmapgg.ohmybilibili.widget.CustomEmptyView;

import butterknife.BindView;

/**
 * Created by hcc on 16/8/7 14:12
 * 100332338@qq.com
 * <p/>
 * 我的收藏
 */
public class IFavoritesFragment extends RxLazyFragment
{

    @BindView(R.id.empty_view)
    CustomEmptyView mCustomEmptyView;

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    public static IFavoritesFragment newInstance()
    {

        return new IFavoritesFragment();
    }

    @Override
    public int getLayoutResId()
    {

        return R.layout.fragment_empty;
    }

    @Override
    public void finishCreateView(Bundle state)
    {

        mToolbar.setTitle("我的收藏");
        mToolbar.setNavigationIcon(R.drawable.ic_navigation_drawer);
        mToolbar.setNavigationOnClickListener(v -> {

            Activity activity1 = getActivity();
            if (activity1 instanceof MainActivity)
                ((MainActivity) activity1).toggleDrawer();
        });

        mCustomEmptyView.setEmptyImage(R.drawable.img_tips_error_fav_no_data);
        mCustomEmptyView.setEmptyText("没有找到你的收藏哟");
    }
}
