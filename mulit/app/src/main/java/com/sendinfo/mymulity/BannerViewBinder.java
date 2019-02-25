package com.sendinfo.mymulity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import me.drakeet.multitype.ItemViewBinder;

/**
 * <pre>
 *     author : ghwang
 *     e-mail : 429329513@qq.com
 *     time   : 2019/02/21
 *     desc   :
 * </pre>
 */

public class BannerViewBinder extends ItemViewBinder<HomeData, BannerViewBinder.ViewHolder> {


    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {

        View root = inflater.inflate(R.layout.header_layout,parent,false);
        return new ViewHolder(root);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull HomeData item) {


        Banner banner = holder.banner;
        List<String> imgs = new ArrayList<>();
        for (HomeData.CarouselBean carouselBean:item.getCarousel()){

            imgs.add("http://www.benke168.com"+carouselBean.getCar_img());
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

    static class ViewHolder extends RecyclerView.ViewHolder{

        private Banner banner;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.banner = itemView.findViewById(R.id.banner);
        }
    }

    private class MyLoader extends com.youth.banner.loader.ImageLoader{


        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {

            Glide.with(context).load((String) path).into(imageView);

        }
    }

}
