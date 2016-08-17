package com.wurensen.freejuhe.application;

import android.app.Application;

import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;
import com.squareup.leakcanary.LeakCanary;
import com.wurensen.freejuhe.BuildConfig;

/**
 * Created by wrs on 2016/8/12.
 * 自定义Application类
 */
public class CustomApplication extends Application {

    private static CustomApplication mInstance;

    // 业务代理
    private ApplicationDelegate mApplicationDelegate;

    public static ApplicationDelegate getDelegate() {
        return mInstance.mApplicationDelegate;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initDebugPlugin();

        mInstance = this;
        mApplicationDelegate = new ApplicationDelegate(this);
        mApplicationDelegate.onCreate();
    }

    /**
     * 初始化调试插件，如内存泄漏分析辅助工具等
     */
    private void initDebugPlugin() {
        // 内存泄漏
        LeakCanary.install(this);

        // 日志
        Logger.init()               // default PRETTYLOGGER or use just init()
                .logLevel(BuildConfig.LOG_DEBUG ? LogLevel.FULL : LogLevel.NONE)        // default LogLevel.FULL,
//                .methodCount(1)                 // default 2
//                .hideThreadInfo()               // default shown
//                .methodOffset(2)                // default 0
//                .logAdapter(null);              //default AndroidLogAdapter
        ;

    }
}
