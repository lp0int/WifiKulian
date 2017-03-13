package com.xiaohong.wifikulian.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaohong.wifikulian.Interface.RecommendItemClickListener;
import com.xiaohong.wifikulian.R;
import com.xiaohong.wifikulian.Variable;
import com.xiaohong.wifikulian.utils.Util;

/**
 * Created by Lpoint on 2017/3/13 10:29.
 */

public class GalleryFunctionAdapter extends RecyclerView.Adapter<GalleryFunctionAdapter.GalleryFunctionViewHolder> {
    private Context mContext;

    public GalleryFunctionAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public GalleryFunctionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        GalleryFunctionAdapter.GalleryFunctionViewHolder holder = new GalleryFunctionAdapter.GalleryFunctionViewHolder(LayoutInflater.from(
                mContext).inflate(R.layout.item_adapter_gallery_function, parent,
                false));
        return holder;
    }

    @Override
    public void onBindViewHolder(GalleryFunctionViewHolder holder, int position) {
        try {
            holder.imgGalleryFunction.setImageURI(Variable.galleryFunctionList.getAdOrder().get(position).getPic1());
            holder.txtGalleryFunction.setText(Variable.galleryFunctionList.getAdOrder().get(position).getName());
        } catch (Exception e) {

        }
    }

    @Override
    public int getItemCount() {
        try {
            return Variable.galleryFunctionList.getAdOrder().size();
        } catch (Exception e) {
            return 0;
        }

    }

    class GalleryFunctionViewHolder extends RecyclerView.ViewHolder {
        private SimpleDraweeView imgGalleryFunction;
        private TextView txtGalleryFunction;

        public GalleryFunctionViewHolder(View view) {
            super(view);
            imgGalleryFunction = (SimpleDraweeView) view.findViewById(R.id.img_gallery_function);
            txtGalleryFunction = (TextView) view.findViewById(R.id.txt_gallery_function);
        }
    }
}
