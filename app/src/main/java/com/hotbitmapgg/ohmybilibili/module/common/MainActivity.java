package com.hotbitmapgg.ohmybilibili.module.common;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.speech.RecognizerIntent;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
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
import com.hotbitmapgg.ohmybilibili.module.search.TotalStationSearchActivity;
import com.hotbitmapgg.ohmybilibili.utils.PreferenceUtils;
import com.hotbitmapgg.ohmybilibili.utils.ToastUtil;
import com.hotbitmapgg.ohmybilibili.widget.CircleImageView;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;
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

    @Bind(R.id.search_view)
    MaterialSearchView mSearchView;

    private CircleImageView mUserAcatarView;

    private TextView mUserName;

    private TextView mUserSign;

    private Fragment[] fragments;

    private int currentTabIndex;

    private int index;

    private boolean isShowMenu = false;

    private Random random;

    private long exitTime;

    private ImageView mSwitchMode;

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

    private void initNavigationView()
    {

        mNavigationView.setNavigationItemSelectedListener(this);
        View headerView = mNavigationView.getHeaderView(0);
        mUserAcatarView = (CircleImageView) headerView.findViewById(R.id.user_avatar_view);
        mUserName = (TextView) headerView.findViewById(R.id.user_name);
        mUserSign = (TextView) headerView.findViewById(R.id.user_other_info);
        mSwitchMode = (ImageView) headerView.findViewById(R.id.iv_head_switch_mode);
        //进入应用随机设置头像
        random = new Random(SystemClock.elapsedRealtime());
        mUserAcatarView.setImageResource(avatars[random.nextInt(avatars.length)]);
        //设置用户名 签名
        mUserName.setText(getResources().getText(R.string.hotbitmapgg));
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
        //设置日夜间模式切换
        mSwitchMode.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {

                switchNightMode();
            }
        });


        boolean flag = PreferenceUtils.getBoolean(SWITCH_MODE_KEY, false);
        if (flag)
        {
            mSwitchMode.setImageResource(R.drawable.ic_switch_daily);
        } else
        {
            mSwitchMode.setImageResource(R.drawable.ic_switch_night);
        }
    }

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

        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this,
                mDrawerLayout,
                mToolbar,
                R.string.app_name,
                R.string.app_name
        );

        mDrawerLayout.addDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();


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

                TotalStationSearchActivity.launch(MainActivity.this, query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText)
            {

                return false;
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {

        getMenuInflater().inflate(R.menu.menu_main, menu);

        // 设置SearchViewItemMenu
        MenuItem item = menu.findItem(R.id.id_action_search);
        mSearchView.setMenuItem(item);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {

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
//                CardPickerDialog dialog = new CardPickerDialog();
//                dialog.setClickListener(this);
//                dialog.show(getSupportFragmentManager(), CardPickerDialog.TAG);
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {

        if (requestCode == MaterialSearchView.REQUEST_VOICE && resultCode == RESULT_OK)
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


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {

        if (keyCode == KeyEvent.KEYCODE_BACK)
        {
            if (mSearchView != null)
            {
                if (mSearchView.isSearchOpen())
                {
                    mSearchView.closeSearch();
                } else
                {
                    exitApp();
                }
            } else
            {
                exitApp();
            }
        }

        return true;
    }

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
}
