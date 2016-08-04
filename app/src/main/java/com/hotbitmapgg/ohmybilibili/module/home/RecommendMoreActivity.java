package com.hotbitmapgg.ohmybilibili.module.home;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.module.video.VideoDetailsActivity;
import com.hotbitmapgg.ohmybilibili.adapter.RecommendMoreAdapter;
import com.hotbitmapgg.ohmybilibili.adapter.RecommendMoreMenuAdapter;
import com.hotbitmapgg.ohmybilibili.api.RecommendApi;
import com.hotbitmapgg.ohmybilibili.base.RxAppCompatBaseActivity;
import com.hotbitmapgg.ohmybilibili.model.BasicMessage;
import com.hotbitmapgg.ohmybilibili.model.RecommendList;
import com.hotbitmapgg.ohmybilibili.model.VideoItemInfo;
import com.hotbitmapgg.ohmybilibili.utils.LogUtil;
import com.hotbitmapgg.ohmybilibili.widget.CircleProgressView;
import com.hotbitmapgg.ohmybilibili.widget.pulldownrefresh.BiliBiliPullDownRefreshListView;

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
 * 首页主站更多界面
 * <p/>
 * 该界面是自己写了个带动画效果的下拉刷新ListView
 * 强行使用了一下，还请见谅
 *
 * @HotBitmapGG
 */
public class RecommendMoreActivity extends RxAppCompatBaseActivity
{

    @Bind(R.id.recommend_pull_refresh_list)
    BiliBiliPullDownRefreshListView mPullToRefreshListView;

    @Bind(R.id.recommend_more_list_circle_progress)
    CircleProgressView mCircleProgressView;

    public enum RefreshType
    {
        REFRESH, LOAD_MORE
    }

    private RefreshType mRefreshType = RefreshType.LOAD_MORE;

    private int pageNum = 1;

    private List<VideoItemInfo> videoInfos = new ArrayList<VideoItemInfo>();

    private RecommendMoreAdapter mAdapter;

    private ListView expandListView;

    // 泡泡窗体
    private PopupWindow mFilterPopupWindow;

    private int order;

    private ImageView mRightBtn;

    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler()
    {

        public void handleMessage(android.os.Message msg)
        {

            if (msg.what == 0)
            {
                mPullToRefreshListView.setVisibility(View.VISIBLE);
                mAdapter = new RecommendMoreAdapter(RecommendMoreActivity.this, videoInfos);
                mPullToRefreshListView.setAdapter(mAdapter);
                mPullToRefreshListView.setOnRefreshComplete();
                mCircleProgressView.setVisibility(View.GONE);
                mCircleProgressView.stopSpinning();
            }
        }

        ;
    };


    @Override
    public int getLayoutId()
    {

        return R.layout.activity_recommend_more;
    }

    @Override
    public void initViews(Bundle savedInstanceState)
    {


        Intent intent = getIntent();
        if (intent != null)
        {
            order = intent.getIntExtra("order", 0);
        }


        mPullToRefreshListView.setOnAcFunRefreshListener(new BiliBiliPullDownRefreshListView.OnAcFunRefreshListener()
        {

            @Override
            public void onRefresh()
            {

                mRefreshType = RefreshType.REFRESH;
                pageNum = 1;
                queryRecommendMoreList(order);
            }

            @Override
            public void onLoadMore()
            {

                mRefreshType = RefreshType.LOAD_MORE;
                pageNum++;
                loadMoreVideo();
            }
        });

        mPullToRefreshListView.setOnItemClickListener(new OnItemClickListener()
        {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {

                VideoItemInfo mItemInfo = (VideoItemInfo) mAdapter.getItem(position - 1);
                VideoDetailsActivity.launch(RecommendMoreActivity.this, mItemInfo);
            }
        });

        startQueryVideoList(order);
    }

    @Override
    public void initToolBar()
    {

        View view = findViewById(R.id.recommend_top);
        ImageView mBack = (ImageView) view.findViewById(R.id.left_btn);
        TextView mTitle = (TextView) view.findViewById(R.id.top_title);
        mRightBtn = (ImageView) view.findViewById(R.id.right_btn);
        mRightBtn.setVisibility(View.VISIBLE);
        mRightBtn.setImageResource(R.drawable.ic_menu_more);
        mBack.setVisibility(View.VISIBLE);
        mTitle.setText("推荐列表");
        mBack.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {

                finish();
            }
        });
        mRightBtn.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {

                initFilterMenu();
            }
        });
    }


    private void startQueryVideoList(int order)
    {

        mPullToRefreshListView.setVisibility(View.GONE);
        mCircleProgressView.setVisibility(View.VISIBLE);
        mCircleProgressView.spin();
        queryRecommendMoreList(order);
    }


    protected void loadMoreVideo()
    {

        Single<BasicMessage<RecommendList>> observable = Single.fromCallable(new Callable<BasicMessage<RecommendList>>()
        {

            @Override
            public BasicMessage<RecommendList> call() throws Exception
            {

                return RecommendApi.getList(null, pageNum + "", "10", order);
            }
        });


        Subscription subscribe = observable.map(new Func1<BasicMessage<RecommendList>,List<VideoItemInfo>>()
        {

            @Override
            public List<VideoItemInfo> call(BasicMessage<RecommendList> recommendListBasicMessage)
            {

                return recommendListBasicMessage.getObject().lists;
            }
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleSubscriber<List<VideoItemInfo>>()
                {

                    @Override
                    public void onSuccess(List<VideoItemInfo> value)
                    {

                        if (value != null)
                        {
                            if (value != null && value.size() > 0)
                            {
                                int size = value.size();
                                for (int i = 0; i < size; i++)
                                {
                                    VideoItemInfo videoItemInfo = value.get(i);
                                    mAdapter.addData(videoItemInfo);
                                }
                                mAdapter.notifyDataSetChanged();
                                mPullToRefreshListView.loadingComplete();
                            }
                        }
                    }

                    @Override
                    public void onError(Throwable error)
                    {

                        LogUtil.lsw("上拉加载数据失败");
                        mPullToRefreshListView.loadingComplete();
                    }
                });

        compositeSubscription.add(subscribe);
    }

    /**
     * 查询热门推荐视频
     */
    protected void queryRecommendMoreList(final int order)
    {

        Single<BasicMessage<RecommendList>> observable = Single.fromCallable(new Callable<BasicMessage<RecommendList>>()
        {

            @Override
            public BasicMessage<RecommendList> call() throws Exception
            {

                return RecommendApi.getList(null, pageNum + "", "10", order);
            }
        });


        Subscription subscribe = observable.map(new Func1<BasicMessage<RecommendList>,List<VideoItemInfo>>()
        {

            @Override
            public List<VideoItemInfo> call(BasicMessage<RecommendList> recommendListBasicMessage)
            {

                return recommendListBasicMessage.getObject().lists;
            }
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleSubscriber<List<VideoItemInfo>>()
                {

                    @Override
                    public void onSuccess(List<VideoItemInfo> value)
                    {

                        if (value != null)
                        {

                            if (mRefreshType == RefreshType.REFRESH)
                            {
                                videoInfos.clear();
                            }
                            if (value.size() < 10)
                            {
                                LogUtil.lsw("数据全部加载完毕");
                                mPullToRefreshListView.allDataLoadingComplete();
                            }
                            if (value != null && value.size() > 0)
                            {
                                videoInfos.addAll(value);
                                mHandler.sendEmptyMessageDelayed(0, 3000);
                            }
                        }
                    }

                    @Override
                    public void onError(Throwable error)
                    {

                        LogUtil.lsw("数据为空");
                        mPullToRefreshListView.setOnRefreshComplete();
                    }
                });

        compositeSubscription.add(subscribe);
    }


    /**
     * 菜单窗口
     */
    private void initFilterMenu()
    {

        LayoutInflater mLayoutInfalter = (LayoutInflater) RecommendMoreActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View menuView = mLayoutInfalter.inflate(R.layout.popup_window_message, null);

        // 展示下拉列表的ListView
        expandListView = (ListView) menuView.findViewById(R.id.listView1);
        expandListView.setOnItemClickListener(new OnItemClickListener()
        {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {

                if (mFilterPopupWindow != null)
                {
                    mFilterPopupWindow.dismiss();
                }

                switch (position)
                {
                    case 0:
                        // 最新投稿
                        startQueryVideoList(RecommendApi.ORDER_DEFAULT);
                        order = RecommendApi.ORDER_DEFAULT;
                        mRefreshType = RefreshType.REFRESH;
                        break;

                    case 1:
                        // 新评论
                        startQueryVideoList(RecommendApi.ORDER_NEW);
                        order = RecommendApi.ORDER_NEW;
                        mRefreshType = RefreshType.REFRESH;
                        break;

                    case 2:
                        // 评论数
                        startQueryVideoList(RecommendApi.ORDER_REVIEW);
                        order = RecommendApi.ORDER_REVIEW;
                        mRefreshType = RefreshType.REFRESH;
                        break;

                    case 3:
                        // 点击数
                        startQueryVideoList(RecommendApi.ORDER_HOT);
                        order = RecommendApi.ORDER_HOT;
                        mRefreshType = RefreshType.REFRESH;
                        break;

                    case 4:
                        // 弹幕数
                        startQueryVideoList(RecommendApi.ORDER_DAMKU);
                        order = RecommendApi.ORDER_DAMKU;
                        mRefreshType = RefreshType.REFRESH;
                        break;

                    case 5:
                        // 推荐数
                        startQueryVideoList(RecommendApi.ORDER_COMMENT);
                        order = RecommendApi.ORDER_COMMENT;
                        mRefreshType = RefreshType.REFRESH;
                        break;

                    case 6:
                        // 硬币数
                        startQueryVideoList(RecommendApi.ORDER_PROMOTE);
                        order = RecommendApi.ORDER_PROMOTE;
                        mRefreshType = RefreshType.REFRESH;
                        break;

                    default:
                        break;
                }
            }
        });
        expandListView.setAdapter(new RecommendMoreMenuAdapter(RecommendMoreActivity.this));
        mFilterPopupWindow = new PopupWindow(menuView, LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);

        // 解决当pw显示时, 无法响应手机的menu back等键的点击事件
        expandListView.setOnKeyListener(new View.OnKeyListener()
        {

            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event)
            {

                if ((keyCode == KeyEvent.KEYCODE_MENU || keyCode == KeyEvent.KEYCODE_BACK) && event.getRepeatCount() == 0)
                {
                    if (mFilterPopupWindow != null && mFilterPopupWindow.isShowing())
                    {
                        mFilterPopupWindow.dismiss();
                    }
                }
                return false;
            }
        });

        // 让pw能够被触摸, 并且获取焦点
        mFilterPopupWindow.setTouchable(true);
        mFilterPopupWindow.setFocusable(true);
        menuView.setOnTouchListener(new OnTouchListener()
        {

            public boolean onTouch(View v, MotionEvent event)
            {

                View view = menuView.findViewById(R.id.listView1);
                int x = (int) event.getX();
                int y = (int) event.getY();
                Rect viewRect = new Rect();
                view.getHitRect(viewRect);
                if (event.getAction() == MotionEvent.ACTION_UP)
                {
                    if (!viewRect.contains(x, y))
                    {
                        if (mFilterPopupWindow != null && mFilterPopupWindow.isShowing())
                        {
                            mFilterPopupWindow.dismiss();
                        }
                    }
                }
                return true;
            }
        });
        mFilterPopupWindow.setOutsideTouchable(true);
        mFilterPopupWindow.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);

        mFilterPopupWindow.update();

        mFilterPopupWindow.setOnDismissListener(new OnDismissListener()
        {

            @Override
            public void onDismiss()
            {

            }
        });

        mFilterPopupWindow.showAsDropDown(mRightBtn);
    }

    @Override
    protected void onDestroy()
    {
        // TODO Auto-generated method stub
        super.onDestroy();

        videoInfos.clear();
        mHandler.removeCallbacksAndMessages(null);
        if (mFilterPopupWindow != null && mFilterPopupWindow.isShowing())
        {
            mFilterPopupWindow.dismiss();
        }
    }
}
