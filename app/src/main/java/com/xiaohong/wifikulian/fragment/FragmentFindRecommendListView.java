package com.xiaohong.wifikulian.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xiaohong.wifikulian.Interface.SubscriberOnNextListener;
import com.xiaohong.wifikulian.R;
import com.xiaohong.wifikulian.Variable;
import com.xiaohong.wifikulian.adapter.RecommendListAdapter;
import com.xiaohong.wifikulian.base.BaseFragment;
import com.xiaohong.wifikulian.models.RecommendListBean;
import com.xiaohong.wifikulian.utils.NetworkRequestMethods3;
import com.xiaohong.wifikulian.utils.ProgressSubscriber;
import com.xiaohong.wifikulian.utils.Utils;

/**
 * Created by Lpoint on 2017/2/7 18:34.
 */

public class FragmentFindRecommendListView extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private RecyclerView mRecyclerView;
    private SubscriberOnNextListener getRecommendListListener;
    private RecommendListAdapter mRecommendListAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fing_recommend_listview, null);
        initView(view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();
    }

    private void initView(View view) {
        mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh_widget);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.list);
        mSwipeRefreshLayout.setColorSchemeResources(
                android.R.color.holo_blue_light,
                android.R.color.holo_green_light,
                android.R.color.holo_red_light);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    private void initData() {
        initRequestListener();
        mRecommendListAdapter = new RecommendListAdapter(getActivity());
        mRecyclerView.setAdapter(mRecommendListAdapter);
        onRefresh();
    }

    @Override
    public void onRefresh() {
        NetworkRequestMethods3.getInstance().getRecommendList(new ProgressSubscriber<RecommendListBean>(getRecommendListListener, getActivity(), "null"), "YtNJ1qw9ZM/1MivnQSG+1JHBZ3K5i6zcp+rrD2wVpz5/T+WdePzoLqCaH8yfkmy/RC3FFGw3mM8C4kjCAnAJTg==");
    }

    private void initRequestListener() {
        getRecommendListListener = new SubscriberOnNextListener<RecommendListBean>() {
            @Override
            public void onNext(RecommendListBean recommendListBean) {
                Variable.recommendListBean = recommendListBean;
                mSwipeRefreshLayout.setRefreshing(false);
                mRecommendListAdapter.notifyDataSetChanged();
            }
        };
    }


}
