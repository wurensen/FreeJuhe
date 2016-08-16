package com.wurensen.freejuhe.common.activity;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.wurensen.freejuhe.common.dialog.CustomProgressDialog;
import com.wurensen.freejuhe.common.mvp.BasePresenter;
import com.wurensen.freejuhe.common.mvp.MVP;
import com.wurensen.freejuhe.common.utils.DialogUtil;

import butterknife.ButterKnife;

/**
 * Created by wrs on 2016/8/12.
 * 基类，封装通用的行为
 */
public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements MVP.View {

    /**
     * loading对话框
     */
    private CustomProgressDialog mLoadingDialog;

    protected P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewLayoutId());
        ButterKnife.bind(this);
        createPresenter();
        initData();
    }

    /**
     * 获取布局界面id
     *
     * @return layoutId
     */
    @LayoutRes
    protected abstract int getContentViewLayoutId();

    /**
     * 创建P层对象
     *
     * @return P
     */
    protected abstract P createPresenter();

    /**
     * 初始化数据，call in {@link #onCreate(Bundle)}，after{@link #createPresenter()}
     */
    protected abstract void initData();

    @Override
    public void showLoadingDialog() {
        if (mLoadingDialog == null) {
            mLoadingDialog = new CustomProgressDialog();
        }
        // TODO: 2016/8/12 先用类名来作为tag
        String tag = this.getClass().getSimpleName();
        DialogUtil.show(getSupportFragmentManager(), mLoadingDialog, tag);
    }

    @Override
    public void dismissLoadingDialog() {
        DialogUtil.dismiss(mLoadingDialog);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dismissLoadingDialog();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }
}
