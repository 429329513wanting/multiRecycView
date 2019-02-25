package com.sendinfo.mymulity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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

public class FooterViewBinder extends ItemViewBinder<String, FooterViewBinder.FooterViewHolder> {


    @NonNull
    @Override
    protected FooterViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {

        View view = inflater.inflate(R.layout.session_footer,parent,false);
        return new FooterViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull FooterViewHolder holder, @NonNull String item) {

        holder.textView.setText(item);

    }

    static class FooterViewHolder extends RecyclerView.ViewHolder{

        private TextView textView;

        public FooterViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.title_tv);

        }
    }
}
