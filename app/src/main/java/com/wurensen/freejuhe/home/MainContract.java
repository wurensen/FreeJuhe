package com.wurensen.freejuhe.home;

import com.wurensen.freejuhe.common.mvp.MVP;

/**
 * Created by wrs on 2016/8/16.
 * 主页行为
 */
public interface MainContract {

    interface View extends MVP.View {

    }

    interface Presenter extends MVP.Presenter<View> {

    }

}
