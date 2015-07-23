package com.zwb.photodemo.fragment;


import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.fastjson.JSON;

import com.alibaba.fastjson.JSONObject;

import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.exception.DbException;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.zwb.photodemo.R;
import com.zwb.photodemo.Utils.DbHepler;
import com.zwb.photodemo.adapter.SongAdapter;
import com.zwb.photodemo.bean.Songs;



import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class SongFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {
    private String SongUrl = "http://tingapi.ting.baidu.com/v1/restserver/ting?from=android&version=5.6.2.3&method=baidu.ting.learn.now&page_size=30";
    private Context context;
    private List<Songs> songses;
    private SongAdapter adapter;

    public SongFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_song, container, false);
    }

    @ViewInject(R.id.recycler)
    private RecyclerView recycler;
    @ViewInject(R.id.refresh)
    private SwipeRefreshLayout refresh;
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ViewUtils.inject(this, view);

        recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new SongAdapter(getActivity(),new ArrayList<Songs>());
        recycler.setAdapter(adapter);
        recycler.addItemDecoration(new RecyclerView.ItemDecoration() {
            /**
             *
             * @param outRect   外边框
             * @param view      itemView
             * @param parent    RecyclerView
             * @param state     状态
             */
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                outRect.set(3, 3, 3, 3);
            }
        });
        refresh.setOnRefreshListener(this);
    }

    @Override
    public void onRefresh() {
        HttpUtils utils = new HttpUtils(10000);

        utils.send(HttpRequest.HttpMethod.GET, SongUrl, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                Log.d("TAG",responseInfo.result);
                JSONObject object = JSON.parseObject(responseInfo.result);
               JSONObject object1 = object.getJSONObject("result");
                List<Songs> items = JSON.parseArray(object1.getString("items"), Songs.class);
               // Log.d("TAG",items.toString());
                adapter.addAll(items);

                try {
                    DbHepler.getUtils().saveOrUpdateAll(items);
                } catch (DbException e) {
                    e.printStackTrace();
                }
                refresh.setRefreshing(false);
            }

            @Override
            public void onFailure(HttpException e, String s) {
                refresh.setRefreshing(false);
            }
        });
    }
}
