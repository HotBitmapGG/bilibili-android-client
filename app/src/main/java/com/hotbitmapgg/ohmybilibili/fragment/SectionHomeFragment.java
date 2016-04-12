package com.hotbitmapgg.ohmybilibili.fragment;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.flyco.tablayout.SlidingTabLayout;
import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.adapter.HomePagerAdapter;
import com.hotbitmapgg.ohmybilibili.api.IndexApi;
import com.hotbitmapgg.ohmybilibili.model.BasicMessage;
import com.hotbitmapgg.ohmybilibili.model.Index;
import com.hotbitmapgg.ohmybilibili.utils.LogUtil;

/**
 * Home主页
 *
 * @author Administrator
 * @HotBitmapGG
 */
public class SectionHomeFragment extends LazyFragment
{

    private ViewPager mTabPager;

    private HomePagerAdapter mHomeAdapter;

    private SlidingTabLayout mSlidingTab;

    private Index mIndexData;


    @Override
    public int getLayoutResId()
    {

        return R.layout.fragment_home_sprout;
    }

    @SuppressLint({"NewApi", "ClickableViewAccessibility"})
    @Override
    public void finishCreateView(Bundle state)
    {

        mTabPager = $(R.id.tab_pager);
        mSlidingTab = $(R.id.sliding_tabs);
        mHomeAdapter = new HomePagerAdapter(getChildFragmentManager(), getApplicationContext());
        mTabPager.setAdapter(mHomeAdapter);
        mSlidingTab.setViewPager(mTabPager);


        new IndexGetTask().execute();
    }


    public Index getIndexData()
    {

        return this.mIndexData;
    }


    private class IndexGetTask extends AsyncTask<Void,Void,BasicMessage<Index>>
    {

        @Override
        protected BasicMessage<Index> doInBackground(Void... params)
        {

            return IndexApi.getIndex();
        }

        @Override
        protected void onPostExecute(BasicMessage<Index> msg)
        {

            if (msg != null && msg.getCode() == BasicMessage.CODE_SUCCEED)
            {
                mIndexData = msg.getObject();
                mHomeAdapter.notifyIndexDataUpdateAll(mIndexData);
            } else
            {
                LogUtil.lsw("获取数据失败");
            }
        }
    }


    @Override
    public void onDestroy()
    {
        // TODO Auto-generated method stub
        super.onDestroy();
    }
}
