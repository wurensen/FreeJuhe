package com.wurensen.freejuhe.common.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.view.View;

/**
 * Created by wrs on 2016/8/19.
 * 定义基础视图行为、加载流程
 */
public interface ViewInitFlow {
    /**
     * 获取布局界面id
     *
     * @return layoutId
     */
    @LayoutRes
    int onGetContentViewLayoutId();

    /**
     * 用于初始化数据，call in {@link Activity#onCreate(Bundle)}
     * or {@link android.support.v4.app.Fragment#onViewCreated(View, Bundle)}
     */
    void onAfterInitView();
}
