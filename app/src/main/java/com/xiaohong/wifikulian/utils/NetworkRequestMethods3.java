package com.xiaohong.wifikulian.utils;

import com.xiaohong.wifikulian.ApplicationInfo;
import com.xiaohong.wifikulian.Constants;
import com.xiaohong.wifikulian.Interface.RequestServiceInterface;
import com.xiaohong.wifikulian.Variable;
import com.xiaohong.wifikulian.models.AdOrdersBean;
import com.xiaohong.wifikulian.models.RecommendListBean;

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
 * Created by Lpoint on 2017/2/8 14:43.
 */

public class NetworkRequestMethods3 {
    public static final String BASE_URL = "https://kulian.exiaohong.com/";
    private static final int DEFAULT_TIMEOUT = 20;
    private Retrofit mRetrofit;
    private RequestServiceInterface mRequestServiceInterface;

    private NetworkRequestMethods3() {
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        httpClientBuilder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS).addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                Request.Builder builder1 = request.newBuilder();
                Request build = builder1.addHeader("Connection", "close").build();
                return chain.proceed(build);
            }
        });
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
        private static final NetworkRequestMethods3 INSTANCE = new NetworkRequestMethods3();
    }

    public static NetworkRequestMethods3 getInstance() {
        return NetworkRequestMethods3.SingletonHolder.INSTANCE;
    }

    public void getRecommendList(Subscriber<RecommendListBean> subscriber, String p) {
        mRequestServiceInterface.getRecommendList(p)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void getAdOrder(Subscriber<AdOrdersBean> subscriber, int adType, int adAdvertising) {
        String userPhone = Variable.userPhone;
        String PL = Constants.PLATFORM;
        int ver = Util.getVersionCode();
        String p = EncodeParameter.getAdOrder(adType, adAdvertising, userPhone, PL, ver, ApplicationInfo.channel);
        mRequestServiceInterface.getAdOrder(p)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }
}
