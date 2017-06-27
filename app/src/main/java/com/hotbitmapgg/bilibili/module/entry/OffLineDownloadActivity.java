package com.hotbitmapgg.bilibili.module.entry;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.format.Formatter;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.hotbitmapgg.bilibili.base.RxBaseActivity;
import com.hotbitmapgg.bilibili.utils.CommonUtil;
import com.hotbitmapgg.bilibili.utils.ToastUtil;
import com.hotbitmapgg.bilibili.widget.CustomEmptyView;
import com.hotbitmapgg.bilibili.widget.progressbar.NumberProgressBar;
import com.hotbitmapgg.ohmybilibili.R;

import butterknife.BindView;

/**
 * Created by hcc on 16/8/7 14:12
 * 100332338@qq.com
 * <p/>
 * 离线缓存
 */
public class OffLineDownloadActivity extends RxBaseActivity {
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.progress_bar)
    NumberProgressBar mProgressBar;
    @BindView(R.id.cache_size_text)
    TextView mCacheSize;

    @Override
    public int getLayoutId() {
        return R.layout.activity_offline_download;
    }


    @Override
    public void initViews(Bundle savedInstanceState) {
        long phoneTotalSize = CommonUtil.getPhoneTotalSize();
        long phoneAvailableSize = CommonUtil.getPhoneAvailableSize();
        //转换为G的显示单位
        String totalSizeStr = Formatter.formatFileSize(this, phoneTotalSize);
        String availabSizeStr = Formatter.formatFileSize(this, phoneAvailableSize);
        //计算占用空间的百分比
        int progress = countProgress(phoneTotalSize, phoneAvailableSize);
        mProgressBar.setProgress(progress);
        mCacheSize.setText("主存储:" + totalSizeStr + "/" + "可用:" + availabSizeStr);
        CustomEmptyView mEmptyLayout = (CustomEmptyView) findViewById(R.id.empty_layout);
        assert mEmptyLayout != null;
        mEmptyLayout.setEmptyImage(R.drawable.img_tips_error_no_downloads);
        mEmptyLayout.setEmptyText("没有找到你的缓存哟");
    }


    @Override
    public void initToolBar() {
        mToolbar.setTitle("离线缓存");
        setSupportActionBar(mToolbar);
        mToolbar.setNavigationIcon(R.drawable.action_button_back_pressed_light);
        mToolbar.setNavigationOnClickListener(v -> finish());
    }


    private int countProgress(long phoneTotalSize, long phoneAvailableSize) {
        double totalSize = phoneTotalSize / (1024 * 3);
        double availabSize = phoneAvailableSize / (1024 * 3);
        //取整相减
        int size = (int) (Math.floor(totalSize) - Math.floor(availabSize));
        double v = (size / Math.floor(totalSize)) * 100;
        return (int) Math.floor(v);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_recommend, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_more) {
            ToastUtil.ShortToast("离线设置");
        }
        return super.onOptionsItemSelected(item);
    }
}
