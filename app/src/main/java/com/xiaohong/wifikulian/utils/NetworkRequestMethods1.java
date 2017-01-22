package com.xiaohong.wifikulian.utils;

import com.xiaohong.wifikulian.Interface.RequestServiceInterface;
import com.xiaohong.wifikulian.models.LoginBean;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Lpoint on 2017/1/20 14:22.
 */

public class NetworkRequestMethods1 {
    public static final String BASE_URL = "http://livew.mobdsp.com/";
    private static final int DEFAULT_TIMEOUT = 20;
    private Retrofit mRetrofit;
    private RequestServiceInterface mRequestServiceInterface;

    private NetworkRequestMethods1() {
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        httpClientBuilder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        mRetrofit = new Retrofit.Builder()
                .client(httpClientBuilder.build())
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        mRequestServiceInterface = mRetrofit.create(RequestServiceInterface.class);
    }

    //在访问NetworkRequestMethods时创建单例
    private static class SingletonHolder {
        private static final NetworkRequestMethods1 INSTANCE = new NetworkRequestMethods1();
    }

    public static NetworkRequestMethods1 getInstance() {
        return SingletonHolder.INSTANCE;
    }

    //登录
    public void login(Subscriber<LoginBean> subscriber, String userName,String pwd) {
        mRequestServiceInterface.login(userName,pwd)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);

    }
}
