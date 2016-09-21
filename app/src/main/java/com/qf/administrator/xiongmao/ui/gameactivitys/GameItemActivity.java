package com.qf.administrator.xiongmao.ui.gameactivitys;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.qf.administrator.xiongmao.R;
import com.qf.administrator.xiongmao.adapters.gameadapters.GameActivityAdapter;
import com.qf.administrator.xiongmao.models.GameActivityModel;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class GameItemActivity extends AppCompatActivity implements GameActivityAdapter.OnItemClickOne {

    private static final String TAG = GameItemActivity.class.getSimpleName();
    private static String ename;

    @InjectView(R.id.stu_game_activity_item_back)
    ImageView mBack;
    @InjectView(R.id.stu_game_activity_item_title)
    TextView mTitle;
    @InjectView(R.id.stu_game_activity_item_recycler)
    RecyclerView mRecycler;
    private GameActivityAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_item);
        ButterKnife.inject(this);
        initView();
        ename = getIntent().getStringExtra("ename");
        setupView();
    }

    private void setupView() {
        String URL = "http://api.m.panda.tv/ajax_get_live_list_by_cate?cate="+ename+"&pageno=1&pagenum=20&sproom=1&__version=1.2.0.1441&__plat=android";
        RequestParams requestParams = new RequestParams(URL);
        x.http().get(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.e(TAG, "onSuccess: "+result );
                Gson gson = new Gson();
                GameActivityModel gameActivityModel = gson.fromJson(result, GameActivityModel.class);
                List<GameActivityModel.DataBean.ItemsBean> items = gameActivityModel.getData().getItems();
                String cname = getIntent().getStringExtra("cname");
                if (cname !=null) {
                    mTitle.setText(cname);
                }
                adapter.updateRes(items);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e(TAG, "onError: " );
            }

            @Override
            public void onCancelled(CancelledException cex) {
                Log.e(TAG, "onCancelled: " );
            }

            @Override
            public void onFinished() {
                Log.e(TAG, "onFinished: " );
            }
        });
    }

    private void initView() {
        GridLayoutManager layout = new GridLayoutManager(this, 2);
        mRecycler.setLayoutManager(layout);
        adapter = new GameActivityAdapter(null,this);
        adapter.setOnItemClickOne(this);
        mRecycler.setAdapter(adapter);
    }

    @OnClick(R.id.stu_game_activity_item_back)
    public void onClick() {
        finish();
    }

    @Override
    public void onType(int position) {

    }
}
