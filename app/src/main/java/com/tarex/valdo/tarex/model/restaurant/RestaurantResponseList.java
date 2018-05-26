package com.tarex.valdo.tarex.model.restaurant;

import io.realm.RealmList;
import io.realm.RealmObject;

public class RestaurantResponseList extends RealmObject {

    private RealmList<RestaurantResponse> restaurantResponse;

    public RealmList<RestaurantResponse> getRestaurantResponse() {
        return restaurantResponse;
    }

    public void setRestaurantResponse(RealmList<RestaurantResponse> restaurantResponse) {
        this.restaurantResponse = restaurantResponse;
    }
}
