package com.xiaohong.wifikulian.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.util.Base64;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.xiaohong.wifikulian.Constants;
import com.xiaohong.wifikulian.R;
import com.xiaohong.wifikulian.Variable;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created by Lpoint on 2017/1/20 11:05.
 */

public class Utils {
    public static void hideActiconBar(Activity activity) {
        activity.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = activity.getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                    | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
            window.setNavigationBarColor(Color.TRANSPARENT);
        }
    }

    @SuppressLint("NewApi")
    public static String AESEncrypt(String sSrc) {
        String key1 = "x!a0";
        String key2 = "h0ng";
        String key3 = "@18*01#)";
        String key = key1 + key2 + key3;
        SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(), "AES");
        try {

            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
            byte[] encrypted = cipher.doFinal(sSrc.getBytes());
            return Base64.encodeToString(encrypted, Base64.DEFAULT);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String getMD5(String val) {
        byte[] hash;

        try {
            hash = MessageDigest.getInstance("MD5").digest(val.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        }

        StringBuilder hex = new StringBuilder(hash.length * 2);
        for (byte b : hash) {
            if ((b & 0xFF) < 0x10)
                hex.append("0");
            hex.append(Integer.toHexString(b & 0xFF));
        }

        return hex.toString();
    }

    public static String getVersion()//获取版本号
    {
        try {
            PackageInfo pi = Variable.BASECONTEXT.getPackageManager().getPackageInfo(Variable.BASECONTEXT.getPackageName(), 0);
            return pi.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return Variable.BASECONTEXT.getString(R.string.version_unknown);
        }
    }

    public static int getVersionCode()//获取版本号(内部识别号)
    {
        try {
            PackageInfo pi = Variable.BASECONTEXT.getPackageManager().getPackageInfo(Variable.BASECONTEXT.getPackageName(), 0);
            return pi.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static boolean isChinaPhoneLegal(String str) throws PatternSyntaxException {
        String regExp = "^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$";
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(str);
        return m.matches();
    }

    public static void showToastStr(Context context, String s) {
        if (Variable.toast == null) {
            Variable.toast = Toast.makeText(context, s, Toast.LENGTH_SHORT);
            Variable.toast.show();
            Variable.oneTime = System.currentTimeMillis();
        } else {
            Variable.twoTime = System.currentTimeMillis();
            if (s.equals(Variable.oldMsg)) {
                if (Variable.twoTime - Variable.oneTime > Toast.LENGTH_SHORT) {
                    Variable.toast.show();
                }
            } else {
                Variable.oldMsg = s;
                Variable.toast.setText(s);
                Variable.toast.show();
            }
        }
        Variable.oneTime = Variable.twoTime;
    }
}
