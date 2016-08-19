package com.wurensen.freejuhe.dribbble;

import android.app.Activity;
import android.content.Intent;

import com.wurensen.freejuhe.R;
import com.wurensen.freejuhe.common.activity.BaseActivity;

/**
 * Created by wrs on 2016/8/18.
 * Dribbble界面
 */
public class DribbbleActivity extends BaseActivity implements DribbbleContract.View {

    private DribbblePresenter mDribbblePresenter;

    public static void start(Activity act) {
        Intent starter = new Intent(act, DribbbleActivity.class);
        act.startActivity(starter);
    }

    @Override
    public int onGetContentViewLayoutId() {
        return R.layout.dribbble_activity;
    }

    @Override
    public void onAfterInitView() {
        mDribbblePresenter = new DribbblePresenter();
        mDribbblePresenter.attachView(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mDribbblePresenter.detachView();
    }
}
