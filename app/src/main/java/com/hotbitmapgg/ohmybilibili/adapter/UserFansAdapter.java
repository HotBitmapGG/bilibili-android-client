package com.hotbitmapgg.ohmybilibili.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.adapter.base.AbsRecyclerViewAdapter;
import com.hotbitmapgg.ohmybilibili.model.user.UserFans;
import com.hotbitmapgg.ohmybilibili.widget.CircleImageView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
/**
 * Created by hcc on 16/8/4 14:12
 * 100332338@qq.com
 */
public class UserFansAdapter extends AbsRecyclerViewAdapter
{

    private ArrayList<UserFans.FansInfo> infos = new ArrayList<>();


    public UserFansAdapter(RecyclerView recyclerView, ArrayList<UserFans.FansInfo> infos)
    {

        super(recyclerView);
        this.infos = infos;
    }

    @Override
    public ClickableViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {

        bindContext(parent.getContext());
        return new itemViewHolder(LayoutInflater.from(getContext()).inflate(R.layout.item_user_fans, parent, false));
    }

    @Override
    public void onBindViewHolder(ClickableViewHolder holder, int position)
    {

        super.onBindViewHolder(holder, position);

        if(holder instanceof  itemViewHolder)
        {
            itemViewHolder mHolder =  (itemViewHolder) holder;
            UserFans.FansInfo fansInfo = infos.get(position);
            Picasso.with(getContext()).load(fansInfo.face).into(mHolder.mUserAvatar);
            mHolder.mUserName.setText(fansInfo.uname);
        }
    }

    public void addData(UserFans.FansInfo fansInfo)
    {
        infos.add(fansInfo);
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

            mUserAvatar = $(R.id.user_avatar_view);
            mUserName = $(R.id.user_name);
        }
    }
}
