package com.sendinfo.okgodemo.HttpUtil;

import android.os.Handler;
import android.os.Message;

import com.lzy.okgo.callback.AbsCallback;
import com.lzy.okgo.model.Response;
import com.socks.library.KLog;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * <pre>
 *     author : ghwang
 *     e-mail : 429329513@qq.com
 *     time   : 2018/04/21
 *     desc   :
 * </pre>
 */

public class BaseCallBack extends AbsCallback<String> {

    private RequestCallBack<BaseResponse> requestCallback;
    private HttpDto httpDto;
    private Handler handler;

    public BaseCallBack(RequestCallBack<BaseResponse> callback, HttpDto http)
    {
        this.requestCallback = callback;
        this.httpDto = http;
    }

    @Override
    public void onSuccess(Response<String> response) {

        KLog.v("OkGo", "onSuccess");

    }

    @Override
    public String convertResponse(okhttp3.Response response) throws Throwable {

        KLog.v("OkGo", "convertResponse");

        return response.body().string();
    }

    /** 缓存成功的回调,UI线程 */
    @Override public void onCacheSuccess(com.lzy.okgo.model.Response<String> response)
    {
        KLog.v("OkGo", "onCacheSuccess");
        onSuccess(response);
        handler.removeMessages(0);
        super.onCacheSuccess(response);
    }

    /** 请求失败，响应错误，数据解析错误等，都会回调该方法， UI线程 */
    @Override public void onError(com.lzy.okgo.model.Response<String> response)
    {
        KLog.v("OkGo", "onError===="+response.body());

    }

    /** 请求网络结束后，UI线程 */
    @Override public void onFinish()
    {
        KLog.v("OkGo", "onFinish");
        super.onFinish();
    }
}
