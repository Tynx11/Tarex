package com.tarex.valdo.tarex.model.restaurant;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Rating extends RealmObject {

    @PrimaryKey
    @SerializedName("id")
    private Long id;

    @SerializedName("restaurant")
    private Long restaurant;

    @SerializedName("countUserAnswers")
    private int countUserAnswers;

    @SerializedName("rating")
    private float rating;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Long restaurant) {
        this.restaurant = restaurant;
    }

    public int getCountUserAnswers() {
        return countUserAnswers;
    }

    public void setCountUserAnswers(int countUserAnswers) {
        this.countUserAnswers = countUserAnswers;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}
