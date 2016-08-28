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
 * 历史记录
 */
public class HistoryFragment extends RxLazyFragment
{

    @Bind(R.id.empty_view)
    CustomEmptyView mCustomEmptyView;

    public static HistoryFragment newInstance()
    {

        return new HistoryFragment();
    }

    @Override
    public int getLayoutResId()
    {

        return R.layout.fragment_empty;
    }

    @Override
    public void finishCreateView(Bundle state)
    {

        mCustomEmptyView.setEmptyImage(R.drawable.ic_movie_pay_order_error);
        mCustomEmptyView.setEmptyText("暂时还没有观看记录哟");
        mCustomEmptyView.hideReloadButton();
    }

    @Override
    protected void lazyLoad()
    {

    }
}
