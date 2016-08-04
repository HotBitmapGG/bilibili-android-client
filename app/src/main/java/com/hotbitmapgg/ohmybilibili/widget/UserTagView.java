package com.hotbitmapgg.ohmybilibili.widget;


import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.module.user.UserInfoActivity;
import com.squareup.picasso.Picasso;

/**
 * 用于视频详情展示用户头像+用户名的View
 * 方便使用
 *
 * @HotBitmapGG
 */
public class UserTagView extends FrameLayout
{

    private LinearLayout cardView;

    private CircleImageView avatarView;

    private TextView userNameText;

    private OnClickListener onClickListener;

    private Activity activity;

    private String name;

    private int mid = -1;

    private String avatarUrl;

    public UserTagView(Context context)
    {

        this(context, null);
    }

    public UserTagView(Context context, AttributeSet attrs)
    {

        this(context, attrs, 0);
    }

    public UserTagView(Context context, AttributeSet attrs, int defStyleAttr)
    {

        super(context, attrs, defStyleAttr);
        cardView = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.widget_user_tag_view, null);
        avatarView = (CircleImageView) cardView.findViewById(R.id.user_avatar);
        userNameText = (TextView) cardView.findViewById(R.id.user_name);

        ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, getResources().getDimensionPixelSize(R.dimen.user_tag_view_height));
        this.addView(cardView, lp);

        cardView.setOnClickListener(new OnClickListener()
        {

            @Override
            public void onClick(View view)
            {

                if (mid != -1 && activity != null)
                {
                    UserInfoActivity.launch(activity, name, mid, avatarUrl);
                } else if (onClickListener != null)
                {
                    onClickListener.onClick(view);
                }
            }
        });
    }

    public void setAvatar(Bitmap bitmap)
    {

        avatarView.setImageBitmap(bitmap);
    }

    public void setAvatar(Drawable drawable)
    {

        avatarView.setImageDrawable(drawable);
    }

    public void setAvatar(@DrawableRes int id)
    {

        avatarView.setImageResource(id);
    }

    public CircleImageView getAvatarView()
    {

        return this.avatarView;
    }

    public void setUserName(String userName)
    {

        userNameText.setText(userName);
    }

    public TextView getUserNameText()
    {

        return this.userNameText;
    }

    public void setUpWithInfo(Activity activity, String name, int mid, String avatarUrl)
    {

        this.activity = activity;
        this.name = name;
        this.mid = mid;
        this.avatarUrl = avatarUrl;
        this.setUserName(name);

        Picasso.with(getContext()).load(this.avatarUrl).placeholder(R.drawable.ico_user_default).into(avatarView);
    }

    @Override
    public void setOnClickListener(OnClickListener listener)
    {

        this.onClickListener = listener;
    }
}
