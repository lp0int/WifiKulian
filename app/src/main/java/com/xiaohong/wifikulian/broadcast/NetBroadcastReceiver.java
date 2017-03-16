package com.xiaohong.wifikulian.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;

import com.xiaohong.wifikulian.Variable;
import com.xiaohong.wifikulian.utils.NetUtils;

/**
 * Created by Lpoint on 2017/3/16 14:26.
 */

public class NetBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if ((intent.getAction().equals(ConnectivityManager.CONNECTIVITY_ACTION))) {
            int netWorkStatus = NetUtils.getNetworkState();
            Variable.netChangeInterface.onNetChange(netWorkStatus);
        }
    }
}
