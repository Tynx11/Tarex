package com.tarex.valdo.tarex.ui.user;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.tarex.valdo.tarex.forms.LoginForm;
import com.tarex.valdo.tarex.model.user.User;
import com.tarex.valdo.tarex.model.user.UserResponse;
import com.tarex.valdo.tarex.model.user.tokenDto.TokenDto;

import io.reactivex.Single;

public interface UserView extends MvpView {

    @StateStrategyType(OneExecutionStateStrategy.class)
    void handleError(Throwable error);

    void setAccessToken(TokenDto tokenDto);
    void user(LoginForm loginForm);



}
