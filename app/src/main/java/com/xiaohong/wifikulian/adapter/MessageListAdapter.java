package com.xiaohong.wifikulian.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xiaohong.wifikulian.R;
import com.xiaohong.wifikulian.Variable;

/**
 * Created by Lpoint on 2017/3/29 16:37.
 */

public class MessageListAdapter extends RecyclerView.Adapter<MessageListAdapter.MessageListViewHolder> {
    private Context mContext;

    public MessageListAdapter(Context context) {
        mContext = context;
    }

    @Override
    public MessageListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MessageListViewHolder holder = new MessageListViewHolder(LayoutInflater.from(mContext)
                .inflate(R.layout.item_adapter_message_list, parent, false));
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

    class MessageListViewHolder extends RecyclerView.ViewHolder {
        TextView txtMessage;

        public MessageListViewHolder(View itemView) {
            super(itemView);
            txtMessage = (TextView) itemView.findViewById(R.id.txt_message);
        }
    }
}
