package com.hotbitmapgg.ohmybilibili.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.hotbitmapgg.ohmybilibili.R;

/**
 * 显示没有数据时和加载数据失败的EmptyView
 *
 * @HotBitmapGG
 */
public class EmptyView extends FrameLayout
{

    private ImageView mEmptyImg;

    private TextView mEmptyText;

    public EmptyView(Context context, AttributeSet attrs, int defStyleAttr)
    {

        super(context, attrs, defStyleAttr);
        init();
    }

    public EmptyView(Context context)
    {

        super(context);
        init();
    }

    public EmptyView(Context context, AttributeSet attrs)
    {

        super(context, attrs);
        init();
    }


    public void init()
    {

        View view = LayoutInflater.from(getContext()).inflate(R.layout.layout_empty, this);
        mEmptyImg = (ImageView) view.findViewById(R.id.empty_img);
        mEmptyText = (TextView) view.findViewById(R.id.empty_text);
    }

    public void setEmptyImage(int imgRes)
    {

        mEmptyImg.setImageResource(imgRes);
    }

    public void setEmptyText(String text)
    {

        mEmptyText.setText(text);
    }
}
