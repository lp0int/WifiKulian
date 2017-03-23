package com.xiaohong.wifikulian;

import android.content.Context;
import android.widget.Toast;

import com.xiaohong.wifikulian.Interface.NetChangeInterface;
import com.xiaohong.wifikulian.models.AdControlBean;
import com.xiaohong.wifikulian.models.AdOrdersBean;
import com.xiaohong.wifikulian.models.GetTabListBean;
import com.xiaohong.wifikulian.models.LoginBean;
import com.xiaohong.wifikulian.models.RecommendListBean;

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
    /**
     * APP内需要展示的信息
     */
    public static AdOrdersBean tabListBean;
    public static RecommendListBean recommendListBean;
    public static AdOrdersBean galleryFunctionList;
    public static AdControlBean adControlBean;
    public static AdOrdersBean bannerList;
    public static AdOrdersBean scrollMsgList;
    public static NetChangeInterface netChangeInterface;
    public static boolean havePermissions = false;

    public static String packageName = "";
    public static int clickH5TaskId = -1;
}
