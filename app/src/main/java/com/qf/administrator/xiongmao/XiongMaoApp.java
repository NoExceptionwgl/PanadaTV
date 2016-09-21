package com.qf.administrator.xiongmao;

import android.app.Application;

import org.xutils.x;

/**
 *
 */
public class XiongMaoApp extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(true);
    }
}
