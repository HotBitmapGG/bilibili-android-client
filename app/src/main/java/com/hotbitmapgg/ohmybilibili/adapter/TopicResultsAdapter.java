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
import com.hotbitmapgg.ohmybilibili.network.auxiliary.UrlHelper;

import java.util.List;

/**
 * Created by hcc on 16/9/4 12:28
 * 100332338@qq.com
 * <p/>
 * 话题搜索结果Adapter
 */
public class TopicResultsAdapter extends AbsRecyclerViewAdapter
{

    private List<SearchResult.ResultBean.TopicBean> topics;

    public TopicResultsAdapter(RecyclerView recyclerView, List<SearchResult.ResultBean.TopicBean> topics)
    {

        super(recyclerView);
        this.topics = topics;
    }

    @Override
    public ClickableViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {

        bindContext(parent.getContext());
        return new ItemViewHolder(LayoutInflater.from(getContext()).
                inflate(R.layout.item_search_topic, parent, false));
    }

    @Override
    public void onBindViewHolder(ClickableViewHolder holder, int position)
    {

        if (holder instanceof ItemViewHolder)
        {
            ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
            SearchResult.ResultBean.TopicBean topicBean = topics.get(position);

            Glide.with(getContext())
                    .load(UrlHelper.getClearVideoPreviewUrl(topicBean.getCover()))
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .centerCrop()
                    .placeholder(R.drawable.bili_default_image_tv)
                    .into(itemViewHolder.mTopicPic);

            itemViewHolder.mTopicTitle.setText(topicBean.getTitle());
            itemViewHolder.mUserName.setText(topicBean.getAuthor());
            itemViewHolder.mTopicDetails.setText(topicBean.getDescription());
        }

        super.onBindViewHolder(holder, position);
    }

    @Override
    public int getItemCount()
    {

        return topics.size();
    }

    public class ItemViewHolder extends ClickableViewHolder
    {

        public ImageView mTopicPic;

        public TextView mTopicTitle;

        public TextView mUserName;

        public TextView mTopicDetails;

        public ItemViewHolder(View itemView)
        {

            super(itemView);

            mTopicPic = $(R.id.item_img);
            mTopicTitle = $(R.id.item_title);
            mUserName = $(R.id.item_user_name);
            mTopicDetails = $(R.id.item_details);
        }
    }
}
