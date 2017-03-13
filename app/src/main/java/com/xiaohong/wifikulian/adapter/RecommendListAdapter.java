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

/**
 * Created by Lpoint on 2017/2/8 16:31.
 */

public class RecommendListAdapter extends RecyclerView.Adapter<RecommendListAdapter.RecommendViewHolder> {
    private Context mContext;
    private RecommendItemClickListener mRecommendItemClickListener;

    public RecommendListAdapter(Context context) {
        mContext = context;
    }

    @Override
    public RecommendViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecommendListAdapter.RecommendViewHolder holder = new RecommendListAdapter.RecommendViewHolder(LayoutInflater.from(
                mContext).inflate(R.layout.item_adapter_recommend_list, parent,
                false), mRecommendItemClickListener);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecommendViewHolder holder, int position) {
        try {
            holder.txtTitle.setText(Variable.recommendListBean.getAppList().get(position).getName());
            holder.imgIcon.setImageURI(Variable.recommendListBean.getAppList().get(position).getLogo());
            holder.txtGetCoin.setText("+" + Variable.recommendListBean.getAppList().get(position).getGold());
            holder.txtSize.setText(Variable.recommendListBean.getAppList().get(position).getSize());
            holder.txtSummary.setText(Variable.recommendListBean.getAppList().get(position).getSummary());
        } catch (Exception e) {
            holder.txtTitle.setText("Exception");
        }
    }

    @Override
    public int getItemCount() {
        try {
            return Variable.recommendListBean.getAppList().size();
        } catch (Exception e) {
            return 0;
        }
    }

    public void setOnItemClickListener(RecommendItemClickListener listener) {
        this.mRecommendItemClickListener = listener;
    }

    class RecommendViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView txtTitle;
        TextView txtSummary;
        TextView txtSize;
        TextView txtGetCoin;
        SimpleDraweeView imgIcon;
        RecommendItemClickListener mOnClickListener;

        public RecommendViewHolder(View view, RecommendItemClickListener mOnClickListener) {
            super(view);
            txtTitle = (TextView) view.findViewById(R.id.txt_title);
            txtSummary = (TextView) view.findViewById(R.id.txt_summary);
            txtSize = (TextView) view.findViewById(R.id.txt_size);
            txtGetCoin = (TextView) view.findViewById(R.id.txt_get_coin);
            imgIcon = (SimpleDraweeView) view.findViewById(R.id.img_icon);
            this.mOnClickListener = mOnClickListener;
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mOnClickListener != null)
                mOnClickListener.onItemClick(v, getPosition());
        }
    }
}
