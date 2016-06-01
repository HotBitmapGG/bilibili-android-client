package com.hotbitmapgg.ohmybilibili.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.base.AbsBaseActivity;
import com.hotbitmapgg.ohmybilibili.model.FeedBackBean;
import com.hotbitmapgg.ohmybilibili.utils.LogUtil;
import com.hotbitmapgg.ohmybilibili.utils.ToastUtil;

import butterknife.Bind;
import cn.bmob.v3.listener.SaveListener;


/**
 * 意见反馈
 *
 * @HotBitmapGG
 */
public class FeedBackActivity extends AbsBaseActivity implements OnClickListener
{

    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    @Bind(R.id.feed_edit)
    EditText mFeedBack;

    @Bind(R.id.tip)
    TextView mTip;

    @Bind(R.id.btn_submit)
    Button mSubmit;


    @Override
    public int getLayoutId()
    {

        return R.layout.activity_feedback;
    }

    @Override
    public void initViews(Bundle savedInstanceState)
    {

        mSubmit.setOnClickListener(this);
        mFeedBack.addTextChangedListener(new TextWatcher()
        {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {

                mTip.setText((160 - s.length()) + "");
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable s)
            {
                // TODO Auto-generated method stub

            }
        });
    }

    @Override
    public void initToolBar()
    {

        mToolbar.setNavigationIcon(R.drawable.action_button_back_pressed_light);
        mToolbar.setTitle("意见反馈");
        mToolbar.setNavigationOnClickListener(new OnClickListener()
        {

            @Override
            public void onClick(View v)
            {

                finish();
            }
        });
    }


    @Override
    public void onClick(View v)
    {

        if (v.getId() == R.id.btn_submit)
        {
            String text = mFeedBack.getText().toString().trim();
            if (TextUtils.isEmpty(text))
            {
                ToastUtil.ShortToast("输入的内容不能为空~");
                return;
            }

            sendFeedBackText(text);
        }
    }

    /**
     * 发送意见
     *
     * @param text
     */
    private void sendFeedBackText(String text)
    {

        FeedBackBean mFeedBackBean = new FeedBackBean();
        mFeedBackBean.setContent(text);
        mFeedBackBean.save(FeedBackActivity.this, new SaveListener()
        {

            @Override
            public void onSuccess()
            {
                // TODO Auto-generated method stub
                ToastUtil.ShortToast("提交成功");
                mFeedBack.setText("");
            }

            @Override
            public void onFailure(int errorCode, String errorMsg)
            {
                // TODO Auto-generated method stub
                ToastUtil.ShortToast("提交失败");
                LogUtil.lsw(errorMsg);
            }
        });
    }
}
