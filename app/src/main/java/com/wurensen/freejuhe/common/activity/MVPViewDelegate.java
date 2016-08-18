package com.wurensen.freejuhe.common.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wurensen.freejuhe.common.dialog.CustomProgressDialog;
import com.wurensen.freejuhe.common.mvp.BasePresenter;
import com.wurensen.freejuhe.common.utils.DialogUtil;

import butterknife.ButterKnife;

/**
 * Created by wrs on 2016/8/17.
 * 基础视图代理类，基础视图，如Activity、Fragment
 */
public class MVPViewDelegate<P extends BasePresenter> {

    /**
     * 定义基础视图行为、加载流程
     *
     * @param <P>
     */
    protected interface BaseView<P extends BasePresenter> {
        /**
         * 获取布局界面id
         *
         * @return layoutId
         */
        int onGetContentViewLayoutId();

        /**
         * 创建P层实例
         *
         * @return P
         */
        P onCreatePresenter();

        /**
         * 初始化数据，call in {@link Activity#onCreate(Bundle)}
         * or {@link android.support.v4.app.Fragment#onCreateView(LayoutInflater, ViewGroup, Bundle)}，after{@link #onCreatePresenter()}
         */
        void onInitData();
    }

    /**
     * loading对话框
     */
    private CustomProgressDialog mLoadingDialog;

    /**
     * P实例
     */
    private P mPresenter;

    protected void onCreate(Activity activity, BaseView baseView) {
        activity.setContentView(baseView.onGetContentViewLayoutId());
        ButterKnife.bind(activity);
        afterBindView(baseView);
    }

    protected View onCreateView(LayoutInflater inflater, ViewGroup container, BaseView baseView) {
        View view = inflater.inflate(baseView.onGetContentViewLayoutId(), container, false);
        ButterKnife.bind(this, view);
        afterBindView(baseView);
        return view;
    }

    private void afterBindView(BaseView baseView) {
        mPresenter = (P) baseView.onCreatePresenter();
        baseView.onInitData();
    }


    protected void onDestroy() {
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }

    protected void showLoadingDialog(FragmentManager fragmentManager) {
        if (mLoadingDialog == null) {
            mLoadingDialog = new CustomProgressDialog();
        }
        // TODO: 2016/8/12 先用类名来作为tag
        String tag = this.getClass().getSimpleName();
        DialogUtil.show(fragmentManager, mLoadingDialog, tag);
    }

    protected void dismissLoadingDialog() {
        DialogUtil.dismiss(mLoadingDialog);
    }

    protected P getPresenter() {
        return mPresenter;
    }

}
