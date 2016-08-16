package com.wurensen.freejuhe.home;

import com.wurensen.freejuhe.common.mvp.BasePresenter;
import com.wurensen.freejuhe.common.mvp.MVP;

/**
 * Created by wrs on 2016/8/16.
 * 主页约束
 */
public interface MainConstraint {

    interface View extends MVP.View {

    }

    abstract class Presenter extends BasePresenter<View> {

    }

    interface Model extends MVP.Model {

    }
}
