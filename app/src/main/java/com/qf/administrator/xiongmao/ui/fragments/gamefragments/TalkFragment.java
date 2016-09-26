package com.qf.administrator.xiongmao.ui.fragments.gamefragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.qf.administrator.xiongmao.R;
import com.qf.administrator.xiongmao.ui.fragments.BaseFragment;
import com.qf.administrator.xiongmao.util.JumpLogin;

/**
 * Created by a on 2016/9/21.
 */
public class TalkFragment extends BaseFragment implements View.OnClickListener {


    private ImageView mGift;
    private PopupWindow popupWindow;

    //si
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstceState) {
        layout = inflater.inflate(R.layout.fragment_talk, container, false);
        return layout;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
    }

    private void initView() {
        mGift = ((ImageView) layout.findViewById(R.id.stu_talk_fragment_gift));
        mGift.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.stu_talk_fragment_gift:
                if (JumpLogin.isLogin(getActivity())) {
                    Toast.makeText(getActivity(), "登录成功", Toast.LENGTH_SHORT).show();
                    View view = LayoutInflater.from(getActivity()).inflate(R.layout.popue_item, null);
                    DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
                    int widthPixels = displayMetrics.widthPixels;
                    int heightPixels = displayMetrics.heightPixels;
                    if (popupWindow!=null) {
                        popupWindow = new PopupWindow(view);
                        popupWindow.setHeight(widthPixels);
                        popupWindow.setHeight((heightPixels/5)*2);
                    }
                    if (popupWindow.isShowing()) {
                        popupWindow.dismiss();
                    }else{
                        popupWindow.showAtLocation(view, Gravity.TOP,0,view.getHeight()+heightPixels*2/5);
                    }
                }else{
                    JumpLogin.login(getActivity());
                }
                break;
        }
    }
}
