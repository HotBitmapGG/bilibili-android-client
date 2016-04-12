package com.hotbitmapgg.ohmybilibili.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.adapter.UserFansAdapter;
import com.hotbitmapgg.ohmybilibili.api.FansApi;
import com.hotbitmapgg.ohmybilibili.model.BasicMessage;
import com.hotbitmapgg.ohmybilibili.model.UserFans;
import com.hotbitmapgg.ohmybilibili.network.AbsAsyncTask;
import com.hotbitmapgg.ohmybilibili.widget.CircleProgressView;
import com.hotbitmapgg.ohmybilibili.widget.DividerItemDecoration;

import java.util.ArrayList;

import cn.easydone.swiperefreshendless.EndlessRecyclerOnScrollListener;
import cn.easydone.swiperefreshendless.HeaderViewRecyclerAdapter;

/**
 * Created by hcc on 16/3/27.
 * 用户粉丝界面
 *
 * @HotBitmapGG
 */
public class UserFansActivity extends AppCompatActivity
{

    private static final String EXTRA_MID = "mid";

    private static final String EXTRA_USERNAME = "userName";

    private String mid;

    private String userName;

    private RecyclerView mRecyclerView;

    private CircleProgressView mCircleProgressView;

    private ArrayList<UserFans.FansInfo> userfansList = new ArrayList<>();

    private UserFansAdapter mRecyclerAdapter;

    private HeaderViewRecyclerAdapter mAdapter;

    private int pageNum = 1;

    private int pageSize = 50;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        if (intent != null)
        {
            mid = intent.getStringExtra("mid");
            userName = intent.getStringExtra("userName");
        }

        setContentView(R.layout.activity_user_fans);


        initTitle();
        initView();
    }

    private void initView()
    {

        mRecyclerView = (RecyclerView) findViewById(R.id.user_fans_recycle);
        mCircleProgressView = (CircleProgressView) findViewById(R.id.circle_progress);
        mCircleProgressView.setVisibility(View.VISIBLE);
        mCircleProgressView.spin();

        new GetUserFansListTaskAbs().execute();
    }

    private void initTitle()
    {

        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
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

    public class GetUserFansListTaskAbs extends AbsAsyncTask<Void,Void,BasicMessage<UserFans>>
    {


        @Override
        protected BasicMessage<UserFans> doInBackground(Void... params)
        {

            return FansApi.getUserFans(mid, pageNum, pageSize);
        }

        @Override
        protected void onPostExecute(BasicMessage<UserFans> userFansBasicMessage)
        {

            if (userFansBasicMessage != null)
            {
                UserFans userFans = userFansBasicMessage.getObject();
                ArrayList<UserFans.FansInfo> list = userFans.list;
                if (list != null && list.size() > 0)
                {
                    userfansList.addAll(list);

                    finishTask();
                }
            }


            super.onPostExecute(userFansBasicMessage);
        }
    }

    public class LoadMoreUserFansTaskAbs extends AbsAsyncTask<Void,Void,BasicMessage<UserFans>>
    {

        @Override
        protected BasicMessage<UserFans> doInBackground(Void... params)
        {

            return FansApi.getUserFans(mid, pageNum, pageSize);
        }

        @Override
        protected void onPostExecute(BasicMessage<UserFans> userFansBasicMessage)
        {

            if (userFansBasicMessage != null)
            {
                UserFans userFans = userFansBasicMessage.getObject();
                ArrayList<UserFans.FansInfo> list = userFans.list;
                if (list != null && list.size() > 0)
                {
                    int size = list.size();
                    for (int i = 0; i < size; i++)
                    {
                        userfansList.add(list.get(i));
                    }
                    if (size < pageSize)
                    {
                        mAdapter.notifyDataSetChanged();
                    }
                    mAdapter.notifyDataSetChanged();
                } else
                {
                    mAdapter.notifyDataSetChanged();
                }
            }
            else
            {
                mAdapter.notifyDataSetChanged();
            }


            super.onPostExecute(userFansBasicMessage);
        }
    }

    private void finishTask()
    {

        mCircleProgressView.setVisibility(View.GONE);
        mCircleProgressView.stopSpinning();

        mRecyclerAdapter = new UserFansAdapter(mRecyclerView, userfansList);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(UserFansActivity.this , DividerItemDecoration.VERTICAL_LIST));
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
                new LoadMoreUserFansTaskAbs().execute();
            }
        });
    }

    private void createLoadMoreView()
    {

        View loadMoreView = LayoutInflater.from(UserFansActivity.this).inflate(R.layout.recycle_view_foot_layout, mRecyclerView, false);
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
