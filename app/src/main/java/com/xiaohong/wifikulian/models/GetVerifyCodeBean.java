package com.xiaohong.wifikulian.models;

/**
 * Created by Lpoint on 2017/2/3.
 */

public class GetVerifyCodeBean {

    /**
     * ret_code : 0
     * ret_msg : success
     * token : qHI1wwvY/EaoMfyLPJsSLhJaaIDYw9JvZWBDHcqkb5jzbfxfeHHVPo5S6kmyuLQiG7ionmZrAPs=
     */

    private int ret_code;
    private String ret_msg;
    private String token;

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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
