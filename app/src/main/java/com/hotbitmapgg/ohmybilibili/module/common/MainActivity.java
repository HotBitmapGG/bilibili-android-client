package com.hotbitmapgg.ohmybilibili.module.common;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.base.RxAppCompatBaseActivity;
import com.hotbitmapgg.ohmybilibili.module.entry.AttentionPeopleFragment;
import com.hotbitmapgg.ohmybilibili.module.entry.ConsumeHistoryFragment;
import com.hotbitmapgg.ohmybilibili.module.entry.GameCentreActivity;
import com.hotbitmapgg.ohmybilibili.module.entry.HistoryFragment;
import com.hotbitmapgg.ohmybilibili.module.entry.IFavoritesFragment;
import com.hotbitmapgg.ohmybilibili.module.entry.OffLineDownloadActivity;
import com.hotbitmapgg.ohmybilibili.module.entry.SettingFragment;
import com.hotbitmapgg.ohmybilibili.module.home.HomePageFragment;
import com.hotbitmapgg.ohmybilibili.widget.CircleImageView;
import com.hotbitmapgg.ohmybilibili.widget.navigation_view.NavigationView;

import java.util.Random;

import butterknife.Bind;

/**
 * Created by hcc on 16/8/7 14:12
 * 100332338@qq.com
 * <p/>
 * 主界面
 */
public class MainActivity extends RxAppCompatBaseActivity implements
        NavigationView.OnNavigationItemSelectedListener
{


    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    @Bind(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;

    @Bind(R.id.navigation_view)
    NavigationView mNavigationView;

    @Bind(R.id.user_avatar_view)
    CircleImageView mUserAcatarView;

    @Bind(R.id.user_name)
    TextView mUserName;

    @Bind(R.id.user_other_info)
    TextView mUserSign;

    private ActionBarDrawerToggle mDrawerToggle;

    private Fragment[] fragments;

    private int currentTabIndex;

    private int index;

    private boolean isShowMenu = false;

    private Random random;

    //随机头像设置数组
    private static final int[] avatars = new int[]{
            R.drawable.ic_avatar1, R.drawable.ic_avatar2,
            R.drawable.ic_avatar3, R.drawable.ic_avatar4,
            R.drawable.ic_avatar5, R.drawable.ic_avatar6,
            R.drawable.ic_avatar7, R.drawable.ic_avatar8,
            R.drawable.ic_avatar9, R.drawable.ic_avatar10,
            R.drawable.ic_avatar11,
            };


    @Override
    public int getLayoutId()
    {

        return R.layout.activity_main;
    }

    @Override
    public void initViews(Bundle savedInstanceState)
    {

        //初始化Fragment
        initFragments();
        //设置侧滑菜单
        mDrawerLayout.addDrawerListener(new DrawerListener());
        mNavigationView.setNavigationItemSelectedListener(this);
        //进入应用随机设置头像
        random = new Random(SystemClock.elapsedRealtime());
        mUserAcatarView.setImageResource(avatars[random.nextInt(avatars.length)]);
        //设置用户名 签名
        mUserName.setText("HotBitmapGG");
        mUserSign.setText("哔哩哔哩 - ( ゜- ゜)つロ 乾杯~");
        //设置头像 随机设置
        mUserAcatarView.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {

                mUserAcatarView.setImageResource(avatars[random.nextInt(avatars.length)]);
            }
        });
    }

    /**
     * 初始化Fragments
     */
    private void initFragments()
    {

        HomePageFragment mHomePageFragment = HomePageFragment.newInstance();
        IFavoritesFragment mFavoritesFragment = IFavoritesFragment.newInstance();
        HistoryFragment mHistoryFragment = HistoryFragment.newInstance();
        AttentionPeopleFragment mAttentionPeopleFragment = AttentionPeopleFragment.newInstance();
        ConsumeHistoryFragment mConsumeHistoryFragment = ConsumeHistoryFragment.newInstance();
        SettingFragment mSettingFragment = SettingFragment.newInstance();


        fragments = new Fragment[]{
                mHomePageFragment,
                mFavoritesFragment,
                mHistoryFragment,
                mAttentionPeopleFragment,
                mConsumeHistoryFragment,
                mSettingFragment
        };

        // 添加显示第一个fragment
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container, mHomePageFragment)
                .show(mHomePageFragment).commit();
    }

    @Override
    public void initToolBar()
    {

        mToolbar.setLogo(R.drawable.ic_bili_logo_white);
        setSupportActionBar(mToolbar);
        ActionBar mActionBar = getSupportActionBar();
        if (mActionBar != null)
        {
            mActionBar.setDisplayHomeAsUpEnabled(true);
            mActionBar.setDisplayUseLogoEnabled(true);
            mActionBar.setDisplayShowTitleEnabled(false);
        }

        mDrawerToggle = new ActionBarDrawerToggle(this,
                mDrawerLayout,
                mToolbar,
                R.string.app_name,
                R.string.app_name
        );

        mDrawerLayout.post(new Runnable()
        {

            @Override
            public void run()
            {

                mDrawerToggle.syncState();
            }
        });

        mDrawerLayout.addDrawerListener(mDrawerToggle);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {

        if (mDrawerToggle != null &&
                mDrawerToggle.onOptionsItemSelected(item))
        {
            return true;
        }

        int id = item.getItemId();
        switch (id)
        {
            case R.id.id_action_game:
                //游戏中心
                startActivity(new Intent(MainActivity.this, GameCentreActivity.class));
                break;

            case R.id.id_action_download:
                //离线缓存
                startActivity(new Intent(MainActivity.this, OffLineDownloadActivity.class));
                break;

            case R.id.id_action_search:
                //搜索

                break;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * fragment时候控制显示隐藏的menu图标
     *
     * @param menu
     * @return
     */
    @Override
    public boolean onPrepareOptionsMenu(Menu menu)
    {

        if (isShowMenu)
            menu.findItem(R.id.id_action_game).setVisible(false);
        else
            menu.findItem(R.id.id_action_game).setVisible(true);

        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item)
    {

        mDrawerLayout.closeDrawer(GravityCompat.START);
        switch (item.getItemId())
        {
            case R.id.item_home:
                // 主页
                index = 0;
                switchFragment(fragments[0]);
                item.setChecked(true);
                mToolbar.setLogo(R.drawable.ic_bili_logo_white);
                mToolbar.setTitle("");
                setMenuShow(false);
                return true;

            case R.id.item_download:
                // 离线缓存
                startActivity(new Intent(MainActivity.this,
                        OffLineDownloadActivity.class));
                return true;

            case R.id.item_favourite:
                // 我的收藏
                index = 1;
                switchFragment(fragments[1]);
                item.setChecked(true);
                mToolbar.setTitle("我的收藏");
                mToolbar.setLogo(null);
                setMenuShow(true);
                return true;

            case R.id.item_history:
                // 历史记录
                index = 2;
                switchFragment(fragments[2]);
                item.setChecked(true);
                mToolbar.setTitle("历史记录");
                mToolbar.setLogo(null);
                setMenuShow(true);
                return true;

            case R.id.item_group:
                // 关注的人
                index = 3;
                switchFragment(fragments[3]);
                item.setChecked(true);
                mToolbar.setTitle("关注的人");
                mToolbar.setLogo(null);
                setMenuShow(true);
                return true;

            case R.id.item_tracker:
                // 消费记录
                index = 4;
                switchFragment(fragments[4]);
                item.setChecked(true);
                mToolbar.setTitle("消费记录");
                mToolbar.setLogo(null);
                setMenuShow(true);
                return true;

            case R.id.item_theme:
                // 主题选择

                return true;

            case R.id.item_app:
                // 应用推荐

                return true;

            case R.id.item_settings:
                // 设置中心
                index = 5;
                switchFragment(fragments[5]);
                item.setChecked(true);
                mToolbar.setTitle("设置与帮助");
                mToolbar.setLogo(null);
                setMenuShow(true);
                return true;
        }

        return false;
    }


    /**
     * Fragment切换
     *
     * @param fragment
     */
    private void switchFragment(Fragment fragment)
    {

        FragmentTransaction trx = getSupportFragmentManager().beginTransaction();
        trx.hide(fragments[currentTabIndex]);
        if (!fragments[index].isAdded())
        {
            trx.add(R.id.container, fragments[index]);
        }
        trx.show(fragments[index]).commit();
        currentTabIndex = index;
    }


    private class DrawerListener implements DrawerLayout.DrawerListener
    {

        @Override
        public void onDrawerOpened(View drawerView)
        {

            if (mDrawerToggle != null)
            {
                mDrawerToggle.onDrawerOpened(drawerView);
            }
        }

        @Override
        public void onDrawerClosed(View drawerView)
        {

            if (mDrawerToggle != null)
            {
                mDrawerToggle.onDrawerClosed(drawerView);
            }
        }

        @Override
        public void onDrawerSlide(View drawerView, float slideOffset)
        {

            if (mDrawerToggle != null)
            {
                mDrawerToggle.onDrawerSlide(drawerView, slideOffset);
            }
        }

        @Override
        public void onDrawerStateChanged(int newState)
        {

            if (mDrawerToggle != null)
            {
                mDrawerToggle.onDrawerStateChanged(newState);
            }
        }
    }

    private class ActionBarDrawerToggle extends android.support.v7.app.ActionBarDrawerToggle
    {

        public ActionBarDrawerToggle(Activity activity, DrawerLayout drawerLayout, Toolbar toolbar,
                                     int openDrawerContentDescRes, int closeDrawerContentDescRes)
        {

            super(activity, drawerLayout, toolbar, openDrawerContentDescRes, closeDrawerContentDescRes);
        }

        @Override
        public void onDrawerClosed(View drawerView)
        {

            super.onDrawerClosed(drawerView);
            invalidateOptionsMenu();
        }

        @Override
        public void onDrawerOpened(View drawerView)
        {

            super.onDrawerOpened(drawerView);
            invalidateOptionsMenu();
        }
    }

    /**
     * flase 显示 true不显示
     *
     * @param isShow
     */
    public void setMenuShow(boolean isShow)
    {
        //切换fragment时改变menu的显示
        isShowMenu = isShow;
        getWindow().invalidatePanelMenu(Window.FEATURE_OPTIONS_PANEL);
    }
}
