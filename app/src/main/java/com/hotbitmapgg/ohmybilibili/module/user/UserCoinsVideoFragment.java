package com.hotbitmapgg.ohmybilibili.module.user;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.adapter.UserCoinsVideoAdapter;
import com.hotbitmapgg.ohmybilibili.base.RxLazyFragment;
import com.hotbitmapgg.ohmybilibili.entity.user.UserCoinsInfo;
import com.hotbitmapgg.ohmybilibili.module.video.VideoDetailsActivity;
import com.hotbitmapgg.ohmybilibili.utils.ConstantUtil;
import com.hotbitmapgg.ohmybilibili.widget.CustomEmptyView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

import static com.hotbitmapgg.ohmybilibili.utils.ConstantUtil.EXTRA_DATA;

/**
 * Created by hcc on 2016/10/12 18:18
 * 100332338@qq.com
 * <p>
 * 用户详情界面的投币
 */

public class UserCoinsVideoFragment extends RxLazyFragment
{

    @BindView(R.id.recycle)
    RecyclerView mRecyclerView;

    @BindView(R.id.empty_view)
    CustomEmptyView mCustomEmptyView;

    private List<UserCoinsInfo.DataBean.ListBean> userCoins = new ArrayList<>();

    private UserCoinsInfo userCoinsInfo;


    public static UserCoinsVideoFragment newInstance(UserCoinsInfo userCoinsInfo)
    {

        UserCoinsVideoFragment mFragment = new UserCoinsVideoFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(ConstantUtil.EXTRA_DATA, userCoinsInfo);
        mFragment.setArguments(bundle);
        return mFragment;
    }

    @Override
    public int getLayoutResId()
    {

        return R.layout.fragment_user_coins;
    }

    @Override
    public void finishCreateView(Bundle state)
    {

        userCoinsInfo = getArguments().getParcelable(EXTRA_DATA);
        initRecyclerView();
    }

    @Override
    protected void initRecyclerView()
    {

        userCoins.addAll(userCoinsInfo.getData().getList());
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        UserCoinsVideoAdapter mAdapter = new UserCoinsVideoAdapter(mRecyclerView, userCoins);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener((position, holder) -> VideoDetailsActivity.launch(getActivity(),
                userCoins.get(position).getAid(), userCoins.get(position).getPic()));
        if (userCoins.isEmpty())
            initEmptyLayout();
    }

    private void initEmptyLayout()
    {

        mCustomEmptyView.setEmptyImage(R.drawable.img_tips_error_space_no_data);
        mCustomEmptyView.setEmptyText("ㄟ( ▔, ▔ )ㄏ 再怎么找也没有啦");
    }
}
