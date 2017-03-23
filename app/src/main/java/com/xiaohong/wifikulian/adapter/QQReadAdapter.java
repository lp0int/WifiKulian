package com.xiaohong.wifikulian.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaohong.wifikulian.Constants;
import com.xiaohong.wifikulian.R;
import com.xiaohong.wifikulian.Variable;
import com.xiaohong.wifikulian.activity.ActivityWebView;
import com.xiaohong.wifikulian.models.QQReadBean;

/**
 * Created by Lpoint on 2017/3/13 16:54.
 */

public class QQReadAdapter extends RecyclerView.Adapter<QQReadAdapter.QQReadViewHolder> {
    private Context mContext;
    private QQReadBean mQQReadBean;

    public QQReadAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setData(QQReadBean qqReadBean) {
        mQQReadBean = qqReadBean;
    }

    @Override
    public QQReadViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        QQReadViewHolder holder = new QQReadViewHolder(LayoutInflater.from(
                mContext).inflate(R.layout.item_adapter_qq_read, parent,
                false));
        return holder;
    }

    @Override
    public void onBindViewHolder(QQReadViewHolder holder, int position) {
        try {
            String bookCoverImg = mQQReadBean.getHotList().get(position).getCover();
            final String idSource = mQQReadBean.getHotList().get(position).getId();
            if (!bookCoverImg.endsWith(".jpg")) {
                String idStr = idSource.substring(idSource.length() - 3);
                int id = Integer.parseInt(idStr);
                bookCoverImg = "http://wfqqreader.3g.qq.com/cover/" + id + "/" + idSource + "/" + "b_"
                        + idSource + ".jpg";
            }
            holder.imgQQRead.setImageURI(bookCoverImg);
            holder.txtQQRead.setText(mQQReadBean.getHotList().get(position).getTitle());
            holder.imgQQRead.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    intent.setClass(mContext, ActivityWebView.class);
                    intent.putExtra(Constants.EXTERNAL_URL, Constants.QQREAD_BASE_IRL + idSource);
                    mContext.startActivity(intent);
                }
            });
        } catch (Exception e) {

        }
    }

    @Override
    public int getItemCount() {
        try {
            return mQQReadBean.getHotList().size();
        } catch (Exception e) {
            return 0;
        }

    }

    class QQReadViewHolder extends RecyclerView.ViewHolder {
        private SimpleDraweeView imgQQRead;
        private TextView txtQQRead;

        public QQReadViewHolder(View view) {
            super(view);
            imgQQRead = (SimpleDraweeView) view.findViewById(R.id.img_gallery_function);
            txtQQRead = (TextView) view.findViewById(R.id.txt_gallery_function);
        }
    }
}
