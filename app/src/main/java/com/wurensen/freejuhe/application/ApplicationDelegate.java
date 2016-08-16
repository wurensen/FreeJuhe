package com.wurensen.freejuhe.application;

import android.app.Application;

/**
 * Created by wrs on 2016/8/16.
 * Application代理类，需要在Application生命周期中处理业务的代码，都在此类完成
 */
public class ApplicationDelegate {

    public Application mApplication;

    public ApplicationDelegate(Application mApplication) {
        this.mApplication = mApplication;
    }

    /**
     * @see Application#onCreate()
     */
    public void onCreate() {

    }
}
