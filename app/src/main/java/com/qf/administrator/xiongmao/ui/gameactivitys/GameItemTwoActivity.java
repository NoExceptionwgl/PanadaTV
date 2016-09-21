package com.qf.administrator.xiongmao.ui.gameactivitys;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.qf.administrator.xiongmao.R;
import com.qf.administrator.xiongmao.adapters.gameadapters.GamePagerAdapter;
import com.qf.administrator.xiongmao.ui.fragments.gamefragments.PersonFragment;
import com.qf.administrator.xiongmao.ui.fragments.gamefragments.TalkFragment;
import com.qf.administrator.xiongmao.ui.fragments.gamefragments.ToplistFragment;

import java.util.ArrayList;
import java.util.List;

import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.Vitamio;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;

public class GameItemTwoActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, ViewPager.OnPageChangeListener {

    private VideoView videoView;
    private ViewPager mViewPager;
    private RadioGroup mRadioGroup;
    private List<Fragment>data;
    private GamePagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Vitamio.isInitialized(this);
        setContentView(R.layout.activity_game_item_two);
        initData();
        initView();

    }

    private void initData() {
        data = new ArrayList<>();
        data.add(new TalkFragment());
        data.add(new ToplistFragment());
        data.add(new PersonFragment());
    }

    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.stu_game_activity_two_item_vp);
        mRadioGroup = (RadioGroup) findViewById(R.id.stu_game_activity_two_item_rg);
        mRadioGroup.setOnCheckedChangeListener(this);
        mViewPager.addOnPageChangeListener(this);
        adapter = new GamePagerAdapter(getSupportFragmentManager(),data);
        mViewPager.setAdapter(adapter);

        //播放
        videoView = (VideoView) findViewById(R.id.stu_game_activity_two_item_videoview);
//        videoView.setVideoPath("http://7rflo2.com2.z0.glb.qiniucdn.com/5714b0b53c958.mp4");
        videoView.setMediaController(new MediaController(this));
//        videoView.start();
        videoView.requestFocus();
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                //设置快进的倍速
                mediaPlayer.setPlaybackSpeed(1.0f);
                //设置缓冲大小
                mediaPlayer.setBufferSize(512 * 1024);
            }
        });
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.stu_game_activity_two_item_liaotian:
                mViewPager.setCurrentItem(0);
                break;
            case R.id.stu_game_activity_two_item_toplist:
                mViewPager.setCurrentItem(1);
                break;
            case R.id.stu_game_activity_two_item_person:
                mViewPager.setCurrentItem(2);
                break;
            case R.id.stu_game_activity_two_item_book:

                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        RadioButton child = (RadioButton) mRadioGroup.getChildAt(position);
        child.setChecked(true);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
