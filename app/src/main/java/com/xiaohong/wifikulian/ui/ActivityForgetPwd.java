package com.xiaohong.wifikulian.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.widget.TextView;

import com.xiaohong.wifikulian.R;
import com.xiaohong.wifikulian.utils.Utils;

/**
 * Created by Lpoint on 2017/1/20 10:53.
 */

public class ActivityForgetPwd extends AppCompatActivity {

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
        txtTitle.setText("忘记密码");
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            this.finish();
            overridePendingTransition(R.anim.x_0_2_0,R.anim.x_0_2_minus100);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
