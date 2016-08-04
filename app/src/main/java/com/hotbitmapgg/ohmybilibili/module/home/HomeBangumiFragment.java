package com.hotbitmapgg.ohmybilibili.module.home;

import android.os.Bundle;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.base.BaseHomeFragment;

/**
 * Created by hcc on 16/8/4 21:18
 * 100332338@qq.com
 * <p/>
 * 首页番剧界面
 */
public class HomeBangumiFragment extends BaseHomeFragment
{

    public static HomeBangumiFragment newInstance()
    {

        return new HomeBangumiFragment();
    }

    @Override
    public int getLayoutResId()
    {

        return R.layout.fragment_home_bangumi;
    }

    @Override
    public void finishCreateView(Bundle state)
    {

    }

    @Override
    public void scrollToTop()
    {

    }

    @Override
    public boolean canScrollVertically(int direction)
    {

        return false;
    }
}
