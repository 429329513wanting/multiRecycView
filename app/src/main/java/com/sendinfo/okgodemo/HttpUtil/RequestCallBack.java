package com.sendinfo.okgodemo.HttpUtil;

import org.json.JSONException;

import io.reactivex.Observable;

/**
 * <pre>
 *     author : ghwang
 *     e-mail : 429329513@qq.com
 *     time   : 2018/04/21
 *     desc   :
 * </pre>
 */

public interface RequestCallBack<T> {

    void requestError(String msg,String url,boolean finish);

    void requestSuccess(T response,String url) throws JSONException;


}
