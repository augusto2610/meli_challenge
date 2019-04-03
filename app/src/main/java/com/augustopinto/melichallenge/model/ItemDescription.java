package com.augustopinto.melichallenge.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ItemDescription implements Serializable {

    @SerializedName("plain_text")
    public String mPlainText;

    @SerializedName("text")
    public String mText;

    public ItemDescription(String plainText, String text) {
        mPlainText = plainText;
        mText = text;
    }

    public String getPlainText() {
        return mPlainText;
    }

    public void setPlainText(String plainText) {
        this.mPlainText = plainText;
    }

    public String getText() {
        return mText;
    }

    public void setText(String text) {
        this.mText = text;
    }
}
