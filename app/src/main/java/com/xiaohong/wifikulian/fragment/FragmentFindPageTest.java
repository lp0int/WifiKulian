package com.xiaohong.wifikulian.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xiaohong.wifikulian.R;
import com.xiaohong.wifikulian.base.BaseFragment;
import com.xiaohong.wifikulian.utils.DialogUtils;

/**
 * Created by Lpoint on 2017/2/6 10:54.
 */

public class FragmentFindPageTest extends BaseFragment {
    public static final String ARGS_PAGE = "args_page";
    private int mPage;

    public static FragmentFindPageTest newInstance(int page) {
        Bundle args = new Bundle();

        args.putInt(ARGS_PAGE, page);
        FragmentFindPageTest fragment = new FragmentFindPageTest();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARGS_PAGE);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_find_pagetest,container,false);
        TextView textView = (TextView) view.findViewById(R.id.textView);
        textView.setText("第"+mPage+"页");
        return view;
    }
}
