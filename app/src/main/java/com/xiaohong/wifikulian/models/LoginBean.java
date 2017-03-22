package com.xiaohong.wifikulian.models;

import java.io.Serializable;

/**
 * Created by Lpoint on 2017/1/20 14:18.
 */

public class LoginBean implements Serializable {

    /**
     * account : 100
     * birth_month : 5
     * birth_year : 1992
     * city_name : 其他
     * coin_num : 52029
     * fac_name : 上海
     * gender : M
     * icon_url : http://cs.dspmind.com/upload/head/15517503498.jpg?t=20170227174524
     * invite_code : 503498
     * is_sign : true
     * is_wolan_ssid : false
     * nick_name : 星星
     * remain_time : 35683273
     * ret_code : 0
     * ret_msg : success
     * show_countdown : true
     * token : JNGdT3H0dB4cYKCIZ3uYPVJBcYop3K8D3wczOlWEIQIBm3fICdBwNh27zTclomFL
     * wx_id : 133565236
     * wx_openid : ouo50s5Zuqg_UrtrN_CuH8SVWKQg
     */

    private int account;
    private int birth_month;
    private int birth_year;
    private String city_name;
    private int coin_num;
    private String fac_name;
    private String gender;
    private String icon_url;
    private String invite_code;
    private String is_sign;
    private String is_wolan_ssid;
    private String nick_name;
    private long remain_time;
    private int ret_code;
    private String ret_msg;
    private String show_countdown;
    private String token;
    private String wx_id;
    private String wx_openid;

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    public int getBirth_month() {
        return birth_month;
    }

    public void setBirth_month(int birth_month) {
        this.birth_month = birth_month;
    }

    public int getBirth_year() {
        return birth_year;
    }

    public void setBirth_year(int birth_year) {
        this.birth_year = birth_year;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public int getCoin_num() {
        return coin_num;
    }

    public void setCoin_num(int coin_num) {
        this.coin_num = coin_num;
    }

    public String getFac_name() {
        return fac_name;
    }

    public void setFac_name(String fac_name) {
        this.fac_name = fac_name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIcon_url() {
        return icon_url;
    }

    public void setIcon_url(String icon_url) {
        this.icon_url = icon_url;
    }

    public String getInvite_code() {
        return invite_code;
    }

    public void setInvite_code(String invite_code) {
        this.invite_code = invite_code;
    }

    public String getIs_sign() {
        return is_sign;
    }

    public void setIs_sign(String is_sign) {
        this.is_sign = is_sign;
    }

    public String getIs_wolan_ssid() {
        return is_wolan_ssid;
    }

    public void setIs_wolan_ssid(String is_wolan_ssid) {
        this.is_wolan_ssid = is_wolan_ssid;
    }

    public String getNick_name() {
        return nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }

    public long getRemain_time() {
        return remain_time;
    }

    public void setRemain_time(long remain_time) {
        this.remain_time = remain_time;
    }

    public int getRet_code() {
        return ret_code;
    }

    public void setRet_code(int ret_code) {
        this.ret_code = ret_code;
    }

    public String getRet_msg() {
        return ret_msg;
    }

    public void setRet_msg(String ret_msg) {
        this.ret_msg = ret_msg;
    }

    public String getShow_countdown() {
        return show_countdown;
    }

    public void setShow_countdown(String show_countdown) {
        this.show_countdown = show_countdown;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getWx_id() {
        return wx_id;
    }

    public void setWx_id(String wx_id) {
        this.wx_id = wx_id;
    }

    public String getWx_openid() {
        return wx_openid;
    }

    public void setWx_openid(String wx_openid) {
        this.wx_openid = wx_openid;
    }
}
