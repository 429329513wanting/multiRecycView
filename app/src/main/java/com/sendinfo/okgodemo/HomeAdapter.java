package com.sendinfo.okgodemo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.sendinfo.okgodemo.HttpUtil.Constant;
import com.socks.library.KLog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <pre>
 *     author : ghwang
 *     e-mail : 429329513@qq.com
 *     time   : 2018/05/04
 *     desc   :
 * </pre>
 */

public class HomeAdapter extends RecyclerView.Adapter {


    public static final int Type_Header = 1;
    public static final int Type_Session_Header = 3;
    public static final int Type_Session_HeaderTwo = 33;
    public static final int Type_Session_HeaderThree = 34;

    public static final int Type_Session_Footer = 4;
    public static final int Type_TimeLimit = 5;
    public static final int Type_YUYUE = 6;
    public static final int Type_NEWS = 7;


    private List<String> headers = new ArrayList<>();
    private List<String> footers = new ArrayList<>();
    private List<HomeData.HouseBean> houseBeans;
    private List<HomeData.ReservationBean> reservationBeans;
    private List<HomeData.NewsBean> newsBeans;
    private Context context;

    public HomeData getHomeData() {
        return homeData;
    }

    public void setHomeData(HomeData homeData) {
        this.homeData = homeData;
    }

    private HomeData homeData;

    int HeaderOffset = 0;
    int FooterOffset = 0;
    int LimitOffset = 0;
    int YuYueOffset = 0;
    int NewsOffset = 0;

    private LayoutInflater mLayoutInflater;
    private List<Integer> types = new ArrayList<>();

    public HomeAdapter(Context context){

        mLayoutInflater = LayoutInflater.from(context);
        types.add(Type_Header);
        this.context = context;
    }


    public void addListByType(int type,List list){

        for (int i=0;i<list.size();i++){

            types.add(type);
        }

        if (type == Type_TimeLimit){

            houseBeans = list;

        }else if(type == Type_YUYUE){

            reservationBeans = list;

        }else if(type == Type_NEWS){

            newsBeans = list;
        }

    }
    public void addHeaderByType(int type,String title){

        types.add(type);
        headers.add(title);

    }

    public void addFooterByType(String title){

        types.add(Type_Session_Footer);
        footers.add(title);

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (viewType == Type_Session_Header){

            return  new HeaderHolder(mLayoutInflater.inflate(R.layout.session_header,parent,false));

        }else if (viewType == Type_Session_Footer){

            return  new FooterHolder(mLayoutInflater.inflate(R.layout.session_footer,parent,false));

        }else if (viewType == Type_TimeLimit){

            return  new TimeLimitHolder(mLayoutInflater.inflate(R.layout.time_limit_layout,parent,false));

        }else if (viewType == Type_YUYUE){

            return  new ReverHouseHolder(mLayoutInflater.inflate(R.layout.yuyue_layout,parent,false));

        }else if (viewType == Type_NEWS){

            NewsHolder newsHolder =  new NewsHolder(mLayoutInflater.inflate(R.layout.news_layout,parent,false));
            return newsHolder;

        }else if(viewType == Type_Header){

            return  new HomeHeaderHolder(mLayoutInflater.inflate(R.layout.header_layout,parent,false));

        }else if (viewType == Type_Session_HeaderTwo){

            return  new HeaderHolder(mLayoutInflater.inflate(R.layout.session_header,parent,false));

        }else if (viewType == Type_Session_HeaderThree){

            return  new HeaderHolder(mLayoutInflater.inflate(R.layout.session_header,parent,false));

        }

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        int viewType = getItemViewType(position);

        if (viewType == Type_Session_Header){


            ((HeaderHolder)holder).bindHolder(headers.get(0));


        }else if (viewType == Type_Session_HeaderTwo){


            ((HeaderHolder)holder).bindHolder(headers.get(1));


        }else if (viewType == Type_Session_HeaderThree){


            ((HeaderHolder)holder).bindHolder(headers.get(2));


        }else if (viewType == Type_Session_Footer){

            ((FooterHolder)holder).bindHolder(footers.get(FooterOffset));
            FooterOffset++;
            if (FooterOffset >= footers.size()){

                FooterOffset = 0;
            }

        }else if (viewType == Type_TimeLimit){

            ((TimeLimitHolder)holder).bindHolder(houseBeans.get(LimitOffset),this.context);

            LimitOffset++;
            if (LimitOffset >= houseBeans.size()){

                LimitOffset = 0;
            }


        }else if (viewType == Type_YUYUE){

            ((ReverHouseHolder)holder).bindHolder(reservationBeans.get(YuYueOffset),this.context);
            YuYueOffset++;
            if (YuYueOffset >= reservationBeans.size()){

                YuYueOffset = 0;
            }


        }else if (viewType == Type_NEWS){
            HomeData.NewsBean newsBean = newsBeans.get(NewsOffset);
            ((NewsHolder)holder).bindHolder(newsBean);
            Glide.with(this.context)
                    .load(Constant.Baseurl+newsBean.getNew_img())
                    .into(((NewsHolder)holder).photo);

            NewsOffset++;
            if (NewsOffset >= newsBeans.size()){

                NewsOffset = 0;
            }

        }else if(viewType == Type_Header){


            if (this.homeData != null){

                ((HomeHeaderHolder)holder).bindHolder(this.homeData.getCarousel());

            }

        }
    }

    @Override
    public int getItemViewType(int position) {

        return types.get(position);
    }

    @Override
    public int getItemCount() {
        return types.size();
    }
}
