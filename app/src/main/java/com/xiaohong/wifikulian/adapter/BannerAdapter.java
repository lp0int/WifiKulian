package com.xiaohong.wifikulian.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaohong.wifikulian.Variable;

import java.util.List;

/**
 * Created by Lpoint on 2017/3/20 16:40.
 */

public class BannerAdapter extends PagerAdapter {
    private List<SimpleDraweeView> mList;

    public BannerAdapter(List<SimpleDraweeView> list) {
        this.mList = list;
    }

    @Override
    public int getCount() {
        return Variable.bannerList.getAdOrder().size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ViewGroup parent = (ViewGroup) mList.get(position % mList.size()).getParent();
        if (parent != null) {
            parent.removeAllViews();
        }
        container.addView(mList.get(position % mList.size()));
        return mList.get(position % mList.size());
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(mList.get(position % mList.size()));
    }
}
