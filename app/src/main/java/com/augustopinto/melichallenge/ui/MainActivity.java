package com.augustopinto.melichallenge.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.augustopinto.melichallenge.R;

public class MainActivity extends AppCompatActivity {

    private ItemAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //TODO retrieve the list.
    }

    private void initViews() {
        RecyclerView recyclerView = findViewById(R.id.itemsRecyclerView);
        mAdapter = new ItemAdapter(this, getItemClickListener());

        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(mAdapter);

    }

    private ItemAdapter.ItemClickListener getItemClickListener() {
        return new ItemAdapter.ItemClickListener() {
            @Override
            public void onItemClicked(String id) {

            }
        };
    }

}
