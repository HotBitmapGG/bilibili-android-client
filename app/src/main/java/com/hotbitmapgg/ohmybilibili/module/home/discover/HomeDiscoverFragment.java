package com.hotbitmapgg.ohmybilibili.module.home.discover;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.base.RxLazyFragment;
import com.hotbitmapgg.ohmybilibili.module.entry.GameCentreActivity;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.Arrays;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by hcc on 16/8/4 21:18
 * 100332338@qq.com
 * <p/>
 * 首页发现界面
 */
public class HomeDiscoverFragment extends RxLazyFragment
{

    @Bind(R.id.tags_layout)
    TagFlowLayout mTagFlowLayout;

    private List<String> tags = Arrays.asList(
            "欢乐颂", "吃货木下", "极限挑战",
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

    @Override
    protected void lazyLoad()
    {

    }

    private void initTagLayout()
    {

        mTagFlowLayout.setAdapter(new TagAdapter<String>(tags)
        {

            @Override
            public View getView(FlowLayout parent, int position, String s)
            {

                TextView mTags = (TextView) LayoutInflater.from(getActivity())
                        .inflate(R.layout.layout_tags_item, parent, false);
                mTags.setText(s);

                return mTags;
            }
        });
    }


    @OnClick(R.id.layout_all_rank)
    void startAllRankActivity()
    {

        startActivity(new Intent(getActivity(), AllRankActivity.class));
    }

    @OnClick(R.id.layout_sort)
    void startSortRankActivity()
    {

    }

    @OnClick(R.id.layout_game_center)
    void startGameCenterActivity()
    {

        startActivity(new Intent(getActivity(), GameCentreActivity.class));
    }
}
