package com.xiaohong.wifikulian.activity;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.airbnb.lottie.LottieAnimationView;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.tencent.smtt.sdk.QbSdk;
import com.xiaohong.wifikulian.Constants;
import com.xiaohong.wifikulian.R;
import com.xiaohong.wifikulian.Variable;
import com.xiaohong.wifikulian.base.BaseActivity;

/**
 * Created by Lpoint on 2017/1/24.
 */

public class ActivitySplash extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Variable.BASECONTEXT = getBaseContext();
        Fresco.initialize(this);
        QbSdk.initX5Environment(this, null);
        initView();

    }

    private void initView(){
        LottieAnimationView animationView = (LottieAnimationView) findViewById(R.id.animation_view);
        animationView.addAnimatorListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Intent intent = new Intent();
                intent.setClass(ActivitySplash.this, ActivityLogin.class);
                startActivity(intent);
                finish();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }
}