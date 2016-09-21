package com.qf.administrator.xiongmao.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qf.administrator.xiongmao.R;
import com.qf.administrator.xiongmao.adapters.HomePagerAdapter;
import com.qf.administrator.xiongmao.ui.fragments.homefragments.DiabloFragment;
import com.qf.administrator.xiongmao.ui.fragments.homefragments.HearthstoneFragment;
import com.qf.administrator.xiongmao.ui.fragments.homefragments.HeroFragment;
import com.qf.administrator.xiongmao.ui.fragments.homefragments.OutdoorFragment;
import com.qf.administrator.xiongmao.ui.fragments.homefragments.PandaFragment;
import com.qf.administrator.xiongmao.ui.fragments.homefragments.SplendidFragment;
import com.qf.administrator.xiongmao.ui.fragments.homefragments.WarcraftFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 首页
 */
public class HomeFragment extends BaseFragment {

    private static final String TAG = HomeFragment.class.getSimpleName();
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private HomePagerAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.fragment_home,container,false);
        return layout;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
    }

    private void initView() {
        mTabLayout = ((TabLayout) layout.findViewById(R.id.home_tablayout));
        mViewPager = ((ViewPager) layout.findViewById(R.id.home_viewpager));

        List<Fragment>data=new ArrayList<>();
        data.add(new SplendidFragment());
        data.add(new HeroFragment());
        data.add(new DiabloFragment());
        data.add(new HearthstoneFragment());
        data.add(new PandaFragment());
        data.add(new OutdoorFragment());
        data.add(new WarcraftFragment());
        /**
         * 当Fragment嵌套进行使用的时候，内部的Fragment加载要使用getChildFragmentManager
         */
        String[] titles = getResources().getStringArray(R.array.tabs);
        adapter = new HomePagerAdapter(getChildFragmentManager(),data,titles);
        mViewPager.setAdapter(adapter);
        /**
         * ViewPager与TabLayout联动
         * ① 重写PagerAdapter中的getPageTitle
         * ② 使TabLayout与ViewPager进行绑定
         */
        mTabLayout.setupWithViewPager(mViewPager);
    }

}
