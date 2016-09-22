package com.qf.administrator.xiongmao.util;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

/**
 * 跳转登陆界面
 */
public class JumpLogin {

    public static boolean isLogin(Context context){
//        SharedPreferences preferences = context.getSharedPreferences("login", Context.MODE_PRIVATE);
//        boolean is_logined = preferences.getBoolean("is_logined", false);
        return  PreferenceUtil.getBoolean(context, "is_logined", false);

    }

    public static void login(Context context) {
       Intent intent = new Intent(context, LoginActivity.class);
       context.startActivity(intent);
    }
}
