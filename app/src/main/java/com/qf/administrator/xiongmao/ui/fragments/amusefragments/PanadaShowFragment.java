package com.qf.administrator.xiongmao.ui.fragments.amusefragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qf.administrator.xiongmao.R;
import com.qf.administrator.xiongmao.ui.fragments.BaseFragment;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Administrator on 2016/9/20.
 */
public class PanadaShowFragment extends BaseFragment {

    @InjectView(R.id.panada_show_recycler_view)
    RecyclerView mRecyclerView;
    @InjectView(R.id.panada_show_swipe)
    SwipeRefreshLayout mSwipeRefresh;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.panada_show_fragment, container, false);
        ButterKnife.inject(this, layout);
        return layout;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //RecyclerView设置管理器，绑定适配器
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        mRecyclerView.setLayoutManager(gridLayoutManager);
        //mRecyclerView.setAdapter();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}
