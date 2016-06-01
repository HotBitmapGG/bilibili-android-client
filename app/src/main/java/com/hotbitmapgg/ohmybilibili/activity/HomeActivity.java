package com.hotbitmapgg.ohmybilibili.activity;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.adapter.SearchRecycleAdapter;
import com.hotbitmapgg.ohmybilibili.base.AbsBaseActivity;
import com.hotbitmapgg.ohmybilibili.fragment.AttentionPeopleFragment;
import com.hotbitmapgg.ohmybilibili.fragment.ConsumeHistoryFragment;
import com.hotbitmapgg.ohmybilibili.fragment.HistoryFragment;
import com.hotbitmapgg.ohmybilibili.fragment.IFavoritesFragment;
import com.hotbitmapgg.ohmybilibili.fragment.SectionHomeFragment;
import com.hotbitmapgg.ohmybilibili.fragment.SettingFragment;
import com.hotbitmapgg.ohmybilibili.model.SearchHistoryItem;
import com.hotbitmapgg.ohmybilibili.utils.LogUtil;
import com.hotbitmapgg.ohmybilibili.widget.CircleImageView;
import com.hotbitmapgg.ohmybilibili.widget.navigation.NavigationView;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorListenerAdapter;
import com.nineoldandroids.animation.ObjectAnimator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.Bind;
import cn.bmob.v3.BmobObject;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.DeleteListener;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;
import io.codetail.animation.SupportAnimator;

/**
 * 主界面
 *
 * @HotBitmapGG
 */
public class HomeActivity extends AbsBaseActivity implements NavigationView.OnNavigationItemSelectedListener
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

    private ActionBar mActionBar;

    private ActionBarDrawerToggle mDrawerToggle;

    private Fragment[] fragments;

    private int currentTabIndex;

    private int index;

    private SectionHomeFragment mSectionHomeFragment;

    private SettingFragment mSettingFragment;

    private boolean isShowMenu = false;

    private Random random;

    private PopupWindow mSearchPop;

    private CardView mCardView;

    private InputMethodManager mInputMethodManager;

    private EditText mEdit;

    private SupportAnimator mHideAnimator;

    private SupportAnimator mAnimator;

    private ListView mSearchRecycle;

    private List<SearchHistoryItem> items = new ArrayList<>();

    private SearchRecycleAdapter mAdapter;

    private View footView;

    private IFavoritesFragment mFavoritesFragment;

    private HistoryFragment mHistoryFragment;

    private AttentionPeopleFragment mAttentionPeopleFragment;

    private ConsumeHistoryFragment mConsumeHistoryFragment;

    //随机头像设置数组
    private static final int[] avatars = new int[]{
            R.drawable.ic_avatar1, R.drawable.ic_avatar2, R.drawable.ic_avatar3, R.drawable.ic_avatar4,
            R.drawable.ic_avatar5, R.drawable.ic_avatar6, R.drawable.ic_avatar7, R.drawable.ic_avatar8,
            R.drawable.ic_avatar9, R.drawable.ic_avatar10, R.drawable.ic_avatar11,
            };


    @Override
    public int getLayoutId()
    {

        return R.layout.activity_main_home;
    }

    @Override
    public void initViews(Bundle savedInstanceState)
    {

        initFragments();

        mDrawerLayout.addDrawerListener(new DrawerListener());
        mNavigationView.setNavigationItemSelectedListener(this);
        // 添加显示第一个fragment
        getFragmentManager().beginTransaction().add(R.id.container, mSectionHomeFragment).show(mSectionHomeFragment).commit();
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


        mInputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
    }

    private void initFragments()
    {

        mSectionHomeFragment = new SectionHomeFragment();
        mSettingFragment = new SettingFragment();
        mFavoritesFragment = new IFavoritesFragment();
        mHistoryFragment = new HistoryFragment();
        mAttentionPeopleFragment = new AttentionPeopleFragment();
        mConsumeHistoryFragment = new ConsumeHistoryFragment();


        fragments = new Fragment[]{
                mSectionHomeFragment,
                mSettingFragment,
                mFavoritesFragment,
                mHistoryFragment,
                mAttentionPeopleFragment,
                mConsumeHistoryFragment
        };
    }

    @Override
    public void initToolBar()
    {

        mToolbar.setLogo(R.drawable.ic_bili_logo_white);
        setSupportActionBar(mToolbar);
        mActionBar = getSupportActionBar();
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

        if (mDrawerToggle != null && mDrawerToggle.onOptionsItemSelected(item))
        {
            return true;
        }

        int id = item.getItemId();
        switch (id)
        {
            case R.id.id_action_game:
                //游戏中心
                startActivity(new Intent(HomeActivity.this, GameCentreActivity.class));
                break;

            case R.id.id_action_download:
                //离线缓存
                startActivity(new Intent(HomeActivity.this, OffLineDownloadActivity.class));
                break;

            case R.id.id_action_search:
                //搜索
                showSearchViewPopWindown();
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
        {
            menu.findItem(R.id.id_action_game).setVisible(false);
        } else
        {
            menu.findItem(R.id.id_action_game).setVisible(true);
        }


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
                setShowingFragment(fragments[0]);
                item.setChecked(true);
                mToolbar.setLogo(R.drawable.ic_bili_logo_white);
                mToolbar.setTitle("");
                setMenuShow(false);

                return true;


            case R.id.item_download:
                // 离线缓存
                startActivity(new Intent(HomeActivity.this, OffLineDownloadActivity.class));

                return true;

            case R.id.item_favourite:
                // 我的收藏
                index = 2;
                setShowingFragment(fragments[2]);
                item.setChecked(true);
                mToolbar.setTitle("我的收藏");
                mToolbar.setLogo(null);
                setMenuShow(true);
                return true;

            case R.id.item_history:
                // 历史记录
                index = 3;
                setShowingFragment(fragments[3]);
                item.setChecked(true);
                mToolbar.setTitle("历史记录");
                mToolbar.setLogo(null);
                setMenuShow(true);

                return true;

            case R.id.item_group:
                // 关注的人
                index = 4;
                setShowingFragment(fragments[4]);
                item.setChecked(true);
                mToolbar.setTitle("关注的人");
                mToolbar.setLogo(null);
                setMenuShow(true);

                return true;

            case R.id.item_tracker:
                // 消费记录
                index = 5;
                setShowingFragment(fragments[5]);
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
                index = 1;
                setShowingFragment(fragments[1]);
                item.setChecked(true);
                mToolbar.setTitle("设置与帮助");
                mToolbar.setLogo(null);
                setMenuShow(true);

                return true;
        }

        return false;
    }

    private void setShowingFragment(Fragment fragment)
    {

        FragmentTransaction trx = getFragmentManager().beginTransaction();
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


    public void showSearchViewPopWindown()
    {

        View view = LayoutInflater.from(this).inflate(R.layout.layout_search_view, null);
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int widthPixels = metrics.widthPixels;
        int heightPixels = metrics.heightPixels;

        mCardView = (CardView) view.findViewById(R.id.search_card_view);
        ImageView mSearchImg = (ImageView) view.findViewById(R.id.search_img);
        final ImageView mBack = (ImageView) view.findViewById(R.id.search_back);
        mEdit = (EditText) view.findViewById(R.id.search_edit);
        ImageView mScan = (ImageView) view.findViewById(R.id.search_scan);
        mSearchRecycle = (ListView) view.findViewById(R.id.search_history_recycle);
        mSearchImg.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {

                String text = mEdit.getText().toString().trim();
                if (!TextUtils.isEmpty(text))
                {
                    //保存搜索记录
                    sendHistoryText(text);
                }
            }
        });

        mBack.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {

                stopPopAnim();
            }
        });

        mSearchPop = new PopupWindow(view, widthPixels, heightPixels);
        mSearchPop.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        mSearchPop.setTouchInterceptor(new View.OnTouchListener()
        {

            @Override
            public boolean onTouch(View v, MotionEvent event)
            {

                if (event.getAction() == MotionEvent.ACTION_OUTSIDE)
                {
                    mSearchPop.dismiss();
                    return true;
                }
                return false;
            }
        });
        mSearchPop.setOnDismissListener(new PopupWindow.OnDismissListener()
        {

            @Override
            public void onDismiss()
            {

                if (mAnimator != null)
                {
                    mAnimator.cancel();
                    mAnimator = null;
                }
                stopPopAnim();
                WindowManager.LayoutParams lp = getWindow().getAttributes();
                lp.alpha = 1.0f;
                getWindow().setAttributes(lp);
            }
        });


        mSearchPop.setWidth(WindowManager.LayoutParams.MATCH_PARENT);
        mSearchPop.setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
        mSearchPop.setTouchable(true);
        mSearchPop.setFocusable(true);
        mSearchPop.setOutsideTouchable(true);
        mSearchPop.setBackgroundDrawable(new BitmapDrawable());
        mSearchPop.showAtLocation(mToolbar, Gravity.TOP, 0, 0);

        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.alpha = .3f;
        getWindow().setAttributes(lp);

        startPopAnim();

        /**
         * 使用安卓L中的Circular Reveal 动画 暂时有问题
         * 会出现有时动画布局不出现的问题 暂时屏蔽 待解决后开放
         */

//        new Handler().postDelayed(new Runnable()
//        {
//
//            @Override
//            public void run()
//            {
//
//                startPopAnim();
//            }
//        }, 50);
    }

    private void initSearchRecycle()
    {

        queryHistoryItem();
    }

    public float r(int a, int b)
    {

        return (float) Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
    }

    public void startPopAnim()
    {

        ObjectAnimator revealAnimator = ObjectAnimator.ofFloat(mCardView, "Alpha", 0, 1);
        revealAnimator.setDuration(500);
        revealAnimator.setInterpolator(new AccelerateInterpolator());
        revealAnimator.start();
        revealAnimator.addListener(new AnimatorListenerAdapter()
        {

            @Override
            public void onAnimationEnd(Animator animation)
            {

                mInputMethodManager.showSoftInput(mEdit, 0);
                mCardView.setVisibility(View.VISIBLE);
                initSearchRecycle();

                super.onAnimationEnd(animation);
            }
        });

//        int cx = mToolbar.getLeft();
//        int cy = mToolbar.getTop();
//        float radius = r(mCardView.getWidth(), mCardView.getHeight());
//        mAnimator = ViewAnimationUtils.createCircularReveal(mCardView, cx / 2,
//                cy - DisplayUtil.dip2px(HomeActivity.this, 32),
//                DisplayUtil.dip2px(HomeActivity.this, 20), radius);
//        mAnimator.addListener(new SupportAnimator.AnimatorListener()
//        {
//
//            @Override
//            public void onAnimationStart()
//            {
//
//            }
//
//            @Override
//            public void onAnimationEnd()
//            {
//
//                mInputMethodManager.showSoftInput(mEdit, 0);
//                mCardView.setVisibility(View.VISIBLE);
//                initSearchRecycle();
//            }
//
//            @Override
//            public void onAnimationCancel()
//            {
//
//                mCardView.setVisibility(View.VISIBLE);
//            }
//
//            @Override
//            public void onAnimationRepeat()
//            {
//
//                mCardView.setVisibility(View.VISIBLE);
//            }
//        });
//
//        mAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
//        mAnimator.setDuration(500);
//        mAnimator.start();
    }

    public void stopPopAnim()
    {

        ObjectAnimator revealAnimator = ObjectAnimator.ofFloat(
                mCardView, "Alpha", 1, 0);
        revealAnimator.setDuration(500);
        revealAnimator.setInterpolator(new AccelerateInterpolator());
        revealAnimator.start();
        revealAnimator.addListener(new AnimatorListenerAdapter()
        {

            @Override
            public void onAnimationEnd(Animator animation)
            {

                mCardView.setVisibility(View.INVISIBLE);
                mSearchPop.dismiss();
                super.onAnimationEnd(animation);
            }
        });

//        int cx = mCardView.getLeft();
//        int cy = mCardView.getTop();
//        float radius = r(mCardView.getWidth(), mCardView.getHeight());
//        mHideAnimator = ViewAnimationUtils.createCircularReveal(mCardView, cx / 2,
//                cy - DisplayUtil.dip2px(HomeActivity.this, 32),
//                radius, DisplayUtil.dip2px(HomeActivity.this, 20));
//        mHideAnimator.addListener(new SupportAnimator.AnimatorListener()
//        {
//
//            @Override
//            public void onAnimationStart()
//            {
//
//            }
//
//            @Override
//            public void onAnimationEnd()
//            {
//
//                mCardView.setVisibility(View.INVISIBLE);
//                mSearchPop.dismiss();
//                mHideAnimator = null;
//                mAnimator = null;
//            }
//
//            @Override
//            public void onAnimationCancel()
//            {
//
//            }
//
//            @Override
//            public void onAnimationRepeat()
//            {
//
//            }
//        });
//
//        mHideAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
//        mHideAnimator.setDuration(500);
//        mHideAnimator.start();
    }


    private void sendHistoryText(String text)
    {

        SearchHistoryItem historyItem = new SearchHistoryItem();
        historyItem.historyName = text;
        historyItem.save(HomeActivity.this, new SaveListener()
        {

            @Override
            public void onSuccess()
            {

                mEdit.setText("");
                LogUtil.lsw("发送搜索历史记录成功");
            }

            @Override
            public void onFailure(int errorCode, String errorMsg)
            {

                LogUtil.lsw("发送搜索历史记录失败");
            }
        });
    }

    public void queryHistoryItem()
    {

        BmobQuery<SearchHistoryItem> query = new BmobQuery<>();
        query.order("createdAt");
        query.setLimit(10);
        query.findObjects(this, new FindListener<SearchHistoryItem>()
        {

            @Override
            public void onSuccess(List<SearchHistoryItem> data)
            {

                if (data != null && data.size() > 0)
                {

                    items.clear();
                    items.addAll(data);
                    finishQueryHistory();
                } else
                {
                    LogUtil.lsw("没有历史记录");
                }
            }

            @Override
            public void onError(int errorCode, String errorMsg)
            {

                LogUtil.lsw("查询历史记录失败" + errorMsg + errorCode);
            }
        });
    }

    private void finishQueryHistory()
    {

        mAdapter = new SearchRecycleAdapter(HomeActivity.this, items);
        mSearchRecycle.setAdapter(mAdapter);
        footView = LayoutInflater.from(HomeActivity.this).inflate(R.layout.layout_search_foot, mSearchRecycle, false);
        mSearchRecycle.addFooterView(footView);
        TextView mClear = (TextView) footView.findViewById(R.id.search_clear);
        mClear.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {

                deleteHostoryData();
            }
        });
    }

    private List<BmobObject> datas = new ArrayList<>();

    public void deleteHostoryData()
    {

        datas.addAll(items);
        new SearchHistoryItem().deleteBatch(HomeActivity.this, datas, new DeleteListener()
        {

            @Override
            public void onSuccess()
            {

                LogUtil.lsw("删除历史记录数据成功");
                items.clear();
                mAdapter.notifyDataSetChanged();
                mSearchRecycle.removeFooterView(footView);
            }

            @Override
            public void onFailure(int i, String s)
            {

                LogUtil.lsw("删除历史记录数据失败" + s);
            }
        });
    }


    @Override
    protected void onDestroy()
    {

        super.onDestroy();
        if (mSearchPop != null && mSearchPop.isShowing())
        {
            mSearchPop.dismiss();
        }
        if (mAnimator != null)
        {
            mAnimator.cancel();
            mAnimator = null;
        }
        if (mHideAnimator != null)
        {
            mHideAnimator.cancel();
            mHideAnimator = null;
        }
    }
}
