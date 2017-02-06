package com.xiaohong.wifikulian;

import android.content.Context;
import android.widget.Toast;

import com.xiaohong.wifikulian.models.GetTabListBean;
import com.xiaohong.wifikulian.models.LoginBean;

/**
 * Created by Lpoint on 2017/2/3.
 */

public class Variable {
    public static Context BASECONTEXT;
    /**
     * 防止Toast重复提示的相关变量
     */
    public static Toast toast = null;
    public static long oneTime = 0;
    public static long twoTime = 0;
    public static String oldMsg = null;
    /**
     * 个人信息相关
     */
    public static LoginBean loginBean;
    public static String userPhone;
    public static GetTabListBean tabListBean;
}
