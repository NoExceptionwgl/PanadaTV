package com.qf.administrator.xiongmao.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 首页适配器
 */
public class HomePagerAdapter extends FragmentPagerAdapter {
    private List<Fragment>data;
    private String[] titles;

    public HomePagerAdapter(FragmentManager fm,List<Fragment>data,String[] titles) {
        super(fm);
        if (data!=null) {
            this.data=data;
        }else {
            this.data=new ArrayList<>();
        }
        if (titles!=null) {
            this.titles=titles;
        }
    }

    @Override
    public Fragment getItem(int position) {
        return data.get(position);
    }

    @Override
    public int getCount() {
        return data!=null?data.size():0;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
