package com.pft.liuxiaofeng.nbajames.utils;

import android.content.Context;
import android.widget.Toast;

import java.text.NumberFormat;

/**
 * Created by LittlePudding on 17-6-13.
 */

public class CommonUtils {

    /**
     * 判断一个字符串是否为空
     */
    public static boolean isEmpty(Object object){
        String string = object+"";
        if (string.equals("")||string.equals("null")){
            return true;
        }
        return false;
    }

    public static void showToast(Context context, String msg) {
        Toast.makeText(context.getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }

    /**
     * 计算百分比
     */
    public static String getPercentage(int num1,int num2){

        // 创建一个数值格式化对象

        NumberFormat numberFormat = NumberFormat.getInstance();

        // 设置精确到小数点后2位

        numberFormat.setMaximumFractionDigits(2);

        String result = numberFormat.format((float) num1 / (float) num2 * 100);

        return result;
//        return "num1和num2的百分比为:" + result + "%";
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }
}
