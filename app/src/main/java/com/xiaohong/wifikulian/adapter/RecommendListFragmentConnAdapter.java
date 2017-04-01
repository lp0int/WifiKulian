package com.xiaohong.wifikulian.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaohong.wifikulian.Constants;
import com.xiaohong.wifikulian.Interface.RecyclerviewItemClickListener;
import com.xiaohong.wifikulian.R;
import com.xiaohong.wifikulian.Variable;
import com.xiaohong.wifikulian.models.AdControlBean;

/**
 * Created by Lpoint on 2017/3/13 15:22.
 */

public class RecommendListFragmentConnAdapter extends RecyclerView.Adapter<RecommendListFragmentConnAdapter.RecommendListFragmentConnViewHolder> {
    private Context mContext;
    private RecyclerviewItemClickListener mRecommendItemClickListener;

    public RecommendListFragmentConnAdapter(Context context) {
        mContext = context;
    }

    @Override
    public RecommendListFragmentConnAdapter.RecommendListFragmentConnViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecommendListFragmentConnAdapter.RecommendListFragmentConnViewHolder holder = new RecommendListFragmentConnAdapter
                .RecommendListFragmentConnViewHolder(LayoutInflater.from(
                mContext).inflate(R.layout.item_adapter_recommend_task_fragment_conn, parent,
                false), mRecommendItemClickListener);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecommendListFragmentConnAdapter.RecommendListFragmentConnViewHolder holder, int position) {
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
            for (AdControlBean.ControlBean ControlBean : Variable.adControlBean.getControl()) {
                if (Constants.APPLIST.equals(ControlBean.getClass_name())) {
                    if (Integer.parseInt(ControlBean.getShow_time()) > Variable.recommendListBean.getAppList().size())
                        return Variable.recommendListBean.getAppList().size();
                    return Integer.parseInt(ControlBean.getShow_time());
                }
            }
            return 0;
        } catch (Exception e) {
            return 0;
        }
    }

    public void setOnItemClickListener(RecyclerviewItemClickListener listener) {
        this.mRecommendItemClickListener = listener;
    }

    class RecommendListFragmentConnViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView txtTitle;
        TextView txtSummary;
        TextView txtSize;
        TextView txtGetCoin;
        SimpleDraweeView imgIcon;
        RecyclerviewItemClickListener mOnClickListener;

        public RecommendListFragmentConnViewHolder(View view, RecyclerviewItemClickListener mOnClickListener) {
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
