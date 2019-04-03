package com.augustopinto.melichallenge.service;


import com.augustopinto.melichallenge.model.ItemData;
import com.augustopinto.melichallenge.model.ItemDescription;
import com.augustopinto.melichallenge.model.SearchResult;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MeLiService {

    @GET("/sites/MLA/search?")
    Call<SearchResult> getSearchResult(@Query("q") String key);

    @GET("/items/{itemId}")
    Call<ItemData> getItemDetails(@Path("itemId") String itemId);

    @GET("/items/{itemId}/description")
    Call <ItemDescription> getItemDescription(@Path("itemId") String itemId);
}
