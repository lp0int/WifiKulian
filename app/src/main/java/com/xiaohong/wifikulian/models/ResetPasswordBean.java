package com.xiaohong.wifikulian.models;

/**
 * Created by Lpoint on 2017/2/4 13:00.
 */

public class ResetPasswordBean {

    /**
     * coin_num : 44157
     * ret_code : 0
     * ret_msg : success
     */

    private int coin_num;
    private int ret_code;
    private String ret_msg;

    public int getCoin_num() {
        return coin_num;
    }

    public void setCoin_num(int coin_num) {
        this.coin_num = coin_num;
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
}
