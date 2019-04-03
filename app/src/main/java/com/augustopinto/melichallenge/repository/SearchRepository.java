package com.augustopinto.melichallenge.repository;

import com.augustopinto.melichallenge.model.ItemData;
import com.augustopinto.melichallenge.model.ItemDescription;
import com.augustopinto.melichallenge.model.SearchResult;
import com.augustopinto.melichallenge.model.SearchResultItem;
import com.augustopinto.melichallenge.service.MeLiService;
import com.augustopinto.melichallenge.service.RetrofitClient;
import com.augustopinto.melichallenge.util.MutableLiveResource;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

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

    public MutableLiveResource<List<SearchResultItem>> getSearchResult(String key) {
        final MutableLiveResource resource = new MutableLiveResource();
        resource.postLoading();

        mService.getSearchResult(key).enqueue(new Callback<SearchResult>() {
            @Override
            public void onResponse(Call<SearchResult> call, Response<SearchResult> response) {
                Timber.d("getSearchResult onResponse");
                if (response.isSuccessful() && response.body() != null) {
                    resource.postSuccess(response.body().mResults);
                } else {
                    resource.postError(null);
                }
            }

            @Override
            public void onFailure(Call<SearchResult> call, Throwable t) {
                Timber.e( "onFailure: %s", t.getMessage());
                resource.postError(null);
            }
        });

        return resource;
    }

    public MutableLiveResource<ItemData> getItemDetails(String id) {
        final MutableLiveResource resource = new MutableLiveResource();
        resource.postLoading();

        mService.getItemDetails(id).enqueue(new Callback<ItemData>() {
            @Override
            public void onResponse(Call<ItemData> call, Response<ItemData> response) {
                Timber.d("getItemDetails onResponse");
                if (response.isSuccessful() && response.body() != null) {
                    resource.postSuccess(response.body());
                } else {
                    resource.postError(null);
                }
            }

            @Override
            public void onFailure(Call<ItemData> call, Throwable t) {
                Timber.e("onFailure: %s", t.getMessage());
                resource.postError(null);
            }
        });
        return resource;
    }

    public MutableLiveResource<ItemDescription> getItemDescription(String id) {
        final MutableLiveResource resource = new MutableLiveResource();
        resource.postLoading();

        mService.getItemDescription(id).enqueue(new Callback<ItemDescription>() {
            @Override
            public void onResponse(Call<ItemDescription> call, Response<ItemDescription> response) {
                Timber.d("onResponse getItemDescription");
                if (response.isSuccessful() && response.body() != null) {
                    resource.postSuccess(response.body());
                } else {
                    resource.postError(null);
                }
            }

            @Override
            public void onFailure(Call<ItemDescription> call, Throwable t) {
                Timber.e("onFailure: %s", t.getMessage());
                resource.postError(null);
            }
        });

        return resource;
    }

}
