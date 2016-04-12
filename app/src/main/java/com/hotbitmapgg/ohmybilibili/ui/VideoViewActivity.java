package com.hotbitmapgg.ohmybilibili.ui;

import android.animation.Animator;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.adapter.VideoAlikeListAdapter;
import com.hotbitmapgg.ohmybilibili.api.VideoApi;
import com.hotbitmapgg.ohmybilibili.api.VideoCommentApi;
import com.hotbitmapgg.ohmybilibili.model.BasicMessage;
import com.hotbitmapgg.ohmybilibili.model.UserVideoItem;
import com.hotbitmapgg.ohmybilibili.model.UserVideoList;
import com.hotbitmapgg.ohmybilibili.model.VideoComment;
import com.hotbitmapgg.ohmybilibili.model.VideoItemInfo;
import com.hotbitmapgg.ohmybilibili.model.VideoViewInfo;
import com.hotbitmapgg.ohmybilibili.network.ApiHelper;
import com.hotbitmapgg.ohmybilibili.network.AbsAsyncTask;
import com.hotbitmapgg.ohmybilibili.network.UrlHelper;
import com.hotbitmapgg.ohmybilibili.network.Utility;
import com.hotbitmapgg.ohmybilibili.okhttp.OkHttpClientManager;
import com.hotbitmapgg.ohmybilibili.utils.LogUtil;
import com.hotbitmapgg.ohmybilibili.widget.AppBarLayout;
import com.hotbitmapgg.ohmybilibili.widget.CircleProgressView;
import com.hotbitmapgg.ohmybilibili.widget.ExpandableHeightListView;
import com.hotbitmapgg.ohmybilibili.widget.ObservableScrollView;
import com.hotbitmapgg.ohmybilibili.widget.UserTagView;
import com.squareup.okhttp.Request;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class VideoViewActivity extends AppCompatActivity implements ObservableScrollView.OnScrollChangeListener
{

	private ObservableScrollView mScrollView;

	private ImageView mPreviewView;

	private AppBarLayout mAppBarBackground;

	private FrameLayout mAppBarContainer;

	private FloatingActionButton mFAB;

	private CircleProgressView mCircleProgress;

	private LinearLayout mContainer;

	private TextView mTitleText, mPlayTimeText, mReviewCountText, mDescText, mCreatedAtText;

	private UserTagView mAuthorTagView;

	private ExpandableHeightListView mVideoPartList;

	private int av;

	private VideoItemInfo itemInfo;

	private VideoViewInfo viewInfo;
	
	private List<UserVideoItem> userVideoList = new ArrayList<>();

	private boolean isPlayingFABAnimation = false;

	private int APP_BAR_HEIGHT, TOOLBAR_HEIGHT, STATUS_BAR_HEIGHT = 0, minHeight = 0;

	private static String EXTRA_ITEM_INFO = "extra_item_info", EXTRA_AV = "extra_av";

	public static String TAG = VideoViewActivity.class.getSimpleName();

	private VideoAlikeListAdapter mVideoAlikeListAdapter;

	private TextView mMoreVideo;

	private TextView mCommentBuuton;

	private Toolbar mToolBar;

	private View mTitleView;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		APP_BAR_HEIGHT = getResources().getDimensionPixelSize(R.dimen.appbar_parallax_max_height);
		TOOLBAR_HEIGHT = getResources().getDimensionPixelSize(R.dimen.abc_action_bar_default_height_material);
		if (Build.VERSION.SDK_INT >= 19)
		{
			STATUS_BAR_HEIGHT = Utility.getStatusBarHeight(getApplicationContext());
		}
		minHeight = APP_BAR_HEIGHT - TOOLBAR_HEIGHT - STATUS_BAR_HEIGHT;

		Intent intent = getIntent();
		if (intent.hasExtra(EXTRA_ITEM_INFO))
		{
			itemInfo = VideoItemInfo.createFromJson(intent.getStringExtra(EXTRA_ITEM_INFO));
		}
		else if (intent.hasExtra(EXTRA_AV))
		{
			av = intent.getIntExtra(EXTRA_AV, -1);
		}

		setContentView(R.layout.activity_video_view);
		initView();

		if (itemInfo != null)
		{
			Picasso.with(this).load(UrlHelper.getClearVideoPreviewUrl(itemInfo.pic)).into(mPreviewView);
		}

		startGetTask();
	}


	protected void initView()
	{

		mAppBarBackground = (AppBarLayout) findViewById(R.id.appbar_background);
		mAppBarContainer = (FrameLayout) findViewById(R.id.appbar_container);
		mScrollView = (ObservableScrollView) findViewById(R.id.scroll_view);
		mPreviewView = (ImageView) findViewById(R.id.video_preview);
		mFAB = (FloatingActionButton) findViewById(R.id.fab);
		mCircleProgress = (CircleProgressView) findViewById(R.id.circle_progress);
		mContainer = (LinearLayout) findViewById(R.id.container_view);
		mTitleText = (TextView) findViewById(R.id.tv_title);
		mPlayTimeText = (TextView) findViewById(R.id.tv_play_time);
		mReviewCountText = (TextView) findViewById(R.id.tv_review_count);
		mDescText = (TextView) findViewById(R.id.tv_description);
		mCreatedAtText = (TextView) findViewById(R.id.tv_created_at);
		mAuthorTagView = (UserTagView) findViewById(R.id.author_tag);
		mVideoPartList = (ExpandableHeightListView) findViewById(R.id.video_part_list);

		mToolBar = (Toolbar) findViewById(R.id.toolbar);
		mToolBar.setNavigationIcon(R.drawable.action_button_back_pressed_light);
		mToolBar.setNavigationOnClickListener(new View.OnClickListener()
		{

			@Override
			public void onClick(View v)
			{
				finish();
			}
		});

		mMoreVideo = (TextView) findViewById(R.id.btn_more_video);
		mCommentBuuton = (TextView) findViewById(R.id.btn_more_comment);
		mMoreVideo.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View v)
			{
				Intent mIntent = new Intent(VideoViewActivity.this , VideoPartsListMoreActivity.class);
				if(itemInfo != null)
				{
					int aid = itemInfo.aid;
					mIntent.putExtra("aid",  aid + "");
				}
				else
				{
					mIntent.putExtra("aid",  av + "");
				}
				startActivity(mIntent);
			}
		});
		mCommentBuuton.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View v)
			{
				Intent mIntent = new Intent(VideoViewActivity.this , VideoCommentActivity.class);
				if(itemInfo != null)
				{
					int aid = itemInfo.aid;
					mIntent.putExtra("aid",  aid);
				}
				else
				{
					mIntent.putExtra("aid",  av);
				}
				startActivity(mIntent);
			}
		});

		mFAB.setTranslationY(-getResources().getDimension(R.dimen.floating_action_button_size_half));
		mScrollView.addOnScrollChangeListener(this);
		
		mFAB.setOnClickListener(new OnClickListener()
		{
			
			@Override
			public void onClick(View v)
			{
				
				Intent mIntent = new Intent(VideoViewActivity.this , BiliBiliPlayerVideoActivity.class);
				if(itemInfo != null)
				{
					int aid = itemInfo.aid;
					mIntent.putExtra("av",  aid + "");
				}
				else
				{
					mIntent.putExtra("av",  av + "");
				}
			
				mIntent.putExtra("page", "1");
				startActivity(mIntent);
			}
		});
	}

	public static void launch(Activity activity, VideoItemInfo itemInfo)
	{
		Intent intent = new Intent(activity, VideoViewActivity.class);
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		intent.putExtra(EXTRA_ITEM_INFO, itemInfo.toJsonString());
		activity.startActivity(intent);
	}

	public static void launch(Activity activity, int aid)
	{
		Intent intent = new Intent(activity, VideoViewActivity.class);
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		intent.putExtra(EXTRA_AV, aid);
		activity.startActivity(intent);
	}

	private void startGetTask()
	{
		mCircleProgress.setVisibility(View.VISIBLE);
		mCircleProgress.spin();
		mContainer.setVisibility(View.GONE);

		new ViewInfoGetTaskAbs().execute();
		new GetVideoComment().execute();
	}

	private void finishGetTask()
	{
		mCircleProgress.setVisibility(View.GONE);
		mCircleProgress.stopSpinning();

		mContainer.setVisibility(View.VISIBLE);

		// 获取该用户推荐的视频列表
		//new GetAuthorRecommendVideoListTaskAbs().execute();
		getVideoListPartsByTid(viewInfo.tid + "");


		if (itemInfo == null)
		{
			if(!TextUtils.isEmpty(viewInfo.pic))
			{
				Picasso.with(this).load(UrlHelper.getClearVideoPreviewUrl(viewInfo.pic)).into(mPreviewView);	
			}
			else
			{
				mPreviewView.setImageResource(R.drawable.bili_default_image_tv);
			}
			
		}

		mTitleText.setText(viewInfo.title);
		mToolBar.setTitle(viewInfo.title);
		mTitleView = mToolBar.getChildAt(1);
		mTitleView.setVisibility(View.GONE);
		mPlayTimeText.setText(String.format(getString(R.string.info_play_times_format), viewInfo.play));
		mReviewCountText.setText(String.format(getString(R.string.info_reviews_format), viewInfo.review));
		mDescText.setText(viewInfo.description);
		mCreatedAtText.setText(viewInfo.created_at);
		mAuthorTagView.setUpWithInfo(this, viewInfo.author, viewInfo.mid, viewInfo.face);
	}


	public void getVideoListPartsByTid(String tid)
    {

		Random random = new Random();
		int anInt = random.nextInt(50);
		String url = ApiHelper.getVideoListPartsByTid(tid,  anInt + "", "10", "default");
    	LogUtil.lsw(url);
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
				UserVideoList partsList = UserVideoList.createFromJson(response);
				if(partsList != null)
				{
					   List<UserVideoItem> datas = partsList.lists;
					   userVideoList.addAll(datas);

					   finishPartsGetTask();
				}

			}
		});
    }


	private void finishPartsGetTask()
	{

		mVideoAlikeListAdapter = new VideoAlikeListAdapter(VideoViewActivity.this, userVideoList);
		mVideoPartList.setAdapter(mVideoAlikeListAdapter);
		mVideoPartList.setExpanded(true);
		mVideoPartList.setOnItemClickListener(new AdapterView.OnItemClickListener()
		{

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id)
			{
				VideoViewActivity.this.finish();
				UserVideoItem videoItem = mVideoAlikeListAdapter.getItem(position);
				int aid = videoItem.aid;
				VideoViewActivity.launch(VideoViewActivity.this, aid);


			}
		});

	}

	@Override
	public void onScrollChanged(ObservableScrollView view, int x, int y, int oldx, int oldy)
	{
		setViewsTranslation(Math.min(minHeight, y));
	}

	private void setViewsTranslation(int target)
	{
		mAppBarContainer.setTranslationY(-target);
		mAppBarBackground.setTranslationY(target);
		float alpha = Math.min(1, -mAppBarContainer.getTranslationY() / (float) minHeight);
		mAppBarBackground.setAlpha(alpha);

		mFAB.setTranslationY(-getResources().getDimension(R.dimen.floating_action_button_size_half) - target);
		if (alpha > 0.8f && !isPlayingFABAnimation)
		{
			hideFAB();
		}
		else if (alpha < 0.65f && !isPlayingFABAnimation)
		{
			showFAB();
		}
		
		if (alpha > 0.8f)
		{

			mTitleView.setVisibility(View.VISIBLE);
		}
		else if (alpha < 0.65f)
		{
			mTitleView.setVisibility(View.GONE);
		}

		mPreviewView.setTranslationY(target * 0.7f);
	}

	private void showFAB()
	{
		mFAB.animate().scaleX(1f).scaleY(1f).setInterpolator(new OvershootInterpolator()).setListener(new Animator.AnimatorListener()
		{
			@Override
			public void onAnimationStart(Animator animator)
			{
				isPlayingFABAnimation = true;
			}

			@Override
			public void onAnimationEnd(Animator animator)
			{
				isPlayingFABAnimation = false;
				if (mAppBarBackground.getAlpha() > 0.8f)
				{
					hideFAB();
				}
			}

			@Override
			public void onAnimationCancel(Animator animator)
			{
				isPlayingFABAnimation = false;
			}

			@Override
			public void onAnimationRepeat(Animator animator)
			{

			}
		}).start();
	}

	private void hideFAB()
	{
		mFAB.animate().scaleX(0f).scaleY(0f).setInterpolator(new AccelerateInterpolator()).setListener(new Animator.AnimatorListener()
		{
			@Override
			public void onAnimationStart(Animator animator)
			{
				isPlayingFABAnimation = true;
			}

			@Override
			public void onAnimationEnd(Animator animator)
			{
				isPlayingFABAnimation = false;
				if (mAppBarBackground.getAlpha() < 0.65f)
				{
					showFAB();
				}
			}

			@Override
			public void onAnimationCancel(Animator animator)
			{
				isPlayingFABAnimation = false;
			}

			@Override
			public void onAnimationRepeat(Animator animator)
			{

			}
		}).start();
	}

	public class ViewInfoGetTaskAbs extends AbsAsyncTask<Void, Void, BasicMessage<VideoViewInfo>>
	{

		@Override
		protected BasicMessage<VideoViewInfo> doInBackground(Void... params)
		{
			return VideoApi.getVideoViewInfo(itemInfo != null ? itemInfo.aid : av, 0, false);
		}

		@Override
		protected void onPostExecute(BasicMessage<VideoViewInfo> msg)
		{
			if (msg != null && msg.getCode() == BasicMessage.CODE_SUCCEED)
			{
				viewInfo = msg.getObject();
				finishGetTask();
			}
			else
			{

			}
		}

	}


	public class GetVideoComment extends AbsAsyncTask<Void,Void,BasicMessage<VideoComment>>
	{

		@Override
		protected BasicMessage<VideoComment> doInBackground(Void... params)
		{

			return VideoCommentApi.getVideoCommentList(itemInfo != null ? itemInfo.aid : av, 1, 10, 3);
		}

		@Override
		protected void onPostExecute(BasicMessage<VideoComment> videoCommentBasicMessage)
		{

			if (videoCommentBasicMessage != null)
			{
				VideoComment videoComment = videoCommentBasicMessage.getObject();
				if(videoComment != null)
				{
					mCommentBuuton.setText("视频评论" + "(" + videoComment.results + ")" + " " + "点我查看评论~");
				}

			}

			super.onPostExecute(videoCommentBasicMessage);
		}
	}



}
