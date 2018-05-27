package com.tarex.valdo.tarex.ui.restaurantList;

import android.support.annotation.NonNull;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.tarex.valdo.tarex.model.restaurant.Restaurant;

import java.util.List;


public interface RestaurantListView extends MvpView {

    void showItems(@NonNull List<Restaurant> items);

    @StateStrategyType(OneExecutionStateStrategy.class)
    void handleError(Throwable error);

    void showDetails(Restaurant item);
}
