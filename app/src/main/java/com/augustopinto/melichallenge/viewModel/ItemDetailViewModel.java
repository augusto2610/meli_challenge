package com.augustopinto.melichallenge.viewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.augustopinto.melichallenge.model.ItemData;
import com.augustopinto.melichallenge.model.ItemDescription;
import com.augustopinto.melichallenge.repository.SearchRepository;
import com.augustopinto.melichallenge.util.MutableLiveResource;

public class ItemDetailViewModel extends AndroidViewModel {

    public ItemDetailViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveResource<ItemData> getItemDetails(String id) {
        return SearchRepository.getInstance().getItemDetails(id);
    }

    public MutableLiveResource<ItemDescription> getItemDescription(String id) {
        return SearchRepository.getInstance().getItemDescription(id);
    }
}
