package com.hotbitmapgg.ohmybilibili.module.user;

import android.os.Bundle;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.base.RxLazyFragment;

/**
 * Created by hcc on 2016/10/12 13:29
 * 100332338@qq.com
 * <p>
 * 用户详情界面的主页
 */

public class UserHomePageFragment extends RxLazyFragment
{


    public static UserHomePageFragment newInstance()
    {

        return new UserHomePageFragment();
    }

    @Override
    public int getLayoutResId()
    {

        return R.layout.fragment_user_home_page;
    }

    @Override
    public void finishCreateView(Bundle state)
    {

    }
}
