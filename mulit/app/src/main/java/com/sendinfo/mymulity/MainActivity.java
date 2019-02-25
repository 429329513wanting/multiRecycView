package com.sendinfo.mymulity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
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
        //recyclerView.setLayoutManager(new LinearLayoutManager(this));

        GridLayoutManager layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {

             if(position>0 && position<= homeData.getHouse().size()){

                    return 1;

                }else{

                    return 2;
                }
            }
        });


        adapter = new MultiTypeAdapter();
        adapter.register(HomeData.class, new BannerViewBinder());
        adapter.register(HomeData.HouseBean.class,new TimeLimitViewBinder((this)));
        adapter.register(HomeData.ReservationBean.class,new YuyueViewBinder());
        adapter.register(String.class,new FooterViewBinder());
        recyclerView.setAdapter(adapter);

        reloadData();

    }

    private void reloadData(){


        ArrayList<Object> items = new ArrayList<>();
        items.add(homeData);
        adapter.setItems(items);
        for (HomeData.HouseBean bean : homeData.getHouse()){

            items.add(bean);
        }
        items.add("限时房源");

        for (HomeData.ReservationBean bean : homeData.getReservation()){

            items.add(bean);
        }
        items.add("查看更多房源");

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
