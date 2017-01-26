package com.xiaohong.wifikulian.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.xiaohong.wifikulian.R;
import com.xiaohong.wifikulian.base.BaseActivity;

/**
 * Created by Lpoint on 2017/1/26.
 */

public class ActivityHome extends BaseActivity {
    private BottomNavigationBar bottomNavigationBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();
    }

    private void initView() {
        bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);
        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.mipmap.main_tab_conn, "连接"))
                .addItem(new BottomNavigationItem(R.mipmap.main_tab_find, "发现"))
                .addItem(new BottomNavigationItem(R.mipmap.main_tab_mine, "个人中心"))
                .setMode(BottomNavigationBar.MODE_FIXED)
                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC).initialise();
    }
}
