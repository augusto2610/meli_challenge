package com.augustopinto.melichallenge.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.augustopinto.melichallenge.model.SearchResultItem;
import com.augustopinto.melichallenge.services.MeLiService;
import com.augustopinto.melichallenge.services.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchRepository {

    private MeLiService mService;
    private static SearchRepository mInstance;

    private SearchRepository() {
        mService = RetrofitClient.getRetrofitInstance().create(MeLiService.class);
    }

    public synchronized static SearchRepository getInstance() {
        if (mInstance == null) {
            mInstance = new SearchRepository();
        }
        return mInstance;
    }

    private LiveData<List<SearchResultItem>> getSearchResult(String key) {
        final MutableLiveData<List<SearchResultItem>> data = new MutableLiveData<>();

        mService.getSearchResult("iphone").enqueue(new Callback<List<SearchResultItem>>() {
            @Override
            public void onResponse(Call<List<SearchResultItem>> call, Response<List<SearchResultItem>> response) {
                data.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<SearchResultItem>> call, Throwable t) {
                data.postValue(null);
            }
        });

        return data;
    }
}
