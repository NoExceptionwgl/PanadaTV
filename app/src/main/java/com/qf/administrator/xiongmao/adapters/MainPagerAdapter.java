package com.qf.administrator.xiongmao.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Administrator on 2016/9/20.
 */
public class MainPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> data;

    public MainPagerAdapter(FragmentManager fm, List<Fragment> data) {
        super(fm);
        this.data = data;
    }

    @Override
    public Fragment getItem(int position) {
        return data.get(position);
    }

    @Override
    public int getCount() {
        return data != null? data.size(): 0;
    }


}
