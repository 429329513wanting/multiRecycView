package com.sendinfo.okgodemo.HttpUtil;

import android.text.TextUtils;

import com.sendinfo.okgodemo.Util.SPreferencesUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <pre>
 *     author : ghwang
 *     e-mail : 429329513@qq.com
 *     time   : 2018/04/21
 *     desc   :
 * </pre>
 */

public class Constant {

    public static final String APITOKEN = "89757";
    public static final String APPKEY = "2017benkel63";


    public static final String Baseurl = "http://www.benke168.com";
    public static final String Doman = "api";

    public static final String LOGIN = "login";
    public static final String PERSONAL = "personal";
    public static final String INDEX = "Index";





    public static String getTime(){
        long time=System.currentTimeMillis()/1000;
        String  str=String.valueOf(time);
        return str;
    }

    public static String getSign() {


        String sign = SPreferencesUtils.getParam("acctoken","")
                +getTime()+APPKEY;
        return md5(sign);
    }

    public static String getToken() {


        String sign = md5(md5(APITOKEN));
        return sign;
    }

    public static String getFullUrl(String url) {


        String full = Baseurl+"/"+Doman+"/"+url;
        return full;
    }

    public static String md5(String string) {
        if (TextUtils.isEmpty(string)) {
            return "";
        }
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
            byte[] bytes = md5.digest(string.getBytes());
            String result = "";
            for (byte b : bytes) {
                String temp = Integer.toHexString(b & 0xff);
                if (temp.length() == 1) {
                    temp = "0" + temp;
                }
                result += temp;
            }
            return result;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
}