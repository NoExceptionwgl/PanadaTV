package com.qf.administrator.xiongmao.ui.fragments.homefragments;

import android.content.Intent;
import android.graphics.Color;
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
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.qf.administrator.xiongmao.R;
import com.qf.administrator.xiongmao.adapters.homeheroadpter.HeroAdapter;
import com.qf.administrator.xiongmao.models.homemodel.HeroModel;
import com.qf.administrator.xiongmao.ui.fragments.BaseFragment;
import com.qf.administrator.xiongmao.ui.gameactivitys.GameItemTwoActivity;
import com.qf.administrator.xiongmao.util.PullToRefreshRecyclerView;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.List;

/**
 * 英雄联盟
 */
public class HeroFragment extends BaseFragment implements PullToRefreshBase.OnRefreshListener2, SwipeRefreshLayout.OnRefreshListener, HeroAdapter.OnClickListener {
    public static final String TAG=HeroFragment.class.getSimpleName();
    private int pageno=1;
    private  final String URL ="http://api.m.panda.tv/ajax_get_live_list_by_cate?cate=lol&pageno="+pageno+"&pagenum=20&sproom=1&__version=1.2.0.1441&__plat=android&banner=1";
    private PullToRefreshRecyclerView mRecyclerView;
    private GridLayoutManager gridLayout;
    private HeroAdapter adapter;
    private SwipeRefreshLayout mSwip;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layout=inflater.inflate(R.layout.fragment_hero,container,false);
        return layout;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        setUpView(State.DOWN);
    }

    @Override
    public void onPullDownToRefresh(PullToRefreshBase refreshView) {
//        pageno=1;
//        setUpView(State.DOWN);
    }

    @Override
    public void onPullUpToRefresh(PullToRefreshBase refreshView) {
        pageno++;

        setUpView(State.UP);
    }

    @Override
    public void onRefresh() {
        pageno=1;
        setUpView(State.DOWN);
        mSwip.setRefreshing(false);
    }

    @Override
    public void onItemClickListener(int position) {
        Intent intent = new Intent(getActivity(), GameItemTwoActivity.class);
        startActivity(intent);
    }

    enum State{
        DOWN,UP
    }
    private void setUpView(final State state) {
        RequestParams requestParams = new RequestParams(URL);
        x.http().get(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.e(TAG, "onSuccess: " +result);
                Gson gson = new Gson();
                HeroModel heroModel = gson.fromJson(result, HeroModel.class);
                List<HeroModel.DataBean.ItemsBean> items = heroModel.getData().getItems();
                switch (state) {
                    case DOWN:
                        adapter.setDataRes(items);
                        break;
                    case UP:
                        adapter.addDataRes(items);
                        break;
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
                mRecyclerView.onRefreshComplete();
            }
        });
    }

    private void initView() {
        mSwip = ((SwipeRefreshLayout) layout.findViewById(R.id.hero_swipe));
        //设置颜色
        mSwip.setColorSchemeColors(R.color.colorBlue);
        //设置下拉的距离
        mSwip.setProgressViewOffset(true,0,200);
        //设置刷新监听
        mSwip.setOnRefreshListener(this);
        mRecyclerView = ((PullToRefreshRecyclerView) layout.findViewById(R.id.hero_recyclerview));
        RecyclerView refreshableView = mRecyclerView.getRefreshableView();
        mRecyclerView.setMode(PullToRefreshBase.Mode.BOTH);
        mRecyclerView.setOnRefreshListener(this);
        gridLayout = new GridLayoutManager(getActivity(),2);
        refreshableView.setLayoutManager(gridLayout);
        adapter = new HeroAdapter(getActivity(),null);
        adapter.setListener(this);
        refreshableView.setAdapter(adapter);
    }
}
