package com.hotbitmapgg.ohmybilibili.ui;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.adapter.AbsRecyclerViewAdapter;
import com.hotbitmapgg.ohmybilibili.adapter.UserItemRecyclerAdapter;
import com.hotbitmapgg.ohmybilibili.api.FriendApi;
import com.hotbitmapgg.ohmybilibili.model.BasicMessage;
import com.hotbitmapgg.ohmybilibili.model.UserInfo;
import com.hotbitmapgg.ohmybilibili.network.AbsAsyncTask;
import com.hotbitmapgg.ohmybilibili.utils.LogUtil;
import com.hotbitmapgg.ohmybilibili.widget.CircleProgressView;
import com.hotbitmapgg.ohmybilibili.widget.DividerItemDecoration;

import java.util.ArrayList;

/**
 * 关注的人
 *
 * @author HotBitmapGG
 */
public class UserAttentionActivity extends AppCompatActivity
{

    private RecyclerView mUserList;

    private CircleProgressView mCircleProgress;

    private ArrayList<Integer> uids;

    private ArrayList<UserInfo> users;

    private static final String EXTRA_UIDS = "extra_users_list";

    private static final String EXTRA_USERNAME = "extra_user_name";

    private String uName;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        uids = intent.getIntegerArrayListExtra(EXTRA_UIDS);
        uName = intent.getStringExtra(EXTRA_USERNAME);

        setContentView(R.layout.activity_user_list);

        initViews();
        startGetListTask();
    }


    private void initViews()
    {

        mCircleProgress = (CircleProgressView) findViewById(R.id.circle_progress);
        mUserList = (RecyclerView) findViewById(R.id.user_list);

        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
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

        new GetListTaskAbs().execute();
    }

    private void finishGetListTask()
    {

        mUserList.setVisibility(View.VISIBLE);
        mCircleProgress.setVisibility(View.GONE);
        mCircleProgress.stopSpinning();
    }

    private class GetListTaskAbs extends AbsAsyncTask<Void,Void,BasicMessage<ArrayList<UserInfo>>>
    {

        @Override
        protected BasicMessage<ArrayList<UserInfo>> doInBackground(Void... params)
        {

            return FriendApi.getUserList(uids);
        }

        @Override
        protected void onPostExecute(BasicMessage<ArrayList<UserInfo>> msg)
        {

            if (msg != null && msg.getCode() == BasicMessage.CODE_SUCCEED)
            {
                users = msg.getObject();
                UserItemRecyclerAdapter mAdapter = new UserItemRecyclerAdapter(mUserList , users);
                mUserList.setHasFixedSize(true);
                mUserList.setLayoutManager(new LinearLayoutManager(UserAttentionActivity.this));
                mUserList.addItemDecoration(new DividerItemDecoration(UserAttentionActivity.this , DividerItemDecoration.VERTICAL_LIST));
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
//                UserItemRecyclerAdapter adapter = new UserItemRecyclerAdapter(UserAttentionActivity.this, users);
//                mUserList.setAdapter(adapter);
//                mUserList.setOnItemClickListener(new OnItemClickListener()
//                {
//
//                    @Override
//                    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
//                    {
//
//                        UserInfo info = users.get(position);
//                        String temp;
//                        temp = !TextUtils.isEmpty(temp = info.name) ? temp : !TextUtils.isEmpty(temp = info.uname) ? temp : info.userid;
//                        UserInfoActivity.launch(UserAttentionActivity.this, temp, info.mid, info.face);
//                    }
//                });
            } else
            {
                LogUtil.lsw("关注的人为空");
            }
            finishGetListTask();
        }
    }
}
