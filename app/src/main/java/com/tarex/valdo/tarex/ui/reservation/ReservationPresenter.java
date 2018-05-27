package com.tarex.valdo.tarex.ui.reservation;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.tarex.valdo.tarex.api.ApiFactory;
import com.tarex.valdo.tarex.forms.ReservationForm;
import com.tarex.valdo.tarex.utils.RxUtils;
import com.tarex.valdo.tarex.utils.prefs.AppPreferencesHelper;

@InjectViewState
public class ReservationPresenter extends MvpPresenter<ReservationView> {
    @Override
    public void onFirstViewAttach() {
        super.onFirstViewAttach();
    }

    @SuppressLint("CheckResult")
    public void reservation(String token, Long restaurantId, String time, String day) {
        ReservationForm reservationForm = new ReservationForm(token, restaurantId, time, day);
        ApiFactory.getReservationService()
                .reservation(reservationForm)
                .compose(RxUtils.asyncSingle())
                .subscribe();
    }

    public void getSpToken(Context context) {
        String nameSharedPreferences = "shPref";
        AppPreferencesHelper appPreferencesHelper =
                new AppPreferencesHelper(context, nameSharedPreferences);
        getViewState().setToken(appPreferencesHelper.getAccessToken());


    }

    public String getAccesToken(Context context, String namePrefs) {
        AppPreferencesHelper appPreferencesHelper = new AppPreferencesHelper(context, namePrefs);
        return appPreferencesHelper.getAccessToken();
    }
}
