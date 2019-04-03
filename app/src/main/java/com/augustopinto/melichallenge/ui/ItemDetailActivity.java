package com.augustopinto.melichallenge.ui;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.augustopinto.melichallenge.R;
import com.augustopinto.melichallenge.model.ItemData;
import com.augustopinto.melichallenge.model.ItemDescription;
import com.augustopinto.melichallenge.util.Resource;
import com.augustopinto.melichallenge.viewModel.ItemDetailViewModel;

public class ItemDetailActivity extends AppCompatActivity {

    private String mItemId;
    private ProgressBar mLoadingProgressBar;
    private TextView mErrorMessageTextView;
    private ItemData mItemData;
    private ItemDescription mItemDescription;
    private ViewPager mViewPager;
    private TextView mItemTitleTextView;
    private TextView mItemPriceTextView;
    private TextView mItemDescriptionTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);
        String extraName = getString(R.string.item_id_extra);

        if (getIntent() != null && getIntent().hasExtra(extraName)) {
            mItemId = getIntent().getStringExtra(extraName);
        }

        initViews();
    }

    @Override
    protected void onResume() {
        super.onResume();
        getDetails();
    }

    private void initViews() {
        mLoadingProgressBar = findViewById(R.id.loadingProgressBar);
        mErrorMessageTextView = findViewById(R.id.errorTextView);
        mViewPager = findViewById(R.id.picturesViewPager);
        mItemTitleTextView = findViewById(R.id.titleTextView);
        mItemPriceTextView = findViewById(R.id.priceTextView);
        mItemDescriptionTextView = findViewById(R.id.descriptionTextView);
    }

    private void getDetails() {
        final ItemDetailViewModel viewModel = ViewModelProviders.of(this).get(ItemDetailViewModel.class);
        viewModel.getItemDetails(mItemId).observe(this, new Observer<Resource<ItemData>>() {
            @Override
            public void onChanged(@Nullable Resource<ItemData> itemDataResource) {
                switch (itemDataResource.getStatus()) {
                    case SUCCESS:
                        mItemData = itemDataResource.getData();
                        getDescription(viewModel);
                        break;
                    case LOADING:
                        mLoadingProgressBar.setVisibility(View.VISIBLE);
                        break;
                    case ERROR:
                        mLoadingProgressBar.setVisibility(View.INVISIBLE);
                        mErrorMessageTextView.setVisibility(View.VISIBLE);
                        break;
                }

            }
        });
    }

    private void getDescription(ItemDetailViewModel viewModel) {
        viewModel.getItemDescription(mItemId).observe(this, new Observer<Resource<ItemDescription>>() {
            @Override
            public void onChanged(@Nullable Resource<ItemDescription> itemDescriptionResource) {
                switch (itemDescriptionResource.getStatus()) {
                    case LOADING:
                        break;
                    case SUCCESS:
                        mLoadingProgressBar.setVisibility(View.INVISIBLE);
                        mItemDescription = itemDescriptionResource.getData();
                        fillItemDetails();
                        break;
                    case ERROR:
                        mLoadingProgressBar.setVisibility(View.INVISIBLE);
                        mErrorMessageTextView.setVisibility(View.VISIBLE);
                        break;
                }
            }
        });
    }

    private void fillItemDetails() {
        mItemTitleTextView.setText(mItemData.mTitle);
        mItemPriceTextView.setText(getString(R.string.list_item_price, String.valueOf(mItemData.mPrice)));
        mItemDescriptionTextView.setText(mItemDescription.mPlainText);

        mViewPager.setAdapter(new ItemImagesAdapter(this, mItemData.mPictures));
    }

}
