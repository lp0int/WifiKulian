package com.xiaohong.wifikulian.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.xiaohong.wifikulian.Constants;

/**
 * Created by Lpoint on 2017/1/24.
 */

public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Constants.BASECONTEXT = getBaseContext();
        Intent intent  = new Intent();
        intent.setClass(SplashActivity.this,MainActivity.class);
        startActivity(intent);
    }
}
