package com.xiaohong.wifikulian.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaohong.wifikulian.Constants;
import com.xiaohong.wifikulian.Interface.AppBarStateChangeListener;
import com.xiaohong.wifikulian.Interface.RecommendItemClickListener;
import com.xiaohong.wifikulian.Interface.SubscriberOnNextListener;
import com.xiaohong.wifikulian.R;
import com.xiaohong.wifikulian.Variable;
import com.xiaohong.wifikulian.activity.ActivityWebView;
import com.xiaohong.wifikulian.adapter.BannerAdapter;
import com.xiaohong.wifikulian.adapter.GalleryFunctionAdapter;
import com.xiaohong.wifikulian.adapter.QQReadAdapter;
import com.xiaohong.wifikulian.adapter.RecommendListFragmentConnAdapter;
import com.xiaohong.wifikulian.base.BaseFragment;
import com.xiaohong.wifikulian.models.AdControlBean;
import com.xiaohong.wifikulian.models.AdOrdersBean;
import com.xiaohong.wifikulian.models.LoginBean;
import com.xiaohong.wifikulian.models.QQReadBean;
import com.xiaohong.wifikulian.models.RecommendListBean;
import com.xiaohong.wifikulian.utils.NetworkRequestMethods1;
import com.xiaohong.wifikulian.utils.NetworkRequestMethods3;
import com.xiaohong.wifikulian.utils.PhoneInfo;
import com.xiaohong.wifikulian.utils.ProgressSubscriber;
import com.xiaohong.wifikulian.utils.SharedPreferencesUtils;
import com.xiaohong.wifikulian.utils.Utils;
import com.xiaohong.wifikulian.utils.view.AutoScrollTextView;
import com.xiaohong.wifikulian.utils.view.NetworkRequestMethods;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by Lpoint on 2017/1/26.
 */

/**
 * @time:2017-3-13 原本NestedScrollView嵌套RecycleView，会是的NestedScrollView滑动失去惯性，使用setNestedScrollingEnabled(false)
 * 来恢复惯性，但是目前还存在卡顿的问题
 */

public class FragmentConn extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener, RecommendItemClickListener,
        ViewPager.OnPageChangeListener, View.OnTouchListener, View.OnClickListener {
    private AppBarLayout mAppBarLayout;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private CollapsingToolbarLayout mCollapsingToolbarLayout;
    private Toolbar mToolbar;
    private AppBarStateChangeListener mAppBarStateChangeListener;
    private TextView txtConnCurrentSsid;
    private TextView txtSurplusCoin, txtSurplusTime, txtRead;
    private AutoScrollTextView txtScrollMsg;
    private RecyclerView galleryFunction, recommendTask, qqReadList;
    private SubscriberOnNextListener getBannerListListener, getGalleryFunctionListListener, getRecommendTaskListListener,
            getAdControlListener, getQQReadListListener, getScrollMsgListener, loginListener;
    private GalleryFunctionAdapter mGalleryFunctionAdapter;
    private RecommendListFragmentConnAdapter mRecommendListFragmentConnAdapter;
    private QQReadAdapter mQQReadAdapter;
    /**
     * Banner相关
     */
    private ViewPager viewpagerBanner;
    private List<SimpleDraweeView> mList;
    private LinearLayout linPoints;
    private BannerAdapter mBannerAdapter;
    private int pointIndex = 0;
    private Observable bannerObservable;
    private View pointView;
    private LinearLayout.LayoutParams pointParams;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_conn, container, false);
        initRequestListener();
        if (Variable.loginBean == null) {
            if (SharedPreferencesUtils.getBooleanValue(getActivity(), Constants.LOGIN_STATUS, Constants.AUTO_LOGIN, false)) {
                reLogin();
            }
            return view;
        }
        initView(view);
        initData();
        onRefresh();
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
        txtRead = (TextView) view.findViewById(R.id.txt_read);
        txtScrollMsg = (AutoScrollTextView) view.findViewById(R.id.txt_scroll_msg);
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
        txtConnCurrentSsid = (TextView) view.findViewById(R.id.txt_conn_current_ssid);
        txtSurplusCoin = (TextView) view.findViewById(R.id.txt_surplus_coin);
        txtSurplusTime = (TextView) view.findViewById(R.id.txt_surplus_time);
        galleryFunction = (RecyclerView) view.findViewById(R.id.gallery_function);
        recommendTask = (RecyclerView) view.findViewById(R.id.list_recommend_task);
        qqReadList = (RecyclerView) view.findViewById(R.id.list_qq_read);
        //初始化Banner相关
        viewpagerBanner = (ViewPager) view.findViewById(R.id.viewpage_banner);
        linPoints = (LinearLayout) view.findViewById(R.id.points);
    }

    private void initData() {
        txtRead.setOnClickListener(this);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        txtConnCurrentSsid.setText(PhoneInfo.SSID());
        txtSurplusCoin.setText(getContext().getResources().getString(R.string.surplus_coin) + "" + Variable.loginBean.getCoin_num());
        txtSurplusTime.setText(getContext().getResources().getString(R.string.surplus_time) + Utils.formatSurplusTime(Variable.loginBean.getRemain_time()));
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
        viewpagerBanner.setOnTouchListener(this);
        handlerIntervalBanerSwitch();
    }

    @Override
    public void onRefresh() {
        NetworkRequestMethods3.getInstance().getAdOrder(new ProgressSubscriber<AdOrdersBean>(getScrollMsgListener, getActivity(),
                        Constants.GET_SCROLL_MSG_PROGRESS_MESSAGE),
                Constants.AD_TYPE_GET_SCROLL_MSG, Constants.AD_ADVERTISING_GET_SCROLL_MSG);
        mSwipeRefreshLayout.setRefreshing(false);
    }

    private void initRequestListener() {
        loginListener = new SubscriberOnNextListener<LoginBean>() {
            @Override
            public void onNext(LoginBean loginBean) {
                if (loginBean.getRet_code() == 0) {
                    Variable.loginBean = loginBean;
                    initData();
                    onRefresh();
                } else {
                    Intent i = getActivity().getPackageManager()
                            .getLaunchIntentForPackage(getActivity().getPackageName());
                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    getActivity().startActivity(i);
                }

            }
        };

        getScrollMsgListener = new SubscriberOnNextListener<AdOrdersBean>() {
            @Override
            public void onNext(AdOrdersBean adOrdersBean) {
                Variable.scrollMsgList = adOrdersBean;
                initScrollMsg();
                NetworkRequestMethods3.getInstance().getAdOrder(new ProgressSubscriber<AdOrdersBean>(getBannerListListener, getActivity(),
                                Constants.GET_BANNER_PROGRESS_MESSAGE),
                        Constants.AD_TYPE_GET_BANNER, Constants.AD_ADVERTISING_GET_BANNER);
            }
        };

        getBannerListListener = new SubscriberOnNextListener<AdOrdersBean>() {
            @Override
            public void onNext(AdOrdersBean bannerList) {
                Variable.bannerList = bannerList;
                initBannerAction();
                NetworkRequestMethods3.getInstance().getAdOrder(new ProgressSubscriber<AdOrdersBean>(getGalleryFunctionListListener, getActivity(),
                                Constants.GET_GALLERY_FUNCTION_PROGRESS_MESSAGE),
                        Constants.AD_TYPE_GET_GALLERY_FUNCTION, Constants.AD_ADVERTISING_GET_GALLERY_FUNCTION);
            }
        };
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
        Variable.clickH5TaskId = Variable.recommendListBean.getAppList().get(position).getId();
        Intent intent = new Intent();
        intent.setClass(getActivity(), ActivityWebView.class);
        intent.putExtra(Constants.EXTERNAL_URL, Variable.recommendListBean.getAppList().get(position).getUrl());
        startActivity(intent);
    }

    private void initScrollMsg() {
        txtScrollMsg.setText("");
        for (AdOrdersBean.AdOrderBean adOrderbean :
                Variable.scrollMsgList.getAdOrder()) {
            if (Variable.scrollMsgList.getAdOrder().size() != 0) {
                txtScrollMsg.setText(txtScrollMsg.getText() + adOrderbean.getContent() + "                            ");
            }
        }
    }

    private void initBannerAction() {
        linPoints.removeAllViews();
        mList = new ArrayList<SimpleDraweeView>();
        for (int i = 0; i < Variable.bannerList.getAdOrder().size(); i++) {
            //设置Banner图片
            SimpleDraweeView simpleDraweeView = new SimpleDraweeView(getActivity());
            simpleDraweeView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT));
            simpleDraweeView.setImageURI(Variable.bannerList.getAdOrder().get(i).getPic1());
            mList.add(simpleDraweeView);
            //设置point
            pointView = new View(getActivity());
            pointParams = new LinearLayout.LayoutParams(Utils.dip2px(getActivity(), 6f), Utils.dip2px(getActivity(), 6f));
            pointParams.leftMargin = 10;
            pointView.setBackgroundResource(R.drawable.point_bg);
            pointView.setLayoutParams(pointParams);
            pointView.setEnabled(false);
            linPoints.addView(pointView);
        }
        mBannerAdapter = new BannerAdapter(mList);
        viewpagerBanner.setAdapter(mBannerAdapter);

        viewpagerBanner.setOnPageChangeListener(this);
        viewpagerBanner.setCurrentItem(0);
        pointIndex = 0;
        linPoints.getChildAt(pointIndex).setEnabled(true);
    }

    private void handlerIntervalBanerSwitch() {
        bannerObservable = Observable.interval(Constants.BANNER_SWITCH_INTERVAL, TimeUnit.SECONDS);
        bannerObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1() {
                    @Override
                    public void call(Object o) {
                        if (Variable.bannerList != null) {
                            viewpagerBanner.setCurrentItem((viewpagerBanner.getCurrentItem() + 1) % Variable.bannerList.getAdOrder().size());
                        }
                    }
                });
    }

    @Override
    protected void onAppBusEvent(int code, Bundle data) {
        switch (code) {
            case Constants.CODE_CHANGE_NETWORK_STATUS:
                int networkType = data.getInt(Constants.WIFI_STATUS_CODE);
                switch (networkType) {
                    case Constants.NETWORK_TYPE_OTHER_WIFI:
                        txtConnCurrentSsid.setText(PhoneInfo.SSID());
                        break;
                    case Constants.NETWORK_TYPE_CELLULAR:
                        txtConnCurrentSsid.setText(Constants.CELLULAR_NETWORK);
                        break;
                    case Constants.NETWORK_TYPE_HONGWIFI_UNVERIFY:
                        txtConnCurrentSsid.setText("未认证网络");
                        break;
                    case Constants.NETWORK_TYPE_HONGWIFI_VERIFIED:
                        txtConnCurrentSsid.setText(PhoneInfo.SSID());
                        break;
                    case Constants.NETWORK_TYPE_NO_NETWORK:
                        txtConnCurrentSsid.setText(Constants.CELLULAR_NO_NETWORK);
                        break;
                    default:
                        break;
                }
                break;
            default:
                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        int newPosition = position % Variable.bannerList.getAdOrder().size();
        linPoints.getChildAt(newPosition).setEnabled(true);
        linPoints.getChildAt(pointIndex).setEnabled(false);
        pointIndex = newPosition;
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        Log.i("info", state + "");
    }

    @Override
    public void onDestroy() {
        if (bannerObservable != null)
            super.onDestroy();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (v.getId()) {
            case R.id.viewpage_banner:
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    mSwipeRefreshLayout.setEnabled(true);
                } else {
                    mSwipeRefreshLayout.setEnabled(false);
                }
                break;
            default:
                break;
        }
        return false;
    }

    private void reLogin() {
        String strUserName = SharedPreferencesUtils.getStringValue(getActivity(), Constants.LOGIN_STATUS, Constants.USER_NAME, "null");
        String strPwd = SharedPreferencesUtils.getStringValue(getActivity(), Constants.LOGIN_STATUS, Constants.PASSWORD, "null");
        Variable.userPhone = strUserName;
        NetworkRequestMethods1.getInstance().login(new ProgressSubscriber<LoginBean>(loginListener, getActivity(), "努力登陆中..."), strUserName, strPwd, getActivity());
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.txt_read:
                Intent intent = new Intent();
                intent.setClass(getContext(), ActivityWebView.class);
                intent.putExtra(Constants.EXTERNAL_URL, Constants.QQREAD_URL_WITH_CID);
                getContext().startActivity(intent);
                break;
            default:
                break;
        }
    }
}
