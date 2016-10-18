package com.hotbitmapgg.ohmybilibili.module.home.partition;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.adapter.pager.HomePartitionLayoutAdapter;
import com.hotbitmapgg.ohmybilibili.base.RxLazyFragment;
import com.hotbitmapgg.ohmybilibili.entity.partition.PartitionInfo;
import com.hotbitmapgg.ohmybilibili.module.entry.GameCentreActivity;
import com.hotbitmapgg.ohmybilibili.network.RetrofitHelper;
import com.hotbitmapgg.ohmybilibili.widget.ExpandableHeightGridView;

import java.util.List;

import butterknife.Bind;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by hcc on 16/8/4 21:18
 * 100332338@qq.com
 * <p/>
 * 首页分区界面
 */
public class HomePartitionFragment extends RxLazyFragment
{

    @Bind(R.id.more_layout)
    ExpandableHeightGridView mMoreLayout;

    private List<PartitionInfo.DataBean> datas;

    public static HomePartitionFragment newInstance()
    {

        return new HomePartitionFragment();
    }

    @Override
    public
    @LayoutRes
    int getLayoutResId()
    {

        return R.layout.fragment_home_partition;
    }

    @Override
    public void finishCreateView(Bundle state)
    {

        loadData();
        initGridView();
    }

    @Override
    protected void loadData()
    {

        RetrofitHelper.getPartitionTypesApi()
                .getPartitionTypes()
                .compose(bindToLifecycle())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(partitionInfo -> {

                    datas = partitionInfo.getData();
                }, throwable -> {

                });
    }

    public void initGridView()
    {

        HomePartitionLayoutAdapter mAdapter = new HomePartitionLayoutAdapter(getActivity());
        mMoreLayout.setAdapter(mAdapter);
        mMoreLayout.setExpanded(true);
        mMoreLayout.setOnItemClickListener((parent, view, position, id) -> {

            switch (position)
            {
                case 0:
                    //直播
                    break;

                case 1:
                    //番剧
                    PartitionInfo.DataBean mBangumi = datas.get(1);
                    PartitionDetailsActivity.launch(getActivity(), mBangumi);
                    break;

                case 2:
                    //动画
                    PartitionInfo.DataBean mAnimation = datas.get(2);
                    PartitionDetailsActivity.launch(getActivity(), mAnimation);
                    break;

                case 3:
                    //音乐
                    PartitionInfo.DataBean mMuise = datas.get(3);
                    PartitionDetailsActivity.launch(getActivity(), mMuise);
                    break;

                case 4:
                    //舞蹈
                    PartitionInfo.DataBean mDence = datas.get(4);
                    PartitionDetailsActivity.launch(getActivity(), mDence);
                    break;

                case 5:
                    //游戏
                    PartitionInfo.DataBean mGame = datas.get(5);
                    PartitionDetailsActivity.launch(getActivity(), mGame);
                    break;

                case 6:
                    //科技
                    PartitionInfo.DataBean mScience = datas.get(6);
                    PartitionDetailsActivity.launch(getActivity(), mScience);
                    break;

                case 7:
                    //生活
                    PartitionInfo.DataBean mLife = datas.get(7);
                    PartitionDetailsActivity.launch(getActivity(), mLife);
                    break;

                case 8:
                    //鬼畜
                    PartitionInfo.DataBean mKichiku = datas.get(8);
                    PartitionDetailsActivity.launch(getActivity(), mKichiku);
                    break;

                case 9:
                    //时尚
                    PartitionInfo.DataBean mFashion = datas.get(9);
                    PartitionDetailsActivity.launch(getActivity(), mFashion);
                    break;

                case 10:
                    //广告

                    break;

                case 11:
                    //娱乐
                    PartitionInfo.DataBean mRecreation = datas.get(10);
                    PartitionDetailsActivity.launch(getActivity(), mRecreation);
                    break;


                case 12:
                    //电影
                    PartitionInfo.DataBean mMovei = datas.get(11);
                    PartitionDetailsActivity.launch(getActivity(), mMovei);
                    break;

                case 13:
                    //电视剧
                    PartitionInfo.DataBean mTv = datas.get(12);
                    PartitionDetailsActivity.launch(getActivity(), mTv);
                    break;


                case 14:
                    // 游戏中心
                    startActivity(new Intent(getActivity(), GameCentreActivity.class));
                    break;

                default:
                    break;
            }
        });
    }
}
