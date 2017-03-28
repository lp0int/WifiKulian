package com.xiaohong.wifikulian.activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import com.xiaohong.wifikulian.Constants;
import com.xiaohong.wifikulian.Interface.JsCallJavaInterface;
import com.xiaohong.wifikulian.R;
import com.xiaohong.wifikulian.base.BaseActivity;
import com.xiaohong.wifikulian.utils.DialogUtils;
import com.xiaohong.wifikulian.utils.Utils;

/**
 * Created by Lpoint on 2017/2/9 14:43.
 */

public class ActivityWebView extends BaseActivity implements View.OnClickListener {
    private WebView webView;
    private String mUrl = "";
    private ProgressBar webViewProgressBar;
    private ValueCallback<Uri> uploadMessage;
    private ValueCallback<Uri[]> uploadMessageAboveL;
    private AppBarLayout topBar;
    private Toolbar toolbar;
    private TextView txtTitle;
    private ImageButton btnBack,btnClose;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.hideActiconBar(this);
        setContentView(R.layout.activity_webview);
        mUrl = getIntent().getStringExtra(Constants.EXTERNAL_URL);
        initView();
        initToolBar(mUrl);
        if (webView != null)
            webView.loadUrl("javascript:OnCreate()");
    }

    private void initToolBar(String url) {
        String[] uris = url.split("titleDefinition=");
        btnBack.setOnClickListener(this);
        if (uris.length > 1) {
            toolbar.setVisibility(View.VISIBLE);
            if (uris[1].startsWith("haveBackButton|")) {
                txtTitle.setText(uris[1].replaceAll("haveBackButton\\|", ""));
                return;
            }
            if (uris[1].startsWith("haveCloseButton|")) {
                txtTitle.setText(uris[1].replaceAll("haveCloseButton\\|", ""));
                btnClose = (ImageButton) findViewById(R.id.btn_close);
                btnClose.setVisibility(View.VISIBLE);
                btnClose.setOnClickListener(this);
                return;
            }
        }
        topBar.setVisibility(View.GONE);
    }

    private void initView() {
        topBar = (AppBarLayout) findViewById(R.id.top_bar);
        btnBack = (ImageButton) findViewById(R.id.btn_back);
        btnClose = (ImageButton) findViewById(R.id.btn_close);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        txtTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);

        webView = (WebView) findViewById(R.id.webview);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webView.setVerticalScrollBarEnabled(false);
        webViewProgressBar = (ProgressBar) findViewById(R.id.webview_progress);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setBuiltInZoomControls(false);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings.setAllowFileAccess(true);// 设置允许访问文件数据
        webSettings.setSupportZoom(false);
        webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        webSettings.setDomStorageEnabled(true);
        webSettings.setDatabaseEnabled(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setAppCacheEnabled(false);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUserAgentString(webView.getSettings().getUserAgentString() + "; Android/wifi_kulian/"
                + Utils.getVersion() + "/" + Utils.getVersionCode());
        webView.addJavascriptInterface(new JsCallJavaInterface(this), "JsCallJavaInterface");
        webView.setWebChromeClient(new MyWebChromeClient());
        webView.setWebViewClient(new WebViewClient() {

            // 重写此方法表明点击网页里面的链接还是在当前的webview里跳转，不跳到浏览器那边
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                mUrl = url;
                if (url.startsWith("http:") || url.startsWith("https:") || url.startsWith("file:")) {
                    view.loadUrl(url);
                    return true;
                } else {
                    try {
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                        startActivity(intent);
                    } catch (ActivityNotFoundException e) {
                        if (url.startsWith("weixin://")) {
                            Utils.showToastStr(ActivityWebView.this, "未安装微信");
                            webView.loadUrl("http://weixin.qq.com");
                            return false;
                        }
                    }
                }
                return true;
            }
        });
        webView.loadUrl(mUrl);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_close:
                finish();
                break;
            case R.id.btn_back:
                if (webView.canGoBack()) {
                    webView.goBack();
                    break;
                }
                finish();
                break;
            default:
                break;
        }
    }

    private class MyWebChromeClient extends WebChromeClient {
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            // TODO 自动生成的方法存根
            if (newProgress == 100) {
                webViewProgressBar.setVisibility(View.GONE);// 加载完网页进度条消失
            } else {
                webViewProgressBar.setVisibility(View.VISIBLE);// 开始加载网页时显示进度条
                webViewProgressBar.setProgress(newProgress);// 设置进度值
            }
        }

        @Override
        public boolean onJsAlert(WebView view, String url, String message, final JsResult result) {
            DialogUtils.getDialog(ActivityWebView.this, "提示信息", message, "确认", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    result.cancel();
                }
            }, "", null).setCancelable(false).show();
            return true;
            // return super.onJsAlert(view, url, message, result);
        }

        @Override
        public boolean onJsConfirm(WebView arg0, String url, String message, final JsResult result) {
            // TODO Auto-generated method stub
            DialogUtils.getDialog(ActivityWebView.this, "提示信息", message, "确认", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    result.confirm();
                }
            }, "取消", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    result.cancel();
                }
            }).setCancelable(false).show();
            return true;
        }

        // For Android < 3.0
        public void openFileChooser(ValueCallback<Uri> valueCallback) {
            uploadMessage = valueCallback;
            openImageChooserActivity();
        }

        // For Android >= 3.0
        public void openFileChooser(ValueCallback valueCallback, String acceptType) {
            uploadMessage = valueCallback;
            openImageChooserActivity();
        }

        // For Android >= 4.1
        @Override
        public void openFileChooser(ValueCallback<Uri> valueCallback, String acceptType, String capture) {
            uploadMessage = valueCallback;
            openImageChooserActivity();
        }

        // For Android >= 5.0
        @Override
        public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> filePathCallback,
                                         WebChromeClient.FileChooserParams fileChooserParams) {
            uploadMessageAboveL = filePathCallback;
            openImageChooserActivity();
            return true;
        }
    }

    private void openImageChooserActivity() {
        Intent i = new Intent(Intent.ACTION_GET_CONTENT);
        i.addCategory(Intent.CATEGORY_OPENABLE);
        i.setType("image/*");
        startActivityForResult(Intent.createChooser(i, "Image Chooser"), Constants.FILE_CHOOSER_RESULT_CODE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Constants.FILE_CHOOSER_RESULT_CODE) {
            if (null == uploadMessage && null == uploadMessageAboveL)
                return;
            Uri result = data == null || resultCode != Activity.RESULT_OK ? null : data.getData();
            if (uploadMessageAboveL != null) {
                onActivityResultAboveL(requestCode, resultCode, data);
            } else if (uploadMessage != null) {
                uploadMessage.onReceiveValue(result);
                uploadMessage = null;
            }
        }
    }

    @TargetApi(android.os.Build.VERSION_CODES.LOLLIPOP)
    private void onActivityResultAboveL(int requestCode, int resultCode, Intent intent) {
        if (requestCode != Constants.FILE_CHOOSER_RESULT_CODE || uploadMessageAboveL == null)
            return;
        Uri[] results = null;
        if (resultCode == Activity.RESULT_OK) {
            if (intent != null) {
                String dataString = intent.getDataString();
                ClipData clipData = intent.getClipData();
                if (clipData != null) {
                    results = new Uri[clipData.getItemCount()];
                    for (int i = 0; i < clipData.getItemCount(); i++) {
                        ClipData.Item item = clipData.getItemAt(i);
                        results[i] = item.getUri();
                    }
                }
                if (dataString != null)
                    results = new Uri[]{Uri.parse(dataString)};
            }
        }
        uploadMessageAboveL.onReceiveValue(results);
        uploadMessageAboveL = null;
    }

    @Override
    public void onPause() {
        super.onPause();
        if (webView != null)
            webView.loadUrl("javascript:OnPause()");
    }

    @Override
    public void onResume() {
        super.onResume();
        if (webView != null)
            webView.loadUrl("javascript:OnResume()");
    }

}
