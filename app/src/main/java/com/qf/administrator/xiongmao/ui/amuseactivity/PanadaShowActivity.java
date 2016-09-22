package com.qf.administrator.xiongmao.ui.amuseactivity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.VideoView;

import com.qf.administrator.xiongmao.R;
import com.qf.administrator.xiongmao.util.JumpLogin;

import butterknife.ButterKnife;
import butterknife.InjectView;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;

public class PanadaShowActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, View.OnClickListener {

    @InjectView(R.id.activity_panada_show_video)
    VideoView mVideo;
    @InjectView(R.id.activity_panada_show_liaotian)
    RadioButton mLiaotian;
    @InjectView(R.id.activity_panada_show_toplist)
    RadioButton mToplist;
    @InjectView(R.id.activity_panada_show_author)
    RadioButton mAuthor;
    @InjectView(R.id.activity_panada_show_book)
    Button mBook;
    @InjectView(R.id.activity_panada_show_rg)
    RadioGroup mRadioGroup;
    @InjectView(R.id.stu_game_activity_two_item_vp)
    ViewPager mViewpager;
    private boolean isLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panada_show);
        ButterKnife.inject(this);
        setListener();
    }

    private void setListener() {
        mRadioGroup.setOnCheckedChangeListener(this);
        mBook.setOnClickListener(this);

    }

//------------------RadioButton监听回调函数------------------
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.activity_panada_show_liaotian:

                break;
            case R.id.activity_panada_show_toplist:

                break;
            case R.id.activity_panada_show_author:

                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.activity_panada_show_book:
                if (JumpLogin.isLogin(this)) {
                    Toast.makeText(PanadaShowActivity.this, "登陆成功", Toast.LENGTH_SHORT).show();
                }else {
                    JumpLogin.login(this);

                }
                break;
        }
    }



}
