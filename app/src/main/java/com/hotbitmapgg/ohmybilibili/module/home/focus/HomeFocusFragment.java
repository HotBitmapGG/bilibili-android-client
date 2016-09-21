package com.hotbitmapgg.ohmybilibili.module.home.focus;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.base.RxLazyFragment;
import com.hotbitmapgg.ohmybilibili.widget.CustomEmptyView;

import butterknife.Bind;

/**
 * Created by hcc on 16/8/22 21:40
 * 100332338@qq.com
 * <p/>
 * 主界面关注界面
 * 该界面由于需要请求登录用户的关注数据
 * 所以这里只能用假数据让界面好看点
 */
public class HomeFocusFragment extends RxLazyFragment
{

    @Bind(R.id.empty_view)
    CustomEmptyView mCustomEmptyView;

    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    public static HomeFocusFragment newIntance()
    {

        return new HomeFocusFragment();
    }

    @Override
    public int getLayoutResId()
    {

        return R.layout.fragment_empty;
    }

    @Override
    public void finishCreateView(Bundle state)
    {

        mToolbar.setVisibility(View.GONE);

        mCustomEmptyView.setEmptyImage(R.drawable.img_tips_error_space_no_data);
        mCustomEmptyView.setEmptyText("没有关注的数据（╯－＿－）╯");
        mCustomEmptyView.hideReloadButton();
    }

    @Override
    protected void lazyLoad()
    {

    }
}
