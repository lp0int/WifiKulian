package com.xiaohong.wifikulian.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xiaohong.wifikulian.Constants;
import com.xiaohong.wifikulian.Interface.AppBarStateChangeListener;
import com.xiaohong.wifikulian.Interface.SubscriberOnNextListener;
import com.xiaohong.wifikulian.R;
import com.xiaohong.wifikulian.Variable;
import com.xiaohong.wifikulian.adapter.GalleryFunctionAdapter;
import com.xiaohong.wifikulian.base.BaseFragment;
import com.xiaohong.wifikulian.models.AdOrdersBean;
import com.xiaohong.wifikulian.models.RecommendListBean;
import com.xiaohong.wifikulian.utils.NetworkRequestMethods3;
import com.xiaohong.wifikulian.utils.PhoneInfo;
import com.xiaohong.wifikulian.utils.ProgressSubscriber;
import com.xiaohong.wifikulian.utils.Util;

/**
 * Created by Lpoint on 2017/1/26.
 */

public class FragmentConn extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {
    private AppBarLayout mAppBarLayout;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private CollapsingToolbarLayout mCollapsingToolbarLayout;
    private Toolbar mToolbar;
    private AppBarStateChangeListener mAppBarStateChangeListener;
    private TextView txtConnCurrentSsid;
    private TextView txtSurplusCoin, txtSurplusTime;
    private RecyclerView galleryFunction;
    private SubscriberOnNextListener getGalleryFunctionListListener;
    private GalleryFunctionAdapter mGalleryFunctionAdapter;
    private SubscriberOnNextListener getRecommendTaskListListener;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_conn, container, false);
        initRequestListener();
        initView(view);
        initData();
        return view;
    }

    private void initView(View view) {
        mAppBarStateChangeListener = new AppBarStateChangeListener() {
            @Override
            public void onStateChanged(AppBarLayout appBarLayout, State state, int verticalOffset) {
                switch (state) {
                    case EXPANDED:
                        mSwipeRefreshLayout.setEnabled(true);
                        break;
                    case COLLAPSED:
                        mSwipeRefreshLayout.setEnabled(false);
                        break;
                    case IDLE:
                        break;
                }
            }
        };
        mToolbar = (Toolbar) view.findViewById(R.id.toolbar);
        mToolbar.setTitle("");
        ((AppCompatActivity) getContext()).setSupportActionBar(mToolbar);
        mAppBarLayout = (AppBarLayout) view.findViewById(R.id.app_bar);
        mAppBarLayout.addOnOffsetChangedListener(mAppBarStateChangeListener);
        mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh_widget);
        mSwipeRefreshLayout.setColorSchemeResources(
                android.R.color.holo_blue_light,
                android.R.color.holo_green_light,
                android.R.color.holo_red_light);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        txtConnCurrentSsid = (TextView) view.findViewById(R.id.txt_conn_current_ssid);
        txtConnCurrentSsid.setText(PhoneInfo.SSID());
        txtSurplusCoin = (TextView) view.findViewById(R.id.txt_surplus_coin);
        txtSurplusCoin.setText(getContext().getResources().getString(R.string.surplus_coin) + "" + Variable.loginBean.getCoin_num());
        txtSurplusTime = (TextView) view.findViewById(R.id.txt_surplus_time);
        txtSurplusTime.setText(getContext().getResources().getString(R.string.surplus_time) + Util.formatSurplusTime(Variable.loginBean.getRemain_time()));
        galleryFunction = (RecyclerView) view.findViewById(R.id.gallery_function);
    }

    private void initData() {
        mGalleryFunctionAdapter = new GalleryFunctionAdapter(getContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        galleryFunction.setLayoutManager(linearLayoutManager);
        galleryFunction.setAdapter(mGalleryFunctionAdapter);
    }

    @Override
    public void onRefresh() {
        NetworkRequestMethods3.getInstance().getAdOrder(new ProgressSubscriber<AdOrdersBean>(getGalleryFunctionListListener, getActivity(),
                        Constants.GET_GALLERY_FUNCTION_PROGRESS_MESSAGE),
                Constants.AD_TYPE_GET_GALLERY_FUNCTION, Constants.AD_ADVERTISING_GET_GALLERY_FUNCTION);
    }

    private void initRequestListener() {
        getGalleryFunctionListListener = new SubscriberOnNextListener<AdOrdersBean>() {
            @Override
            public void onNext(AdOrdersBean galleryFunctionList) {
                mSwipeRefreshLayout.setRefreshing(false);
                Variable.galleryFunctionList = galleryFunctionList;
                mGalleryFunctionAdapter.notifyDataSetChanged();
            }
        };
        getRecommendTaskListListener = new SubscriberOnNextListener<RecommendListBean>() {
            @Override
            public void onNext(RecommendListBean recommendListBean) {
                Variable.recommendListBean = recommendListBean;
            }
        };
    }
}
