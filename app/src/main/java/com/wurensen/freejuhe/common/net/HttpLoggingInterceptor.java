package com.wurensen.freejuhe.common.net;

import com.orhanobut.logger.Logger;
import com.wurensen.freejuhe.BuildConfig;

import java.io.IOException;
import java.nio.charset.Charset;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okio.Buffer;
import okio.BufferedSource;

/**
 * Created by wrs on 2016/8/17.
 * 请求日志拦截器
 */
public class HttpLoggingInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        // 打印请求
        Request request = chain.request();
        Logger.i(request.toString());
        // 发起请求
        Response response = chain.proceed(request);
        // 打印应答
        Logger.i(response.toString());
        // 打印应答数据，需要拷贝
        if (BuildConfig.LOG_DEBUG) {
            BufferedSource source = response.body().source();
            source.request(Long.MAX_VALUE); // Buffer the entire body.
            Buffer buffer = source.buffer();
            Charset charset = Charset.defaultCharset();
            MediaType contentType = response.body().contentType();
            if (contentType != null) {
                charset = contentType.charset(charset);
            }
            String bodyString = buffer.clone().readString(charset);
            Logger.i(bodyString);
        }

        return response;
    }
}
