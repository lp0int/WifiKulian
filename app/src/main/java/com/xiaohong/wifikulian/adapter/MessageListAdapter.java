package com.xiaohong.wifikulian.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.xiaohong.wifikulian.Interface.RecyclerviewItemClickListener;
import com.xiaohong.wifikulian.R;
import com.xiaohong.wifikulian.Variable;

/**
 * Created by Lpoint on 2017/3/29 16:37.
 */

public class MessageListAdapter extends RecyclerView.Adapter<MessageListAdapter.MessageListViewHolder>{
    private Context mContext;
    private RecyclerviewItemClickListener mMsgItemClickListener;

    public MessageListAdapter(Context context) {
        mContext = context;
    }

    @Override
    public MessageListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MessageListViewHolder holder = new MessageListViewHolder(LayoutInflater.from(mContext)
                .inflate(R.layout.item_adapter_message_list, parent, false), mMsgItemClickListener);
        return holder;
    }

    @Override
    public void onBindViewHolder(MessageListViewHolder holder, int position) {
        holder.txtMessage.setText(Variable.messageList.getAdOrder().get(position).getContent());
    }

    @Override
    public int getItemCount() {
        if (Variable.messageList == null) {
            return 0;
        }
        return Variable.messageList.getAdOrder().size();
    }

    public void setOnItemClickListener(RecyclerviewItemClickListener listener) {
        this.mMsgItemClickListener = listener;
    }

    class MessageListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView txtMessage;
        RelativeLayout relItem;
        RecyclerviewItemClickListener mItemClickListener;

        public MessageListViewHolder(View itemView, RecyclerviewItemClickListener itemClickListener) {
            super(itemView);
            txtMessage = (TextView) itemView.findViewById(R.id.txt_message);
            relItem = (RelativeLayout) itemView.findViewById(R.id.rel_item);
            this.mItemClickListener = itemClickListener;
            relItem.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mMsgItemClickListener != null)
                mMsgItemClickListener.onItemClick(v, getPosition());
        }
    }
}
