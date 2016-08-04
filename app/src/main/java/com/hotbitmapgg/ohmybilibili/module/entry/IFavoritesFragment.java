package com.hotbitmapgg.ohmybilibili.module.entry;

import android.os.Bundle;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.base.RxLazyFragment;
import com.hotbitmapgg.ohmybilibili.widget.EmptyView;

import butterknife.Bind;

/**
 * 我的收藏
 * 没有Api进行调用
 *
 * @HotBitmapGG
 */
public class IFavoritesFragment extends RxLazyFragment
{

    @Bind(R.id.empty_view)
    EmptyView mEmptyView;

    @Override
    public int getLayoutResId()
    {

        return R.layout.fragment_ifav;
    }

    @Override
    public void finishCreateView(Bundle state)
    {

        mEmptyView.setEmptyImage(R.drawable.img_tips_error_fav_no_data);
        mEmptyView.setEmptyText("没有找到你的收藏哟");
    }
}
