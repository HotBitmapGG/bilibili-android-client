package com.hotbitmapgg.ohmybilibili.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.adapter.base.AbsRecyclerViewAdapter;
import com.hotbitmapgg.ohmybilibili.model.video.VideoComment;
import com.hotbitmapgg.ohmybilibili.network.UrlHelper;
import com.hotbitmapgg.ohmybilibili.widget.CircleImageView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
/**
 * Created by hcc on 16/8/4 14:12
 * 100332338@qq.com
 */
public class HotCommentAdapter extends AbsRecyclerViewAdapter
{

    private ArrayList<VideoComment.HotList> comments = new ArrayList<>();

    public HotCommentAdapter(RecyclerView recyclerView, ArrayList<VideoComment.HotList> comments)
    {

        super(recyclerView);
        this.comments = comments;
    }

    @Override
    public ClickableViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {

        bindContext(parent.getContext());
        return new ItemViewHolder(LayoutInflater.from(getContext()).inflate(R.layout.item_video_comment, parent, false));
    }

    @Override
    public void onBindViewHolder(ClickableViewHolder holder, int position)
    {


        if (holder instanceof ItemViewHolder)
        {
            try
            {
                ItemViewHolder mHolder = (ItemViewHolder) holder;
                VideoComment.HotList list = comments.get(position);
                mHolder.mUserName.setText(list.nick);
                Picasso.with(getContext()).load(UrlHelper.getFaceUrlByUrl(list.face)).placeholder(R.drawable.ico_user_default).error(R.drawable.ico_user_default).into(mHolder.mUserAvatar);
                int currentLevel = list.level_info.current_level;
                checkLevel(currentLevel, mHolder);
                String sex = list.sex;
                if (sex.equals("女"))
                {
                    mHolder.mUserSex.setImageResource(R.drawable.ic_user_female_border);
                } else
                {
                    mHolder.mUserSex.setImageResource(R.drawable.ic_user_male_border);
                }
                mHolder.mCommentNum.setText(list.reply_count + "");
                mHolder.mSpot.setText(list.good + "");
                mHolder.mCommentTime.setText(list.create_at);
                mHolder.mCotent.setText(list.msg);
                mHolder.mFloor.setText("#" + list.lv);
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }

        super.onBindViewHolder(holder, position);
    }

    private void checkLevel(int currentLevel, ItemViewHolder mHolder)
    {

        if (currentLevel == 0)
        {
            mHolder.mUserLv.setImageResource(R.drawable.ic_lv0);
        } else if (currentLevel == 1)
        {
            mHolder.mUserLv.setImageResource(R.drawable.ic_lv1);
        } else if (currentLevel == 2)
        {
            mHolder.mUserLv.setImageResource(R.drawable.ic_lv2);
        } else if (currentLevel == 3)
        {
            mHolder.mUserLv.setImageResource(R.drawable.ic_lv3);
        } else if (currentLevel == 4)
        {
            mHolder.mUserLv.setImageResource(R.drawable.ic_lv4);
        } else if (currentLevel == 5)
        {
            mHolder.mUserLv.setImageResource(R.drawable.ic_lv5);
        } else if (currentLevel == 6)
        {
            mHolder.mUserLv.setImageResource(R.drawable.ic_lv6);
        }
    }

    @Override
    public int getItemCount()
    {

        return comments.size();
    }


    public class ItemViewHolder extends ClickableViewHolder
    {

        public CircleImageView mUserAvatar;

        public TextView mUserName;

        public ImageView mUserLv;

        public ImageView mUserSex;

        public TextView mFloor;

        public TextView mCommentTime;

        public TextView mCommentNum;

        public TextView mSpot;

        public TextView mCotent;

        public ItemViewHolder(View itemView)
        {

            super(itemView);
            mUserAvatar = $(R.id.comment_user_avatar);
            mUserName = $(R.id.comment_user_name);
            mUserLv = $(R.id.comment_user_lever);
            mUserSex = $(R.id.comment_user_sex);
            mFloor = $(R.id.comment_floor);
            mCommentTime = $(R.id.comment_time);
            mCommentNum = $(R.id.comment_num);
            mSpot = $(R.id.comment_spot);
            mCotent = $(R.id.comment_content);
        }
    }
}
