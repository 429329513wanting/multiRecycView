package com.sendinfo.mymulity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import me.drakeet.multitype.ClassLinker;
import me.drakeet.multitype.ItemViewBinder;
import me.drakeet.multitype.MultiTypeAdapter;

import android.os.Bundle;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MultiTypeAdapter adapter;
    private HomeData homeData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        String str = getDataFromRaw();
        try {

            JSONObject jsonObject = new JSONObject(str);
            homeData = JsonUtil.getObject(jsonObject.toString(),HomeData.class);


        }catch (JSONException e){

            e.printStackTrace();
        }

        recyclerView = findViewById(R.id.recycview);

        GridLayoutManager layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {

             if(position>1 && position<= homeData.getHouse().size()+1){

                    return 1;//占1列

                }else{

                    return 2;//占2列
                }
            }
        });

        adapter = new MultiTypeAdapter();
        adapter.register(HomeData.class, new BannerViewBinder());
        adapter.register(HomeData.HouseBean.class,new TimeLimitViewBinder((this)));
        adapter.register(HomeData.ReservationBean.class,new YuyueViewBinder());

        //一个模型对应多个Item
        adapter.register(TitleBean.class).to(
                new HeaderViewBinder(),
                new FooterViewBinder()
        ).withClassLinker(new ClassLinker<TitleBean>() {
            @NonNull
            @Override
            public Class<? extends ItemViewBinder<TitleBean, ?>> index(int position, @NonNull TitleBean titleBean) {

                if (titleBean.type.equals("header")){

                    return HeaderViewBinder.class;

                }else {

                    return FooterViewBinder.class;
                }
            }
        });

        recyclerView.setAdapter(adapter);

        reloadData();
    }

    private void reloadData(){


        ArrayList<Object> items = new ArrayList<>();
        items.add(homeData);
        adapter.setItems(items);


        TitleBean bean0 = new TitleBean();
        bean0.title = "限时房源";
        bean0.type = "header";
        items.add(bean0);

        for (HomeData.HouseBean bean : homeData.getHouse()){

            items.add(bean);
        }
        TitleBean bean111 = new TitleBean();
        bean111.title = "查看更多房源";
        bean111.type = "footer";
        items.add(bean111);

        TitleBean bean1 = new TitleBean();
        bean1.title = "火爆预约房源";
        bean1.type = "header";
        items.add(bean1);

        for (HomeData.ReservationBean bean : homeData.getReservation()){

            items.add(bean);
        }
        TitleBean bean11 = new TitleBean();
        bean11.title = "查看更多房源";
        bean11.type = "footer";
        items.add(bean11);
        adapter.notifyDataSetChanged();
    }


    private String getDataFromRaw(){

        InputStream inputStream = getResources().openRawResource(R.raw.data);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder sb = new StringBuilder();

        String line = null;

        try {

            while ((line = reader.readLine()) != null) {

                sb.append(line);

            }

        }catch (IOException e){

            e.printStackTrace();

        }finally {

            try {

                inputStream.close();

            }catch (IOException e){

                e.printStackTrace();
            }

        }


        return sb.toString();
    }
}
