package com.qf.administrator.xiongmao.ui.gameactivitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.qf.administrator.xiongmao.R;
import com.qf.administrator.xiongmao.adapters.gameadapters.GameActivityAdapter;
import com.qf.administrator.xiongmao.models.GameActivityModel;
import com.qf.administrator.xiongmao.util.PullToRefreshRecyclerView;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class GameItemActivity extends AppCompatActivity implements GameActivityAdapter.OnItemClickOne,PullToRefreshBase.OnRefreshListener2, SwipeRefreshLayout.OnRefreshListener {

    private static final String TAG = GameItemActivity.class.getSimpleName();
    private  String ename;
    private int page = 1;

    private GameActivityAdapter adapter;


    @InjectView(R.id.stu_game_activity_item_back)
    ImageView mBack;
    @InjectView(R.id.stu_game_activity_item_title)
    TextView mTitle;
    @InjectView(R.id.stu_game_activity_item_recycler)
    PullToRefreshRecyclerView mPullToRefresh;
    @InjectView(R.id.stu_game_activity_swipe)
    SwipeRefreshLayout mSwipe;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_item);
        ButterKnife.inject(this);
        initView();
        ename = getIntent().getStringExtra("ename");
        setupView(State.DOWM);
    }

    enum State{
        DOWM,UP
    }

    private void setupView(final State state) {
        String URL = "http://api.m.panda.tv/ajax_get_live_list_by_cate?cate="+ename+"&pageno="+page+"&pagenum=20&sproom=1&__version=1.2.0.1441&__plat=android";
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
                switch (state) {
                    case DOWM:
                        adapter.updateRes(items);
                        break;
                    case UP:
                        adapter.addRes(items);
                        break;
                }
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
                mPullToRefresh.onRefreshComplete();
            }
        });
    }

    private void initView() {
        //设置刷新颜色
        mSwipe.setColorSchemeResources(R.color.swipeColor);
        //设置下拉距离
        mSwipe.setProgressViewOffset(true, 0,300 );
        //设置刷新监听
        mSwipe.setOnRefreshListener(this);

        mPullToRefresh.setMode(PullToRefreshBase.Mode.BOTH);
        mRecyclerView = mPullToRefresh.getRefreshableView();
        mPullToRefresh.setOnRefreshListener(this);
        GridLayoutManager layout = new GridLayoutManager(this, 2);
        mRecyclerView.setLayoutManager(layout);
        adapter = new GameActivityAdapter(null,this);
        adapter.setOnItemClickOne(this);
        mRecyclerView.setAdapter(adapter);
    }

    @OnClick(R.id.stu_game_activity_item_back)
    public void onClick() {
        finish();
    }

    @Override
    public void onType(int position) {
        Log.e(TAG, "onType: "+position );
        Intent intent = new Intent(this, GameItemTwoActivity.class);
        startActivity(intent);
    }

    @Override
    public void onPullDownToRefresh(PullToRefreshBase refreshView) {
        Log.e(TAG, "onPullDownToRefresh: " );
        onRefresh();
    }

    @Override
    public void onPullUpToRefresh(PullToRefreshBase refreshView) {
        page++;
        setupView(State.UP);
    }

    @Override
    public void onRefresh() {
        page = 1;
        setupView(State.DOWM);
        mSwipe.setRefreshing(false);
    }
}
