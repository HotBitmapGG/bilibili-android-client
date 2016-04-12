package com.hotbitmapgg.ohmybilibili.ui;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.adapter.GameCentreAdapter;
import com.hotbitmapgg.ohmybilibili.model.GameItem;
import com.hotbitmapgg.ohmybilibili.widget.CircleProgressView;
import com.hotbitmapgg.ohmybilibili.widget.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hcc on 16/4/9 14:39
 * 100332338@qq.com
 * 游戏中心
 */
public class GameCentreActivity extends AppCompatActivity
{

    private Toolbar mToolbar;

    private RecyclerView mRecycle;

    private CircleProgressView mCircleProgressView;

    private int[] gameimages = new int[]{
            R.drawable.hxzj_gamecenter_smallbanner, R.drawable.wcat_list,
            R.drawable.xwy_list, R.drawable.mlk, R.drawable.img_bh2,
            R.drawable.w
    };

    private String[] gametexts = new String[]{"幻想战姬", "白猫计划", "侠物语", "梅露可物语", "崩坏学院2", "世界2"};

    private String[] gamepaths = new String[]{
            "http://hxzj.biligame.com/", "http://bmjh.biligame.com/",
            "http://xwy.biligame.com/", "http://mlk.biligame.com/", "http://teos2.biligame.com/",
            "http://sj2.biligame.com/"
    };

    private List<GameItem> games = new ArrayList<>();

    private Handler mHandler = new Handler()
    {

        @Override
        public void handleMessage(Message msg)
        {

            super.handleMessage(msg);
            if (msg.what == 0)
            {
                hideProgress();
            }
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_center);

        initToolBar();
        initView();
        initData();
    }

    private void initData()
    {

        GameItem mGameItem;
        for (int i = 0; i < gametexts.length; i++)
        {
            mGameItem = new GameItem();
            mGameItem.imageRes = gameimages[i];
            mGameItem.name = gametexts[i];
            mGameItem.path = gamepaths[i];

            games.add(mGameItem);
        }
    }

    private void initView()
    {

        mRecycle = (RecyclerView) findViewById(R.id.recycle);
        mCircleProgressView = (CircleProgressView) findViewById(R.id.circle_progress);

        showProgress();

        mRecycle.setHasFixedSize(true);
        mRecycle.setLayoutManager(new LinearLayoutManager(GameCentreActivity.this));
        mRecycle.addItemDecoration(new DividerItemDecoration(GameCentreActivity.this, DividerItemDecoration.VERTICAL_LIST));
        GameCentreAdapter mAdapter = new GameCentreAdapter(mRecycle, games);
        mRecycle.setAdapter(mAdapter);

        mHandler.sendEmptyMessageDelayed(0, 2000);
    }

    private void showProgress()
    {

        mCircleProgressView.setVisibility(View.VISIBLE);
        mCircleProgressView.spin();
        mRecycle.setVisibility(View.GONE);
    }

    public void hideProgress()
    {

        mCircleProgressView.setVisibility(View.GONE);
        mCircleProgressView.stopSpinning();
        mRecycle.setVisibility(View.VISIBLE);
    }

    private void initToolBar()
    {

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setNavigationIcon(R.drawable.action_button_back_pressed_light);
        mToolbar.setTitle("游戏中心");
        mToolbar.setNavigationOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {

                finish();
            }
        });
    }
}
