package com.hotbitmapgg.ohmybilibili.module.common;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatDelegate;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.base.RxAppCompatBaseActivity;
import com.hotbitmapgg.ohmybilibili.module.entry.AttentionPeopleFragment;
import com.hotbitmapgg.ohmybilibili.module.entry.ConsumeHistoryFragment;
import com.hotbitmapgg.ohmybilibili.module.entry.HistoryFragment;
import com.hotbitmapgg.ohmybilibili.module.entry.IFavoritesFragment;
import com.hotbitmapgg.ohmybilibili.module.entry.OffLineDownloadActivity;
import com.hotbitmapgg.ohmybilibili.module.entry.SettingFragment;
import com.hotbitmapgg.ohmybilibili.module.home.HomePageFragment;
import com.hotbitmapgg.ohmybilibili.utils.PreferenceUtils;
import com.hotbitmapgg.ohmybilibili.utils.ToastUtil;
import com.hotbitmapgg.ohmybilibili.widget.CircleImageView;

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

    @Bind(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;

    @Bind(R.id.navigation_view)
    NavigationView mNavigationView;

    private Fragment[] fragments;

    private int currentTabIndex;

    private int index;

    private long exitTime;

    private HomePageFragment mHomePageFragment;

    private int avatarIndex;

    private static final String SWITCH_MODE_KEY = "mode_key";

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
        //初始化侧滑菜单
        initNavigationView();
    }


    /**
     * 初始化Fragments
     */
    private void initFragments()
    {

        mHomePageFragment = HomePageFragment.newInstance();
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


    /**
     * 初始化NavigationView
     */
    private void initNavigationView()
    {

        mNavigationView.setNavigationItemSelectedListener(this);
        View headerView = mNavigationView.getHeaderView(0);
        CircleImageView mUserAvatarView = (CircleImageView) headerView.findViewById(R.id.user_avatar_view);
        TextView mUserName = (TextView) headerView.findViewById(R.id.user_name);
        TextView mUserSign = (TextView) headerView.findViewById(R.id.user_other_info);
        ImageView mSwitchMode = (ImageView) headerView.findViewById(R.id.iv_head_switch_mode);
        //进入应用随机设置头像
        Random random = new Random(SystemClock.elapsedRealtime());
        avatarIndex = random.nextInt(avatars.length);
        mUserAvatarView.setImageResource(avatars[avatarIndex]);
        //设置用户名 签名
        mUserName.setText(getResources().getText(R.string.hotbitmapgg));
        mUserSign.setText(getResources().getText(R.string.about_user_head_layout));
        //设置日夜间模式切换
        mSwitchMode.setOnClickListener(v -> switchNightMode());


        boolean flag = PreferenceUtils.getBoolean(SWITCH_MODE_KEY, false);
        if (flag)
        {
            mSwitchMode.setImageResource(R.drawable.ic_switch_daily);
        } else
        {
            mSwitchMode.setImageResource(R.drawable.ic_switch_night);
        }
    }

    /**
     * 日夜间模式切换
     */
    private void switchNightMode()
    {

        boolean isNight = PreferenceUtils.getBoolean(SWITCH_MODE_KEY, false);
        if (isNight)
        {
            // 日间模式
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            PreferenceUtils.putBoolean(SWITCH_MODE_KEY, false);
        } else
        {
            // 夜间模式
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            PreferenceUtils.putBoolean(SWITCH_MODE_KEY, true);
        }

        recreate();
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item)
    {

        mDrawerLayout.closeDrawer(GravityCompat.START);
        switch (item.getItemId())
        {
            case R.id.item_home:
                // 主页
                changeFragmentIndex(item, 0);
                return true;

            case R.id.item_download:
                // 离线缓存
                startActivity(new Intent(MainActivity.this,
                        OffLineDownloadActivity.class));
                return true;

            case R.id.item_favourite:
                // 我的收藏
                changeFragmentIndex(item, 1);
                return true;

            case R.id.item_history:
                // 历史记录
                changeFragmentIndex(item, 2);
                return true;

            case R.id.item_group:
                // 关注的人
                changeFragmentIndex(item, 3);
                return true;

            case R.id.item_tracker:
                // 消费记录
                changeFragmentIndex(item, 4);
                return true;

            case R.id.item_theme:
                // 主题选择
//                CardPickerDialog dialog = new CardPickerDialog();
//                dialog.setClickListener(this);
//                dialog.show(getSupportFragmentManager(), CardPickerDialog.TAG);
                return true;

            case R.id.item_app:
                // 应用推荐

                return true;

            case R.id.item_settings:
                // 设置中心
                changeFragmentIndex(item, 5);
                return true;
        }

        return false;
    }


    /**
     * Fragment切换
     */
    private void switchFragment()
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


    /**
     * 切换Fragment的下标
     *
     * @param item
     * @param currentIndex
     */
    private void changeFragmentIndex(MenuItem item, int currentIndex)
    {

        index = currentIndex;
        switchFragment();
        item.setChecked(true);
    }

    /**
     * DrawerLayout侧滑菜单开关
     */
    public void toggleDrawer()
    {

        if (mDrawerLayout.isDrawerOpen(GravityCompat.START))
        {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else
        {
            mDrawerLayout.openDrawer(GravityCompat.START);
        }
    }

    /**
     * 获取当前设置的头像Index
     *
     * @return
     */
    public int getUserAvatarIndex()
    {

        return avatarIndex;
    }


    /**
     * 监听back键处理DrawerLayout和SearchView
     *
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {

        if (keyCode == KeyEvent.KEYCODE_BACK)
        {
            if (mDrawerLayout.isDrawerOpen(mDrawerLayout.getChildAt(1)))
            {
                mDrawerLayout.closeDrawers();
            } else
            {
                if (mHomePageFragment != null)
                {
                    if (mHomePageFragment.isOpenSearchView())
                    {
                        mHomePageFragment.closeSearchView();
                    } else
                    {
                        exitApp();
                    }
                } else
                {
                    exitApp();
                }
            }
        }

        return true;
    }

    /**
     * 双击退出App
     */
    private void exitApp()
    {

        if (System.currentTimeMillis() - exitTime > 2000)
        {
            ToastUtil.ShortToast("再按一次退出");
            exitTime = System.currentTimeMillis();
        } else
        {
            PreferenceUtils.remove(SWITCH_MODE_KEY);
            finish();
        }
    }

    /**
     * 解决App重启后导致Fragment重叠的问题
     *
     * @param outState
     */
    @Override
    protected void onSaveInstanceState(Bundle outState)
    {
        //super.onSaveInstanceState(outState);
    }

    @Override
    public void initToolBar()
    {

    }
}
