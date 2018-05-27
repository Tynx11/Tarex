package com.tarex.valdo.tarex.repository.restaurant;

import android.support.annotation.NonNull;

import com.tarex.valdo.tarex.api.ApiFactory;
import com.tarex.valdo.tarex.model.restaurant.Restaurant;
import com.tarex.valdo.tarex.model.restaurant.RestaurantResponse;
import com.tarex.valdo.tarex.repository.cache.ErrorReadFromCache;
import com.tarex.valdo.tarex.repository.cache.ErrorSingleReadFromCache;
import com.tarex.valdo.tarex.repository.cache.RewriteCache;
import com.tarex.valdo.tarex.utils.RxUtils;

import java.util.List;

import io.reactivex.Single;

public class RestaurantRepositoryImpl implements RestaurantRepository {


    @NonNull
    @Override
    public Single<List<Restaurant>> restaurantList() {
        return ApiFactory.getRestaurantService()
                .restaurantList()
                .map(RestaurantResponse::getRestaurants)
                .flatMap(new RewriteCache<>(Restaurant.class))
                .onErrorResumeNext(new ErrorReadFromCache<>(Restaurant.class))
                .compose(RxUtils.asyncSingle());
    }

    @Override
    public Single<Restaurant> restaurant(final Long id) {
        return ApiFactory.getRestaurantService()
                .restaurant(id)
                .map(RestaurantResponse::getRestaurants)
                .map(c -> c.get(0))
                .onErrorResumeNext(new ErrorSingleReadFromCache<>(Restaurant.class,id))
                .compose(RxUtils.asyncSingle());
    }

}
