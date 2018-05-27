package com.tarex.valdo.tarex.ui.restaurantList;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.tarex.valdo.tarex.model.restaurant.Restaurant;
import com.tarex.valdo.tarex.repository.RepositoryProvider;

@InjectViewState
public class RestaurantListPresenter extends MvpPresenter<RestaurantListView> {

    @Override
    public void onFirstViewAttach() {
        super.onFirstViewAttach();
        loadRestaurant();
    }

    public void loadRestaurant() {
        RepositoryProvider.provideRestaurantRepository()
                .restaurantList()
                .subscribe(
                        getViewState()::showItems,getViewState()::handleError);
    }

    public void onItemClick(Restaurant restaurant) {
        getViewState().showDetails(restaurant);
    }

}
