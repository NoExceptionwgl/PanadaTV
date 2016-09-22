package com.qf.administrator.xiongmao.ui.fragments.gamefragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.qf.administrator.xiongmao.R;
import com.qf.administrator.xiongmao.adapters.gameadapters.WeekAdapter;
import com.qf.administrator.xiongmao.events.SendHostId;
import com.qf.administrator.xiongmao.models.WeekModel;
import com.qf.administrator.xiongmao.ui.fragments.BaseFragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.List;

/**
 * Created by a on 2016/9/21.
 */
public class ToplistWeekFragment extends BaseFragment{

    public static final String TAG = ToplistWeekFragment.class.getSimpleName();
    private RecyclerView mRecyclerView;
    private WeekAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.fragment_toplist_week,container,false);
        return layout;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
    }

    private void initView() {
        mRecyclerView = ((RecyclerView) layout.findViewById(R.id.stu_toplist_fragment_week_recycler));
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(manager);
        adapter = new WeekAdapter(null,getActivity());
        mRecyclerView.setAdapter(adapter);
    }


    @Subscribe
    public void onEvent(SendHostId event){
        String hostid = event.getHostid();
        Log.e(TAG, "onEvent: "+hostid );
        String URL = "http://rank.service.panda.tv/weekly?anchor_id="+hostid+"&__version=1.2.0.1441&__plat=android";
        RequestParams requestParams = new RequestParams(URL);
        x.http().get(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.e(TAG, "onSuccess: "+result );
                Gson gson = new Gson();
                List<WeekModel> data = gson.fromJson(result, new TypeToken<List<WeekModel>>() {
                }.getType());
                if (data!=null) {
                    adapter.updataRes(data);
                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e(TAG, "onError: " );
            }

            @Override
            public void onCancelled(CancelledException cex) {
                Log.e(TAG, "onCancelled: " );
            }

            @Override
            public void onFinished() {
                Log.e(TAG, "onFinished: " );
            }
        });
    }

    //EventBus注册和取消
    @Override
    public void onResume() {
        super.onResume();
        //注册EventBus
        EventBus.getDefault().register(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        //取消注册
        EventBus.getDefault().unregister(this);
    }


}
