package com.augustopinto.melichallenge.ui;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.augustopinto.melichallenge.R;
import com.augustopinto.melichallenge.model.SearchResultItem;
import com.augustopinto.melichallenge.util.MutableLiveResource;
import com.augustopinto.melichallenge.util.Resource;
import com.augustopinto.melichallenge.viewModel.MainViewModel;

import java.util.List;

/**
 * This is the first screen shown in the app.
 * MainActivity shows a list with a hardcoded search.
 */
public class MainActivity extends AppCompatActivity {

    private ItemAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private ProgressBar mProgressBar;
    private TextView mErrorTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    @Override
    protected void onResume() {
        super.onResume();
        MainViewModel viewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        getResultList(viewModel);
    }

    private void initViews() {
        mProgressBar = findViewById(R.id.loadingProgressBar);
        mErrorTextView = findViewById(R.id.errorTextView);

        mRecyclerView = findViewById(R.id.itemsRecyclerView);
        mAdapter = new ItemAdapter(this, getItemClickListener());

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setHasFixedSize(true);
        DividerItemDecoration itemDecoration =
                new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        mRecyclerView.addItemDecoration(itemDecoration);

        mRecyclerView.setAdapter(mAdapter);

    }

    private void getResultList(MainViewModel viewModel) {
        viewModel.getSearchList().observe(this, new Observer<Resource<List<SearchResultItem>>>() {
            @Override
            public void onChanged(@Nullable Resource<List<SearchResultItem>> listResource) {
                switch (listResource.getStatus()) {
                    case LOADING:
                        mRecyclerView.setVisibility(View.INVISIBLE);
                        mProgressBar.setVisibility(View.VISIBLE);
                        break;

                    case SUCCESS:
                        mRecyclerView.setVisibility(View.VISIBLE);
                        mProgressBar.setVisibility(View.INVISIBLE);
                        mAdapter.setList(listResource.getData());
                        break;

                    case ERROR:
                        mProgressBar.setVisibility(View.INVISIBLE);
                        mRecyclerView.setVisibility(View.INVISIBLE);
                        mErrorTextView.setVisibility(View.VISIBLE);
                        break;
                }
            }
        });

    }

    private void goToDetails(String id) {
        Intent intent = new Intent(this, ItemDetailActivity.class);
        intent.putExtra(getString(R.string.item_id_extra), id);
        startActivity(intent);
    }

    private ItemAdapter.ItemClickListener getItemClickListener() {
        return new ItemAdapter.ItemClickListener() {
            @Override
            public void onItemClicked(String id) {
                goToDetails(id);
            }
        };
    }

}
