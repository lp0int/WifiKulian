package com.xiaohong.wifikulian.utils;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.telephony.TelephonyManager;

import com.xiaohong.wifikulian.Constants;
import com.xiaohong.wifikulian.Variable;

/**
 * Created by Lpoint on 2017/1/24.
 */

public class PhoneInfo {
    public static WifiManager wifiManager = (WifiManager) Variable.BASECONTEXT.getSystemService(Context.WIFI_SERVICE);
    public static TelephonyManager telephonyManager = (TelephonyManager) Variable.BASECONTEXT.getSystemService(Context.TELEPHONY_SERVICE);
    public static ConnectivityManager connectivityManager = (ConnectivityManager) Variable.BASECONTEXT
            .getSystemService(Context.CONNECTIVITY_SERVICE);

    public static String Mac() {
        String macAddress = "-1";
        WifiInfo wifiInfo = wifiManager.getConnectionInfo();
        if (wifiManager != null && wifiInfo != null)
            macAddress = wifiInfo.getMacAddress();
        return macAddress;
    }

    public static String SSID() {
        String ssid = "-1";
        WifiInfo wifiInfo = wifiManager.getConnectionInfo();
        if (wifiManager != null && wifiInfo != null)
            ssid = wifiInfo.getSSID();
        return ssid.replace("\"", "");
    }

    public static String IMEI(Context mContext) {
        if (ContextCompat.checkSelfPermission(mContext, Manifest.permission.READ_PHONE_STATE)
                != PackageManager.PERMISSION_GRANTED) {
            //进入到这里代表没有权限.
            ActivityCompat.requestPermissions((Activity) mContext, new String[]{Manifest.permission.CALL_PHONE}, 1);
            return "";
        }
        String imei = "-1";
        if (telephonyManager != null)
            imei = telephonyManager.getDeviceId();
        return imei;
    }

    public static String PHONENUM() {
        String phoneNumber = "-1";
        if (telephonyManager != null)
            phoneNumber = telephonyManager.getLine1Number();
        return phoneNumber;
    }

    public static String PHONEMODEL() {
        return android.os.Build.MODEL;
    }
}
