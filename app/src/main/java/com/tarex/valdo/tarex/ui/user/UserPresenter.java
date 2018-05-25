package com.tarex.valdo.tarex.ui.user;

import android.content.Context;
import android.util.Log;

import com.arellomobile.mvp.MvpPresenter;
import com.tarex.valdo.tarex.api.ApiFactory;
import com.tarex.valdo.tarex.forms.LoginForm;
import com.tarex.valdo.tarex.model.user.UserResponse;
import com.tarex.valdo.tarex.model.user.tokenDto.TokenDto;
import com.tarex.valdo.tarex.utils.RxUtils;

import io.reactivex.Single;

public class UserPresenter extends MvpPresenter<UserView> {

    @Override
    public void onFirstViewAttach() {
        super.onFirstViewAttach();

    }

        public void user(LoginForm loginForm) {
              ApiFactory.getUserService()
                    .user(loginForm)
                    .compose(RxUtils.async())
                    .subscribe(userResponse -> {
                        Log.d("PRESENTER", "token: "+ userResponse.getTokenDto().getValue());
                        getViewState().setAccessToken(userResponse.getTokenDto());

                    });
        }




}
