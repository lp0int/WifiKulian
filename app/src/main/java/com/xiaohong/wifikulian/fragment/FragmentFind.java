package com.xiaohong.wifikulian.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xiaohong.wifikulian.Constants;
import com.xiaohong.wifikulian.R;
import com.xiaohong.wifikulian.base.BaseFragment;

/**
 * Created by Lpoint on 2017/1/26.
 */

public class FragmentFind extends BaseFragment {
    private TextView txtText;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_find,container,  false);
        txtText = (TextView) view.findViewById(R.id.txt_test);
        return view;
    }
}
