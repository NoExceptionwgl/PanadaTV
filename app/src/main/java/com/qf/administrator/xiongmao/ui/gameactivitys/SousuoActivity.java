package com.qf.administrator.xiongmao.ui.gameactivitys;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.qf.administrator.xiongmao.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class SousuoActivity extends AppCompatActivity {

    @InjectView(R.id.stu_game_sousuo_back)
    ImageView stuGameSousuoBack;
    @InjectView(R.id.stu_game_sousuo_et)
    EditText stuGameSousuoEt;
    @InjectView(R.id.stu_game_sousuo)
    ImageView stuGameSousuo;
    @InjectView(R.id.stu_game_sousuo_panda)
    ImageView stuGameSousuoPanda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sousuo);
        ButterKnife.inject(this);
    }

    @OnClick({R.id.stu_game_sousuo_back, R.id.stu_game_sousuo_et, R.id.stu_game_sousuo})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.stu_game_sousuo_back:
                finish();
                break;
            case R.id.stu_game_sousuo_et:

                break;
            case R.id.stu_game_sousuo:

                break;
        }
    }
}
