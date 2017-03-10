package com.xiaohong.wifikulian.Interface;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.webkit.JavascriptInterface;

import com.xiaohong.wifikulian.Variable;
import com.xiaohong.wifikulian.utils.DialogUtils;
import com.xiaohong.wifikulian.utils.PhoneInfo;
import com.xiaohong.wifikulian.utils.Util;

public class JsCallJavaInterface {

    @JavascriptInterface
    public String GetUserPhone() {
        return PhoneInfo.PHONENUM();
    }

    @JavascriptInterface
    public void LogMsg(String tag, String info) {
        Log.i(tag, info);
    }

    @JavascriptInterface
    public void ToastMsg(final String info) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                Util.showToastStr(Variable.BASECONTEXT, info);
            }
        });
    }

    @JavascriptInterface
    public void DialogMsg(final String title, final String info) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                DialogUtils.getDialog(Variable.BASECONTEXT, title, info, "", null, "确认", null).setCancelable(true).show();
            }
        });
    }

    @JavascriptInterface
    public String GetVersionName() {
        return Util.getVersion();
    }

}
