package com.xiaohong.wifikulian.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.xiaohong.wifikulian.R;
import com.xiaohong.wifikulian.base.BaseActivity;
import com.xiaohong.wifikulian.utils.Utils;

/**
 * Created by Lpoint on 2017/3/28 20:12.
 */

public class ActivityMessage extends BaseActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.hideActiconBar(this);
        setContentView(R.layout.activity_message);
//        initView();
    }
    private void initView(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        TextView txtTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        txtTitle.setText("消息中心");
    }
}
