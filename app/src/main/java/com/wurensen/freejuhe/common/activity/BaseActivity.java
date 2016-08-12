package com.wurensen.freejuhe.common.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.wurensen.freejuhe.common.dialog.CustomProgressDialog;
import com.wurensen.freejuhe.common.mvp.MVP;
import com.wurensen.freejuhe.common.utils.DialogUtil;

/**
 * Created by wrs on 2016/8/12.
 * 基类，封装通用的行为
 */
public class BaseActivity extends AppCompatActivity implements MVP.View {

    /**
     * loading对话框
     */
    private CustomProgressDialog mLoadingDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

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
    }
}
