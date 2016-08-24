package com.wurensen.freejuhe.dribbble.api;

import com.wurensen.freejuhe.dribbble.model.Shots;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by WuRS on 2016/8/23.
 * Dribbble请求接口类
 */
public interface DribbbleApi {

    String CLIENT_ACCESS_TOKEN = "875e4f41f580f5d55b002d7c6a51c4111df6d6fe2311ccfe10856edf94fc9eb8";

    String BASE_URL = "https://api.dribbble.com/v1/";

    @GET("shots")
    Call<Shots> shots();

}
