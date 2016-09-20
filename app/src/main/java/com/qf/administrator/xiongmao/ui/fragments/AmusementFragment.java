package com.qf.administrator.xiongmao.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.qf.administrator.xiongmao.R;
import com.qf.administrator.xiongmao.adapters.amuseadapters.AmuseAdapter;
import com.qf.administrator.xiongmao.ui.fragments.amusefragments.MusicFragment;
import com.qf.administrator.xiongmao.ui.fragments.amusefragments.OutDoorFragment;
import com.qf.administrator.xiongmao.ui.fragments.amusefragments.PanadaShowFragment;
import com.qf.administrator.xiongmao.ui.fragments.amusefragments.PetParkFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * 娱乐
 */
public class AmusementFragment extends BaseFragment implements View.OnClickListener {

    private static final String TAG = AmusementFragment.class.getSimpleName();
    @InjectView(R.id.amuse_seaerch_image)
    ImageView mImage;
    @InjectView(R.id.amuse_viewpager)
    ViewPager mViewpager;
    @InjectView(R.id.amuse_tab_layout)
    TabLayout mTabLayout;

    private List<Fragment> data;
    private AmuseAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.fragment_amusement, container, false);
        ButterKnife.inject(this, layout);
        return layout;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getFragment();
        initView();
        setListener();
    }

    public List<Fragment> getFragment() {
        data = new ArrayList<>();
        PanadaShowFragment panadaShowFragment = new PanadaShowFragment();
        OutDoorFragment outDoorFragment = new OutDoorFragment();
        PetParkFragment petParkFragment = new PetParkFragment();
        MusicFragment musicFragment = new MusicFragment();

        data.add(panadaShowFragment);
        data.add(outDoorFragment);
        data.add(petParkFragment);
        data.add(musicFragment);
        return data;
    }

    private void initView() {
        adapter = new AmuseAdapter(getChildFragmentManager(), data);
        mViewpager.setAdapter(adapter);

        mTabLayout.setupWithViewPager(mViewpager);

    }

    private void setListener() {
        mImage.setOnClickListener(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    //-------------------ImageView点击监听---------------------------
    @Override
    public void onClick(View v) {

    }


}
