package com.augustopinto.melichallenge.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Picture implements Serializable {

    @SerializedName("id")
    public String mId;

    @SerializedName("url")
    public String mUrl;

    @SerializedName("secure_url")
    public String mSecureUrl;


    public Picture(String id, String url, String secureUrl) {
        mId = id;
        mUrl = url;
        mSecureUrl = secureUrl;
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

    public String getSecureUrl() {
        return mSecureUrl;
    }

    public void setSecureUrl(String secureUrl) {
        mSecureUrl = secureUrl;
    }
}
