package com.qf.administrator.xiongmao.util;

import android.app.Activity;
import android.provider.Settings;
import android.util.Log;
import android.view.WindowManager;
import android.widget.Toast;

/**
 * 改变亮度的工具类
 * <p/>
 * 亮度是系统的一个设置,我们需要修改设置中的内容
 * 需要添加一个权限,WRITE_SETTINGS
 */
public class LightController {

    private static final String TAG = LightController.class.getSimpleName();

    /**
     * @param context
     * @param yDelta      < 0
     * @param screenWidth
     */
    public static void lightUp(Activity context, float yDelta, int screenWidth) {
        try {
            //获取当前亮度
            int currentLight = Settings.System.getInt(context.getContentResolver(), Settings.System.SCREEN_BRIGHTNESS, -1);
            //系统亮度不提供最大值 (0 - 255)  add<0
            float add = 2 * yDelta * 255 / screenWidth;
            //改变界面亮度
            WindowManager.LayoutParams attributes = context.getWindow().getAttributes();
            //screenBrightness 取值0 - 1 float类型
            attributes.screenBrightness = Math.min(255, currentLight - add) / 255;
            //设置界面参数
            context.getWindow().setAttributes(attributes);
            //
            Settings.System.putInt(context.getContentResolver(), Settings.System.SCREEN_BRIGHTNESS, (int) Math.min(255, currentLight - add));
        } catch (Exception e) {
            Log.e(TAG, "lightUp: " );
            Toast.makeText(context, "无法改变亮度", Toast.LENGTH_SHORT).show();
        }
    }

    public static void lightDown(Activity context, float yDelta, int screenWidth){
        try {
            //获取当前亮度
            int currentLight = Settings.System.getInt(context.getContentResolver(), Settings.System.SCREEN_BRIGHTNESS, -1);
            //系统亮度不提供最大值 (0 - 255)  add<0
            float reduce = 2 * yDelta * 255 / screenWidth;
            //改变界面亮度
            WindowManager.LayoutParams attributes = context.getWindow().getAttributes();
            //screenBrightness 取值0 - 1 float类型
            attributes.screenBrightness = Math.max(0, currentLight - reduce) / 255;
            //设置界面参数
            context.getWindow().setAttributes(attributes);
            //
            Settings.System.putInt(context.getContentResolver(), Settings.System.SCREEN_BRIGHTNESS, (int) Math.max(0, currentLight - reduce));
        } catch (Exception e) {
            Log.e(TAG, "lightUp: " );
            Toast.makeText(context, "无法改变亮度", Toast.LENGTH_SHORT).show();
        }
    }
}
