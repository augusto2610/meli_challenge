package com.augustopinto.melichallenge.util;

import android.arch.lifecycle.MutableLiveData;

public class MutableLiveResource<T> extends MutableLiveData<Resource<T>> {

    public void postLoading() {
        postValue(new Resource<T>().loading());
    }

    public void postError(Exception exception) {
        postValue(new Resource<T>().error(exception));
    }

    public void postSuccess(T data) {
        postValue(new Resource<T>().success(data));
    }
}
