package com.pft.liuxiaofeng.nbajames.utils;

import android.content.Context;
import android.widget.Toast;

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
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }
}
