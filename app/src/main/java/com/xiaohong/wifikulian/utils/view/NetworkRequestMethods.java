package com.xiaohong.wifikulian.utils.view;

import com.xiaohong.wifikulian.Constants;
import com.xiaohong.wifikulian.Interface.RequestServiceInterface;
import com.xiaohong.wifikulian.models.QQReadBean;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Lpoint on 2017/3/13 16:30.
 */

public class NetworkRequestMethods {
    private static final int DEFAULT_TIMEOUT = 20;
    private Retrofit mRetrofit;
    private RequestServiceInterface mRequestServiceInterface;
    private OkHttpClient.Builder httpClientBuilder;

    private NetworkRequestMethods() {
        httpClientBuilder = new OkHttpClient.Builder();
        httpClientBuilder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS).addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                Request.Builder builder1 = request.newBuilder();
                Request build = builder1.addHeader("Connection", "close").build();
                return chain.proceed(build);
            }
        });
    }

    //在访问NetworkRequestMethods时创建单例
    private static class SingletonHolder {
        private static final NetworkRequestMethods INSTANCE = new NetworkRequestMethods();
    }

    public static NetworkRequestMethods getInstance() {
        return NetworkRequestMethods.SingletonHolder.INSTANCE;
    }

    public void getQQRead(Subscriber<QQReadBean> subscriber) {
        mRetrofit = new Retrofit.Builder()
                .client(httpClientBuilder.build())
                .baseUrl(Constants.QQREAD_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        mRequestServiceInterface = mRetrofit.create(RequestServiceInterface.class);
        mRequestServiceInterface.getQQRead(Constants.QQREAD_G_F)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }
}