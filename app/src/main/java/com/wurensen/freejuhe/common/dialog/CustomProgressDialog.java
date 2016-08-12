package com.wurensen.freejuhe.common.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;

/**
 * Created by wrs on 2016/8/12.
 * 通用的进度对话框
 */
public class CustomProgressDialog extends AppCompatDialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // TODO: 2016/8/12 实现通用的对话框样式，不受平台版本影响
        return super.onCreateDialog(savedInstanceState);
    }
}
