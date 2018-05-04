package com.sendinfo.okgodemo.HttpUtil;

/**
 * <pre>
 *     author : ghwang
 *     e-mail : 429329513@qq.com
 *     time   : 2018/04/21
 *     desc   :
 * </pre>
 */

public class BaseRequest {

    private String asscee_token;
    private String timestamp;
    private String sign;
    private String method;


    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }



    public String getAsscee_token() {
        return asscee_token;
    }

    public void setAsscee_token(String asscee_token) {
        this.asscee_token = asscee_token;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }



}
