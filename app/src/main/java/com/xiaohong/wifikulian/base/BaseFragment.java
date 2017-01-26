package com.xiaohong.wifikulian.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.squareup.otto.Subscribe;
import com.xiaohong.wifikulian.Constants;
import com.xiaohong.wifikulian.models.AppEventModel;

/**
 * Created by Lpoint on 2017/1/26.
 */

public class BaseFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            AppEvent.getInstance().register(mEventSubscriber);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        AppEvent.getInstance().unregister(mEventSubscriber);
    }

    protected void sendEventModel(int eventCode, Bundle bundle) {
        AppEvent.getInstance().postQueue(new AppEventModel(eventCode, bundle));
    }

    protected void sendEventModel(int eventCode) {
        AppEvent.getInstance().postQueue(new AppEventModel(eventCode));
    }

    protected void onAppBusEvent(int code, Bundle data) {
        switch (code) {
            case Constants.CODE_LOGOUT:
                getActivity().finish();
                break;
        }
    }

    private Object mEventSubscriber = new Object() {
        @Subscribe
        public void onAppEventBusReceived(AppEventModel event) {
            int requestCode = event.getEventCode();
            Bundle data = event.getBundle();
            onAppBusEvent(requestCode, data);
        }
    };

}
