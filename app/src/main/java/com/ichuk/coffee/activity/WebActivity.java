package com.ichuk.coffee.activity;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.ichuk.coffee.R;
import com.ichuk.coffee.base.BaseActivity;

public class WebActivity extends BaseActivity implements View.OnClickListener {

    private ImageView ivBack;
    private TextView tvHeaderTitle;
    private WebView wvAgreement;
    private String mTitle = "";
    private String mUrl = "";
    private ProgressBar pbWeb;

    /**
     * set event
     */
    @Override
    protected void setEvent() {
        ivBack.setOnClickListener(this);
    }

    /**
     * initial view
     */
    @Override
    protected void initView() {
        findViews();
        getData();
        setHeader();
        setWebView();
    }

    /**
     * get data from intent
     */
    private void getData() {
        mTitle = getIntent().getStringExtra("title");
        mUrl = getIntent().getStringExtra("url");
    }

    /**
     * set webView
     */
    @SuppressLint("SetJavaScriptEnabled")
    private void setWebView() {
        wvAgreement.loadUrl(mUrl);
        WebViewClient webViewClient = new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                Log.e("url", "shouldOverrideUrlLoading: " + url);
                view.loadUrl(url);
                return true;
            }
        };
        wvAgreement.setWebViewClient(webViewClient);

        WebSettings setting = wvAgreement.getSettings();
        setting.setJavaScriptEnabled(true);
        wvAgreement.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if (newProgress == 100) {
                    pbWeb.setVisibility(View.GONE);
                } else {
                    pbWeb.setVisibility(View.VISIBLE);
                    pbWeb.setProgress(newProgress);
                }

            }
        });
    }

    /**
     * set header
     */
    private void setHeader() {
        ivBack.setVisibility(View.VISIBLE);
        tvHeaderTitle.setText(mTitle);
    }

    /**
     * findViewById
     */
    private void findViews() {
        ivBack = findViewById(R.id.iv_back);
        tvHeaderTitle = findViewById(R.id.tv_header_title);
        wvAgreement = findViewById(R.id.wv_agreement);
        pbWeb = findViewById(R.id.pb_web);
    }

    /**
     * load layout
     */
    @Override
    protected int setLayout() {
        return R.layout.activity_web;
    }

    @Override
    public void onClick(View view) {
        if (view == ivBack) {
            finish();
        }
    }

    @Override
    protected void onDestroy() {
        if (wvAgreement != null) {
            wvAgreement.destroy();
            wvAgreement = null;
        }
        super.onDestroy();
    }
}
