package com.xiaohong.wifikulian.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.xiaohong.wifikulian.Constants;

/**
 * Created by Lpoint on 2017/3/16 14:28.
 */

public class NetUtils {
    public static int getNetworkState() {
        NetworkInfo activeNetworkInfo = PhoneInfo.connectivityManager
                .getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            if (activeNetworkInfo.getType() == (ConnectivityManager.TYPE_WIFI)) {
                if (PhoneInfo.SSID().startsWith("hongWifi"))
                    return Constants.NETWORK_TYPE_HONGWIFI_VERIFIED;
                return Constants.NETWORK_TYPE_OTHER_WIFI;
            } else if (activeNetworkInfo.getType() == (ConnectivityManager.TYPE_MOBILE)) {
                return Constants.NETWORK_TYPE_CELLULAR;
            }
        } else {
            return Constants.NETWORK_TYPE_NO_NETWORK;
        }
        return Constants.NETWORK_TYPE_NO_NETWORK;
    }
}
