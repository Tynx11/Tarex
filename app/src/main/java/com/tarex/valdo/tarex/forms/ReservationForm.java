package com.tarex.valdo.tarex.forms;

import com.google.gson.annotations.SerializedName;

public class ReservationForm {

    @SerializedName("userToken")
    String userToken;

    @SerializedName("restaurant_id")
    Long restaurantId;

    @SerializedName("time")
    String time;

    @SerializedName("day")
    String day;

    @SerializedName("countPeople")
    int countPeople;

    public ReservationForm(String userToken, Long restaurantId, String time, String day) {
        this.userToken = userToken;
        this.restaurantId = restaurantId;
        this.time = time;
        this.day = day;
        ;
    }

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public int getCountPeople() {
        return countPeople;
    }

    public void setCountPeople(int countPeople) {
        this.countPeople = countPeople;
    }
}
