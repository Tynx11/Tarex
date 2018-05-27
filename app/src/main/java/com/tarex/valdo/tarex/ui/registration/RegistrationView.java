package com.tarex.valdo.tarex.ui.registration;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

public interface RegistrationView extends MvpView {

    @StateStrategyType(OneExecutionStateStrategy.class)
    void handleError(Throwable error);

    @StateStrategyType(AddToEndSingleStrategy.class)
    void setAccessToken(String tokenDto);

    void getSpToken (String token);
}
