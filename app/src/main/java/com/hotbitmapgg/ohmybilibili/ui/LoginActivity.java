package com.hotbitmapgg.ohmybilibili.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.utils.CommonUtils;
import com.hotbitmapgg.ohmybilibili.utils.PreferenceUtils;
import com.hotbitmapgg.ohmybilibili.utils.StatusBarCompat;
import com.hotbitmapgg.ohmybilibili.utils.ToastUtil;

/**
 * 登录
 *
 * @author Administrator
 * @hcc
 */
public class LoginActivity extends AppCompatActivity implements OnClickListener
{

    // 用户名
    private EditText et_username;

    // 密码
    private EditText et_password;

    // 登录
    private Button btn_login;


    // 用户名删除按钮
    private ImageView mDeleteUserName;


    private ImageView mLeftLogo;

    private ImageView mRightLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //设置全局状态栏颜色
        StatusBarCompat.compat(this);
        init();
        initTitle();
    }

    private void initTitle()
    {
        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setNavigationIcon(R.drawable.ic_cancle);
        mToolbar.setTitle("登录");
        mToolbar.setNavigationOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                finish();
            }
        });
    }

    private void init()
    {

        mLeftLogo = (ImageView) findViewById(R.id.iv_icon_left);
        mRightLogo = (ImageView) findViewById(R.id.iv_icon_right);

        mDeleteUserName = (ImageView) findViewById(R.id.delete_username);

        et_username = (EditText) findViewById(R.id.et_username);
        et_password = (EditText) findViewById(R.id.et_password);
        btn_login = (Button) findViewById(R.id.btn_login);


        btn_login.setOnClickListener(this);

        mDeleteUserName.setOnClickListener(new OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                // 清空用户名以及密码
                et_username.setText("");
                et_password.setText("");
                mDeleteUserName.setVisibility(View.GONE);
                et_username.setFocusable(true);
                et_username.setFocusableInTouchMode(true);
                et_username.requestFocus();
            }
        });


        et_username.setOnFocusChangeListener(new OnFocusChangeListener()
        {

            @Override
            public void onFocusChange(View v, boolean hasFocus)
            {

                if (hasFocus && et_username.getText().length() > 0)
                {
                    mDeleteUserName.setVisibility(View.VISIBLE);
                } else
                {
                    mDeleteUserName.setVisibility(View.GONE);
                }

                mLeftLogo.setImageResource(R.drawable.ic_22);
                mRightLogo.setImageResource(R.drawable.ic_33);
            }
        });

        et_password.setOnFocusChangeListener(new OnFocusChangeListener()
        {

            @Override
            public void onFocusChange(View v, boolean hasFocus)
            {

                mLeftLogo.setImageResource(R.drawable.ic_22_hide);
                mRightLogo.setImageResource(R.drawable.ic_33_hide);
            }
        });

        et_username.addTextChangedListener(new TextWatcher()
        {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                // TODO Auto-generated method stub
                // 如果用户名清空了 清空密码 清空记住密码选项
                et_password.setText("");
                if (s.length() > 0)
                {
                    // 如果用户名有内容时候 显示删除按钮
                    mDeleteUserName.setVisibility(View.VISIBLE);
                } else
                {
                    // 如果用户名有内容时候 显示删除按钮
                    mDeleteUserName.setVisibility(View.GONE);
                }
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
    public void onClick(View v)
    {

        switch (v.getId())
        {
            case R.id.btn_login:

                boolean isNetConnected = CommonUtils.isNetworkAvailable(this);
                if (!isNetConnected)
                {
                    ToastUtil.ShortToast("当前网络不可用,请检查网络设置");
                    return;
                }
                login();
                break;


            default:
                break;
        }
    }

    private void login()
    {

        String name = et_username.getText().toString();
        String password = et_password.getText().toString();

        if (TextUtils.isEmpty(name))
        {
            ToastUtil.ShortToast("用户名不能为空");
            return;
        }

        if (TextUtils.isEmpty(password))
        {
            ToastUtil.ShortToast("密码不能为空");
            return;
        }

        PreferenceUtils.put("login" ,true);
        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
        startActivity(intent);
        finish();

    }

    @Override
    protected void onDestroy()
    {
        // TODO Auto-generated method stub
        super.onDestroy();
    }
}
