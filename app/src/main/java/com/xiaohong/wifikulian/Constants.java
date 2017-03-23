package com.xiaohong.wifikulian;

import java.util.ArrayList;

/**
 * Created by Lpoint on 2017/1/24.
 */

public class Constants {
    public static final boolean DEBUG_MODE = true;
    public static final boolean GOD_MODE = true;
    public static final String PLATFORM = "android";
    public static final int FILE_CHOOSER_RESULT_CODE = 10000;
    public static final String DAY = "日";
    public static final String HOUR = "时";
    public static final String MINUTE = "分";
    public static final String QQREAD_URL = "http://ubook.3g.qq.com/";
    public static final String QQREAD_URL_WITH_CID = "http://ubook.qq.com/?g_f=100028";
    public static final String QQREAD_G_F = "100028";
    public static final String QQREAD_BASE_IRL = "http://ubook.qq.com/8/intro.html?bid=";
    public static final String WIFI_STATUS_CODE = "wifiStatusCode";
    public static final String CELLULAR_NETWORK = "蜂窝网络";
    public static final String CELLULAR_NO_NETWORK = "无网络";
    public static final int GET_PERMISSIONS_REQUEST_CODE = 0x400;
    public static final int BANNER_SWITCH_INTERVAL = 5;
    /**
     * SharedPreferences相关数据
     */
    public static final String LOGIN_STATUS = "loginStatus";
    public static final String AUTO_LOGIN ="autoLogin";
    public static final String USER_NAME = "userName";
    public static final String PASSWORD = "password";
    /**
     * 广播
     */
    public static final String BROADCAST_RECEIVER_ACTION = "com.xiaohong.wifikulian.broadcast.NetBroadcastReceiver";
    /**
     * 网络状态的值
     */
    public static final int NETWORK_TYPE_CELLULAR = 0x200;
    public static final int NETWORK_TYPE_OTHER_WIFI = 0x0201;
    public static final int NETWORK_TYPE_HONGWIFI_UNVERIFY = 0x0202;
    public static final int NETWORK_TYPE_HONGWIFI_VERIFIED = 0x0203;
    public static final int NETWORK_TYPE_NO_NETWORK = 0x0204;

    /**
     * SSID标识
     */
    public static final String[] SSIDLIST = {"hongwifi","ruijie","小鸿","wo-lan","-wo"};

    /**
     * 网络请求提示信息
     */
    public static final String DEFAULT_PROGRESS_MESSAGE = "数据请求中，请稍等";
    public static final String GET_SCROLL_MSG_PROGRESS_MESSAGE = "滚动消息更新中";
    public static final String GET_BANNER_PROGRESS_MESSAGE = "滚动广告更新中";
    public static final String GET_GALLERY_FUNCTION_PROGRESS_MESSAGE = "功能按钮数据更新中";
    public static final String GET_RECOMMEND_TASK_LIST_PROGRESS_MESSAGE = "推荐任务信息更新中";
    public static final String GET_QQ_READ_PROGRESS_MESSAGE = "阅读信息更新中";
    /**
     * otto的code值
     */
    public static final int CODE_LOGOUT = 0x000;
    public static final int CODE_REGISTER_OVER = 0x001;
    public static final int CODE_CHANGE_PWD = 0x002;
    public static final int CODE_CHANGE_NETWORK_STATUS = 0x003;
    /**
     * ActivityLogin的相关数据
     */
    public static final String LOGIN_USERNAME = "loginUserName";
    /**
     * ActivityForgetPwd的相关数据
     */
    public static final String RESET_PWD_USERNAME = "resetPwdUserName";
    public static final String RESET_PWD_PASSWORD = "resetPwdPassword";
    /**
     * 相关提示信息
     */
    public static final String PHONENUMBER_WRONGFUL = "电话号码不合法，请输入正确的号码";
    public static final String PASSWORD_UNLIKELINESS = "两次输入的密码不同，请核对后重新输入";
    /**
     * WebViewFragment相关数据
     */
    public static final String EXTERNAL_URL = "external.url";
    /**
     * 请求AdOrder的相关值
     */
    public static final int AD_TYPE_GET_GALLERY_FUNCTION = 7;
    public static final int AD_ADVERTISING_GET_GALLERY_FUNCTION = 16;
    public static final int AD_TYPE_GET_RECOMMEND_LIST = 3;
    public static final int AD_TYPE_GET_FIND_TAB_LIST = 8;
    public static final int AD_ADVERTISING_GET_FIND_TAB_LIST = 17;
    public static final int AD_TYPE_GET_BANNER = 11;
    public static final int AD_ADVERTISING_GET_BANNER = 19;
    public static final int AD_TYPE_GET_SCROLL_MSG = 9;
    public static final int AD_ADVERTISING_GET_SCROLL_MSG = 18;
    /**
     * 相关控制字段
     */
    public static final String APPLIST = "AppList";
}
