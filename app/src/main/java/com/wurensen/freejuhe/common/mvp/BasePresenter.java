package com.wurensen.freejuhe.common.mvp;

/**
 * MVP通用的Presenter类
 * Created by wrs on 2016/8/12.
 */
public class BasePresenter<T extends MVP.View> implements MVP.Presenter {

    /**
     * V层
     */
    protected T mMvpView;

    /**
     * 将V层与P层绑定
     * @param mvpView
     */
    public void attachView(T mvpView) {
        mMvpView = mvpView;
    }

    /**
     * 将V层与P层解绑
     */
    public void detachView() {
        mMvpView = null;
    }

    /**
     * 获取V视图
     * @return T
     */
    public T getMvpView() {
        return mMvpView;
    }
}
