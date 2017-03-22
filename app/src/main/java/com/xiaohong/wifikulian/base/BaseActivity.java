package com.xiaohong.wifikulian.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.squareup.otto.Subscribe;
import com.xiaohong.wifikulian.Constants;
import com.xiaohong.wifikulian.Variable;
import com.xiaohong.wifikulian.models.AdControlBean;
import com.xiaohong.wifikulian.models.AdOrdersBean;
import com.xiaohong.wifikulian.models.AppEventModel;
import com.xiaohong.wifikulian.models.LoginBean;
import com.xiaohong.wifikulian.models.RecommendListBean;

/**
 * Created by Lpoint on 2017/1/26.
 */

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppEvent.getInstance().register(mEventSubscriber);
    }

    private Object mEventSubscriber = new Object() {
        @Subscribe
        public void onAppEventBusReceived(AppEventModel event) {
            int requestCode = event.getEventCode();
            Bundle data = event.getBundle();
            onAppBusEvent(requestCode, data);
        }
    };

    protected void onAppBusEvent(int code, Bundle data) {
        switch (code) {
            case Constants.CODE_LOGOUT:
                finish();
                break;
        }
    }

    protected void sendEventModel(int eventCode, Bundle bundle) {
        AppEvent.getInstance().postQueue(new AppEventModel(eventCode, bundle));
    }

    protected void sendEventModel(int eventCode) {
        AppEvent.getInstance().postQueue(new AppEventModel(eventCode));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        AppEvent.getInstance().unregister(mEventSubscriber);
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putSerializable("loginBean",Variable.loginBean);
        outState.putSerializable("tabListBean",Variable.tabListBean);
        outState.putSerializable("recommendListBean",Variable.recommendListBean);
        outState.putSerializable("galleryFunctionList",Variable.galleryFunctionList);
        outState.putSerializable("adControlBean",Variable.adControlBean);
        outState.putSerializable("bannerList",Variable.bannerList);
        outState.putSerializable("scrollMsgList",Variable.scrollMsgList);
        outState.putBoolean("havePermissions",Variable.havePermissions);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Variable.loginBean = (LoginBean)savedInstanceState.getSerializable("loginBean");
        Variable.tabListBean = (AdOrdersBean) savedInstanceState.getSerializable("tabListBean");
        Variable.recommendListBean = (RecommendListBean) savedInstanceState.getSerializable("recommendListBean");
        Variable.galleryFunctionList = (AdOrdersBean) savedInstanceState.getSerializable("galleryFunctionList");
        Variable.adControlBean = (AdControlBean) savedInstanceState.getSerializable("adControlBean");
        Variable.bannerList = (AdOrdersBean) savedInstanceState.getSerializable("bannerList");
        Variable.scrollMsgList = (AdOrdersBean) savedInstanceState.getSerializable("scrollMsgList");
        Variable.havePermissions = savedInstanceState.getBoolean("havePermissions");
    }
}
