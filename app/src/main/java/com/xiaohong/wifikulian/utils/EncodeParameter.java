package com.xiaohong.wifikulian.utils;

import com.xiaohong.wifikulian.ApplicationInfo;
import com.xiaohong.wifikulian.Constants;

/**
 * Created by Lpoint on 2017/1/24.
 */

public class EncodeParameter {
    public static String getLoginParameter(String phone_number, String passwd, String phone_mac, String imei, String model, String ssid) {
        String original_str = "phone_number=" + phone_number + "&passwd=" + Utils.getMD5(passwd) + "&phone_mac="
                + phone_mac + "&imei=" + imei + "&model=" + model + "&ssid=" + Utils.getMD5(ssid) + getPublicParameter();
        String encrypt_str = Utils.AESEncrypt(original_str).replace("\n", "");
        return encrypt_str;
    }

    public static String getVerifyCodeParameter(String phone_number) {
        String original_str = "phone_number=" + phone_number + getPublicParameter();
        String encrypt_str = Utils.AESEncrypt(original_str).replace("\n", "");
        return encrypt_str;
    }

    public static String getResetPwdParameter(String phone_number, String new_passwd, String verify_code) {
        String original_str = "phone_number=" + phone_number + "&new_passwd=" + new_passwd + "&verify_code=" + verify_code + getPublicParameter();
        String encrypt_str = Utils.AESEncrypt(original_str).replace("\n", "");
        return encrypt_str;
    }

    public static String getAdOrder(int ad_type, int ad_advertising, String user_phone) {
        String original_str = "ad_type=" + ad_type + "&ad_advertising=" + ad_advertising + "&user_phone=" + user_phone + getPublicParameter();
        String encypt_str = Utils.AESEncrypt(original_str).replace("\n", "");
        return encypt_str;
    }

    public static String getRecommendList(String user_phone) {
        String original_str = "ad_type=" + Constants.AD_TYPE_GET_RECOMMEND_LIST + "&user_phone=" + user_phone + getPublicParameter();
        String encypt_str = Utils.AESEncrypt(original_str).replace("\n", "");
        return encypt_str;
    }

    public static String getAdControl(String user_phone){
        String original_str = "user_phone=" + user_phone + getPublicParameter();
        String encypt_str = Utils.AESEncrypt(original_str).replace("\n", "");
        return encypt_str;
    }

    private static String getPublicParameter() {
        return "&pl=" + Constants.PLATFORM + "&ver=" + Utils.getVersionCode() + "&channel=" + ApplicationInfo.channel + "&t=" + System.currentTimeMillis();
    }
}
