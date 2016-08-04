package com.hotbitmapgg.ohmybilibili.module.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.base.BaseHomeFragment;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.Arrays;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 首页-发现
 *
 * @HotBitmapGG
 */
public class HomeDiscoverFragment extends BaseHomeFragment
{

    @Bind(R.id.tags_layout)
    TagFlowLayout mTagFlowLayout;

    @Bind(R.id.ll_more)
    LinearLayout mMoreLayout;

    private List<String> tags = Arrays.asList("欢乐颂", "吃货木下", "极限挑战",
            "暴走大事件", "火星情报局", "在下扳本有何贵干",
            "重生之名流巨星", "papi酱", "报告老板",
            "火影忍者", "起小点", "徐老师来巡山",
            "奥巴马", "宋仲基", "snh48"
    );

    public static HomeDiscoverFragment newInstance()
    {

        return new HomeDiscoverFragment();
    }

    @Override
    public int getLayoutResId()
    {

        return R.layout.fragment_discover;
    }

    @Override
    public void finishCreateView(Bundle state)
    {

        initTagLayout();
    }

    private void initTagLayout()
    {

        mTagFlowLayout.setAdapter(new TagAdapter<String>(tags)
        {

            @Override
            public View getView(FlowLayout parent, int position, String s)
            {

                TextView mTags = (TextView) LayoutInflater.from(getActivity()).inflate(R.layout.tags_layout, parent, false);
                mTags.setText(s);

                return mTags;
            }
        });
    }

    @OnClick(R.id.ll_more)
    void locaMore()
    {

    }

    @Override
    public void scrollToTop()
    {

    }

    @Override
    public boolean canScrollVertically(int direction)
    {

        return false;
    }
}
