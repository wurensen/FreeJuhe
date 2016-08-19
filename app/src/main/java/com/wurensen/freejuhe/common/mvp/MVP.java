package com.wurensen.freejuhe.common.mvp;

import android.support.annotation.NonNull;

/**
 * Created by wrs on 2016/8/12.
 * 定义MVP模式的基本结构
 */
public interface MVP {

    /**
     * V层接口
     */
    interface View {
    }

    /**
     * P层接口
     */
    interface Presenter<V extends View> {

        /**
         * 将V层与P层进行绑定
         *
         * @param mvpView V层对象
         */
        void attachView(@NonNull V mvpView);

        /**
         * 将V层与P层进行解绑
         */
        void detachView();
    }

}
