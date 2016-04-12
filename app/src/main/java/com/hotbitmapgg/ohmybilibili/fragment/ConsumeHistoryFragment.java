package com.hotbitmapgg.ohmybilibili.fragment;

import android.os.Bundle;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.widget.EmptyView;

/**
 * Created by hcc on 16/4/10 20:29
 * 100332338@qq.com
 *
 * 消费记录
 */
public class ConsumeHistoryFragment extends LazyFragment
{

    @Override
    public int getLayoutResId()
    {

        return R.layout.fragment_consume_history;
    }

    @Override
    public void finishCreateView(Bundle state)
    {
        EmptyView mEmptyView = $(R.id.empty_view);
        mEmptyView.setEmptyImage(R.drawable.ic_movie_pay_area_limit);
        mEmptyView.setEmptyText("你还没有消费记录哟");
    }
}
