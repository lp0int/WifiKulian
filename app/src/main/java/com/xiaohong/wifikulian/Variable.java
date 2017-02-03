package com.xiaohong.wifikulian;

import android.content.Context;
import android.widget.Toast;

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
}
