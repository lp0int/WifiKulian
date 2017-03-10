package com.xiaohong.wifikulian.Interface;

import android.support.design.widget.AppBarLayout;

/**
 * Created by Lpoint on 2017/3/9 17:08.
 */
public abstract class AppBarStateChangeListener implements AppBarLayout.OnOffsetChangedListener {
    public enum State {
        EXPANDED,
        COLLAPSED,
        IDLE,
        HALFCOLLPASED
    }

    private State mCurrentState = State.IDLE;

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
        if (verticalOffset == 0) {
            if (mCurrentState != State.EXPANDED)
                onStateChanged(appBarLayout, State.EXPANDED,verticalOffset);
            mCurrentState = State.EXPANDED;
        } else if (Math.abs(verticalOffset) >= appBarLayout.getTotalScrollRange()) {
            if (mCurrentState != State.COLLAPSED)
                onStateChanged(appBarLayout, State.COLLAPSED,verticalOffset);
            mCurrentState = State.COLLAPSED;
        } else if (Math.abs(verticalOffset) >= appBarLayout.getTotalScrollRange() / 2) {
            if (mCurrentState != State.HALFCOLLPASED)
                onStateChanged(appBarLayout, State.HALFCOLLPASED,verticalOffset);
            mCurrentState = State.HALFCOLLPASED;
        } else {
            if (mCurrentState != State.IDLE)
                onStateChanged(appBarLayout, State.IDLE,verticalOffset);
            mCurrentState = State.IDLE;
        }
    }

    public abstract void onStateChanged(AppBarLayout appBarLayout, State state,int verticalOffset);
}