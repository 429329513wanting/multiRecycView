package com.sendinfo.mymulity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import me.drakeet.multitype.ItemViewBinder;

/**
 * <pre>
 *     author : ghwang
 *     e-mail : 429329513@qq.com
 *     time   : 2019/02/25
 *     desc   :
 * </pre>
 */

public class YuyueViewBinder extends ItemViewBinder<HomeData.ReservationBean,
        YuyueViewBinder.ViewHolder> {


    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {

        View view = inflater.inflate(R.layout.yuyue_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull HomeData.ReservationBean model) {

        //处理业务逻辑

        holder.textView.setText(model.getTitle());
        String tags = "";
        for (HomeData.ReservationBean.LabelBeanX lab : model.getLabel()){


            tags += lab.getName()+" ";

        }
        holder.tagTv.setText(tags);

        String infos = model.getHousetype()
                +"|"+model.getDirection()
                +"|"+model.getAcreage()
                +"月";

        holder.infoTv.setText(infos);
        holder.priceTv.setText("￥"+model.getPrice());


        HomeData.ReservationBean.RoompicBean roompicBean0 = model.getRoompic().get(0);
        HomeData.ReservationBean.RoompicBean roompicBean1 = model.getRoompic().get(1);
        HomeData.ReservationBean.RoompicBean roompicBean2 = model.getRoompic().get(2);


        Glide.with(holder.textView.getContext()).load("http://www.benke168.com"+roompicBean0.getPic()).into(holder.img0);
        Glide.with(holder.textView.getContext()).load("http://www.benke168.com"+roompicBean1.getPic()).into(holder.img1);
        Glide.with(holder.textView.getContext()).load("http://www.benke168.com"+roompicBean2.getPic()).into(holder.img2);
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        private TextView textView;
        private TextView tagTv;
        private TextView infoTv;
        private TextView priceTv;
        private ImageView img0;
        private ImageView img1;
        private ImageView img2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.title_tv);
            tagTv = itemView.findViewById(R.id.tag_tv);
            infoTv = itemView.findViewById(R.id.info_tv);
            priceTv = itemView.findViewById(R.id.price_tv);
            img0 = itemView.findViewById(R.id.img0);
            img1 = itemView.findViewById(R.id.img1);
            img2 = itemView.findViewById(R.id.img2);
        }
    }

}
