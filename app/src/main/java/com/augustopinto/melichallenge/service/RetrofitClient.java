package com.augustopinto.melichallenge.service;

import com.augustopinto.melichallenge.BuildConfig;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static Retrofit mRetrofit;

    public static Retrofit getRetrofitInstance() {
        if (mRetrofit == null) {

            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.addInterceptor(interceptor);

            mRetrofit = new Retrofit.Builder().baseUrl(BuildConfig.BASE_URL).
                    client(builder.build()).
                    addConverterFactory(GsonConverterFactory.create()).build();
        }
        return mRetrofit;
    }

}
