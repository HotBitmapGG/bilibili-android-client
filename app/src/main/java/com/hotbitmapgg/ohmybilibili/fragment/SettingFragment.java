package com.hotbitmapgg.ohmybilibili.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.ui.AppIntroduceActivity;
import com.hotbitmapgg.ohmybilibili.ui.FeedBackActivity;
import com.hotbitmapgg.ohmybilibili.ui.IQrCodeActivity;
import com.hotbitmapgg.ohmybilibili.ui.LoginActivity;
import com.hotbitmapgg.ohmybilibili.utils.PreferenceUtils;

/**
 * Created by hcc on 16/3/20.
 * 设置界面
 */
public class SettingFragment extends LazyFragment implements View.OnClickListener
{

    private RelativeLayout mCommomSetting;

    private RelativeLayout mFeedBack;

    private RelativeLayout mAboutMe;

    private RelativeLayout mAboutApp;

    private RelativeLayout mUpdateApp;

    private Button mLogout;

    @Override
    public int getLayoutResId()
    {

        return R.layout.fragment_setting;
    }

    @Override
    public void finishCreateView(Bundle state)
    {

        mCommomSetting = $(R.id.rl_common_setting);
        mFeedBack = $(R.id.rl_idea);
        mAboutMe = $(R.id.rl_about_me);
        mAboutApp = $(R.id.rl_about);
        mUpdateApp = $(R.id.rl_update);

        mLogout = $(R.id.btn_logout);

        mCommomSetting.setOnClickListener(this);
        mFeedBack.setOnClickListener(this);
        mAboutMe.setOnClickListener(this);
        mAboutApp.setOnClickListener(this);
        mUpdateApp.setOnClickListener(this);
        mLogout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {

        switch (v.getId())
        {
            case R.id.rl_common_setting:
                //通用设置

                break;

            case R.id.rl_idea:
                //意见反馈
                startActivity(new Intent(getActivity() , FeedBackActivity.class));
                break;

            case R.id.rl_about_me:
                //关于我
                startActivity(new Intent(getActivity() , IQrCodeActivity.class));
                break;

            case R.id.rl_about:
                //关于哔哩哔哩
                startActivity(new Intent(getActivity() , AppIntroduceActivity.class));
                break;

            case R.id.rl_update:
                //版本更新

                break;

            case R.id.btn_logout:
                //退出登录  清空本地保存的头像跟登录flag
                PreferenceUtils.remove("login");
                startActivity(new Intent(getActivity() , LoginActivity.class));
                getActivity().finish();

                break;
        }
    }
}
