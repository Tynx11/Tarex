package com.tarex.valdo.tarex.ui.restaraunt;

import com.arellomobile.mvp.MvpView;
import com.tarex.valdo.tarex.model.restaurant.Restaurant;

public interface RestaurantView extends MvpView {

    void getRestaurantId ();

    void setName (Restaurant restaurant);

    void setDescription (Restaurant restaurant);

    void setImage (Restaurant restaurant);

    void setPlace (Restaurant restaurant);


}
