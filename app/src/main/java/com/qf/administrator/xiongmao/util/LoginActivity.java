package com.qf.administrator.xiongmao.util;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.qf.administrator.xiongmao.R;

import java.util.HashMap;

import butterknife.ButterKnife;
import butterknife.InjectView;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;
import cn.sharesdk.sina.weibo.SinaWeibo;
import cn.sharesdk.tencent.qq.QQ;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, PlatformActionListener {

    @InjectView(R.id.activity_login_back_image)
    ImageView mBack;
    @InjectView(R.id.activity_login_username)
    EditText mUsername;
    @InjectView(R.id.activity_login_password)
    EditText mPassword;
    @InjectView(R.id.activity_login_btn)
    Button mLoginBtn;
    @InjectView(R.id.activity_register_btn)
    Button mRegisterBtn;
    @InjectView(R.id.activity_forget_btn)
    TextView mForgetBtn;
    @InjectView(R.id.login_qq_image)
    ImageView mQQ;
    @InjectView(R.id.login_weibo_image)
    ImageView mWeiBo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.inject(this);
        setListener();
    }

    private void setListener() {
        mBack.setOnClickListener(this);
        mQQ.setOnClickListener(this);
        mWeiBo.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.activity_login_back_image:
                finish();
                break;
            case R.id.activity_login_btn:

                break;
            case R.id.activity_register_btn:

                break;
            case R.id.activity_forget_btn:

                break;
            case R.id.login_qq_image:
                //第三方登陆qq
                ShareSDK.initSDK(this);
                Platform qq = ShareSDK.getPlatform(this, QQ.NAME);
                qq.setPlatformActionListener(this);
                qq.authorize();
                qq.showUser(null);
                break;
            case R.id.login_weibo_image:
                //登陆微博
                ShareSDK.initSDK(this);
                Platform sina = ShareSDK.getPlatform(this, SinaWeibo.NAME);
                sina.setPlatformActionListener(this);
                sina.authorize();
                sina.showUser(null);
                break;

        }
    }

    private void showShare(String title, String url) {
        ShareSDK.initSDK(this);
        OnekeyShare oks = new OnekeyShare();
        //关闭sso授权
        oks.disableSSOWhenAuthorize();

        // 分享时Notification的图标和文字  2.5.9以后的版本不调用此方法
        //oks.setNotification(R.drawable.ic_launcher, getString(R.string.app_name));
        // title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间使用
        oks.setTitle(title);
        // titleUrl是标题的网络链接，仅在人人网和QQ空间使用
        oks.setTitleUrl(url);
        // text是分享文本，所有平台都需要这个字段
        oks.setText("你是猴子请来的吗");
        //分享网络图片，新浪微博分享网络图片需要通过审核后申请高级写入接口，否则请注释掉测试新浪微博
        oks.setImageUrl("http://f1.sharesdk.cn/imgs/2014/02/26/owWpLZo_638x960.jpg");
        // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
        //oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
        // url仅在微信（包括好友和朋友圈）中使用
        oks.setUrl("http://sharesdk.cn");
        // comment是我对这条分享的评论，仅在人人网和QQ空间使用
        oks.setComment("我是测试评论文本");
        // site是分享此内容的网站名称，仅在QQ空间使用
        oks.setSite(getString(R.string.app_name));
        // siteUrl是分享此内容的网站地址，仅在QQ空间使用
        oks.setSiteUrl("http://sharesdk.cn");

        // 启动分享GUI
        oks.show(this);
    }

    //-------------------------登陆的回调监听---------------------------------
    @Override
    public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
        PreferenceUtil.setBoolean(this,"is_logined",true);
        finish();
    }

    @Override
    public void onError(Platform platform, int i, Throwable throwable) {

    }

    @Override
    public void onCancel(Platform platform, int i) {

    }


}
