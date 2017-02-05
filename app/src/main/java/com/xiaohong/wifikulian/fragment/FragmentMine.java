package com.xiaohong.wifikulian.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaohong.wifikulian.R;
import com.xiaohong.wifikulian.Variable;
import com.xiaohong.wifikulian.base.BaseFragment;
import com.xiaohong.wifikulian.utils.Utils;

import org.w3c.dom.Text;

/**
 * Created by Lpoint on 2017/1/26.
 */

public class FragmentMine extends BaseFragment {
    private SimpleDraweeView imgProtrait;
    private TextView txtNickname;
    private TextView txtVersion;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mine, container, false);
        initView(view);
        initData();
        return view;
    }

    private void initView(View view){
        imgProtrait = (SimpleDraweeView)view.findViewById(R.id.img_portrait);
        txtNickname = (TextView) view.findViewById(R.id.txt_nickname);
        txtVersion = (TextView) view.findViewById(R.id.txt_version);
    }

    private void initData(){
        imgProtrait.setImageURI(Variable.loginBean.getIcon_url());
        txtNickname.setText(Variable.loginBean.getNick_name());
        txtVersion.setText("WIFI酷连 V" + Utils.getVersion() + "build" + Utils.getVersionCode());
    }
}
