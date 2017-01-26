package com.xiaohong.wifikulian.base;

import android.os.Handler;
import android.os.Looper;

import com.squareup.otto.Bus;

/**
 * Created by Lpoint on 2017/1/26.
 */

public class AppEvent extends Bus {
    private static AppEvent instance;

    public static AppEvent getInstance(){
        if(instance == null)
            instance = new AppEvent();
        return instance;
    }

    private Handler mHandler = new Handler(Looper.getMainLooper());

    public void postQueue(final Object object){
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                AppEvent.getInstance().post(object);
            }
        });
    }
}
