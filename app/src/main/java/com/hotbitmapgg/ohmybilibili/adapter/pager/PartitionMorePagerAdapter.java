package com.hotbitmapgg.ohmybilibili.adapter.pager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.hotbitmapgg.ohmybilibili.entity.region.PartitionInfo;
import com.hotbitmapgg.ohmybilibili.module.home.region.PartitionDetailsFragment;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;

/**
 * Created by hcc on 16/8/4 14:12
 * 100332338@qq.com
 * <p/>
 * 分区界面PagerAdapter
 */
public class PartitionMorePagerAdapter extends FragmentStatePagerAdapter
{

    private List<PartitionInfo.DataBean.ChildrenBean> childrens;

    private List<Fragment> fragments = new ArrayList<>();

    public PartitionMorePagerAdapter(FragmentManager fm, List<PartitionInfo.DataBean.ChildrenBean> childrens)
    {

        super(fm);
        this.childrens = childrens;
        initFragments();
    }

    private void initFragments()
    {

        Observable.from(childrens)
                .subscribe(childrenBean -> {
                    fragments.add(PartitionDetailsFragment.
                            newInstance(String.valueOf(childrenBean.getTid())));
                });
    }

    @Override
    public Fragment getItem(int position)
    {


        return fragments.get(position);
    }

    @Override
    public int getCount()
    {
        return childrens.size();
    }

    @Override
    public CharSequence getPageTitle(int position)
    {

        return childrens.get(position).getName();
    }
}
