package com.hotbitmapgg.ohmybilibili.module.home;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.adapter.ListMoreDetailsRecycleAdapter;
import com.hotbitmapgg.ohmybilibili.adapter.base.AbsRecyclerViewAdapter;
import com.hotbitmapgg.ohmybilibili.module.video.VideoDetailsActivity;
import com.hotbitmapgg.ohmybilibili.base.RxAppCompatBaseActivity;
import com.hotbitmapgg.ohmybilibili.model.Index;
import com.hotbitmapgg.ohmybilibili.model.VideoItemInfo;
import com.hotbitmapgg.ohmybilibili.widget.CircleProgressView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * 首页推荐详情界面
 *
 * @HotBitmapGG
 */
public class ListMoreDetailsActivity extends RxAppCompatBaseActivity
{

    @Bind(R.id.recycle)
    RecyclerView mRecyclerView;

    @Bind(R.id.circle_progress)
    CircleProgressView mCircleProgressView;

    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    public static final String EXTRA_TITLE = "extra_title";

    public static final String EXTRA_LIST = "extra_list";

    private String title;

    private Index.FuckList fuckList;

    private List<VideoItemInfo> videoItemInfos = new ArrayList<>();

    private Handler mHandler = new Handler()
    {

        @Override
        public void handleMessage(Message msg)
        {

            if (msg.what == 0)
            {
                setFuckList();
            }
            super.handleMessage(msg);
        }
    };


    @Override
    public int getLayoutId()
    {

        return R.layout.activity_list_more;
    }

    @Override
    public void initViews(Bundle savedInstanceState)
    {

        Intent intent = getIntent();
        if (intent != null)
        {
            Bundle bundle = intent.getExtras();
            title = bundle.getString(EXTRA_TITLE);
            fuckList = (Index.FuckList) bundle.getSerializable(EXTRA_LIST);
        }

        showProgress();
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new GridLayoutManager(ListMoreDetailsActivity.this, 2));
        mHandler.sendEmptyMessageDelayed(0, 1000);
    }

    private void setFuckList()
    {

        VideoItemInfo item0 = fuckList.item0;
        VideoItemInfo item1 = fuckList.item1;
        VideoItemInfo item2 = fuckList.item2;
        VideoItemInfo item3 = fuckList.item3;
        VideoItemInfo item4 = fuckList.item4;
        VideoItemInfo item5 = fuckList.item5;
        VideoItemInfo item6 = fuckList.item6;
        VideoItemInfo item7 = fuckList.item7;
        VideoItemInfo item8 = fuckList.item8;

        videoItemInfos.add(item0);
        videoItemInfos.add(item1);
        videoItemInfos.add(item2);
        videoItemInfos.add(item3);
        videoItemInfos.add(item4);
        videoItemInfos.add(item5);
        videoItemInfos.add(item6);
        videoItemInfos.add(item7);
        videoItemInfos.add(item8);


        ListMoreDetailsRecycleAdapter moreDetailsRecycleAdapter = new ListMoreDetailsRecycleAdapter(mRecyclerView, videoItemInfos);
        mRecyclerView.setAdapter(moreDetailsRecycleAdapter);
        moreDetailsRecycleAdapter.setOnItemClickListener(new AbsRecyclerViewAdapter.OnItemClickListener()
        {

            @Override
            public void onItemClick(int position, AbsRecyclerViewAdapter.ClickableViewHolder holder)
            {

                VideoDetailsActivity.launch(ListMoreDetailsActivity.this, videoItemInfos.get(position));
            }
        });
        hideProgress();
    }

    @Override
    public void initToolBar()
    {

        mToolbar.setNavigationIcon(R.drawable.action_button_back_pressed_light);
        mToolbar.setTitle(title + "详情");
        mToolbar.setNavigationOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {

                finish();
            }
        });
    }

    public static void luancher(Activity activity, String title, Index.FuckList fuckList)
    {

        Intent mIntent = new Intent(activity, ListMoreDetailsActivity.class);
        mIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        Bundle mBundle = new Bundle();
        mBundle.putString(EXTRA_TITLE, title);
        mBundle.putSerializable(EXTRA_LIST, (Serializable) fuckList);
        mIntent.putExtras(mBundle);
        activity.startActivity(mIntent);
    }


    public void showProgress()
    {

        mCircleProgressView.setVisibility(View.VISIBLE);
        mCircleProgressView.spin();
    }

    public void hideProgress()
    {

        mCircleProgressView.setVisibility(View.GONE);
        mCircleProgressView.stopSpinning();
    }

    @Override
    protected void onDestroy()
    {

        super.onDestroy();
        mHandler.removeCallbacksAndMessages(null);
        videoItemInfos.clear();
    }
}
