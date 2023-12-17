package com.example.testproj;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebviewActivity extends AppCompatActivity {

    private Toolbar toolBar;
    /* access modifiers changed from: private */
    public WebView webview;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        webview = (WebView) findViewById(R.id.webview);
        toolBar = (Toolbar) findViewById(R.id.webToolBar);
        toolBar.setTitle((CharSequence) getIntent().getStringExtra("title"));
        webview.getSettings().setAllowFileAccess(true);
        webview.getSettings().setDomStorageEnabled(true);
        webview.getSettings().setBlockNetworkLoads(false);
        webview.getSettings().setJavaScriptEnabled(true);
//        webview.getSettings().setAppCacheEnabled(true);
        webview.getSettings().setLoadsImagesAutomatically(true);
        webview.getSettings().setMixedContentMode(0);
        webview.setBackgroundColor(0);
        webview.loadUrl(getIntent().getStringExtra("navigate_url"));
        webview.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                // Page loading started, show the progress bar
                showLoader();
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                // Page loading finished, hide the progress bar
                dismissLoader();
            }
        });
        setSupportActionBar(toolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed(); // or implement your own navigation logic
            }
        });
    }

    private class MyClient extends WebViewClient {
        private MyClient() {
        }

        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            WebviewActivity.this.webview.evaluateJavascript("javascript:(function() { document.getElementsByClassName('col-md-8 form-group')[0].style.display='none'; })()", (ValueCallback) null);
            return super.shouldInterceptRequest(webView, str);
        }
    }

    private void showLoader() {
        progressDialog = new ProgressDialog(WebviewActivity.this);
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();
        progressDialog.setContentView(R.layout.progress_dialog);
    }

    private void dismissLoader() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }
}