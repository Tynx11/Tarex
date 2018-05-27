package com.tarex.valdo.tarex.ui.restaurantList;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.tarex.valdo.tarex.R;
import com.tarex.valdo.tarex.model.restaurant.Restaurant;
import com.tarex.valdo.tarex.utils.ImageLoaderHelper;

public class RestaurantItemHolder extends RecyclerView.ViewHolder {
    private TextView restName;
    private TextView shortDesrciption;

    private ImageView price1;
    private ImageView price2;
    private ImageView price3;
    private ImageView price4;
    private ImageView price5;

    private ImageView photoRestaraunt;


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
        price1 = itemView.findViewById(R.id.iv_rybl_1);
        price2 = itemView.findViewById(R.id.iv_rybl_2);
        price3 = itemView.findViewById(R.id.iv_rybl_3);
        price4 = itemView.findViewById(R.id.iv_rybl_4);
        price5 = itemView.findViewById(R.id.iv_rybl_5);
        photoRestaraunt = itemView.findViewById(R.id.iv_restaraunt);
    }

    public void bind(@NonNull Restaurant item) {
        restName.setText(item.getName());
        shortDesrciption.setText(item.getDescription());
        setPrice(item);
            ImageLoaderHelper.loadPicture(photoRestaraunt, item.getUrlPhoto());

    }

    private void setPrice(Restaurant item) {
        if (item.getAvgPrice() > 300 ) {
            price2.setImageResource(R.drawable.ryblyellow);
            if (item.getAvgPrice() > 600 ) {
                price3.setImageResource(R.drawable.ryblyellow);
                if (item.getAvgPrice() > 1000) {
                    price4.setImageResource(R.drawable.ryblyellow);
                    if (item.getAvgPrice() > 1500) {
                        price5.setImageResource(R.drawable.ryblyellow);
                    }
                }
            }
        }
    }
}
