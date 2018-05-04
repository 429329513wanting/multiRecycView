package com.sendinfo.okgodemo;

import android.view.View;
import android.widget.TextView;

/**
 * <pre>
 *     author : ghwang
 *     e-mail : 429329513@qq.com
 *     time   : 2018/05/04
 *     desc   :
 * </pre>
 */

public class FooterHolder extends AbsViewHolder<String > {

    private TextView textView;
    public FooterHolder(View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.title_tv);

    }

    @Override
    public void bindHolder(String model) {

        textView.setText(model);
    }
}
