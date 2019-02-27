package com.tarex.valdo.tarex.model.restaurant;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Restaurant extends RealmObject {

    @PrimaryKey
    @SerializedName("id")
    private Long id;

    @SerializedName("@id")
    private Long id1;

    @SerializedName("name")
    private String name;

    @SerializedName("address")
     private Address address;

    @SerializedName("rating")
    private Rating rating;

    @SerializedName("description")
    private String description;

    @SerializedName("avgPrice")
    private int avgPrice;

    @SerializedName("urlPhoto")
    private String urlPhoto;

    public int getAvgPrice() {
        return avgPrice;
    }

    public String getUrlPhoto() {
        return urlPhoto;
    }

    public void setUrlPhoto(String urlPhoto) {
        this.urlPhoto = urlPhoto;
    }

    public void setAvgPrice(int avgPrice) {
        this.avgPrice = avgPrice;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId1() {
        return id1;
    }

    public void setId1(Long id1) {
        this.id1 = id1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
   }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }
}
