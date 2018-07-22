package com.example.wbcz.customcomponent;

import android.util.Log;
import android.webkit.JavascriptInterface;

public class JsInterface {

    private JSBridge JSBridge;
    @JavascriptInterface
    public void setValue(String value) {
        JSBridge.setTextViewValue(value);
    }

    public JsInterface(JSBridge JSBridge) {
        this.JSBridge = JSBridge;
    }
    @JavascriptInterface
    public void newValue() {
        Log.d("fff", "newValue: ttttt");
    }

}

