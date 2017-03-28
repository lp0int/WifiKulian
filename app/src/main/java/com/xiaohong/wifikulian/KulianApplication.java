package com.xiaohong.wifikulian;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.tencent.smtt.sdk.QbSdk;
import com.xiaohong.wifikulian.handler.CrashHandler;

/**
 * Created by Lpoint on 2017/3/9 11:44.
 */

public class KulianApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Variable.BASECONTEXT = getBaseContext();
        Fresco.initialize(this);
        QbSdk.initX5Environment(this, null);
//        CrashHandler.getInstance().init(getApplicationContext());
    }
}
