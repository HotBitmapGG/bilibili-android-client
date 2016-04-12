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
import com.hotbitmapgg.ohmybilibili.adapter.UpMoreCoverAdapter;
import com.hotbitmapgg.ohmybilibili.model.UserVideoItem;
import com.hotbitmapgg.ohmybilibili.model.UserVideoList;
import com.hotbitmapgg.ohmybilibili.network.ApiHelper;
import com.hotbitmapgg.ohmybilibili.okhttp.OkHttpClientManager;
import com.hotbitmapgg.ohmybilibili.utils.LogUtil;
import com.hotbitmapgg.ohmybilibili.widget.CircleProgressView;
import com.squareup.okhttp.Request;

import java.util.ArrayList;
import java.util.List;

import cn.easydone.swiperefreshendless.EndlessRecyclerOnScrollListener;
import cn.easydone.swiperefreshendless.HeaderViewRecyclerAdapter;

/**
 * Created by hcc on 16/4/2.
 * Up主上传视频查看更多
 */
public class UpMoreCoverActivity extends AppCompatActivity
{

    private String uName;

    private static final String EXTRA_USER_NAME = "extra_user_name", EXTRA_MID = "extra_mid";

    private int mid;

    private List<UserVideoItem> userVideoList = new ArrayList<>();

    private int pageNum = 1;

    private int pageSize = 10;

    private RecyclerView mRecycleView;

    private CircleProgressView mCircleProgressView;

    private HeaderViewRecyclerAdapter mHeaderViewRecyclerAdapter;

    private UpMoreCoverAdapter upMoreCoverAdapter;

    private View loadMoreView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        if (intent != null)
        {
            uName = intent.getStringExtra(EXTRA_USER_NAME);
            mid = intent.getIntExtra(EXTRA_MID, -1);
        }

        setContentView(R.layout.activity_up_more_cover);


        initToolBar();
        initView();
    }

    private void initView()
    {

        mRecycleView = (RecyclerView) findViewById(R.id.up_more_recycle);
        mCircleProgressView = (CircleProgressView) findViewById(R.id.circle_progress);
        mCircleProgressView.setVisibility(View.VISIBLE);
        mCircleProgressView.spin();
        getUserVideoList();
    }

    private void initToolBar()
    {

        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setNavigationIcon(R.drawable.action_button_back_pressed_light);
        mToolbar.setTitle(uName + "的投稿");
        mToolbar.setNavigationOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {

                finish();
            }
        });
    }


    public static void launch(Activity activity, String name, int mid)
    {

        Intent intent = new Intent(activity, UpMoreCoverActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra(EXTRA_USER_NAME, name);
        intent.putExtra(EXTRA_MID, mid);
        activity.startActivity(intent);
    }


    private void getUserVideoList()
    {

        String url = ApiHelper.getUserVideoListUrl(mid, pageNum, pageSize);
        OkHttpClientManager.getAsyn(url, new OkHttpClientManager.ResultCallback<String>()

                {

                    @Override
                    public void onError(Request request, Exception e)
                    {
                        // TODO Auto-generated method stub

                    }

                    @Override
                    public void onResponse(String response)
                    {

                        UserVideoList videoList = UserVideoList.createFromJson(response);
                        if (videoList != null)
                        {
                            List<UserVideoItem> datas = videoList.lists;
                            userVideoList.addAll(datas);

                            finishUserVideoListGetTask();
                        }
                    }
                }
        );
    }

    private void finishUserVideoListGetTask()
    {

        mCircleProgressView.stopSpinning();
        mCircleProgressView.setVisibility(View.GONE);
        mRecycleView.setHasFixedSize(true);

        upMoreCoverAdapter = new UpMoreCoverAdapter(mRecycleView, userVideoList);
        mRecycleView.setHasFixedSize(true);
        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(this);
        mRecycleView.setLayoutManager(mLinearLayoutManager);
        mHeaderViewRecyclerAdapter = new HeaderViewRecyclerAdapter(upMoreCoverAdapter);
        mRecycleView.setAdapter(mHeaderViewRecyclerAdapter);
        createLoadMoreView();
        mRecycleView.addOnScrollListener(new EndlessRecyclerOnScrollListener(mLinearLayoutManager)
        {

            @Override
            public void onLoadMore(int i)
            {

                pageNum++;
                loadMoreData();
            }
        });
    }

    private void loadMoreData()
    {

        String url = ApiHelper.getUserVideoListUrl(mid, pageNum, pageSize);
        OkHttpClientManager.getAsyn(url, new OkHttpClientManager.ResultCallback<String>()

                {

                    @Override
                    public void onError(Request request, Exception e)
                    {
                        // TODO Auto-generated method stub

                    }

                    @Override
                    public void onResponse(String response)
                    {

                        UserVideoList videoList = UserVideoList.createFromJson(response);
                        if (videoList != null)
                        {
                            List<UserVideoItem> datas = videoList.lists;
                            if (datas != null && datas.size() > 0)
                            {
                                int size = datas.size();
                                for (int i = 0; i < size; i++)
                                {
                                    upMoreCoverAdapter.addData(datas.get(i));
                                }
                                if (size < pageSize)
                                {
                                    mHeaderViewRecyclerAdapter.notifyDataSetChanged();
                                }
                                loadMoreView.setVisibility(View.VISIBLE);
                                mHeaderViewRecyclerAdapter.notifyDataSetChanged();
                            } else
                            {
                                LogUtil.lsw("数据为空");
                                mHeaderViewRecyclerAdapter.notifyDataSetChanged();
                                loadMoreView.setVisibility(View.GONE);
                            }
                        } else
                        {
                            mHeaderViewRecyclerAdapter.notifyDataSetChanged();
                        }
                    }
                }
        );
    }

    private void createLoadMoreView()
    {

        loadMoreView = LayoutInflater.from(UpMoreCoverActivity.this).inflate(R.layout.recycle_view_foot_layout, mRecycleView, false);
        mHeaderViewRecyclerAdapter.addFooterView(loadMoreView);
    }
}
