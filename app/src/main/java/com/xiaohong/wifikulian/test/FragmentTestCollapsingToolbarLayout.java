package com.xiaohong.wifikulian.test;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;

import com.xiaohong.wifikulian.R;
import com.xiaohong.wifikulian.base.BaseFragment;

/**
 * Created by Lpoint on 2017/3/9 18:11.
 */

public class FragmentTestCollapsingToolbarLayout extends BaseFragment {
    Toolbar toolbar;
    LinearLayout headLayout;
    CollapsingToolbarLayout collapsingToolbarLayout;
    CoordinatorLayout coordinatorLayout;
    AppBarLayout appBarLayout;
    WebView mWebView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.test_fragment_collapsing, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        headLayout = (LinearLayout) view.findViewById(R.id.head_layout);
        collapsingToolbarLayout = (CollapsingToolbarLayout) view.findViewById(R.id.collapsingToolbarLayout);
        coordinatorLayout = (CoordinatorLayout) view.findViewById(R.id.coordinator_Layout);
        appBarLayout = (AppBarLayout)view.findViewById(R.id.app_bar_layout);
        setTitleToCollapsingToolbarLayout();
    }
    /**
     * 使用CollapsingToolbarLayout必须把title设置到CollapsingToolbarLayout上，
     * 设置到Toolbar上则不会显示
     */
    private void setTitleToCollapsingToolbarLayout() {
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (verticalOffset <= -headLayout.getHeight() / 2) {
                    collapsingToolbarLayout.setTitle("测试标题");
                    //使用下面两个CollapsingToolbarLayout的方法设置展开透明->折叠时你想要的颜色
                    collapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(android.R.color.transparent));
                    collapsingToolbarLayout.setCollapsedTitleTextColor(getResources().getColor(R.color.black));
                } else {
                    collapsingToolbarLayout.setTitle("");
                }
            }
        });
    }

}
