package com.qf.administrator.xiongmao.ui.fragments.homefragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.qf.administrator.xiongmao.R;
import com.qf.administrator.xiongmao.adapters.homewarcraftadapter.WarcraftAdapter;
import com.qf.administrator.xiongmao.models.homemodel.WarcraftModel;
import com.qf.administrator.xiongmao.ui.fragments.BaseFragment;
import com.qf.administrator.xiongmao.ui.gameactivitys.GameItemTwoActivity;
import com.qf.administrator.xiongmao.util.PullToRefreshRecyclerView;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.net.URL;
import java.util.List;

/**
 * 魔兽世界
 */
public class WarcraftFragment extends BaseFragment implements PullToRefreshBase.OnRefreshListener2, WarcraftAdapter.OnItemClickListener {
    public static final String TAG = WarcraftFragment.class.getSimpleName();
    private PullToRefreshRecyclerView mRecyclerView;
    private GridLayoutManager mGrid;
    private int pageno = 1;
    private String URL = "http://api.m.panda.tv/ajax_get_live_list_by_cate?cate=wow&pageno=" + pageno + "&pagenum=20&sproom=1&__version=1.2.0.1441&__plat=android&banner=1";
    private WarcraftAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        layout = inflater.inflate(R.layout.fragment_warcraft, container, false);
        return layout;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        setUpView(State.DOWN);
    }

    @Override
    public void onClickListener(int position) {
        Intent intent = new Intent(getActivity(), GameItemTwoActivity.class);
        startActivity(intent);
    }

    enum State {
        DOWN, UP
    }

    private void setUpView(final State state) {
        RequestParams requestParams = new RequestParams(URL);
        x.http().get(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.e(TAG, "onSuccess: " + result);
                Gson gson = new Gson();
                WarcraftModel warcraftModel = gson.fromJson(result, WarcraftModel.class);
                List<WarcraftModel.DataBean.ItemsBean> items = warcraftModel.getData().getItems();
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
                Log.e(TAG, "onError: ");
            }

            @Override
            public void onCancelled(CancelledException cex) {
                Log.e(TAG, "onCancelled: ");
            }

            @Override
            public void onFinished() {
                Log.e(TAG, "onFinished: ");
                mRecyclerView.onRefreshComplete();
            }
        });
    }

    private void initView() {
        mRecyclerView = ((PullToRefreshRecyclerView) layout.findViewById(R.id.warcraft_recyclerview));
        mRecyclerView.setMode(PullToRefreshBase.Mode.BOTH);
        mRecyclerView.setOnRefreshListener(this);
        RecyclerView refreshableView = mRecyclerView.getRefreshableView();
        mGrid = new GridLayoutManager(getActivity(), 2);
        refreshableView.setLayoutManager(mGrid);
        adapter = new WarcraftAdapter(getActivity(), null);
        adapter.setListener(this);
        refreshableView.setAdapter(adapter);
    }

    @Override
    public void onPullDownToRefresh(PullToRefreshBase refreshView) {
        pageno = 1;
        setUpView(State.DOWN);
    }

    @Override
    public void onPullUpToRefresh(PullToRefreshBase refreshView) {
        pageno++;
        setUpView(State.UP);
    }
}
