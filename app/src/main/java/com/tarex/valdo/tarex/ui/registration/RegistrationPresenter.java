package com.tarex.valdo.tarex.ui.registration;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.tarex.valdo.tarex.api.ApiFactory;
import com.tarex.valdo.tarex.forms.LoginForm;
import com.tarex.valdo.tarex.forms.RegistrationForm;
import com.tarex.valdo.tarex.utils.RxUtils;
import com.tarex.valdo.tarex.utils.prefs.AppPreferencesHelper;

@InjectViewState
public class RegistrationPresenter extends MvpPresenter<RegistrationView> {

    @Override
    public void onFirstViewAttach() {
        super.onFirstViewAttach();
    }

    @SuppressLint("CheckResult")
    public void registraion(String login, String pass,String name, String surname,String phone) {
        RegistrationForm registrationForm = new RegistrationForm(login, pass, name,surname,phone);
        ApiFactory.getUserService()
                .registration(registrationForm)
                .compose(RxUtils.async())
                .subscribe(userResponse -> {
                    String token =  userResponse.getTokenDto().getValue();
                    Log.d("PRESENTER", "token: " + token);
                    getViewState().setAccessToken(token);
                }, error-> getViewState().handleError(error));
    }

    public void createSharedPreferences (Context context, String token) {
        String nameSharedPreferences = "shPref";
        AppPreferencesHelper appPreferencesHelper =
                new AppPreferencesHelper(context,nameSharedPreferences);
        if (token != null)
            appPreferencesHelper.setAccessToken(token);
        getViewState().getSpToken(appPreferencesHelper.getAccessToken());

    }
}
