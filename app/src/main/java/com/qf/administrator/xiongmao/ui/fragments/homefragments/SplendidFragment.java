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
import com.qf.administrator.xiongmao.adapters.homesplendidadapter.SplendidAdapter;
import com.qf.administrator.xiongmao.models.homemodel.HomeModel;
import com.qf.administrator.xiongmao.ui.fragments.BaseFragment;
import com.qf.administrator.xiongmao.ui.fragments.homefragments.homeactivity.HomeActivity;
import com.qf.administrator.xiongmao.util.PullToRefreshRecyclerView;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.List;


/**
 * 精彩推荐
 */
public class SplendidFragment extends BaseFragment implements SplendidAdapter.OneItemClicOne,PullToRefreshBase.OnRefreshListener2 {
    public static final String TAG=SplendidFragment.class.getSimpleName();
    private PullToRefreshRecyclerView mRecyclerView;
    private SplendidAdapter adapter1;
    private static int pageno=1;
    private static final String URL="http://api.m.panda.tv/ajax_live_lists?pageno="+pageno+"&pagenum=20&status=2&order=person_num&sproom=1&__version=1.2.0.1441&__plat=android&banner=1";
    private RecyclerView refreshableView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        layout=inflater.inflate(R.layout.fragment_splendid,container,false);
        return layout;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        setUpView(State.DOWN);
    }
    enum State{
        DOWN,UP
    }
  private void setUpView(final State state) {


        RequestParams requestParams = new RequestParams(URL);
        x.http().get(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.e(TAG, "onSuccess: "+result );
                Gson gson = new Gson();
                HomeModel homeModel = gson.fromJson(result, HomeModel.class);
                List<HomeModel.DataBean.ItemsBean> items = homeModel.getData().getItems();
                switch (state) {
                    case DOWN:
                        adapter1.setDataRes(items);
                        break;
                    case UP:
                        adapter1.addDataRes(items);
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
        mRecyclerView = ((PullToRefreshRecyclerView) layout.findViewById(R.id.splendid_recyclerview));
        mRecyclerView.setMode(PullToRefreshBase.Mode.BOTH);
        refreshableView = mRecyclerView.getRefreshableView();
        mRecyclerView.setOnRefreshListener(this);
        GridLayoutManager layout = new GridLayoutManager(getActivity(), 2);
        refreshableView.setLayoutManager(layout);
        adapter1 = new SplendidAdapter(getActivity(),null);
        adapter1.setListener(this);
        refreshableView.setAdapter(adapter1);
    }

    @Override
    public void OnitemClickListener(int position) {
        Intent intent = new Intent(getActivity(), HomeActivity.class);

        startActivity(intent);
    }

    @Override
    public void onPullDownToRefresh(PullToRefreshBase refreshView) {
        pageno=1;
        setUpView(State.DOWN);
    }

    @Override
    public void onPullUpToRefresh(PullToRefreshBase refreshView) {
        pageno++;
        setUpView(State.UP);
    }


}
