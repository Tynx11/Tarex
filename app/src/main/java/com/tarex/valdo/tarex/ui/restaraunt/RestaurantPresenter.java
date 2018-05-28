package com.tarex.valdo.tarex.ui.restaraunt;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.tarex.valdo.tarex.repository.RepositoryProvider;

@InjectViewState
public class RestaurantPresenter extends MvpPresenter<RestaurantView> {

    @Override
    public void onFirstViewAttach() {
        super.onFirstViewAttach();
        getViewState().getRestaurantId();

    }

    public void init(Long id) {
        RepositoryProvider.provideRestaurantRepository()
                .restaurant(id)
                .subscribe(restaurant -> {
                    getViewState().setName(restaurant);
                    getViewState().setDescription(restaurant);
                    getViewState().setImage(restaurant);
                    getViewState().setPlace(restaurant);
                   // getViewState().setFutures(restaurant);
                    //getViewState().setRestaurantMenu(restaurant);
                    //getViewState().set
                });
    }

}
