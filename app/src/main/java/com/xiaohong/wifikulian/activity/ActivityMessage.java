package com.xiaohong.wifikulian.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.xiaohong.wifikulian.Constants;
import com.xiaohong.wifikulian.Interface.SubscriberOnNextListener;
import com.xiaohong.wifikulian.R;
import com.xiaohong.wifikulian.Variable;
import com.xiaohong.wifikulian.adapter.MessageListAdapter;
import com.xiaohong.wifikulian.base.BaseActivity;
import com.xiaohong.wifikulian.models.AdOrdersBean;
import com.xiaohong.wifikulian.utils.NetworkRequestMethods3;
import com.xiaohong.wifikulian.utils.ProgressSubscriber;
import com.xiaohong.wifikulian.utils.Utils;

/**
 * Created by Lpoint on 2017/3/28 20:12.
 */

public class ActivityMessage extends BaseActivity implements View.OnClickListener, SwipeRefreshLayout.OnRefreshListener {
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private RecyclerView mRecyclerView;
    private SubscriberOnNextListener getMessageListListener;
    private ImageButton btnBack;
    private MessageListAdapter mMessageListAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.hideActiconBar(this);
        setContentView(R.layout.activity_message);
        initView();
        initData();
    }

    private void initView() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        TextView txtTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        txtTitle.setText("消息中心");
        btnBack = (ImageButton) toolbar.findViewById(R.id.btn_back);
        btnBack.setOnClickListener(this);
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh_widget);
        mRecyclerView = (RecyclerView) findViewById(R.id.list);
        mSwipeRefreshLayout.setColorSchemeResources(
                android.R.color.holo_blue_light,
                android.R.color.holo_green_light,
                android.R.color.holo_red_light);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    private void initData() {
        initRequestListener();
        mMessageListAdapter = new MessageListAdapter(this);
        mRecyclerView.setAdapter(mMessageListAdapter);
    }

    private void initRequestListener() {
        getMessageListListener = new SubscriberOnNextListener<AdOrdersBean>() {
            @Override
            public void onNext(AdOrdersBean adOrdersBean) {
                Variable.messageList = adOrdersBean;
                mMessageListAdapter.notifyDataSetChanged();
            }
            @Override
            public void onError(Throwable e) {

            }
        };
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                finish();
                break;
            default:
                break;
        }
    }

    @Override
    public void onRefresh() {
        NetworkRequestMethods3.getInstance().getAdOrder(new ProgressSubscriber<AdOrdersBean>(getMessageListListener, this, Constants.GET_MESSAGE_LIST_PROGRESS_MESSAGE)
                , Constants.AD_TYPE_GET_MESSAGE_LIST, Constants.AD_ADVERTISING_GET_MESSAGE_LIST);
        mSwipeRefreshLayout.setRefreshing(false);
    }
}
