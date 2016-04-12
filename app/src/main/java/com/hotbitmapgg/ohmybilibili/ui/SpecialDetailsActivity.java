package com.hotbitmapgg.ohmybilibili.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.network.AbsAsyncTask;
import com.hotbitmapgg.ohmybilibili.adapter.SpItemAdapter;
import com.hotbitmapgg.ohmybilibili.api.SpApi;
import com.hotbitmapgg.ohmybilibili.model.BasicMessage;
import com.hotbitmapgg.ohmybilibili.model.Sp;
import com.hotbitmapgg.ohmybilibili.widget.CircleProgressView;
import com.hotbitmapgg.ohmybilibili.widget.ExpandableHeightGridView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * 专题视频详情界面
 *
 * @author Administrator
 * @hcc
 */
public class SpecialDetailsActivity extends AppCompatActivity
{

	private ImageView mPreviewImage;

	private TextView mTitleText, mLastUpdateText, mDescText, mPlayTimeText, mVideoCountText;

	private ExpandableHeightGridView mSpVideoList;

	private int spid;

	private String title;

	private Sp sp;

	private int season_id;

	private ArrayList<Sp.Item> spList = new ArrayList<Sp.Item>();

	private TextView mDescMore;

	private TextView mFavourite;

	private TextView mAttention;

	private SpItemAdapter mItemAdapter;

	private CircleProgressView mCircleProgressView;

	private LinearLayout mSpMainLayout;

	private Toolbar mToolbar;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		Intent intent = getIntent();
		String spidStr = intent.getStringExtra("spid");
		spid = Integer.parseInt(spidStr);
		title = intent.getStringExtra("title");
		season_id = intent.getIntExtra("season_id", 0);

		setContentView(R.layout.activity_special_details);

		initView();
		initToolBar();
	}

	private void initToolBar()
	{

		mToolbar = (Toolbar) findViewById(R.id.toolbar);
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

	private void initView()
	{
		mPreviewImage = (ImageView) findViewById(R.id.sp_preview);
		mTitleText = (TextView) findViewById(R.id.sp_title);
		mLastUpdateText = (TextView) findViewById(R.id.sp_last_update_at);
		mDescText = (TextView) findViewById(R.id.sp_desc);
		mPlayTimeText = (TextView) findViewById(R.id.tv_play_time);
		mVideoCountText = (TextView) findViewById(R.id.tv_video_count);
		mSpVideoList = (ExpandableHeightGridView) findViewById(R.id.sp_video_list);
		mDescMore = (TextView) findViewById(R.id.tv_desc_more);
		mFavourite = (TextView) findViewById(R.id.tv_favourite);
		mAttention = (TextView) findViewById(R.id.tv_attention);
		mCircleProgressView = (CircleProgressView) findViewById(R.id.sp_circle_progress);
		mSpMainLayout = (LinearLayout) findViewById(R.id.sp_main);


		startGetSpInfoTask();

	}

	private void startGetSpInfoTask()
	{

		mCircleProgressView.setVisibility(View.VISIBLE);
		mCircleProgressView.spin();
		new SpInfoGetTaskAbs().execute();

	}

	public class SpInfoGetTaskAbs extends AbsAsyncTask<Void, Void, BasicMessage<Sp>>
	{

		@Override
		protected BasicMessage<Sp> doInBackground(Void... params)
		{
			return SpApi.getSpInfo(spid, title);
		}

		@Override
		protected void onPostExecute(BasicMessage<Sp> msg)
		{
			if (msg != null)
			{
				if (msg.getCode() == BasicMessage.CODE_SUCCEED)
				{
					sp = msg.getObject();
					finishGetSpInfo();
				}
				else
				{

				}
			}
		}

	}

	public class SpVideoGetTaskAbs extends AbsAsyncTask<Integer, Void, BasicMessage<ArrayList<Sp.Item>>>
	{

		@Override
		protected BasicMessage<ArrayList<Sp.Item>> doInBackground(Integer... params)
		{
			// bangumi 设置为1时只返回番剧类视频 设置为0时只返回普通视频 不设置则返回所有视频
			return SpApi.getSpItem(spid, season_id, 1);
		}

		@Override
		protected void onPostExecute(BasicMessage<ArrayList<Sp.Item>> msg)
		{
			if (msg != null)
			{
				if (msg.getCode() == BasicMessage.CODE_SUCCEED)
				{
					ArrayList<Sp.Item> spItemList = msg.getObject();
					spList.addAll(spItemList);
					finishGetSpVideoListTask();
				}
				else
				{

				}
			}
		}

	}

	public void finishGetSpInfo()
	{
		// 专题名称
		String spTitle = sp.title;
		// 最后更新日期
		String lastupdate_at = sp.lastupdate_at;
		// 专题简介
		String description = sp.description;
		// 播放次数
		int playCount = sp.view;
		// 专题列表数量
		int count = sp.count;
		// 专题封面
		String cover = sp.cover;
		//收藏数量
		int favourite = sp.favourite;
		//关注数量
		int attention = sp.attention;

		// 初始化界面数据
		Picasso.with(this).load(cover).placeholder(R.drawable.bili_default_image_tv).into(mPreviewImage);
		mTitleText.setText(spTitle);
		mLastUpdateText.setText("最后更新日期:" + lastupdate_at);
		if(!TextUtils.isEmpty(description))
		{
			mDescText.setText(description);
		}
		else
		{
			mDescText.setText("该专题没有任何介绍~");
			mDescMore.setVisibility(View.GONE);
		}

		mPlayTimeText.setText(playCount + "");
		mVideoCountText.setText(count + "话");
		mToolbar.setTitle(spTitle);
		mFavourite.setText(favourite + "");
		mAttention.setText(attention + "");

		mDescMore.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View v)
			{

				mDescText.setEllipsize(null);
				mDescText.setSingleLine(false);
				mDescMore.setVisibility(View.GONE);

			}
		});

		new SpVideoGetTaskAbs().execute();

	}

	public void finishGetSpVideoListTask()
	{

		mCircleProgressView.setVisibility(View.GONE);
		mCircleProgressView.stopSpinning();
		mSpMainLayout.setVisibility(View.VISIBLE);
		mItemAdapter = new SpItemAdapter(SpecialDetailsActivity.this, spList);
		mSpVideoList.setAdapter(mItemAdapter);
		mSpVideoList.setExpanded(true);
		mSpVideoList.setOnItemClickListener(new OnItemClickListener()
		{

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id)
			{

				Sp.Item mItem = (Sp.Item) mItemAdapter.getItem(position);
				int aid = mItem.aid;
				VideoViewActivity.launch(SpecialDetailsActivity.this, aid);

			}
		});


	}

}
