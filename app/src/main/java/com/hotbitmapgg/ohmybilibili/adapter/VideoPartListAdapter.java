package com.hotbitmapgg.ohmybilibili.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.adapter.base.AbsRecyclerViewAdapter;
import com.hotbitmapgg.ohmybilibili.model.user.AuthorRecommend;
import com.hotbitmapgg.ohmybilibili.network.UrlHelper;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by hcc on 16/8/4 14:12
 * 100332338@qq.com
 */
public class VideoPartListAdapter extends AbsRecyclerViewAdapter
{

    private List<AuthorRecommend.AuthorData> datas = new ArrayList<>();

    public VideoPartListAdapter(RecyclerView recyclerView, List<AuthorRecommend.AuthorData> datas)
    {

        super(recyclerView);
        this.datas = datas;
    }

    @Override
    public ClickableViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {

        bindContext(parent.getContext());
        return new ItemViewHolder(LayoutInflater.from(getContext()).inflate(R.layout.card_item_video_parts, parent, false));
    }

    @Override
    public void onBindViewHolder(ClickableViewHolder holder, int position)
    {

        if (holder instanceof ItemViewHolder)
        {
            ItemViewHolder mHolder = (ItemViewHolder) holder;
            AuthorRecommend.AuthorData authorData = datas.get(position);

            int click = authorData.click;
            String cover = authorData.cover;
            int favorites = authorData.favorites;
            int review = authorData.review;
            int video_review = authorData.video_review;
            String title = authorData.title;

            Picasso.with(getContext()).load(UrlHelper.getClearVideoPreviewUrl(cover)).placeholder(R.drawable.bili_default_image_tv).into(mHolder.mVideoPic);
            mHolder.mVideoTitle.setText(title);
            mHolder.mVideoUserFav.setText(favorites + "");
            mHolder.mVideoPlayNum.setText(click + "");
            mHolder.mVideoUserCommend.setText(review + "");
            mHolder.mVideoReviewNum.setText(video_review + "");
        }

        super.onBindViewHolder(holder, position);
    }


    @Override
    public int getItemCount()
    {

        return datas.size();
    }

    public class ItemViewHolder extends AbsRecyclerViewAdapter.ClickableViewHolder
    {

        public ImageView mVideoPic;

        public TextView mVideoTitle;

        public TextView mVideoUserFav;

        public TextView mVideoUserCommend;

        public TextView mVideoPlayNum;

        public TextView mVideoReviewNum;

        public ItemViewHolder(View itemView)
        {

            super(itemView);

            mVideoPic = $(R.id.user_video_pic);

            mVideoTitle = $(R.id.user_video_title);

            mVideoUserFav = $(R.id.user_video_fav);

            mVideoUserCommend = $(R.id.user_video_commend);

            mVideoPlayNum = $(R.id.user_play_num);

            mVideoReviewNum = $(R.id.user_review_count);
        }
    }

//	private List<AuthorRecommend.AuthorData> parts;
//
//	private LayoutInflater mInflater;
//
//	private Context context;
//
//	public VideoPartListAdapter(Context context, List<AuthorRecommend.AuthorData> userVideoList)
//	{
//		mInflater = LayoutInflater.from(context);
//		this.parts = userVideoList;
//		this.context = context;
//	}
//
//	@Override
//	public int getCount()
//	{
//		return parts.size();
//	}
//
//	@Override
//	public AuthorRecommend.AuthorData getItem(int i)
//	{
//		return parts.get(i);
//	}
//
//	@Override
//	public long getItemId(int i)
//	{
//		return i;
//	}
//
//	@Override
//	public View getView(int i, View view, ViewGroup viewGroup)
//	{
//		ViewHolder vh;
//		if (view == null)
//		{
//			view = mInflater.inflate(R.layout.list_item_video_part_item, null);
//			vh = new ViewHolder(view);
//			view.setTag(vh);
//		}
//		else
//		{
//			vh = (ViewHolder) view.getTag();
//		}
//
//		AuthorRecommend.AuthorData item = getItem(i);
//		int click = item.click;
//		String cover = item.cover;
//		int favorites = item.favorites;
//		int review = item.review;
//		int video_review = item.video_review;
//		String title = item.title;
//
//		Picasso.with(context).load(UrlHelper.getClearVideoPreviewUrl(cover)).placeholder(R.drawable.bili_default_image_tv).into(vh.mVideoPic);
//		vh.mVideoTitle.setText(title);
//		vh.mVideoUserFav.setText(favorites + "");
//		vh.mVideoPlayNum.setText(click + "");
//		vh.mVideoUserCommend.setText(review + "");
//		vh.mVideoReviewNum.setText(video_review + "");
//
//		return view;
//	}
//
//	private class ViewHolder
//	{
//
//		ImageView mVideoPic;
//
//		TextView mVideoTitle;
//
//		TextView mVideoUserFav;
//
//		TextView mVideoUserCommend;
//
//		TextView mVideoPlayNum;
//
//		TextView mVideoReviewNum;
//
//		public ViewHolder(View parentView)
//		{
//			mVideoPic = (ImageView) parentView.findViewById(R.id.user_video_pic);
//
//			mVideoTitle = (TextView) parentView.findViewById(R.id.user_video_title);
//
//			mVideoUserFav = (TextView) parentView.findViewById(R.id.user_video_fav);
//
//			mVideoUserCommend = (TextView) parentView.findViewById(R.id.user_video_commend);
//
//			mVideoPlayNum = (TextView) parentView.findViewById(R.id.user_play_num);
//
//			mVideoReviewNum = (TextView) parentView.findViewById(R.id.user_review_count);
//		}
//
//	}
}
