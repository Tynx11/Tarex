package com.tarex.valdo.tarex.repository;


import android.support.annotation.MainThread;
import android.support.annotation.NonNull;

import com.tarex.valdo.tarex.repository.restaurant.RestaurantRepository;
import com.tarex.valdo.tarex.repository.restaurant.RestaurantRepositoryImpl;

public class RepositoryProvider {

    private static RestaurantRepository restaurantRepository;

    @NonNull
    public static RestaurantRepository provideRestaurantRepository() {
        if(restaurantRepository == null) {
            restaurantRepository = new RestaurantRepositoryImpl();
        }
        return restaurantRepository;
    }

    @MainThread
    public static void init() {
        restaurantRepository = new RestaurantRepositoryImpl();
    }

    public static void setRestaurantRepository (RestaurantRepository restaurantRepository) {
        RepositoryProvider.restaurantRepository = restaurantRepository;
    }
}
