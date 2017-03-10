package com.xiaohong.wifikulian.utils;

import android.content.Context;

import com.xiaohong.wifikulian.Constants;
import com.xiaohong.wifikulian.Interface.ProgressCancelListener;
import com.xiaohong.wifikulian.Interface.SubscriberOnNextListener;
import com.xiaohong.wifikulian.handler.ProgressDialogHandler;

import rx.Subscriber;

/**
 * Created by Lpoint on 2017/1/20 14:46.
 */

public class ProgressSubscriber<T> extends Subscriber<T> implements ProgressCancelListener {
    private SubscriberOnNextListener mSubscriberOnNextListener;
    private ProgressDialogHandler mProgressDialogHandler;
    private Context mContext;
    private String mProgressMsg;

    public ProgressSubscriber(SubscriberOnNextListener mSubscriberOnNextListener, Context mContext, String... progressMsgs) {
        this.mSubscriberOnNextListener = mSubscriberOnNextListener;
        this.mContext = mContext;
        mProgressMsg = progressMsgs.length > 0 ? progressMsgs[0] : Constants.PROGRESS_MESSAGE;
        mProgressDialogHandler = new ProgressDialogHandler(mContext, this, true, mProgressMsg);
    }

    private void showProgressDialog() {
        if (mProgressDialogHandler != null)
            mProgressDialogHandler.obtainMessage(ProgressDialogHandler.SHOW_PROGRESS_DIALOG).sendToTarget();
    }

    private void dismissProgressDialog() {
        if (mProgressDialogHandler != null) {
            mProgressDialogHandler.obtainMessage(ProgressDialogHandler.DISMISS_PROGRESS_DIALOG).sendToTarget();
            mProgressDialogHandler = null;
        }
    }

    @Override
    public void onStart() {
        showProgressDialog();
    }

    @Override
    public void onCancelProgress() {
        if (!this.isUnsubscribed())
            this.unsubscribe();
    }

    @Override
    public void onCompleted() {
        dismissProgressDialog();
//        Toast.makeText(mContext, "Get Info Conpleted", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onError(Throwable throwable) {
        dismissProgressDialog();
        Util.showDebugToast(mContext,"error:" + throwable.getMessage());
    }

    @Override
    public void onNext(T t) {
        mSubscriberOnNextListener.onNext(t);
    }
}
