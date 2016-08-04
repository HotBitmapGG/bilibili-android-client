package com.hotbitmapgg.ohmybilibili.module.entry;

import android.os.Bundle;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.base.RxLazyFragment;
import com.hotbitmapgg.ohmybilibili.widget.EmptyView;

import butterknife.Bind;

/**
 * 消费记录
 * 没有Api进行调用
 *
 * @HotBitmapGG
 */
public class ConsumeHistoryFragment extends RxLazyFragment
{

    @Bind(R.id.empty_view)
    EmptyView mEmptyView;

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
