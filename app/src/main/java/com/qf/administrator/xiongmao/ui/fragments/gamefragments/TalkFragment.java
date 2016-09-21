package com.qf.administrator.xiongmao.ui.fragments.gamefragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qf.administrator.xiongmao.R;
import com.qf.administrator.xiongmao.ui.fragments.BaseFragment;

/**
 * Created by a on 2016/9/21.
 */
public class TalkFragment extends BaseFragment {



    //si
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstceState) {
        layout = inflater.inflate(R.layout.fragment_talk, container, false);
        return layout;
    }
}
