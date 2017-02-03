package com.xiaohong.wifikulian.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.xiaohong.wifikulian.Constants;
import com.xiaohong.wifikulian.Variable;
import com.xiaohong.wifikulian.base.BaseActivity;

/**
 * Created by Lpoint on 2017/1/24.
 */

public class ActivitySplash extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Variable.BASECONTEXT = getBaseContext();
        Intent intent  = new Intent();
        intent.setClass(ActivitySplash.this,ActivityLogin.class);
        startActivity(intent);
        finish();
    }
}
