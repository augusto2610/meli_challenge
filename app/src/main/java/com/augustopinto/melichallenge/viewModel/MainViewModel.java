package com.augustopinto.melichallenge.viewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.augustopinto.melichallenge.model.SearchResultItem;
import com.augustopinto.melichallenge.repository.SearchRepository;
import com.augustopinto.melichallenge.util.MutableLiveResource;

import java.util.List;

public class MainViewModel extends AndroidViewModel {

    private final MutableLiveResource<List<SearchResultItem>> mSearchList;

    public MainViewModel(@NonNull Application application) {
        super(application);
        mSearchList = SearchRepository.getInstance().getSearchResult("iphone");
    }

    public MutableLiveResource<List<SearchResultItem>> getSearchList() {
        return mSearchList;
    }
}
