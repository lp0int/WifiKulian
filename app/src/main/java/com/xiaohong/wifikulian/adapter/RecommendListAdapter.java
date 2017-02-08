package com.xiaohong.wifikulian.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xiaohong.wifikulian.R;
import com.xiaohong.wifikulian.Variable;
import com.xiaohong.wifikulian.fragment.FragmentFindRecommendListView;

import org.w3c.dom.Text;

/**
 * Created by Lpoint on 2017/2/8 16:31.
 */

public class RecommendListAdapter extends RecyclerView.Adapter<RecommendListAdapter.RecommendViewHolder> {
    private Context mContext;

    public RecommendListAdapter(Context context) {
        mContext = context;
    }

    @Override
    public RecommendViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecommendListAdapter.RecommendViewHolder holder = new RecommendListAdapter.RecommendViewHolder(LayoutInflater.from(
                mContext).inflate(R.layout.item_adapter_recommend_list, parent,
                false));
        return holder;
    }

    @Override
    public void onBindViewHolder(RecommendViewHolder holder, int position) {
        try {
            holder.txt.setText(Variable.recommendListBean.getAppList().get(position).getName());
        }catch (Exception e){
            holder.txt.setText("Exception");
        }
    }

    @Override
    public int getItemCount() {
        try {
            return Variable.recommendListBean.getAppList().size();
        }catch (Exception e){
            return 0;
        }
    }

    class RecommendViewHolder extends RecyclerView.ViewHolder {
        TextView txt;

        public RecommendViewHolder(View view) {
            super(view);
            txt = (TextView) view.findViewById(R.id.txt);
        }
    }
}
