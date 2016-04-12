package com.hotbitmapgg.ohmybilibili.fragment;

import android.os.Bundle;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.widget.EmptyView;

/**
 * Created by hcc on 16/4/10 20:07
 * 100332338@qq.com
 * <p/>
 * 关注的人
 */
public class AttentionPeopleFragment extends LazyFragment
{

    @Override
    public int getLayoutResId()
    {

        return R.layout.fragment_attention;
    }

    @Override
    public void finishCreateView(Bundle state)
    {

        EmptyView mEmptyView = $(R.id.empty_view);
        mEmptyView.setEmptyImage(R.drawable.img_tips_error_no_following_person);
        mEmptyView.setEmptyText("你还没有关注的人哟");
    }
}
