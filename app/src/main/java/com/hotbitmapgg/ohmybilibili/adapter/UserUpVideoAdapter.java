package com.hotbitmapgg.ohmybilibili.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.model.UserVideoItem;
import com.hotbitmapgg.ohmybilibili.network.UrlHelper;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * 用户上传视频Adapter
 */
public class UserUpVideoAdapter extends BaseAdapter
{

    private List<UserVideoItem> parts;

    private LayoutInflater mInflater;

    private Context context;

    public UserUpVideoAdapter(Context context, List<UserVideoItem> userVideoList)
    {
        mInflater = LayoutInflater.from(context);
        this.parts = userVideoList;
        this.context = context;
    }

    @Override
    public int getCount()
    {
        return parts.size();
    }

    @Override
    public UserVideoItem getItem(int i)
    {
        return parts.get(i);
    }

    @Override
    public long getItemId(int i)
    {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        ViewHolder vh;
        if (view == null)
        {
            view = mInflater.inflate(R.layout.card_item_user_up_video, null);
            vh = new ViewHolder(view);
            view.setTag(vh);
        }
        else
        {
            vh = (ViewHolder) view.getTag();
        }

        UserVideoItem item = getItem(i);
        //String author = item.author;
        String pic = item.pic;
        String play = item.play;
        int video_review = item.video_review;
        String title = item.title;

        Picasso.with(context).load(UrlHelper.getClearVideoPreviewUrl(pic)).placeholder(R.drawable.bili_default_image_tv).into(vh.mVideoPic);
        vh.mVideoTitle.setText(title);
        //vh.mVideoUserInfo.setText(author);
        vh.mVideoPlayNum.setText(play);
        vh.mVideoReviewNum.setText(video_review + "");

        return view;
    }

    private class ViewHolder
    {

        ImageView mVideoPic;

        TextView mVideoTitle;

        //TextView mVideoUserInfo;

        TextView mVideoPlayNum;

        TextView mVideoReviewNum;

        public ViewHolder(View parentView)
        {
            mVideoPic = (ImageView) parentView.findViewById(R.id.user_video_pic);

            mVideoTitle = (TextView) parentView.findViewById(R.id.user_video_title);

           // mVideoUserInfo = (TextView) parentView.findViewById(R.id.user_video_info);

            mVideoPlayNum = (TextView) parentView.findViewById(R.id.user_play_num);

            mVideoReviewNum = (TextView) parentView.findViewById(R.id.user_review_count);
        }

    }

}
