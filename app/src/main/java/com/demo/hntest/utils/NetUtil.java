package com.demo.hntest.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.NetworkInterface;

/**
 * https://blog.csdn.net/sinat_31057219/article/details/81134030?spm=1001.2101.3001.6650.1
 * &utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromBaidu%7ERate-1-
 * 81134030-blog-106491767.235%5Ev43%5Epc_blog_bottom_relevance_base8&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromBaidu%7ERate-1-81134030-blog-106491767.235%5Ev43%5Epc_blog_bottom_relevance_base8&utm_relevant_index=2
 */
public class NetUtil {
    //网络类型
    public static final int NETTYPE_NONE = 0;//没有网络
    public static final int NETTYPE_WIFI = 1;//wifi
    ///2G网络
    public static final int NETTYPE_2G = 2;
    //3G网络
    public static final int NETTYPE_3G = 3;
    //4G网络
    public static final int NETTYPE_4G = 4;
    //5G网络
    public static final int NETTYPE_5G = 5;
    //手机网络
    public static final int NETTYPE_MOBILE = 6;

    /**
     * 获取运营商名字
     */
    public static String getOperatorName(Context context) {
        /*
         * getSimOperatorName()就可以直接获取到运营商的名字
         * 也可以使用IMSI获取，getSimOperator()，然后根据返回值判断，例如"46000"为移动
         * IMSI相关链接：http://baike.baidu.com/item/imsi
         */
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        return telephonyManager.getSimOperatorName();
    }

    /**
     * 获取当前网络连接类型
     */
    public static int getNetWorkType(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager == null) return NETTYPE_NONE;
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo == null || !networkInfo.isAvailable()) return NETTYPE_NONE;
        //判断是否为wifi
        NetworkInfo wifi = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        if (wifi != null) {
            NetworkInfo.State state = wifi.getState();
            if (null != state) {
                if (state == NetworkInfo.State.CONNECTED || state == NetworkInfo.State.CONNECTING) {
                    return NETTYPE_WIFI;
                }
            }
        }
        //若不是WiFi 判断是否是 2G 3G 4G 5G
        return getNetWorkTypeByMobile(context);
    }

    private static int getNetWorkTypeByMobile(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        switch (telephonyManager.getNetworkType()) {

            /*
	   GPRS : 2G(2.5) General Packet Radia Service 114kbps
	   EDGE : 2G(2.75G) Enhanced Data Rate for GSM Evolution 384kbps
	   UMTS : 3G WCDMA 联通3G Universal Mobile Telecommunication System 完整的3G移动通信技术标准
	   CDMA : 2G 电信 Code Division Multiple Access 码分多址
	   EVDO_0 : 3G (EVDO 全程 CDMA2000 1xEV-DO) Evolution - Data Only (Data Optimized) 153.6kps - 2.4mbps 属于3G
	   EVDO_A : 3G 1.8mbps - 3.1mbps 属于3G过渡，3.5G
	   1xRTT : 2G CDMA2000 1xRTT (RTT - 无线电传输技术) 144kbps 2G的过渡,
	   HSDPA : 3.5G 高速下行分组接入 3.5G WCDMA High Speed Downlink Packet Access 14.4mbps
	   HSUPA : 3.5G High Speed Uplink Packet Access 高速上行链路分组接入 1.4 - 5.8 mbps
	   HSPA : 3G (分HSDPA,HSUPA) High Speed Packet Access
	   IDEN : 2G Integrated Dispatch Enhanced Networks 集成数字增强型网络 （属于2G，来自维基百科）
	   EVDO_B : 3G EV-DO Rev.B 14.7Mbps 下行 3.5G
	   LTE : 4G Long Term Evolution FDD-LTE 和 TDD-LTE , 3G过渡，升级版 LTE Advanced 才是4G
	   EHRPD : 3G CDMA2000向LTE 4G的中间产物 Evolved High Rate Packet Data HRPD的升级
	   HSPAP : 3G HSPAP 比 HSDPA 快些
	   */

            case TelephonyManager.NETWORK_TYPE_GPRS:
            case TelephonyManager.NETWORK_TYPE_EDGE:
            case TelephonyManager.NETWORK_TYPE_CDMA:
            case TelephonyManager.NETWORK_TYPE_1xRTT:
            case TelephonyManager.NETWORK_TYPE_IDEN:
                return NETTYPE_2G;
            case TelephonyManager.NETWORK_TYPE_UMTS:
            case TelephonyManager.NETWORK_TYPE_EVDO_0:
            case TelephonyManager.NETWORK_TYPE_EVDO_A:
            case TelephonyManager.NETWORK_TYPE_HSDPA:
            case TelephonyManager.NETWORK_TYPE_HSUPA:
            case TelephonyManager.NETWORK_TYPE_HSPA:
            case TelephonyManager.NETWORK_TYPE_EVDO_B:
            case TelephonyManager.NETWORK_TYPE_HSPAP:
                return NETTYPE_3G;
            case TelephonyManager.NETWORK_TYPE_LTE:
                return NETTYPE_4G;
            case TelephonyManager.NETWORK_TYPE_EHRPD:
                return NETTYPE_5G;
            default:
                return NETTYPE_MOBILE;
        }

    }

    //判断网络是否连接
    public static boolean isConnected(Context context) {
        ConnectivityManager connectivity = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (null != connectivity) {
            NetworkInfo info = connectivity.getActiveNetworkInfo();
            if (null != info && info.isConnected()) {
                if (info.getState() == NetworkInfo.State.CONNECTED) {
                    return true;
                }
            }
        }
        return false;
    }

    //判断是否wifi连接
    public static synchronized boolean isWifi(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm == null) return false;
        NetworkInfo wifi = cm.getActiveNetworkInfo();
        if (wifi != null) {
            int type = wifi.getType();
            if (type == ConnectivityManager.TYPE_WIFI || type == ConnectivityManager.TYPE_ETHERNET) {
                return wifi.isConnected();
            }
        }
        return false;
    }

    public static int getNetWorkWifiLevel(Context context) {
        if (!isWifi(context)) {
            return 0;
        }
        WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        WifiInfo wifiInfo = wifiManager.getConnectionInfo();
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.N) {
            int level = wifiInfo.getRssi();
            if (level <= 0 && level >= -50) {
                //最强
                System.out.println("网络信号强度 level 5-------" + level);
                return 5;
            } else if (level < -50 && level >= -70) {
                //较强
                System.out.println("网络信号强度 level 4-------" + level);
                return 4;
            } else if (level < -70 && level >= -80) {
                //较弱
                System.out.println("网络信号强度 level 3-------" + level);
                return 3;
            } else if (level < -80 && level >= -100) {
                //약弱
                System.out.println("网络信号强度 level 2-------" + level);
                return 2;
            } else {
                //微弱
                System.out.println("网络信号强度 level 1-------" + level);
                return 1;
            }

        }
        return 0;
    }


    //判断热点是否打开

    public static boolean isWifiApOpen(Context context) {
        try {
            WifiManager manager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
            //通过放射获取 getWifiApState()方法
            Method method = manager.getClass().getDeclaredMethod("getWifiApState");
            //调用getWifiApState() ，获取返回值
            int state = (int) method.invoke(manager);
            //通过放射获取 WIFI_AP的开启状态属性
            Field field = manager.getClass().getDeclaredField("WIFI_AP_STATE_ENABLED");
            //获取属性值
            int value = (int) field.get(manager);
            //判断是否开启
            if (state == value) {
                return true;
            } else {
                return false;
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return false;
    }

}
