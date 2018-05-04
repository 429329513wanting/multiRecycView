package com.sendinfo.okgodemo.HttpUtil;


import android.text.TextUtils;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.request.base.BodyRequest;
import com.lzy.okgo.request.base.Request;
import com.sendinfo.okgodemo.Util.SPreferencesUtils;
import com.socks.library.KLog;

import java.io.Serializable;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.FormBody;
import okhttp3.RequestBody;

/**
 * <pre>
 *     author : ghwang
 *     e-mail : 429329513@qq.com
 *     time   : 2018/04/21
 *     desc   :
 * </pre>
 */

public class HttpDto implements Serializable {

    public final static int GET = 0x100000;
    public final static int POST = 0x100001;



    private int type =POST;


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    private String url;

    public String getFullUrl() {
        return fullUrl;
    }

    public void setFullUrl(String fullUrl) {
        this.fullUrl = fullUrl;
    }

    private String fullUrl;


    private CacheMode cacheMode = CacheMode.DEFAULT;

    private Map<String,String> params;
    private Map<String,String> heads;


    private boolean auth;

    private String method;
    private ParamsModel model;
    private RequestBody requestBody;
    private Object tag;

    public HttpDto(String url,String method,ParamsModel model) {

        this(url,method,model,false);
    }
    public HttpDto(String url,String method,ParamsModel model,boolean auth) {


        this.url = url;
        this.method = method;
        this.model = model;
        this.auth = auth;

        BaseRequest baseRequest =  new BaseRequest();
        baseRequest.setMethod(method);

        heads = new HashMap<>();
        heads.put("token",Constant.getToken());

        params = new HashMap<>();

        //是否授权
        if (this.auth){

            baseRequest.setTimestamp(Constant.getTime());
            baseRequest.setSign(Constant.getSign());
            baseRequest.setAsscee_token((String) SPreferencesUtils.getParam("acctoken",""));

            params.put("asscee_token",baseRequest.getAsscee_token());
            params.put("timestamp",baseRequest.getTimestamp());
            params.put("sign",baseRequest.getSign());
        }
    }

    public Request getRequest(){

        Request request = null;
        if (type == GET){

            request = OkGo.get(Constant.getFullUrl(url+"/"+method));

            Map<String,String> map = JsonUtil.getMapForObj(model);

            for (Map.Entry<String, String> entry : map.entrySet()){

                if (entry.getValue().length()!=0){

                    request.params(entry.getKey(),entry.getValue());
                }
            }


        }else if(type == POST){

            request = OkGo.post(Constant.getFullUrl(url+"/"+method));

            FormBody.Builder builder = new FormBody.Builder();
            Map<String,String> map = JsonUtil.getMapForObj(model);

            for (Map.Entry<String, String> entry : map.entrySet()){

                if (entry.getValue().length()!=0){

                    builder.add(entry.getKey(),entry.getValue());
                }
            }

            requestBody = builder.build();
            if (this.auth){

                ((BodyRequest)request).isSpliceUrl(true);

            }
            ((BodyRequest)request).upRequestBody(this.requestBody);
        }

        if (heads != null){

            for (Map.Entry<String, String> entry : heads.entrySet())
            {
                request.headers(entry.getKey(), entry.getValue());
            }
        }
        if (params != null){

            request.params(params);
        }

        request.tag(this);
        request.cacheMode(cacheMode);
        this.fullUrl = Constant.getFullUrl(url+"/"+method);
        return request;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public ParamsModel getModel() {
        return model;
    }

    public void setModel(ParamsModel model) {
        this.model = model;
    }


    public Object getTag() {
        return tag;
    }

    public void setTag(Object tag) {
        this.tag = tag;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    public Map<String, String> getHeads() {
        return heads;
    }

    public void setHeads(Map<String, String> heads) {
        this.heads = heads;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
    public boolean isAuth() {
        return auth;
    }

    public void setAuth(boolean auth) {
        this.auth = auth;
    }


    public void print()
    {
        KLog.i("╔══════════════════════════════════════════════════");
        KLog.i("║    请求地址:" + Constant.Baseurl+"/"+url+"/"+method);
        Map<String,String>params = JsonUtil.getMapForObj(this.model);
        if (params != null)
        {
            KLog.i("║    请求参数为:");
            for (Map.Entry<String, String> entry : params.entrySet())
            {
                if (entry.getKey().equals("data"))
                {
                    KLog.i("║    " + entry.getKey() + " : ");
                    KLog.json(entry.getValue());
                }
                else
                {
                    KLog.i("║    " + entry.getKey() + " = " + entry.getValue());
                }
            }
        }
        else
        {
            KLog.i("║    请求参数为空");
        }

        KLog.i("║    ");

        if (heads != null)
        {
            KLog.i("║    请求头为:");
            for (Map.Entry<String, String> entry : heads.entrySet())
            {
                KLog.i("║    " + entry.getKey() + " = " + entry.getValue());
            }
        }
        else
        {
            KLog.i("║    请求头为空");
        }

        KLog.i("╚══════════════════════════════════════════════════");
    }

}
