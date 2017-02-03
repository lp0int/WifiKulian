package com.xiaohong.wifikulian.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.xiaohong.wifikulian.Constants;
import com.xiaohong.wifikulian.R;
import com.xiaohong.wifikulian.base.BaseActivity;
import com.xiaohong.wifikulian.utils.Utils;

/**
 * Created by Lpoint on 2017/1/20 10:53.
 */

public class ActivityForgetPwd extends BaseActivity implements View.OnClickListener{

    private TextView txtTitle;

    private EditText edtUserName, edtPassword, edtConfirmPassword, edtVerifyCode;
    private Button btnGetVerifyCode,btnResetPassword;

    @SuppressLint("InlinedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.hideActiconBar(this);
        setContentView(R.layout.activity_forget_pwd);
        initView();
        initData();
    }

    private void initView() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        txtTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        txtTitle.setText("忘记密码");

        edtUserName = (EditText)findViewById(R.id.edt_username);
        edtPassword = (EditText) findViewById(R.id.edt_password);
        edtConfirmPassword = (EditText) findViewById(R.id.edt_confirm_password);
        edtVerifyCode = (EditText) findViewById(R.id.edt_verify_code);
        btnResetPassword = (Button) findViewById(R.id.btn_reset_pwd);
        btnResetPassword.setOnClickListener(this);
        btnGetVerifyCode = (Button) findViewById(R.id.btn_verify_code);
        btnGetVerifyCode.setOnClickListener(this);
        edtUserName.addTextChangedListener(textWatcher);
        edtPassword.addTextChangedListener(textWatcher);
        edtConfirmPassword.addTextChangedListener(textWatcher);
        edtVerifyCode.addTextChangedListener(textWatcher);
    }

    private void initData(){
        if(!TextUtils.isEmpty(getIntent().getStringExtra(Constants.LOGIN_USERNAME))) {
            edtUserName.setText(getIntent().getStringExtra(Constants.LOGIN_USERNAME));
            edtPassword.requestFocus();
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            this.finish();
            overridePendingTransition(R.anim.x_0_2_0, R.anim.x_0_2_minus100);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_reset_pwd:
                if(!edtPassword.getText().toString().equals(edtConfirmPassword.getText().toString()))
                    Utils.showToastStr(ActivityForgetPwd.this,Constants.PASSWORD_UNLIKELINESS);
                break;
            case R.id.btn_verify_code:
                if(!Utils.isChinaPhoneLegal(edtUserName.getText().toString())){
                    Utils.showToastStr(ActivityForgetPwd.this,Constants.PHONENUMBER_WRONGFUL);
                    break;
                }
                break;
            default:
                break;
        }
    }

    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            if(TextUtils.isEmpty(edtUserName.getText()))
                btnGetVerifyCode.setEnabled(false);
            else
                btnGetVerifyCode.setEnabled(true);

            if(TextUtils.isEmpty(edtPassword.getText()) || TextUtils.isEmpty(edtConfirmPassword.getText()) || TextUtils.isEmpty(edtVerifyCode.getText()) || TextUtils.isEmpty(edtUserName.getText()))
                btnResetPassword.setEnabled(false);
            else
                btnResetPassword.setEnabled(true);
        }
    };
}
