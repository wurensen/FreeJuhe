package com.wurensen.freejuhe.common.mvp;

/**
 * Created by wrs on 2016/8/12.
 * MVP抽象的P类，定义通用的方法
 */
public abstract class BasePresenter<T extends MVP.View> implements MVP.Presenter {

    /**
     * V层
     */
    protected T mMvpView;

    /**
     * 将V层与P层进行绑定
     * @param mvpView V层对象
     */
    public void attachView(T mvpView) {
        mMvpView = mvpView;
    }

    /**
     * 将V层与P层进行解绑
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

    /**
     * 判断是否还关联着V层，调用{@link #getMvpView()}前请先调用该方法检查V层对象是否还存在
     * @return 是否关联
     * @see #attachView(MVP.View) 
     */
    public boolean isMvpViewAttached() {
        return mMvpView != null;
    }

}
