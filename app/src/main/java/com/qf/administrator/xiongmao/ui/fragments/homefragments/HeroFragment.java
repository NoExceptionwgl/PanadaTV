package com.qf.administrator.xiongmao.ui.fragments.homefragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qf.administrator.xiongmao.R;
import com.qf.administrator.xiongmao.ui.fragments.BaseFragment;
import com.qf.administrator.xiongmao.util.PullToRefreshRecyclerView;

/**
 * 英雄联盟
 */
public class HeroFragment extends BaseFragment {
    public static final String TAG=HeroFragment.class.getSimpleName();
    private PullToRefreshRecyclerView mRecyclerView;
    private GridLayoutManager gridLayout;

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
    }

    private void initView() {
        mRecyclerView = ((PullToRefreshRecyclerView) layout.findViewById(R.id.hero_recyclerview));
        RecyclerView refreshableView = mRecyclerView.getRefreshableView();
        gridLayout = new GridLayoutManager(getActivity(),2);
        refreshableView.setLayoutManager(gridLayout);
    }
}
