package com.xiaohong.wifikulian.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

/**
 * Created by Lpoint on 2017/3/21.
 */

public class SharedPreferencesUtils {
    private static SharedPreferences sp;

    public static String getStringValue(Context mContext,String sharedPreferencesName,String sharedPreferencesKey,String defaultValue){
        sp = mContext.getSharedPreferences(sharedPreferencesName, Context.MODE_PRIVATE);
        return sp.getString(sharedPreferencesKey,defaultValue);
    }

    public static int getIntValue(Context mContext,String sharedPreferencesName,String sharedPreferencesKey,int defaultValue){
        sp = mContext.getSharedPreferences(sharedPreferencesName, Context.MODE_PRIVATE);
        return sp.getInt(sharedPreferencesKey,defaultValue);
    }

    public static boolean getBooleanValue(Context mContext,String sharedPreferencesName,String sharedPreferencesKey,boolean defaultValue){
        sp = mContext.getSharedPreferences(sharedPreferencesName, Context.MODE_PRIVATE);
        return sp.getBoolean(sharedPreferencesKey,defaultValue);
    }

    public static boolean setStringValue(Context mContext,String sharedPreferencesName,String sharedPreferencesKey,String sharedPreferencesValue){
        try {
            sp = mContext.getSharedPreferences(sharedPreferencesName, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sp.edit();
            editor.putString(sharedPreferencesKey, sharedPreferencesValue);
            editor.commit();
            return true;
        }catch (Exception e){
            return false;
        }
    }
    public static boolean setIntValue(Context mContext,String sharedPreferencesName,String sharedPreferencesKey,int sharedPreferencesValue){
        try {
            sp = mContext.getSharedPreferences(sharedPreferencesName, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sp.edit();
            editor.putInt(sharedPreferencesKey, sharedPreferencesValue);
            editor.commit();
            return true;
        }catch (Exception e){
            return false;
        }
    }
    public static boolean setBooleanValue(Context mContext,String sharedPreferencesName,String sharedPreferencesKey,boolean sharedPreferencesValue){
        try {
            sp = mContext.getSharedPreferences(sharedPreferencesName, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sp.edit();
            editor.putBoolean(sharedPreferencesKey, sharedPreferencesValue);
            editor.commit();
            return true;
        }catch (Exception e){
            return false;
        }
    }

}
