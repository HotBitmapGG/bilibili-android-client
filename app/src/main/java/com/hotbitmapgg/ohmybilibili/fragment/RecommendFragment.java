package com.hotbitmapgg.ohmybilibili.fragment;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.NestedScrollView;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.CardView;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.adapter.BannerPagerAdapter;
import com.hotbitmapgg.ohmybilibili.api.BannerApi;
import com.hotbitmapgg.ohmybilibili.api.RecommendApi;
import com.hotbitmapgg.ohmybilibili.model.BasicMessage;
import com.hotbitmapgg.ohmybilibili.model.HomeBanner;
import com.hotbitmapgg.ohmybilibili.model.Index;
import com.hotbitmapgg.ohmybilibili.model.LiveBean;
import com.hotbitmapgg.ohmybilibili.model.RecommendList;
import com.hotbitmapgg.ohmybilibili.model.VideoItemInfo;
import com.hotbitmapgg.ohmybilibili.network.AbsAsyncTask;
import com.hotbitmapgg.ohmybilibili.network.ApiHelper;
import com.hotbitmapgg.ohmybilibili.okhttp.OkHttpClientManager;
import com.hotbitmapgg.ohmybilibili.ui.BangumiTimeLineActivity;
import com.hotbitmapgg.ohmybilibili.ui.RecommendMoreActivity;
import com.hotbitmapgg.ohmybilibili.ui.VideoViewActivity;
import com.hotbitmapgg.ohmybilibili.utils.LogUtil;
import com.hotbitmapgg.ohmybilibili.widget.CircleIndicator;
import com.hotbitmapgg.ohmybilibili.widget.CircleProgressView;
import com.squareup.okhttp.Request;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

@SuppressLint("ValidFragment")
public class RecommendFragment extends BaseHomeFragment implements Runnable
{

	private NestedScrollView mScrollView;

	private LinearLayout mContainer;

	private CircleProgressView mCircleProgress;

	private List<CardView> cards;

	private List<CardView> ranks;

	private List<CardView> hots;

	private List<CardView> lives;

	private LinearLayout mUpdateLayout;

	private ImageView mUpdateImg;

	private int pageNum = 1;

	private ObjectAnimator animator;

	private TextView mUpdateText;

	private ViewPager mBannerPager;

	private BannerPagerAdapter mBannerAdapter;

	private CircleIndicator mBannerIndicator;

	private Timer mTimer;

	private BannerTask mTimerTask;

	private SwipeRefreshLayout mSwipeRefreshLayout;

	private int size;

	private int mBannerPosition = 0;

	private boolean mIsUserTouched = false;

	@SuppressLint("HandlerLeak")
	private Handler mHandler = new Handler()
	{
		public void handleMessage(android.os.Message msg)
		{
			if(msg.what == 0)
			{
				new UpdateRecommendTaskAbs().execute();
			}

		};
	};

	private FrameLayout mBangumiIndexLayout;

	private FrameLayout mBangumiTimeLine;

	public static RecommendFragment newInstance()
	{
		RecommendFragment fragment = new RecommendFragment();
		return fragment;
	}

	@Override
	public int getLayoutResId()
	{
		return R.layout.fragment_tab_recommend;
	}

	@Override
	public void finishCreateView(Bundle state)
	{

		mSwipeRefreshLayout = $(R.id.refresh_layout);

		mSwipeRefreshLayout.setColorSchemeResources(R.color.top_bar_bg);
		mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener()
		{
			@Override
			public void onRefresh()
			{
				new GetRecommendTaskAbs().execute();
				new GetRankTaskAbs().execute();
				new GetHotsTaskAbs().execute();
				getLiveList();
			}
		});

		mScrollView = $(R.id.scrollable);
		mCircleProgress = $(R.id.circle_progress);
		mContainer = $(R.id.container);
		mUpdateLayout = $(R.id.ll_update_recommend);
		mUpdateImg = $(R.id.iv_update_recommend);
		mUpdateText = $(R.id.tv_update_recommend);

		//番剧索引
		mBangumiIndexLayout = $(R.id.bangumi_index);
		//新番剧查询
		mBangumiTimeLine = $(R.id.bangumi_timeline);
		mBangumiIndexLayout.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View v)
			{

			}
		});
		mBangumiTimeLine.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View v)
			{
               startActivity(new Intent(getActivity() , BangumiTimeLineActivity.class));
			}
		});


		mBannerPager = $(R.id.banner_pager);
        mBannerIndicator = $(R.id.pager_indicator);

		mBannerPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener()
		{

			@Override
			public void onPageSelected(int position)
			{
				mBannerPosition = position;

			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2)
			{
				// TODO Auto-generated method stub

			}

			@Override
			public void onPageScrollStateChanged(int arg0)
			{
				// TODO Auto-generated method stub

			}
		});

		mBannerPager.setOnTouchListener(new View.OnTouchListener()
		{
			@Override
			public boolean onTouch(View v, MotionEvent event)
			{
				int action = event.getAction();
				if (action == MotionEvent.ACTION_DOWN || action == MotionEvent.ACTION_MOVE)
				{
					mIsUserTouched = true;
				}
				else if (action == MotionEvent.ACTION_UP)
				{
					mIsUserTouched = false;
				}
				return false;
			}
		});

		mUpdateLayout.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View v)
			{
				//点击换一波推荐 执行旋转动画
				updateRecommend();


			}
		});


		//最新推荐
		cards = new ArrayList<>();

		cards.add((CardView) $(R.id.card_frame_0));
		cards.add((CardView) $(R.id.card_frame_1));
		cards.add((CardView) $(R.id.card_frame_2));
		cards.add((CardView) $(R.id.card_frame_3));
		cards.add((CardView) $(R.id.card_frame_4));
		cards.add((CardView) $(R.id.card_frame_5));



		$(R.id.btn_recommend_more).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View view)
			{
				//首页推荐查看更多
				Intent mIntent = new Intent(getActivity() , RecommendMoreActivity.class);
				mIntent.putExtra("order", RecommendApi.ORDER_DEFAULT);
				startActivity(mIntent);
			}
		});

		//播放最多推荐
		ranks = new ArrayList<>();

		ranks.add((CardView) $(R.id.rank_card_frame_0));
		ranks.add((CardView) $(R.id.rank_card_frame_1));
		ranks.add((CardView) $(R.id.rank_card_frame_2));
		ranks.add((CardView) $(R.id.rank_card_frame_3));

		$(R.id.btn_rank_more).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View view)
			{
				//播放最多查看更多
				Intent mIntent = new Intent(getActivity() , RecommendMoreActivity.class);
				mIntent.putExtra("order", RecommendApi.ORDER_HOT);
				startActivity(mIntent);
			}
		});

		//热门推荐
		hots = new ArrayList<>();

		hots.add((CardView) $(R.id.hot_card_frame_0));
		hots.add((CardView) $(R.id.hot_card_frame_1));
		hots.add((CardView) $(R.id.hot_card_frame_2));
		hots.add((CardView) $(R.id.hot_card_frame_3));

		$(R.id.btn_hot_more).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View view)
			{
				//热门推荐查看更多
				Intent mIntent = new Intent(getActivity() , RecommendMoreActivity.class);
				mIntent.putExtra("order", RecommendApi.ORDER_COMMENT);
				startActivity(mIntent);
			}
		});

		//直播专区
		lives = new ArrayList<>();

		lives.add((CardView) $(R.id.live_card_frame_0));
		lives.add((CardView) $(R.id.live_card_frame_1));

		$(R.id.btn_live_more).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View view)
			{
				//直播中心查看更多

			}
		});

		startGetTask();
		startBannerGetTask();
	}

	protected void updateRecommend()
	{
		//文字修改
		mUpdateText.setText("嘿咻,嘿咻~");
		//执行动画
		startUpdateAnim();
		//获取一波推荐
		pageNum++;
		//延迟2s执行
		mHandler.sendEmptyMessageDelayed(0, 2000);

	}

	protected void startUpdateAnim()
	{
		animator = ObjectAnimator.ofFloat(mUpdateImg, "rotation", 0 , 360);
		animator.setDuration(1000);
		animator.setInterpolator(new LinearInterpolator());
		animator.setRepeatMode(ValueAnimator.RESTART);
		animator.setRepeatCount(2);
		animator.start();


	}

	protected void stoptUpdateAnim()
	{
		animator.end();
		animator = null;
		mUpdateText.setText("换一波推荐");
	}

	private void startGetTask()
	{
		mCircleProgress.setVisibility(View.VISIBLE);
		mCircleProgress.spin();
		mContainer.setVisibility(View.GONE);

		new GetRecommendTaskAbs().execute();
		new GetRankTaskAbs().execute();
		new GetHotsTaskAbs().execute();

		getLiveList();
	}

	private void finishGetTask()
	{
		mCircleProgress.setVisibility(View.GONE);
		mCircleProgress.stopSpinning();
		mContainer.setVisibility(View.VISIBLE);

		mSwipeRefreshLayout.setRefreshing(false);

	}

	@Override
	public void scrollToTop()
	{
		//mScrollView.smoothScrollTo(mScrollView.getScrollX(), 0);
	}

	@Override
	public boolean canScrollVertically(int direction)
	{
		//return mScrollView != null && mScrollView.canScrollVertically(direction);
		return  true;
	}

	@Override
	public void notifyIndexDataUpdate(Index data)
	{

	}

	@Override
	public void run()
	{
		if (mBannerPosition == size - 1)
		{
			mBannerPager.setCurrentItem(size - 1, false);
		}
		else
		{
			mBannerPager.setCurrentItem(mBannerPosition);
		}
	}

		private void startBannerGetTask()
	{
		new BannerGetTaskAbs().execute();
	}

	public void startViewPagerRun()
	{
		//执行ViewPager进行轮播
		mTimer = new Timer();
		mTimerTask = new BannerTask();
		mTimer.schedule(mTimerTask, 10000, 10000);

	}


	@SuppressLint("NewApi")
	private class BannerGetTaskAbs extends AbsAsyncTask<Void, Void, BasicMessage<ArrayList<HomeBanner>>>
	{

		@Override
		protected BasicMessage<ArrayList<HomeBanner>> doInBackground(Void... params)
		{

			return BannerApi.getBanner();
		}

		@Override
		protected void onPostExecute(BasicMessage<ArrayList<HomeBanner>> msg)
		{
			if (msg != null && msg.getCode() == BasicMessage.CODE_SUCCEED)
			{
				mBannerIndicator.setVisibility(View.VISIBLE);
				size = msg.getObject().size();
				mBannerAdapter = new BannerPagerAdapter(getChildFragmentManager(), msg.getObject());
				mBannerPager.setAdapter(mBannerAdapter);
				mBannerIndicator.setViewPager(mBannerPager);

				startViewPagerRun();
			}
			else
			{
				LogUtil.lsw("数据加载失败");
			}
		}
	}


	private class UpdateRecommendTaskAbs extends AbsAsyncTask<Void, Void, BasicMessage<RecommendList>>
	{

		@Override
		protected BasicMessage<RecommendList> doInBackground(Void... params)
		{
			return RecommendApi.getList(null, pageNum + "", "6", RecommendApi.ORDER_DEFAULT);
		}

		@Override
		protected void onPostExecute(BasicMessage<RecommendList> result)
		{
			if (result != null)
			{
				if (result.getCode() == BasicMessage.CODE_SUCCEED)
				{
					for (int i = 0; i < 6; i++)
					{

						cards.get(i).addView(createVideoCard(result.getObject().lists.get(i)));
					}

					stoptUpdateAnim();
				}
			}
			else
			{
				LogUtil.lsw("数据为空");
			}
		}

	}



	private class GetRecommendTaskAbs extends AbsAsyncTask<Void, Void, BasicMessage<RecommendList>>
	{

		@Override
		protected BasicMessage<RecommendList> doInBackground(Void... params)
		{
			return RecommendApi.getList(null, "1", "6", RecommendApi.ORDER_DEFAULT);
		}

		@Override
		protected void onPostExecute(BasicMessage<RecommendList> result)
		{
			if (result != null)
			{
				LogUtil.lsw(result.getCode() + "###");
				if (result.getCode() == BasicMessage.CODE_SUCCEED)
				{
					for (int i = 0; i < 6; i++)
					{
						cards.get(i).addView(createVideoCard(result.getObject().lists.get(i)));
					}
				}
			}
			else
			{
				LogUtil.lsw("数据为空");
			}
		}

	}

	private class GetRankTaskAbs extends AbsAsyncTask<Void, Void, BasicMessage<RecommendList>>
	{

		@Override
		protected BasicMessage<RecommendList> doInBackground(Void... params)
		{
			Random mRandom = new Random();
			int nextInt = mRandom.nextInt(100);
			return RecommendApi.getList(null, nextInt + "", "4", RecommendApi.ORDER_HOT);
		}

		@Override
		protected void onPostExecute(BasicMessage<RecommendList> result)
		{
			if (result != null)
			{
				LogUtil.lsw(result.getCode() + "###");
				if (result.getCode() == BasicMessage.CODE_SUCCEED)
				{
					for (int i = 0; i < 4; i++)
					{

						ranks.get(i).addView(createVideoCard(result.getObject().lists.get(i)));
					}
				}
			}
			else
			{
				LogUtil.lsw("数据为空");
			}
		}

	}


	private class GetHotsTaskAbs extends AbsAsyncTask<Void, Void, BasicMessage<RecommendList>>
	{

		@Override
		protected BasicMessage<RecommendList> doInBackground(Void... params)
		{
			Random mRandom = new Random();
			int nextInt = mRandom.nextInt(100);
			return RecommendApi.getList(null, nextInt + "", "4", RecommendApi.ORDER_COMMENT);
		}

		@Override
		protected void onPostExecute(BasicMessage<RecommendList> result)
		{
			if (result != null)
			{
				LogUtil.lsw(result.getCode() + "###");
				if (result.getCode() == BasicMessage.CODE_SUCCEED)
				{
					for (int i = 0; i < 4; i++)
					{

						hots.get(i).addView(createVideoCard(result.getObject().lists.get(i)));
					}

					finishGetTask();
				}
			}
			else
			{
				LogUtil.lsw("数据为空");
			}
		}

	}

	public void getLiveList()
	{
		OkHttpClientManager.getAsyn(ApiHelper.GET_LIVE_LIST_URL, new OkHttpClientManager.ResultCallback<LiveBean>()
		{

			@Override
			public void onError(Request request, Exception e)
			{
				// TODO Auto-generated method stub

			}

			@Override
			public void onResponse(LiveBean response)
			{
				if(response != null)
				{
					for (int i = 0; i < 2; i++)
					{

						lives.get(i).addView(createLiveCard(response.data.get(i)));
					}
				}

			}
		});
	}



	@SuppressLint("InflateParams")
	private CardView createVideoCard(VideoItemInfo info)
	{
		CardView view = (CardView) getLayoutInflater().inflate(R.layout.card_item_home_common, null);

		TextView mTitle = (TextView) view.findViewById(R.id.video_title);
		TextView mPlayNum = (TextView) view.findViewById(R.id.video_play_num);
		TextView mReviewNum = (TextView) view.findViewById(R.id.video_review_count);
		mTitle.setText(info.title);
		Picasso.with(getApplicationContext()).load(info.pic).placeholder(R.drawable.bili_default_image_tv).error(R.drawable.bili_default_image_tv).into((ImageView) view.findViewById(R.id.video_preview));
		mPlayNum.setText(info.play);
		mReviewNum.setText(info.video_review + "");

		view.setTag(info);
		view.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View view)
			{
				if (view.getTag() instanceof VideoItemInfo)
				{
					VideoItemInfo info = (VideoItemInfo) view.getTag();
					VideoViewActivity.launch(getSupportActivity(), info);
				}
			}
		});

		return view;
	}

	@SuppressLint("InflateParams")
	private CardView createLiveCard(LiveBean.LiveData liveBean)
	{
		CardView view = (CardView) getLayoutInflater().inflate(R.layout.card_item_home_live, null);

		TextView mTitle = (TextView) view.findViewById(R.id.live_title);
		TextView mUserName = (TextView) view.findViewById(R.id.live_user_name);
		TextView mLiveNum = (TextView) view.findViewById(R.id.live_num);
		mTitle.setText(liveBean.title);
		Picasso.with(getApplicationContext()).load(liveBean.face).placeholder(R.drawable.ico_user_default).into((ImageView) view.findViewById(R.id.live_user_avater));
		Picasso.with(getApplicationContext()).load(liveBean.cover).placeholder(R.drawable.bili_default_image_tv).into((ImageView) view.findViewById(R.id.live_preview));
		mUserName.setText(liveBean.uname);
		mLiveNum.setText(liveBean.online + "");

		view.setTag(liveBean);
		view.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View view)
			{
				if (view.getTag() instanceof LiveBean.LiveData)
				{
					LiveBean.LiveData liveData = (LiveBean.LiveData) view.getTag();


				}
			}
		});

		return view;
	}

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		//EventBus.getDefault().register(this);
	}

	@Override
	public void onDestroy()
	{
		// TODO Auto-generated method stub
		super.onDestroy();
		//EventBus.getDefault().unregister(this);
		if(mTimer != null)
		{
			mTimer.cancel();
			mTimer = null;
		}
        if(mTimerTask != null)
		{
			mTimerTask.cancel();
			mTimerTask = null;
		}

	}

	private class BannerTask extends  TimerTask
	{

		@Override
		public void run()
		{
			if (!mIsUserTouched)
			{
				mBannerPosition = (mBannerPosition + 1) % size;
				if (getActivity() != null)
				{
					getActivity().runOnUiThread(RecommendFragment.this);
				}

			}
		}
	}



}
