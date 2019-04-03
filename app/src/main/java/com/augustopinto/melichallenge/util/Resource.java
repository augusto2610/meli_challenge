package com.augustopinto.melichallenge.util;

public class Resource<T> {

    public enum Status {
        SUCCESS, ERROR, LOADING
    }

    private Status mStatus;

    private T mData;

    private Exception mException;

    public Resource success(T data) {
        mStatus = Status.SUCCESS;
        mData = data;
        mException = null;
        return this;
    }

    public Resource error(Exception exception) {
        mStatus = Status.ERROR;
        mData = null;
        mException = exception;
        return this;
    }

    public Resource loading() {
        mStatus = Status.LOADING;
        mData = null;
        mException = null;
        return this;
    }

    public Status getStatus() {
        return mStatus;
    }

    public T getData() {
        return mData;
    }

    public Exception getException() {
        return mException;
    }
}
