package com.hotbitmapgg.bilibili.adapter;

import android.annotation.SuppressLint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.hotbitmapgg.bilibili.adapter.helper.AbsRecyclerViewAdapter;
import com.hotbitmapgg.bilibili.entity.video.VideoCommentInfo;
import com.hotbitmapgg.bilibili.network.auxiliary.UrlHelper;
import com.hotbitmapgg.bilibili.utils.DateUtil;
import com.hotbitmapgg.bilibili.widget.CircleImageView;
import com.hotbitmapgg.ohmybilibili.R;

import java.util.List;

/**
 * Created by hcc on 16/8/4 14:12
 * 100332338@qq.com
 * <p/>
 * 视频评论Adapter
 */
public class VideoCommentAdapter extends AbsRecyclerViewAdapter {
    private List<VideoCommentInfo.List> comments;

    public VideoCommentAdapter(RecyclerView recyclerView, List<VideoCommentInfo.List> comments) {
        super(recyclerView);
        this.comments = comments;
    }

    @Override
    public ClickableViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        bindContext(parent.getContext());
        return new ItemViewHolder(LayoutInflater.from(getContext()).
                inflate(R.layout.item_video_comment, parent, false));
    }


    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(ClickableViewHolder holder, int position) {
        if (holder instanceof ItemViewHolder) {
            ItemViewHolder mHolder = (ItemViewHolder) holder;
            VideoCommentInfo.List list = comments.get(position);
            mHolder.mUserName.setText(list.nick);

            Glide.with(getContext())
                    .load(UrlHelper.getFaceUrlByUrl(list.face))
                    .centerCrop()
                    .dontAnimate()
                    .placeholder(R.drawable.ico_user_default)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(mHolder.mUserAvatar);

            int currentLevel = list.level_info.current_level;
            checkLevel(currentLevel, mHolder);

            switch (list.sex) {
                case "女":
                    mHolder.mUserSex.setImageResource(R.drawable.ic_user_female);
                    break;
                case "男":
                    mHolder.mUserSex.setImageResource(R.drawable.ic_user_male);
                    break;
                default:
                    mHolder.mUserSex.setImageResource(R.drawable.ic_user_gay_border);
                    break;
            }
            mHolder.mCommentNum.setText(String.valueOf(list.reply_count));
            mHolder.mSpot.setText(String.valueOf(list.good));
            long l = DateUtil.stringToLong(list.create_at, "yyyy-MM-dd HH:mm");
            String time = DateUtil.getDescriptionTimeFromTimestamp(l);
            mHolder.mCommentTime.setText(time);
            mHolder.mContent.setText(list.msg);
            mHolder.mFloor.setText("#" + list.lv);
        }
        super.onBindViewHolder(holder, position);
    }


    private void checkLevel(int currentLevel, ItemViewHolder mHolder) {
        if (currentLevel == 0) {
            mHolder.mUserLv.setImageResource(R.drawable.ic_lv0);
        } else if (currentLevel == 1) {
            mHolder.mUserLv.setImageResource(R.drawable.ic_lv1);
        } else if (currentLevel == 2) {
            mHolder.mUserLv.setImageResource(R.drawable.ic_lv2);
        } else if (currentLevel == 3) {
            mHolder.mUserLv.setImageResource(R.drawable.ic_lv3);
        } else if (currentLevel == 4) {
            mHolder.mUserLv.setImageResource(R.drawable.ic_lv4);
        } else if (currentLevel == 5) {
            mHolder.mUserLv.setImageResource(R.drawable.ic_lv5);
        } else if (currentLevel == 6) {
            mHolder.mUserLv.setImageResource(R.drawable.ic_lv6);
        }
    }


    @Override
    public int getItemCount() {
        return comments.size();
    }


    public class ItemViewHolder extends AbsRecyclerViewAdapter.ClickableViewHolder {

        CircleImageView mUserAvatar;
        TextView mUserName;
        ImageView mUserLv;
        ImageView mUserSex;
        TextView mFloor;
        TextView mCommentTime;
        TextView mCommentNum;
        TextView mSpot;
        TextView mContent;

        public ItemViewHolder(View itemView) {
            super(itemView);
            mUserAvatar = $(R.id.item_user_avatar);
            mUserName = $(R.id.item_user_name);
            mUserLv = $(R.id.item_user_lever);
            mUserSex = $(R.id.item_user_sex);
            mFloor = $(R.id.item_comment_floor);
            mCommentTime = $(R.id.item_comment_time);
            mCommentNum = $(R.id.item_comment_num);
            mSpot = $(R.id.item_comment_spot);
            mContent = $(R.id.item_comment_content);
        }
    }
}
