package com.hotbitmapgg.ohmybilibili.module.entry;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.module.common.AppIntroduceActivity;
import com.hotbitmapgg.ohmybilibili.module.common.HotBitmapGGInfoActivity;
import com.hotbitmapgg.ohmybilibili.module.common.LoginActivity;
import com.hotbitmapgg.ohmybilibili.base.RxLazyFragment;
import com.hotbitmapgg.ohmybilibili.utils.PreferenceUtils;

import butterknife.Bind;

/**
 * Created by hcc on 16/8/7 14:12
 * 100332338@qq.com
 * <p/>
 * 设置与帮助
 */
public class SettingFragment extends RxLazyFragment implements View.OnClickListener
{

    @Bind(R.id.layout_about_me)
    RelativeLayout mAboutMe;

    @Bind(R.id.layout_about_app)
    RelativeLayout mAboutApp;

    @Bind(R.id.layout_update)
    RelativeLayout mUpdateApp;

    @Bind(R.id.btn_logout)
    Button mLogout;

    @Bind(R.id.app_version_code)
    TextView mVersionCode;

    public static SettingFragment newInstance()
    {

        return new SettingFragment();
    }

    @Override
    public int getLayoutResId()
    {

        return R.layout.fragment_setting;
    }

    @Override
    public void finishCreateView(Bundle state)
    {

        mAboutMe.setOnClickListener(this);
        mAboutApp.setOnClickListener(this);
        mUpdateApp.setOnClickListener(this);
        mLogout.setOnClickListener(this);

        mVersionCode.setText("v" + getVersionCode());
    }

    @Override
    protected void lazyLoad()
    {

    }

    @Override
    public void onClick(View v)
    {

        switch (v.getId())
        {

            case R.id.layout_about_me:
                //关于我
                startActivity(new Intent(getActivity(), HotBitmapGGInfoActivity.class));
                break;

            case R.id.layout_about_app:
                //关于哔哩哔哩
                startActivity(new Intent(getActivity(), AppIntroduceActivity.class));
                break;

            case R.id.layout_update:
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
            packageInfo = getActivity().getPackageManager()
                    .getPackageInfo(getActivity().getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e)
        {
            e.printStackTrace();
        }
        return packageInfo.versionName;
    }
}
