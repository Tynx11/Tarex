package com.tarex.valdo.tarex.ui.restaurantList;

import android.support.annotation.NonNull;
import android.view.ViewGroup;

import com.tarex.valdo.tarex.model.restaurant.Restaurant;
import com.tarex.valdo.tarex.ui.base.BaseAdapter;

import java.util.List;

public class RestaurantAdapter extends BaseAdapter<Restaurant,RestaurantItemHolder> {

    public RestaurantAdapter(@NonNull List<Restaurant> items) {
        super(items);
    }

    @Override
    public RestaurantItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return RestaurantItemHolder.create(parent.getContext());
    }

    @Override
    public void onBindViewHolder(RestaurantItemHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        Restaurant item = getItem(position);
        holder.bind(item);
    }
}

