package com.augustopinto.melichallenge.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class ItemData implements Serializable {

    @SerializedName("id")
    public String mId;

    @SerializedName("title")
    public String mTitle;

    @SerializedName("price")
    public double mPrice;

    @SerializedName("pictures")
    public List<Picture> mPictures;

    public ItemData(String id, String title, double price, List<Picture> pictures) {
        mId = id;
        mTitle = title;
        mPrice = price;
        mPictures = pictures;
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

    public List<Picture> getPictures() {
        return mPictures;
    }

    public void setPictures(List<Picture> pictures) {
        this.mPictures = pictures;
    }
}
