package com.hotbitmapgg.ohmybilibili.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.adapter.AbsRecyclerViewAdapter;
import com.hotbitmapgg.ohmybilibili.adapter.VideoPartListAdapter;
import com.hotbitmapgg.ohmybilibili.api.AuthorRecommendApi;
import com.hotbitmapgg.ohmybilibili.model.AuthorRecommend;
import com.hotbitmapgg.ohmybilibili.model.BasicMessage;
import com.hotbitmapgg.ohmybilibili.network.AbsAsyncTask;
import com.hotbitmapgg.ohmybilibili.utils.LogUtil;
import com.hotbitmapgg.ohmybilibili.widget.CircleProgressView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hcc on 16/3/27.
 * <p/>
 * 视频相关查看更多
 */
public class VideoPartsListMoreActivity extends AppCompatActivity
{

    private Toolbar mToolbar;

    private RecyclerView mRecyclerView;

    private CircleProgressView mCircleProgressView;

    private List<AuthorRecommend.AuthorData> authorRecommendList = new ArrayList<>();

    private VideoPartListAdapter mPartListAdapter;

    private String aid;

    private static final String EXTRA_AV = "extra_av";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        if (intent != null)
        {
            aid = intent.getStringExtra("aid");
        }
        setContentView(R.layout.activity_video_parts_list_more);

        initTitle();
        initView();
    }

    private void initView()
    {

        mRecyclerView = (RecyclerView) findViewById(R.id.video_parts_recycle);
        mCircleProgressView = (CircleProgressView) findViewById(R.id.circle_progress);

        startTask();
    }

    private void startTask()
    {

        mCircleProgressView.setVisibility(View.VISIBLE);
        mCircleProgressView.spin();

        new GetAuthorRecommendVideoListTaskAbs().execute();
    }

    private void initTitle()
    {

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle("up主推荐视频");
        mToolbar.setNavigationIcon(R.drawable.action_button_back_pressed_light);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {

                finish();
            }
        });
    }


    public class GetAuthorRecommendVideoListTaskAbs extends AbsAsyncTask<Void,Void,BasicMessage<AuthorRecommend>>
    {

        @Override
        protected BasicMessage<AuthorRecommend> doInBackground(Void... params)
        {

            return AuthorRecommendApi.getAuthorRecommendList(aid);
        }

        @Override
        protected void onPostExecute(BasicMessage<AuthorRecommend> authorRecommendBasicMessage)
        {

            if (authorRecommendBasicMessage != null)
            {
                if (authorRecommendBasicMessage.getCode() == BasicMessage.CODE_SUCCEED)
                {
                    AuthorRecommend authorRecommend = authorRecommendBasicMessage.getObject();
                    List<AuthorRecommend.AuthorData> list = authorRecommend.list;
                    if (list != null && list.size() > 0)
                    {
                        authorRecommendList.addAll(list);

                        finishGetAuthorRecommendListTask();
                    } else
                    {

                        //没有数据
                        LogUtil.lsw("数据为空");
                    }
                } else
                {
                    LogUtil.lsw("请求失败");
                }
            } else
            {
                LogUtil.lsw("数据为空");
            }
        }
    }

    private void finishGetAuthorRecommendListTask()
    {

        mPartListAdapter = new VideoPartListAdapter(mRecyclerView, authorRecommendList);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new GridLayoutManager(VideoPartsListMoreActivity.this, 2));
        mRecyclerView.setAdapter(mPartListAdapter);
        mPartListAdapter.setOnItemClickListener(new AbsRecyclerViewAdapter.OnItemClickListener()
        {

            @Override
            public void onItemClick(int position, AbsRecyclerViewAdapter.ClickableViewHolder holder)
            {

                AuthorRecommend.AuthorData authorData = authorRecommendList.get(position);
                int aid = authorData.aid;
                Intent mIntent = new Intent(VideoPartsListMoreActivity.this, VideoViewActivity.class);
                mIntent.putExtra(EXTRA_AV, aid);
                startActivity(mIntent);
            }
        });


        mCircleProgressView.setVisibility(View.GONE);
        mCircleProgressView.stopSpinning();

//        mVideoPartList.setAdapter(mPartListAdapter);
//        mVideoPartList.setExpanded(true);
//        mVideoPartList.setOnItemClickListener(new OnItemClickListener()
//        {
//
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
//            {
//                //VideoViewActivity.this.finish();
//                AuthorRecommend.AuthorData videoItem = mPartListAdapter.getItem(position);
//                int aid = videoItem.aid;
//                Intent mIntent = new Intent(VideoViewActivity.this, VideoViewActivity.class);
//                mIntent.putExtra(EXTRA_AV, aid);
//                startActivity(mIntent);
//            }
//        });
    }
}
