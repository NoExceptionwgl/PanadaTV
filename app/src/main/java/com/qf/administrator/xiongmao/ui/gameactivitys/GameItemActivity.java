package com.qf.administrator.xiongmao.ui.gameactivitys;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.qf.administrator.xiongmao.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class GameItemActivity extends AppCompatActivity {

    @InjectView(R.id.stu_game_activity_item_back)
    ImageView mBack;
    @InjectView(R.id.stu_game_activity_item_title)
    TextView mTitle;
    @InjectView(R.id.stu_game_activity_item_recycler)
    RecyclerView mRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_item);
        ButterKnife.inject(this);
        initView();
    }

    private void initView() {
        GridLayoutManager layout = new GridLayoutManager(this, 2);
        mRecycler.setLayoutManager(layout);
    }

    @OnClick(R.id.stu_game_activity_item_back)
    public void onClick() {
        finish();
    }
}
