package com.xiaohong.wifikulian.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by Lpoint on 2017/1/24.
 */

public class EncodeParameter {
    public static String getLoginParameter(String phone_number, String passwd, int ver, String phone_mac, String imei, String model, String pl, String ssid) {
        String original_str = "phone_number=" + phone_number + "&passwd=" + Utils.getMD5(passwd) + "&ver=" + ver + "&phone_mac=" + phone_mac + "&imei=" + imei + "&model=" + model + "&pl=" + pl + "&ssid=" + Utils.getMD5(ssid);
        String encrypt_str = Utils.AESEncrypt(original_str).replace("\n", "");
        return encrypt_str;
    }
}
