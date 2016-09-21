package com.qf.administrator.xiongmao.ui.fragments;

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
import com.qf.administrator.xiongmao.R;
import com.qf.administrator.xiongmao.adapters.gameadapters.GameAdapter;
import com.qf.administrator.xiongmao.constants.HttpUrl;
import com.qf.administrator.xiongmao.models.GameModel;
import com.qf.administrator.xiongmao.ui.gameactivitys.GameItemActivity;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * 游戏
 */
public class GameFragment extends BaseFragment implements GameAdapter.OnItemClick {

    private static final String TAG = GameFragment.class.getSimpleName();
    @InjectView(R.id.stu_game_recycler)
    RecyclerView mRecycler;
    private GameAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.fragment_game, container, false);
        ButterKnife.inject(this, layout);
        return layout;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        initView();
        setupView();
        super.onActivityCreated(savedInstanceState);
    }

    private void initView() {
        GridLayoutManager layout = new GridLayoutManager(getActivity(), 3);
        mRecycler.setLayoutManager(layout);
        adapter = new GameAdapter(getActivity(),null);
        adapter.setListener(this);
        mRecycler.setAdapter(adapter);
    }

    private void setupView() {
        RequestParams requestParams = new RequestParams(HttpUrl.GameUrl);
        x.http().get(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.e(TAG, "onSuccess: "+result );
                Gson gson = new Gson();
                GameModel gameModel = gson.fromJson(result, GameModel.class);
                List<GameModel.DataBean> data = gameModel.getData();
                adapter.updateRes(data);
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


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    @Override
    public void onItem(int position,String cname,String ename) {
        Intent intent = new Intent(getActivity(), GameItemActivity.class);
        intent.putExtra("cname",cname);
        intent.putExtra("ename",ename);
        startActivity(intent);
    }
}
