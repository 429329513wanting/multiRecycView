package com.sendinfo.okgodemo;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sendinfo.okgodemo.HttpUtil.Constant;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *     author : ghwang
 *     e-mail : 429329513@qq.com
 *     time   : 2018/05/04
 *     desc   :
 * </pre>
 */

public class HomeHeaderHolder extends AbsViewHolder<List<HomeData.CarouselBean>> {

    private Banner banner;
    public HomeHeaderHolder(View itemView) {
        super(itemView);
        banner = itemView.findViewById(R.id.banner);

    }

    @Override
    public void bindHolder(List<HomeData.CarouselBean> carouselBeans) {

        List<String>imgs = new ArrayList<>();
        for (HomeData.CarouselBean carouselBean:carouselBeans){

            imgs.add(Constant.Baseurl+carouselBean.getCar_img());
        }

        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        banner.setBannerAnimation(Transformer.Default);
        banner.setDelayTime(3000);
        banner.setIndicatorGravity(BannerConfig.CENTER);
        banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {

            }
        });
        banner.setImageLoader(new MyLoader());
        banner.setImages(imgs);
        banner.isAutoPlay(true);
        banner.start();
    }

    private class MyLoader extends com.youth.banner.loader.ImageLoader{


        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {

            Glide.with(context).load((String) path).into(imageView);

        }
    }
}
