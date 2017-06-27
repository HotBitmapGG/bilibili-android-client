package com.hotbitmapgg.bilibili.module.home.region;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;
import com.hotbitmapgg.bilibili.adapter.HomeRegionItemAdapter;
import com.hotbitmapgg.bilibili.base.RxLazyFragment;
import com.hotbitmapgg.bilibili.entity.region.RegionTypesInfo;
import com.hotbitmapgg.bilibili.module.entry.GameCentreActivity;
import com.hotbitmapgg.ohmybilibili.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by hcc on 16/8/4 21:18
 * 100332338@qq.com
 * <p/>
 * 首页分区界面
 */
public class HomeRegionFragment extends RxLazyFragment {
    @BindView(R.id.recycle)
    RecyclerView mRecyclerView;

    private List<RegionTypesInfo.DataBean> regionTypes = new ArrayList<>();

    public static HomeRegionFragment newInstance() {
        return new HomeRegionFragment();
    }

    @Override
    public
    @LayoutRes
    int getLayoutResId() {
        return R.layout.fragment_home_region;
    }


    @Override
    public void finishCreateView(Bundle state) {
        loadData();
        initRecyclerView();
    }

    @Override
    protected void loadData() {
        Observable.just(readAssetsJson())
                .compose(bindToLifecycle())
                .map(s -> new Gson().fromJson(s, RegionTypesInfo.class))
                .map(RegionTypesInfo::getData)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(dataBeans -> {
                    regionTypes.addAll(dataBeans);
                    finishTask();
                }, throwable -> {
                });
    }


    /**
     * 读取assets下的json数据
     */
    private String readAssetsJson() {
        AssetManager assetManager = getActivity().getAssets();
        try {
            InputStream is = assetManager.open("region.json");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            StringBuilder stringBuilder = new StringBuilder();
            String str;
            while ((str = br.readLine()) != null) {
                stringBuilder.append(str);
            }
            return stringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


    @Override
    protected void initRecyclerView() {
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        HomeRegionItemAdapter mAdapter = new HomeRegionItemAdapter(mRecyclerView);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener((position, holder) -> {
            switch (position) {
                case 0:
                    //直播
                    startActivity(new Intent(getActivity(), LiveAppIndexActivity.class));
                    break;
                case 1:
                    //番剧
                    RegionTypesInfo.DataBean mBangumi = regionTypes.get(1);
                    RegionTypeDetailsActivity.launch(getActivity(), mBangumi);
                    break;
                case 2:
                    //动画
                    RegionTypesInfo.DataBean mAnimation = regionTypes.get(2);
                    RegionTypeDetailsActivity.launch(getActivity(), mAnimation);
                    break;
                case 3:
                    //音乐
                    RegionTypesInfo.DataBean mMuise = regionTypes.get(3);
                    RegionTypeDetailsActivity.launch(getActivity(), mMuise);
                    break;
                case 4:
                    //舞蹈
                    RegionTypesInfo.DataBean mDence = regionTypes.get(4);
                    RegionTypeDetailsActivity.launch(getActivity(), mDence);
                    break;
                case 5:
                    //游戏
                    RegionTypesInfo.DataBean mGame = regionTypes.get(5);
                    RegionTypeDetailsActivity.launch(getActivity(), mGame);
                    break;
                case 6:
                    //科技
                    RegionTypesInfo.DataBean mScience = regionTypes.get(6);
                    RegionTypeDetailsActivity.launch(getActivity(), mScience);
                    break;
                case 7:
                    //生活
                    RegionTypesInfo.DataBean mLife = regionTypes.get(7);
                    RegionTypeDetailsActivity.launch(getActivity(), mLife);
                    break;
                case 8:
                    //鬼畜
                    RegionTypesInfo.DataBean mKichiku = regionTypes.get(8);
                    RegionTypeDetailsActivity.launch(getActivity(), mKichiku);
                    break;
                case 9:
                    //时尚
                    RegionTypesInfo.DataBean mFashion = regionTypes.get(9);
                    RegionTypeDetailsActivity.launch(getActivity(), mFashion);
                    break;
                case 10:
                    //广告
                    startActivity(new Intent(getActivity(), AdvertisingActivity.class));
                    break;
                case 11:
                    //娱乐
                    RegionTypesInfo.DataBean mRecreation = regionTypes.get(10);
                    RegionTypeDetailsActivity.launch(getActivity(), mRecreation);
                    break;
                case 12:
                    //电影
                    RegionTypesInfo.DataBean mMovei = regionTypes.get(11);
                    RegionTypeDetailsActivity.launch(getActivity(), mMovei);
                    break;
                case 13:
                    //电视剧
                    RegionTypesInfo.DataBean mTv = regionTypes.get(12);
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
