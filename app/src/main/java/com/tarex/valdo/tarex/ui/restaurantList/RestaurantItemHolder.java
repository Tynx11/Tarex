package com.tarex.valdo.tarex.ui.restaurantList;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.tarex.valdo.tarex.R;
import com.tarex.valdo.tarex.model.restaurant.Restaurant;

public class RestaurantItemHolder extends RecyclerView.ViewHolder {
    private TextView restName;
    private TextView shortDesrciption;

    @NonNull
    public static RestaurantItemHolder create(@NonNull Context context) {
        View view = View.inflate(context, R.layout.item_restaraunt, null);
        RestaurantItemHolder holder = new RestaurantItemHolder(view);
        return holder;
    }

    public  RestaurantItemHolder (View itemView) {
        super(itemView);
        restName = itemView.findViewById(R.id.tv_name);
        shortDesrciption = itemView.findViewById(R.id.tv_description);
    }

    public void bind(@NonNull Restaurant item) {
    restName.setText(item.getName());
    shortDesrciption.setText(item.getDescription());
    }
}
