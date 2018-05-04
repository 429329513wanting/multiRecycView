package com.sendinfo.okgodemo;

import android.app.Application;
import android.content.Context;

import com.blankj.utilcode.util.Utils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheEntity;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.model.HttpHeaders;
import com.lzy.okgo.model.HttpParams;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;


/**
 * <pre>
 *     author : ghwang
 *     e-mail : 429329513@qq.com
 *     time   : 2018/04/19
 *     desc   :
 * </pre>
 */

public class MyApplication extends Application {

    public static MyApplication instance;
    private static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        context = getApplicationContext();
        configOkGo();
        Utils.init(this);
    }

    public static Context getContext(){

        return context;
    }
    private void configOkGo(){

        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        //全局的读取超时时间
        builder.readTimeout(OkGo.DEFAULT_MILLISECONDS, TimeUnit.MILLISECONDS);
//全局的写入超时时间
        builder.writeTimeout(OkGo.DEFAULT_MILLISECONDS, TimeUnit.MILLISECONDS);
//全局的连接超时时间
        builder.connectTimeout(OkGo.DEFAULT_MILLISECONDS, TimeUnit.MILLISECONDS);

        HttpHeaders headers = new HttpHeaders();
        HttpParams params = new HttpParams();


        OkGo.getInstance().init(this)
                .setOkHttpClient(builder.build())
                .setCacheMode(CacheMode.NO_CACHE)
                .setCacheTime(CacheEntity.CACHE_NEVER_EXPIRE)
                .setRetryCount(0)
                .addCommonHeaders(headers)
                .addCommonParams(params);


    }
}
