package com.qf.administrator.xiongmao.ui.fragments.amusefragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.qf.administrator.xiongmao.R;
import com.qf.administrator.xiongmao.adapters.amuseadapters.PanadaAdapter;
import com.qf.administrator.xiongmao.constants.HttpUrl;
import com.qf.administrator.xiongmao.models.amusemodels.PanadaShowModel;
import com.qf.administrator.xiongmao.ui.fragments.BaseFragment;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Administrator on 2016/9/20.
 */
public class OutDoorFragment extends BaseFragment {

    private static final String TAG = OutDoorFragment.class.getSimpleName();
    @InjectView(R.id.out_door_recycler_view)
    RecyclerView mRecyclerView;
    @InjectView(R.id.out_door_swipe)
    SwipeRefreshLayout mSwipe;
    private PanadaAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.out_door_fragment, container, false);
        ButterKnife.inject(this, layout);
        return layout;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        initData();

    }

    private void initView() {
        //RecyclerView设置管理器，绑定适配器
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        mRecyclerView.setLayoutManager(gridLayoutManager);
        adapter = new PanadaAdapter(getActivity(),null);
        mRecyclerView.setAdapter(adapter);
    }

    private void initData() {
        RequestParams params = new RequestParams(HttpUrl.OUTDOOR_URL);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.e(TAG, "onSuccess: " + result);
                Gson gson = new Gson();
                PanadaShowModel panadaShowModel = gson.fromJson(result, PanadaShowModel.class);
                List<PanadaShowModel.DataBean.ItemsBean> data = panadaShowModel.getData().getItems();
                adapter.addRes(data);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e(TAG, "onError: " + ex.getLocalizedMessage() + ex.getMessage());
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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}
