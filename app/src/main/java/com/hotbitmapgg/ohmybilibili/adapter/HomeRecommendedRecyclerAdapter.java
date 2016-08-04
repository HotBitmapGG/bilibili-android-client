package com.hotbitmapgg.ohmybilibili.adapter;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.adapter.base.AbsRecyclerViewAdapter;
import com.hotbitmapgg.ohmybilibili.model.recommended.Body;
import com.hotbitmapgg.ohmybilibili.model.recommended.Result;
import com.hotbitmapgg.ohmybilibili.module.home.AllRankActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hcc on 16/8/4 12:45
 * 100332338@qq.com
 */
public class HomeRecommendedRecyclerAdapter extends AbsRecyclerViewAdapter
{

    private List<Result> results = new ArrayList<>();

    private int[] icons = new int[]{
            R.drawable.ic_tuijian,
            R.drawable.ic_category_live,
            R.drawable.ic_category_t13,
            R.drawable.ic_category_t1,
            R.drawable.ic_category_t3,
            R.drawable.ic_category_t129,
            R.drawable.ic_category_t4,
            R.drawable.ic_category_t119,
            R.drawable.ic_category_t36,
            R.drawable.ic_category_t137,
            R.drawable.ic_category_t47,
            R.drawable.ic_category_t155,
            R.drawable.ic_category_t31,
            R.drawable.ic_category_t11,
            R.drawable.ic_category_t23
    };

    public HomeRecommendedRecyclerAdapter(RecyclerView recyclerView, List<Result> results)
    {

        super(recyclerView);
        this.results = results;
    }

    @Override
    public ClickableViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {

        bindContext(parent.getContext());
        return new ItemViewHolder(LayoutInflater.from(getContext()).inflate(R.layout.item_home_recommended, parent, false));
    }

    @Override
    public void onBindViewHolder(ClickableViewHolder holder, int position)
    {

        if (holder instanceof ItemViewHolder)
        {
            Result result = results.get(position);
            ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
            itemViewHolder.mTypeImg.setImageResource(icons[position]);
            itemViewHolder.mTypeTv.setText(result.getHead().getTitle());
            if(position == 0)
            {
                itemViewHolder.mTypeRankBtn.setVisibility(View.VISIBLE);
            }
            else
            {
                itemViewHolder.mTypeMore.setVisibility(View.VISIBLE);
            }

            initGrid(itemViewHolder, result);
            setRankBtnClick(itemViewHolder);
        }
        super.onBindViewHolder(holder, position);
    }

    private void setRankBtnClick(ItemViewHolder itemViewHolder)
    {
       itemViewHolder.mTypeRankBtn.setOnClickListener(new View.OnClickListener()
       {

           @Override
           public void onClick(View v)
           {
              getContext().startActivity(new Intent(getContext() , AllRankActivity.class));
           }
       });
    }

    private void initGrid(ItemViewHolder itemViewHolder, Result result)
    {

        ArrayList<Body> body = result.getBody();
        itemViewHolder.mItemRecycle.setHasFixedSize(true);
        itemViewHolder.mItemRecycle.setNestedScrollingEnabled(false);
        itemViewHolder.mItemRecycle.setLayoutManager(new GridLayoutManager(getContext(), 2));
        HomeRecommendedGridAdapter mGridAdapter = new HomeRecommendedGridAdapter(itemViewHolder.mItemRecycle, body);
        itemViewHolder.mItemRecycle.setAdapter(mGridAdapter);
        mGridAdapter.setOnItemClickListener(new OnItemClickListener()
        {

            @Override
            public void onItemClick(int position, ClickableViewHolder holder)
            {

            }
        });
    }

    @Override
    public int getItemCount()
    {

        return results.size();
    }

    private class ItemViewHolder extends AbsRecyclerViewAdapter.ClickableViewHolder
    {

        public RecyclerView mItemRecycle;

        public ImageView mTypeImg;

        public TextView mTypeTv;

        public TextView mTypeMore;

        public TextView mTypeRankBtn;

        public ItemViewHolder(View itemView)
        {

            super(itemView);
            mItemRecycle = $(R.id.item_grid);
            mTypeImg = $(R.id.item_type_img);
            mTypeTv = $(R.id.item_type_tv);
            mTypeMore = $(R.id.item_type_more);
            mTypeRankBtn = $(R.id.item_type_rank_btn);
        }
    }
}
