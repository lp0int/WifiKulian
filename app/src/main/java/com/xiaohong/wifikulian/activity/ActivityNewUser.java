package com.xiaohong.wifikulian.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.widget.TextView;

import com.xiaohong.wifikulian.Constants;
import com.xiaohong.wifikulian.R;
import com.xiaohong.wifikulian.base.BaseActivity;
import com.xiaohong.wifikulian.utils.Utils;

/**
 * Created by Lpoint on 2017/1/20 13:29.
 */

public class ActivityNewUser extends BaseActivity {
    private TextView txtTitle;

    @SuppressLint("InlinedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.hideActiconBar(this);
        setContentView(R.layout.activity_forget_pwd);
        initView();
    }

    private void initView() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        txtTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        txtTitle.setText("注册");
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            this.finish();
            overridePendingTransition(R.anim.x_0_2_0,R.anim.x_0_2_100);
            sendEventModel(Constants.CODE_REGISTER_OVER);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
