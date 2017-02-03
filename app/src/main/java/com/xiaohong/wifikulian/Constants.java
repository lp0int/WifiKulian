package com.xiaohong.wifikulian;

/**
 * Created by Lpoint on 2017/1/24.
 */

public class Constants {
    public static final boolean DEBUG_MODE = true;
    public static final boolean GOD_MODE = true;
    public static final String PLATFORM = "android";

    public static final String PROGRESS_MESSAGE = "数据请求中，请稍等";
    /**
     * otto的code值
     */
    public static final int CODE_LOGOUT = 0x000;
    public static final int CODE_REGISTER_OVER = 0x001;
    /**
     * ActivityLogin的相关数据
     */
    public static final String LOGIN_USERNAME = "loginUserName";
    /**
     * 相关提示信息
     */
    public static final String PHONENUMBER_WRONGFUL = "电话号码不合法，请输入正确的号码";
    public static final String PASSWORD_UNLIKELINESS = "两次输入的密码不同，请核对后重新输入";
}
