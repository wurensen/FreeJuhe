package com.wurensen.freejuhe.common.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;

import com.wurensen.freejuhe.common.dialog.CustomProgressDialog;
import com.wurensen.freejuhe.common.mvp.BasePresenter;
import com.wurensen.freejuhe.common.utils.DialogUtil;

import butterknife.ButterKnife;

/**
 * Created by wrs on 2016/8/17.
 * 基础视图代理类，基础视图，如Activity、Fragment
 */
public class BaseViewDelegate {

    /**
     * 定义基础视图行为
     * @param <P>
     */
    interface BaseView<P extends BasePresenter> {
        /**
         * 获取布局界面id
         *
         * @return layoutId
         */
        int getContentViewLayoutId();

        /**
         * 创建P层对象
         *
         * @return P
         */
        P createPresenter();

        /**
         * 初始化数据，call in {@link Activity#onCreate(Bundle)}
         * or {@link android.support.v4.app.Fragment#onActivityCreated(Bundle)}，after{@link #createPresenter()}
         */
        void initData();
    }

    /**
     * loading对话框
     */
    private CustomProgressDialog mLoadingDialog;


    protected void onCreate(Activity activity, @Nullable Bundle savedInstanceState, BaseView baseView) {
        activity.setContentView(baseView.getContentViewLayoutId());
        ButterKnife.bind(activity);
        baseView.createPresenter();
        baseView.initData();
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

}
