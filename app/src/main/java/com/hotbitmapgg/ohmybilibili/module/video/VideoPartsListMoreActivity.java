package com.hotbitmapgg.ohmybilibili.module.video;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.adapter.VideoPartListAdapter;
import com.hotbitmapgg.ohmybilibili.adapter.base.AbsRecyclerViewAdapter;
import com.hotbitmapgg.ohmybilibili.api.AuthorRecommendApi;
import com.hotbitmapgg.ohmybilibili.base.RxAppCompatBaseActivity;
import com.hotbitmapgg.ohmybilibili.model.user.AuthorRecommend;
import com.hotbitmapgg.ohmybilibili.model.base.BasicMessage;
import com.hotbitmapgg.ohmybilibili.utils.LogUtil;
import com.hotbitmapgg.ohmybilibili.widget.CircleProgressView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import butterknife.Bind;
import rx.Single;
import rx.SingleSubscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * 视频相关查看更多
 *
 * @HotBitmapGG
 */
public class VideoPartsListMoreActivity extends RxAppCompatBaseActivity
{

    @Bind(R.id.video_parts_recycle)
    RecyclerView mRecyclerView;

    @Bind(R.id.circle_progress)
    CircleProgressView mCircleProgressView;

    @Bind(R.id.toolbar)
    Toolbar mToolbar;


    private List<AuthorRecommend.AuthorData> authorRecommendList = new ArrayList<>();

    private VideoPartListAdapter mPartListAdapter;

    private String aid;

    private static final String EXTRA_AV = "extra_av";


    @Override
    public int getLayoutId()
    {

        return R.layout.activity_video_parts_list_more;
    }

    @Override
    public void initViews(Bundle savedInstanceState)
    {

        Intent intent = getIntent();
        if (intent != null)
        {
            aid = intent.getStringExtra("aid");
        }

        startTask();
    }

    @Override
    public void initToolBar()
    {

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


    private void startTask()
    {

        mCircleProgressView.setVisibility(View.VISIBLE);
        mCircleProgressView.spin();

        getAuthorRecommendVideoList();
    }

    public void getAuthorRecommendVideoList()
    {

        Single<BasicMessage<AuthorRecommend>> single = Single.fromCallable(new Callable<BasicMessage<AuthorRecommend>>()
        {

            @Override
            public BasicMessage<AuthorRecommend> call() throws Exception
            {

                return AuthorRecommendApi.getAuthorRecommendList(aid);
            }
        });

        Subscription subscribe = single.map(new Func1<BasicMessage<AuthorRecommend>,AuthorRecommend>()
        {

            @Override
            public AuthorRecommend call(BasicMessage<AuthorRecommend> authorRecommendBasicMessage)
            {

                return authorRecommendBasicMessage.getObject();
            }
        })
                .map(new Func1<AuthorRecommend,List<AuthorRecommend.AuthorData>>()
                {

                    @Override
                    public List<AuthorRecommend.AuthorData> call(AuthorRecommend authorRecommend)
                    {

                        return authorRecommend.list;
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleSubscriber<List<AuthorRecommend.AuthorData>>()
                {

                    @Override
                    public void onSuccess(List<AuthorRecommend.AuthorData> value)
                    {

                        authorRecommendList.addAll(value);

                        finishGetAuthorRecommendListTask();
                    }

                    @Override
                    public void onError(Throwable error)
                    {

                        LogUtil.lsw("视频相关推荐加载失败");
                    }
                });

        compositeSubscription.add(subscribe);
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
                Intent mIntent = new Intent(VideoPartsListMoreActivity.this, VideoDetailsActivity.class);
                mIntent.putExtra(EXTRA_AV, aid);
                startActivity(mIntent);
            }
        });


        mCircleProgressView.setVisibility(View.GONE);
        mCircleProgressView.stopSpinning();
    }
}
