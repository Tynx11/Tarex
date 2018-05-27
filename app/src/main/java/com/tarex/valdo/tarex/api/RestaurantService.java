package com.tarex.valdo.tarex.api;

import com.tarex.valdo.tarex.forms.LoginForm;
import com.tarex.valdo.tarex.model.restaurant.RestaurantResponse;
import com.tarex.valdo.tarex.model.user.UserResponse;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RestaurantService {

    @GET("restaurant")
    Single<RestaurantResponse> restaurantList();

//    @GET("")
//    Observable<RestaurantResponse> restaurant(@Body );



}
