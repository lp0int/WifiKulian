package com.xiaohong.wifikulian.utils;

import android.content.Context;
import android.widget.Toast;

import com.xiaohong.wifikulian.Handler.ProgressDialogHandler;
import com.xiaohong.wifikulian.Interface.ProgressCancelListener;
import com.xiaohong.wifikulian.Interface.SubscriberOnNextListener;

import rx.Subscriber;

/**
 * Created by Lpoint on 2017/1/20 14:46.
 */

public class ProgressSubscriber<T> extends Subscriber<T> implements ProgressCancelListener {
    private SubscriberOnNextListener mSubscriberOnNextListener;
    private ProgressDialogHandler mProgressDialogHandler;
    private Context mContext;

    public ProgressSubscriber(SubscriberOnNextListener mSubscriberOnNextListener, Context mContext) {
        this.mSubscriberOnNextListener = mSubscriberOnNextListener;
        this.mContext = mContext;
        mProgressDialogHandler = new ProgressDialogHandler(mContext, this, true);
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
        Toast.makeText(mContext, "Get Info Conpleted", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onError(Throwable throwable) {
        dismissProgressDialog();
        Toast.makeText(mContext, "error:" + throwable.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNext(T t) {
        mSubscriberOnNextListener.onNext(t);
    }
}
