package com.hotbitmapgg.ohmybilibili.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.adapter.base.AbsRecyclerViewAdapter;
import com.hotbitmapgg.ohmybilibili.entity.user.UserFans;
import com.hotbitmapgg.ohmybilibili.widget.CircleImageView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hcc on 16/8/4 14:12
 * 100332338@qq.com
 * <p/>
 * 用户粉丝Adapter
 */
public class UserFansAdapter extends AbsRecyclerViewAdapter
{

    private List<UserFans.FansInfo> infos = new ArrayList<>();


    public UserFansAdapter(RecyclerView recyclerView,
                           List<UserFans.FansInfo> infos)
    {

        super(recyclerView);
        this.infos = infos;
    }

    @Override
    public ClickableViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {

        bindContext(parent.getContext());
        return new itemViewHolder(LayoutInflater.from(getContext()).
                inflate(R.layout.item_user_fans, parent, false));
    }

    @Override
    public void onBindViewHolder(ClickableViewHolder holder, int position)
    {

        super.onBindViewHolder(holder, position);

        if (holder instanceof itemViewHolder)
        {
            itemViewHolder mHolder = (itemViewHolder) holder;
            UserFans.FansInfo fansInfo = infos.get(position);

            Picasso.with(getContext())
                    .load(fansInfo.face)
                    .placeholder(R.drawable.ico_user_default)
                    .error(R.drawable.bili_default_image_tv)
                    .into(mHolder.mUserAvatar);
            mHolder.mUserName.setText(fansInfo.uname);
        }
    }

    @Override
    public int getItemCount()
    {

        return infos.size();
    }

    public class itemViewHolder extends AbsRecyclerViewAdapter.ClickableViewHolder
    {


        public CircleImageView mUserAvatar;

        public TextView mUserName;

        public itemViewHolder(View itemView)
        {

            super(itemView);

            mUserAvatar = $(R.id.item_user_avatar);
            mUserName = $(R.id.item_user_name);
        }
    }
}
