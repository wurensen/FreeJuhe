package com.wurensen.freejuhe.dribbble;

import com.wurensen.freejuhe.common.mvp.MVP;

/**
 * Created by wrs on 2016/8/18.
 * 定义Dribbble界面的MVP交互行为
 */
public interface DribbbleContract {

    interface View extends MVP.View {

    }

    interface Presenter extends MVP.Presenter<View> {

    }


}
