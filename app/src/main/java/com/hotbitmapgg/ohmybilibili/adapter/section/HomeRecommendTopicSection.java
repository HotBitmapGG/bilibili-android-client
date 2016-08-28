package com.hotbitmapgg.ohmybilibili.adapter.section;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.widget.sectioned.StatelessSection;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by hcc on 16/8/27 20:19
 * 100332338@qq.com
 * <p/>
 * 首页推荐界面话题section
 */
public class HomeRecommendTopicSection extends StatelessSection
{

    private Context mContext;

    private String imgUrl;

    private String title;

    public HomeRecommendTopicSection(Context context, String imgUrl, String title)
    {

        super(R.layout.layout_home_recommend_topic,
                R.layout.layout_home_recommend_empty);
        this.mContext = context;
        this.imgUrl = imgUrl;
        this.title = title;
    }

    @Override
    public int getContentItemsTotal()
    {

        return 1;
    }

    @Override
    public RecyclerView.ViewHolder getItemViewHolder(View view)
    {

        return new EmptyViewHolder(view);
    }

    @Override
    public void onBindItemViewHolder(RecyclerView.ViewHolder holder, int position)
    {

    }

    @Override
    public RecyclerView.ViewHolder getHeaderViewHolder(View view)
    {

        return new TopicViewHolder(view);
    }

    @Override
    public void onBindHeaderViewHolder(RecyclerView.ViewHolder holder)
    {

        TopicViewHolder topicViewHolder = (TopicViewHolder) holder;

        Glide.with(mContext)
                .load(imgUrl)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.bili_default_image_tv)
                .into(topicViewHolder.mImageView);

        topicViewHolder.mTextView.setText(title);
        if (TextUtils.isEmpty(title))
            topicViewHolder.mTextView.setVisibility(View.GONE);
        else
            topicViewHolder.mTextView.setVisibility(View.VISIBLE);
    }

    static class TopicViewHolder extends RecyclerView.ViewHolder
    {

        @Bind(R.id.topic_image)
        ImageView mImageView;

        @Bind(R.id.topic_title)
        TextView mTextView;

        public TopicViewHolder(View itemView)
        {

            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    static class EmptyViewHolder extends RecyclerView.ViewHolder
    {

        public EmptyViewHolder(View itemView)
        {

            super(itemView);
        }
    }
}
