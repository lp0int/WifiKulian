package com.xiaohong.wifikulian.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xiaohong.wifikulian.Interface.SubscriberOnNextListener;
import com.xiaohong.wifikulian.R;
import com.xiaohong.wifikulian.Variable;
import com.xiaohong.wifikulian.adapter.FragmentTestPageAdapter;
import com.xiaohong.wifikulian.base.BaseFragment;
import com.xiaohong.wifikulian.models.GetTabListBean;
import com.xiaohong.wifikulian.utils.NetworkRequestMethods2;
import com.xiaohong.wifikulian.utils.ProgressSubscriber;

/**
 * Created by Lpoint on 2017/1/26.
 */

public class FragmentFind extends BaseFragment {
    private SubscriberOnNextListener<GetTabListBean> getTabListListener;

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
//        FragmentTestPageAdapter mFragmentPagerAdapter = new FragmentTestPageAdapter(getActivity().getSupportFragmentManager(),getActivity());
//        viewPager.setAdapter(mFragmentPagerAdapter);

        mTabLayout = (TabLayout) view.findViewById(R.id.tablayout);
        mTabLayout.setupWithViewPager(mViewPager);
//        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initRequestListener();
        NetworkRequestMethods2.getInstance().getTabList(new ProgressSubscriber<GetTabListBean>(getTabListListener,getActivity(),"数据请求中，请稍等..."), Variable.userPhone);
    }

    private void initRequestListener(){
        getTabListListener = new SubscriberOnNextListener<GetTabListBean>() {
            @Override
            public void onNext(GetTabListBean bean) {
                Variable.tabListBean = bean;
                FragmentPagerAdapter mFragmentPagerAdapter = new FragmentTestPageAdapter(FragmentFind.this.getActivity().getSupportFragmentManager(),FragmentFind.this.getActivity());
                mViewPager.setAdapter(mFragmentPagerAdapter);
                mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
            }
        };
    }
}
