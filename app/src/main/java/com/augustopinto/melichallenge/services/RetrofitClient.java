package com.augustopinto.melichallenge.services;

import com.augustopinto.melichallenge.BuildConfig;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static Retrofit mRetrofit;

    public static Retrofit getRetrofitInstance() {
        if (mRetrofit == null) {
            mRetrofit = new Retrofit.Builder().baseUrl(BuildConfig.BASE_URL).
                    addConverterFactory(GsonConverterFactory.create()).build();
        }
        return mRetrofit;
    }

}
