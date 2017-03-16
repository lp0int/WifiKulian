package com.xiaohong.wifikulian.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.xiaohong.wifikulian.Variable;
import com.xiaohong.wifikulian.fragment.FragmentFindPageTest;
import com.xiaohong.wifikulian.fragment.FragmentFindRecommendListView;
import com.xiaohong.wifikulian.fragment.FragmentWebView;

/**
 * Created by Lpoint on 2017/2/6 10:57.
 */

public class FragmentTestPageAdapter extends FragmentPagerAdapter {
    public final int COUNT;
    private String[] titles;
    private Context context;

    public FragmentTestPageAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
        titles = new String[Variable.tabListBean.getAdOrder().size()];
        COUNT = Variable.tabListBean.getAdOrder().size();
        initTitles();
    }

    @Override
    public Fragment getItem(int position) {
        if(Variable.tabListBean.getAdOrder().get(position).getUrl().startsWith("http"))
            return FragmentWebView.getInstance(Variable.tabListBean.getAdOrder().get(position).getUrl());
        if(Variable.tabListBean.getAdOrder().get(position).getUrl().startsWith("Native"))
            return new FragmentFindRecommendListView();
        return FragmentFindPageTest.newInstance(position + 1);
    }

    @Override
    public int getCount() {
        return COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }

    private void initTitles() {
        for (int i = 0 ; i < Variable.tabListBean.getAdOrder().size() ; i++){
            titles[i] = Variable.tabListBean.getAdOrder().get(i).getName();
        }
    }
}
