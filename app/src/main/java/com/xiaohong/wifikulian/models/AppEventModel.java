package com.xiaohong.wifikulian.models;

import android.os.Bundle;

import java.io.Serializable;

/**
 * Created by Lpoint on 2017/1/26.
 */

public class AppEventModel implements Serializable {
    private int eventCode;
    private Bundle bundle;

    public AppEventModel(int eventCode) {
        this.eventCode = eventCode;
    }

    public AppEventModel(int eventCode, Bundle bundle) {
        this.eventCode = eventCode;
        this.bundle = bundle;
    }

    public int getEventCode() {
        return eventCode;
    }

    public void setBundle(Bundle bundle) {
        this.bundle = bundle;
    }

    public Bundle getBundle() {
        return bundle;
    }
}
