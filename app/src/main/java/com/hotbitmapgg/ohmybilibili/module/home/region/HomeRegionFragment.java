package com.hotbitmapgg.ohmybilibili.module.home.region;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.hotbitmapgg.ohmybilibili.BilibiliApp;
import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.adapter.HomeRegionItemAdapter;
import com.hotbitmapgg.ohmybilibili.base.RxLazyFragment;
import com.hotbitmapgg.ohmybilibili.entity.region.RegionTypesInfo;
import com.hotbitmapgg.ohmybilibili.module.entry.GameCentreActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by hcc on 16/8/4 21:18
 * 100332338@qq.com
 * <p/>
 * 首页分区界面
 */
public class HomeRegionFragment extends RxLazyFragment
{

    @BindView(R.id.recycle)
    RecyclerView mRecyclerView;

    private List<RegionTypesInfo.DataBean> datas = new ArrayList<>();

    public static HomeRegionFragment newInstance()
    {

        return new HomeRegionFragment();
    }

    @Override
    public
    @LayoutRes
    int getLayoutResId()
    {

        return R.layout.fragment_home_region;
    }

    @Override
    public void finishCreateView(Bundle state)
    {

        loadData();
        initRecyclerView();
    }

    @Override
    protected void loadData()
    {

        BilibiliApp.getInstance()
                .getRepository()
                .getPartitionTypes(false)
                .compose(bindToLifecycle())
                .map(partitionInfoReply -> partitionInfoReply.getData().getData())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(dataBeans -> {
                    datas.addAll(dataBeans);
                }, throwable -> {

                });
    }

    @Override
    protected void initRecyclerView()
    {

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        HomeRegionItemAdapter mAdapter = new HomeRegionItemAdapter(mRecyclerView);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener((position, holder) -> {

            switch (position)
            {
                case 0:
                    //直播
                    startActivity(new Intent(getActivity(), LiveAppIndexActivity.class));
                    break;

                case 1:
                    //番剧
                    RegionTypesInfo.DataBean mBangumi = datas.get(1);
                    if (mBangumi != null)
                        RegionTypeDetailsActivity.launch(getActivity(), mBangumi);
                    break;

                case 2:
                    //动画
                    RegionTypesInfo.DataBean mAnimation = datas.get(2);
                    if (mAnimation != null)
                        RegionTypeDetailsActivity.launch(getActivity(), mAnimation);
                    break;

                case 3:
                    //音乐
                    RegionTypesInfo.DataBean mMuise = datas.get(3);
                    if (mMuise != null)
                        RegionTypeDetailsActivity.launch(getActivity(), mMuise);
                    break;

                case 4:
                    //舞蹈
                    RegionTypesInfo.DataBean mDence = datas.get(4);
                    if (mDence != null)
                        RegionTypeDetailsActivity.launch(getActivity(), mDence);
                    break;

                case 5:
                    //游戏
                    RegionTypesInfo.DataBean mGame = datas.get(5);
                    RegionTypeDetailsActivity.launch(getActivity(), mGame);
                    break;

                case 6:
                    //科技
                    RegionTypesInfo.DataBean mScience = datas.get(6);
                    RegionTypeDetailsActivity.launch(getActivity(), mScience);
                    break;

                case 7:
                    //生活
                    RegionTypesInfo.DataBean mLife = datas.get(7);
                    if (mLife != null)
                        RegionTypeDetailsActivity.launch(getActivity(), mLife);
                    break;

                case 8:
                    //鬼畜
                    RegionTypesInfo.DataBean mKichiku = datas.get(8);
                    if (mKichiku != null)
                        RegionTypeDetailsActivity.launch(getActivity(), mKichiku);
                    break;

                case 9:
                    //时尚
                    RegionTypesInfo.DataBean mFashion = datas.get(9);
                    if (mFashion != null)
                        RegionTypeDetailsActivity.launch(getActivity(), mFashion);
                    break;

                case 10:
                    //广告
                    break;

                case 11:
                    //娱乐
                    RegionTypesInfo.DataBean mRecreation = datas.get(10);
                    if (mRecreation != null)
                        RegionTypeDetailsActivity.launch(getActivity(), mRecreation);
                    break;


                case 12:
                    //电影
                    RegionTypesInfo.DataBean mMovei = datas.get(11);
                    if (mMovei != null)
                        RegionTypeDetailsActivity.launch(getActivity(), mMovei);
                    break;

                case 13:
                    //电视剧
                    RegionTypesInfo.DataBean mTv = datas.get(12);
                    if (mTv != null)
                        RegionTypeDetailsActivity.launch(getActivity(), mTv);
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
