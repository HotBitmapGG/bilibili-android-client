package com.hotbitmapgg.ohmybilibili.fragment;

import android.os.Bundle;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.widget.EmptyView;

/**
 * Created by hcc on 16/4/10 20:07
 * 100332338@qq.com
 * <p/>
 * 我的收藏
 */
public class IFavoritesFragment extends LazyFragment
{

    @Override
    public int getLayoutResId()
    {

        return R.layout.fragment_ifav;
    }

    @Override
    public void finishCreateView(Bundle state)
    {

        EmptyView mEmptyView = $(R.id.empty_view);
        mEmptyView.setEmptyImage(R.drawable.img_tips_error_fav_no_data);
        mEmptyView.setEmptyText("没有找到你的收藏哟");
    }
}
