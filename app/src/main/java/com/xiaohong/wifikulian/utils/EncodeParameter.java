package com.xiaohong.wifikulian.utils;

/**
 * Created by Lpoint on 2017/1/24.
 */

public class EncodeParameter {
    public static String getLoginParameter(String phone_number, String passwd, int ver, String phone_mac, String imei, String model, String pl, String ssid) {
        String original_str = "phone_number=" + phone_number + "&passwd=" + Util.getMD5(passwd) + "&ver=" + ver + "&phone_mac=" + phone_mac + "&imei=" + imei + "&model=" + model + "&pl=" + pl + "&ssid=" + Util.getMD5(ssid);
        String encrypt_str = Util.AESEncrypt(original_str).replace("\n", "");
        return encrypt_str;
    }

    public static String getVerifyCodeParameter(String phone_number,int ver){
        String original_str = "phone_number=" + phone_number + "&ver=" + ver;
        String encrypt_str = Util.AESEncrypt(original_str).replace("\n", "");
        return encrypt_str;
    }

    public static String getResetPwdParameter(String phone_number,String new_passwd,String verify_code,String ver,String pl){
        String original_str = "phone_number=" + phone_number + "&new_passwd=" + new_passwd + "&verify_code=" + verify_code + "&ver=" + ver + "&pl=" + pl;
        String encrypt_str = Util.AESEncrypt(original_str).replace("\n", "");
        return encrypt_str;
    }
}
