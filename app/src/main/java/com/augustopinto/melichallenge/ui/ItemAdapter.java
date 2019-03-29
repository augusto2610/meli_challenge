package com.augustopinto.melichallenge.ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.augustopinto.melichallenge.R;
import com.augustopinto.melichallenge.model.SearchResultItem;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    public interface ItemClickListener {
        void onItemClicked(String id);
    }

    private Context mContext;
    private ItemClickListener mItemClickListener;
    private ArrayList<SearchResultItem> mListItems;

    public ItemAdapter(Context context, ItemClickListener listener) {
        mContext = context;
        mItemClickListener = listener;
        mListItems = new ArrayList<>();
    }

    public void setList(ArrayList<SearchResultItem> list) {
        mListItems.clear();
        mListItems.addAll(list);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.list_item, parent, false);
        final ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mItemClickListener.onItemClicked(mListItems.get(viewHolder.getAdapterPosition()).id);
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        SearchResultItem item = mListItems.get(viewHolder.getAdapterPosition());
        Picasso.get().load(item.imageUrl).into(viewHolder.mProductImage);

        viewHolder.mProductPrice.setText(mContext.getString(R.string.list_item_price,
                String.valueOf(item.price)));

        viewHolder.mProductTitle.setText(item.name);
    }

    @Override
    public int getItemCount() {
        return mListItems.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView mProductImage;
        TextView mProductTitle;
        TextView mProductPrice;

        public ViewHolder(View itemView) {
            super(itemView);
            mProductImage = itemView.findViewById(R.id.productImageView);
            mProductTitle = itemView.findViewById(R.id.productTitleTextView);
            mProductPrice = itemView.findViewById(R.id.productPriceTextView);
        }
    }

}
