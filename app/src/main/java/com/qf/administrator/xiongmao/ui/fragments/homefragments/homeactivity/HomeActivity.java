package com.qf.administrator.xiongmao.ui.fragments.homefragments.homeactivity;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.qf.administrator.xiongmao.R;
import com.qf.administrator.xiongmao.adapters.gameadapters.GamePagerAdapter;
import com.qf.administrator.xiongmao.ui.fragments.gamefragments.PersonFragment;
import com.qf.administrator.xiongmao.ui.fragments.gamefragments.TalkFragment;
import com.qf.administrator.xiongmao.ui.fragments.gamefragments.ToplistFragment;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, ViewPager.OnPageChangeListener {

    private ViewPager mViewPager;
    private RadioGroup mRadioGroup;
    private List<Fragment> data;
    private GamePagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();
        initData();
    }

    private void initData() {
        data = new ArrayList<>();
        data.add(new TalkFragment());
        data.add(new ToplistFragment());
        data.add(new PersonFragment());
    }

    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.home_activity_viewpager);
        mRadioGroup = (RadioGroup) findViewById(R.id.home_activity_radiogroup);
        mRadioGroup.setOnCheckedChangeListener(this);
        mViewPager.addOnPageChangeListener(this);
        adapter = new GamePagerAdapter(getSupportFragmentManager(),data);
        mViewPager.setAdapter(adapter);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            //聊天
            case R.id.shome_activity_button01:
                mViewPager.setCurrentItem(0);
                break;
            //排行榜
            case R.id.shome_activity_button02:
                mViewPager.setCurrentItem(1);
                break;
            //主播
            case R.id.shome_activity_button03:
                mViewPager.setCurrentItem(2);
                break;
            //订阅
            case R.id.shome_activity_button04:

                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        RadioButton childAt = (RadioButton) mRadioGroup.getChildAt(position);
        childAt.setChecked(true);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
