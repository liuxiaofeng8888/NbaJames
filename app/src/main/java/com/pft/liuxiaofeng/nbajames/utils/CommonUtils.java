package com.pft.liuxiaofeng.nbajames.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by LittlePudding on 17-6-13.
 */

public class CommonUtils {
    private static Toast toast;

    /**
     * 判断一个字符串是否为空
     */
    public static boolean isEmpty(Object object) {
        String string = object + "";
        if (string.equals("") || string.equals("null")) {
            return true;
        }
        return false;
    }

    public static void showToast(Context context, String msg) {
        if (toast == null) {
            toast = Toast.makeText(context.getApplicationContext(), msg, Toast.LENGTH_SHORT);
        } else {
            toast.setText(msg);
        }
        toast.show();
    }

    public static void showLongToast(Context context, String msg) {
        if (toast == null) {
            toast = Toast.makeText(context, msg, Toast.LENGTH_LONG);
        } else {
            toast.setText(msg);
        }
        toast.show();
    }


    /**
     * 计算百分比
     */
    public static String getPercentage(int num1, int num2) {

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

    /**
     * 判断是否有网络连接
     *
     * @param context
     * @return
     */
    public static boolean isNetworkConnected(Context context) {
        if (context != null) {
            ConnectivityManager mConnectivityManager = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mNetworkInfo = mConnectivityManager.getActiveNetworkInfo();
            if (mNetworkInfo != null) {
                return mNetworkInfo.isAvailable();
            }
        }
        return false;
    }

    /**
     * 判断WIFI网络是否可用
     *
     * @param context
     * @return
     */
    public boolean isWifiConnected(Context context) {
        if (context != null) {
            ConnectivityManager mConnectivityManager = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mWiFiNetworkInfo = mConnectivityManager
                    .getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            if (mWiFiNetworkInfo != null) {
                return mWiFiNetworkInfo.isAvailable();
            }
        }
        return false;
    }


    /**
     * 判断mobile网络是否可用
     *
     * @param context
     * @return
     */
    public boolean isMobileConnected(Context context) {
        if (context != null) {
            ConnectivityManager mConnectivityManager = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mMobileNetworkInfo = mConnectivityManager
                    .getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
            if (mMobileNetworkInfo != null) {
                return mMobileNetworkInfo.isAvailable();
            }
        }
        return false;
    }

    /**
     * 获取当前的网络类型
     *
     * @param context
     * @return
     */
    public static int getConnectedType(Context context) {
        if (context != null) {
            ConnectivityManager mConnectivityManager = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mNetworkInfo = mConnectivityManager.getActiveNetworkInfo();
            if (mNetworkInfo != null && mNetworkInfo.isAvailable()) {
                return mNetworkInfo.getType();
            }
        }
        return -1;
    }

    /**
     * 设置金额，添加元
     * @return
     */
    public static String setAmount(Object amount) {

        if (amount instanceof Double) {
            //格式化double为两位小数
            return formatDouble((Double) amount) + "元";
        }
        return amount + "元";
    }

    /**
     * 格式化为两位小数
     * @param num
     * @return
     */
    public static String formatDouble(double num) {
        java.text.DecimalFormat df = new java.text.DecimalFormat("#0.00");
        return df.format(num);
    }

    /**
     * null转换成空字符串
     *
     * @param str
     * @return
     */
    public static String nullStrToEmpty(Object str) {
        return (str == null ? "" : (str instanceof String ? (String) str : str.toString()));
    }

    /**
     * 判断date距离当前多长时间
     * @param date
     * @return
     */
    public static String getTimeLine(Date date){
        long now = new Date().getTime();
        long da1 = date.getTime();
        String timeline = "";
        if(now>da1){//之前
            long a = now-da1;
            if(a/1000==0){
                timeline = "刚刚";
            }else {
                long a1 = a/1000;
                if(a1<60){
                    timeline = a1+"秒前";
                } else{
                    long b = a1/60;
                    if(b<60){
                        if(b>30){
                            timeline = "半小时前";
                        }else{
                            timeline = b+"分钟前";
                        }
                    }else{
                        long c = b/60;
                        if(c<24){
                            timeline = c+"小时前";
                        }else {
                            long d = c/24;
                            if(d<30){
                                if(d>7){
                                    timeline = (d/7)+"周前";
                                }else{
                                    timeline = d+"天前";
                                }
                            } else{
                                long e = d/30;
                                if(e<12){
                                    timeline = e+"月前";
                                } else{
                                    timeline = getTime(date, "yy/MM/dd");
                                }
                            }
                        }
                    }
                }
            }
        } else {
            long a = da1-now;
            if(a/1000==0){
                timeline = "刚刚";
            }else {


                long a1 = a/1000;{
                    if(a1<60){
                        timeline = a1+"秒后";
                    } else{
                        long b = a1/60;

                        if(b<60){
                            if(b==30){
                                timeline = "半小时后";
                            }else{
                                timeline = b+"分钟后";
                            }
                        }else{
                            long c = b/60;
                            if(c<24){
                                timeline = c+"小时后";
                            }else {
                                long d = c/24;
                                if(d<30){
                                    if(d%7==0){
                                        timeline = (d/7)+"周后";
                                    }else{
                                        timeline = d+"天后";
                                    }
                                } else{
                                    long e = d/30;
                                    if(e<12){
                                        timeline = e+"月后";
                                    } else{
                                        timeline = getTime(date,"yy/MM/dd");
                                    }
                                }

                            }

                        }
                    }
                }

            }
        }
        return timeline;
    }

    public static String getTime(Date date,String format){
        return new SimpleDateFormat(format).format(date);
    }
}
