package com.example.wbcz.customcomponent;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;
import android.content.DialogInterface;

public class WebviewActivity extends AppCompatActivity implements JSBridge{
    WebView mWebView;
    TextView textView;
    private Handler mHander;
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void  initWidgets(Bundle savedInstanceState) {
        WebView.setWebContentsDebuggingEnabled(true);
        mWebView = (WebView) findViewById(R.id.test_webview);
        textView = (TextView) findViewById(R.id.text_view);
        Button btnClick = (Button) findViewById(R.id.btn_click);
        WebSettings seting = mWebView.getSettings();
        seting.setJavaScriptEnabled(true);

        mHander = new Handler();
        //给webview添加JS接口

        mWebView.addJavascriptInterface(new JsInterface(this), "send");
        mWebView.loadUrl("file:///android_asset/index.html");

        //native调用JS
        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mWebView.post(new Runnable() {
                    @Override
                    public void run() {
                        mWebView.loadUrl("javascript:callJS()");
                    }
                });
            }
        });

    }
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        initWidgets(savedInstanceState);

        mWebView.setWebChromeClient(new WebChromeClient(){
            @Override
            public boolean onJsAlert(WebView view, String url, String message, final JsResult result) {
                AlertDialog.Builder b = new AlertDialog.Builder(WebviewActivity.this);
                b.setTitle("alert");
                b.setMessage(message + url);
                b.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        result.confirm();
                    }
                });
                b.setCancelable(false);
                b.create().show();
                return true;
            }
        });

    }


    @Override
    public void setTextViewValue(final String value) {
        mHander.post(new Runnable() {
            @Override
            public void run() {
                textView.setText(value);
            }
        });
    }
}


