package com.hotbitmapgg.ohmybilibili.module.user;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.adapter.UserFansAdapter;
import com.hotbitmapgg.ohmybilibili.api.FansApi;
import com.hotbitmapgg.ohmybilibili.base.RxAppCompatBaseActivity;
import com.hotbitmapgg.ohmybilibili.model.base.BasicMessage;
import com.hotbitmapgg.ohmybilibili.model.user.UserFans;
import com.hotbitmapgg.ohmybilibili.utils.LogUtil;
import com.hotbitmapgg.ohmybilibili.widget.CircleProgressView;
import com.hotbitmapgg.ohmybilibili.widget.recycle.DividerItemDecoration;
import com.hotbitmapgg.ohmybilibili.widget.swiperefresh.EndlessRecyclerOnScrollListener;
import com.hotbitmapgg.ohmybilibili.widget.swiperefresh.HeaderViewRecyclerAdapter;

import java.util.ArrayList;
import java.util.concurrent.Callable;

import butterknife.Bind;
import rx.Single;
import rx.SingleSubscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * 用户粉丝界面
 *
 * @HotBitmapGG
 */
public class UserFansActivity extends RxAppCompatBaseActivity
{

    @Bind(R.id.user_fans_recycle)
    RecyclerView mRecyclerView;

    @Bind(R.id.circle_progress)
    CircleProgressView mCircleProgressView;

    @Bind(R.id.toolbar)
    Toolbar mToolbar;


    private static final String EXTRA_MID = "mid";

    private static final String EXTRA_USERNAME = "userName";

    private String mid;

    private String userName;

    private ArrayList<UserFans.FansInfo> userfansList = new ArrayList<>();

    private UserFansAdapter mRecyclerAdapter;

    private HeaderViewRecyclerAdapter mAdapter;

    private int pageNum = 1;

    private int pageSize = 50;

    private View loadMoreView;


    @Override
    public int getLayoutId()
    {

        return R.layout.activity_user_fans;
    }

    @Override
    public void initViews(Bundle savedInstanceState)
    {

        Intent intent = getIntent();
        if (intent != null)
        {
            mid = intent.getStringExtra("mid");
            userName = intent.getStringExtra("userName");
        }


        mCircleProgressView.setVisibility(View.VISIBLE);
        mCircleProgressView.spin();

        getFans();
    }

    @Override
    public void initToolBar()
    {

        mToolbar.setNavigationIcon(R.drawable.action_button_back_pressed_light);
        mToolbar.setTitle(userName + "的粉丝");
        mToolbar.setNavigationOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {

                finish();
            }
        });
    }

    public void getFans()
    {

        Single<BasicMessage<UserFans>> observable = Single.fromCallable(new Callable<BasicMessage<UserFans>>()
        {

            @Override
            public BasicMessage<UserFans> call() throws Exception
            {

                return FansApi.getUserFans(mid, pageNum, pageSize);
            }
        });

        Subscription subscribe = observable.map(new Func1<BasicMessage<UserFans>,UserFans>()
        {

            @Override
            public UserFans call(BasicMessage<UserFans> userFansBasicMessage)
            {

                return userFansBasicMessage.getObject();
            }
        })
                .map(new Func1<UserFans,ArrayList<UserFans.FansInfo>>()
                {

                    @Override
                    public ArrayList<UserFans.FansInfo> call(UserFans userFans)
                    {

                        return userFans.list;
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleSubscriber<ArrayList<UserFans.FansInfo>>()
                {

                    @Override
                    public void onSuccess(ArrayList<UserFans.FansInfo> value)
                    {

                        if (value != null && value.size() > 0)
                        {
                            userfansList.addAll(value);

                            finishTask();
                        }
                    }

                    @Override
                    public void onError(Throwable error)
                    {

                        LogUtil.lsw("粉丝数据加载失败");
                    }
                });

        compositeSubscription.add(subscribe);
    }

    public void loadMoreFans()
    {

        Single<BasicMessage<UserFans>> single = Single.fromCallable(new Callable<BasicMessage<UserFans>>()
        {

            @Override
            public BasicMessage<UserFans> call() throws Exception
            {

                return FansApi.getUserFans(mid, pageNum, pageSize);
            }
        });

        Subscription subscribe = single.map(new Func1<BasicMessage<UserFans>,UserFans>()
        {

            @Override
            public UserFans call(BasicMessage<UserFans> userFansBasicMessage)
            {

                return userFansBasicMessage.getObject();
            }
        })
                .map(new Func1<UserFans,ArrayList<UserFans.FansInfo>>()
                {

                    @Override
                    public ArrayList<UserFans.FansInfo> call(UserFans userFans)
                    {

                        return userFans.list;
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleSubscriber<ArrayList<UserFans.FansInfo>>()
                {

                    @Override
                    public void onSuccess(ArrayList<UserFans.FansInfo> value)
                    {

                        if (value != null && value.size() > 0)
                        {
                            int size = value.size();
                            for (int i = 0; i < size; i++)
                            {
                                userfansList.add(value.get(i));
                            }
                            if (size < pageSize)
                            {
                                mAdapter.notifyDataSetChanged();
                                loadMoreView.setVisibility(View.GONE);
                            }
                            mAdapter.notifyDataSetChanged();
                        } else
                        {
                            loadMoreView.setVisibility(View.GONE);
                            mAdapter.notifyDataSetChanged();
                        }
                    }

                    @Override
                    public void onError(Throwable error)
                    {

                        LogUtil.lsw("粉丝数据上拉加载失败");
                        mAdapter.notifyDataSetChanged();
                        loadMoreView.setVisibility(View.GONE);
                    }
                });

        compositeSubscription.add(subscribe);
    }

    private void finishTask()
    {

        mCircleProgressView.setVisibility(View.GONE);
        mCircleProgressView.stopSpinning();

        mRecyclerAdapter = new UserFansAdapter(mRecyclerView, userfansList);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(UserFansActivity.this, DividerItemDecoration.VERTICAL_LIST));
        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mAdapter = new HeaderViewRecyclerAdapter(mRecyclerAdapter);
        mRecyclerView.setAdapter(mAdapter);
        createLoadMoreView();
        mRecyclerView.addOnScrollListener(new EndlessRecyclerOnScrollListener(mLinearLayoutManager)
        {

            @Override
            public void onLoadMore(int i)
            {

                pageNum++;
                loadMoreFans();
            }
        });
    }

    private void createLoadMoreView()
    {

        loadMoreView = LayoutInflater.from(UserFansActivity.this).inflate(R.layout.recycle_view_foot_layout, mRecyclerView, false);
        mAdapter.addFooterView(loadMoreView);
    }


    public static void launch(Activity activity, String mid, String userName)
    {

        Intent intent = new Intent(activity, UserFansActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra(EXTRA_MID, mid);
        intent.putExtra(EXTRA_USERNAME, userName);
        activity.startActivity(intent);
    }
}
