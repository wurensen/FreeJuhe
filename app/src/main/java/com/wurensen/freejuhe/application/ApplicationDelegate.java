package com.wurensen.freejuhe.application;

import android.app.Application;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by wrs on 2016/8/16.
 * Application代理类，需要在Application生命周期中处理业务的代码，都在此类完成
 */
public class ApplicationDelegate {

    private Application mApplication;
    private Gson mGson;

    public static ApplicationDelegate getInstance() {
        return CustomApplication.getDelegate();
    }

    public ApplicationDelegate(Application mApplication) {
        this.mApplication = mApplication;
    }

    /**
     * @see Application#onCreate()
     */
    public void onCreate() {
        initGson();
    }

    private void initGson() {
        mGson = new GsonBuilder().create();
    }

    public Gson getGson() {
        return mGson;
    }
}
