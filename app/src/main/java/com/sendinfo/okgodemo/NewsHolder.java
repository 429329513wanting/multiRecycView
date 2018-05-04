package com.sendinfo.okgodemo;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

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


    public NewsHolder(View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.title_tv);
        introTv = itemView.findViewById(R.id.intro_tv);
        photo = itemView.findViewById(R.id.photo);


    }

    @Override
    public void bindHolder(HomeData.NewsBean model) {

        textView.setText(model.getTitle());
        introTv.setText(model.getSummary());
    }
}
