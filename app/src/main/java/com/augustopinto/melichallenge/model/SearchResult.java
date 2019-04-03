package com.augustopinto.melichallenge.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class SearchResult implements Serializable {

    @SerializedName("site_id")
    public String mSiteId;

    @SerializedName("query")
    public String mQuery;

    @SerializedName("results")
    public List<SearchResultItem> mResults;

    public SearchResult(String siteId, String query, List<SearchResultItem> results) {
        mSiteId = siteId;
        mQuery = query;
        mResults = results;
    }

    public String getSiteId() {
        return mSiteId;
    }

    public void setSiteId(String siteId) {
        mSiteId = siteId;
    }

    public String getQuery() {
        return mQuery;
    }

    public void setQuery(String query) {
        mQuery = query;
    }

    public List<SearchResultItem> getResults() {
        return mResults;
    }

    public void setResults(List<SearchResultItem> results) {
        mResults = results;
    }
}
