package com.sendinfo.okgodemo;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * <pre>
 *     author : ghwang
 *     e-mail : 429329513@qq.com
 *     time   : 2018/05/04
 *     desc   :
 * </pre>
 */

public abstract class AbsViewHolder<T> extends RecyclerView.ViewHolder {
    public AbsViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void bindHolder(T model);

}
