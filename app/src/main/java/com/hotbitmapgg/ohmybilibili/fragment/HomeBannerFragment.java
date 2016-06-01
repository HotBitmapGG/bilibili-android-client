package com.hotbitmapgg.ohmybilibili.fragment;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.base.AbsBaseFragment;
import com.hotbitmapgg.ohmybilibili.network.UrlHelper;
import com.hotbitmapgg.ohmybilibili.model.HomeBanner;
import com.hotbitmapgg.ohmybilibili.activity.BrowserActivity;
import com.hotbitmapgg.ohmybilibili.activity.VideoDetailsActivity;
import com.hotbitmapgg.ohmybilibili.utils.LogUtil;
import com.squareup.picasso.Picasso;

import butterknife.Bind;

/**
 * 首页轮播图展示Fragment
 *
 * @HotBitmapGG
 */
@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
public class HomeBannerFragment extends AbsBaseFragment
{

    @Bind(R.id.banner_image)
    ImageView mImageView;

    @Bind(R.id.banner_title)
    TextView mTitleText;

    private HomeBanner item;

    private static final String ARG_BANNER_JSON = "args_banner_json";

    public static HomeBannerFragment newInstance(HomeBanner banner)
    {

        HomeBannerFragment fragment = new HomeBannerFragment();
        Bundle data = new Bundle();
        data.putString(ARG_BANNER_JSON, new Gson().toJson(banner));
        fragment.setArguments(data);
        return fragment;
    }

    @Override
    public int getLayoutResId()
    {

        return R.layout.fragment_home_banner;
    }

    @SuppressLint("NewApi")
    @Override
    public void finishCreateView(Bundle state)
    {

        item = new Gson().fromJson(getArguments().getString(ARG_BANNER_JSON), HomeBanner.class);

        $(R.id.banner_layout).setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {

                if (UrlHelper.isVideoUrl(item.link))
                {
                    VideoDetailsActivity.launch(getSupportActivity(), UrlHelper.getAVfromVideoUrl(item.link));
                } else
                {
                    LogUtil.lsw(item.link);
                    Intent mIntent = new Intent(getActivity(), BrowserActivity.class);
                    mIntent.putExtra("url", item.link);
                    mIntent.putExtra("title", item.title);
                    mIntent.putExtra("picUrl", item.img);

                    getActivity().startActivity(mIntent);
                }
            }
        });

        int paddingBottom = getResources().getDimensionPixelSize(R.dimen.abc_action_bar_default_height_material);
        paddingBottom += getResources().getDimensionPixelSize(R.dimen.circle_indicator_default_height);

        int paddingStart = mTitleText.getPaddingStart();
        int paddingEnd = mTitleText.getPaddingEnd();
        int paddingTop = mTitleText.getPaddingTop();

        mTitleText.setPaddingRelative(paddingStart, paddingTop, paddingEnd, paddingBottom);

        mTitleText.setText(item.title);
        Picasso.with(getApplicationContext()).load(item.img).placeholder(R.drawable.bili_default_image_tv).into(mImageView);
    }

    public void setImageTransitionY(float y)
    {

        mImageView.setTranslationY(y);
    }
}
