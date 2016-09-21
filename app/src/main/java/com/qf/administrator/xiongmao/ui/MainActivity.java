package com.qf.administrator.xiongmao.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.qf.administrator.xiongmao.R;
import com.qf.administrator.xiongmao.adapters.MainPagerAdapter;
import com.qf.administrator.xiongmao.ui.fragments.AmusementFragment;
import com.qf.administrator.xiongmao.ui.fragments.GameFragment;
import com.qf.administrator.xiongmao.ui.fragments.GoddessFragment;
import com.qf.administrator.xiongmao.ui.fragments.HomeFragment;
import com.qf.administrator.xiongmao.ui.fragments.MineFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener, ViewPager.OnPageChangeListener {

    private static final String TAG = MainActivity.class.getSimpleName();
    private ViewPager mViewPager;
    private RadioGroup mController;
    private List<Fragment> data;
    private MainPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
        setListener();
    }

    private void initData() {
        data = new ArrayList<>();
        data.add(new HomeFragment());
        data.add(new GameFragment());
        data.add(new AmusementFragment());
        data.add(new GoddessFragment());
        data.add(new MineFragment());
    }

    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.main_viewpager);
        mController = (RadioGroup) findViewById(R.id.main_controller);
        adapter = new MainPagerAdapter(getSupportFragmentManager(),data);
        mViewPager.setAdapter(adapter);


    }

    private void setListener() {
        mController.setOnCheckedChangeListener(this);
        mViewPager.addOnPageChangeListener(this);
    }

//--------------------------RadioGroup监听------------------------------
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.main_controller_home:
                mViewPager.setCurrentItem(0);
                break;
            case R.id.main_controller_game:
                mViewPager.setCurrentItem(1);
                break;
            case R.id.main_controller_amusement:
                mViewPager.setCurrentItem(2);
                break;
            case R.id.main_controller_goddess:
                mViewPager.setCurrentItem(3);
                break;
            case R.id.main_controller_mine:
                mViewPager.setCurrentItem(4);
                break;
        }
    }

//------------------------ViewPager回调监听---------------------------------
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {
        RadioButton child = (RadioButton) mController.getChildAt(position);
        child.setChecked(true);
    }

    @Override
    public void onPageScrollStateChanged(int state) {
    }
}
