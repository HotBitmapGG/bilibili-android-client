package com.hotbitmapgg.ohmybilibili.adapter.section;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.adapter.SecondElementBangumiAdapter;
import com.hotbitmapgg.ohmybilibili.entity.bangumi.BangumiRecommend;
import com.hotbitmapgg.ohmybilibili.entity.bangumi.MiddlewareBangumi;
import com.hotbitmapgg.ohmybilibili.module.home.bangumi.BangumiDetailsActivity;
import com.hotbitmapgg.ohmybilibili.widget.sectioned.StatelessSection;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by hcc on 2016/10/14 20:02
 * 100332338@qq.com
 * <p>
 * 首页番剧推荐Section
 */

public class HomeBangumiRecommendSection extends StatelessSection
{

    private Context mContext;

    private List<BangumiRecommend.RecommendsBean> recommends;


    public HomeBangumiRecommendSection(Context context, List<BangumiRecommend.RecommendsBean> recommends)
    {

        super(R.layout.layout_home_bangumi_recommend_head, R.layout.layout_home_recommend_empty);
        this.mContext = context;
        this.recommends = recommends;
    }

    @Override
    public int getContentItemsTotal()
    {

        return 1;
    }

    @Override
    public RecyclerView.ViewHolder getItemViewHolder(View view)
    {

        return new HomeBangumiRecommendSection.EmptyViewHolder(view);
    }

    @Override
    public void onBindItemViewHolder(RecyclerView.ViewHolder holder, int position)
    {

    }

    @Override
    public RecyclerView.ViewHolder getHeaderViewHolder(View view)
    {

        return new HomeBangumiRecommendSection.RecyclerViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindHeaderViewHolder(RecyclerView.ViewHolder holder)
    {

        HomeBangumiRecommendSection.RecyclerViewHolder recyclerViewHolder = (HomeBangumiRecommendSection.RecyclerViewHolder) holder;

        recyclerViewHolder.mRecyclerView.setHasFixedSize(false);
        recyclerViewHolder.mRecyclerView.setNestedScrollingEnabled(false);
        recyclerViewHolder.mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
        SecondElementBangumiAdapter mAdapter = new SecondElementBangumiAdapter(recyclerViewHolder.mRecyclerView, recommends);
        recyclerViewHolder.mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener((position, holder1) -> {

            BangumiRecommend.RecommendsBean recommendsBean = recommends.get(position);
            MiddlewareBangumi middlewareBangumi = new MiddlewareBangumi();
            middlewareBangumi.setAid(recommendsBean.getAid());
            middlewareBangumi.setCreate(recommendsBean.getCreate());
            middlewareBangumi.setPlay(recommendsBean.getPlay());
            middlewareBangumi.setFavorites(recommendsBean.getFavorites());
            middlewareBangumi.setPic(recommendsBean.getPic());
            middlewareBangumi.setDescription(recommendsBean.getDescription());
            middlewareBangumi.setTitle(recommendsBean.getTitle());
            BangumiDetailsActivity.launch((Activity) mContext, middlewareBangumi);
        });
    }


    static class RecyclerViewHolder extends RecyclerView.ViewHolder
    {

        @Bind(R.id.home_bangumi_recommend_recycler)
        RecyclerView mRecyclerView;

        RecyclerViewHolder(View itemView)
        {

            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    private static class EmptyViewHolder extends RecyclerView.ViewHolder
    {


        EmptyViewHolder(View itemView)
        {

            super(itemView);
        }
    }
}
