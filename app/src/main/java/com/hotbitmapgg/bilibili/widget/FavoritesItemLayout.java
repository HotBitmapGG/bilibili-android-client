package com.hotbitmapgg.bilibili.widget;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.hotbitmapgg.bilibili.entity.user.UserFavoritesInfo;
import com.hotbitmapgg.ohmybilibili.R;
import java.util.List;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/**
 * Created by hcc on 2016/10/13 15:54
 * 100332338@qq.com
 * <p>
 * 自定义收藏夹布局控件
 */

public class FavoritesItemLayout extends FrameLayout {

  private ImageView mFillImage;

  private ImageView mTopImage;

  private ImageView mBottomImage;

  private LinearLayout mBottomImageLayout;

  private ImageView mLeftImage;

  private ImageView mRightImage;

  private List<UserFavoritesInfo.DataBean.VideosBean> videos;


  public FavoritesItemLayout(Context context) {

    this(context, null);
  }


  public FavoritesItemLayout(Context context, AttributeSet attrs) {

    this(context, attrs, 0);
  }


  public FavoritesItemLayout(Context context, AttributeSet attrs, int defStyleAttr) {

    super(context, attrs, defStyleAttr);
    @SuppressLint("InflateParams")
    RelativeLayout layout = (RelativeLayout) LayoutInflater.from(context)
        .inflate(R.layout.layout_favorites_view, null);
    mFillImage = (ImageView) layout.findViewById(R.id.image_fill);
    mTopImage = (ImageView) layout.findViewById(R.id.image_top);
    mBottomImage = (ImageView) layout.findViewById(R.id.image_bottom);
    mBottomImageLayout = (LinearLayout) layout.findViewById(R.id.image_bottom_layout);
    mLeftImage = (ImageView) layout.findViewById(R.id.image_left);
    mRightImage = (ImageView) layout.findViewById(R.id.image_right);

    addView(layout);
  }


  /**
   * 设置收藏夹为空时候的占位图
   */
  public void setEmptyImage() {

    mFillImage.setVisibility(VISIBLE);
    mTopImage.setVisibility(GONE);
    mBottomImage.setVisibility(GONE);
    mBottomImageLayout.setVisibility(GONE);
    mLeftImage.setVisibility(GONE);
    mRightImage.setVisibility(GONE);

    mFillImage.setImageResource(R.drawable.ic_favorite_box_default_large);
  }


  /**
   * 设置收藏夹一张图片时
   * <p>
   * 只显示最上边铺满整个layout的imageView
   */
  public void setOneImage() {

    mFillImage.setVisibility(VISIBLE);
    mTopImage.setVisibility(GONE);
    mBottomImage.setVisibility(GONE);
    mBottomImageLayout.setVisibility(GONE);
    mLeftImage.setVisibility(GONE);
    mRightImage.setVisibility(GONE);

    Glide.with(getContext())
        .load(videos.get(0).getPic())
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .into(mFillImage);
  }


  /**
   * 设置收藏夹两张图片时
   * <p>
   * 只显示最上边和最下边的两张图片
   */
  public void setTwoImage() {

    mTopImage.setVisibility(VISIBLE);
    mBottomImage.setVisibility(VISIBLE);
    mFillImage.setVisibility(GONE);
    mBottomImageLayout.setVisibility(GONE);
    mLeftImage.setVisibility(GONE);
    mRightImage.setVisibility(GONE);

    Glide.with(getContext())
        .load(videos.get(0).getPic())
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .into(mTopImage);

    Glide.with(getContext())
        .load(videos.get(1).getPic())
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .into(mBottomImage);
  }


  /**
   * 设置收藏夹三张图片时
   * <p>
   * 只显示最上边的图片和下边的两张图片布局
   */
  public void setThreeImage() {

    mTopImage.setVisibility(VISIBLE);
    mBottomImageLayout.setVisibility(VISIBLE);
    mLeftImage.setVisibility(VISIBLE);
    mRightImage.setVisibility(VISIBLE);
    mBottomImage.setVisibility(GONE);
    mFillImage.setVisibility(GONE);

    Glide.with(getContext())
        .load(videos.get(0).getPic())
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .into(mTopImage);

    Glide.with(getContext())
        .load(videos.get(1).getPic())
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .into(mLeftImage);

    Glide.with(getContext())
        .load(videos.get(2).getPic())
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .into(mRightImage);
  }


  public void setImages(List<UserFavoritesInfo.DataBean.VideosBean> videos) {

    this.videos = videos;
    if (videos != null && videos.size() > 0) {
      switch (videos.size()) {

        case 1:
          setOneImage();
          break;

        case 2:
          setTwoImage();
          break;

        case 3:
          setThreeImage();
          break;
      }
    } else {
      setEmptyImage();
    }
  }
}
