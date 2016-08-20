package com.hotbitmapgg.ohmybilibili.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.entity.recommended.RecommendInfo;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by hcc on 16/8/20 16:21
 * 100332338@qq.com
 */
public class RecommendedAdapter extends RecyclerView.Adapter
{

    private List<RecommendInfo.ResultBean> results = new ArrayList<>();

    private int[] icons = new int[]{
            R.drawable.ic_header_hot,
            R.drawable.ic_head_live,
            R.drawable.ic_category_t13,
            R.drawable.ic_category_t1,
            R.drawable.ic_category_t3,
            R.drawable.ic_category_t129,
            R.drawable.ic_category_t4,
            R.drawable.ic_category_t119,
            R.drawable.ic_category_t36,
            R.drawable.ic_header_activity_center,
            R.drawable.ic_category_t160,
            R.drawable.ic_category_t155,
            R.drawable.ic_category_t5,
            R.drawable.ic_category_t11,
            R.drawable.ic_category_t23
    };

    public RecommendedAdapter(List<RecommendInfo.ResultBean> results)
    {

        this.results = results;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {

        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position)
    {

    }

    @Override
    public int getItemViewType(int position)
    {

        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount()
    {

        return 0;
    }


    private class RecommendTitleViewHolder extends RecyclerView.ViewHolder
    {


        public RecommendTitleViewHolder(View itemView)
        {

            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


    private class RecoomedItemViewHolder extends RecyclerView.ViewHolder
    {

        public RecoomedItemViewHolder(View itemView)
        {

            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
