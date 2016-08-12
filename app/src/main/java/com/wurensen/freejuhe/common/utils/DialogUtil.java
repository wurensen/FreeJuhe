package com.wurensen.freejuhe.common.utils;

import android.app.Dialog;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;

/**
 * Created by wrs on 2016/8/12.
 * 对话框工具类，统一对话框的管理，防止显示或隐藏时崩溃
 */
public class DialogUtil {

    /**
     * 显示对话框
     * @param dialog Dialog
     */
    public static void show(Dialog dialog) {
        if (dialog == null) {
            return;
        }
        try {
            dialog.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 隐藏对话框
     * @param dialog Dialog
     */
    public static void dismiss(Dialog dialog) {
        if (dialog == null) {
            return;
        }
        dialog.dismiss();
    }

    /**
     * 显示对话框Fragment
     * @param fragmentManager FragmentManager
     * @param dialogFragment DialogFragment
     * @param tag tag
     */
    public static void show(FragmentManager fragmentManager, DialogFragment dialogFragment, String tag) {
        if (fragmentManager == null || dialogFragment == null) {
            return;
        }
        try {
            dialogFragment.show(fragmentManager, tag);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 隐藏对话框Fragment
     * @param dialogFragment DialogFragment
     */
    public static void dismiss(DialogFragment dialogFragment) {
        if (dialogFragment == null) {
            return;
        }
        try {
            dialogFragment.dismissAllowingStateLoss();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
