package com.hotbitmapgg.ohmybilibili.ui;

import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.DownloadListener;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebSettings.RenderPriority;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.utils.StatusBarCompat;
import com.hotbitmapgg.ohmybilibili.widget.CircleProgressView;

/**
 * WebView
 */
public class BrowserActivity extends AppCompatActivity implements DownloadListener
{

    private final Handler mHandler = new Handler();

    private CircleProgressView progressBar;

    private WebView mWebView;

    private String url, mTitle;

    WebViewClientBase webViewClient = new WebViewClientBase();

    private String iconUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bilibili_html);

        StatusBarCompat.compat(this);

        Intent intent = getIntent();
        url = intent.getStringExtra("url");
        mTitle = intent.getStringExtra("title");
        iconUrl = intent.getStringExtra("picUrl");
        initTitle();
        initView();
        setupWebView();
    }

    private void initTitle()
    {

        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setNavigationIcon(R.drawable.action_button_back_pressed_light);
        mToolbar.setTitle(mTitle == null ? "详情" : mTitle);
        mToolbar.setNavigationOnClickListener(new OnClickListener()
        {

            @Override
            public void onClick(View v)
            {

                finish();
            }
        });
    }

    /**
     * @param
     * @return void
     * @throws
     * @Title: initView
     * @Description: TODO
     */
    private void initView()
    {

        progressBar = (CircleProgressView) findViewById(R.id.banner_loading_circle);
        mWebView = (WebView) findViewById(R.id.webView1);
        progressBar.spin();
    }

    /**
     *
     */
    private void setupWebView()
    {

        final WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        webSettings.setDomStorageEnabled(true);
        webSettings.setGeolocationEnabled(true);
        mWebView.getSettings().setRenderPriority(RenderPriority.HIGH);
        mWebView.getSettings().setBlockNetworkImage(true);
        mWebView.setWebViewClient(webViewClient);
        mWebView.requestFocus(View.FOCUS_DOWN);
        mWebView.setDownloadListener(this);
        mWebView.getSettings().setDefaultTextEncodingName("UTF-8");
        mWebView.setWebChromeClient(new WebChromeClient()
        {

            @Override
            public boolean onJsAlert(WebView view, String url, String message, final JsResult result)
            {

                AlertDialog.Builder b2 = new AlertDialog.Builder(BrowserActivity.this).setTitle(R.string.app_name).setMessage(message).setPositiveButton("确定", new AlertDialog.OnClickListener()
                {

                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {

                        result.confirm();
                    }
                });

                b2.setCancelable(false);
                b2.create();
                b2.show();
                return true;
            }
        });
        mWebView.loadUrl(url);
    }

    public class WebViewClientBase extends WebViewClient
    {

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon)
        {

            super.onPageStarted(view, url, favicon);
        }

        @Override
        public void onPageFinished(WebView view, String url)
        {

            super.onPageFinished(view, url);
            progressBar.setVisibility(View.GONE);
            progressBar.stopSpinning();
            mWebView.getSettings().setBlockNetworkImage(false);
        }

        @Override
        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl)
        {

            super.onReceivedError(view, errorCode, description, failingUrl);
            String errorHtml = "<html><body><h2>找不到网页</h2></body></html>";
            view.loadDataWithBaseURL(null, errorHtml, "text/html", "UTF-8", null);
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see android.webkit.DownloadListener#onDownloadStart(java.lang.String,
     * java.lang.String, java.lang.String, java.lang.String, long)
     */
    @Override
    public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimetype, long contentLength)
    {

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        try
        {
            startActivity(intent);
            return;
        } catch (ActivityNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    public void initialize()
    {

        mHandler.post(new Runnable()
        {

            @Override
            public void run()
            {

                mWebView.loadUrl("javascript:initialize()");
            }
        });
    }
}
