package com.sendinfo.okgodemo.HttpUtil;

import android.os.Handler;

import com.lzy.okgo.callback.AbsCallback;
import com.lzy.okgo.callback.Callback;
import com.lzy.okgo.model.Progress;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;
import com.socks.library.KLog;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * <pre>
 *     author : ghwang
 *     e-mail : 429329513@qq.com
 *     time   : 2018/04/21
 *     desc   :
 * </pre>
 */

public class HttpRequest {


    static BaseResponse baseResponse = new BaseResponse();

    public static void startAction(final HttpDto http,
                                   final RequestCallBack<BaseResponse>callBack){


        http.print();
        http.getRequest().execute(new BaseCallBack(callBack,http){

            @Override
            public void onSuccess(Response<String> response) {

                try {
                    JSONObject jsonObject = new JSONObject(response.body().toString());
                    KLog.json(jsonObject.toString());
                    baseResponse = JsonUtil.getObject(jsonObject.toString(),BaseResponse.class);
                    callBack.requestSuccess(baseResponse,http.getFullUrl());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
