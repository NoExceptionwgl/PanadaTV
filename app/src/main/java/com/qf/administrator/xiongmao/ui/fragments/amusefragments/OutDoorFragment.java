package com.qf.administrator.xiongmao.ui.fragments.amusefragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qf.administrator.xiongmao.R;
import com.qf.administrator.xiongmao.ui.fragments.BaseFragment;

/**
 * Created by Administrator on 2016/9/20.
 */
public class OutDoorFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.out_door_fragment,container,false);
        return layout;
    }



}
