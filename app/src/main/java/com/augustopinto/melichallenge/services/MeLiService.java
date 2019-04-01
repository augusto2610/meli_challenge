package com.augustopinto.melichallenge.services;

import android.arch.lifecycle.LiveData;

import com.augustopinto.melichallenge.model.ItemData;
import com.augustopinto.melichallenge.model.SearchResultItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MeLiService {

    @GET("/sites/MLU/search?")
    Call<LiveData<List<SearchResultItem>>> getSearchResult(@Query("q") String key);

    @GET("/items/{itemId}")
    Call<LiveData<ItemData>> getItemDetails(@Path("itemId") String itemId);
}
