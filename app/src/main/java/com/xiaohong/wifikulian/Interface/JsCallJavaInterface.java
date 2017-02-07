package com.xiaohong.wifikulian.Interface;

import android.webkit.JavascriptInterface;

import com.xiaohong.wifikulian.utils.PhoneInfo;

public class JsCallJavaInterface {

    @JavascriptInterface
    public String GetUserPhone() {
        return PhoneInfo.PHONENUM();
    }
}
