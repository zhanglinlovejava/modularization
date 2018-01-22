package com.zhanglin.basiccomponent.base.api;


import com.zhanglin.basiccomponent.utils.Logger;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by zhanglin on 2018/1/16.
 */

public class ApiService {
    private Retrofit retrofit;
    private OkHttpClient okHttpClient;

    public static class APIServiceHolder {
        public static ApiService instance = new ApiService();
    }

    public static ApiService getInstance() {
        return APIServiceHolder.instance;
    }

    public OkHttpClient provideOkHttpClient() {

        if (okHttpClient == null) {

            OkHttpClient.Builder okHttpBuilder = new OkHttpClient.Builder();
            okHttpBuilder.connectTimeout(30, TimeUnit.SECONDS); // 设置连接超时时间
            okHttpBuilder.addInterceptor(new Interceptor() {
                @Override
                public okhttp3.Response intercept(Chain chain) throws IOException {
                    Request original = chain.request();
                    String url = original.url().url().toString();
                    Request.Builder newReuestBuilder = original.newBuilder();
                    newReuestBuilder.method(original.method(), original.body());
                    newReuestBuilder.url(url);
                    Logger.e("请求地址：--  " + url);

//                if (!TextUtils.isEmpty(userStorage.getToken())) {
//                    newReuestBuilder.addHeader("Authorization", "Bearer " + userStorage.getToken());
//                    if (userStorage.isTokenExpires()) {
//                        Logger.e("token 过期了");
//                    }
//                }
                    newReuestBuilder.addHeader("Content-Type", "application/x-www-form-urlencoded");
                    return chain.proceed(newReuestBuilder.build());
                }
            });
//        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            okHttpBuilder.addInterceptor(logging);
//        }
            okHttpClient = okHttpBuilder.build();
        }

        return okHttpClient;
    }

    public Retrofit provideRetrofit() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .client(provideOkHttpClient())
                    .baseUrl("http://www.baidu.com")// TODO: 2017/7/25
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(AsyncRxJavaCallAdapterFactory.create())
                    .build();
        }
        return retrofit;
    }

}
