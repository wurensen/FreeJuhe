package com.wurensen.freejuhe.dribbble.api;

import com.orhanobut.logger.Logger;
import com.wurensen.freejuhe.ApplicationTest;
import com.wurensen.freejuhe.common.net.RequestManager;
import com.wurensen.freejuhe.dribbble.model.Shots;

import retrofit2.Response;


/**
 * Created by WuRS on 2016/8/24.
 */
public class DribbbleApiTest extends ApplicationTest {

    private DribbbleApi dribbbleApi;

    public void setUp() throws Exception {
        super.setUp();
        dribbbleApi = RequestManager.getInstance().getRetrofit().create(DribbbleApi.class);
    }

    public void testShots() throws Exception {
        Response<Shots> response = dribbbleApi.shots().execute();
        if (response.body() != null) {
            Logger.i(response.body().toString());
        }
    }
}