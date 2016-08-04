package com.hotbitmapgg.ohmybilibili.module.entry;

import android.os.Bundle;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.base.RxLazyFragment;
import com.hotbitmapgg.ohmybilibili.widget.EmptyView;

import butterknife.Bind;

/**
 * 关注的人
 * 没有Api进行调用
 *
 * @HotBitmapGG
 */
public class AttentionPeopleFragment extends RxLazyFragment
{

    @Bind(R.id.empty_view)
    EmptyView mEmptyView;

    @Override
    public int getLayoutResId()
    {

        return R.layout.fragment_attention;
    }

    @Override
    public void finishCreateView(Bundle state)
    {

        mEmptyView.setEmptyImage(R.drawable.img_tips_error_no_following_person);
        mEmptyView.setEmptyText("你还没有关注的人哟");
    }
}
