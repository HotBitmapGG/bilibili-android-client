package com.hotbitmapgg.ohmybilibili.module.entry;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.base.RxLazyFragment;
import com.hotbitmapgg.ohmybilibili.module.common.MainActivity;
import com.hotbitmapgg.ohmybilibili.widget.CustomEmptyView;

import butterknife.Bind;

/**
 * Created by hcc on 16/8/7 14:12
 * 100332338@qq.com
 * <p/>
 * 消费记录
 */
public class ConsumeHistoryFragment extends RxLazyFragment
{

    @Bind(R.id.empty_view)
    CustomEmptyView mCustomEmptyView;

    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    public static ConsumeHistoryFragment newInstance()
    {

        return new ConsumeHistoryFragment();
    }

    @Override
    public int getLayoutResId()
    {

        return R.layout.fragment_empty;
    }

    @Override
    public void finishCreateView(Bundle state)
    {

        mToolbar.setTitle("消费记录");
        mToolbar.setNavigationIcon(R.drawable.ic_navigation_drawer);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {

                Activity activity = getActivity();
                if (activity instanceof MainActivity)
                    ((MainActivity) activity).toggleDrawer();
            }
        });

        mCustomEmptyView.setEmptyImage(R.drawable.ic_movie_pay_area_limit);
        mCustomEmptyView.setEmptyText("你还没有消费记录哟");
        mCustomEmptyView.hideReloadButton();
    }

    @Override
    protected void lazyLoad()
    {

    }
}
