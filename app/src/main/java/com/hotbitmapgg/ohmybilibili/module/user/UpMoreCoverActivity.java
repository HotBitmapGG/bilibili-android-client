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
import com.hotbitmapgg.ohmybilibili.adapter.UpMoreCoverAdapter;
import com.hotbitmapgg.ohmybilibili.base.RxAppCompatBaseActivity;
import com.hotbitmapgg.ohmybilibili.model.user.UserVideoItem;
import com.hotbitmapgg.ohmybilibili.model.user.UserVideoList;
import com.hotbitmapgg.ohmybilibili.network.ApiHelper;
import com.hotbitmapgg.ohmybilibili.utils.LogUtil;
import com.hotbitmapgg.ohmybilibili.widget.CircleProgressView;
import com.hotbitmapgg.ohmybilibili.widget.swiperefresh.EndlessRecyclerOnScrollListener;
import com.hotbitmapgg.ohmybilibili.widget.swiperefresh.HeaderViewRecyclerAdapter;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import okhttp3.Call;

/**
 * Up主上传视频查看更多
 *
 * @HotBitmapGG
 */
public class UpMoreCoverActivity extends RxAppCompatBaseActivity
{

    @Bind(R.id.up_more_recycle)
    RecyclerView mRecycleView;

    @Bind(R.id.circle_progress)
    CircleProgressView mCircleProgressView;

    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    private String uName;

    private static final String EXTRA_USER_NAME = "extra_user_name", EXTRA_MID = "extra_mid";

    private int mid;

    private List<UserVideoItem> userVideoList = new ArrayList<>();

    private int pageNum = 1;

    private int pageSize = 10;

    private HeaderViewRecyclerAdapter mHeaderViewRecyclerAdapter;

    private UpMoreCoverAdapter upMoreCoverAdapter;

    private View loadMoreView;


    @Override
    public int getLayoutId()
    {

        return R.layout.activity_up_more_cover;
    }

    @Override
    public void initViews(Bundle savedInstanceState)
    {

        Intent intent = getIntent();
        if (intent != null)
        {
            uName = intent.getStringExtra(EXTRA_USER_NAME);
            mid = intent.getIntExtra(EXTRA_MID, -1);
        }

        mCircleProgressView.setVisibility(View.VISIBLE);
        mCircleProgressView.spin();
        getUserVideoList();
    }

    @Override
    public void initToolBar()
    {

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
        OkHttpUtils.get().url(url).build().execute(new StringCallback()
        {

            @Override
            public void onError(Call call, Exception e)
            {

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
        });


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
        OkHttpUtils.get().url(url).build().execute(new StringCallback()
        {

            @Override
            public void onError(Call call, Exception e)
            {

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
        });


    }

    private void createLoadMoreView()
    {

        loadMoreView = LayoutInflater.from(UpMoreCoverActivity.this).inflate(R.layout.recycle_view_foot_layout, mRecycleView, false);
        mHeaderViewRecyclerAdapter.addFooterView(loadMoreView);
    }
}
