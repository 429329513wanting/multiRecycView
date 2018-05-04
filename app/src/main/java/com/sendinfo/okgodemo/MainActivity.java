package com.sendinfo.okgodemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.sendinfo.okgodemo.HttpUtil.BaseResponse;
import com.sendinfo.okgodemo.HttpUtil.Constant;
import com.sendinfo.okgodemo.HttpUtil.HttpDto;
import com.sendinfo.okgodemo.HttpUtil.HttpRequest;
import com.sendinfo.okgodemo.HttpUtil.JsonUtil;
import com.sendinfo.okgodemo.HttpUtil.ParamsModel;
import com.sendinfo.okgodemo.HttpUtil.RequestCallBack;
import com.sendinfo.okgodemo.Util.SPreferencesUtils;
import com.socks.library.KLog;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private HomeAdapter homeAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycview);
        homeAdapter = new HomeAdapter(this);

        recyclerView.setAdapter(homeAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        indexData();



    }


    private void indexData(){

        ParamsModel model = new ParamsModel();
        model.setAreaid("178");
        HttpDto httpDto = new HttpDto("index",
                Constant.INDEX,model);
        httpDto.setType(HttpDto.GET);

        HttpRequest.startAction(httpDto, new RequestCallBack<BaseResponse>() {
            @Override
            public void requestError(String msg, String url, boolean finish) {

            }

            @Override
            public void requestSuccess(BaseResponse response, String url) throws JSONException {

                HomeData homeData = JsonUtil.getObjectFromObject(response.getData(),HomeData.class);
                KLog.d(homeData);

                //组装数据
                homeAdapter.addHeaderByType(HomeAdapter.Type_Session_Header,"限时特惠房源");
                homeAdapter.addListByType(HomeAdapter.Type_TimeLimit,homeData.getHouse());
                homeAdapter.addFooterByType("查看更多房源");

                homeAdapter.addHeaderByType(HomeAdapter.Type_Session_HeaderTwo,"火爆预约房源");
                homeAdapter.addListByType(HomeAdapter.Type_YUYUE,homeData.getReservation());
                homeAdapter.addFooterByType("查看更多房源");


                homeAdapter.addHeaderByType(HomeAdapter.Type_Session_HeaderThree,"社区生活");
                homeAdapter.addListByType(HomeAdapter.Type_NEWS,homeData.getNews());

                homeAdapter.setHomeData(homeData);
                homeAdapter.notifyDataSetChanged();
            }
        });
    }
}
