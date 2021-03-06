package com.xiaohong.wifikulian.activity;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.xiaohong.wifikulian.Constants;
import com.xiaohong.wifikulian.Interface.NetChangeInterface;
import com.xiaohong.wifikulian.R;
import com.xiaohong.wifikulian.Variable;
import com.xiaohong.wifikulian.base.BaseActivity;
import com.xiaohong.wifikulian.broadcast.NetBroadcastReceiver;
import com.xiaohong.wifikulian.fragment.FragmentConn;
import com.xiaohong.wifikulian.fragment.FragmentFind;
import com.xiaohong.wifikulian.fragment.FragmentMine;
import com.xiaohong.wifikulian.models.LoginBean;
import com.xiaohong.wifikulian.utils.Utils;

import java.util.ArrayList;

/**
 * Created by Lpoint on 2017/1/26.
 */

public class ActivityHome extends BaseActivity implements BottomNavigationBar.OnTabSelectedListener, NetChangeInterface {
    private BottomNavigationBar bottomNavigationBar;
    private ArrayList<Fragment> fragments;
    private NetBroadcastReceiver mBroadcastReceiver;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.hideActiconBar(this);
        setContentView(R.layout.activity_home);
        initView();
    }

    private void initView() {
        Variable.netChangeInterface = this;
        if (mBroadcastReceiver == null) {
            mBroadcastReceiver = new NetBroadcastReceiver();
            registerReceiver(mBroadcastReceiver, new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
        }
        bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);
        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.mipmap.main_tab_conn, "连接"))
                .addItem(new BottomNavigationItem(R.mipmap.main_tab_find, "发现"))
                .addItem(new BottomNavigationItem(R.mipmap.main_tab_mine, "个人中心"))
                .setMode(BottomNavigationBar.MODE_FIXED)
                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC).initialise();
        initFragment();
        bottomNavigationBar.setTabSelectedListener(this);
        initSelect();
    }

    private void initFragment() {
        fragments = new ArrayList<>();
        fragments.add(new FragmentConn());
        fragments.add(new FragmentFind());
        fragments.add(new FragmentMine());
    }

    /**
     * @time 2017-01-26
     * 最开始是直接在此处transaction。replace(Fragment)来切换fragment，结果导致fragment每次都是重新走过生命周期，所以会在Destroy里面
     * 执行AppEvent.getInstance().unregister(mEventSubscriber);导致收不到发送过来的事件，并且再次打开Fragment的时候，会重新加载一遍Fragment,
     * 效率很低，官方文档解释说：replace()这个方法只是在上一个Fragment不再需要时采用的简便方法。正确的做法是在onTabSelected检查是否add，
     * 使用add()和show()方法来现实Fragment，在onTabUnselected时使用hide方法来隐藏fragment();
     * 目前可能存在一个隐患为在内存不足的时候，Activity被回收重启后导致fragment重叠显示，解决方案为在OnCreate里面添加Fragment的时候检测一下
     * 当前的savedInstanceState.
     * *参考资料http://www.cnblogs.com/android-joker/p/4414891.html
     */
    @Override
    public void onTabSelected(int position) {
        if (fragments != null) {
            FragmentManager fm = this.getSupportFragmentManager();
            FragmentTransaction transaction = fm.beginTransaction();
            Fragment fragment = fragments.get(position % fragments.size());
            if (fragment.isAdded()) {
                transaction.show(fragment);
            } else {
                transaction.add(R.id.lin_content, fragment);
                transaction.show(fragment);
            }
            transaction.commitAllowingStateLoss();
        }
    }

    @Override
    public void onTabUnselected(int position) {
        if (fragments != null) {
            FragmentManager fm = this.getSupportFragmentManager();
            FragmentTransaction transaction = fm.beginTransaction();
            Fragment fragment = fragments.get(position % fragments.size());
            transaction.hide(fragment);
            transaction.commit();
        }
    }

    @Override
    public void onTabReselected(int position) {

    }

    private void initSelect() {
        onTabSelected(0);
    }

    @Override
    public void onNetChange(int networkType) {
        Bundle bundle = new Bundle();
        bundle.putInt(Constants.WIFI_STATUS_CODE, networkType);
        sendEventModel(Constants.CODE_CHANGE_NETWORK_STATUS, bundle);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent home = new Intent(Intent.ACTION_MAIN);
            home.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            home.addCategory(Intent.CATEGORY_HOME);
            startActivity(home);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onAppBusEvent(int code, Bundle data) {
        super.onAppBusEvent(code, data);
        switch (code){
            case Constants.CODE_JUMP_TO_RECOMMEND_TASK:
                bottomNavigationBar.selectTab(1);
                break;
            default:
                break;
        }

    }
}
