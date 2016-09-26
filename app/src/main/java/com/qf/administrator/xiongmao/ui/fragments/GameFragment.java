package com.qf.administrator.xiongmao.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.qf.administrator.xiongmao.R;
import com.qf.administrator.xiongmao.adapters.gameadapters.GameAdapter;
import com.qf.administrator.xiongmao.constants.HttpUrl;
import com.qf.administrator.xiongmao.models.GameModel;
import com.qf.administrator.xiongmao.ui.gameactivitys.GameItemActivity;
import com.qf.administrator.xiongmao.ui.gameactivitys.SousuoActivity;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * 游戏
 */
public class GameFragment extends BaseFragment implements GameAdapter.OnItemClick, SwipeRefreshLayout.OnRefreshListener, View.OnClickListener {

    private static final String TAG = GameFragment.class.getSimpleName();
    @InjectView(R.id.stu_game_recycler)
    RecyclerView mRecycler;
    @InjectView(R.id.stu_game_swipe)
    SwipeRefreshLayout mSwipe;
    private GameAdapter adapter;
    private ImageView mImageView;

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
        onRefresh();
        super.onActivityCreated(savedInstanceState);
    }

    private void initView() {
        mImageView = ((ImageView) layout.findViewById(R.id.stu_game_sousuo));
        mImageView.setOnClickListener(this);
        //设置刷新颜色
        mSwipe.setColorSchemeResources(R.color.swipeColor);
        //设置下拉距离
        mSwipe.setProgressViewOffset(true, 0,300 );

        GridLayoutManager layout = new GridLayoutManager(getActivity(), 3);
        mRecycler.setLayoutManager(layout);

        adapter = new GameAdapter(getActivity(), null);
        adapter.setListener(this);
        mRecycler.setAdapter(adapter);
        //设置刷新监听
        mSwipe.setOnRefreshListener(this);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    @Override
    public void onItem(int position, String cname, String ename) {
        Intent intent = new Intent(getActivity(), GameItemActivity.class);
        intent.putExtra("cname", cname);
        intent.putExtra("ename", ename);
        startActivity(intent);
    }

    @Override
    public void onRefresh() {
        RequestParams requestParams = new RequestParams(HttpUrl.GameUrl);
        x.http().get(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
//                Log.e(TAG, "onSuccess: " + result);
                Gson gson = new Gson();
                GameModel gameModel = gson.fromJson(result, GameModel.class);
                List<GameModel.DataBean> data = gameModel.getData();
                adapter.updateRes(data);
                mSwipe.setRefreshing(false);
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
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.stu_game_sousuo:
                Intent intent = new Intent(getActivity(), SousuoActivity.class);
                startActivity(intent);
                break;
        }
    }
}
