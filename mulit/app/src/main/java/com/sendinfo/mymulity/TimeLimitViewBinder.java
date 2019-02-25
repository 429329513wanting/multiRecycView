package com.sendinfo.mymulity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.bumptech.glide.Glide;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import me.drakeet.multitype.ItemViewBinder;

/**
 * <pre>
 *     author : ghwang
 *     e-mail : 429329513@qq.com
 *     time   : 2019/02/22
 *     desc   :
 * </pre>
 */

public class TimeLimitViewBinder extends ItemViewBinder<HomeData.HouseBean, TimeLimitViewBinder.LimitViewHolder> {

    private Context context;
    public TimeLimitViewBinder(Context context){

        this.context = context;
    }

    @NonNull
    @Override
    protected LimitViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {

        View view = inflater.inflate(R.layout.time_limit_layout,parent,false);
        return new LimitViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull LimitViewHolder holder, @NonNull HomeData.HouseBean item) {

        //赋值

        holder.textView.setText(item.getTitle());
        holder.priceTv.setText("￥"+item.getPrice()+"/m²");
        Context context = holder.priceTv.getContext();
        Glide.with(context).load("http://www.benke168.com"+item.getRoombg()).into(holder.photo);

        String tags = "";
        for (HomeData.HouseBean.LabelBean lab : item.getLabel()){


            tags += lab.getName()+" ";

        }
        holder.tagTv.setText(tags);
        holder.typeTv.setText(item.getTypename());

        int position = getPosition(holder);


    }

    static class LimitViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;

        private TextView tagTv;
        private TextView typeTv;
        private TextView priceTv;
        private ImageView photo;

        public LimitViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.title_tv);

            tagTv = itemView.findViewById(R.id.tag_tv);
            typeTv = itemView.findViewById(R.id.type_tv);
            priceTv = itemView.findViewById(R.id.price_tv);
            photo = itemView.findViewById(R.id.photo);
        }
    }


}
