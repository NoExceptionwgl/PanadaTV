package com.qf.administrator.xiongmao.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qf.administrator.xiongmao.R;

/**
 * 女神
 */
public class GoddessFragment extends BaseFragment {

    private static final String TAG = GoddessFragment.class.getSimpleName();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.fragment_goddess,container,false);
        return layout;
    }
}
