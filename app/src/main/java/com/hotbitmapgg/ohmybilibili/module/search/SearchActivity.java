package com.hotbitmapgg.ohmybilibili.module.search;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.flyco.tablayout.SlidingTabLayout;
import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.base.RxAppCompatBaseActivity;
import com.hotbitmapgg.ohmybilibili.entity.search.SearchResult;
import com.hotbitmapgg.ohmybilibili.network.RetrofitHelper;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by hcc on 16/8/29 19:58
 * 100332338@qq.com
 * <p/>
 * 全站搜索界面
 */
public class SearchActivity extends RxAppCompatBaseActivity
{

    @Bind(R.id.sliding_tabs)
    SlidingTabLayout mSlidingTabLayout;

    @Bind(R.id.view_pager)
    ViewPager mViewPager;

    @Bind(R.id.iv_search_loading)
    ImageView mLoadingView;

    @Bind(R.id.search_back)
    ImageView mBack;

    @Bind(R.id.search_edit)
    EditText mSearchEdit;

    @Bind(R.id.search_text_clear)
    ImageView mSearchTextClear;

    @Bind(R.id.search_img)
    ImageView mSearchBtn;

    @Bind(R.id.search_layout)
    LinearLayout mSearchLayout;


    private static final String EXTRA_CONTENT = "extra_content";

    private String content;

    private int page = 1;

    private int count = 10;

    private List<String> titles = new ArrayList<>();

    private List<Fragment> fragments = new ArrayList<>();

    private AnimationDrawable mAnimationDrawable;

    private SearchResult.PageinfoBean pageinfo;


    @Override
    public int getLayoutId()
    {

        return R.layout.activity_search;
    }

    @Override
    public void initToolBar()
    {

    }

    @Override
    public void initViews(Bundle savedInstanceState)
    {

        Intent intent = getIntent();
        if (intent != null)
        {
            content = intent.getStringExtra(EXTRA_CONTENT);
        }

        mLoadingView.setImageResource(R.drawable.anim_search_loading);
        mAnimationDrawable = (AnimationDrawable) mLoadingView.getDrawable();
        showSearchAnim();
        getSearchData();
    }

    private void getSearchData()
    {

        RetrofitHelper.getSearchApi()
                .search(content, page, count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<SearchResult>()
                {

                    @Override
                    public void call(SearchResult searchResult)
                    {

                        pageinfo = searchResult.getPageinfo();
                        SearchResult.ResultBean result = searchResult.getResult();
                        finishTask(result);
                    }
                });
    }

    private void finishTask(SearchResult.ResultBean result)
    {

        hideSearchAnim();
        titles.add("综合");
        titles.add("番剧" + "(" + checkNumResults(pageinfo.getBangumi().getNumResults()) + ")");
        titles.add("UP主" + "(" + checkNumResults(pageinfo.getUpuser().getNumResults()) + ")");
        titles.add("影视" + "(" + checkNumResults(pageinfo.getUpuser().getNumResults()) + ")");
        titles.add("专题" + "(" + checkNumResults(pageinfo.getSpecial().getNumResults()) + ")");

        SearchResultFragment fragment1 = SearchResultFragment.newInstance(result);
        SearchResultFragment fragment2 = SearchResultFragment.newInstance(result);
        SearchResultFragment fragment3 = SearchResultFragment.newInstance(result);
        SearchResultFragment fragment4 = SearchResultFragment.newInstance(result);
        SearchResultFragment fragment5 = SearchResultFragment.newInstance(result);

        fragments.add(fragment1);
        fragments.add(fragment2);
        fragments.add(fragment3);
        fragments.add(fragment4);
        fragments.add(fragment5);

        SearchTabAdapter mAdapter = new SearchTabAdapter(getSupportFragmentManager(), titles, fragments);
        mViewPager.setAdapter(mAdapter);
        mSlidingTabLayout.setViewPager(mViewPager);
    }

    public String checkNumResults(int numResult)
    {

        return numResult > 100 ? "99+" : String.valueOf(numResult);
    }


    private void showSearchAnim()
    {

        mLoadingView.setVisibility(View.VISIBLE);
        mSearchLayout.setVisibility(View.GONE);
        mAnimationDrawable.start();
    }

    private void hideSearchAnim()
    {

        mLoadingView.setVisibility(View.GONE);
        mSearchLayout.setVisibility(View.VISIBLE);
        mAnimationDrawable.stop();
    }

    public static void launch(Activity activity, String str)
    {

        Intent mIntent = new Intent(activity, SearchActivity.class);
        mIntent.putExtra(EXTRA_CONTENT, str);
        activity.startActivity(mIntent);
    }

    @Override
    protected void onDestroy()
    {

        super.onDestroy();
        if (mAnimationDrawable != null)
        {
            mAnimationDrawable.stop();
            mAnimationDrawable = null;
        }
    }

    private static class SearchTabAdapter extends FragmentStatePagerAdapter
    {

        private List<String> titles;

        private List<Fragment> fragments;

        public SearchTabAdapter(FragmentManager fm,
                                List<String> titles,
                                List<Fragment> fragments)
        {

            super(fm);
            this.titles = titles;
            this.fragments = fragments;
        }

        @Override
        public Fragment getItem(int position)
        {

            return fragments.get(position);
        }

        @Override
        public CharSequence getPageTitle(int position)
        {

            return titles.get(position);
        }

        @Override
        public int getCount()
        {

            return fragments.size();
        }
    }
}
