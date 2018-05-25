package com.tarex.valdo.tarex.api;

import android.support.annotation.NonNull;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.tarex.valdo.tarex.BuildConfig;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public final class ApiFactory {

    private static OkHttpClient sClient;

    private static volatile RestaurantService restaurantService;
    private static volatile UserService userService;

    private ApiFactory () {
    }

    @NonNull
    public static RestaurantService getRestaurantService() {
        RestaurantService service = restaurantService;
        if (service == null) {
            synchronized (ApiFactory.class) {
                service = restaurantService;
                if (service == null) {
                    service = restaurantService = buildRetrofit().create(RestaurantService.class);
                }
            }
        }
        return service;
    }

    @NonNull
    public static UserService getUserService() {
        UserService service = userService;
        if (service == null) {
            synchronized (ApiFactory.class) {
                service = userService;
                if (service == null) {
                    service = userService = buildRetrofit().create(UserService.class);
                }
            }
        }
        return service;
    }

    private static Retrofit buildRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.API_ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    private static OkHttpClient buildClient(){
        return new OkHttpClient.Builder()
                //.addInterceptor(ApiKeyInterceptor.create)
                .addInterceptor(LoggingInterceptor.create())
                .addInterceptor(new StethoInterceptor())
                .build();

    }

    private static OkHttpClient getClient() {
        OkHttpClient client = sClient;
        if (client == null) {
            synchronized (ApiFactory.class) {
                client = sClient;
                if (client == null) {
                    client = sClient = buildClient();
                }
            }
        }
        return client;
    }

    public static void recreate() {
        sClient = null;
        sClient = getClient();
        userService = buildRetrofit().create(UserService.class);
    }

    public static void setUsersService(UserService userService) {
        ApiFactory.userService = userService;
    }


}
