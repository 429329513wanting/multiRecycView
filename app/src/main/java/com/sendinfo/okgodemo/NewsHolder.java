package com.sendinfo.okgodemo;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.greenrobot.eventbus.EventBus;

/**
 * <pre>
 *     author : ghwang
 *     e-mail : 429329513@qq.com
 *     time   : 2018/05/04
 *     desc   :
 * </pre>
 */

public class NewsHolder extends AbsViewHolder<HomeData.NewsBean> {

    private TextView textView;
    private TextView introTv;
    public ImageView photo;
    private RelativeLayout maskLineLayout;



    public NewsHolder(View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.title_tv);
        introTv = itemView.findViewById(R.id.intro_tv);
        photo = itemView.findViewById(R.id.photo);

        maskLineLayout = itemView.findViewById(R.id.mask_linear);o
        maskLineLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EventBus.getDefault().post(new MessageEvent(v.getTag()));
            }
        });


    }

    @Override
    public void bindHolder(HomeData.NewsBean model) {

        textView.setText(model.getTitle());
        introTv.setText(model.getSummary());
        maskLineLayout.setTag( model);
    }
}
