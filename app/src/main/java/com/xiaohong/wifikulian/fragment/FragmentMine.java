package com.xiaohong.wifikulian.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaohong.wifikulian.Constants;
import com.xiaohong.wifikulian.R;
import com.xiaohong.wifikulian.Variable;
import com.xiaohong.wifikulian.activity.ActivityMessage;
import com.xiaohong.wifikulian.activity.ActivityWebView;
import com.xiaohong.wifikulian.base.BaseFragment;
import com.xiaohong.wifikulian.utils.Utils;

/**
 * Created by Lpoint on 2017/1/26.
 */

public class FragmentMine extends BaseFragment implements View.OnClickListener {
    private SimpleDraweeView imgProtrait;
    private TextView txtNickname;
    private TextView txtVersion;
    private TextView txtCoin;
    private LinearLayout linControl;
    private RelativeLayout relFrequentlyAskedQuestions, relGetCoin, relMessageCenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mine, container, false);
        initView(view);
        initData();
        return view;
    }

    private void initView(View view) {
        imgProtrait = (SimpleDraweeView) view.findViewById(R.id.img_portrait);
        txtNickname = (TextView) view.findViewById(R.id.txt_nickname);
        txtVersion = (TextView) view.findViewById(R.id.txt_version);
        linControl = (LinearLayout) view.findViewById(R.id.lin_control);
        txtCoin = (TextView) linControl.findViewById(R.id.txt_coin);
        relGetCoin = (RelativeLayout) linControl.findViewById(R.id.rel_get_coin);
        relFrequentlyAskedQuestions = (RelativeLayout) view.findViewById(R.id.rel_frequently_asked_questions);
        relMessageCenter = (RelativeLayout) view.findViewById(R.id.rel_message_center);
    }

    private void initData() {
        imgProtrait.setImageURI(Variable.loginBean.getIcon_url());
        txtNickname.setText(Variable.loginBean.getNick_name());
        txtVersion.setText("WIFI酷连 V" + Utils.getVersion() + "build" + Utils.getVersionCode());
        txtCoin.setText(Variable.loginBean.getCoin_num() + "");
        relFrequentlyAskedQuestions.setOnClickListener(this);
        relGetCoin.setOnClickListener(this);
        relMessageCenter.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.rel_frequently_asked_questions:
                intent.setClass(getActivity(), ActivityWebView.class);
                intent.putExtra(Constants.EXTERNAL_URL, Constants.FAQ_URL);
                startActivity(intent);
                break;
            case R.id.rel_get_coin:
                sendEventModel(Constants.CODE_JUMP_TO_RECOMMEND_TASK);
                break;
            case R.id.rel_message_center:
                intent.setClass(getActivity(), ActivityMessage.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
