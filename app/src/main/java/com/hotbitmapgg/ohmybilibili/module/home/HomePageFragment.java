package com.hotbitmapgg.ohmybilibili.module.home;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.flyco.tablayout.SlidingTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.adapter.HomePagerAdapter;
import com.hotbitmapgg.ohmybilibili.base.RxLazyFragment;
import com.hotbitmapgg.ohmybilibili.module.common.MainActivity;
import com.hotbitmapgg.ohmybilibili.module.entry.GameCentreActivity;
import com.hotbitmapgg.ohmybilibili.module.entry.OffLineDownloadActivity;
import com.hotbitmapgg.ohmybilibili.module.search.TotalStationSearchActivity;
import com.hotbitmapgg.ohmybilibili.widget.CircleImageView;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by hcc on 16/8/4 21:18
 * 100332338@qq.com
 * <p/>
 * 首页模块主界面
 */
public class HomePageFragment extends RxLazyFragment
{

    @Bind(R.id.view_pager)
    ViewPager mViewPager;

    @Bind(R.id.sliding_tabs)
    SlidingTabLayout mSlidingTab;

    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    @Bind(R.id.search_view)
    MaterialSearchView mSearchView;

    @Bind(R.id.toolbar_user_avatar)
    CircleImageView mCircleImageView;

    //随机头像设置数组
    private static final int[] avatars = new int[]{
            R.drawable.ic_avatar1, R.drawable.ic_avatar2,
            R.drawable.ic_avatar3, R.drawable.ic_avatar4,
            R.drawable.ic_avatar5, R.drawable.ic_avatar6,
            R.drawable.ic_avatar7, R.drawable.ic_avatar8,
            R.drawable.ic_avatar9, R.drawable.ic_avatar10,
            R.drawable.ic_avatar11,
            };

    public static HomePageFragment newInstance()
    {

        return new HomePageFragment();
    }


    @Override
    public int getLayoutResId()
    {

        return R.layout.fragment_home_pager;
    }

    @Override
    public void finishCreateView(Bundle state)
    {

        setHasOptionsMenu(true);
        initToolBar();
        initSearchView();
        initViewPager();
    }


    private void initToolBar()
    {

        mToolbar.setTitle("");
        ((MainActivity) getActivity()).setSupportActionBar(mToolbar);
        int userAvatarIndex = ((MainActivity) getActivity()).getUserAvatarIndex();
        mCircleImageView.setImageResource(avatars[userAvatarIndex]);
    }

    private void initSearchView()
    {

        //初始化SearchBar
        mSearchView.setVoiceSearch(false);
        mSearchView.setCursorDrawable(R.drawable.custom_cursor);
        mSearchView.setEllipsize(true);
        mSearchView.setSuggestions(getResources().getStringArray(R.array.query_suggestions));
        mSearchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener()
        {

            @Override
            public boolean onQueryTextSubmit(String query)
            {

                TotalStationSearchActivity.launch(getActivity(), query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText)
            {

                return false;
            }
        });
    }


    private void initViewPager()
    {

        HomePagerAdapter mHomeAdapter = new HomePagerAdapter(getChildFragmentManager(),
                getApplicationContext());
        mViewPager.setOffscreenPageLimit(5);
        mViewPager.setAdapter(mHomeAdapter);
        mSlidingTab.setViewPager(mViewPager);
        mSlidingTab.setOnTabSelectListener(new OnTabSelectListener()
        {

            @Override
            public void onTabSelect(int position)
            {

                mViewPager.setCurrentItem(position, false);
                mSlidingTab.onPageSelected(position);
            }

            @Override
            public void onTabReselect(int position)
            {

            }
        });
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater)
    {

        menu.clear();
        inflater.inflate(R.menu.menu_main, menu);

        // 设置SearchViewItemMenu
        MenuItem item = menu.findItem(R.id.id_action_search);
        mSearchView.setMenuItem(item);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {

        int id = item.getItemId();
        switch (id)
        {
            case R.id.id_action_game:
                //游戏中心
                startActivity(new Intent(getActivity(), GameCentreActivity.class));
                break;

            case R.id.id_action_download:
                //离线缓存
                startActivity(new Intent(getActivity(), OffLineDownloadActivity.class));
                break;
        }

        return super.onOptionsItemSelected(item);
    }


    @OnClick(R.id.navigation_layout)
    void toggleDrawer()
    {

        Activity activity = getActivity();
        if (activity instanceof MainActivity)
            ((MainActivity) activity).toggleDrawer();
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {

        if (requestCode == MaterialSearchView.REQUEST_VOICE && resultCode == Activity.RESULT_OK)
        {
            ArrayList<String> matches = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            if (matches != null && matches.size() > 0)
            {
                String searchWrd = matches.get(0);
                if (!TextUtils.isEmpty(searchWrd))
                {
                    mSearchView.setQuery(searchWrd, false);
                }
            }

            return;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }


    public boolean isOpenSearchView()
    {

        if (mSearchView.isSearchOpen())
            return true;
        else
            return false;
    }

    public void closeSearchView()
    {

        mSearchView.closeSearch();
    }

    @Override
    protected void lazyLoad()
    {

    }
}
