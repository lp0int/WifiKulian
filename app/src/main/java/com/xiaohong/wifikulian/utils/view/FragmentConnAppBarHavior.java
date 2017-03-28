package com.xiaohong.wifikulian.utils.view;

import android.content.Context;
import android.net.Uri;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaohong.wifikulian.R;
import com.xiaohong.wifikulian.Variable;
import com.xiaohong.wifikulian.utils.Utils;

/**
 * Created by Lpoint on 2017/3/10 10:11.
 */

public class FragmentConnAppBarHavior extends CoordinatorLayout.Behavior<View> {
    private final float DEPENDENCY_Y_START_LOCATION_DP = 0f;
    private final float DEPENDENCY_Y_END_LOCATION_DP = -65f;
    private final float IMG_CONN_SUCCESS_X_START_LOCATION_DP = 85f;
    private final float IMG_CONN_SUCCESS_OVER_PADDING_DP = 7f;
    private final float IMG_CONN_SUCCESS_Y_START_LOCATION_DP = 35f;
    private final float IMG_CONN_SUCCESS_Y_END_LOCATION_DP = 0f;
    private final float IMG_CONN_SUCCESS_WIDTH_START_DP = 50f;
    private final float IMG_CONN_SUCCESS_WIDTH_END_DP = 16f;
    private final float IMG_CONN_SUCCESS_HEIGHT_START_DP = 50f;
    private final float IMG_CONN_SUCCESS_HEIGHT_END_DP = 16f;
    private Context mContext;
    private DisplayMetrics display;
    float ratioX;
    float ratioY;
    float ratioWidth;
    float ratioHeight;
    float ratioRelControlWidth;
    SimpleDraweeView imgConn;
    int relControlWidthOffset;

    public FragmentConnAppBarHavior(Context mContext, AttributeSet attrs) {
        super(mContext, attrs);
        display = mContext.getResources().getDisplayMetrics();
        mContext = mContext;
        int dependencyOffset = Utils.dip2px(Variable.BASECONTEXT, DEPENDENCY_Y_START_LOCATION_DP) - Utils.dip2px(Variable.BASECONTEXT, DEPENDENCY_Y_END_LOCATION_DP);
        int imgConnXOffset = Utils.dip2px(Variable.BASECONTEXT, IMG_CONN_SUCCESS_X_START_LOCATION_DP) - Utils.dip2px(Variable.BASECONTEXT, IMG_CONN_SUCCESS_OVER_PADDING_DP);
        int imgConnYOffset = Utils.dip2px(Variable.BASECONTEXT, IMG_CONN_SUCCESS_Y_START_LOCATION_DP + IMG_CONN_SUCCESS_HEIGHT_START_DP) - Utils.dip2px(Variable.BASECONTEXT,
                IMG_CONN_SUCCESS_Y_END_LOCATION_DP + (IMG_CONN_SUCCESS_HEIGHT_END_DP + IMG_CONN_SUCCESS_OVER_PADDING_DP));
        int imgConnWidthOffset = Utils.dip2px(Variable.BASECONTEXT, IMG_CONN_SUCCESS_WIDTH_START_DP) - Utils.dip2px(Variable.BASECONTEXT, IMG_CONN_SUCCESS_WIDTH_END_DP);
        int imgConnHeightOffset = Utils.dip2px(Variable.BASECONTEXT, IMG_CONN_SUCCESS_HEIGHT_START_DP) - Utils.dip2px(Variable.BASECONTEXT, IMG_CONN_SUCCESS_HEIGHT_END_DP);
        relControlWidthOffset = Utils.dip2px(Variable.BASECONTEXT, IMG_CONN_SUCCESS_WIDTH_END_DP + 2 * IMG_CONN_SUCCESS_OVER_PADDING_DP);
        ratioX = (float) imgConnXOffset / (float) dependencyOffset;
        ratioY = (float) imgConnYOffset / (float) dependencyOffset;
        ratioWidth = (float) imgConnWidthOffset / (float) dependencyOffset;
        ratioHeight = (float) imgConnHeightOffset / (float) dependencyOffset;
        ratioRelControlWidth = (float) relControlWidthOffset / (float) dependencyOffset;
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        return dependency instanceof AppBarLayout;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
        setImgConn(child, dependency);
        setTextAlpha(child, dependency);
        setControlWidth(child, dependency);
        return true;
    }

    private void setControlWidth(View child, View dependency) {
        LinearLayout relControl = (LinearLayout) ((AppBarLayout) dependency).findViewById(R.id.lin_control);
        float ratio = Math.abs((float) dependency.getTop()) / Math.abs((float) Utils.dip2px(Variable.BASECONTEXT, DEPENDENCY_Y_END_LOCATION_DP));
        CoordinatorLayout.MarginLayoutParams layoutParams = (CoordinatorLayout.MarginLayoutParams) relControl.getLayoutParams();
        layoutParams.leftMargin = (int) (relControlWidthOffset * ratio);
        relControl.setLayoutParams(layoutParams);
    }

    private void setTextAlpha(View child, View dependency) {
        TextView txtCurrentConn = (TextView) ((AppBarLayout) dependency).findViewById(R.id.txt_conn_current);
        TextView txtCurrentConnSsid = (TextView) ((AppBarLayout) dependency).findViewById(R.id.txt_conn_current_ssid);
        float ratio = Math.abs((float) dependency.getTop()) / Math.abs((float) Utils.dip2px(Variable.BASECONTEXT, DEPENDENCY_Y_END_LOCATION_DP));
        txtCurrentConn.setAlpha(1 - ratio);
        txtCurrentConnSsid.setAlpha(1 - ratio);
    }

    private void setImgConn(View child, View dependency) {
        imgConn = (SimpleDraweeView) ((AppBarLayout) dependency).findViewById(R.id.img_conn);
        float ratio = Math.abs((float) dependency.getTop()) / Math.abs((float) Utils.dip2px(Variable.BASECONTEXT, DEPENDENCY_Y_END_LOCATION_DP));
        Uri uriImagSuccBig = Uri.parse("res://com.xiaohong.wifikulian/" + R.mipmap.link_success);
        Uri uriImagSuccSmall = Uri.parse("res://com.xiaohong.wifikulian/" + R.mipmap.connection_success);
        if (ratio < 0.5) {
            imgConn.setImageURI(uriImagSuccBig);
        } else {
            imgConn.setImageURI(uriImagSuccSmall);
        }
        imgConn.setAlpha(2 * Math.abs(0.5f - ratio));
        float x = Utils.dip2px(Variable.BASECONTEXT, IMG_CONN_SUCCESS_X_START_LOCATION_DP) - -(dependency.getTop() * ratioX);
        float y = Utils.dip2px(Variable.BASECONTEXT, IMG_CONN_SUCCESS_Y_START_LOCATION_DP) - (dependency.getTop() * ratioY);
        float w = Utils.dip2px(Variable.BASECONTEXT, IMG_CONN_SUCCESS_WIDTH_START_DP) - -(dependency.getTop() * ratioWidth);
        float h = Utils.dip2px(Variable.BASECONTEXT, IMG_CONN_SUCCESS_HEIGHT_START_DP) - -(dependency.getTop() * ratioHeight);
        setPosition(imgConn, (int) x, (int) y, (int) w, (int) h);
    }

    private void setPosition(View v, int x, int y, int w, int h) {
        CoordinatorLayout.MarginLayoutParams layoutParams = (CoordinatorLayout.MarginLayoutParams) v.getLayoutParams();
        layoutParams.leftMargin = x;
        layoutParams.topMargin = y;
        layoutParams.width = w;
        layoutParams.height = h;
        v.setLayoutParams(layoutParams);
    }
}
