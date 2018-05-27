package com.tarex.valdo.tarex.ui.user;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.tarex.valdo.tarex.api.ApiFactory;
import com.tarex.valdo.tarex.forms.LoginForm;
import com.tarex.valdo.tarex.model.user.UserResponse;
import com.tarex.valdo.tarex.model.user.tokenDto.TokenDto;
import com.tarex.valdo.tarex.utils.RxUtils;
import com.tarex.valdo.tarex.utils.prefs.AppPreferencesHelper;

import io.reactivex.Single;

@InjectViewState
public class UserPresenter extends MvpPresenter<UserView> {

    @Override
    public void onFirstViewAttach() {
        super.onFirstViewAttach();
    }

    @SuppressLint("CheckResult")
    public void user(String login, String pass) {
        LoginForm loginForm = new LoginForm(login, pass);
        ApiFactory.getUserService()
                .user(loginForm)
                .compose(RxUtils.async())
                .subscribe(userResponse -> {
                    String token =  userResponse.getTokenDto().getValue();
                    Log.d("PRESENTER", "token: " + token);
                    getViewState().setAccessToken(token);
                }, error-> getViewState().handleError(error));
    }

    public void createSharedPreferences (Context context,String token) {
        String nameSharedPreferences = "shPref";
        AppPreferencesHelper appPreferencesHelper =
                new AppPreferencesHelper(context,nameSharedPreferences);
        if (token != null)
        appPreferencesHelper.setAccessToken(token);
        getViewState().getSpToken(appPreferencesHelper.getAccessToken());

    }

    public String getAccesToken (Context context,String namePrefs) {
    AppPreferencesHelper appPreferencesHelper = new AppPreferencesHelper(context,namePrefs);
    return appPreferencesHelper.getAccessToken();
    }

}
