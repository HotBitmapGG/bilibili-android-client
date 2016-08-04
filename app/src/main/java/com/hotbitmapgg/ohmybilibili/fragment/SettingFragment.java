package com.hotbitmapgg.ohmybilibili.fragment;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.activity.AppIntroduceActivity;
import com.hotbitmapgg.ohmybilibili.activity.HotBitmapGGInfoActivity;
import com.hotbitmapgg.ohmybilibili.activity.IQrCodeActivity;
import com.hotbitmapgg.ohmybilibili.activity.LoginActivity;
import com.hotbitmapgg.ohmybilibili.base.AbsBaseFragment;
import com.hotbitmapgg.ohmybilibili.utils.PreferenceUtils;

import butterknife.Bind;

/**
 * 设置与帮助
 *
 * @HotBitmapGG
 */
public class SettingFragment extends AbsBaseFragment implements View.OnClickListener
{

    @Bind(R.id.rl_common_setting)
    RelativeLayout mCommomSetting;

    @Bind(R.id.rl_about_me)
    RelativeLayout mAboutMe;

    @Bind(R.id.rl_about)
    RelativeLayout mAboutApp;

    @Bind(R.id.rl_update)
    RelativeLayout mUpdateApp;

    @Bind(R.id.btn_logout)
    Button mLogout;

    @Bind(R.id.app_version_code)
    TextView mVersionCode;

    @Override
    public int getLayoutResId()
    {

        return R.layout.fragment_setting;
    }

    @Override
    public void finishCreateView(Bundle state)
    {

        mCommomSetting.setOnClickListener(this);
        mAboutMe.setOnClickListener(this);
        mAboutApp.setOnClickListener(this);
        mUpdateApp.setOnClickListener(this);
        mLogout.setOnClickListener(this);

        mVersionCode.setText("V" + getVersionCode());
    }

    @Override
    public void onClick(View v)
    {

        switch (v.getId())
        {
            case R.id.rl_common_setting:
                //通用设置
                startActivity(new Intent(getActivity(), IQrCodeActivity.class));
                break;

            case R.id.rl_about_me:
                //关于我
                startActivity(new Intent(getActivity(), HotBitmapGGInfoActivity.class));
                break;

            case R.id.rl_about:
                //关于哔哩哔哩
                startActivity(new Intent(getActivity(), AppIntroduceActivity.class));
                break;

            case R.id.rl_update:
                //版本更新

                break;

            case R.id.btn_logout:
                //退出登录  清空本地保存的头像跟登录flag
                PreferenceUtils.remove("login");
                startActivity(new Intent(getActivity(), LoginActivity.class));
                getActivity().finish();

                break;
        }
    }

    public String getVersionCode()
    {

        PackageInfo packageInfo = null;
        try
        {
            packageInfo = getActivity().getPackageManager().getPackageInfo(getActivity().getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e)
        {
            e.printStackTrace();
        }
        return packageInfo.versionName;
    }
}
