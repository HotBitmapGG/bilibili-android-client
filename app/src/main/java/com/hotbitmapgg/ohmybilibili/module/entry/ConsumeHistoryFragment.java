package com.hotbitmapgg.ohmybilibili.module.entry;

import android.os.Bundle;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.base.RxLazyFragment;
import com.hotbitmapgg.ohmybilibili.widget.EmptyView;

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
    EmptyView mEmptyView;

    public static ConsumeHistoryFragment newInstance()
    {

        return new ConsumeHistoryFragment();
    }

    @Override
    public int getLayoutResId()
    {

        return R.layout.fragment_consume_history;
    }

    @Override
    public void finishCreateView(Bundle state)
    {

        mEmptyView.setEmptyImage(R.drawable.ic_movie_pay_area_limit);
        mEmptyView.setEmptyText("你还没有消费记录哟");
    }
}
