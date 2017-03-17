package com.xiaohong.wifikulian.utils;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import com.xiaohong.wifikulian.Constants;
import com.xiaohong.wifikulian.Variable;

/**
 * Created by Lpoint on 2017/3/17 16:44.
 */

public class PermissionsUtils {
    public static void getPermissions(Context mContext) {
        if (ContextCompat.checkSelfPermission(mContext, Manifest.permission.READ_PHONE_STATE)
                != PackageManager.PERMISSION_GRANTED) {
            //进入到这里代表没有权限.
            Variable.havePermissions = false;
            if (ActivityCompat.shouldShowRequestPermissionRationale((Activity) mContext, Manifest.permission.READ_PHONE_STATE)) {
                //已经禁止提示了
                Utils.showToastStr(mContext, "请前往设置中打开相关权限");
            } else {
                ActivityCompat.requestPermissions((Activity) mContext, new String[]{Manifest.permission.READ_PHONE_STATE}, Constants.GET_PERMISSIONS_REQUEST_CODE);
            }
        }else{
            Variable.havePermissions = true;
        }
    }
}
