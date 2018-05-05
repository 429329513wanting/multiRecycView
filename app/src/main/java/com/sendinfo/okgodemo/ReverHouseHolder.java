package com.sendinfo.okgodemo;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sendinfo.okgodemo.HttpUtil.Constant;

import org.greenrobot.eventbus.EventBus;

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
    private TextView tagTv;
    private TextView infoTv;
    private TextView priceTv;
    private ImageView img0;
    private ImageView img1;
    private ImageView img2;
    private RelativeLayout maskLineLayout;


    public ReverHouseHolder(View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.title_tv);
        tagTv = itemView.findViewById(R.id.tag_tv);
        infoTv = itemView.findViewById(R.id.info_tv);
        priceTv = itemView.findViewById(R.id.price_tv);
        img0 = itemView.findViewById(R.id.img0);
        img1 = itemView.findViewById(R.id.img1);
        img2 = itemView.findViewById(R.id.img2);
        maskLineLayout = itemView.findViewById(R.id.mask_layout);
        maskLineLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EventBus.getDefault().post(new MessageEvent(v.getTag()));
            }
        });




    }

    @Override
    public void bindHolder(HomeData.ReservationBean model) {



    }
    public void bindHolder(HomeData.ReservationBean model, Context context){

        textView.setText(model.getTitle());
        String tags = "";
        for (HomeData.ReservationBean.LabelBeanX lab : model.getLabel()){


            tags += lab.getName()+" ";

        }
        tagTv.setText(tags);

        String infos = model.getHousetype()
                +"|"+model.getDirection()
                +"|"+model.getAcreage()
                +"m²";

        infoTv.setText(infos);
        priceTv.setText("￥"+model.getPrice());

        maskLineLayout.setTag(model);

        HomeData.ReservationBean.RoompicBean roompicBean0 = model.getRoompic().get(0);
        HomeData.ReservationBean.RoompicBean roompicBean1 = model.getRoompic().get(1);
        HomeData.ReservationBean.RoompicBean roompicBean2 = model.getRoompic().get(2);


        Glide.with(context).load(Constant.Baseurl+roompicBean0.getPic()).into(img0);
        Glide.with(context).load(Constant.Baseurl+roompicBean1.getPic()).into(img1);
        Glide.with(context).load(Constant.Baseurl+roompicBean2.getPic()).into(img2);

    }
}
