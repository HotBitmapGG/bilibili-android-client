package com.hotbitmapgg.ohmybilibili.module.entry;

import android.os.Bundle;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.base.RxLazyFragment;
import com.hotbitmapgg.ohmybilibili.widget.CustomEmptyView;

import butterknife.Bind;

/**
 * Created by hcc on 16/8/7 14:12
 * 100332338@qq.com
 * <p/>
 * 我的收藏
 */
public class IFavoritesFragment extends RxLazyFragment
{

    @Bind(R.id.empty_view)
    CustomEmptyView mCustomEmptyView;

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

        mCustomEmptyView.setEmptyImage(R.drawable.img_tips_error_fav_no_data);
        mCustomEmptyView.setEmptyText("没有找到你的收藏哟");
        mCustomEmptyView.hideReloadButton();
    }

    @Override
    protected void lazyLoad()
    {

    }
}
