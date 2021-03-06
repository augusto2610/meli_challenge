package com.augustopinto.melichallenge.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class SearchResultItem implements Serializable {

    @SerializedName("id")
    public String mId;

    @SerializedName("title")
    public String mTitle;

    @SerializedName("price")
    public double mPrice;

    @SerializedName("thumbnail")
    public String mImageUrl;

    public SearchResultItem(String id, String title, double price, String imageUrl) {
        mId = id;
        mTitle = title;
        mPrice = price;
        mImageUrl = imageUrl;
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public double getPrice() {
        return mPrice;
    }

    public void setPrice(double price) {
        mPrice = price;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        mImageUrl = imageUrl;
    }
}
