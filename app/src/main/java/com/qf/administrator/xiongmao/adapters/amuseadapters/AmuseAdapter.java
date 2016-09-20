package com.qf.administrator.xiongmao.adapters.amuseadapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 2016/9/20.
 */
public class AmuseAdapter extends FragmentPagerAdapter {

    private List<Fragment> data;
    private String[] title = new String[] {"熊猫星秀","户外直播","萌宠乐园","音乐专区"};

    public AmuseAdapter(FragmentManager fm, List<Fragment> data) {
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

    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }
}
