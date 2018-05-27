package com.tarex.valdo.tarex.model.restaurant;

import com.google.gson.annotations.SerializedName;
import com.tarex.valdo.tarex.model.general.ListItem;

import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class RestaurantResponse extends RealmObject {

    @SerializedName("restaurants")
    private RealmList<Restaurant> restaurant;

    public RealmList<Restaurant> getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(RealmList<Restaurant> restaurant) {
        this.restaurant = restaurant;
    }
}
