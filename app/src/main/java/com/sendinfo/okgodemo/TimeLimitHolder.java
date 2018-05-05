package com.sendinfo.okgodemo;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
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

public class TimeLimitHolder extends AbsViewHolder<HomeData.HouseBean> {

    private TextView textView;

    private TextView tagTv;
    private TextView typeTv;
    private TextView priceTv;
    private ImageView photo;
    private LinearLayout maskLineLayout;

    public TimeLimitHolder(View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.title_tv);

        tagTv = itemView.findViewById(R.id.tag_tv);
        typeTv = itemView.findViewById(R.id.type_tv);
        priceTv = itemView.findViewById(R.id.price_tv);
        photo = itemView.findViewById(R.id.photo);
        maskLineLayout = itemView.findViewById(R.id.mask_linear);

        maskLineLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                HomeData.HouseBean bean = (HomeData.HouseBean) v.getTag();
                EventBus.getDefault().post(new MessageEvent(bean));
            }
        });

    }

    @Override
    public void bindHolder(HomeData.HouseBean model) {

    }

    public void bindHolder(HomeData.HouseBean model, Context context) {

        textView.setText(model.getTitle());
        priceTv.setText("￥"+model.getPrice()+"/m²");
        Glide.with(context).load(Constant.Baseurl+model.getRoombg()).into(photo);

        String tags = "";
        for (HomeData.HouseBean.LabelBean lab : model.getLabel()){


            tags += lab.getName()+" ";

        }
        tagTv.setText(tags);
        typeTv.setText(model.getTypename());

        maskLineLayout.setTag(model);
    }
}
