package com.hotbitmapgg.ohmybilibili.module.home.discover;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.base.RxLazyFragment;
import com.hotbitmapgg.ohmybilibili.module.entry.GameCentreActivity;
import com.hotbitmapgg.ohmybilibili.module.search.TotalStationSearchActivity;
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

    @Bind(R.id.hide_scroll_view)
    NestedScrollView mScrollView;

    @Bind(R.id.hide_tags_layout)
    TagFlowLayout mHideTagLayout;

    @Bind(R.id.more_layout)
    LinearLayout mMoreLayout;

    @Bind(R.id.tv_more)
    TextView mMoreText;

    private boolean isShowMore = true;


    private List<String> tags = Arrays.asList(
            "釜山行", "极乐净土", "吃货木下",
            "麻雀", "玻璃芦苇", "re:从零开始的异世界生活",
            "守望先锋", "张继科"
    );


    private List<String> moreTags = Arrays.asList(
            "釜山行", "极乐净土", "吃货木下",
            "麻雀", "玻璃芦苇", "re:从零开始的异世界生活",
            "守望先锋", "张继科", "贤者之爱",
            "不可抗力", "逗鱼时刻", "抗韩中年人",
            "蜡笔小新", "刺客列传", "主播炸了", "熬厂长",
            "有喜欢的人", "主播真会玩", "亲爱的公主病", "起小点",
            "暴走大事件", "毫不保留的爱", "一年生", "你的名字", "谷阿莫",
            "云画的月光", "德云色", "美丽新世界", "老e", "snh48", "天天卡牌",
            "杨洋", "心有所属", "微微一笑很倾城", "隧道", "识汝不识丁", "马龙",
            "双程", "错生", "arashi", "火影忍者", "徐老师来巡山", "步步惊心丽",
            "日剧", "张继科丁宁", "马男波杰克", "akb48", "乔任梁", "阴阳师"
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

        mScrollView.setNestedScrollingEnabled(true);
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
            public View getView(FlowLayout parent, int position, final String s)
            {

                TextView mTags = (TextView) LayoutInflater.from(getActivity())
                        .inflate(R.layout.layout_tags_item, parent, false);
                mTags.setText(s);
                mTags.setOnClickListener(v -> TotalStationSearchActivity.launch(getActivity(), s));

                return mTags;
            }
        });


        mHideTagLayout.setAdapter(new TagAdapter<String>(moreTags)
        {

            @Override
            public View getView(FlowLayout parent, int position, final String s)
            {

                TextView mTags = (TextView) LayoutInflater.from(getActivity())
                        .inflate(R.layout.layout_tags_item, parent, false);
                mTags.setText(s);
                mTags.setOnClickListener(v -> TotalStationSearchActivity.launch(getActivity(), s));

                return mTags;
            }
        });
    }


    @OnClick(R.id.more_layout)
    void showAndHideMoreLayout()
    {

        if (isShowMore)
        {
            isShowMore = false;
            mScrollView.setVisibility(View.VISIBLE);
            mMoreText.setText("收起");
            mTagFlowLayout.setVisibility(View.GONE);
        } else
        {
            isShowMore = true;
            mScrollView.setVisibility(View.GONE);
            mMoreText.setText("查看更多");
            mTagFlowLayout.setVisibility(View.VISIBLE);
        }
    }


    @OnClick(R.id.layout_all_rank)
    void startAllRankActivity()
    {

        startActivity(new Intent(getActivity(), AllRankActivity.class));
    }

    @OnClick(R.id.layout_original)
    void startOriginalRankActivity()
    {

        startActivity(new Intent(getActivity(), OriginalRankActivity.class));
    }

    @OnClick(R.id.layout_game_center)
    void startGameCenterActivity()
    {

        startActivity(new Intent(getActivity(), GameCentreActivity.class));
    }

    @OnClick(R.id.card_view)
    void startSearchActivity()
    {

        startActivity(new Intent(getActivity(), TotalStationSearchActivity.class));
    }
}
