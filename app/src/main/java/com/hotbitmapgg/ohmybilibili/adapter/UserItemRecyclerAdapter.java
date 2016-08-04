package com.hotbitmapgg.ohmybilibili.adapter;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.adapter.base.AbsRecyclerViewAdapter;
import com.hotbitmapgg.ohmybilibili.model.user.UserInfo;
import com.hotbitmapgg.ohmybilibili.network.UrlHelper;
import com.hotbitmapgg.ohmybilibili.widget.CircleImageView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by hcc on 16/8/4 14:12
 * 100332338@qq.com
 */
public class UserItemRecyclerAdapter extends AbsRecyclerViewAdapter
{

    private List<UserInfo> items = new ArrayList<>();

    public UserItemRecyclerAdapter(RecyclerView recyclerView, List<UserInfo> items)
    {

        super(recyclerView);
        this.items = items;
    }

    @Override
    public ClickableViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {

        bindContext(parent.getContext());
        return new ItemViewHolder(LayoutInflater.from(getContext()).inflate(R.layout.list_item_user, parent, false));
    }

    @Override
    public void onBindViewHolder(ClickableViewHolder holder, int position)
    {

        if(holder instanceof ItemViewHolder)
        {
            String temp;
            ItemViewHolder mHolder = (ItemViewHolder)holder;
            mHolder.mUserName.setText(!TextUtils.isEmpty(temp = items.get(position).name) ? temp : !TextUtils.isEmpty(temp = items.get(position).uname) ? temp : items.get(position).userid);

            Picasso.with(getContext()).load(UrlHelper.getFaceUrl(items.get(position))).placeholder(R.drawable.ico_user_default).into(mHolder.mUserPhoto);

        }

        super.onBindViewHolder(holder, position);
    }

    @Override
    public int getItemCount()
    {

        return items.size();
    }

    public class ItemViewHolder extends AbsRecyclerViewAdapter.ClickableViewHolder
    {

        public CircleImageView mUserPhoto;

        public TextView mUserName;

        public ItemViewHolder(View itemView)
        {

            super(itemView);
            mUserPhoto = $(R.id.user_avatar_view);
            mUserName = $(R.id.user_name);
        }
    }
}
