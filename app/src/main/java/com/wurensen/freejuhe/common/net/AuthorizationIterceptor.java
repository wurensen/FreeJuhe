package com.wurensen.freejuhe.common.net;

import com.wurensen.freejuhe.dribbble.api.DribbbleApi;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by WuRS on 2016/8/25.
 */
public class AuthorizationIterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();
        Request authorised = original.newBuilder()
                .header("Authorization", DribbbleApi.CLIENT_ACCESS_TOKEN)
                .build();
        return chain.proceed(authorised);
    }
}
