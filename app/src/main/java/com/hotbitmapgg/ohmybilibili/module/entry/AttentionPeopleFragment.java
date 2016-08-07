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
 * 关注的人
 */
public class AttentionPeopleFragment extends RxLazyFragment
{

    @Bind(R.id.empty_view)
    EmptyView mEmptyView;

    public static AttentionPeopleFragment newInstance()
    {

        return new AttentionPeopleFragment();
    }

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
