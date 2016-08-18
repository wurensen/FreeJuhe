package com.wurensen.freejuhe.common.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.wurensen.freejuhe.common.mvp.BasePresenter;
import com.wurensen.freejuhe.common.mvp.MVP;

/**
 * Created by wrs on 2016/8/12.
 * Activity基类，封装通用的行为
 *
 * @param <P> 具体P类型
 */
public abstract class BaseMVPActivity<P extends BasePresenter> extends AppCompatActivity
        implements MVP.View, MVPViewDelegate.BaseView<P> {

    private MVPViewDelegate<P> mBaseViewDelegate = new MVPViewDelegate<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBaseViewDelegate.onCreate(this, this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dismissLoadingDialog();
        mBaseViewDelegate.onDestroy();
    }

    public void showLoadingDialog() {
        mBaseViewDelegate.showLoadingDialog(getSupportFragmentManager());
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
