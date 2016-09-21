package com.qf.administrator.xiongmao.ui.fragments.homefragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jude.rollviewpager.RollPagerView;
import com.qf.administrator.xiongmao.R;
import com.qf.administrator.xiongmao.adapters.homesplendidadapter.SplendidAdapter;
import com.qf.administrator.xiongmao.ui.fragments.BaseFragment;

import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * 精彩推荐
 */
public class SplendidFragment extends BaseFragment {
    public static final String TAG=SplendidFragment.class.getSimpleName();
    private RollPagerView mRollPagerView;
    private SplendidAdapter adapter;

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
        initData();
    }

    private void initData() {
//        x.http().get(new RequestParams(),new comm);
    }

    private void initView() {
        mRollPagerView = ((RollPagerView) layout.findViewById(R.id.splendid_rollpager));
        //设置播放时间间隔
        mRollPagerView.setPlayDelay(1000);
        //设置透明度
        mRollPagerView.setAnimationDurtion(500);
        //设置适配器
//        adapter = new SplendidAdapter(null,getActivity());
//        mRollPagerView.setAdapter(adapter);
    }
}
