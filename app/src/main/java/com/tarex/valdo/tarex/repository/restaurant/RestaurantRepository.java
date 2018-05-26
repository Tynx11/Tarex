package com.tarex.valdo.tarex.repository.restaurant;

import android.support.annotation.NonNull;

import com.tarex.valdo.tarex.model.restaurant.Restaurant;
import com.tarex.valdo.tarex.model.restaurant.RestaurantResponse;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;

public interface RestaurantRepository {

    @NonNull
    Single<List<Restaurant>> restaurantList();

    Single<Restaurant> restaurant ();
}
