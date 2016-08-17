package com.wurensen.freejuhe.common.net;

import com.orhanobut.logger.Logger;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by wrs on 2016/8/17.
 * 请求日志拦截器
 */
public class HttpLoggingInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Logger.i(request.toString());
        Response response = chain.proceed(request);
        Logger.json(request.toString());
        return response;
    }
}
