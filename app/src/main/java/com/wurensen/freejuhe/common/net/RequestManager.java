package com.wurensen.freejuhe.common.net;

import com.wurensen.freejuhe.application.ApplicationDelegate;
import com.wurensen.freejuhe.dribbble.api.DribbbleApi;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by wrs on 2016/8/17.
 * 请求管理器
 */
public class RequestManager {

    private Retrofit mRetrofit;

    private RequestManager() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(7676, TimeUnit.MILLISECONDS)
                .addInterceptor(new AuthorizationIterceptor())
                .addInterceptor(new HttpLoggingInterceptor())
                .build();

        mRetrofit = new Retrofit.Builder()
                .baseUrl(DribbbleApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(ApplicationDelegate.getInstance().getGson()))
                .client(okHttpClient)
                .build();

    }

    private static final class InstanceHolder {
        private static final RequestManager INSTANCE = new RequestManager();
    }

    /**
     * 获取实例
     *
     * @return RequestManager
     */
    public static RequestManager getInstance() {
        return InstanceHolder.INSTANCE;
    }

    /**
     * 获取Retrofit实例
     *
     * @return Retrofit实例
     */
    public Retrofit getRetrofit() {
        return mRetrofit;
    }
}
