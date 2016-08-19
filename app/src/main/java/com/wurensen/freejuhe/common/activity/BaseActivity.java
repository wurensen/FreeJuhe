package com.wurensen.freejuhe.common.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by wrs on 2016/8/12.
 * Activity基类，封装通用的行为
 */
public abstract class BaseActivity extends AppCompatActivity implements ViewInitFlow {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(onGetContentViewLayoutId());
        ButterKnife.bind(this);
        onAfterInitView();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
