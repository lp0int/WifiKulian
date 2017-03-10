package com.xiaohong.wifikulian.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.Html;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.xiaohong.wifikulian.Constants;
import com.xiaohong.wifikulian.Interface.SubscriberOnNextListener;
import com.xiaohong.wifikulian.R;
import com.xiaohong.wifikulian.Variable;
import com.xiaohong.wifikulian.base.BaseActivity;
import com.xiaohong.wifikulian.models.LoginBean;
import com.xiaohong.wifikulian.utils.NetworkRequestMethods1;
import com.xiaohong.wifikulian.utils.ProgressSubscriber;
import com.xiaohong.wifikulian.utils.Util;

public class ActivityLogin extends BaseActivity implements View.OnClickListener {
    private TextView txtPwdUpdate;
    private EditText edtUserName;
    private EditText edtPwd;
    private TextView txtNewUser;
    private TextView txtForgetPwd;
    private Button btnLogin;

    private SubscriberOnNextListener LoginListener;

    @SuppressLint("InlinedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Util.hideActiconBar(this);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView() {
        txtForgetPwd = (TextView) findViewById(R.id.txt_forget_pwd);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        txtPwdUpdate = (TextView) findViewById(R.id.txt_pwd_update);
        txtNewUser = (TextView) findViewById(R.id.txt_new_user);
        btnLogin = (Button) findViewById(R.id.btn_login);
        edtPwd = (EditText) findViewById(R.id.edt_pwd);
        edtPwd.addTextChangedListener(watcher);
        edtUserName = (EditText) findViewById(R.id.edt_username);
        edtUserName.addTextChangedListener(watcher);
        String exchange = getResources().getString(R.string.login_pwd_update);
        txtPwdUpdate.setText(Html.fromHtml(exchange));
        txtForgetPwd.setOnClickListener(this);
        txtNewUser.setOnClickListener(this);
        btnLogin.setOnClickListener(this);
        initRequestListenter();
        if (Constants.GOD_MODE) {
            edtUserName.setText("15105609453");
            edtPwd.setText("123456");
        }
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.txt_forget_pwd:
                intent.setClass(ActivityLogin.this, ActivityForgetPwd.class);
                if (!TextUtils.isEmpty(edtUserName.getText()))
                    intent.putExtra(Constants.LOGIN_USERNAME, edtUserName.getText().toString());
                startActivity(intent);
                overridePendingTransition(R.anim.x_minus100_2_0, R.anim.x_0_2_0);
                break;
            case R.id.txt_new_user:
                intent.setClass(ActivityLogin.this, ActivityNewUser.class);
                startActivity(intent);
                overridePendingTransition(R.anim.x_100_2_0, R.anim.x_0_2_0);
                break;
            case R.id.btn_login:
                doLogin();
                break;
            default:
                break;
        }
    }

    private void initRequestListenter() {
        LoginListener = new SubscriberOnNextListener<LoginBean>() {
            @Override
            public void onNext(LoginBean loginBean) {
                if (loginBean.getRet_code() == 0) {
                    Variable.loginBean = loginBean;
                    Toast.makeText(ActivityLogin.this, "登录成功", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent();
                    intent.setClass(ActivityLogin.this, ActivityHome.class);
                    startActivity(intent);
                    finish();
                } else
                    Util.showToastStr(ActivityLogin.this, "登录失败；" + loginBean.getRet_msg());
            }
        };
    }

    private TextWatcher watcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            if (edtUserName.getText().toString().length() != 0 && edtPwd.getText().toString().length() != 0)
                btnLogin.setEnabled(true);
            else
                btnLogin.setEnabled(false);
        }
    };

    @Override
    protected void onAppBusEvent(int code, Bundle data) {
        switch (code){
            case Constants.CODE_CHANGE_PWD:
                edtUserName.setText(data.getString(Constants.RESET_PWD_USERNAME));
                edtPwd.setText(data.getString(Constants.RESET_PWD_PASSWORD));
                doLogin();
        }
    }

    private void doLogin(){
        String strUserName = edtUserName.getText().toString();
        String strPwd = edtPwd.getText().toString();
        Variable.userPhone = strUserName;
        NetworkRequestMethods1.getInstance().login(new ProgressSubscriber<LoginBean>(LoginListener, ActivityLogin.this, "努力登陆中..."), strUserName, strPwd);
    }
}
