package com.xiaohong.wifikulian.Interface;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.webkit.JavascriptInterface;

import com.xiaohong.wifikulian.ApplicationInfo;
import com.xiaohong.wifikulian.Constants;
import com.xiaohong.wifikulian.Variable;
import com.xiaohong.wifikulian.models.appProcess.AndroidAppProcess;
import com.xiaohong.wifikulian.models.appProcess.ProcessManager;
import com.xiaohong.wifikulian.utils.DialogUtils;
import com.xiaohong.wifikulian.utils.PhoneInfo;
import com.xiaohong.wifikulian.utils.Utils;

import java.util.List;

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
                Utils.showToastStr(Variable.BASECONTEXT, info);
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
        return Utils.getVersion();
    }

    @JavascriptInterface
    public String GetVersionCode() {
        return Utils.getVersionCode() + "";
    }

    @JavascriptInterface
    public String GetMac() {
        return PhoneInfo.Mac();
    }

    @JavascriptInterface
    public String GetPlatform() {
        return Constants.PLATFORM;
    }

    @JavascriptInterface
    public String GetChannel() {
        return ApplicationInfo.channel;
    }

    @JavascriptInterface
    public String GetRunningApplication() {
        String str = "";
        List<AndroidAppProcess> tasks = ProcessManager.getRunningAppProcesses();
        for (AndroidAppProcess androidAppProcess : tasks) {
            str += androidAppProcess.name + "</br>";
        }
        return str;
    }

    @JavascriptInterface
    public String GetToken() {
        return Variable.loginBean.getToken();
    }

    @JavascriptInterface
    public String CheckAppIsRunning(String packageName) {
        List<AndroidAppProcess> tasks = ProcessManager.getRunningAppProcesses();
        for (AndroidAppProcess androidAppProcess : tasks)
            if (androidAppProcess.name.contains(packageName))
                return "true";
        return "false";
    }

    @JavascriptInterface
    public void OpenApplication(String ApplicationName) {
        try {
            Intent intent = Variable.BASECONTEXT.getPackageManager().getLaunchIntentForPackage(ApplicationName);
            Variable.BASECONTEXT.startActivity(intent);
        } catch (Exception e) {
            ToastMsg("尚未安装应用");
        }
    }

    @JavascriptInterface
    public int GetH5TaskId(){
        return Variable.clickH5TaskId;
    }
}
