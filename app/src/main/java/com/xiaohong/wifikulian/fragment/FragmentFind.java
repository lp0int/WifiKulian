package com.xiaohong.wifikulian.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xiaohong.wifikulian.Constants;
import com.xiaohong.wifikulian.Interface.SubscriberOnNextListener;
import com.xiaohong.wifikulian.R;
import com.xiaohong.wifikulian.Variable;
import com.xiaohong.wifikulian.adapter.FragmentTestPageAdapter;
import com.xiaohong.wifikulian.base.BaseFragment;
import com.xiaohong.wifikulian.models.AdOrdersBean;
import com.xiaohong.wifikulian.models.GetTabListBean;
import com.xiaohong.wifikulian.utils.NetworkRequestMethods2;
import com.xiaohong.wifikulian.utils.NetworkRequestMethods3;
import com.xiaohong.wifikulian.utils.ProgressSubscriber;

/**
 * Created by Lpoint on 2017/1/26.
 */

public class FragmentFind extends BaseFragment {
    private SubscriberOnNextListener<AdOrdersBean> getTabListListener;

    private ViewPager mViewPager;
    private TabLayout mTabLayout;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_find, container, false);

        mViewPager = (ViewPager) view.findViewById(R.id.viewpage);

        mTabLayout = (TabLayout) view.findViewById(R.id.tablayout);
        mTabLayout.setupWithViewPager(mViewPager);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initRequestListener();
        NetworkRequestMethods3.getInstance().getTabList(new ProgressSubscriber<AdOrdersBean>(getTabListListener, getActivity(), "数据请求中，请稍等..."),
                Constants.AD_TYPE_GET_FIND_TAB_LIST, Constants.AD_ADVERTISING_GET_FIND_TAB_LIST);
    }

    private void initRequestListener() {
        getTabListListener = new SubscriberOnNextListener<AdOrdersBean>() {
            @Override
            public void onNext(AdOrdersBean bean) {
                Variable.tabListBean = bean;
                FragmentTestPageAdapter mFragmentPagerAdapter = new FragmentTestPageAdapter(FragmentFind.this.getActivity().getSupportFragmentManager(), FragmentFind.this.getActivity());
                mViewPager.setAdapter(mFragmentPagerAdapter);
                mViewPager.setOffscreenPageLimit(Variable.tabListBean.getAdOrder().size());
                if (Variable.tabListBean.getAdOrder().size() <= 3)
                    mTabLayout.setTabMode(TabLayout.MODE_FIXED);
                else
                    mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
            }
        };
    }
}
