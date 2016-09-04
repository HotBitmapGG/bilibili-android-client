package com.hotbitmapgg.ohmybilibili.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.adapter.base.AbsRecyclerViewAdapter;
import com.hotbitmapgg.ohmybilibili.entity.search.SearchResult;

import java.util.List;

/**
 * Created by hcc on 16/8/29 21:18
 * 100332338@qq.com
 * <p/>
 * 搜索列表数据Adapter
 */
public class BangumiResultsAdapter extends AbsRecyclerViewAdapter
{

    private List<SearchResult.ResultBean.BangumiBean> bangumis;

    public BangumiResultsAdapter(RecyclerView recyclerView, List<SearchResult.ResultBean.BangumiBean> bangumis)
    {

        super(recyclerView);
        this.bangumis = bangumis;
    }

    @Override
    public ClickableViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {

        bindContext(parent.getContext());
        return new ItemViewHolder(LayoutInflater.from(getContext()).
                inflate(R.layout.item_search_bangumi, parent, false));
    }

    @Override
    public void onBindViewHolder(ClickableViewHolder holder, int position)
    {

        if (holder instanceof ItemViewHolder)
        {
            ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
            SearchResult.ResultBean.BangumiBean bangumiBean = bangumis.get(position);

            Glide.with(getContext())
                    .load(bangumiBean.getCover())
                    .centerCrop()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .placeholder(R.drawable.bili_default_image_tv)
                    .into(itemViewHolder.mBangumiPic);

            itemViewHolder.mBangumiTitle.setText(bangumiBean.getTitle());
            itemViewHolder.mBangumiDetails.setText(bangumiBean.getBrief());
        }

        super.onBindViewHolder(holder, position);
    }

    @Override
    public int getItemCount()
    {

        return bangumis.size();
    }

    public class ItemViewHolder extends ClickableViewHolder
    {

        public ImageView mBangumiPic;

        public TextView mBangumiTitle;

//        public TextView mBangumiFrom;

        public TextView mBangumiDetails;

        public ItemViewHolder(View itemView)
        {

            super(itemView);

            mBangumiPic = $(R.id.item_img);
            mBangumiTitle = $(R.id.item_title);
          //  mBangumiFrom = $(R.id.item_user_name);
            mBangumiDetails = $(R.id.item_details);
        }
    }
}
