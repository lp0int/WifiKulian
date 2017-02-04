package com.xiaohong.wifikulian.Interface;

import com.xiaohong.wifikulian.models.GetVerifyCodeBean;
import com.xiaohong.wifikulian.models.LoginBean;
import com.xiaohong.wifikulian.models.ResetPasswordBean;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Lpoint on 2017/1/20 14:12.
 */

public interface RequestServiceInterface {
    @GET("cb/applogin")
    Observable<LoginBean> login(@Query("encrypt_str") String encrypt_str);

    @GET("cb/appverifycode")
    Observable<GetVerifyCodeBean> getVerifyCode(@Query("encrypt_str") String encrypt_str);

    @GET("cb/reset_passwd")
    Observable<ResetPasswordBean> resetPwd(@Query("encrypt_str") String encrypt_str);

}
