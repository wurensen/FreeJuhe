package com.wurensen.freejuhe.common.net;

import com.wurensen.freejuhe.application.ApplicationDelegate;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by wrs on 2016/8/17.
 * 请求管理器
 */
public class RequestManager {

    private RequestManager() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(7676, TimeUnit.MILLISECONDS)
                .addInterceptor(new HttpLoggingInterceptor())
                .build();

        Retrofit retrofit = new Retrofit.Builder()
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


}
