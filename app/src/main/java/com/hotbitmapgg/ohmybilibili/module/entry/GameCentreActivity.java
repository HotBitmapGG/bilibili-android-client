package com.hotbitmapgg.ohmybilibili.module.entry;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.adapter.GameCentreAdapter;
import com.hotbitmapgg.ohmybilibili.base.RxAppCompatBaseActivity;
import com.hotbitmapgg.ohmybilibili.entity.game.GameItem;
import com.hotbitmapgg.ohmybilibili.widget.CircleProgressView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.Bind;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;

/**
 * Created by hcc on 16/8/7 14:12
 * 100332338@qq.com
 * <p/>
 * 游戏中心界面
 */
public class GameCentreActivity extends RxAppCompatBaseActivity
{


    @Bind(R.id.recycle)
    RecyclerView mRecycle;

    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    @Bind(R.id.circle_progress)
    CircleProgressView mCircleProgressView;

    private int[] gameimages = new int[]{
            R.drawable.game_1,
            R.drawable.game_2,
            R.drawable.game_3,
            R.drawable.game_4,
            R.drawable.game_5,
            R.drawable.game_6,
            R.drawable.game_7,
            R.drawable.game_8,
            R.drawable.game_9,
            R.drawable.game_10,
            R.drawable.game_11,
            R.drawable.game_12,
            };

    private String[] gametexts = new String[]{
            "命运-冠位指定（Fate/GO）",
            "少女前线",
            "苍之骑士团",
            "ICHU偶像进行曲",
            "幻游猎人",
            "阴阳师",
            "神代梦华谭",
            "少女咖啡枪",
            "大航海之路",
            "皇牌机娘",
            "妖刀少女异闻录",
            "螺旋境界线",
            };


    private String[] gameDetails = new String[]
            {
                    "Fate系列首款正版手游即将开启！",
                    "战地誓约，守护羁绊",
                    "王国的命运，就交到你手上了",
                    "把我变成真正的偶像吧！",
                    "即时冒险RPG手游《幻游猎人》预约开启！",
                    "唯美如樱，百鬼物语",
                    "想变成蝴蝶Σ(:0」∠)_",
                    "少女×枪战",
                    "目标是星辰大海",
                    "二次元战机娘化游戏",
                    "拔刀吧，少女！",
                    "幻想之境，触手可及！",
                    };

    private String[] gamepaths = new String[]{
            "http://fgo.biligame.com/dy/",
            "http://gf.biligame.com/",
            "http://czqst.biligame.com/",
            "http://ichu.biligame.com/",
            "http://hylr.biligame.com/yuyue/",
            "http://yys.biligame.com/",
            "http://sdmht.biligame.com/yuyue.html",
            "http://kfq.biligame.com/yuyue/",
            "http://dhh.biligame.com/",
            "http://hpjn.biligame.com/",
            "http://ydsnywl.biligame.com/",
            "http://lxjjx.biligame.com/yuyue/",
            };

    private List<GameItem> games = new ArrayList<>();


    @Override
    public int getLayoutId()
    {

        return R.layout.activity_game_center;
    }

    @Override
    public void initViews(Bundle savedInstanceState)
    {

        showProgress();
        setGameFill();
    }

    private void setGameFill()
    {

        Observable.timer(2000, TimeUnit.MILLISECONDS)
                .compose(this.<Long> bindToLifecycle())
                .doOnSubscribe(new Action0()
                {

                    @Override
                    public void call()
                    {

                        showProgress();
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Long>()
                {

                    @Override
                    public void call(Long aLong)
                    {

                        initData();
                    }
                });
    }

    @Override
    public void initToolBar()
    {

        mToolbar.setTitle("游戏中心");
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null)
            actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {

        switch (item.getItemId())
        {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initData()
    {

        GameItem mGameItem;
        for (int i = 0; i < gametexts.length; i++)
        {
            mGameItem = new GameItem();
            mGameItem.imageRes = gameimages[i];
            mGameItem.name = gametexts[i];
            mGameItem.desc = gameDetails[i];
            mGameItem.path = gamepaths[i];

            games.add(mGameItem);
        }

        hideProgress();
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
        initRecyclerView();
    }

    private void initRecyclerView()
    {

        mRecycle.setHasFixedSize(true);
        mRecycle.setLayoutManager(new LinearLayoutManager(GameCentreActivity.this));
        GameCentreAdapter mAdapter = new GameCentreAdapter(mRecycle, games);
        mRecycle.setAdapter(mAdapter);
    }
}
