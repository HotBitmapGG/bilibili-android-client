package com.hotbitmapgg.ohmybilibili.fragment;

import android.os.Bundle;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.widget.EmptyView;

/**
 * Created by hcc on 16/4/10 20:07
 * 100332338@qq.com
 * <p/>
 * 历史记录
 */
public class HistoryFragment extends LazyFragment
{

    @Override
    public int getLayoutResId()
    {

        return R.layout.fragment_history;
    }

    @Override
    public void finishCreateView(Bundle state)
    {

        EmptyView mEmptyView = $(R.id.empty_view);
        mEmptyView.setEmptyImage(R.drawable.ic_movie_pay_order_error);
        mEmptyView.setEmptyText("暂时还没有观看记录哟");
    }
}
