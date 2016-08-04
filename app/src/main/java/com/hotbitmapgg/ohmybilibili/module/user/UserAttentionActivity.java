package com.hotbitmapgg.ohmybilibili.module.user;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.adapter.UserItemRecyclerAdapter;
import com.hotbitmapgg.ohmybilibili.adapter.base.AbsRecyclerViewAdapter;
import com.hotbitmapgg.ohmybilibili.api.FriendApi;
import com.hotbitmapgg.ohmybilibili.base.RxAppCompatBaseActivity;
import com.hotbitmapgg.ohmybilibili.model.base.BasicMessage;
import com.hotbitmapgg.ohmybilibili.model.user.UserInfo;
import com.hotbitmapgg.ohmybilibili.utils.LogUtil;
import com.hotbitmapgg.ohmybilibili.widget.CircleProgressView;
import com.hotbitmapgg.ohmybilibili.widget.recycle.DividerItemDecoration;

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
 * 关注的人
 *
 * @author HotBitmapGG
 */
public class UserAttentionActivity extends RxAppCompatBaseActivity
{

    @Bind(R.id.circle_progress)
    CircleProgressView mCircleProgress;

    @Bind(R.id.user_list)
    RecyclerView mUserList;

    @Bind(R.id.toolbar)
    Toolbar mToolbar;


    private ArrayList<Integer> uids;

    private ArrayList<UserInfo> users;

    private static final String EXTRA_UIDS = "extra_users_list";

    private static final String EXTRA_USERNAME = "extra_user_name";

    private String uName;


    @Override
    public int getLayoutId()
    {

        return R.layout.activity_user_list;
    }

    @Override
    public void initViews(Bundle savedInstanceState)
    {

        Intent intent = getIntent();
        if (intent != null)
        {
            uids = intent.getIntegerArrayListExtra(EXTRA_UIDS);
            uName = intent.getStringExtra(EXTRA_USERNAME);
        }

        startGetListTask();
    }

    @Override
    public void initToolBar()
    {

        mToolbar.setNavigationIcon(R.drawable.action_button_back_pressed_light);
        mToolbar.setTitle(uName + "的关注");
        mToolbar.setNavigationOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {

                finish();
            }
        });
    }


    public static void launch(Activity activity, ArrayList<Integer> uids, String userName)
    {

        Intent intent = new Intent(activity, UserAttentionActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra(EXTRA_UIDS, uids);
        intent.putExtra(EXTRA_USERNAME, userName);
        activity.startActivity(intent);
    }

    private void startGetListTask()
    {

        mUserList.setVisibility(View.GONE);
        mCircleProgress.setVisibility(View.VISIBLE);
        mCircleProgress.spin();

        //new GetListTaskAbs().execute();
        getAttention();
    }

    private void finishGetListTask()
    {

        UserItemRecyclerAdapter mAdapter = new UserItemRecyclerAdapter(mUserList, users);
        mUserList.setHasFixedSize(true);
        mUserList.setLayoutManager(new LinearLayoutManager(UserAttentionActivity.this));
        mUserList.addItemDecoration(new DividerItemDecoration(UserAttentionActivity.this, DividerItemDecoration.VERTICAL_LIST));
        mUserList.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new AbsRecyclerViewAdapter.OnItemClickListener()
        {

            @Override
            public void onItemClick(int position, AbsRecyclerViewAdapter.ClickableViewHolder holder)
            {

                UserInfo info = users.get(position);
                String temp;
                temp = !TextUtils.isEmpty(temp = info.name) ? temp : !TextUtils.isEmpty(temp = info.uname) ? temp : info.userid;
                UserInfoActivity.launch(UserAttentionActivity.this, temp, info.mid, info.face);
            }
        });

        mUserList.setVisibility(View.VISIBLE);
        mCircleProgress.setVisibility(View.GONE);
        mCircleProgress.stopSpinning();
    }


    public void getAttention()
    {

        Single<BasicMessage<ArrayList<UserInfo>>> observable = Single.fromCallable(new Callable<BasicMessage<ArrayList<UserInfo>>>()
        {

            @Override
            public BasicMessage<ArrayList<UserInfo>> call() throws Exception
            {

                return FriendApi.getUserList(uids);
            }
        });

        Subscription subscribe = observable
                .map(new Func1<BasicMessage<ArrayList<UserInfo>>,ArrayList<UserInfo>>()
                {

                    @Override
                    public ArrayList<UserInfo> call(BasicMessage<ArrayList<UserInfo>> arrayListBasicMessage)
                    {

                        return arrayListBasicMessage.getObject();
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleSubscriber<ArrayList<UserInfo>>()
                {

                    @Override
                    public void onSuccess(ArrayList<UserInfo> value)
                    {

                        users = value;
                        finishGetListTask();
                    }

                    @Override
                    public void onError(Throwable error)
                    {

                        LogUtil.lsw("关注的人获取失败");
                    }
                });

        compositeSubscription.add(subscribe);
    }
}
