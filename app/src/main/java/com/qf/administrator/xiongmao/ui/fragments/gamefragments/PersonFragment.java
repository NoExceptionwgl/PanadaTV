package com.qf.administrator.xiongmao.ui.fragments.gamefragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.qf.administrator.xiongmao.R;
import com.qf.administrator.xiongmao.events.SendId;
import com.qf.administrator.xiongmao.models.PersonModel;
import com.qf.administrator.xiongmao.ui.fragments.BaseFragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.image.ImageOptions;
import org.xutils.x;

import java.text.DecimalFormat;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by a on 2016/9/21.
 */
public class PersonFragment extends BaseFragment {


    private static final String TAG = PersonFragment.class.getSimpleName();
//    private static String URL ;
    private static String URL1 = "http://api.m.panda.tv/ajax_get_liveroom_baseinfo?roomid=452530&slaveflag=1&type=json&__version=1.2.0.1441&__plat=android" ;
    @InjectView(R.id.stu_person_fragment_iv)
    ImageView mImageView;
    @InjectView(R.id.stu_person_fragment_person_name)
    TextView mPersonName;
    @InjectView(R.id.stu_person_fragment_room_id)
    TextView mRoomId;
    @InjectView(R.id.stu_person_fragment_room_person_title)
    TextView mRoomPersonTitle;
    @InjectView(R.id.stu_person_fragment_fans_count)
    TextView mFansCount;
    @InjectView(R.id.stu_person_fragment_height)
    TextView mHeight;
    @InjectView(R.id.stu_person_fragment_xiangqing)
    TextView mXiangqing;

    private ImageOptions options = new ImageOptions.Builder()
            .setCircular(true)
            .setFadeIn(true)
            .build();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstceState) {
        layout = inflater.inflate(R.layout.fragment_person, container, false);
        ButterKnife.inject(this, layout);
        return layout;
    }

    @Subscribe
    public void onEvent(SendId event) {
        String id = event.getId();
        String URL = "http://api.m.panda.tv/ajax_get_liveroom_baseinfo?roomid="+id+"&slaveflag=1&type=json&__version=1.2.0.1441&__plat=android";
        Log.e(TAG, "onEvent: " + id);
        RequestParams params = new RequestParams(URL);
        Log.e(TAG, "initView: "+ URL );
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.e(TAG, "onSuccess: "+result );
                Gson gson = new Gson();
                PersonModel personModel = gson.fromJson(result, PersonModel.class);
                PersonModel.DataBean.InfoBean info = personModel.getData().getInfo();
                mPersonName.setText(info.getHostinfo().getName());
                String id = info.getRoominfo().getId();
                mRoomId.setText("房间号: "+id);
                mRoomPersonTitle.setText(info.getRoominfo().getName());
                String fans = info.getRoominfo().getFans();
                DecimalFormat format = new DecimalFormat("#0.0");
                double parseDouble = Double.parseDouble(format.format(Double.parseDouble(fans)/10000));
                mFansCount.setText(parseDouble+"万");
                String bamboos = info.getHostinfo().getBamboos();
                DecimalFormat format1 = new DecimalFormat("#0.00");
                double parseDouble1 = Double.parseDouble(format1.format(Double.parseDouble(bamboos)/1000000));
                mHeight.setText(parseDouble1+"m");
                mXiangqing.setText(info.getRoominfo().getBulletin());
                x.image().bind(mImageView,info.getHostinfo().getAvatar(),options);
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

    //EventBus注册和取消
    @Override
    public void onResume() {
        super.onResume();
        //注册EventBus
        EventBus.getDefault().register(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        //取消注册
        EventBus.getDefault().unregister(this);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}
