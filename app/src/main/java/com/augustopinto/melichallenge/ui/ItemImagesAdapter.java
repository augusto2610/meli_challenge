package com.augustopinto.melichallenge.ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.augustopinto.melichallenge.R;
import com.augustopinto.melichallenge.model.Picture;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ItemImagesAdapter extends PagerAdapter {

    private Context mContext;
    private ArrayList<Picture> mImages;

    public ItemImagesAdapter(Context context, List<Picture> images) {
        mContext = context;
        mImages = new ArrayList<>();
        mImages.addAll(images);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View imageLayout = LayoutInflater.from(mContext).inflate(R.layout.pager_item, container, false);
        ImageView imageView = imageLayout.findViewById(R.id.itemImageView);
        Picasso.get().load(mImages.get(position).mUrl).into(imageView);

        container.addView(imageLayout, 0);

        return imageLayout;
    }

    @Override
    public int getCount() {
        return mImages.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view.equals(o);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
