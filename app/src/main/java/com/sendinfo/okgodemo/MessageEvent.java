package com.sendinfo.okgodemo;

/**
 * <pre>
 *     author : ghwang
 *     e-mail : 429329513@qq.com
 *     time   : 2018/05/05
 *     desc   :
 * </pre>
 */

public class MessageEvent {


    public MessageEvent(Object data){

        this.data = data;

    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    private Object data;
}
