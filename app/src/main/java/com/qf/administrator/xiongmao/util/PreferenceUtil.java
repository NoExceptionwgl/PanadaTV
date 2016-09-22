package com.qf.administrator.xiongmao.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * SharePreference封装
 */
public class PreferenceUtil {

    public static boolean getBoolean(Context context,String key, boolean defValue) {
        SharedPreferences preferences = context.getSharedPreferences("is_logined", Context.MODE_PRIVATE);
        return preferences.getBoolean(key,defValue);
    }
    public static void setBoolean(Context context,String key, boolean value) {
        SharedPreferences preferences = context.getSharedPreferences("is_logined", Context.MODE_PRIVATE);
        preferences.edit().putBoolean(key, value).commit();

    }



}
