package com.qf.administrator.xiongmao.ui;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.qf.administrator.xiongmao.R;

public class SplashActivity extends BaseActivity implements Handler.Callback, View.OnClickListener {

    private static final int GO_MAIN = 100;
    private static final long DELAY_TIME = 1000;
    private Handler mHandler;
    private Button mBtn;
    private int time = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initView();
    }

    private void initView() {
        mHandler = new Handler(this);
        mBtn = (Button) findViewById(R.id.splash_btn);
        mBtn.setText("跳过" + time);
        mHandler.sendEmptyMessageDelayed(GO_MAIN,DELAY_TIME);
        mBtn.setOnClickListener(this);
    }

    @Override
    public boolean handleMessage(Message msg) {
        switch (msg.what) {
            case GO_MAIN:
                if (time > 1) {
                    time--;
                    mBtn.setText("跳过" + time);
                    mHandler.sendEmptyMessageDelayed(GO_MAIN,DELAY_TIME);
                }else {
                    jumpMainActivity();
                }
                break;
        }
        return false;
    }

    public void jumpMainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        mHandler.removeMessages(GO_MAIN);
        //结束自己
        finish();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.splash_btn:
                jumpMainActivity();
                break;
        }
    }
}
