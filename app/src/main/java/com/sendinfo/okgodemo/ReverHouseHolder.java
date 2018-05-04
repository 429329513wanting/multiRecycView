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

public class ReverHouseHolder extends AbsViewHolder<HomeData.ReservationBean> {

    private TextView textView;

    public ReverHouseHolder(View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.title_tv);

    }

    @Override
    public void bindHolder(HomeData.ReservationBean model) {

        textView.setText(model.getTitle());
    }
}
