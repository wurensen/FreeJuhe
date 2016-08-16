package com.wurensen.freejuhe.common.mvp;

/**
 * Created by wrs on 2016/8/12.
 * MVP抽象的P类，定义通用的方法
 */
public abstract class BasePresenter<V extends MVP.View> implements MVP.Presenter<V> {

    /**
     * V层
     */
    protected V mMvpView;


    @Override
    public void attachView(V mvpView) {
        mMvpView = mvpView;
    }

    @Override
    public void detachView() {
        mMvpView = null;
    }

    /**
     * 获取V视图
     *
     * @return T
     */
    public V getMvpView() {
        return mMvpView;
    }

    /**
     * 判断是否还关联着V层，调用{@link #getMvpView()}前请先调用该方法检查V层对象是否还存在
     *
     * @return 是否关联
     * @see #attachView(MVP.View)
     */
    public boolean isMvpViewAttached() {
        return mMvpView != null;
    }

}
