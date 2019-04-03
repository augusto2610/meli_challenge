package com.augustopinto.melichallenge;

import android.app.Application;

import timber.log.Timber;

public class Melichallenge extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }
}
