package com.xiaohong.wifikulian.fragment;

import android.content.Intent;
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
import android.widget.AdapterView;
import android.widget.TextView;

import com.xiaohong.wifikulian.Constants;
import com.xiaohong.wifikulian.Interface.AppBarStateChangeListener;
import com.xiaohong.wifikulian.Interface.RecommendItemClickListener;
import com.xiaohong.wifikulian.Interface.SubscriberOnNextListener;
import com.xiaohong.wifikulian.R;
import com.xiaohong.wifikulian.Variable;
import com.xiaohong.wifikulian.activity.ActivityWevView;
import com.xiaohong.wifikulian.adapter.GalleryFunctionAdapter;
import com.xiaohong.wifikulian.adapter.QQReadAdapter;
import com.xiaohong.wifikulian.adapter.RecommendListFragmentConnAdapter;
import com.xiaohong.wifikulian.base.BaseFragment;
import com.xiaohong.wifikulian.models.AdControlBean;
import com.xiaohong.wifikulian.models.AdOrdersBean;
import com.xiaohong.wifikulian.models.QQReadBean;
import com.xiaohong.wifikulian.models.RecommendListBean;
import com.xiaohong.wifikulian.utils.EncodeParameter;
import com.xiaohong.wifikulian.utils.NetworkRequestMethods3;
import com.xiaohong.wifikulian.utils.PhoneInfo;
import com.xiaohong.wifikulian.utils.ProgressSubscriber;
import com.xiaohong.wifikulian.utils.Util;
import com.xiaohong.wifikulian.utils.view.NetworkRequestMethods;

/**
 * Created by Lpoint on 2017/1/26.
 */

/**
 * @time:2017-3-13 原本NestedScrollView嵌套RecycleView，会是的NestedScrollView滑动失去惯性，使用setNestedScrollingEnabled(false)
 * 来恢复惯性，但是目前还存在卡顿的问题
 */

public class FragmentConn extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener, RecommendItemClickListener {
    private AppBarLayout mAppBarLayout;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private CollapsingToolbarLayout mCollapsingToolbarLayout;
    private Toolbar mToolbar;
    private AppBarStateChangeListener mAppBarStateChangeListener;
    private TextView txtConnCurrentSsid;
    private TextView txtSurplusCoin, txtSurplusTime;
    private RecyclerView galleryFunction, recommendTask, qqReadList;
    private SubscriberOnNextListener getGalleryFunctionListListener;
    private SubscriberOnNextListener getRecommendTaskListListener;
    private SubscriberOnNextListener getAdControlListener;
    private SubscriberOnNextListener getQQReadListListener;
    private GalleryFunctionAdapter mGalleryFunctionAdapter;
    private RecommendListFragmentConnAdapter mRecommendListFragmentConnAdapter;
    private QQReadAdapter mQQReadAdapter;


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
        recommendTask = (RecyclerView) view.findViewById(R.id.list_recommend_task);
        qqReadList = (RecyclerView) view.findViewById(R.id.list_qq_read);
    }

    private void initData() {
        mGalleryFunctionAdapter = new GalleryFunctionAdapter(getContext());
        mRecommendListFragmentConnAdapter = new RecommendListFragmentConnAdapter(getContext());
        mQQReadAdapter = new QQReadAdapter(getActivity());
        mRecommendListFragmentConnAdapter.setOnItemClickListener(this);
        LinearLayoutManager galleryLayoutManager = new LinearLayoutManager(getActivity());
        galleryLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        galleryFunction.setLayoutManager(galleryLayoutManager);
        galleryFunction.setNestedScrollingEnabled(false);
        galleryFunction.setAdapter(mGalleryFunctionAdapter);
        LinearLayoutManager recommendTaskLayoutManager = new LinearLayoutManager(getActivity());
        recommendTaskLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recommendTask.setLayoutManager(recommendTaskLayoutManager);
        recommendTask.setNestedScrollingEnabled(false);
        recommendTask.setAdapter(mRecommendListFragmentConnAdapter);
        LinearLayoutManager qqReadLayoutManager = new LinearLayoutManager(getActivity());
        qqReadLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        qqReadList.setLayoutManager(qqReadLayoutManager);
        qqReadList.setNestedScrollingEnabled(false);
        qqReadList.setAdapter(mQQReadAdapter);

    }

    @Override
    public void onRefresh() {
        NetworkRequestMethods3.getInstance().getAdOrder(new ProgressSubscriber<AdOrdersBean>(getGalleryFunctionListListener, getActivity(),
                        Constants.GET_GALLERY_FUNCTION_PROGRESS_MESSAGE),
                Constants.AD_TYPE_GET_GALLERY_FUNCTION, Constants.AD_ADVERTISING_GET_GALLERY_FUNCTION);
        mSwipeRefreshLayout.setRefreshing(false);
    }

    private void initRequestListener() {
        getGalleryFunctionListListener = new SubscriberOnNextListener<AdOrdersBean>() {
            @Override
            public void onNext(AdOrdersBean galleryFunctionList) {
                Variable.galleryFunctionList = galleryFunctionList;
                mGalleryFunctionAdapter.notifyDataSetChanged();
                NetworkRequestMethods3.getInstance().getRecommendList(new ProgressSubscriber<RecommendListBean>(getRecommendTaskListListener, getActivity(),
                        Constants.GET_RECOMMEND_TASK_LIST_PROGRESS_MESSAGE));
            }
        };
        getRecommendTaskListListener = new SubscriberOnNextListener<RecommendListBean>() {
            @Override
            public void onNext(RecommendListBean recommendListBean) {
                Variable.recommendListBean = recommendListBean;
                NetworkRequestMethods3.getInstance().getAdControl(new ProgressSubscriber<AdControlBean>(getAdControlListener, getActivity(),
                        Constants.GET_RECOMMEND_TASK_LIST_PROGRESS_MESSAGE));
            }
        };
        getAdControlListener = new SubscriberOnNextListener<AdControlBean>() {
            @Override
            public void onNext(AdControlBean adControlBean) {
                Variable.adControlBean = adControlBean;
                mRecommendListFragmentConnAdapter.notifyDataSetChanged();
                NetworkRequestMethods.getInstance().getQQRead(new ProgressSubscriber<QQReadBean>(getQQReadListListener, getActivity(),
                        Constants.GET_QQ_READ_PROGRESS_MESSAGE));
            }
        };
        getQQReadListListener = new SubscriberOnNextListener<QQReadBean>() {
            @Override
            public void onNext(QQReadBean qqReadBean) {
                mQQReadAdapter.setData(qqReadBean);
                mQQReadAdapter.notifyDataSetChanged();
            }
        };
    }

    @Override
    public void onItemClick(View view, int position) {
        Intent intent = new Intent();
        intent.setClass(getActivity(), ActivityWevView.class);
        intent.putExtra(Constants.EXTERNAL_URL, Variable.recommendListBean.getAppList().get(position).getUrl());
        startActivity(intent);
    }
}
