package com.wurensen.freejuhe.common.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wurensen.freejuhe.common.mvp.BasePresenter;
import com.wurensen.freejuhe.common.mvp.MVP;

/**
 * Created by wrs on 2016/8/12.
 * Fragment基类，封装通用的行为
 *
 * @param <P> 具体P类型
 */
public abstract class BaseMVPFragment<P extends BasePresenter> extends Fragment
        implements MVP.View, MVPViewDelegate.BaseView<P> {

    private MVPViewDelegate<P> mBaseViewDelegate = new MVPViewDelegate<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return mBaseViewDelegate.onCreateView(inflater, container, this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mBaseViewDelegate.onDestroy();
    }

    public void showLoadingDialog() {
        mBaseViewDelegate.showLoadingDialog(getChildFragmentManager());
    }

    public void dismissLoadingDialog() {
        mBaseViewDelegate.dismissLoadingDialog();
    }

    /**
     * 获取{@link MVPViewDelegate.BaseView#onCreatePresenter()}创建的P实例
     *
     * @return P P层实例
     */
    protected P getPresenter() {
        return mBaseViewDelegate.getPresenter();
    }
}
